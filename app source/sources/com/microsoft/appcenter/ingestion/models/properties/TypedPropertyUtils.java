package com.microsoft.appcenter.ingestion.models.properties;

import android.support.annotation.NonNull;
import com.microsoft.appcenter.ingestion.models.CommonProperties;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TypedPropertyUtils {
    public TypedPropertyUtils() {
    }

    public static TypedProperty create(@NonNull String str) throws JSONException {
        Throwable th;
        StringBuilder sb;
        TypedProperty typedProperty;
        TypedProperty typedProperty2;
        TypedProperty typedProperty3;
        TypedProperty typedProperty4;
        TypedProperty typedProperty5;
        String type = str;
        if ("boolean".equals(type)) {
            new BooleanTypedProperty();
            return typedProperty5;
        } else if (DateTimeTypedProperty.TYPE.equals(type)) {
            new DateTimeTypedProperty();
            return typedProperty4;
        } else if (DoubleTypedProperty.TYPE.equals(type)) {
            new DoubleTypedProperty();
            return typedProperty3;
        } else if (LongTypedProperty.TYPE.equals(type)) {
            new LongTypedProperty();
            return typedProperty2;
        } else if ("string".equals(type)) {
            new StringTypedProperty();
            return typedProperty;
        } else {
            Throwable th2 = th;
            new StringBuilder();
            new JSONException(sb.append("Unsupported type: ").append(type).toString());
            throw th2;
        }
    }

    public static List<TypedProperty> read(JSONObject object) throws JSONException {
        List<TypedProperty> list;
        JSONArray jArray = object.optJSONArray(CommonProperties.TYPED_PROPERTIES);
        if (jArray == null) {
            return null;
        }
        new ArrayList(jArray.length());
        List<TypedProperty> array = list;
        for (int i = 0; i < jArray.length(); i++) {
            JSONObject jsonObject = jArray.getJSONObject(i);
            TypedProperty typedProperty = create(jsonObject.getString(CommonProperties.TYPE));
            typedProperty.read(jsonObject);
            boolean add = array.add(typedProperty);
        }
        return array;
    }
}
