package com.xiaopeng.montecarlo.base.scene;
/* loaded from: classes.dex */
public interface IXPHandlerBuilder {
    XPHandler createMainThreadHandler();

    XPHandler createWorkThreadHandler(String str);
}
