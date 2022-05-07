package org.jose4j.lang;

public class ExceptionHelp {
    public ExceptionHelp() {
    }

    public static String toStringWithCauses(Throwable th) {
        StringBuilder sb;
        Throwable t = th;
        new StringBuilder();
        StringBuilder sb2 = sb;
        StringBuilder append = sb2.append(t);
        while (t.getCause() != null) {
            t = t.getCause();
            StringBuilder append2 = sb2.append("; caused by: ").append(t);
        }
        return sb2.toString();
    }

    public static String toStringWithCausesAndAbbreviatedStack(Throwable th, Class cls) {
        StringBuilder sb;
        Throwable t = th;
        Class stopAt = cls;
        new StringBuilder();
        StringBuilder sb2 = sb;
        boolean z = true;
        while (true) {
            boolean first = z;
            if (t == null) {
                return sb2.toString();
            }
            if (!first) {
                StringBuilder append = sb2.append("; caused by: ");
            }
            StringBuilder append2 = sb2.append(t).append(" at ");
            StackTraceElement[] arr$ = t.getStackTrace();
            int len$ = arr$.length;
            int i$ = 0;
            while (true) {
                if (i$ >= len$) {
                    break;
                }
                StackTraceElement ste = arr$[i$];
                if (ste.getClassName().equals(stopAt.getName())) {
                    StringBuilder append3 = sb2.append("...omitted...");
                    break;
                }
                StringBuilder append4 = sb2.append(ste).append("; ");
                i$++;
            }
            t = t.getCause();
            z = false;
        }
    }
}
