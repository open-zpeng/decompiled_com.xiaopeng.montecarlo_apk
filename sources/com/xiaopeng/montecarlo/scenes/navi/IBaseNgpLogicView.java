package com.xiaopeng.montecarlo.scenes.navi;

import com.xiaopeng.montecarlo.base.IMapLogicView;
import com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter;
/* loaded from: classes3.dex */
public interface IBaseNgpLogicView<T extends AbstractBasePresenter> extends IMapLogicView<T> {
    default void onHideTrafficPanel() {
    }

    default void onShowTrafficPanel(int i) {
    }

    void onUpdateNgpInfoTips(boolean z, int i, int i2, int i3);

    void onUpdateNgpLcTips(boolean z, int i, int i2, int i3, int i4, boolean z2, boolean z3);

    void onUpdateNgpLcTipsByDriveMode(int i, int i2, boolean z, int i3);

    default void onUpdateNgpLcTipsProgress(boolean z, long j, int i, boolean z2) {
    }

    void onUpdateNgpOperateStatus(boolean z, int i, int i2, boolean z2);

    void onUpdateNgpQuitTips(boolean z, int i, int i2, int i3);

    default void onUpdateNgpStatus(boolean z) {
    }

    void onUpdateRemainDis(long j, int i, int i2);

    void onUpdateTakeOverWeakStatus(boolean z);

    default void refreshNgpPanelView() {
    }
}
