package com.google.appinventor.components.common;

import java.util.HashMap;
import java.util.Map;

public enum NxtSensorMode implements OptionList<Integer> {
    ;
    
    private static final Map<Integer, NxtSensorMode> hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = null;
    private final int B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T;

    static {
        Map<Integer, NxtSensorMode> map;
        new HashMap();
        hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = map;
        NxtSensorMode[] values = values();
        NxtSensorMode[] nxtSensorModeArr = values;
        int length = values.length;
        for (int i = 0; i < length; i++) {
            NxtSensorMode nxtSensorMode = nxtSensorModeArr[i];
            NxtSensorMode put = hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.put(nxtSensorMode.toUnderlyingValue(), nxtSensorMode);
        }
    }

    private NxtSensorMode(int i) {
        String str = r8;
        int i2 = r9;
        this.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T = i;
    }

    public final Integer toUnderlyingValue() {
        return Integer.valueOf(this.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T);
    }

    public static NxtSensorMode fromUnderlyingValue(Integer num) {
        return hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.get(num);
    }
}
