package gnu.xquery.util;

import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.Target;
import gnu.kawa.functions.Convert;
import gnu.kawa.reflect.OccurrenceType;
import gnu.kawa.xml.XDataType;
import gnu.mapping.Procedure;
import gnu.mapping.Values;

public class CastAs extends Convert {
    public static final CastAs castAs;

    static {
        CastAs castAs2;
        new CastAs();
        castAs = castAs2;
    }

    public CastAs() {
        setProperty(Procedure.validateApplyKey, "gnu.xquery.util.CompileMisc:validateApplyCastAs");
    }

    public Object apply2(Object obj, Object obj2) {
        Throwable th;
        StringBuilder sb;
        Values values;
        Object arg1 = obj;
        Object arg2 = obj2;
        Type type = (Type) arg1;
        if (type instanceof XDataType) {
            return ((XDataType) type).cast(arg2);
        }
        if (type instanceof OccurrenceType) {
            OccurrenceType occ = (OccurrenceType) type;
            Type base = occ.getBase();
            if (base instanceof XDataType) {
                int min = occ.minOccurs();
                int max = occ.maxOccurs();
                if (arg2 instanceof Values) {
                    if (arg2 == Values.empty && min == 0) {
                        return arg2;
                    }
                    Values vals = (Values) arg2;
                    int pos = vals.startPos();
                    int n = 0;
                    new Values();
                    Values result = values;
                    while (true) {
                        pos = vals.nextPos(pos);
                        if (pos == 0) {
                            break;
                        }
                        result.writeObject(((XDataType) base).cast(vals.getPosPrevious(pos)));
                        n++;
                    }
                    if (n >= min && (max < 0 || n <= max)) {
                        return result.canonicalize();
                    }
                } else if (min <= 1 && max != 0) {
                    return ((XDataType) base).cast(arg2);
                }
                Throwable th2 = th;
                new StringBuilder();
                new ClassCastException(sb.append("cannot cast ").append(arg2).append(" to ").append(arg1).toString());
                throw th2;
            }
        }
        return super.apply2(arg1, arg2);
    }

    public void compile(ApplyExp exp, Compilation comp, Target target) {
        ApplyExp.compile(exp, comp, target);
    }
}
