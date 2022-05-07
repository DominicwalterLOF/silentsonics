package com.google.appinventor.components.runtime.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameInstance {
    private String AQ1MpycqIZ4lZp4zU5ZgAcOeQWFjlY37qDhSA6zNIQj8WisYY7lHQNjV6h6Xnju0;
    private String GqEao9b9YWjqJfm0U8G9R1Onjg5BiUMTCoMqRIVO602C1plqYKUzgjm5B5hvlTms = "";
    private List<String> IhlDYVsQmgat6F3NXqRok975lHQlAvyJICX3QHDdE383xYIGTapMORiCm1KjyWCi;
    private Map<String, String> LYVRHQlR5uMq9RmVQLgPQwQp4HVKuBDt7Jnpu0jTztYClgnk53NSpkUmjjPPbYn;

    public GameInstance(String str) {
        List<String> list;
        Map<String, String> map;
        new ArrayList(0);
        this.IhlDYVsQmgat6F3NXqRok975lHQlAvyJICX3QHDdE383xYIGTapMORiCm1KjyWCi = list;
        new HashMap();
        this.LYVRHQlR5uMq9RmVQLgPQwQp4HVKuBDt7Jnpu0jTztYClgnk53NSpkUmjjPPbYn = map;
        this.AQ1MpycqIZ4lZp4zU5ZgAcOeQWFjlY37qDhSA6zNIQj8WisYY7lHQNjV6h6Xnju0 = str;
    }

    public String getInstanceId() {
        return this.AQ1MpycqIZ4lZp4zU5ZgAcOeQWFjlY37qDhSA6zNIQj8WisYY7lHQNjV6h6Xnju0;
    }

    public String getLeader() {
        return this.GqEao9b9YWjqJfm0U8G9R1Onjg5BiUMTCoMqRIVO602C1plqYKUzgjm5B5hvlTms;
    }

    public void setLeader(String str) {
        String str2 = str;
        this.GqEao9b9YWjqJfm0U8G9R1Onjg5BiUMTCoMqRIVO602C1plqYKUzgjm5B5hvlTms = str2;
    }

    public PlayerListDelta setPlayers(List<String> list) {
        List list2;
        List<String> list3;
        PlayerListDelta playerListDelta;
        List<String> list4 = list;
        if (list4.equals(this.IhlDYVsQmgat6F3NXqRok975lHQlAvyJICX3QHDdE383xYIGTapMORiCm1KjyWCi)) {
            return PlayerListDelta.NO_CHANGE;
        }
        List<String> list5 = this.IhlDYVsQmgat6F3NXqRok975lHQlAvyJICX3QHDdE383xYIGTapMORiCm1KjyWCi;
        new ArrayList(list4);
        List list6 = list2;
        new ArrayList(list4);
        this.IhlDYVsQmgat6F3NXqRok975lHQlAvyJICX3QHDdE383xYIGTapMORiCm1KjyWCi = list3;
        boolean removeAll = list6.removeAll(list5);
        boolean removeAll2 = list5.removeAll(list4);
        if (list6.size() == 0 && list5.size() == 0) {
            return PlayerListDelta.NO_CHANGE;
        }
        new PlayerListDelta(list5, list6);
        return playerListDelta;
    }

    public List<String> getPlayers() {
        return this.IhlDYVsQmgat6F3NXqRok975lHQlAvyJICX3QHDdE383xYIGTapMORiCm1KjyWCi;
    }

    public String getMessageTime(String str) {
        String str2 = str;
        if (this.LYVRHQlR5uMq9RmVQLgPQwQp4HVKuBDt7Jnpu0jTztYClgnk53NSpkUmjjPPbYn.containsKey(str2)) {
            return this.LYVRHQlR5uMq9RmVQLgPQwQp4HVKuBDt7Jnpu0jTztYClgnk53NSpkUmjjPPbYn.get(str2);
        }
        return "";
    }

    public void putMessageTime(String str, String str2) {
        String put = this.LYVRHQlR5uMq9RmVQLgPQwQp4HVKuBDt7Jnpu0jTztYClgnk53NSpkUmjjPPbYn.put(str, str2);
    }
}
