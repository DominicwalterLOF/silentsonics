package com.google.appinventor.components.runtime;

import android.util.Log;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.annotations.UsesLibraries;
import com.google.appinventor.components.annotations.UsesPermissions;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.errors.PermissionException;
import com.google.appinventor.components.runtime.util.AsynchUtil;
import com.google.appinventor.components.runtime.util.ErrorMessages;
import com.google.appinventor.components.runtime.util.FileUtil;
import com.google.appinventor.components.runtime.util.IOUtils;
import com.google.appinventor.components.runtime.util.MediaUtil;
import com.google.appinventor.components.runtime.util.QUtil;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.model.ZipParameters;

@DesignerComponent(category = ComponentCategory.STORAGE, description = "Non-visible component for storing and retrieving files. Use this component to write or read files on your device. The default behaviour is to write files to the private data directory associated with your App. The Companion is special cased to write files to /sdcard/Kodular/data to facilitate debugging. If the file path starts with a slash (/), then the file is created relative to /sdcard. For example writing a file to /myFile.txt will write the file in /sdcard/myFile.txt.", iconName = "images/file.png", nonVisible = true, version = 6)
@UsesLibraries({"zip4j.jar"})
@SimpleObject
@UsesPermissions({"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"})
public class File extends AndroidNonvisibleComponent implements Component {
    private static final int BUFFER_LENGTH = 4096;
    private static final String LOG_TAG = "FileComponent";
    private boolean legacy = false;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public File(ComponentContainer componentContainer) {
        super(componentContainer.$form());
        LegacyMode(false);
    }

    @DesignerProperty(defaultValue = "False", editorType = "boolean")
    @SimpleProperty(category = PropertyCategory.BEHAVIOR)
    public void LegacyMode(boolean z) {
        boolean z2 = z;
        this.legacy = z2;
    }

    @SimpleProperty(description = "Allows app to access files from the root of the external storage directory (legacy mode).")
    public boolean LegacyMode() {
        return this.legacy;
    }

    @SimpleFunction(description = "Saves text to a file. If the filename begins with a slash (/) the file is written to the sdcard. For example writing to /myFile.txt will write the file to /sdcard/myFile.txt. If the filename does not start with a slash, it will be written in the programs private data directory where it will not be accessible to other programs on the phone. There is a special exception for the AI Companion where these files are written to /sdcard/AppInventor/data to facilitate debugging. Note that this block will overwrite a file if it already exists.\n\nIf you want to add content to a file use the append block.")
    public void SaveFile(String str, String str2) {
        String str3 = str;
        String str4 = str2;
        if (str4.startsWith("/")) {
            FileUtil.checkExternalStorageWriteable();
        }
        Write(str4, str3, false);
    }

    @SimpleFunction(description = "Appends text to the end of a file storage, creating the file if it does not exist. See the help text under SaveFile for information about where files are written.")
    public void AppendToFile(String str, String str2) {
        String str3 = str;
        String str4 = str2;
        if (str4.startsWith("/")) {
            FileUtil.checkExternalStorageWriteable();
        }
        Write(str4, str3, true);
    }

