package com.shaded.fasterxml.jackson.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@JacksonAnnotation
@Retention(RetentionPolicy.RUNTIME)
public @interface JsonTypeInfo {

    public enum As {
    }

    Class<?> defaultImpl() default None.class;

    As include() default As.PROPERTY;

    String property() default "";

    Id use();

    boolean visible() default false;

    public enum Id {
        ;
        
        private final String _defaultPropertyName;

        private Id(String str) {
            String str2 = r8;
            int i = r9;
            this._defaultPropertyName = str;
        }

        public String getDefaultPropertyName() {
            return this._defaultPropertyName;
        }
    }

    public static abstract class None {
        public None() {
        }
    }
}
