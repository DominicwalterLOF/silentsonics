package com.airbnb.lottie.parser;

import android.util.JsonReader;
import com.airbnb.lottie.model.content.MergePaths;
import java.io.IOException;

class MergePathsParser {
    private MergePathsParser() {
    }

    static MergePaths parse(JsonReader jsonReader) throws IOException {
        MergePaths mergePaths;
        JsonReader reader = jsonReader;
        String name = null;
        MergePaths.MergePathsMode mode = null;
        boolean hidden = false;
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            boolean z = true;
            switch (nextName.hashCode()) {
                case 3324:
                    if (nextName.equals("hd")) {
                        z = true;
                        break;
                    }
                    break;
                case 3488:
                    if (nextName.equals("mm")) {
                        z = true;
                        break;
                    }
                    break;
                case 3519:
                    if (nextName.equals("nm")) {
                        z = false;
                        break;
                    }
                    break;
            }
            switch (z) {
                case false:
                    name = reader.nextString();
                    break;
                case true:
                    mode = MergePaths.MergePathsMode.forId(reader.nextInt());
                    break;
                case true:
                    hidden = reader.nextBoolean();
                    break;
                default:
                    reader.skipValue();
                    break;
            }
        }
        new MergePaths(name, mode, hidden);
        return mergePaths;
    }
}
