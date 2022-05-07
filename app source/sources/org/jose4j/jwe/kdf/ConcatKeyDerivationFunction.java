package org.jose4j.jwe.kdf;

import java.io.ByteArrayOutputStream;
import java.security.MessageDigest;
import org.jose4j.lang.ByteUtil;
import org.jose4j.lang.HashUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConcatKeyDerivationFunction {
    private static final Logger log = LoggerFactory.getLogger((Class<?>) ConcatKeyDerivationFunction.class);
    private int digestLength;
    private MessageDigest messageDigest;

    public ConcatKeyDerivationFunction(String hashAlgoritm) {
        this.messageDigest = HashUtil.getMessageDigest(hashAlgoritm);
        init();
    }

    public ConcatKeyDerivationFunction(String hashAlgoritm, String provider) {
        this.messageDigest = HashUtil.getMessageDigest(hashAlgoritm, provider);
        init();
    }

    private void init() {
        this.digestLength = ByteUtil.bitLength(this.messageDigest.getDigestLength());
        if (traceLog()) {
            log.trace("Hash Algorithm: {} with hashlen: {} bits", (Object) this.messageDigest.getAlgorithm(), (Object) Integer.valueOf(this.digestLength));
        }
    }

    public byte[] kdf(byte[] bArr, int i, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, byte[] bArr6) {
        StringBuilder sb;
        byte[] sharedSecret = bArr;
        int keydatalen = i;
        byte[] algorithmId = bArr2;
        byte[] partyUInfo = bArr3;
        byte[] partyVInfo = bArr4;
        byte[] suppPubInfo = bArr5;
        byte[] suppPrivInfo = bArr6;
        if (traceLog()) {
            new StringBuilder();
            StringBuilder msg = sb;
            StringBuilder append = msg.append("KDF:").append("\n");
            StringBuilder append2 = msg.append("  z: ").append(ByteUtil.toDebugString(sharedSecret)).append("\n");
            StringBuilder append3 = msg.append("  keydatalen: ").append(keydatalen);
            StringBuilder append4 = msg.append("  algorithmId: ").append(ByteUtil.toDebugString(algorithmId)).append("\n");
            StringBuilder append5 = msg.append("  partyUInfo: ").append(ByteUtil.toDebugString(partyUInfo)).append("\n");
            StringBuilder append6 = msg.append("  partyVInfo: ").append(ByteUtil.toDebugString(partyVInfo)).append("\n");
            StringBuilder append7 = msg.append("  suppPubInfo: ").append(ByteUtil.toDebugString(suppPubInfo)).append("\n");
            StringBuilder append8 = msg.append("  suppPrivInfo: ").append(ByteUtil.toDebugString(suppPrivInfo));
            log.trace(msg.toString());
        }
        byte[][] bArr7 = new byte[5][];
        bArr7[0] = algorithmId;
        byte[][] bArr8 = bArr7;
        bArr8[1] = partyUInfo;
        byte[][] bArr9 = bArr8;
        bArr9[2] = partyVInfo;
        byte[][] bArr10 = bArr9;
        bArr10[3] = suppPubInfo;
        byte[][] bArr11 = bArr10;
        bArr11[4] = suppPrivInfo;
        return kdf(sharedSecret, keydatalen, ByteUtil.concat(bArr11));
    }

    public byte[] kdf(byte[] bArr, int i, byte[] bArr2) {
        ByteArrayOutputStream byteArrayOutputStream;
        byte[] sharedSecret = bArr;
        int keydatalen = i;
        byte[] otherInfo = bArr2;
        long reps = getReps(keydatalen);
        if (traceLog()) {
            log.trace("reps: {}", (Object) String.valueOf(reps));
            log.trace("otherInfo: {}", (Object) ByteUtil.toDebugString(otherInfo));
        }
        new ByteArrayOutputStream();
        ByteArrayOutputStream derivedByteOutputStream = byteArrayOutputStream;
        for (int i2 = 1; ((long) i2) <= reps; i2++) {
            byte[] counterBytes = ByteUtil.getBytes(i2);
            if (traceLog()) {
                log.trace("rep {} hashing ", (Object) Integer.valueOf(i2));
                log.trace(" counter: {}", (Object) ByteUtil.toDebugString(counterBytes));
                log.trace(" z: {}", (Object) ByteUtil.toDebugString(sharedSecret));
                log.trace(" otherInfo: {}", (Object) ByteUtil.toDebugString(otherInfo));
            }
            this.messageDigest.update(counterBytes);
            this.messageDigest.update(sharedSecret);
            this.messageDigest.update(otherInfo);
            byte[] digest = this.messageDigest.digest();
            if (traceLog()) {
                log.trace(" k({}): {}", (Object) Integer.valueOf(i2), (Object) ByteUtil.toDebugString(digest));
            }
            derivedByteOutputStream.write(digest, 0, digest.length);
        }
        int i3 = ByteUtil.byteLength(keydatalen);
        byte[] derivedKeyMaterial = derivedByteOutputStream.toByteArray();
        if (traceLog()) {
            log.trace("derived key material: {}", (Object) ByteUtil.toDebugString(derivedKeyMaterial));
        }
        if (derivedKeyMaterial.length != i3) {
            byte[] newKeyMaterial = ByteUtil.subArray(derivedKeyMaterial, 0, i3);
            if (traceLog()) {
                log.trace("first {} bits of derived key material: {}", (Object) Integer.valueOf(keydatalen), (Object) ByteUtil.toDebugString(newKeyMaterial));
            }
            derivedKeyMaterial = newKeyMaterial;
        }
        if (traceLog()) {
            log.trace("final derived key material: {}", (Object) ByteUtil.toDebugString(derivedKeyMaterial));
        }
        return derivedKeyMaterial;
    }

    /* access modifiers changed from: package-private */
    public long getReps(int keydatalen) {
        return (long) ((int) Math.ceil((double) (((float) keydatalen) / ((float) this.digestLength))));
    }

    private boolean traceLog() {
        return false;
    }
}
