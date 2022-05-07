package gnu.kawa.functions;

import gnu.bytecode.Type;
import gnu.mapping.Procedure;
import gnu.mapping.Procedure2;

public class Convert extends Procedure2 {
    public static final Convert as;

    public Convert() {
    }

    static {
        Convert convert;
        new Convert();
        as = convert;
        as.setName("as");
        as.setProperty(Procedure.validateApplyKey, "gnu.kawa.functions.CompileMisc:validateApplyConvert");
        Procedure.compilerKey.set(as, "*gnu.kawa.functions.CompileMisc:forConvert");
    }

    public static Convert getInstance() {
        return as;
    }

    public Object apply2(Object obj, Object obj2) {
        Type type;
        Object arg1 = obj;
        Object arg2 = obj2;
        if (arg1 instanceof Class) {
            type = Type.make((Class) arg1);
        } else {
            type = (Type) arg1;
        }
        return type.coerceFromObject(arg2);
    }
}
