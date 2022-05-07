package com.google.appinventor.components.runtime;

import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;
import com.google.appinventor.components.annotations.Asset;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.annotations.UsesPermissions;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.util.MediaUtil;

@SimpleObject
@DesignerComponent(category = ComponentCategory.ANIMATION, description = "<p>A 'sprite' that can be placed on a <code>Canvas</code>, where it can react to touches and drags, interact with other sprites (<code>Ball</code>s and other <code>ImageSprite</code>s) and the edge of the Canvas, and move according to its property values.  Its appearance is that of the image specified in its <code>Picture</code> property (unless its <code>Visible</code> property is <code>False</code>).</p> <p>To have an <code>ImageSprite</code> move 10 pixels to the left every 1000 milliseconds (one second), for example, you would set the <code>Speed</code> property to 10 [pixels], the <code>Interval</code> property to 1000 [milliseconds], the <code>Heading</code> property to 180 [degrees], and the <code>Enabled</code> property to <code>True</code>.  A sprite whose <code>Rotates</code> property is <code>True</code> will rotate its image as the sprite's <code>Heading</code> changes.  Checking for collisions with a rotated sprite currently checks the sprite's unrotated position so that collision checking will be inaccurate for tall narrow or short wide sprites that are rotated.  Any of the sprite properties can be changed at any time under program control.</p> ", version = 8)
@UsesPermissions({"android.permission.INTERNET"})
public class ImageSprite extends Sprite {
    private BitmapDrawable B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T;
    private int OAUx2n1xMKzXfjTj5DCb1XzhEYBfmj7wvFgBr5BSQUCav1CowwMbt2iKFNQwGzpG = -1;
    private final Form form;
    private int joZZFkzhsHdrkrd2PnThIkJfOfuAzcTTVQ9uzSCPDoVjmnvQXSliAgIhSj7yEkSN = -1;
    private boolean pgq50Ta8BOwqZ1x44UiPoTcDoRPiNHTTIb3Jgmceok7eFp2gi0sO4JRUukOMKqHH;
    private String picturePath = "";

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ImageSprite(com.google.appinventor.components.runtime.ComponentContainer r5) {
        /*
            r4 = this;
            r0 = r4
            r1 = r5
            r2 = r0
            r3 = r1
            r2.<init>(r3)
            r2 = r0
            r3 = -1
            r2.joZZFkzhsHdrkrd2PnThIkJfOfuAzcTTVQ9uzSCPDoVjmnvQXSliAgIhSj7yEkSN = r3
            r2 = r0
            r3 = -1
            r2.OAUx2n1xMKzXfjTj5DCb1XzhEYBfmj7wvFgBr5BSQUCav1CowwMbt2iKFNQwGzpG = r3
            r2 = r0
            java.lang.String r3 = ""
            r2.picturePath = r3
            r2 = r0
            r3 = r1
            com.google.appinventor.components.runtime.Form r3 = r3.$form()
            r2.form = r3
            r2 = r0
            r3 = 1
            r2.pgq50Ta8BOwqZ1x44UiPoTcDoRPiNHTTIb3Jgmceok7eFp2gi0sO4JRUukOMKqHH = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.appinventor.components.runtime.ImageSprite.<init>(com.google.appinventor.components.runtime.ComponentContainer):void");
    }

    public void onDraw(Canvas canvas) {
        Canvas canvas2 = canvas;
        if (this.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T != null && this.visible) {
            int round = (int) (((float) Math.round(this.xLeft)) * this.form.deviceDensity());
            int round2 = (int) (((float) Math.round(this.yTop)) * this.form.deviceDensity());
            int Width = (int) (((float) Width()) * this.form.deviceDensity());
            int Height = (int) (((float) Height()) * this.form.deviceDensity());
            this.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T.setBounds(round, round2, round + Width, round2 + Height);
            if (!this.pgq50Ta8BOwqZ1x44UiPoTcDoRPiNHTTIb3Jgmceok7eFp2gi0sO4JRUukOMKqHH) {
                this.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T.draw(canvas2);
                return;
            }
            int save = canvas2.save();
            canvas2.rotate((float) (-Heading()), (float) (round + (Width / 2)), (float) (round2 + (Height / 2)));
            this.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T.draw(canvas2);
            canvas2.restore();
        }
    }

    @SimpleProperty(category = PropertyCategory.APPEARANCE, description = "The picture that determines the ImageSprite's appearance.")
    public String Picture() {
        return this.picturePath;
    }

    @DesignerProperty(defaultValue = "", editorType = "image_asset")
    @SimpleProperty
    public void Picture(@Asset String str) {
        StringBuilder sb;
        String str2 = str;
        this.picturePath = str2 == null ? "" : str2;
        try {
            this.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T = MediaUtil.getBitmapDrawable(this.form, this.picturePath);
        } catch (Exception e) {
            new StringBuilder("Unable to load ");
            int e2 = Log.e("ImageSprite", sb.append(this.picturePath).toString());
            this.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T = null;
        }
        registerChange();
    }

    @SimpleProperty(description = "The height of the ImageSprite in pixels.")
    public int Height() {
        if (this.OAUx2n1xMKzXfjTj5DCb1XzhEYBfmj7wvFgBr5BSQUCav1CowwMbt2iKFNQwGzpG != -1 && this.OAUx2n1xMKzXfjTj5DCb1XzhEYBfmj7wvFgBr5BSQUCav1CowwMbt2iKFNQwGzpG != -2 && this.OAUx2n1xMKzXfjTj5DCb1XzhEYBfmj7wvFgBr5BSQUCav1CowwMbt2iKFNQwGzpG > -1000) {
            return this.OAUx2n1xMKzXfjTj5DCb1XzhEYBfmj7wvFgBr5BSQUCav1CowwMbt2iKFNQwGzpG;
        }
        if (this.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T == null) {
            return 0;
        }
        return (int) (((float) this.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T.getBitmap().getHeight()) / this.form.deviceDensity());
    }

    @SimpleProperty
    public void Height(int i) {
        this.OAUx2n1xMKzXfjTj5DCb1XzhEYBfmj7wvFgBr5BSQUCav1CowwMbt2iKFNQwGzpG = i;
        registerChange();
    }

    public void HeightPercent(int i) {
    }

    @SimpleProperty(description = "The width of the ImageSprite in pixels.")
    public int Width() {
        if (this.joZZFkzhsHdrkrd2PnThIkJfOfuAzcTTVQ9uzSCPDoVjmnvQXSliAgIhSj7yEkSN != -1 && this.joZZFkzhsHdrkrd2PnThIkJfOfuAzcTTVQ9uzSCPDoVjmnvQXSliAgIhSj7yEkSN != -2 && this.joZZFkzhsHdrkrd2PnThIkJfOfuAzcTTVQ9uzSCPDoVjmnvQXSliAgIhSj7yEkSN > -1000) {
            return this.joZZFkzhsHdrkrd2PnThIkJfOfuAzcTTVQ9uzSCPDoVjmnvQXSliAgIhSj7yEkSN;
        }
        if (this.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T == null) {
            return 0;
        }
        return (int) (((float) this.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T.getBitmap().getWidth()) / this.form.deviceDensity());
    }

    @SimpleProperty
    public void Width(int i) {
        this.joZZFkzhsHdrkrd2PnThIkJfOfuAzcTTVQ9uzSCPDoVjmnvQXSliAgIhSj7yEkSN = i;
        registerChange();
    }

    public void WidthPercent(int i) {
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "Whether the image should rotate to match the ImageSprite's heading. The sprite rotates around its centerpoint.")
    public boolean Rotates() {
        return this.pgq50Ta8BOwqZ1x44UiPoTcDoRPiNHTTIb3Jgmceok7eFp2gi0sO4JRUukOMKqHH;
    }

    @DesignerProperty(defaultValue = "True", editorType = "boolean")
    @SimpleProperty
    public void Rotates(boolean z) {
        this.pgq50Ta8BOwqZ1x44UiPoTcDoRPiNHTTIb3Jgmceok7eFp2gi0sO4JRUukOMKqHH = z;
        registerChange();
    }

    @SimpleProperty(description = "The horizontal coordinate of the left edge of the ImageSprite, increasing as the ImageSprite moves right.")
    public double X() {
        return super.X();
    }

    @SimpleProperty(description = "The vertical coordinate of the top edge of the ImageSprite, increasing as the ImageSprite moves down.")
    public double Y() {
        return super.Y();
    }

    @SimpleFunction(description = "Moves the ImageSprite so that its left top corner is at the specfied x and y coordinates.")
    public void MoveTo(double d, double d2) {
        super.MoveTo(d, d2);
    }
}
