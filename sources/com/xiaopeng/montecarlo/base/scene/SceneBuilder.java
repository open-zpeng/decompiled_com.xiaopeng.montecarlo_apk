package com.xiaopeng.montecarlo.base.scene;

import com.xiaopeng.montecarlo.bridge.StatusConst;
/* loaded from: classes.dex */
public class SceneBuilder implements ISceneBuilder {
    private final ISceneBuilder mSceneBuilderProxy;

    public SceneBuilder(ISceneBuilder iSceneBuilder) {
        this.mSceneBuilderProxy = iSceneBuilder;
    }

    @Override // com.xiaopeng.montecarlo.base.scene.ISceneBuilder
    public IScene createScene(StatusConst.Mode mode) {
        return this.mSceneBuilderProxy.createScene(mode);
    }
}
