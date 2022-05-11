package gnu.kawa.xml;

import androidx.fragment.app.FragmentTransaction;
import gnu.lists.Consumer;
import gnu.lists.XConsumer;
import gnu.mapping.CallContext;
import gnu.mapping.Location;
import gnu.mapping.MethodProc;
import gnu.mapping.Values;
import gnu.xml.TextUtils;

public class CommentConstructor extends MethodProc {
    public static final CommentConstructor commentConstructor;

    public CommentConstructor() {
    }

    static {
        CommentConstructor commentConstructor2;
        new CommentConstructor();
        commentConstructor = commentConstructor2;
    }

    public int numArgs() {
        return FragmentTransaction.TRANSIT_FRAGMENT_OPEN;
    }

    public void apply(CallContext callContext) {
        StringBuffer stringBuffer;
        CallContext ctx = callContext;
        Consumer saved = ctx.consumer;
        XConsumer out = NodeConstructor.pushNodeContext(ctx);
        try {
            new StringBuffer();
            StringBuffer sbuf = stringBuffer;
            String endMarker = Location.UNBOUND;
            boolean first = true;
            int i = 0;
            while (true) {
                Object arg = ctx.getNextArg(endMarker);
                if (arg == endMarker) {
                    int len = sbuf.length();
                    char[] buf = new char[len];
                    sbuf.getChars(0, len, buf, 0);
                    out.writeComment(buf, 0, len);
                    NodeConstructor.popNodeContext(saved, ctx);
                    return;
                }
                if (arg instanceof Values) {
                    Values vals = (Values) arg;
                    int it = 0;
                    while (true) {
                        int nextPos = vals.nextPos(it);
                        it = nextPos;
                        if (nextPos == 0) {
                            break;
                        }
                        if (!first) {
                            StringBuffer append = sbuf.append(' ');
                        }
                        first = false;
                        TextUtils.stringValue(vals.getPosPrevious(it), sbuf);
                    }
                } else {
                    if (!first) {
                        StringBuffer append2 = sbuf.append(' ');
                    }
                    first = false;
                    TextUtils.stringValue(arg, sbuf);
                }
                i++;
            }
        } catch (Throwable th) {
            Throwable th2 = th;
            NodeConstructor.popNodeContext(saved, ctx);
            throw th2;
        }
    }
}
