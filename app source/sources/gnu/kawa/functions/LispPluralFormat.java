package gnu.kawa.functions;

import gnu.math.IntNum;
import gnu.text.ReportFormat;
import java.io.IOException;
import java.io.Writer;
import java.text.FieldPosition;
import org.jose4j.jwk.EllipticCurveJsonWebKey;

/* compiled from: LispFormat */
class LispPluralFormat extends ReportFormat {
    boolean backup;
    boolean y;

    LispPluralFormat() {
    }

    public static LispPluralFormat getInstance(boolean backup2, boolean y2) {
        LispPluralFormat lispPluralFormat;
        new LispPluralFormat();
        LispPluralFormat fmt = lispPluralFormat;
        fmt.backup = backup2;
        fmt.y = y2;
        return fmt;
    }

    public int format(Object[] objArr, int i, Writer writer, FieldPosition fieldPosition) throws IOException {
        Object[] args = objArr;
        int start = i;
        Writer dst = writer;
        FieldPosition fieldPosition2 = fieldPosition;
        if (this.backup) {
            start--;
        }
        int i2 = start;
        int start2 = start + 1;
        boolean plural = args[i2] != IntNum.one();
        if (this.y) {
            print(dst, plural ? "ies" : EllipticCurveJsonWebKey.Y_MEMBER_NAME);
        } else if (plural) {
            dst.write(115);
        }
        return start2;
    }
}
