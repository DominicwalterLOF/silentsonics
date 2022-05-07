package com.google.appinventor.components.common;

import java.util.HashMap;
import java.util.Map;

public enum NxtMotorMode implements OptionList<Integer> {
    ;
    
    private static final Map<Integer, NxtMotorMode> hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = null;
    private final int B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T;

    static {
        Map<Integer, NxtMotorMode> map;
        new HashMap();
        hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = map;
        NxtMotorMode[] values = values();
        NxtMotorMode[] nxtMotorModeArr = values;
        int length = values.length;
        for (int i = 0; i < length; i++) {
            NxtMotorMode nxtMotorMode = nxtMotorModeArr[i];
            NxtMotorMode put = hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.put(nxtMotorMode.toUnderlyingValue(), nxtMotorMode);
        }
    }

    private NxtMotorMode(int i) {
        String str = r8;
        int i2 = r9;
        this.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T = i;
    }

    public final Integer toUnderlyingValue() {
        return Integer.valueOf(this.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T);
    }

    public static NxtMotorMode fromUnderlyingValue(Integer num) {
        return hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.get(num);
    }
}
