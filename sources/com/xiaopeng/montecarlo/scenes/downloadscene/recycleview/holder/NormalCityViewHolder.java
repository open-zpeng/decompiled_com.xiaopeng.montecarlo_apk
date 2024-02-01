package com.xiaopeng.montecarlo.scenes.downloadscene.recycleview.holder;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.scenes.downloadscene.bean.CityItem;
import com.xiaopeng.montecarlo.scenes.downloadscene.recycleview.listener.IOnRecyclerViewListener;
import com.xiaopeng.montecarlo.util.ThemeWatcherUtil;
import com.xiaopeng.xui.view.XView;
import com.xiaopeng.xui.widget.XCircularProgressBar;
import com.xiaopeng.xui.widget.XTextView;
import javax.validation.constraints.NotNull;
/* loaded from: classes3.dex */
public class NormalCityViewHolder extends AbstractCityViewHolder {
    private TextView mTvThisIsCurrentCity;

    public TextView getTvThisIsCurrentCity() {
        return this.mTvThisIsCurrentCity;
    }

    public NormalCityViewHolder(View view) {
        super(view);
        this.mGroupView = (ViewGroup) view.findViewById(R.id.recycle_expand_child);
        this.mDivideLine = (XView) view.findViewById(R.id.item_city_line_1);
        this.mTvCityTitle = (XTextView) view.findViewById(R.id.tv_city_name);
        this.mTvThisIsCurrentCity = (TextView) view.findViewById(R.id.tv_this_is_current_city);
        this.mDownloadProgressBar = (XCircularProgressBar) view.findViewById(R.id.base_package_download_progress_bar);
        this.mTvDownloadState = (XTextView) view.findViewById(R.id.base_package_download_status);
    }

    @Override // com.xiaopeng.montecarlo.scenes.downloadscene.recycleview.holder.BaseHolder
    public View getClickableView() {
        return this.mGroupView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.scenes.downloadscene.recycleview.holder.BaseHolder
    public Drawable getGroupViewBackgroundDrawable(@NotNull CityItem cityItem) {
        return ThemeWatcherUtil.getDrawable(cityItem.isLastItem() ? R.drawable.shape_bg_list_item_bottom : R.drawable.shape_bg_list_item_middle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.scenes.downloadscene.recycleview.holder.AbstractCityViewHolder, com.xiaopeng.montecarlo.scenes.downloadscene.recycleview.holder.BaseHolder
    public boolean showDividerLine(@NotNull CityItem cityItem) {
        return !cityItem.isLastItem();
    }

    @Override // com.xiaopeng.montecarlo.scenes.downloadscene.recycleview.holder.AbstractCityViewHolder, com.xiaopeng.montecarlo.scenes.downloadscene.recycleview.holder.BaseHolder
    public void onBindHolder(CityItem cityItem, IOnRecyclerViewListener.OnItemClickListener onItemClickListener) {
        if (cityItem != null) {
            if (this.mTvThisIsCurrentCity != null) {
                if (cityItem.isCurrentCity()) {
                    this.mTvThisIsCurrentCity.setVisibility(0);
                    this.mTvThisIsCurrentCity.setTextColor(ThemeWatcherUtil.getColor(R.color.primary_text02));
                } else {
                    this.mTvThisIsCurrentCity.setVisibility(8);
                }
            }
            super.onBindHolder(cityItem, onItemClickListener);
        }
    }
}
