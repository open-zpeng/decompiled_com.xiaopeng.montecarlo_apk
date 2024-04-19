package com.xiaopeng.montecarlo.scenes.searchscene.dataprovider;

import com.xiaopeng.montecarlo.navcore.bean.favorite.FavoriteAddress;
import java.util.List;
/* loaded from: classes3.dex */
public class SearchDeleteFavouriteParam extends SearchRequestParam {
    private List<FavoriteAddress> mFavoriteAddressList;

    public List<FavoriteAddress> getFavoriteAddress() {
        return this.mFavoriteAddressList;
    }

    public void setFavoriteAddress(List<FavoriteAddress> list) {
        this.mFavoriteAddressList = list;
    }
}
