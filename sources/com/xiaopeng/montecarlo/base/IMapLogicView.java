package com.xiaopeng.montecarlo.base;

import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter;
import com.xiaopeng.montecarlo.navcore.mapdisplay.MapViewWrapper;
/* loaded from: classes.dex */
public interface IMapLogicView<T extends AbstractBasePresenter> extends IBaseLogicView<T> {
    @NonNull
    MapViewWrapper getMapView();
}
