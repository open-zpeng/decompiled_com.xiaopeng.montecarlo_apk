package com.xiaopeng.montecarlo.scenes.scanscene;

import android.os.Bundle;
import com.xiaopeng.montecarlo.base.BaseBridge;
import com.xiaopeng.montecarlo.base.IBaseLogicView;
import com.xiaopeng.montecarlo.base.IBasePresenter;
/* loaded from: classes3.dex */
public interface IScanSearchContract {

    /* loaded from: classes3.dex */
    public interface LogicView extends IBaseLogicView<ScanSearchPresenter> {
        BaseBridge getBaseBridge();

        void setResult(Bundle bundle);
    }

    /* loaded from: classes3.dex */
    public interface Presenter extends IBasePresenter {
        int getFromSceneIndex();

        int getSearchMode();

        void initData(Bundle bundle);
    }
}
