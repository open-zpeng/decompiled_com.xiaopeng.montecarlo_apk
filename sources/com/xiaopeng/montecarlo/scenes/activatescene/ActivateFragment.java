package com.xiaopeng.montecarlo.scenes.activatescene;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.xiaopeng.lib.bughunter.anr.UILooperObserver;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.base.BaseMapScene;
import com.xiaopeng.montecarlo.base.BaseScene;
import com.xiaopeng.montecarlo.bridge.CruiseBridge;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.timer.XCountDownTimer;
import com.xiaopeng.montecarlo.scenes.activatescene.IActivateContract;
import com.xiaopeng.montecarlo.util.ThemeWatcherUtil;
import com.xiaopeng.montecarlo.views.dialog.XManualActivateDialog;
import com.xiaopeng.montecarlo.views.dialog.XTextDialog;
/* loaded from: classes3.dex */
public class ActivateFragment extends BaseMapScene implements IActivateContract.LogicView {
    private static final int MANUAL_ACTIVATE_SUCCESS_TIMER_MAX = 5000;
    private static final int MANUAL_ACTIVATE_SUCCESS_TIMER_UPDATE = 1000;
    private static final L.Tag TAG = new L.Tag("ActivateFragment");
    private XManualActivateDialog mManualActivateDialog;
    private String[] mManualActivateResultMsg;
    private XTextDialog mNetActivateDialog;
    private ActivateScenePresenter mPresenter;
    private XCountDownTimer mTimer;
    private View.OnClickListener mManualListener = new View.OnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.activatescene.ActivateFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ActivateFragment.this.mPresenter.isActivateSuccess()) {
                ActivateFragment.this.mTimer.stop();
                ActivateFragment.this.mManualActivateDialog.dismiss();
                ActivateFragment.this.gotoMap();
                return;
            }
            ActivateFragment.this.mPresenter.manualActivate(ActivateFragment.this.mManualActivateDialog.getUserCode(), ActivateFragment.this.mManualActivateDialog.getLoginCode());
        }
    };
    private XCountDownTimer.ITimerCallback mTimerCallback = new XCountDownTimer.ITimerCallback() { // from class: com.xiaopeng.montecarlo.scenes.activatescene.ActivateFragment.2
        @Override // com.xiaopeng.montecarlo.root.util.timer.XCountDownTimer.ITimerCallback
        public void onTick(long j) {
            ActivateFragment.this.mManualActivateDialog.setOkButtonText(ContextUtils.getString(R.string.activate_manual_close, Integer.valueOf((int) j)));
        }

        @Override // com.xiaopeng.montecarlo.root.util.timer.XCountDownTimer.ITimerCallback
        public void onTimeOut() {
            ActivateFragment.this.mManualActivateDialog.dismiss();
            ActivateFragment.this.gotoMap();
        }
    };

    @Override // com.xiaopeng.montecarlo.base.IBaseLogicView
    public void hide() {
    }

    @Override // com.xiaopeng.montecarlo.base.BaseScene
    public boolean onSceneSaveInstanceState(Bundle bundle) {
        return true;
    }

    @Override // com.xiaopeng.montecarlo.base.IBaseLogicView
    public void show() {
    }

    public static BaseScene newInstance() {
        return new ActivateFragment();
    }

    @Override // com.xiaopeng.montecarlo.base.BaseFullScenes, com.xiaopeng.montecarlo.base.BaseScene
    protected View onSceneCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_activate, (ViewGroup) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.base.BaseMapScene, com.xiaopeng.montecarlo.base.BaseFullScenes, com.xiaopeng.montecarlo.base.BaseScene
    public void onSceneViewCreated(View view, @Nullable Bundle bundle) {
        super.onSceneViewCreated(view, bundle);
        boolean z = bundle != null;
        this.mManualActivateResultMsg = ContextUtils.getStringArray(R.array.manual_activate_result);
        this.mTimer = new XCountDownTimer(UILooperObserver.ANR_TRIGGER_TIME, 1000L, this.mTimerCallback);
        this.mPresenter.startCheckActivate(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.base.BaseMapScene, com.xiaopeng.montecarlo.base.BaseFullScenes, com.xiaopeng.montecarlo.base.BaseScene
    public void onSceneResume() {
        super.onSceneResume();
        this.mPresenter.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.base.BaseMapScene, com.xiaopeng.montecarlo.base.BaseFullScenes, com.xiaopeng.montecarlo.base.BaseScene
    public void onScenePause() {
        super.onScenePause();
        this.mPresenter.onPause();
        XTextDialog xTextDialog = this.mNetActivateDialog;
        if (xTextDialog != null && xTextDialog.isShowing()) {
            this.mNetActivateDialog.dismiss();
        }
        XManualActivateDialog xManualActivateDialog = this.mManualActivateDialog;
        if (xManualActivateDialog == null || !xManualActivateDialog.isShowing()) {
            return;
        }
        this.mManualActivateDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.base.BaseMapScene, com.xiaopeng.montecarlo.base.BaseFullScenes, com.xiaopeng.montecarlo.base.BaseScene
    public void onSceneDestroyView() {
        super.onSceneDestroyView();
        this.mPresenter.onDestroy();
    }

    @Override // com.xiaopeng.montecarlo.base.IBaseLogicView
    /* renamed from: getPresenter */
    public ActivateScenePresenter mo116getPresenter() {
        return this.mPresenter;
    }

    @Override // com.xiaopeng.montecarlo.base.IBaseLogicView
    public void setPresenter(ActivateScenePresenter activateScenePresenter) {
        this.mPresenter = activateScenePresenter;
    }

    @Override // com.xiaopeng.montecarlo.scenes.activatescene.IActivateContract.LogicView
    public void activateSilentSuccess() {
        if (isSceneLegal()) {
            runOnUiThread(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.activatescene.ActivateFragment.3
                @Override // java.lang.Runnable
                public void run() {
                    if (ActivateFragment.this.isSceneLegal()) {
                        if (ActivateFragment.this.mNetActivateDialog != null && ActivateFragment.this.mNetActivateDialog.isShowing()) {
                            ActivateFragment.this.mNetActivateDialog.dismiss();
                        }
                        if (ActivateFragment.this.mManualActivateDialog != null && ActivateFragment.this.mManualActivateDialog.isShowing()) {
                            ActivateFragment.this.mManualActivateDialog.dismiss();
                        }
                        ActivateFragment.this.gotoMap();
                    }
                }
            });
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.activatescene.IActivateContract.LogicView
    public void activateManualSuccess(final boolean z) {
        if (isSceneLegal()) {
            runOnUiThread(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.activatescene.ActivateFragment.4
                @Override // java.lang.Runnable
                public void run() {
                    if (ActivateFragment.this.isSceneLegal()) {
                        ActivateFragment.this.createManualActivateDialog();
                        ActivateFragment.this.mManualActivateDialog.setIsNight(!ThemeWatcherUtil.isDayMode());
                        ActivateFragment.this.mManualActivateDialog.setManualActivateResultTextColor(ThemeWatcherUtil.getColor(R.color.primary_forward_color_normal));
                        ActivateFragment.this.mManualActivateDialog.setManualActivateResult(ActivateFragment.this.mManualActivateResultMsg[1]);
                        XManualActivateDialog xManualActivateDialog = ActivateFragment.this.mManualActivateDialog;
                        Object[] objArr = new Object[1];
                        objArr[0] = Long.valueOf(z ? ActivateFragment.this.mTimer.getLeftTickTime() : 5L);
                        xManualActivateDialog.setOkButtonText(ContextUtils.getString(R.string.activate_manual_close, objArr));
                        ActivateFragment.this.mTimer.start();
                    }
                }
            });
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.activatescene.IActivateContract.LogicView
    public void showManualActivateDialog() {
        if (isSceneLegal()) {
            runOnUiThread(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.activatescene.ActivateFragment.5
                @Override // java.lang.Runnable
                public void run() {
                    if (ActivateFragment.this.isSceneLegal()) {
                        if (ActivateFragment.this.mNetActivateDialog != null && ActivateFragment.this.mNetActivateDialog.isShowing()) {
                            ActivateFragment.this.mNetActivateDialog.dismiss();
                        }
                        ActivateFragment.this.createManualActivateDialog();
                        ActivateFragment.this.mManualActivateDialog.setManualActivateResult("");
                        ActivateFragment.this.mManualActivateDialog.setIsNight(!ThemeWatcherUtil.isDayMode());
                        ActivateFragment.this.mManualActivateDialog.show();
                    }
                }
            });
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.activatescene.IActivateContract.LogicView
    public void showActivateNetErrorDialog() {
        if (isSceneLegal()) {
            runOnUiThread(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.activatescene.ActivateFragment.6
                @Override // java.lang.Runnable
                public void run() {
                    if (ActivateFragment.this.isSceneLegal()) {
                        if (ActivateFragment.this.mNetActivateDialog == null) {
                            ActivateFragment activateFragment = ActivateFragment.this;
                            activateFragment.mNetActivateDialog = new XTextDialog(activateFragment.getActivity(), -1, false);
                        }
                        ActivateFragment.this.mNetActivateDialog.setIsNight(!ThemeWatcherUtil.isDayMode());
                        ActivateFragment.this.mNetActivateDialog.setGravity(3);
                        ActivateFragment.this.mNetActivateDialog.setContentText(R.string.activate_fail_message);
                        ActivateFragment.this.mNetActivateDialog.showTitle(false);
                        ActivateFragment.this.mNetActivateDialog.showClose(false);
                        ActivateFragment.this.mNetActivateDialog.showOkButton(false);
                        ActivateFragment.this.mNetActivateDialog.showCancelButton(false);
                        ActivateFragment.this.mNetActivateDialog.setCanceledOnTouchOutside(false);
                        ActivateFragment.this.mNetActivateDialog.show();
                    }
                }
            });
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.activatescene.IActivateContract.LogicView
    public void showManualActivateFail(final int i) {
        if (isSceneLegal()) {
            runOnUiThread(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.activatescene.ActivateFragment.7
                @Override // java.lang.Runnable
                public void run() {
                    if (ActivateFragment.this.isSceneLegal()) {
                        ActivateFragment.this.createManualActivateDialog();
                        ActivateFragment.this.mManualActivateDialog.setIsNight(!ThemeWatcherUtil.isDayMode());
                        if (i >= ActivateFragment.this.mManualActivateResultMsg.length || i < 0) {
                            ActivateFragment.this.mManualActivateDialog.setManualActivateResult("");
                        } else {
                            ActivateFragment.this.mManualActivateDialog.setManualActivateResultTextColor(ThemeWatcherUtil.getColor(R.color.primary_negative_color_normal));
                            ActivateFragment.this.mManualActivateDialog.setManualActivateResult(ActivateFragment.this.mManualActivateResultMsg[i]);
                        }
                        ActivateFragment.this.mManualActivateDialog.setOkButtonText(R.string.activate_manual_retry);
                        ActivateFragment.this.mManualActivateDialog.show();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gotoMap() {
        startScene(new CruiseBridge().setBundle(new Bundle()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createManualActivateDialog() {
        if (this.mManualActivateDialog == null) {
            this.mManualActivateDialog = new XManualActivateDialog(getActivity());
            this.mManualActivateDialog.setOkButtonClickListener(this.mManualListener);
            this.mManualActivateDialog.setTitle(R.string.activate_manual_title);
            this.mManualActivateDialog.setOkButtonText(R.string.activate_manual_ok);
            this.mManualActivateDialog.setManualActivateUuid(this.mPresenter.getUUID());
        }
    }
}
