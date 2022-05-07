package com.google.appinventor.components.common;

import java.util.HashMap;
import java.util.Map;

public enum MapType implements OptionList<Integer> {
    ;
    
    private static final Map<Integer, MapType> hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = null;

    /* renamed from: hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME  reason: collision with other field name */
    private final Integer f15hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;

    static {
        Map<Integer, MapType> map;
        new HashMap();
        hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = map;
        MapType[] values = values();
        MapType[] mapTypeArr = values;
        int length = values.length;
        for (int i = 0; i < length; i++) {
            MapType mapType = mapTypeArr[i];
            MapType put = hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.put(mapType.toUnderlyingValue(), mapType);
        }
    }

    private MapType(Integer num) {
        String str = r8;
        int i = r9;
        this.f15hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = num;
    }

    public final Integer toUnderlyingValue() {
        return this.f15hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;
    }

    public static MapType fromUnderlyingValue(Integer num) {
        return hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.get(num);
    }
}
