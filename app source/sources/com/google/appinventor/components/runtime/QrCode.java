package com.google.appinventor.components.runtime;

import android.content.Context;
import android.net.ConnectivityManager;
import android.util.Log;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.annotations.UsesPermissions;
import com.google.appinventor.components.common.ComponentCategory;
import java.net.URLEncoder;
import org.jose4j.jwk.EllipticCurveJsonWebKey;

@SimpleObject
@DesignerComponent(category = ComponentCategory.MEDIA, description = "", iconName = "images/qrCode.png", nonVisible = true, version = 1)
@UsesPermissions({"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
public class QrCode extends AndroidNonvisibleComponent implements Component {
    private int KZERK4FJjgj00YJ12FkBt8g0XGe7fRlOujzm0QMQzA20gzGqez6qkZCId3aKJaes = -16777216;
    private Context context;
    private String fAlnFrzRyM2sCUVmNXgAumx383He1buRJXamXMT9T0hNFh1WxfF7xQU1M3W9TIGM = "http://api.qrserver.com/v1/create-qr-code/?data=";
    private String gUtdvgLwReW6eQihrPDf1Gr7OXNm8PrZovE9AMcvRbNvJBLZZT49Ja1NneDzYHk = "UTF-8";
    private String hZhaRgwkBZwejuAnnYABoWeuzwSnVTS6FhaE0jegMWisoVYsWwdasjmLDosamQJe = "png";
    private String iz2AUXs4pv4EMA73duiR1R3OfWItF7gDqk3oMKKRO3MIyuqvZdoefifHvTvEAhn = "Default";
    private int nrk4qDbuonwjAUi7HPDytbtabfk6KLkf1OM4Z1o9O6dUiFPBfNVpTU1RRHKJKimM = 0;
    private int q8iygSjgpTZ52A5K8GXhnvUs2CX4iXd4uIVtwvououVquIzlzfVOfWIR3CjSHG4 = -1;
    private int size = 200;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public QrCode(com.google.appinventor.components.runtime.ComponentContainer r5) {
        /*
            r4 = this;
            r0 = r4
            r1 = r5
            r2 = r0
            r3 = r1
            com.google.appinventor.components.runtime.Form r3 = r3.$form()
            r2.<init>(r3)
            r2 = r0
            java.lang.String r3 = "Default"
            r2.iz2AUXs4pv4EMA73duiR1R3OfWItF7gDqk3oMKKRO3MIyuqvZdoefifHvTvEAhn = r3
            r2 = r0
            r3 = 200(0xc8, float:2.8E-43)
            r2.size = r3
            r2 = r0
            java.lang.String r3 = "UTF-8"
            r2.gUtdvgLwReW6eQihrPDf1Gr7OXNm8PrZovE9AMcvRbNvJBLZZT49Ja1NneDzYHk = r3
            r2 = r0
            r3 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r2.KZERK4FJjgj00YJ12FkBt8g0XGe7fRlOujzm0QMQzA20gzGqez6qkZCId3aKJaes = r3
            r2 = r0
            r3 = -1
            r2.q8iygSjgpTZ52A5K8GXhnvUs2CX4iXd4uIVtwvououVquIzlzfVOfWIR3CjSHG4 = r3
            r2 = r0
            r3 = 0
            r2.nrk4qDbuonwjAUi7HPDytbtabfk6KLkf1OM4Z1o9O6dUiFPBfNVpTU1RRHKJKimM = r3
            r2 = r0
            java.lang.String r3 = "png"
            r2.hZhaRgwkBZwejuAnnYABoWeuzwSnVTS6FhaE0jegMWisoVYsWwdasjmLDosamQJe = r3
            r2 = r0
            java.lang.String r3 = "http://api.qrserver.com/v1/create-qr-code/?data="
            r2.fAlnFrzRyM2sCUVmNXgAumx383He1buRJXamXMT9T0hNFh1WxfF7xQU1M3W9TIGM = r3
            r2 = r0
            r3 = r1
            android.app.Activity r3 = r3.$context()
            r2.context = r3
            java.lang.String r2 = "QRCode"
            java.lang.String r3 = "QRCode Created"
            int r2 = android.util.Log.d(r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.appinventor.components.runtime.QrCode.<init>(com.google.appinventor.components.runtime.ComponentContainer):void");
    }

    @SimpleEvent(description = "You will find here the success state and image url.")
    public void GotResponse(boolean z, String str) {
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(z);
        Object[] objArr2 = objArr;
        objArr2[1] = str;
        boolean dispatchEvent = EventDispatcher.dispatchEvent(this, "GotResponse", objArr2);
    }

    @SimpleFunction(description = "Create a QR Code and the result is a link to it. Example: Set the resolution(in pixel) to 200(height and width has the same value) and text to: Hello world!. Result: QR code resolution is 200x200, text = Hello world! Your text input is encoded in the link automatically.")
    public void GenerateQrCode() {
        StringBuilder sb;
        boolean z;
        try {
            if (this.iz2AUXs4pv4EMA73duiR1R3OfWItF7gDqk3oMKKRO3MIyuqvZdoefifHvTvEAhn == null || this.iz2AUXs4pv4EMA73duiR1R3OfWItF7gDqk3oMKKRO3MIyuqvZdoefifHvTvEAhn.isEmpty()) {
                GotResponse(false, "Can not generate qr code with no text.");
                return;
            }
            String encode = URLEncoder.encode(this.iz2AUXs4pv4EMA73duiR1R3OfWItF7gDqk3oMKKRO3MIyuqvZdoefifHvTvEAhn, this.gUtdvgLwReW6eQihrPDf1Gr7OXNm8PrZovE9AMcvRbNvJBLZZT49Ja1NneDzYHk);
            new StringBuilder();
            StringBuilder sb2 = sb;
            StringBuilder sb3 = sb2;
            StringBuilder append = sb2.append(this.fAlnFrzRyM2sCUVmNXgAumx383He1buRJXamXMT9T0hNFh1WxfF7xQU1M3W9TIGM);
            StringBuilder append2 = sb3.append(encode);
            StringBuilder append3 = sb3.append("&color=");
            StringBuilder append4 = sb3.append(Integer.toHexString(this.KZERK4FJjgj00YJ12FkBt8g0XGe7fRlOujzm0QMQzA20gzGqez6qkZCId3aKJaes).substring(2));
            StringBuilder append5 = sb3.append("&bgcolor=");
            StringBuilder append6 = sb3.append(Integer.toHexString(this.q8iygSjgpTZ52A5K8GXhnvUs2CX4iXd4uIVtwvououVquIzlzfVOfWIR3CjSHG4).substring(2));
            StringBuilder append7 = sb3.append("&margin=");
            StringBuilder append8 = sb3.append(this.nrk4qDbuonwjAUi7HPDytbtabfk6KLkf1OM4Z1o9O6dUiFPBfNVpTU1RRHKJKimM);
            StringBuilder append9 = sb3.append("&format=");
            StringBuilder append10 = sb3.append(this.hZhaRgwkBZwejuAnnYABoWeuzwSnVTS6FhaE0jegMWisoVYsWwdasjmLDosamQJe);
            StringBuilder append11 = sb3.append("&size=");
            StringBuilder append12 = sb3.append(this.size);
            StringBuilder append13 = sb3.append(EllipticCurveJsonWebKey.X_MEMBER_NAME);
            StringBuilder append14 = sb3.append(this.size);
            ConnectivityManager connectivityManager = (ConnectivityManager) this.context.getSystemService("connectivity");
            ConnectivityManager connectivityManager2 = connectivityManager;
            if (connectivityManager.getActiveNetworkInfo() == null || !connectivityManager2.getActiveNetworkInfo().isAvailable() || !connectivityManager2.getActiveNetworkInfo().isConnected()) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                GotResponse(true, sb3.toString());
                int d = Log.d("QRCode", "Success state is: true");
                return;
            }
            GotResponse(false, "");
            int d2 = Log.d("QRCode", "Success state is: false");
        } catch (Exception e) {
        }
    }

    @DesignerProperty(defaultValue = "Default", editorType = "textArea")
    @SimpleProperty(description = "This is the text that is converted as qr code.")
    public void Text(String str) {
        String str2 = str;
        this.iz2AUXs4pv4EMA73duiR1R3OfWItF7gDqk3oMKKRO3MIyuqvZdoefifHvTvEAhn = str2;
    }

    @SimpleProperty(description = "Return the text.")
    public String Text() {
        return this.iz2AUXs4pv4EMA73duiR1R3OfWItF7gDqk3oMKKRO3MIyuqvZdoefifHvTvEAhn;
    }

    @DesignerProperty(defaultValue = "200", editorType = "integer")
    @SimpleProperty(description = "Set the size/resolution of the qr code.")
    public void Size(int i) {
        int i2 = i;
        this.size = i2;
    }

    @SimpleProperty(description = "Return the size/resolution of the qr code.")
    public int Size() {
        return this.size;
    }

    @DesignerProperty(defaultValue = "UTF-8", editorType = "string", propertyType = "advanced")
    @SimpleProperty(description = "Set the charset of the input text.")
    public void Charset(String str) {
        String str2 = str;
        this.gUtdvgLwReW6eQihrPDf1Gr7OXNm8PrZovE9AMcvRbNvJBLZZT49Ja1NneDzYHk = str2;
    }

    @SimpleProperty(description = "Return the charset of the input text.")
    public String Charset() {
        return this.gUtdvgLwReW6eQihrPDf1Gr7OXNm8PrZovE9AMcvRbNvJBLZZT49Ja1NneDzYHk;
    }

    @DesignerProperty(defaultValue = "&HFF000000", editorType = "color")
    @SimpleProperty(description = "Set the color of the qr code result.")
    public void FrontColor(int i) {
        int i2 = i;
        this.KZERK4FJjgj00YJ12FkBt8g0XGe7fRlOujzm0QMQzA20gzGqez6qkZCId3aKJaes = i2;
    }

    @SimpleProperty(description = "Return the color of the qr code result.")
    public int FrontColor() {
        return this.KZERK4FJjgj00YJ12FkBt8g0XGe7fRlOujzm0QMQzA20gzGqez6qkZCId3aKJaes;
    }

    @DesignerProperty(defaultValue = "&HFFFFFFFF", editorType = "color")
    @SimpleProperty(description = "Set the background color of the qr code result.")
    public void BackgroundColor(int i) {
        int i2 = i;
        this.q8iygSjgpTZ52A5K8GXhnvUs2CX4iXd4uIVtwvououVquIzlzfVOfWIR3CjSHG4 = i2;
    }

    @SimpleProperty(description = "Return the background color of the qr code result.")
    public int BackgroundColor() {
        return this.q8iygSjgpTZ52A5K8GXhnvUs2CX4iXd4uIVtwvououVquIzlzfVOfWIR3CjSHG4;
    }

    @DesignerProperty(defaultValue = "0", editorType = "integer")
    @SimpleProperty(description = "Thickness of a margin in pixels. The margin will always have the same color as the background.")
    public void Margin(int i) {
        int i2 = i;
        this.nrk4qDbuonwjAUi7HPDytbtabfk6KLkf1OM4Z1o9O6dUiFPBfNVpTU1RRHKJKimM = i2;
    }

    @SimpleProperty(description = "Return the margin in pixels.")
    public int Margin() {
        return this.nrk4qDbuonwjAUi7HPDytbtabfk6KLkf1OM4Z1o9O6dUiFPBfNVpTU1RRHKJKimM;
    }

    @DesignerProperty(defaultValue = "png", editorType = "string")
    @SimpleProperty(description = "It's possible to create the QR code picture using different file formats, available are PNG, GIF, JPEG and the vector graphic formats SVG and EPS.")
    public void Format(String str) {
        String str2 = str;
        this.hZhaRgwkBZwejuAnnYABoWeuzwSnVTS6FhaE0jegMWisoVYsWwdasjmLDosamQJe = str2;
    }

    @SimpleProperty(description = "Return the selected image format")
    public String Format() {
        return this.hZhaRgwkBZwejuAnnYABoWeuzwSnVTS6FhaE0jegMWisoVYsWwdasjmLDosamQJe;
    }
}
