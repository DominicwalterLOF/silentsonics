package org.jose4j.jwe;

import com.google.appinventor.components.runtime.util.Ev3Constants;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.GCMParameterSpec;
import org.jose4j.keys.AesKey;
import org.jose4j.lang.ByteUtil;
import org.jose4j.lang.ExceptionHelp;
import org.jose4j.lang.JoseException;
import org.slf4j.Logger;

public class SimpleAeadCipher {
    public static final String GCM_TRANSFORMATION_NAME = "AES/GCM/NoPadding";
    private String algorithm;
    private int tagByteLength;

    public SimpleAeadCipher(String algorithm2, int tagByteLength2) {
        this.algorithm = algorithm2;
        this.tagByteLength = tagByteLength2;
    }

    private Cipher getInitialisedCipher(Key key, byte[] bArr, int i, String provider) throws JoseException {
        Throwable th;
        Throwable th2;
        StringBuilder sb;
        AlgorithmParameterSpec algorithmParameterSpec;
        Key key2 = key;
        byte[] iv = bArr;
        int mode = i;
        Cipher cipher = CipherUtil.getCipher(this.algorithm, provider);
        try {
            new GCMParameterSpec(ByteUtil.bitLength(this.tagByteLength), iv);
            cipher.init(mode, key2, algorithmParameterSpec);
            return cipher;
        } catch (InvalidKeyException e) {
            InvalidKeyException e2 = e;
            Throwable th3 = th2;
            new StringBuilder();
            new JoseException(sb.append("Invalid key for ").append(this.algorithm).toString(), e2);
            throw th3;
        } catch (InvalidAlgorithmParameterException e3) {
            InvalidAlgorithmParameterException e4 = e3;
            Throwable th4 = th;
            new JoseException(e4.toString(), e4);
            throw th4;
        }
    }

    public CipherOutput encrypt(Key key, byte[] iv, byte[] plaintext, byte[] aad, String provider) throws JoseException {
        Throwable th;
        CipherOutput cipherOutput;
        Cipher cipher = getInitialisedCipher(key, iv, 1, provider);
        updateAad(cipher, aad);
        try {
            byte[] cipherOutput2 = cipher.doFinal(plaintext);
            new CipherOutput();
            CipherOutput result = cipherOutput;
            int tagIndex = cipherOutput2.length - this.tagByteLength;
            byte[] access$002 = CipherOutput.access$002(result, ByteUtil.subArray(cipherOutput2, 0, tagIndex));
            byte[] access$102 = CipherOutput.access$102(result, ByteUtil.subArray(cipherOutput2, tagIndex, this.tagByteLength));
            return result;
        } catch (BadPaddingException | IllegalBlockSizeException e) {
            GeneralSecurityException e2 = e;
            Throwable th2 = th;
            new JoseException(e2.toString(), e2);
            throw th2;
        }
    }

    private void updateAad(Cipher cipher, byte[] bArr) {
        Cipher cipher2 = cipher;
        byte[] aad = bArr;
        if (aad != null && aad.length > 0) {
            cipher2.updateAAD(aad);
        }
    }

    public byte[] decrypt(Key key, byte[] iv, byte[] bArr, byte[] bArr2, byte[] aad, String provider) throws JoseException {
        Throwable th;
        byte[] ciphertext = bArr;
        byte[] tag = bArr2;
        Cipher cipher = getInitialisedCipher(key, iv, 2, provider);
        updateAad(cipher, aad);
        Cipher cipher2 = cipher;
        try {
            byte[][] bArr3 = new byte[2][];
            bArr3[0] = ciphertext;
            byte[][] bArr4 = bArr3;
            bArr4[1] = tag;
            return cipher2.doFinal(ByteUtil.concat(bArr4));
        } catch (BadPaddingException | IllegalBlockSizeException e) {
            GeneralSecurityException e2 = e;
            Throwable th2 = th;
            new JoseException(e2.toString(), e2);
            throw th2;
        }
    }

    public boolean isAvailable(Logger logger, int i, int i2, String str) {
        Key key;
        Logger log = logger;
        int keyByteLength = i;
        int ivByteLength = i2;
        String joseAlg = str;
        boolean isAvailable = false;
        if (CipherStrengthSupport.isAvailable(this.algorithm, keyByteLength)) {
            byte[] plain = {Ev3Constants.Opcode.JR_NEQ8, Ev3Constants.Opcode.JR_EQ8, Ev3Constants.Opcode.PORT_CNV_OUTPUT, Ev3Constants.Opcode.JR_GT16, Ev3Constants.Opcode.JR_EQ32, Ev3Constants.Opcode.JR_LTEQ8, Ev3Constants.Opcode.JR_LT16, Ev3Constants.Opcode.JR_GTEQ8, Ev3Constants.Opcode.JR_LTEQ8};
            byte[] aad = {Ev3Constants.Opcode.PORT_CNV_OUTPUT, Ev3Constants.Opcode.PORT_CNV_OUTPUT, Ev3Constants.Opcode.JR_LT8};
            byte[] iv = new byte[ivByteLength];
            try {
                new AesKey(new byte[keyByteLength]);
                CipherOutput encrypt = encrypt(key, iv, plain, aad, (String) null);
                isAvailable = true;
            } catch (Throwable th) {
                log.debug("{} is not available ({}).", (Object) joseAlg, (Object) ExceptionHelp.toStringWithCauses(th));
            }
        }
        return isAvailable;
    }

    public static class CipherOutput {
        private byte[] ciphertext;
        private byte[] tag;

        public CipherOutput() {
        }

        static /* synthetic */ byte[] access$002(CipherOutput x0, byte[] x1) {
            byte[] bArr = x1;
            byte[] bArr2 = bArr;
            x0.ciphertext = bArr2;
            return bArr;
        }

        static /* synthetic */ byte[] access$102(CipherOutput x0, byte[] x1) {
            byte[] bArr = x1;
            byte[] bArr2 = bArr;
            x0.tag = bArr2;
            return bArr;
        }

        public byte[] getCiphertext() {
            return this.ciphertext;
        }

        public byte[] getTag() {
            return this.tag;
        }
    }
}
