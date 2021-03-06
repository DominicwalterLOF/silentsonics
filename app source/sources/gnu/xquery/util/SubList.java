package gnu.xquery.util;

import gnu.lists.Consumer;
import gnu.lists.Sequence;
import gnu.mapping.CallContext;
import gnu.mapping.MethodProc;
import gnu.mapping.Values;

public class SubList extends MethodProc {
    public static final SubList subList;

    public SubList() {
    }

    static {
        SubList subList2;
        new SubList();
        subList = subList2;
    }

    public int numArgs() {
        return 12290;
    }

    public static void subList(Object obj, double d, double d2, Consumer consumer) {
        int endPosition;
        Object seq = obj;
        double start = d;
        double end = d2;
        Consumer out = consumer;
        if (seq instanceof Values) {
            Values vals = (Values) seq;
            int n = 0;
            int i = 0;
            do {
                n++;
                if (((double) n) < start) {
                    i = vals.nextDataIndex(i);
                } else {
                    int startPosition = i;
                    while (true) {
                        endPosition = i;
                        int i2 = n;
                        n++;
                        if (((double) i2) >= end) {
                            break;
                        }
                        i = vals.nextDataIndex(i);
                        if (i < 0) {
                            break;
                        }
                    }
                    int consumeIRange = vals.consumeIRange(startPosition, endPosition, out);
                    return;
                }
            } while (i >= 0);
        } else if (start <= 1.0d && end >= 2.0d) {
            out.writeObject(seq);
        }
    }

    public void apply(CallContext callContext) {
        CallContext ctx = callContext;
        Consumer consumer = ctx.consumer;
        Object seq = ctx.getNextArg();
        double d1 = (double) Math.round(StringUtils.asDouble(ctx.getNextArg()));
        Object eof = Sequence.eofValue;
        Object arg2 = ctx.getNextArg(eof);
        ctx.lastArg();
        subList(seq, d1, d1 + (arg2 != eof ? (double) Math.round(StringUtils.asDouble(arg2)) : Double.POSITIVE_INFINITY), consumer);
    }
}
