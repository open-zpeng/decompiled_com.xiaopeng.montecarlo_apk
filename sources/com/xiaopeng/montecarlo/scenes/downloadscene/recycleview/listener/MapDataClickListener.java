package com.xiaopeng.montecarlo.scenes.downloadscene.recycleview.listener;

import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.scenes.downloadscene.bean.CityItem;
import com.xiaopeng.montecarlo.scenes.downloadscene.bean.ProvinceItem;
import com.xiaopeng.montecarlo.scenes.downloadscene.operation.event.DownloadStateEvent;
import com.xiaopeng.montecarlo.scenes.downloadscene.operation.transition.DownloadStateManager;
import com.xiaopeng.montecarlo.scenes.downloadscene.recycleview.holder.BaseHolder;
import com.xiaopeng.montecarlo.scenes.downloadscene.recycleview.holder.ProvinceViewHolder;
import com.xiaopeng.montecarlo.scenes.downloadscene.recycleview.listener.IOnRecyclerViewListener;
import com.xiaopeng.montecarlo.util.ThemeWatcherUtil;
/* loaded from: classes2.dex */
public class MapDataClickListener implements IOnRecyclerViewListener.OnItemClickListener {
    private static final L.Tag TAG = new L.Tag("MapDataClickListener");
    private DownloadStateManager mOperator;

    public MapDataClickListener(@NonNull DownloadStateManager downloadStateManager) {
        this.mOperator = downloadStateManager;
    }

    @Override // com.xiaopeng.montecarlo.scenes.downloadscene.recycleview.listener.IOnRecyclerViewListener.OnItemClickListener
    public void onGroupItemClick(ProvinceItem provinceItem, ProvinceViewHolder provinceViewHolder, int i) {
        if (provinceItem == null || provinceViewHolder == null) {
            return;
        }
        L.Tag tag = TAG;
        L.d(tag, "onGroupItemClick: " + provinceItem.getProvinceTitle());
        if (provinceItem.isExpand()) {
            provinceViewHolder.getImgProvinceArrow().setImageResource(ThemeWatcherUtil.getDrawableResId(R.drawable.vector_ic_xsmall_lower));
        } else {
            provinceViewHolder.getImgProvinceArrow().setImageResource(ThemeWatcherUtil.getDrawableResId(R.drawable.vector_ic_xsmall_upper));
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.downloadscene.recycleview.listener.IOnRecyclerViewListener.OnItemClickListener
    public void onChildItemClick(CityItem cityItem, BaseHolder baseHolder) {
        if (this.mOperator == null) {
            L.w(TAG, "onChildItemClick failed");
        } else if (cityItem != null) {
            L.Tag tag = TAG;
            L.d(tag, "onChildItemClick " + cityItem.getCityTitle());
            this.mOperator.onOperate(cityItem, DownloadStateEvent.DOWNLOAD_EVENT_START_OR_PAUSE);
        }
    }
}
