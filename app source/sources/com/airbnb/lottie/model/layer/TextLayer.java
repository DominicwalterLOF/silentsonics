package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.TextDelegate;
import com.airbnb.lottie.animation.content.ContentGroup;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.TextKeyframeAnimation;
import com.airbnb.lottie.model.DocumentData;
import com.airbnb.lottie.model.Font;
import com.airbnb.lottie.model.FontCharacter;
import com.airbnb.lottie.model.content.ShapeGroup;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class TextLayer extends BaseLayer {
    private final LongSparseArray<String> codePointCache;
    @Nullable
    private BaseKeyframeAnimation<Integer, Integer> colorAnimation;
    private final LottieComposition composition;
    private final Map<FontCharacter, List<ContentGroup>> contentsForCharacter;
    private final Paint fillPaint;
    private final LottieDrawable lottieDrawable;
    private final Matrix matrix;
    private final RectF rectF;
    private final StringBuilder stringBuilder;
    @Nullable
    private BaseKeyframeAnimation<Integer, Integer> strokeColorAnimation;
    private final Paint strokePaint;
    @Nullable
    private BaseKeyframeAnimation<Float, Float> strokeWidthAnimation;
    private final TextKeyframeAnimation textAnimation;
    @Nullable
    private BaseKeyframeAnimation<Float, Float> trackingAnimation;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    TextLayer(com.airbnb.lottie.LottieDrawable r11, com.airbnb.lottie.model.layer.Layer r12) {
        /*
            r10 = this;
            r0 = r10
            r1 = r11
            r2 = r12
            r4 = r0
            r5 = r1
            r6 = r2
            r4.<init>(r5, r6)
            r4 = r0
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r9 = r5
            r5 = r9
            r6 = r9
            r7 = 2
            r6.<init>(r7)
            r4.stringBuilder = r5
            r4 = r0
            android.graphics.RectF r5 = new android.graphics.RectF
            r9 = r5
            r5 = r9
            r6 = r9
            r6.<init>()
            r4.rectF = r5
            r4 = r0
            android.graphics.Matrix r5 = new android.graphics.Matrix
            r9 = r5
            r5 = r9
            r6 = r9
            r6.<init>()
            r4.matrix = r5
            r4 = r0
            com.airbnb.lottie.model.layer.TextLayer$1 r5 = new com.airbnb.lottie.model.layer.TextLayer$1
            r9 = r5
            r5 = r9
            r6 = r9
            r7 = r0
            r8 = 1
            r6.<init>(r7, r8)
            r4.fillPaint = r5
            r4 = r0
            com.airbnb.lottie.model.layer.TextLayer$2 r5 = new com.airbnb.lottie.model.layer.TextLayer$2
            r9 = r5
            r5 = r9
            r6 = r9
            r7 = r0
            r8 = 1
            r6.<init>(r7, r8)
            r4.strokePaint = r5
            r4 = r0
            java.util.HashMap r5 = new java.util.HashMap
            r9 = r5
            r5 = r9
            r6 = r9
            r6.<init>()
            r4.contentsForCharacter = r5
            r4 = r0
            androidx.collection.LongSparseArray r5 = new androidx.collection.LongSparseArray
            r9 = r5
            r5 = r9
            r6 = r9
            r6.<init>()
            r4.codePointCache = r5
            r4 = r0
            r5 = r1
            r4.lottieDrawable = r5
            r4 = r0
            r5 = r2
            com.airbnb.lottie.LottieComposition r5 = r5.getComposition()
            r4.composition = r5
            r4 = r0
            r5 = r2
            com.airbnb.lottie.model.animatable.AnimatableTextFrame r5 = r5.getText()
            com.airbnb.lottie.animation.keyframe.TextKeyframeAnimation r5 = r5.createAnimation()
            r4.textAnimation = r5
            r4 = r0
            com.airbnb.lottie.animation.keyframe.TextKeyframeAnimation r4 = r4.textAnimation
            r5 = r0
            r4.addUpdateListener(r5)
            r4 = r0
            r5 = r0
            com.airbnb.lottie.animation.keyframe.TextKeyframeAnimation r5 = r5.textAnimation
            r4.addAnimation(r5)
            r4 = r2
            com.airbnb.lottie.model.animatable.AnimatableTextProperties r4 = r4.getTextProperties()
            r3 = r4
            r4 = r3
            if (r4 == 0) goto L_0x00a7
            r4 = r3
            com.airbnb.lottie.model.animatable.AnimatableColorValue r4 = r4.color
            if (r4 == 0) goto L_0x00a7
            r4 = r0
            r5 = r3
            com.airbnb.lottie.model.animatable.AnimatableColorValue r5 = r5.color
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation r5 = r5.createAnimation()
            r4.colorAnimation = r5
            r4 = r0
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Integer, java.lang.Integer> r4 = r4.colorAnimation
            r5 = r0
            r4.addUpdateListener(r5)
            r4 = r0
            r5 = r0
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Integer, java.lang.Integer> r5 = r5.colorAnimation
            r4.addAnimation(r5)
        L_0x00a7:
            r4 = r3
            if (r4 == 0) goto L_0x00c7
            r4 = r3
            com.airbnb.lottie.model.animatable.AnimatableColorValue r4 = r4.stroke
            if (r4 == 0) goto L_0x00c7
            r4 = r0
            r5 = r3
            com.airbnb.lottie.model.animatable.AnimatableColorValue r5 = r5.stroke
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation r5 = r5.createAnimation()
            r4.strokeColorAnimation = r5
            r4 = r0
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Integer, java.lang.Integer> r4 = r4.strokeColorAnimation
            r5 = r0
            r4.addUpdateListener(r5)
            r4 = r0
            r5 = r0
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Integer, java.lang.Integer> r5 = r5.strokeColorAnimation
            r4.addAnimation(r5)
        L_0x00c7:
            r4 = r3
            if (r4 == 0) goto L_0x00e7
            r4 = r3
            com.airbnb.lottie.model.animatable.AnimatableFloatValue r4 = r4.strokeWidth
            if (r4 == 0) goto L_0x00e7
            r4 = r0
            r5 = r3
            com.airbnb.lottie.model.animatable.AnimatableFloatValue r5 = r5.strokeWidth
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation r5 = r5.createAnimation()
            r4.strokeWidthAnimation = r5
            r4 = r0
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Float, java.lang.Float> r4 = r4.strokeWidthAnimation
            r5 = r0
            r4.addUpdateListener(r5)
            r4 = r0
            r5 = r0
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Float, java.lang.Float> r5 = r5.strokeWidthAnimation
            r4.addAnimation(r5)
        L_0x00e7:
            r4 = r3
            if (r4 == 0) goto L_0x0107
            r4 = r3
            com.airbnb.lottie.model.animatable.AnimatableFloatValue r4 = r4.tracking
            if (r4 == 0) goto L_0x0107
            r4 = r0
            r5 = r3
            com.airbnb.lottie.model.animatable.AnimatableFloatValue r5 = r5.tracking
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation r5 = r5.createAnimation()
            r4.trackingAnimation = r5
            r4 = r0
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Float, java.lang.Float> r4 = r4.trackingAnimation
            r5 = r0
            r4.addUpdateListener(r5)
            r4 = r0
            r5 = r0
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Float, java.lang.Float> r5 = r5.trackingAnimation
            r4.addAnimation(r5)
        L_0x0107:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.model.layer.TextLayer.<init>(com.airbnb.lottie.LottieDrawable, com.airbnb.lottie.model.layer.Layer):void");
    }

    public void getBounds(RectF rectF2, Matrix parentMatrix, boolean applyParents) {
        RectF outBounds = rectF2;
        super.getBounds(outBounds, parentMatrix, applyParents);
        outBounds.set(0.0f, 0.0f, (float) this.composition.getBounds().width(), (float) this.composition.getBounds().height());
    }

    /* access modifiers changed from: package-private */
    public void drawLayer(Canvas canvas, Matrix matrix2, int i) {
        Canvas canvas2 = canvas;
        Matrix parentMatrix = matrix2;
        int i2 = i;
        int save = canvas2.save();
        if (!this.lottieDrawable.useTextGlyphs()) {
            canvas2.setMatrix(parentMatrix);
        }
        DocumentData documentData = (DocumentData) this.textAnimation.getValue();
        Font font = this.composition.getFonts().get(documentData.fontName);
        if (font == null) {
            canvas2.restore();
            return;
        }
        if (this.colorAnimation != null) {
            this.fillPaint.setColor(this.colorAnimation.getValue().intValue());
        } else {
            this.fillPaint.setColor(documentData.color);
        }
        if (this.strokeColorAnimation != null) {
            this.strokePaint.setColor(this.strokeColorAnimation.getValue().intValue());
        } else {
            this.strokePaint.setColor(documentData.strokeColor);
        }
        int alpha = ((this.transform.getOpacity() == null ? 100 : this.transform.getOpacity().getValue().intValue()) * 255) / 100;
        this.fillPaint.setAlpha(alpha);
        this.strokePaint.setAlpha(alpha);
        if (this.strokeWidthAnimation != null) {
            this.strokePaint.setStrokeWidth(this.strokeWidthAnimation.getValue().floatValue());
        } else {
            this.strokePaint.setStrokeWidth((float) (documentData.strokeWidth * ((double) Utils.dpScale()) * ((double) Utils.getScale(parentMatrix))));
        }
        if (this.lottieDrawable.useTextGlyphs()) {
            drawTextGlyphs(documentData, parentMatrix, font, canvas2);
        } else {
            drawTextWithFont(documentData, font, parentMatrix, canvas2);
        }
        canvas2.restore();
    }

    private void drawTextGlyphs(DocumentData documentData, Matrix matrix2, Font font, Canvas canvas) {
        DocumentData documentData2 = documentData;
        Matrix parentMatrix = matrix2;
        Font font2 = font;
        Canvas canvas2 = canvas;
        float fontScale = ((float) documentData2.size) / 100.0f;
        float parentScale = Utils.getScale(parentMatrix);
        String text = documentData2.text;
        float lineHeight = ((float) documentData2.lineHeight) * Utils.dpScale();
        List<String> textLines = getTextLines(text);
        int textLineCount = textLines.size();
        for (int l = 0; l < textLineCount; l++) {
            String textLine = textLines.get(l);
            float textLineWidth = getTextLineWidthForGlyphs(textLine, font2, fontScale, parentScale);
            int save = canvas2.save();
            applyJustification(documentData2.justification, canvas2, textLineWidth);
            canvas2.translate(0.0f, (((float) l) * lineHeight) - ((((float) (textLineCount - 1)) * lineHeight) / 2.0f));
            drawGlyphTextLine(textLine, documentData2, parentMatrix, font2, canvas2, parentScale, fontScale);
            canvas2.restore();
        }
    }

    private void drawGlyphTextLine(String str, DocumentData documentData, Matrix matrix2, Font font, Canvas canvas, float f, float f2) {
        String text = str;
        DocumentData documentData2 = documentData;
        Matrix parentMatrix = matrix2;
        Font font2 = font;
        Canvas canvas2 = canvas;
        float parentScale = f;
        float fontScale = f2;
        for (int i = 0; i < text.length(); i++) {
            FontCharacter character = this.composition.getCharacters().get(FontCharacter.hashFor(text.charAt(i), font2.getFamily(), font2.getStyle()));
            if (character != null) {
                drawCharacterAsGlyph(character, parentMatrix, fontScale, documentData2, canvas2);
                float tx = ((float) character.getWidth()) * fontScale * Utils.dpScale() * parentScale;
                float tracking = ((float) documentData2.tracking) / 10.0f;
                if (this.trackingAnimation != null) {
                    tracking += this.trackingAnimation.getValue().floatValue();
                }
                canvas2.translate(tx + (tracking * parentScale), 0.0f);
            }
        }
    }

    private void drawTextWithFont(DocumentData documentData, Font font, Matrix matrix2, Canvas canvas) {
        DocumentData documentData2 = documentData;
        Font font2 = font;
        Matrix parentMatrix = matrix2;
        Canvas canvas2 = canvas;
        float parentScale = Utils.getScale(parentMatrix);
        Typeface typeface = this.lottieDrawable.getTypeface(font2.getFamily(), font2.getStyle());
        if (typeface != null) {
            String text = documentData2.text;
            TextDelegate textDelegate = this.lottieDrawable.getTextDelegate();
            if (textDelegate != null) {
                text = textDelegate.getTextInternal(text);
            }
            Typeface typeface2 = this.fillPaint.setTypeface(typeface);
            this.fillPaint.setTextSize((float) (documentData2.size * ((double) Utils.dpScale())));
            Typeface typeface3 = this.strokePaint.setTypeface(this.fillPaint.getTypeface());
            this.strokePaint.setTextSize(this.fillPaint.getTextSize());
            float lineHeight = ((float) documentData2.lineHeight) * Utils.dpScale();
            List<String> textLines = getTextLines(text);
            int textLineCount = textLines.size();
            for (int l = 0; l < textLineCount; l++) {
                String textLine = textLines.get(l);
                applyJustification(documentData2.justification, canvas2, this.strokePaint.measureText(textLine));
                canvas2.translate(0.0f, (((float) l) * lineHeight) - ((((float) (textLineCount - 1)) * lineHeight) / 2.0f));
                drawFontTextLine(textLine, documentData2, canvas2, parentScale);
                canvas2.setMatrix(parentMatrix);
            }
        }
    }

    private List<String> getTextLines(String text) {
        return Arrays.asList(text.replaceAll("\r\n", "\r").replaceAll("\n", "\r").split("\r"));
    }

    private void drawFontTextLine(String str, DocumentData documentData, Canvas canvas, float f) {
        String text = str;
        DocumentData documentData2 = documentData;
        Canvas canvas2 = canvas;
        float parentScale = f;
        int i = 0;
        while (i < text.length()) {
            String charString = codePointToString(text, i);
            i += charString.length();
            drawCharacterFromFont(charString, documentData2, canvas2);
            float charWidth = this.fillPaint.measureText(charString, 0, 1);
            float tracking = ((float) documentData2.tracking) / 10.0f;
            if (this.trackingAnimation != null) {
                tracking += this.trackingAnimation.getValue().floatValue();
            }
            canvas2.translate(charWidth + (tracking * parentScale), 0.0f);
        }
    }

    private float getTextLineWidthForGlyphs(String str, Font font, float f, float f2) {
        String textLine = str;
        Font font2 = font;
        float fontScale = f;
        float parentScale = f2;
        float textLineWidth = 0.0f;
        for (int i = 0; i < textLine.length(); i++) {
            FontCharacter character = this.composition.getCharacters().get(FontCharacter.hashFor(textLine.charAt(i), font2.getFamily(), font2.getStyle()));
            if (character != null) {
                textLineWidth = (float) (((double) textLineWidth) + (character.getWidth() * ((double) fontScale) * ((double) Utils.dpScale()) * ((double) parentScale)));
            }
        }
        return textLineWidth;
    }

    private void applyJustification(DocumentData.Justification justification, Canvas canvas, float f) {
        Canvas canvas2 = canvas;
        float textLineWidth = f;
        switch (justification) {
            case RIGHT_ALIGN:
                canvas2.translate(-textLineWidth, 0.0f);
                return;
            case CENTER:
                canvas2.translate((-textLineWidth) / 2.0f, 0.0f);
                return;
            default:
                return;
        }
    }

    private void drawCharacterAsGlyph(FontCharacter character, Matrix matrix2, float f, DocumentData documentData, Canvas canvas) {
        Matrix parentMatrix = matrix2;
        float fontScale = f;
        DocumentData documentData2 = documentData;
        Canvas canvas2 = canvas;
        List<ContentGroup> contentGroups = getContentsForCharacter(character);
        for (int j = 0; j < contentGroups.size(); j++) {
            Path path = contentGroups.get(j).getPath();
            path.computeBounds(this.rectF, false);
            this.matrix.set(parentMatrix);
            boolean preTranslate = this.matrix.preTranslate(0.0f, ((float) (-documentData2.baselineShift)) * Utils.dpScale());
            boolean preScale = this.matrix.preScale(fontScale, fontScale);
            path.transform(this.matrix);
            if (documentData2.strokeOverFill) {
                drawGlyph(path, this.fillPaint, canvas2);
                drawGlyph(path, this.strokePaint, canvas2);
            } else {
                drawGlyph(path, this.strokePaint, canvas2);
                drawGlyph(path, this.fillPaint, canvas2);
            }
        }
    }

    private void drawGlyph(Path path, Paint paint, Canvas canvas) {
        Path path2 = path;
        Paint paint2 = paint;
        Canvas canvas2 = canvas;
        if (paint2.getColor() != 0) {
            if (paint2.getStyle() != Paint.Style.STROKE || paint2.getStrokeWidth() != 0.0f) {
                canvas2.drawPath(path2, paint2);
            }
        }
    }

    private void drawCharacterFromFont(String str, DocumentData documentData, Canvas canvas) {
        String character = str;
        Canvas canvas2 = canvas;
        if (documentData.strokeOverFill) {
            drawCharacter(character, this.fillPaint, canvas2);
            drawCharacter(character, this.strokePaint, canvas2);
            return;
        }
        drawCharacter(character, this.strokePaint, canvas2);
        drawCharacter(character, this.fillPaint, canvas2);
    }

    private void drawCharacter(String str, Paint paint, Canvas canvas) {
        String character = str;
        Paint paint2 = paint;
        Canvas canvas2 = canvas;
        if (paint2.getColor() != 0) {
            if (paint2.getStyle() != Paint.Style.STROKE || paint2.getStrokeWidth() != 0.0f) {
                canvas2.drawText(character, 0, character.length(), 0.0f, 0.0f, paint2);
            }
        }
    }

    private List<ContentGroup> getContentsForCharacter(FontCharacter fontCharacter) {
        List<ContentGroup> list;
        Object obj;
        FontCharacter character = fontCharacter;
        if (this.contentsForCharacter.containsKey(character)) {
            return this.contentsForCharacter.get(character);
        }
        List<ShapeGroup> shapes = character.getShapes();
        int size = shapes.size();
        new ArrayList(size);
        List<ContentGroup> contents = list;
        for (int i = 0; i < size; i++) {
            new ContentGroup(this.lottieDrawable, this, shapes.get(i));
            boolean add = contents.add(obj);
        }
        List<ContentGroup> put = this.contentsForCharacter.put(character, contents);
        return contents;
    }

    private String codePointToString(String str, int i) {
        String text = str;
        int startIndex = i;
        int firstCodePoint = text.codePointAt(startIndex);
        int key = firstCodePoint;
        int index = startIndex + Character.charCount(firstCodePoint);
        while (index < text.length()) {
            int nextCodePoint = text.codePointAt(index);
            if (!isModifier(nextCodePoint)) {
                break;
            }
            index += Character.charCount(nextCodePoint);
            key = (key * 31) + nextCodePoint;
        }
        if (this.codePointCache.containsKey((long) key)) {
            return this.codePointCache.get((long) key);
        }
        this.stringBuilder.setLength(0);
        int i2 = startIndex;
        while (true) {
            int i3 = i2;
            if (i3 < index) {
                int codePoint = text.codePointAt(i3);
                StringBuilder appendCodePoint = this.stringBuilder.appendCodePoint(codePoint);
                i2 = i3 + Character.charCount(codePoint);
            } else {
                String str2 = this.stringBuilder.toString();
                this.codePointCache.put((long) key, str2);
                return str2;
            }
        }
    }

    private boolean isModifier(int i) {
        int codePoint = i;
        return Character.getType(codePoint) == 16 || Character.getType(codePoint) == 27 || Character.getType(codePoint) == 6 || Character.getType(codePoint) == 28 || Character.getType(codePoint) == 19;
    }

    public <T> void addValueCallback(T t, @Nullable LottieValueCallback<T> lottieValueCallback) {
        T property = t;
        LottieValueCallback<T> callback = lottieValueCallback;
        super.addValueCallback(property, callback);
        if (property == LottieProperty.COLOR && this.colorAnimation != null) {
            this.colorAnimation.setValueCallback(callback);
        } else if (property == LottieProperty.STROKE_COLOR && this.strokeColorAnimation != null) {
            this.strokeColorAnimation.setValueCallback(callback);
        } else if (property == LottieProperty.STROKE_WIDTH && this.strokeWidthAnimation != null) {
            this.strokeWidthAnimation.setValueCallback(callback);
        } else if (property == LottieProperty.TEXT_TRACKING && this.trackingAnimation != null) {
            this.trackingAnimation.setValueCallback(callback);
        }
    }
}
