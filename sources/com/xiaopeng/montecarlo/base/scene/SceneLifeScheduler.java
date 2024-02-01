package com.xiaopeng.montecarlo.base.scene;

import com.xiaopeng.montecarlo.base.BaseScene;
/* loaded from: classes.dex */
public class SceneLifeScheduler {
    private final ISceneLifeScheduler<BaseScene> mSceneLifeSchedulerProxy;

    public SceneLifeScheduler(ISceneLifeScheduler<BaseScene> iSceneLifeScheduler) {
        this.mSceneLifeSchedulerProxy = iSceneLifeScheduler;
    }

    public void show(BaseScene baseScene) {
        ISceneLifeScheduler<BaseScene> iSceneLifeScheduler = this.mSceneLifeSchedulerProxy;
        if (iSceneLifeScheduler != null) {
            iSceneLifeScheduler.show(baseScene);
        }
    }

    public void remove(BaseScene baseScene) {
        ISceneLifeScheduler<BaseScene> iSceneLifeScheduler = this.mSceneLifeSchedulerProxy;
        if (iSceneLifeScheduler != null) {
            iSceneLifeScheduler.remove(baseScene);
        }
    }

    public void attach(BaseScene baseScene) {
        ISceneLifeScheduler<BaseScene> iSceneLifeScheduler = this.mSceneLifeSchedulerProxy;
        if (iSceneLifeScheduler != null) {
            iSceneLifeScheduler.attach(baseScene);
        }
    }

    public void detach(BaseScene baseScene) {
        ISceneLifeScheduler<BaseScene> iSceneLifeScheduler = this.mSceneLifeSchedulerProxy;
        if (iSceneLifeScheduler != null) {
            iSceneLifeScheduler.detach(baseScene);
        }
    }

    public void add(int i, BaseScene baseScene) {
        ISceneLifeScheduler<BaseScene> iSceneLifeScheduler = this.mSceneLifeSchedulerProxy;
        if (iSceneLifeScheduler != null) {
            iSceneLifeScheduler.add(i, baseScene);
        }
    }

    public BaseScene findSceneById(int i) {
        ISceneLifeScheduler<BaseScene> iSceneLifeScheduler = this.mSceneLifeSchedulerProxy;
        if (iSceneLifeScheduler != null) {
            return iSceneLifeScheduler.findSceneById(i);
        }
        return null;
    }
}