    @SimpleFunction(description = "Reads text from a file in storage. Prefix the filename with / to read from a specific file on the SD card. for instance /myFile.txt will read the file /sdcard/myFile.txt. To read assets packaged with an application (also works for the Companion) start the filename with // (two slashes). If a filename does not start with a slash, it will be read from the applications private storage (for packaged apps) and from /sdcard/AppInventor/data for the Companion.")
    public void ReadFrom(String str) {
        PermissionResultHandler permissionResultHandler;
        final String str2 = str;
        final boolean z = this.legacy;
        new PermissionResultHandler(this) {
            final /* synthetic */ File hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;

            {
                this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = r7;
            }

            public final void HandlePermissionResponse(String str, boolean z) {
                InputStream openFile;
                Runnable runnable;
                String str2 = str;
                if (z) {
                    try {
                        if (str2.startsWith("//")) {
                            openFile = this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.form.openAsset(str2.substring(2));
                        } else {
                            String access$000 = this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.AbsoluteFileName(str2, z);
                            int d = Log.d(File.LOG_TAG, "filepath = ".concat(String.valueOf(access$000)));
                            openFile = FileUtil.openFile(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.form, access$000);
                        }
                        final InputStream inputStream = openFile;
                        new Runnable(this) {
                            private /* synthetic */ AnonymousClass1 hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;

                            {
                                this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = r6;
                            }

                            public final void run() {
                                this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.AsyncRead(inputStream, str2);
                            }
                        };
                        AsynchUtil.runAsynchronously(runnable);
                    } catch (PermissionException e) {
                        this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.form.dispatchPermissionDeniedEvent((Component) this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME, "ReadFrom", e);
                    } catch (FileNotFoundException e2) {
                        int e3 = Log.e(File.LOG_TAG, "FileNotFoundException", e2);
                        this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.form.dispatchErrorOccurredEvent(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME, "ReadFrom", ErrorMessages.ERROR_CANNOT_FIND_FILE, str2);
                    } catch (Exception e4) {
                        int e5 = Log.e(File.LOG_TAG, "IOException", e4);
                        this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.form.dispatchErrorOccurredEvent(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME, "ReadFrom", ErrorMessages.ERROR_CANNOT_FIND_FILE, str2);
                    }
                } else {
                    this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.form.dispatchPermissionDeniedEvent((Component) this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME, "ReadFrom", str2);
                }
            }
        };
        this.form.askPermission("android.permission.READ_EXTERNAL_STORAGE", permissionResultHandler);
    }

    @SimpleFunction(description = "Deletes a file from storage. Prefix the filename with / to delete a specific file in the SD card, for instance /myFile.txt. will delete the file /sdcard/myFile.txt. If the file does not begin with a /, then the file located in the programs private storage will be deleted. Starting the file with // is an error because assets files cannot be deleted.")
    public void Delete(String str) {
        PermissionResultHandler permissionResultHandler;
        final String str2 = str;
        final boolean z = this.legacy;
        new PermissionResultHandler(this) {
            private /* synthetic */ File hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;

            {
                this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = r7;
            }

            public final void HandlePermissionResponse(String str, boolean z) {
                java.io.File file;
                PermissionException permissionException;
                String str2 = str;
                if (!z) {
                    this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.form.dispatchPermissionDeniedEvent((Component) this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME, "Delete", str2);
                } else if (str2.startsWith("//")) {
                    this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.form.dispatchErrorOccurredEvent(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME, "DeleteFile", ErrorMessages.ERROR_CANNOT_DELETE_ASSET, str2);
                } else {
                    String access$000 = this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.AbsoluteFileName(str2, z);
                    if (MediaUtil.isExternalFile(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.form, str2) && this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.form.isDeniedPermission("android.permission.WRITE_EXTERNAL_STORAGE")) {
                        new PermissionException("android.permission.WRITE_EXTERNAL_STORAGE");
                        this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.form.dispatchPermissionDeniedEvent((Component) this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME, "Delete", permissionException);
                    }
                    new java.io.File(access$000);
                    boolean delete = file.delete();
                }
            }
        };
        this.form.askPermission("android.permission.WRITE_EXTERNAL_STORAGE", permissionResultHandler);
    }

    @SimpleEvent(description = "Event indicating that the contents from the file have been read.")
    public void GotText(String str) {
        boolean dispatchEvent = EventDispatcher.dispatchEvent(this, "GotText", str);
    }

    @SimpleEvent(description = "Event indicating that the contents of the file have been written.")
    public void AfterFileSaved(String str) {
        boolean dispatchEvent = EventDispatcher.dispatchEvent(this, "AfterFileSaved", str);
    }

