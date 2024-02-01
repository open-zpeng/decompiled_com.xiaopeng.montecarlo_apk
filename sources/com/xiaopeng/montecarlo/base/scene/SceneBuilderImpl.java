package com.xiaopeng.montecarlo.base.scene;

import com.xiaopeng.montecarlo.ScenesFactory;
import com.xiaopeng.montecarlo.bridge.StatusConst;
/* loaded from: classes.dex */
public class SceneBuilderImpl implements ISceneBuilder {
    @Override // com.xiaopeng.montecarlo.base.scene.ISceneBuilder
    public IScene createScene(StatusConst.Mode mode) {
        return ScenesFactory.createScene(mode);
    }
}
