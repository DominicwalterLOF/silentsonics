package com.airbnb.lottie.parser;

import android.graphics.Color;
import android.util.JsonReader;
import android.util.JsonToken;
import androidx.annotation.IntRange;
import com.airbnb.lottie.model.content.GradientColor;
import com.airbnb.lottie.utils.MiscUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GradientColorParser implements ValueParser<GradientColor> {
    private int colorPoints;

    public GradientColorParser(int colorPoints2) {
        this.colorPoints = colorPoints2;
    }

    public GradientColor parse(JsonReader jsonReader, float f) throws IOException {
        List<Float> list;
        GradientColor gradientColor;
        JsonReader reader = jsonReader;
        float f2 = f;
        new ArrayList<>();
        List<Float> array = list;
        boolean isArray = reader.peek() == JsonToken.BEGIN_ARRAY;
        if (isArray) {
            reader.beginArray();
        }
        while (reader.hasNext()) {
            boolean add = array.add(Float.valueOf((float) reader.nextDouble()));
        }
        if (isArray) {
            reader.endArray();
        }
        if (this.colorPoints == -1) {
            this.colorPoints = array.size() / 4;
        }
        float[] positions = new float[this.colorPoints];
        int[] colors = new int[this.colorPoints];
        int r = 0;
        int g = 0;
        int i = 0;
        while (true) {
            if (i < this.colorPoints * 4) {
                int colorIndex = i / 4;
                double value = (double) array.get(i).floatValue();
                switch (i % 4) {
                    case 0:
                        positions[colorIndex] = (float) value;
                        break;
                    case 1:
                        r = (int) (value * 255.0d);
                        break;
                    case 2:
                        g = (int) (value * 255.0d);
                        break;
                    case 3:
                        colors[colorIndex] = Color.argb(255, r, g, (int) (value * 255.0d));
                        break;
                }
                i++;
            } else {
                new GradientColor(positions, colors);
                GradientColor gradientColor2 = gradientColor;
                addOpacityStopsToGradientIfNeeded(gradientColor2, array);
                return gradientColor2;
            }
        }
    }

    private void addOpacityStopsToGradientIfNeeded(GradientColor gradientColor, List<Float> list) {
        GradientColor gradientColor2 = gradientColor;
        List<Float> array = list;
        int startIndex = this.colorPoints * 4;
        if (array.size() > startIndex) {
            int opacityStops = (array.size() - startIndex) / 2;
            double[] positions = new double[opacityStops];
            double[] opacities = new double[opacityStops];
            int j = 0;
            for (int i = startIndex; i < array.size(); i++) {
                if (i % 2 == 0) {
                    positions[j] = (double) array.get(i).floatValue();
                } else {
                    opacities[j] = (double) array.get(i).floatValue();
                    j++;
                }
            }
            for (int i2 = 0; i2 < gradientColor2.getSize(); i2++) {
                int color = gradientColor2.getColors()[i2];
                gradientColor2.getColors()[i2] = Color.argb(getOpacityAtPosition((double) gradientColor2.getPositions()[i2], positions, opacities), Color.red(color), Color.green(color), Color.blue(color));
            }
        }
    }

    @IntRange(from = 0, to = 255)
    private int getOpacityAtPosition(double d, double[] dArr, double[] dArr2) {
        double position = d;
        double[] positions = dArr;
        double[] opacities = dArr2;
        for (int i = 1; i < positions.length; i++) {
            double lastPosition = positions[i - 1];
            double thisPosition = positions[i];
            if (positions[i] >= position) {
                return (int) (255.0d * MiscUtils.lerp(opacities[i - 1], opacities[i], (position - lastPosition) / (thisPosition - lastPosition)));
            }
        }
        return (int) (255.0d * opacities[opacities.length - 1]);
    }
}
