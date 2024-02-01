package com.xiaopeng.montecarlo.scenes.downloadscene.recycleview.listener;

import com.xiaopeng.montecarlo.scenes.downloadscene.bean.CityItem;
import com.xiaopeng.montecarlo.scenes.downloadscene.bean.ProvinceItem;
import com.xiaopeng.montecarlo.scenes.downloadscene.recycleview.holder.BaseHolder;
import com.xiaopeng.montecarlo.scenes.downloadscene.recycleview.holder.ProvinceViewHolder;
/* loaded from: classes3.dex */
public interface IOnRecyclerViewListener {

    /* loaded from: classes3.dex */
    public interface OnItemClickListener {
        void onChildItemClick(CityItem cityItem, BaseHolder<CityItem> baseHolder);

        void onGroupItemClick(ProvinceItem provinceItem, ProvinceViewHolder provinceViewHolder, int i);
    }
}
