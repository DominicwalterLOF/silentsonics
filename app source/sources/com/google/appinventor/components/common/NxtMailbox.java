package com.google.appinventor.components.common;

import java.util.HashMap;
import java.util.Map;

public enum NxtMailbox implements OptionList<Integer> {
    ;
    
    private static final Map<Integer, NxtMailbox> hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = null;

    /* renamed from: hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME  reason: collision with other field name */
    private int f17hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;

    /* renamed from: hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME  reason: collision with other field name */
    private Integer f18hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;

    static {
        Map<Integer, NxtMailbox> map;
        new HashMap();
        hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = map;
        NxtMailbox[] values = values();
        NxtMailbox[] nxtMailboxArr = values;
        int length = values.length;
        for (int i = 0; i < length; i++) {
            NxtMailbox nxtMailbox = nxtMailboxArr[i];
            NxtMailbox put = hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.put(nxtMailbox.toUnderlyingValue(), nxtMailbox);
        }
    }

    private NxtMailbox(Integer num, int i) {
        String str = r9;
        int i2 = r10;
        this.f18hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = num;
        this.f17hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = i;
    }

    public final Integer toUnderlyingValue() {
        return this.f18hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;
    }

    public final Integer toInt() {
        return Integer.valueOf(this.f17hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME);
    }

    public static NxtMailbox fromUnderlyingValue(Integer num) {
        return hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.get(num);
    }
}
