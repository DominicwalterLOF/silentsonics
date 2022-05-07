package org.jose4j.jwe.kdf;

import org.jose4j.base64url.Base64Url;
import org.jose4j.lang.ByteUtil;
import org.jose4j.lang.HashUtil;
import org.jose4j.lang.StringUtil;

public class KdfUtil {
    private Base64Url base64Url;
    private ConcatKeyDerivationFunction kdf;

    public KdfUtil() {
        Base64Url base64Url2;
        ConcatKeyDerivationFunction concatKeyDerivationFunction;
        new Base64Url();
        this.base64Url = base64Url2;
        new ConcatKeyDerivationFunction(HashUtil.SHA_256);
        this.kdf = concatKeyDerivationFunction;
    }

    public KdfUtil(String provider) {
        Base64Url base64Url2;
        ConcatKeyDerivationFunction concatKeyDerivationFunction;
        new Base64Url();
        this.base64Url = base64Url2;
        new ConcatKeyDerivationFunction(HashUtil.SHA_256, provider);
        this.kdf = concatKeyDerivationFunction;
    }

    public byte[] kdf(byte[] sharedSecret, int i, String algorithmId, String partyUInfo, String partyVInfo) {
        int keydatalen = i;
        return this.kdf.kdf(sharedSecret, keydatalen, prependDatalen(StringUtil.getBytesUtf8(algorithmId)), getDatalenDataFormat(partyUInfo), getDatalenDataFormat(partyVInfo), ByteUtil.getBytes(keydatalen), ByteUtil.EMPTY_BYTES);
    }

    /* access modifiers changed from: package-private */
    public byte[] prependDatalen(byte[] bArr) {
        byte[] data = bArr;
        if (data == null) {
            data = ByteUtil.EMPTY_BYTES;
        }
        byte[][] bArr2 = new byte[2][];
        bArr2[0] = ByteUtil.getBytes(data.length);
        byte[][] bArr3 = bArr2;
        bArr3[1] = data;
        return ByteUtil.concat(bArr3);
    }

    /* access modifiers changed from: package-private */
    public byte[] getDatalenDataFormat(String encodedValue) {
        return prependDatalen(this.base64Url.base64UrlDecode(encodedValue));
    }
}
