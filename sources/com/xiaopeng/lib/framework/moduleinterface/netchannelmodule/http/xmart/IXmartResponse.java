package com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.xmart;

import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public interface IXmartResponse {
    @Nullable
    IServerBean body();

    int code();

    @Nullable
    Throwable getException();

    @Nullable
    String message();
}
