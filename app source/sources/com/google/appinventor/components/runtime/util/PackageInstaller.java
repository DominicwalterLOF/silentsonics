package com.google.appinventor.components.runtime.util;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.util.Log;
import com.google.appinventor.components.runtime.Form;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;

public class PackageInstaller {
    private PackageInstaller() {
    }

    public static void doPackageInstall(Form form, String str) {
        Runnable runnable;
        final String str2 = str;
        final Form form2 = form;
        new Runnable() {
            public final void run() {
                URL url;
                InputStream inputStream;
                File file;
                FileOutputStream fileOutputStream;
                StringBuilder sb;
                Intent intent;
                try {
                    new URL(str2);
                    new BufferedInputStream(url.openConnection().getInputStream());
                    InputStream inputStream2 = inputStream;
                    new File(QUtil.getReplAssetPath(form2), "/package.apk");
                    File file2 = file;
                    new FileOutputStream(file2);
                    FileOutputStream fileOutputStream2 = fileOutputStream;
                    byte[] bArr = new byte[32768];
                    while (true) {
                        int read = inputStream2.read(bArr, 0, 32768);
                        int i = read;
                        if (read > 0) {
                            fileOutputStream2.write(bArr, 0, i);
                        } else {
                            inputStream2.close();
                            fileOutputStream2.close();
                            new StringBuilder("About to Install package from ");
                            int d = Log.d("PackageInstaller (Kodular)", sb.append(str2).toString());
                            new Intent("android.intent.action.VIEW");
                            Intent intent2 = intent;
                            Intent dataAndType = intent2.setDataAndType(NougatUtil.getPackageUri(form2, file2), "application/vnd.android.package-archive");
                            Intent flags = intent2.setFlags(1);
                            form2.startActivity(intent2);
                            IOUtils.closeQuietly("PackageInstaller (Kodular)", inputStream2);
                            IOUtils.closeQuietly("PackageInstaller (Kodular)", fileOutputStream2);
                            return;
                        }
                    }
                } catch (ActivityNotFoundException e) {
                    int e2 = Log.e("PackageInstaller (Kodular)", "Unable to install package", e);
                    form2.dispatchErrorOccurredEvent(form2, "PackageInstaller", ErrorMessages.ERROR_UNABLE_TO_INSTALL_PACKAGE, null);
                    IOUtils.closeQuietly("PackageInstaller (Kodular)", (Closeable) null);
                    IOUtils.closeQuietly("PackageInstaller (Kodular)", (Closeable) null);
                } catch (Exception e3) {
                    int e4 = Log.e("PackageInstaller (Kodular)", "ERROR_UNABLE_TO_GET", e3);
                    form2.dispatchErrorOccurredEvent(form2, "PackageInstaller", ErrorMessages.ERROR_WEB_UNABLE_TO_GET, str2);
                    IOUtils.closeQuietly("PackageInstaller (Kodular)", (Closeable) null);
                    IOUtils.closeQuietly("PackageInstaller (Kodular)", (Closeable) null);
                } catch (Throwable th) {
                    IOUtils.closeQuietly("PackageInstaller (Kodular)", (Closeable) null);
                    IOUtils.closeQuietly("PackageInstaller (Kodular)", (Closeable) null);
                    throw th;
                }
            }
        };
        AsynchUtil.runAsynchronously(runnable);
    }
}
