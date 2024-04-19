package com.xiaopeng.montecarlo.base.scene;
/* loaded from: classes2.dex */
public class XPHandlerBuilderImpl implements IXPHandlerBuilder {
    @Override // com.xiaopeng.montecarlo.base.scene.IXPHandlerBuilder
    public XPHandler createMainThreadHandler() {
        return new XPHandler(new XPHandlerImpl());
    }

    @Override // com.xiaopeng.montecarlo.base.scene.IXPHandlerBuilder
    public XPHandler createWorkThreadHandler(String str) {
        return new XPHandler(new XPHandlerImpl(str));
    }
}