    @SimpleFunction(description = "Move a file. You can not move asset files.")
    public boolean Move(String str, String str2) {
        return getJavaFile(str).renameTo(getJavaFile(str2));
    }

    @SimpleFunction(description = "Copy a file. If input path started with two // (slashes) then it's a asset file. You can not copy a file into the assets directory.")
    public void Copy(String str, String str2) {
        PermissionResultHandler permissionResultHandler;
        final String str3 = str;
        final boolean z = this.legacy;
        final String str4 = str2;
        new PermissionResultHandler(this) {
            private /* synthetic */ File hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;

            {
                this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = r8;
            }

            public final void HandlePermissionResponse(String str, boolean z) {
                String str2 = str;
                if (z) {
                    try {
                        if (!str3.startsWith("//")) {
                            String copyFile = FileUtil.copyFile(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.AbsoluteFileName(str3, z), this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.AbsoluteFileName(str4, z));
                        } else if (this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.form.isRepl()) {
                            String copyFile2 = FileUtil.copyFile(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.AbsoluteFileName(str3, z), this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.AbsoluteFileName(str4, z));
                        } else {
                            String writeStreamToFile = FileUtil.writeStreamToFile(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.form.getAssets().open(str3.substring(2)), this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.AbsoluteFileName(str4, z));
                        }
                    } catch (IOException e) {
                        int e2 = Log.e(File.LOG_TAG, String.valueOf(e));
                        this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.form.dispatchErrorOccurredEvent(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME, "Copy", ErrorMessages.ERROR_CANNOT_CREATE_FILE, str4);
                    }
                } else {
                    this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.form.dispatchPermissionDeniedEvent((Component) this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME, "Copy", str2);
                }
            }
        };
        this.form.askPermission("android.permission.WRITE_EXTERNAL_STORAGE", permissionResultHandler);
    }

    @SimpleFunction(description = "Check whether a file exists. If file path started with two // (slashes) then it means you would check if a asset file exists.")
    public boolean Exists(String str) {
        java.io.File file;
        StringBuilder sb;
        String str2 = str;
        if (!str2.startsWith("//")) {
            return getJavaFile(str2).exists();
        }
        String substring = str2.substring(2);
        if (this.form.isRepl()) {
            new StringBuilder();
            new java.io.File(sb.append(QUtil.getReplAssetPath(this.form)).append(substring).toString());
            return file.exists();
        }
        try {
            IOUtils.closeQuietly(LOG_TAG, this.form.getAssets().open(substring));
            return true;
        } catch (IOException e) {
            IOUtils.closeQuietly(LOG_TAG, (Closeable) null);
            return false;
        } catch (Throwable th) {
            IOUtils.closeQuietly(LOG_TAG, (Closeable) null);
            throw th;
        }
    }

    @SimpleFunction(description = "Get file size")
    public long FileSize(String str) {
        java.io.File javaFile = getJavaFile(str);
        java.io.File file = javaFile;
        if (!javaFile.exists() || !file.isFile()) {
            return -1;
        }
        return file.length();
    }

    @SimpleFunction(description = "Get total space")
    public long GetTotalSpace(String str) {
        return getJavaFile(str).getTotalSpace();
    }

    @SimpleFunction(description = "Get Free Space")
    public long GetFreeSpace(String str) {
        return getJavaFile(str).getFreeSpace();
    }

    @SimpleFunction(description = "Get file name")
    public String GetFileName(String str) {
        return getJavaFile(str).getName();
    }

    @SimpleFunction(description = "Check whether the path is a file")
    public boolean IsFile(String str) {
        java.io.File javaFile = getJavaFile(str);
        return javaFile.exists() && javaFile.isFile();
    }

    @SimpleFunction(description = "Check whether the path is a directory")
    public boolean IsDirectory(String str) {
        java.io.File javaFile = getJavaFile(str);
        return javaFile.exists() && javaFile.isDirectory();
    }

