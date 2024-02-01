package com.lzy.okgo.convert;

import okhttp3.Response;
/* loaded from: classes2.dex */
public interface Converter<T> {
    T convertResponse(Response response) throws Throwable;
}
