package com.xiaopeng.montecarlo.scenes.mapscene;

import android.os.Bundle;
/* loaded from: classes2.dex */
public interface ISceneMapFragmentListener {
    void onClickOverView();

    boolean onClickRecenter();

    void onClickRouteChargeSwitch();

    default boolean onClickSRNaviMode() {
        return false;
    }

    void onClickZoomView(boolean z);

    void onSceneMapFragmentResult(int i, Bundle bundle);
}
