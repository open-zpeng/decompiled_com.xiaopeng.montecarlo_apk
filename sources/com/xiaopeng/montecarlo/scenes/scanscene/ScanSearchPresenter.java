package com.xiaopeng.montecarlo.scenes.scanscene;

import android.os.Bundle;
import com.xiaopeng.montecarlo.base.scene.BasePresenter;
import com.xiaopeng.montecarlo.bridge.SearchBridge;
import com.xiaopeng.montecarlo.bridge.StatusConst;
import com.xiaopeng.montecarlo.navcore.event.SpeechNaviEvent;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.scenes.scanscene.IScanSearchContract;
import com.xiaopeng.montecarlo.speech.command.ICommandCallback;
/* loaded from: classes3.dex */
public class ScanSearchPresenter extends BasePresenter implements IScanSearchContract.Presenter {
    private static final L.Tag TAG = new L.Tag("ScanSearchPresenter");
    private IScanSearchContract.LogicView mLogicView;
    private int mSearchDest = 1000;
    private int mFromSceneIndex = -1;
    private int mSearchMode = 100;
    private String mSearchText = "";

    public ScanSearchPresenter(IScanSearchContract.LogicView logicView) {
        if (logicView == null) {
            throw new IllegalArgumentException("logicView is null");
        }
        this.mLogicView = logicView;
        this.mLogicView.setPresenter(this);
    }

    @Override // com.xiaopeng.montecarlo.scenes.scanscene.IScanSearchContract.Presenter
    public void initData(Bundle bundle) {
        if (bundle != null) {
            this.mFromSceneIndex = bundle.getInt(SearchBridge.FROM_SCENE_INDEX, -2);
            this.mSearchDest = bundle.getInt(SearchBridge.SEARCH_DEST_KEY, 1000);
            this.mSearchMode = bundle.getInt(SearchBridge.SEARCH_MODE);
            this.mSearchText = bundle.getString(SearchBridge.SEARCH_KEYWORD_TEXT);
        }
    }

    public int getDestMode() {
        return this.mSearchDest;
    }

    public String getSearchText() {
        return this.mSearchText;
    }

    @Override // com.xiaopeng.montecarlo.scenes.scanscene.IScanSearchContract.Presenter
    public int getSearchMode() {
        return this.mSearchMode;
    }

    @Override // com.xiaopeng.montecarlo.scenes.scanscene.IScanSearchContract.Presenter
    public int getFromSceneIndex() {
        return this.mFromSceneIndex;
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

    public void exitCurrentSearch() {
        this.mLogicView.backToMode(StatusConst.Mode.SEARCH, true);
    }

    @Override // com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter, com.xiaopeng.montecarlo.speech.command.ISpeechEvent
    public boolean onSpeechEvent(SpeechNaviEvent speechNaviEvent, ICommandCallback iCommandCallback) {
        if (speechNaviEvent.what == 312) {
            L.Tag tag = TAG;
            L.i(tag, "SPEECH_ROUTE_NEW_DEST_WITH_VIAS, isSceneLegal:" + this.mLogicView.isSceneLegal());
            if (this.mLogicView.isSceneLegal()) {
                this.mLogicView.getSpeechEventBizHelper().routeNewDestWithVias(this.mLogicView.getMainContext().getCurrentScene(), speechNaviEvent);
                return true;
            }
        }
        return false;
    }
}
