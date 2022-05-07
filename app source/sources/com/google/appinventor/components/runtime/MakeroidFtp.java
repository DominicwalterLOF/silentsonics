package com.google.appinventor.components.runtime;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
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
import com.google.appinventor.components.runtime.util.YailList;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

@DesignerComponent(category = ComponentCategory.CONNECTIVITY, description = "write in ode", iconName = "images/ftp.png", nonVisible = true, version = 2)
@UsesLibraries({"commons-net.jar"})
@SimpleObject
@UsesPermissions({"android.permission.INTERNET", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"})
public class MakeroidFtp extends AndroidNonvisibleComponent implements Component {
    /* access modifiers changed from: private */
    public String D5WW7ko68TBhY3rWGJixZsWe3BbuoJE4ehTpLkVzvzCwqdv8qeJ2dPQYU5v0Rxk = "Your Username";
    private String FlE8cJN9pJT0vK7EOYVYVCxuB0sJcG6jpZ55tqfSsTRV8K3RkDe9yvLjVOLhsxDi = "/";
    private int XBLVE91Zp5kvRRn2aG2d0scvywAN7zOQf8gZkaueK9XPU163NLSIe4vWoTpXMo6u = 21;
    private FTPClient hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;
    /* access modifiers changed from: private */
    public String l1RC65VA1OrEFGFIoMpcm9UdXKH0b4XYT6Sp5a4IfmUrLMcXzEdiTdgfLz7JJ5B0 = "";
    private String sk5rMw9RgYy71OTPvOENAp3eApfAT8tLYhxGtg9aKlffH3QIqZgsCnaQ8Le0fA = "ftp.example.org";

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MakeroidFtp(ComponentContainer componentContainer) {
        super(componentContainer.$form());
        FTPClient fTPClient;
        new FTPClient();
        this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = fTPClient;
        int d2 = Log.d("Makeroid Ftp", "Makeroid Ftp Created");
    }

    @DesignerProperty(defaultValue = "/", editorType = "string")
    @SimpleProperty(description = "Set the ftp working dir.")
    public void WorkingDirectory(String str) {
        String str2 = str;
        this.FlE8cJN9pJT0vK7EOYVYVCxuB0sJcG6jpZ55tqfSsTRV8K3RkDe9yvLjVOLhsxDi = str2;
        try {
            boolean changeWorkingDirectory = this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.changeWorkingDirectory(str2);
        } catch (Exception e) {
            int e2 = Log.e("Makeroid Ftp", String.valueOf(e));
        }
    }

    @SimpleProperty(category = PropertyCategory.APPEARANCE, description = "Returns the ftp working dir.")
    public String WorkingDirectory() {
        return this.FlE8cJN9pJT0vK7EOYVYVCxuB0sJcG6jpZ55tqfSsTRV8K3RkDe9yvLjVOLhsxDi;
    }

    @DesignerProperty(defaultValue = "ftp.example.org", editorType = "string")
    @SimpleProperty(description = "Set the ftp server url.")
    public void FtpServer(String str) {
        String str2 = str;
        this.sk5rMw9RgYy71OTPvOENAp3eApfAT8tLYhxGtg9aKlffH3QIqZgsCnaQ8Le0fA = str2;
    }

    @SimpleProperty(category = PropertyCategory.APPEARANCE, description = "Returns the ftp server url.")
    public String FtpServer() {
        return this.sk5rMw9RgYy71OTPvOENAp3eApfAT8tLYhxGtg9aKlffH3QIqZgsCnaQ8Le0fA;
    }

    @DesignerProperty(defaultValue = "21", editorType = "integer")
    @SimpleProperty(description = "Set the ftp port number.")
    public void Port(int i) {
        int i2 = i;
        this.XBLVE91Zp5kvRRn2aG2d0scvywAN7zOQf8gZkaueK9XPU163NLSIe4vWoTpXMo6u = i2;
    }

    @SimpleProperty(category = PropertyCategory.APPEARANCE, description = "Returns the ftp port number.")
    public int Port() {
        return this.XBLVE91Zp5kvRRn2aG2d0scvywAN7zOQf8gZkaueK9XPU163NLSIe4vWoTpXMo6u;
    }

    @DesignerProperty(defaultValue = "Your Username", editorType = "string")
    @SimpleProperty(description = "Set the username to login into the ftp server.")
    public void Username(String str) {
        String str2 = str;
        this.D5WW7ko68TBhY3rWGJixZsWe3BbuoJE4ehTpLkVzvzCwqdv8qeJ2dPQYU5v0Rxk = str2;
    }

    @SimpleProperty(category = PropertyCategory.APPEARANCE, description = "Returns the username.")
    public String Username() {
        return this.D5WW7ko68TBhY3rWGJixZsWe3BbuoJE4ehTpLkVzvzCwqdv8qeJ2dPQYU5v0Rxk;
    }

    @DesignerProperty(defaultValue = "", editorType = "string")
    @SimpleProperty(description = "Set the password to login into the ftp server.")
    public void Password(String str) {
        String str2 = str;
        this.l1RC65VA1OrEFGFIoMpcm9UdXKH0b4XYT6Sp5a4IfmUrLMcXzEdiTdgfLz7JJ5B0 = str2;
    }

    @SimpleProperty(category = PropertyCategory.APPEARANCE, description = "Returns the password.")
    public String Password() {
        return this.l1RC65VA1OrEFGFIoMpcm9UdXKH0b4XYT6Sp5a4IfmUrLMcXzEdiTdgfLz7JJ5B0;
    }

    @SimpleFunction(description = "Make/create a directory on the ftp server.")
    public void makeDir(String str) {
        StringBuilder sb;
        try {
            boolean makeDirectory = this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.makeDirectory(str);
        } catch (Exception e) {
            new StringBuilder("mkdiRd");
            int e2 = Log.e("Makeroid Ftp", sb.append(e.getMessage()).toString());
        }
    }

    @SimpleFunction(description = "Delete a directory on the ftp server.")
    public void deleteDir(String str) {
        StringBuilder sb;
        try {
            boolean removeDirectory = this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.removeDirectory(str);
        } catch (Exception e) {
            new StringBuilder("mkdiRd");
            int e2 = Log.e("Makeroid Ftp", sb.append(e.getMessage()).toString());
        }
    }

    @SimpleFunction(description = "Get a list of files in a directory. Returns a empty list if a error occurs.")
    public YailList GetListOfFiles(String str) {
        File file;
        ArrayList arrayList;
        String str2 = str;
        new File(str2);
        File file2 = file;
        new ArrayList();
        ArrayList arrayList2 = arrayList;
        if (!file2.exists() || !file2.isDirectory()) {
            return YailList.makeEmptyList();
        }
        try {
            FTPFile[] listFiles = this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.listFiles(str2);
            FTPFile[] fTPFileArr = listFiles;
            int length = listFiles.length;
            for (int i = 0; i < length; i++) {
                boolean add = arrayList2.add(fTPFileArr[i].getName());
            }
            return YailList.makeList(arrayList2.toArray());
        } catch (Exception e) {
            return YailList.makeEmptyList();
        }
    }

    @SimpleFunction(description = "Start the connection to the ftp server.")
    public void Connect() {
        a aVar;
        new a(this, (byte) 0);
        AsyncTask execute = aVar.execute(new Void[0]);
    }

    @SuppressLint({"StaticFieldLeak"})
    class a extends AsyncTask<Void, Void, Boolean> {
        private /* synthetic */ MakeroidFtp hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;

        /* access modifiers changed from: protected */
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            Object[] objArr2 = objArr;
            return hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME();
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ void onPostExecute(Object obj) {
            this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.ConnectionStatus(((Boolean) obj).booleanValue());
        }

        private a(MakeroidFtp makeroidFtp) {
            this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = makeroidFtp;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        /* synthetic */ a(MakeroidFtp makeroidFtp, byte b) {
            this(makeroidFtp);
            byte b2 = b;
        }

        private Boolean hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME() {
            StringBuilder sb;
            StringBuilder sb2;
            boolean z = false;
            try {
                MakeroidFtp.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME).connect(MakeroidFtp.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME), MakeroidFtp.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME));
            } catch (Exception e) {
                Exception exc = e;
                MakeroidFtp makeroidFtp = this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;
                new StringBuilder();
                makeroidFtp.ConnectError(sb2.append(exc.getMessage()).toString());
                int e2 = Log.e("Makeroid Ftp", String.valueOf(exc));
            }
            try {
                z = MakeroidFtp.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME).login(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.D5WW7ko68TBhY3rWGJixZsWe3BbuoJE4ehTpLkVzvzCwqdv8qeJ2dPQYU5v0Rxk, this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.l1RC65VA1OrEFGFIoMpcm9UdXKH0b4XYT6Sp5a4IfmUrLMcXzEdiTdgfLz7JJ5B0);
            } catch (Exception e3) {
                Exception exc2 = e3;
                int e4 = Log.e("Makeroid Ftp", String.valueOf(exc2));
                MakeroidFtp makeroidFtp2 = this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;
                new StringBuilder();
                makeroidFtp2.ConnectError(sb.append(exc2.getMessage()).toString());
            }
            return Boolean.valueOf(z);
        }
    }

    @SimpleFunction(description = "Disconnect the current connection.")
    public void Disconnect() {
        b bVar;
        new b(this, (byte) 0);
        AsyncTask execute = bVar.execute(new Void[0]);
    }

    @SuppressLint({"StaticFieldLeak"})
    class b extends AsyncTask<Void, Void, Boolean> {
        private /* synthetic */ MakeroidFtp hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;

        /* access modifiers changed from: protected */
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            Object[] objArr2 = objArr;
            return hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME();
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ void onPostExecute(Object obj) {
            this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.ConnectionStatus(((Boolean) obj).booleanValue());
        }

        private b(MakeroidFtp makeroidFtp) {
            this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = makeroidFtp;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        /* synthetic */ b(MakeroidFtp makeroidFtp, byte b) {
            this(makeroidFtp);
            byte b2 = b;
        }

        private Boolean hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME() {
            StringBuilder sb;
            boolean z;
            try {
                MakeroidFtp.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME).disconnect();
                z = false;
            } catch (Exception e) {
                Exception exc = e;
                int e2 = Log.e("Makeroid Ftp", String.valueOf(exc));
                MakeroidFtp makeroidFtp = this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;
                new StringBuilder();
                makeroidFtp.DisconnectError(sb.append(exc.getMessage()).toString());
                z = true;
            }
            return Boolean.valueOf(z);
        }
    }

    @SimpleFunction(description = "Start uploading a file.")
    public void UploadFile(String str, String str2) {
        PermissionResultHandler permissionResultHandler;
        final String str3 = str;
        final String str4 = str2;
        new PermissionResultHandler(this) {
            private /* synthetic */ MakeroidFtp hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;

            {
                this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = r7;
            }

            public final void HandlePermissionResponse(String str, boolean z) {
                d dVar;
                String str2 = str;
                if (z) {
                    try {
                        d dVar2 = dVar;
                        new d(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME, (byte) 0);
                        String[] strArr = new String[2];
                        strArr[0] = str3;
                        String[] strArr2 = strArr;
                        strArr2[1] = str4;
                        AsyncTask execute = dVar2.execute(strArr2);
                    } catch (PermissionException e) {
                        this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.form.dispatchPermissionDeniedEvent((Component) this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME, "UploadFile", e);
                    } catch (Exception e2) {
                        int e3 = Log.e("Makeroid Ftp", String.valueOf(e2));
                    }
                } else {
                    this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.form.dispatchPermissionDeniedEvent((Component) this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME, "DownloadFile", str2);
                }
            }
        };
        this.form.askPermission("android.permission.READ_EXTERNAL_STORAGE", permissionResultHandler);
    }

    @SuppressLint({"StaticFieldLeak"})
    class d extends AsyncTask<String, Void, String> {
        private /* synthetic */ MakeroidFtp hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;

        /* access modifiers changed from: protected */
        public final /* synthetic */ void onPostExecute(Object obj) {
            String str = (String) obj;
            if (str.contains("None")) {
                this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.UploadDone();
            } else {
                this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.UploadError(str);
            }
        }

        private d(MakeroidFtp makeroidFtp) {
            this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = makeroidFtp;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        /* synthetic */ d(MakeroidFtp makeroidFtp, byte b) {
            this(makeroidFtp);
            byte b2 = b;
        }

        /* JADX WARNING: type inference failed for: r4v33, types: [java.io.FileInputStream] */
        /* access modifiers changed from: private */
        /* JADX WARNING: Multi-variable type inference failed */
        /* renamed from: hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String doInBackground(java.lang.String... r10) {
            /*
                r9 = this;
                r0 = r9
                r1 = r10
                java.lang.String r4 = ""
                r2 = r4
                java.io.File r4 = new java.io.File     // Catch:{ PermissionException -> 0x0048, Exception -> 0x007a }
                r8 = r4
                r4 = r8
                r5 = r8
                r6 = r1
                r7 = 0
                r6 = r6[r7]     // Catch:{ PermissionException -> 0x0048, Exception -> 0x007a }
                r5.<init>(r6)     // Catch:{ PermissionException -> 0x0048, Exception -> 0x007a }
                r3 = r4
                r4 = r0
                com.google.appinventor.components.runtime.MakeroidFtp r4 = r4.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME     // Catch:{ PermissionException -> 0x0048, Exception -> 0x007a }
                org.apache.commons.net.ftp.FTPClient r4 = com.google.appinventor.components.runtime.MakeroidFtp.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME((com.google.appinventor.components.runtime.MakeroidFtp) r4)     // Catch:{ PermissionException -> 0x0048, Exception -> 0x007a }
                r5 = 2
                boolean r4 = r4.setFileType(r5)     // Catch:{ PermissionException -> 0x0048, Exception -> 0x007a }
                java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ PermissionException -> 0x0048, Exception -> 0x007a }
                r8 = r4
                r4 = r8
                r5 = r8
                r6 = r3
                r5.<init>(r6)     // Catch:{ PermissionException -> 0x0048, Exception -> 0x007a }
                r3 = r4
                r4 = r0
                com.google.appinventor.components.runtime.MakeroidFtp r4 = r4.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME     // Catch:{ PermissionException -> 0x0048, Exception -> 0x007a }
                org.apache.commons.net.ftp.FTPClient r4 = com.google.appinventor.components.runtime.MakeroidFtp.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME((com.google.appinventor.components.runtime.MakeroidFtp) r4)     // Catch:{ PermissionException -> 0x0048, Exception -> 0x007a }
                r5 = r1
                r6 = 1
                r5 = r5[r6]     // Catch:{ PermissionException -> 0x0048, Exception -> 0x007a }
                r6 = r3
                boolean r4 = r4.storeFile(r5, r6)     // Catch:{ PermissionException -> 0x0048, Exception -> 0x007a }
                r1 = r4
                r4 = r3
                r4.close()     // Catch:{ PermissionException -> 0x0048, Exception -> 0x007a }
                r4 = r1
                if (r4 == 0) goto L_0x0045
                java.lang.String r4 = "None"
                r2 = r4
            L_0x0045:
                r4 = r2
                r0 = r4
                return r0
            L_0x0048:
                r4 = move-exception
                r3 = r4
                r4 = r0
                com.google.appinventor.components.runtime.MakeroidFtp r4 = r4.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME
                com.google.appinventor.components.runtime.Form r4 = r4.form
                r5 = r0
                com.google.appinventor.components.runtime.MakeroidFtp r5 = r5.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME
                java.lang.String r6 = "UploadFile"
                r7 = r3
                r4.dispatchPermissionDeniedEvent((com.google.appinventor.components.runtime.Component) r5, (java.lang.String) r6, (com.google.appinventor.components.runtime.errors.PermissionException) r7)
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r8 = r4
                r4 = r8
                r5 = r8
                r5.<init>()
                r5 = r3
                java.lang.String r5 = r5.getMessage()
                java.lang.StringBuilder r4 = r4.append(r5)
                java.lang.String r4 = r4.toString()
                r3 = r4
                java.lang.String r4 = "Makeroid Ftp"
                r5 = r3
                int r4 = android.util.Log.e(r4, r5)
                r4 = r3
                r2 = r4
                goto L_0x0045
            L_0x007a:
                r4 = move-exception
                r3 = r4
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r8 = r4
                r4 = r8
                r5 = r8
                r5.<init>()
                r5 = r3
                java.lang.String r5 = r5.getMessage()
                java.lang.StringBuilder r4 = r4.append(r5)
                java.lang.String r4 = r4.toString()
                r3 = r4
                java.lang.String r4 = "Makeroid Ftp"
                r5 = r3
                int r4 = android.util.Log.e(r4, r5)
                r4 = r3
                r2 = r4
                goto L_0x0045
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.appinventor.components.runtime.MakeroidFtp.d.doInBackground(java.lang.String[]):java.lang.String");
        }
    }

    @SimpleFunction(description = "Start downloading a file.")
    public void DownloadFile(String str, String str2) {
        PermissionResultHandler permissionResultHandler;
        final String str3 = str;
        final String str4 = str2;
        new PermissionResultHandler(this) {
            private /* synthetic */ MakeroidFtp hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;

            {
                this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = r7;
            }

            public final void HandlePermissionResponse(String str, boolean z) {
                c cVar;
                String str2 = str;
                if (z) {
                    try {
                        c cVar2 = cVar;
                        new c(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME, (byte) 0);
                        String[] strArr = new String[2];
                        strArr[0] = str3;
                        String[] strArr2 = strArr;
                        strArr2[1] = str4;
                        AsyncTask execute = cVar2.execute(strArr2);
                    } catch (PermissionException e) {
                        this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.form.dispatchPermissionDeniedEvent((Component) this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME, "DownloadFile", e);
                    } catch (Exception e2) {
                        int e3 = Log.e("Makeroid Ftp", String.valueOf(e2));
                    }
                } else {
                    this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.form.dispatchPermissionDeniedEvent((Component) this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME, "DownloadFile", str2);
                }
            }
        };
        this.form.askPermission("android.permission.WRITE_EXTERNAL_STORAGE", permissionResultHandler);
    }

    @SuppressLint({"StaticFieldLeak"})
    class c extends AsyncTask<String, Void, String> {
        private /* synthetic */ MakeroidFtp hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;

        /* access modifiers changed from: protected */
        public final /* synthetic */ void onPostExecute(Object obj) {
            String str = (String) obj;
            if (str.contains("None")) {
                this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.DownloadDone();
            } else {
                this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.DownloadError(str);
            }
        }

        private c(MakeroidFtp makeroidFtp) {
            this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = makeroidFtp;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        /* synthetic */ c(MakeroidFtp makeroidFtp, byte b) {
            this(makeroidFtp);
            byte b2 = b;
        }

        /* access modifiers changed from: private */
        /* renamed from: hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME */
        public String doInBackground(String... strArr) {
            StringBuilder sb;
            StringBuilder sb2;
            File file;
            StringBuilder sb3;
            StringBuilder sb4;
            StringBuilder sb5;
            StringBuilder sb6;
            StringBuilder sb7;
            OutputStream outputStream;
            OutputStream outputStream2;
            StringBuilder sb8;
            String[] strArr2 = strArr;
            String str = "";
            try {
                new File(strArr2[1]);
                File file2 = file;
                File file3 = file2;
                File parentFile = file2.getParentFile();
                File file4 = parentFile;
                if (!parentFile.exists()) {
                    boolean mkdir = file4.mkdir();
                }
                try {
                    new FileOutputStream(file3);
                    new BufferedOutputStream(outputStream2);
                    OutputStream outputStream3 = outputStream;
                    boolean fileType = MakeroidFtp.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME).setFileType(2);
                    if (MakeroidFtp.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME).retrieveFile(strArr2[0], outputStream3)) {
                        str = "None";
                    }
                    try {
                        outputStream3.close();
                    } catch (Exception e) {
                        Exception exc = e;
                        int e2 = Log.e("Makeroid Ftp", String.valueOf(exc));
                        new StringBuilder();
                        str = sb8.append(exc.getMessage()).toString();
                    }
                } catch (PermissionException e3) {
                    PermissionException permissionException = e3;
                    this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.form.dispatchPermissionDeniedEvent((Component) this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME, "DownloadFile", permissionException);
                    new StringBuilder();
                    str = sb6.append(permissionException.getMessage()).toString();
                    if (0 != 0) {
                        OutputStream outputStream4 = null;
                        try {
                            outputStream4.close();
                        } catch (Exception e4) {
                            Exception exc2 = e4;
                            int e5 = Log.e("Makeroid Ftp", String.valueOf(exc2));
                            new StringBuilder();
                            str = sb7.append(exc2.getMessage()).toString();
                        }
                    }
                } catch (Exception e6) {
                    Exception exc3 = e6;
                    int e7 = Log.e("Makeroid Ftp", String.valueOf(exc3));
                    new StringBuilder();
                    str = sb4.append(exc3.getMessage()).toString();
                    if (0 != 0) {
                        OutputStream outputStream5 = null;
                        try {
                            outputStream5.close();
                        } catch (Exception e8) {
                            Exception exc4 = e8;
                            int e9 = Log.e("Makeroid Ftp", String.valueOf(exc4));
                            new StringBuilder();
                            str = sb5.append(exc4.getMessage()).toString();
                        }
                    }
                } catch (Throwable th) {
                    Throwable th2 = th;
                    if (0 != 0) {
                        OutputStream outputStream6 = null;
                        try {
                            outputStream6.close();
                        } catch (Exception e10) {
                            Exception exc5 = e10;
                            int e11 = Log.e("Makeroid Ftp", String.valueOf(exc5));
                            new StringBuilder();
                            StringBuilder append = sb3.append(exc5.getMessage());
                        }
                    }
                    throw th2;
                }
                return str;
            } catch (PermissionException e12) {
                PermissionException permissionException2 = e12;
                this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.form.dispatchPermissionDeniedEvent((Component) this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME, "DownloadFile", permissionException2);
                new StringBuilder();
                return sb2.append(permissionException2.getMessage()).toString();
            } catch (Exception e13) {
                Exception exc6 = e13;
                int e14 = Log.e("Makeroid Ftp", String.valueOf(exc6));
                new StringBuilder();
                return sb.append(exc6.getMessage()).toString();
            }
        }
    }

    @SimpleEvent(description = "This event returns the status of the connection. If it is connect it will return true, else false. ")
    public void ConnectionStatus(boolean z) {
        boolean dispatchEvent = EventDispatcher.dispatchEvent(this, "ConnectionStatus", Boolean.valueOf(z));
    }

    @SimpleEvent(description = "This event is invoked when the upload is finished.")
    public void UploadDone() {
        boolean dispatchEvent = EventDispatcher.dispatchEvent(this, "UploadDone", new Object[0]);
    }

    @SimpleEvent(description = "This event is invoked when the download is finished.")
    public void DownloadDone() {
        boolean dispatchEvent = EventDispatcher.dispatchEvent(this, "DownloadDone", new Object[0]);
    }

    @SimpleEvent(description = "This event returns the reason if a upload was not successful.")
    public void UploadError(String str) {
        boolean dispatchEvent = EventDispatcher.dispatchEvent(this, "UploadError", str);
    }

    @SimpleEvent(description = "This event returns the reason if a download was not successful.")
    public void DownloadError(String str) {
        boolean dispatchEvent = EventDispatcher.dispatchEvent(this, "DownloadError", str);
    }

    @SimpleEvent(description = "This event returns the reason if a try to connect was not successful.")
    public void ConnectError(String str) {
        boolean dispatchEvent = EventDispatcher.dispatchEvent(this, "ConnectError", str);
    }

    @SimpleEvent(description = "This event returns the reason if a try to disconnect was not successful.")
    public void DisconnectError(String str) {
        boolean dispatchEvent = EventDispatcher.dispatchEvent(this, "DisconnectError", str);
    }
}
