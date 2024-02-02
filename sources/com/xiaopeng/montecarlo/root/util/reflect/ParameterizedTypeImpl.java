package com.xiaopeng.montecarlo.root.util.reflect;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes2.dex */
public class ParameterizedTypeImpl implements ParameterizedType {
    private final Type[] mActualTypeArguments;
    private final Class<?> mRawType;

    @Override // java.lang.reflect.ParameterizedType
    public Type getOwnerType() {
        return null;
    }

    public ParameterizedTypeImpl(Class<?> cls, Type[] typeArr) {
        this.mRawType = cls;
        this.mActualTypeArguments = typeArr == null ? new Type[0] : typeArr;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type[] getActualTypeArguments() {
        return this.mActualTypeArguments;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Class<?> getRawType() {
        return this.mRawType;
    }
}
