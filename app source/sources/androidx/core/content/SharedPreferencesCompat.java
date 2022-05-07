package androidx.core.content;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;

@Deprecated
public final class SharedPreferencesCompat {

    @Deprecated
    public static final class EditorCompat {
        private static EditorCompat sInstance;
        private final Helper mHelper;

        private static class Helper {
            Helper() {
            }

            public void apply(@NonNull SharedPreferences.Editor editor) {
                SharedPreferences.Editor editor2 = editor;
                try {
                    editor2.apply();
                } catch (AbstractMethodError e) {
                    AbstractMethodError abstractMethodError = e;
                    boolean commit = editor2.commit();
                }
            }
        }

        private EditorCompat() {
            Helper helper;
            new Helper();
            this.mHelper = helper;
        }

        @Deprecated
        public static EditorCompat getInstance() {
            EditorCompat editorCompat;
            if (sInstance == null) {
                new EditorCompat();
                sInstance = editorCompat;
            }
            return sInstance;
        }

        @Deprecated
        public void apply(@NonNull SharedPreferences.Editor editor) {
            this.mHelper.apply(editor);
        }
    }

    private SharedPreferencesCompat() {
    }
}
