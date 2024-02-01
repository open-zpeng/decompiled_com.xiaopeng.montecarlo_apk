package com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene;

import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.base.scene.BasePresenter;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.ILinkSeamlessNaviContract;
/* loaded from: classes3.dex */
public class LinkSeamlessNaviPresenter extends BasePresenter implements ILinkSeamlessNaviContract.Presenter {
    private static final L.Tag TAG = new L.Tag("LinkSeamlessNaviPresenter");
    private ILinkSeamlessNaviContract.LogicView mLogicView;

    public LinkSeamlessNaviPresenter(@NonNull ILinkSeamlessNaviContract.LogicView logicView) {
        this.mLogicView = logicView;
        this.mLogicView.setPresenter(this);
    }

    @Override // com.xiaopeng.montecarlo.base.scene.BasePresenter, com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter, com.xiaopeng.montecarlo.base.IBasePresenter
    public void onResume() {
        super.onResume();
    }

    @Override // com.xiaopeng.montecarlo.base.scene.BasePresenter, com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter, com.xiaopeng.montecarlo.base.IBasePresenter
    public void onPause() {
        super.onPause();
    }

    @Override // com.xiaopeng.montecarlo.base.scene.BasePresenter, com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter, com.xiaopeng.montecarlo.base.IBasePresenter
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.xiaopeng.montecarlo.base.scene.BasePresenter, com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter, com.xiaopeng.montecarlo.base.IBasePresenter
    public void show() {
        super.show();
    }

    @Override // com.xiaopeng.montecarlo.base.scene.BasePresenter, com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter, com.xiaopeng.montecarlo.base.IBasePresenter
    public void hide() {
        super.hide();
    }
}