    @SimpleEvent(description = "Event indicating that the zip file have been created.")
    public void AfterZip() {
        boolean dispatchEvent = EventDispatcher.dispatchEvent(this, "AfterZip", new Object[0]);
    }

    @SimpleEvent(description = "Event indicating that the zip file have been created.")
    public void AfterUnzip() {
        boolean dispatchEvent = EventDispatcher.dispatchEvent(this, "AfterUnzip", new Object[0]);
    }

    @SimpleEvent(description = "Event indicating that there was any failure on zip or unzip a file.")
    public void OnZipFailure(String str) {
        boolean dispatchEvent = EventDispatcher.dispatchEvent(this, "OnZipFailure", str);
    }

    @SimpleFunction(description = "Create a zip file with or without a password.")
    public void Zip(String str, String str2, String str3) {
        StringBuilder sb;
        ZipParameters zipParameters;
        ZipFile zipFile;
        java.io.File file;
        String str4 = str;
        String str5 = str2;
        String str6 = str3;
        try {
            new ZipParameters();
            ZipParameters zipParameters2 = zipParameters;
            ZipParameters zipParameters3 = zipParameters2;
            zipParameters2.setCompressionMethod(8);
            zipParameters3.setCompressionLevel(5);
            if (str6.length() > 0) {
                zipParameters3.setEncryptFiles(true);
                zipParameters3.setEncryptionMethod(99);
                zipParameters3.setAesKeyStrength(3);
                zipParameters3.setPassword(str6);
            }
            new ZipFile(str5);
            ZipFile zipFile2 = zipFile;
            new java.io.File(str4);
            java.io.File file2 = file;
            java.io.File file3 = file2;
            if (file2.isFile()) {
                zipFile2.addFile(file3, zipParameters3);
            } else if (file3.isDirectory()) {
                zipFile2.addFolder(file3, zipParameters3);
            }
            AfterZip();
        } catch (Exception e) {
            Exception exc = e;
            int e2 = Log.e(LOG_TAG, String.valueOf(exc));
            new StringBuilder();
            OnZipFailure(sb.append(exc.getMessage()).toString());
        }
    }

    @SimpleFunction(description = "Unzip a file with or without a password. If you dont need a passwort then let it empty.")
    public void Unzip(String str, String str2, String str3) {
        StringBuilder sb;
        ZipFile zipFile;
        String str4 = str2;
        String str5 = str3;
        try {
            new ZipFile(str);
            ZipFile zipFile2 = zipFile;
            ZipFile zipFile3 = zipFile2;
            if (zipFile2.isEncrypted()) {
                zipFile3.setPassword(str5);
            }
            zipFile3.extractAll(str4);
            AfterUnzip();
        } catch (Exception e) {
            Exception exc = e;
            int e2 = Log.e(LOG_TAG, String.valueOf(exc));
            new StringBuilder();
            OnZipFailure(sb.append(exc.getMessage()).toString());
        }
    }

    @SimpleFunction(description = "Create a new directory.")
    public void CreateDirectory(String str) {
        PermissionResultHandler permissionResultHandler;
        final String str2 = str;
        new PermissionResultHandler(this) {
            private /* synthetic */ File hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;

            {
                this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = r6;
            }

            public final void HandlePermissionResponse(String str, boolean z) {
                java.io.File file;
                StringBuilder sb;
                String str2 = str;
                if (z) {
                    try {
                        new StringBuilder();
                        new java.io.File(sb.append(QUtil.getExternalStoragePath(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.form)).append(str2).toString());
                        java.io.File file2 = file;
                        java.io.File file3 = file2;
                        if (!file2.exists()) {
                            boolean mkdirs = file3.mkdirs();
                        }
                        this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.DirectoryCreated(true);
                    } catch (PermissionException e) {
                        this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.form.dispatchPermissionDeniedEvent((Component) this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME, "CreateDirectory", e);
                    } catch (Exception e2) {
                        this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.DirectoryCreated(false);
                    }
                } else {
                    this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.form.dispatchPermissionDeniedEvent((Component) this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME, "CreateDirectory", str2);
                }
            }
        };
        this.form.askPermission("android.permission.WRITE_EXTERNAL_STORAGE", permissionResultHandler);
    }

