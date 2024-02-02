package com.xiaopeng.montecarlo.views.poicard;

import com.xiaopeng.montecarlo.navcore.bean.favorite.FavoriteAddress;
/* loaded from: classes3.dex */
public interface PoiCardEventListener {
    void onAddFavoriteClick();

    void onAddWayPointClick();

    void onDeleteWayPointClick();

    void onHomeSettingSuccess(FavoriteAddress favoriteAddress);

    void onOfficeSettingSuccess(FavoriteAddress favoriteAddress);

    void onSearchClick();

    void onStartNaviClick();
}
