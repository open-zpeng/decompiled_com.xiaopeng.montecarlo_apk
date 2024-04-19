package com.xiaopeng.montecarlo.scenes.downloadscene;

import com.xiaopeng.montecarlo.base.IBasePresenter;
import com.xiaopeng.montecarlo.base.IMapLogicView;
import com.xiaopeng.montecarlo.scenes.downloadscene.operation.transition.DownloadStateManager;
/* loaded from: classes3.dex */
public interface IMapDownloadContract {

    /* loaded from: classes3.dex */
    public interface LogicView extends IMapLogicView<MapDownloadPresenter> {
        void refreshFullView();
    }

    /* loaded from: classes3.dex */
    public interface Model {
    }

    /* loaded from: classes3.dex */
    public interface Presenter extends IBasePresenter {
        DownloadStateManager getDownloadStateManager();
    }
}
