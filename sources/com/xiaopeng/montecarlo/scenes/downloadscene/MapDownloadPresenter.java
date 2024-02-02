package com.xiaopeng.montecarlo.scenes.downloadscene;

import com.xiaopeng.montecarlo.base.scene.BasePresenter;
import com.xiaopeng.montecarlo.navcore.download.IDownloadOperate;
import com.xiaopeng.montecarlo.navcore.download.MapDataManager;
import com.xiaopeng.montecarlo.navcore.event.SpeechNaviEvent;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.scenes.downloadscene.IMapDownloadContract;
import com.xiaopeng.montecarlo.scenes.downloadscene.operation.transition.DownloadStateManager;
import com.xiaopeng.montecarlo.speech.command.ICommandCallback;
/* loaded from: classes2.dex */
public class MapDownloadPresenter extends BasePresenter implements IMapDownloadContract.Presenter {
    public static final String KEY_NEED_EXIT_SETTINGS = "key_need_exit_settings";
    private static final L.Tag TAG = new L.Tag("MapDownloadPresent");
    private final IDownloadOperate mDownloadOperate = new DownloadOperate();
    private DownloadStateManager mDownloadStateManager = new DownloadStateManager(this.mDownloadOperate);
    private IMapDownloadContract.LogicView mView;

    public MapDownloadPresenter getPresenter() {
        return this;
    }

    public MapDownloadPresenter(IMapDownloadContract.LogicView logicView) {
        if (logicView != null) {
            this.mView = logicView;
            this.mView.setPresenter(this);
            return;
        }
        L.w(TAG, "logicView is null");
    }

    @Override // com.xiaopeng.montecarlo.scenes.downloadscene.IMapDownloadContract.Presenter
    public DownloadStateManager getDownloadStateManager() {
        return this.mDownloadStateManager;
    }

    @Override // com.xiaopeng.montecarlo.base.scene.BasePresenter, com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter, com.xiaopeng.montecarlo.base.IBasePresenter
    public void onResume() {
        super.onResume();
        L.i(TAG, "onResume");
    }

    @Override // com.xiaopeng.montecarlo.base.scene.BasePresenter, com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter, com.xiaopeng.montecarlo.base.IBasePresenter
    public void onPause() {
        super.onPause();
        L.i(TAG, "onPause");
    }

    @Override // com.xiaopeng.montecarlo.base.scene.BasePresenter, com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter, com.xiaopeng.montecarlo.base.IBasePresenter
    public void onDestroy() {
        super.onDestroy();
        L.i(TAG, "onDestroy");
        this.mView = null;
    }

    @Override // com.xiaopeng.montecarlo.base.scene.BasePresenter, com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter, com.xiaopeng.montecarlo.base.IBasePresenter
    public void show() {
        super.show();
        L.i(TAG, "show");
    }

    @Override // com.xiaopeng.montecarlo.base.scene.BasePresenter, com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter, com.xiaopeng.montecarlo.base.IBasePresenter
    public void hide() {
        super.hide();
        L.i(TAG, "hide");
    }

    @Override // com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter, com.xiaopeng.montecarlo.speech.command.ISpeechEvent
    public boolean onSpeechEvent(SpeechNaviEvent speechNaviEvent, ICommandCallback iCommandCallback) {
        if (speechNaviEvent.what == 312) {
            L.Tag tag = TAG;
            L.i(tag, "SPEECH_ROUTE_NEW_DEST_WITH_VIAS, isSceneLegal:" + this.mView.isSceneLegal());
            if (this.mView.isSceneLegal()) {
                this.mView.getSpeechEventBizHelper().routeNewDestWithVias(this.mView.getMainContext().getCurrentScene(), speechNaviEvent);
                return true;
            }
        }
        return false;
    }

    /* loaded from: classes2.dex */
    private class DownloadOperate implements IDownloadOperate {
        private DownloadOperate() {
        }

        @Override // com.xiaopeng.montecarlo.navcore.download.IDownloadOperate
        public void startDownload(Integer num) {
            MapDataManager.getInstance().startDownload(num);
        }

        @Override // com.xiaopeng.montecarlo.navcore.download.IDownloadOperate
        public void pauseDownload(Integer num) {
            MapDataManager.getInstance().pauseDownload(num);
        }

        @Override // com.xiaopeng.montecarlo.navcore.download.IDownloadOperate
        public void cancelDownload(Integer num) {
            MapDataManager.getInstance().cancelDownload(num);
        }

        @Override // com.xiaopeng.montecarlo.navcore.download.IDownloadOperate
        public void deleteDownload(Integer num) {
            MapDataManager.getInstance().deleteDownload(num);
        }
    }

    public void refreshFullView() {
        IMapDownloadContract.LogicView logicView = this.mView;
        if (logicView != null) {
            logicView.refreshFullView();
        }
    }
}
