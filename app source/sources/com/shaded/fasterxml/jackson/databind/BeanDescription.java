package com.shaded.fasterxml.jackson.databind;

import com.shaded.fasterxml.jackson.annotation.JsonFormat;
import com.shaded.fasterxml.jackson.annotation.JsonInclude;
import com.shaded.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.shaded.fasterxml.jackson.databind.introspect.AnnotatedClass;
import com.shaded.fasterxml.jackson.databind.introspect.AnnotatedConstructor;
import com.shaded.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.shaded.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.shaded.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;
import com.shaded.fasterxml.jackson.databind.introspect.ObjectIdInfo;
import com.shaded.fasterxml.jackson.databind.type.TypeBindings;
import com.shaded.fasterxml.jackson.databind.util.Annotations;
import com.shaded.fasterxml.jackson.databind.util.Converter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class BeanDescription {
    protected final JavaType _type;

    public abstract TypeBindings bindingsForBeanType();

    public abstract AnnotatedMember findAnyGetter();

    public abstract AnnotatedMethod findAnySetter();

    public abstract Map<String, AnnotatedMember> findBackReferenceProperties();

    public abstract AnnotatedConstructor findDefaultConstructor();

    public abstract Converter<Object, Object> findDeserializationConverter();

    public abstract JsonFormat.Value findExpectedFormat(JsonFormat.Value value);

    public abstract Method findFactoryMethod(Class<?>... clsArr);

    public abstract Map<Object, AnnotatedMember> findInjectables();

    public abstract AnnotatedMethod findJsonValueMethod();

    public abstract AnnotatedMethod findMethod(String str, Class<?>[] clsArr);

    public abstract Class<?> findPOJOBuilder();

    public abstract JsonPOJOBuilder.Value findPOJOBuilderConfig();

    public abstract List<BeanPropertyDefinition> findProperties();

    public abstract Converter<Object, Object> findSerializationConverter();

    public abstract JsonInclude.Include findSerializationInclusion(JsonInclude.Include include);

    public abstract Constructor<?> findSingleArgConstructor(Class<?>... clsArr);

    public abstract Annotations getClassAnnotations();

    public abstract AnnotatedClass getClassInfo();

    public abstract List<AnnotatedConstructor> getConstructors();

    public abstract List<AnnotatedMethod> getFactoryMethods();

    public abstract Set<String> getIgnoredPropertyNames();

    public abstract ObjectIdInfo getObjectIdInfo();

    public abstract boolean hasKnownClassAnnotations();

    public abstract Object instantiateBean(boolean z);

    public abstract JavaType resolveType(Type type);

    protected BeanDescription(JavaType javaType) {
        this._type = javaType;
    }

    public JavaType getType() {
        return this._type;
    }

    public Class<?> getBeanClass() {
        return this._type.getRawClass();
    }
}
