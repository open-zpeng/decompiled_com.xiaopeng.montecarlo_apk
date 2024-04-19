package com.xiaopeng.montecarlo.base.scene;
/* loaded from: classes2.dex */
public class XPHandlerBuilder {
    private IXPHandlerBuilder mXPHandlerBuilder;

    public XPHandlerBuilder(IXPHandlerBuilder iXPHandlerBuilder) {
        this.mXPHandlerBuilder = iXPHandlerBuilder;
    }

    public XPHandler createMainThreadHandler() {
        return this.mXPHandlerBuilder.createMainThreadHandler();
    }

    public XPHandler createWorkThreadHandler(String str) {
        return this.mXPHandlerBuilder.createWorkThreadHandler(str);
    }
}
