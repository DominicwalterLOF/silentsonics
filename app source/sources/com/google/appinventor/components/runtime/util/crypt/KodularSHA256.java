package com.google.appinventor.components.runtime.util.crypt;

import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.jose4j.lang.HashUtil;

public class KodularSHA256 {
    public KodularSHA256() {
    }

    public static String sha256(String str) {
        StringBuilder sb;
        StringBuilder sb2;
        String str2;
        try {
            String str3 = str2;
            new String(MessageDigest.getInstance(HashUtil.SHA_256).digest(str.getBytes("UTF-8")), "UTF-8");
            return str3;
        } catch (NoSuchAlgorithmException e) {
            new StringBuilder();
            int e2 = Log.e("MakeroidCrypt", sb2.append(e.getMessage()).toString());
            return "";
        } catch (UnsupportedEncodingException e3) {
            new StringBuilder();
            int e4 = Log.e("MakeroidCrypt", sb.append(e3.getMessage()).toString());
            return "";
        }
    }
}
