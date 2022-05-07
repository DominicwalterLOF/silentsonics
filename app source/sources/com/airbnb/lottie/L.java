package com.airbnb.lottie;

import androidx.annotation.RestrictTo;
import androidx.core.os.TraceCompat;

@RestrictTo({RestrictTo.Scope.LIBRARY})
public class L {
    public static boolean DBG = false;
    private static final int MAX_DEPTH = 20;
    public static final String TAG = "LOTTIE";
    private static int depthPastMaxDepth = 0;
    private static String[] sections;
    private static long[] startTimeNs;
    private static int traceDepth = 0;
    private static boolean traceEnabled = false;

    public L() {
    }

    public static void setTraceEnabled(boolean z) {
        boolean enabled = z;
        if (traceEnabled != enabled) {
            traceEnabled = enabled;
            if (traceEnabled) {
                sections = new String[20];
                startTimeNs = new long[20];
            }
        }
    }

    public static void beginSection(String str) {
        String section = str;
        if (traceEnabled) {
            if (traceDepth == 20) {
                depthPastMaxDepth++;
                return;
            }
            sections[traceDepth] = section;
            startTimeNs[traceDepth] = System.nanoTime();
            TraceCompat.beginSection(section);
            traceDepth++;
        }
    }

    public static float endSection(String str) {
        Throwable th;
        StringBuilder sb;
        Throwable th2;
        String section = str;
        if (depthPastMaxDepth > 0) {
            depthPastMaxDepth--;
            return 0.0f;
        } else if (!traceEnabled) {
            return 0.0f;
        } else {
            traceDepth--;
            if (traceDepth == -1) {
                Throwable th3 = th2;
                new IllegalStateException("Can't end trace section. There are none.");
                throw th3;
            } else if (!section.equals(sections[traceDepth])) {
                Throwable th4 = th;
                new StringBuilder();
                new IllegalStateException(sb.append("Unbalanced trace call ").append(section).append(". Expected ").append(sections[traceDepth]).append(".").toString());
                throw th4;
            } else {
                TraceCompat.endSection();
                return ((float) (System.nanoTime() - startTimeNs[traceDepth])) / 1000000.0f;
            }
        }
    }
}
