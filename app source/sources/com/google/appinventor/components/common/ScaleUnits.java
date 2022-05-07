package com.google.appinventor.components.common;

import java.util.HashMap;
import java.util.Map;

public enum ScaleUnits implements OptionList<Integer> {
    ;
    
    private static final Map<Integer, ScaleUnits> hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = null;

    /* renamed from: hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME  reason: collision with other field name */
    private final Integer f31hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;

    static {
        Map<Integer, ScaleUnits> map;
        new HashMap();
        hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = map;
        ScaleUnits[] values = values();
        ScaleUnits[] scaleUnitsArr = values;
        int length = values.length;
        for (int i = 0; i < length; i++) {
            ScaleUnits scaleUnits = scaleUnitsArr[i];
            ScaleUnits put = hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.put(scaleUnits.toUnderlyingValue(), scaleUnits);
        }
    }

    private ScaleUnits(Integer num) {
        String str = r8;
        int i = r9;
        this.f31hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = num;
    }

    public final Integer toUnderlyingValue() {
        return this.f31hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;
    }

    public static ScaleUnits fromUnderlyingValue(Integer num) {
        return hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.get(num);
    }
}
