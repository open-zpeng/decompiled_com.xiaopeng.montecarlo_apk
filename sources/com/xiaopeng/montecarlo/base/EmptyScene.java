package com.xiaopeng.montecarlo.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.autonavi.gbl.common.model.RectInt;
import com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter;
/* loaded from: classes.dex */
public class EmptyScene extends BaseScene {
    @Override // com.xiaopeng.montecarlo.base.scene.IBaseScene
    public <T extends AbstractBasePresenter> T getPresenter() {
        return null;
    }

    @Override // com.xiaopeng.montecarlo.base.BaseScene
    protected View onSceneCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.base.BaseScene
    public RectInt getCurrentFreeBound() {
        return super.getCurrentFreeBound();
    }
}
