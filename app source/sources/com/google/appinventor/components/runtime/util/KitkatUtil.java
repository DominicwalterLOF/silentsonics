package com.google.appinventor.components.runtime.util;

import android.content.Intent;
import android.provider.Telephony;
import android.telephony.SmsMessage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class KitkatUtil {
    private KitkatUtil() {
    }

    public static List<SmsMessage> getMessagesFromIntent(Intent intent) {
        List<SmsMessage> list;
        new ArrayList();
        List<SmsMessage> list2 = list;
        SmsMessage[] messagesFromIntent = Telephony.Sms.Intents.getMessagesFromIntent(intent);
        SmsMessage[] smsMessageArr = messagesFromIntent;
        if (messagesFromIntent != null && smsMessageArr.length >= 0) {
            boolean addAll = Collections.addAll(list2, smsMessageArr);
        }
        return list2;
    }
}