    @SimpleEvent(description = "Event indicating that there was a directory created. The return value is 'true' or 'false'.")
    public void DirectoryCreated(boolean z) {
        boolean dispatchEvent = EventDispatcher.dispatchEvent(this, "DirectoryCreated", Boolean.valueOf(z));
    }

    /* access modifiers changed from: private */
    public String AbsoluteFileName(String str, boolean z) {
        java.io.File filesDir;
        StringBuilder sb;
        java.io.File file;
        StringBuilder sb2;
        String str2 = str;
        boolean z2 = z;
        if (str2.startsWith("/")) {
            new StringBuilder();
            return sb2.append(QUtil.getExternalStoragePath(this.form, false, z2)).append(str2).toString();
        }
        if (this.form.isRepl()) {
            new java.io.File(QUtil.getReplDataPath(this.form, false));
            filesDir = file;
        } else {
            filesDir = this.form.getFilesDir();
        }
        if (!filesDir.exists()) {
            boolean mkdirs = filesDir.mkdirs();
        }
        new StringBuilder();
        return sb.append(filesDir.getPath()).append("/").append(str2).toString();
    }

    private void Write(String str, String str2, boolean z) {
        Runnable runnable;
        PermissionResultHandler permissionResultHandler;
        String str3 = str;
        String str4 = str2;
        boolean z2 = z;
        if (!str3.startsWith("//")) {
            final String str5 = str3;
            final boolean z3 = this.legacy;
            final boolean z4 = z2;
            final String str6 = str4;
            new Runnable(this) {
                final /* synthetic */ File hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;

                {
                    this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = r9;
                }

                /* JADX WARNING: type inference failed for: r4v27, types: [java.io.FileOutputStream] */
                /* JADX WARNING: Multi-variable type inference failed */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void run() {
                    /*
                        r13 = this;
                        r0 = r13
                        r4 = r0
                        com.google.appinventor.components.runtime.File r4 = r4.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME
                        r5 = r0
                        java.lang.String r5 = r8
                        r6 = r0
                        boolean r6 = r9
                        java.lang.String r4 = r4.AbsoluteFileName(r5, r6)
                        r1 = r4
                        r4 = r0
                        com.google.appinventor.components.runtime.File r4 = r4.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME
                        com.google.appinventor.components.runtime.Form r4 = r4.form
                        r5 = r1
                        boolean r4 = com.google.appinventor.components.runtime.util.MediaUtil.isExternalFile(r4, r5)
                        if (r4 == 0) goto L_0x0026
                        r4 = r0
                        com.google.appinventor.components.runtime.File r4 = r4.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME
                        com.google.appinventor.components.runtime.Form r4 = r4.form
                        java.lang.String r5 = "android.permission.WRITE_EXTERNAL_STORAGE"
                        r4.assertPermission(r5)
                    L_0x0026:
                        java.io.File r4 = new java.io.File
                        r12 = r4
                        r4 = r12
                        r5 = r12
                        r6 = r1
                        r5.<init>(r6)
                        r12 = r4
                        r4 = r12
                        r5 = r12
                        r2 = r5
                        boolean r4 = r4.exists()
                        if (r4 != 0) goto L_0x003e
                        r4 = r2
                        boolean r4 = r4.createNewFile()     // Catch:{ IOException -> 0x007c }
                    L_0x003e:
                        java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x00b8 }
                        r12 = r4
                        r4 = r12
                        r5 = r12
                        r6 = r2
                        r7 = r0
                        boolean r7 = r10     // Catch:{ IOException -> 0x00b8 }
                        r5.<init>(r6, r7)     // Catch:{ IOException -> 0x00b8 }
                        r2 = r4
                        java.io.OutputStreamWriter r4 = new java.io.OutputStreamWriter     // Catch:{ IOException -> 0x00b8 }
                        r12 = r4
                        r4 = r12
                        r5 = r12
                        r6 = r2
                        r5.<init>(r6)     // Catch:{ IOException -> 0x00b8 }
                        r12 = r4
                        r4 = r12
                        r5 = r12
                        r3 = r5
                        r5 = r0
                        java.lang.String r5 = r11     // Catch:{ IOException -> 0x00b8 }
                        r4.write(r5)     // Catch:{ IOException -> 0x00b8 }
                        r4 = r3
                        r4.flush()     // Catch:{ IOException -> 0x00b8 }
                        r4 = r3
                        r4.close()     // Catch:{ IOException -> 0x00b8 }
                        r4 = r2
                        r4.close()     // Catch:{ IOException -> 0x00b8 }
                        r4 = r0
                        com.google.appinventor.components.runtime.File r4 = r4.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME     // Catch:{ IOException -> 0x00b8 }
                        com.google.appinventor.components.runtime.Form r4 = r4.form     // Catch:{ IOException -> 0x00b8 }
                        com.google.appinventor.components.runtime.File$5$1 r5 = new com.google.appinventor.components.runtime.File$5$1     // Catch:{ IOException -> 0x00b8 }
                        r12 = r5
                        r5 = r12
                        r6 = r12
                        r7 = r0
                        r6.<init>(r7)     // Catch:{ IOException -> 0x00b8 }
                        r4.runOnUiThread(r5)     // Catch:{ IOException -> 0x00b8 }
                    L_0x007b:
                        return
                    L_0x007c:
                        r4 = move-exception
                        r4 = r0
                        boolean r4 = r10
                        if (r4 == 0) goto L_0x009d
                        r4 = r0
                        com.google.appinventor.components.runtime.File r4 = r4.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME
                        com.google.appinventor.components.runtime.Form r4 = r4.form
                        r5 = r0
                        com.google.appinventor.components.runtime.File r5 = r5.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME
                        java.lang.String r6 = "AppendTo"
                        r7 = 2103(0x837, float:2.947E-42)
                        r8 = 1
                        java.lang.Object[] r8 = new java.lang.Object[r8]
                        r12 = r8
                        r8 = r12
                        r9 = r12
                        r10 = 0
                        r11 = r1
                        r9[r10] = r11
                        r4.dispatchErrorOccurredEvent(r5, r6, r7, r8)
                        goto L_0x007b
                    L_0x009d:
                        r4 = r0
                        com.google.appinventor.components.runtime.File r4 = r4.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME
                        com.google.appinventor.components.runtime.Form r4 = r4.form
                        r5 = r0
                        com.google.appinventor.components.runtime.File r5 = r5.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME
                        java.lang.String r6 = "SaveFile"
                        r7 = 2103(0x837, float:2.947E-42)
                        r8 = 1
                        java.lang.Object[] r8 = new java.lang.Object[r8]
                        r12 = r8
                        r8 = r12
                        r9 = r12
                        r10 = 0
                        r11 = r1
                        r9[r10] = r11
                        r4.dispatchErrorOccurredEvent(r5, r6, r7, r8)
                        goto L_0x007b
                    L_0x00b8:
                        r4 = move-exception
                        r4 = r0
                        boolean r4 = r10
                        if (r4 == 0) goto L_0x00d9
                        r4 = r0
                        com.google.appinventor.components.runtime.File r4 = r4.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME
                        com.google.appinventor.components.runtime.Form r4 = r4.form
                        r5 = r0
                        com.google.appinventor.components.runtime.File r5 = r5.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME
                        java.lang.String r6 = "AppendTo"
                        r7 = 2104(0x838, float:2.948E-42)
                        r8 = 1
                        java.lang.Object[] r8 = new java.lang.Object[r8]
                        r12 = r8
                        r8 = r12
                        r9 = r12
                        r10 = 0
                        r11 = r1
                        r9[r10] = r11
                        r4.dispatchErrorOccurredEvent(r5, r6, r7, r8)
                        goto L_0x007b
                    L_0x00d9:
                        r4 = r0
                        com.google.appinventor.components.runtime.File r4 = r4.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME
                        com.google.appinventor.components.runtime.Form r4 = r4.form
                        r5 = r0
                        com.google.appinventor.components.runtime.File r5 = r5.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME
                        java.lang.String r6 = "SaveFile"
                        r7 = 2104(0x838, float:2.948E-42)
                        r8 = 1
                        java.lang.Object[] r8 = new java.lang.Object[r8]
                        r12 = r8
                        r8 = r12
                        r9 = r12
                        r10 = 0
                        r11 = r1
                        r9[r10] = r11
                        r4.dispatchErrorOccurredEvent(r5, r6, r7, r8)
                        goto L_0x007b
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.google.appinventor.components.runtime.File.AnonymousClass5.run():void");
                }
            };
            final Runnable runnable2 = runnable;
            final boolean z5 = z2;
            new PermissionResultHandler(this) {
                private /* synthetic */ File hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;

                {
                    this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = r7;
                }

                public final void HandlePermissionResponse(String str, boolean z) {
                    String str2 = str;
                    if (z) {
                        AsynchUtil.runAsynchronously(runnable2);
                    } else {
                        this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.form.dispatchPermissionDeniedEvent((Component) this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME, z5 ? "AppendToFile" : "SaveFile", str2);
                    }
                }
            };
            this.form.askPermission("android.permission.WRITE_EXTERNAL_STORAGE", permissionResultHandler);
        } else if (z2) {
            this.form.dispatchErrorOccurredEvent(this, "AppendTo", ErrorMessages.ERROR_CANNOT_WRITE_ASSET, str3);
        } else {
            this.form.dispatchErrorOccurredEvent(this, "SaveFile", ErrorMessages.ERROR_CANNOT_WRITE_ASSET, str3);
        }
    }

    private String normalizeNewLines(String str) {
        return str.replaceAll("\r\n", "\n");
    }

    /* access modifiers changed from: private */
    public void AsyncRead(InputStream inputStream, String str) {
        InputStreamReader inputStreamReader;
        StringWriter stringWriter;
        Runnable runnable;
        String str2 = str;
        try {
            new InputStreamReader(inputStream);
            InputStreamReader inputStreamReader2 = inputStreamReader;
            new StringWriter();
            StringWriter stringWriter2 = stringWriter;
            char[] cArr = new char[4096];
            while (true) {
                int read = inputStreamReader2.read(cArr, 0, 4096);
                int i = read;
                if (read > 0) {
                    stringWriter2.write(cArr, 0, i);
                } else {
                    final String normalizeNewLines = normalizeNewLines(stringWriter2.toString());
                    new Runnable(this) {
                        private /* synthetic */ File hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;

                        {
                            this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = r6;
                        }

                        public final void run() {
                            this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.GotText(normalizeNewLines);
                        }
                    };
                    this.form.runOnUiThread(runnable);
                    return;
                }
            }
        } catch (FileNotFoundException e) {
            int e2 = Log.e(LOG_TAG, "FileNotFoundException", e);
            this.form.dispatchErrorOccurredEvent(this, "ReadFrom", ErrorMessages.ERROR_CANNOT_FIND_FILE, str2);
        } catch (Exception e3) {
            int e4 = Log.e(LOG_TAG, "Exception", e3);
            this.form.dispatchErrorOccurredEvent(this, "ReadFrom", ErrorMessages.ERROR_CANNOT_READ_FILE, str2);
        }
    }

    private java.io.File getJavaFile(String str) {
        java.io.File file;
        new java.io.File(AbsoluteFileName(str, this.legacy));
        return file;
    }
}
