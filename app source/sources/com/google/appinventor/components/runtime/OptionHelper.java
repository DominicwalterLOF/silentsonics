package com.google.appinventor.components.runtime;

import com.google.appinventor.components.annotations.Options;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.common.OptionList;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class OptionHelper {
    private static final Map<String, Map<String, Method>> mBLKdPlRolYfdtud5Z8giGWyhURWoCw9yHsOv08fUnIBAM4MuKAWkHVD8nEhBmIT;

    public OptionHelper() {
    }

    static {
        Map<String, Map<String, Method>> map;
        new HashMap();
        mBLKdPlRolYfdtud5Z8giGWyhURWoCw9yHsOv08fUnIBAM4MuKAWkHVD8nEhBmIT = map;
    }

    public static <T> Object optionListFromValue(Component component, String str, T t) {
        T t2 = t;
        Method hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(component, str);
        Method method = hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;
        if (hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME == null) {
            return t2;
        }
        Options options = (Options) method.getAnnotation(Options.class);
        Options options2 = options;
        if (options == null) {
            return t2;
        }
        Class<? extends OptionList<?>> value = options2.value();
        try {
            Object invoke = value.getMethod("fromUnderlyingValue", new Class[]{t2.getClass()}).invoke(value, new Object[]{t2});
            Object obj = invoke;
            if (invoke != null) {
                return obj;
            }
            return t2;
        } catch (NoSuchMethodException e) {
            return t2;
        } catch (IllegalAccessException e2) {
            return t2;
        } catch (InvocationTargetException e3) {
            return t2;
        }
    }

    public static Object[] optionListsFromValues(Component component, String str, Object... objArr) {
        Component component2 = component;
        String str2 = str;
        Object[] objArr2 = objArr;
        if (objArr2.length == 0) {
            return objArr2;
        }
        Method hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(component2, str2);
        Method method = hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;
        if (hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME == null) {
            return objArr2;
        }
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
        int i = 0;
        int length = parameterAnnotations.length;
        for (int i2 = 0; i2 < length; i2++) {
            Annotation[] annotationArr = parameterAnnotations[i2];
            Annotation[] annotationArr2 = annotationArr;
            int length2 = annotationArr.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length2) {
                    break;
                }
                Annotation annotation = annotationArr2[i3];
                Annotation annotation2 = annotation;
                if (annotation.annotationType() == Options.class) {
                    Class<? extends OptionList<?>> value = ((Options) annotation2).value();
                    Class<? extends OptionList<?>> cls = value;
                    try {
                        Object invoke = cls.getMethod("fromUnderlyingValue", new Class[]{objArr2[i].getClass()}).invoke(value, new Object[]{objArr2[i]});
                        Object obj = invoke;
                        if (invoke != null) {
                            objArr2[i] = obj;
                        }
                    } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
                    }
                } else {
                    i3++;
                }
            }
            i++;
        }
        return objArr2;
    }

    private static Method hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(Component component, String str) {
        String str2 = str;
        Class<?> cls = component.getClass();
        Class<?> cls2 = cls;
        String simpleName = cls.getSimpleName();
        Map<String, Method> map = mBLKdPlRolYfdtud5Z8giGWyhURWoCw9yHsOv08fUnIBAM4MuKAWkHVD8nEhBmIT.get(simpleName);
        Map<String, Method> map2 = map;
        if (map == null) {
            map2 = hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(cls2);
            Map<String, Method> put = mBLKdPlRolYfdtud5Z8giGWyhURWoCw9yHsOv08fUnIBAM4MuKAWkHVD8nEhBmIT.put(simpleName, map2);
        }
        return map2.get(str2);
    }

    private static Map<String, Method> hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(Class<?> cls) {
        Map<String, Method> map;
        new HashMap();
        Map<String, Method> map2 = map;
        Method[] methods = cls.getMethods();
        Method[] methodArr = methods;
        int length = methods.length;
        for (int i = 0; i < length; i++) {
            Method method = methodArr[i];
            Method method2 = method;
            if ((method.getModifiers() & 1) != 0) {
                String name = method2.getName();
                if (((SimpleEvent) method2.getAnnotation(SimpleEvent.class)) != null) {
                    Method put = map2.put(name, method2);
                } else if (method2.getReturnType() != Void.TYPE) {
                    if (((SimpleFunction) method2.getAnnotation(SimpleFunction.class)) != null) {
                        Method put2 = map2.put(name, method2);
                    } else if (((SimpleProperty) method2.getAnnotation(SimpleProperty.class)) != null) {
                        Method put3 = map2.put(name, method2);
                    }
                }
            }
        }
        return map2;
    }
}
