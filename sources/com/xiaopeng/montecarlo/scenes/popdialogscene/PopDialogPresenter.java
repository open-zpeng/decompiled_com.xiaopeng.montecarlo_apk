package com.xiaopeng.montecarlo.scenes.popdialogscene;

import android.text.TextUtils;
import com.xiaopeng.montecarlo.aimessage.AiMsgManager;
import com.xiaopeng.montecarlo.base.scene.BasePresenter;
import com.xiaopeng.montecarlo.navcore.state.IStateListener;
import com.xiaopeng.montecarlo.navcore.state.StateManager;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.scenes.popdialogscene.IPopDialogContract;
/* loaded from: classes2.dex */
public class PopDialogPresenter extends BasePresenter implements IPopDialogContract.Presenter, IStateListener {
    private static final L.Tag TAG = new L.Tag("PopDialogPresenter");
    private IPopDialogContract.LogicView mLogicView;

    public PopDialogPresenter(IPopDialogContract.LogicView logicView) {
        this.mLogicView = logicView;
        IPopDialogContract.LogicView logicView2 = this.mLogicView;
        if (logicView2 != null) {
            logicView2.setPresenter(this);
        }
    }

    @Override // com.xiaopeng.montecarlo.base.scene.BasePresenter, com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter, com.xiaopeng.montecarlo.base.IBasePresenter
    public void onResume() {
        super.onResume();
        if (L.ENABLE) {
            L.d(TAG, "onResume");
        }
        StateManager.getInstance().addListener(this);
    }

    @Override // com.xiaopeng.montecarlo.base.scene.BasePresenter, com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter, com.xiaopeng.montecarlo.base.IBasePresenter
    public void onPause() {
        super.onPause();
        if (L.ENABLE) {
            L.d(TAG, "onPause");
        }
        StateManager.getInstance().removeListener(this);
    }

    @Override // com.xiaopeng.montecarlo.base.scene.BasePresenter, com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter, com.xiaopeng.montecarlo.base.IBasePresenter
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.xiaopeng.montecarlo.base.scene.BasePresenter, com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter, com.xiaopeng.montecarlo.base.IBasePresenter
    public void show() {
        super.show();
        if (L.ENABLE) {
            L.d(TAG, "show");
        }
    }

    @Override // com.xiaopeng.montecarlo.base.scene.BasePresenter, com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter, com.xiaopeng.montecarlo.base.IBasePresenter
    public void hide() {
        super.hide();
        if (L.ENABLE) {
            L.d(TAG, "hide");
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.popdialogscene.IPopDialogContract.Presenter
    public void onInitView(int i, Object obj) {
        this.mLogicView.fillContent();
    }

    public void dialWithBT(String str) {
        if (TextUtils.isEmpty(str)) {
            IPopDialogContract.LogicView logicView = this.mLogicView;
            if (logicView != null) {
                logicView.exit();
                return;
            }
            return;
        }
        AiMsgManager aiMsgManager = this.mLogicView.getMainContext() == null ? null : this.mLogicView.getMainContext().getAiMsgManager();
        if (aiMsgManager != null) {
            this.mLogicView.dialWithBT(aiMsgManager, str);
        }
    }

    @Override // com.xiaopeng.montecarlo.navcore.state.IStateListener
    public void onStateChange(int i) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "onStateChange: " + i);
        }
        if (1 == i) {
            this.mLogicView.exit();
        }
    }
}
