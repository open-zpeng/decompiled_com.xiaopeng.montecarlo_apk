package com.xiaopeng.montecarlo.scenes.downloadscene.recycleview.holder;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.scenes.downloadscene.bean.CityItem;
import com.xiaopeng.montecarlo.scenes.downloadscene.recycleview.listener.IOnRecyclerViewListener;
import com.xiaopeng.montecarlo.util.ThemeWatcherUtil;
import com.xiaopeng.xui.widget.XCircularProgressBar;
import com.xiaopeng.xui.widget.XTextView;
import javax.validation.constraints.NotNull;
/* loaded from: classes2.dex */
public class BaseCityViewHolder extends AbstractCityViewHolder {
    public BaseCityViewHolder(View view) {
        super(view);
        this.mGroupView = (ViewGroup) view.findViewById(R.id.base_function);
        this.mTvCityTitle = (XTextView) this.mGroupView.findViewById(R.id.base_function_package_title);
        this.mDownloadProgressBar = (XCircularProgressBar) this.mGroupView.findViewById(R.id.base_package_download_progress_bar);
        this.mTvDownloadState = (XTextView) this.mGroupView.findViewById(R.id.base_package_download_status);
    }

    @Override // com.xiaopeng.montecarlo.scenes.downloadscene.recycleview.holder.BaseHolder
    public View getClickableView() {
        return this.mDownloadProgressBar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.scenes.downloadscene.recycleview.holder.BaseHolder
    public Drawable getGroupViewBackgroundDrawable(@NotNull CityItem cityItem) {
        return ThemeWatcherUtil.getDrawable(R.drawable.shape_bg_list_item_normal);
    }

    @Override // com.xiaopeng.montecarlo.scenes.downloadscene.recycleview.holder.AbstractCityViewHolder, com.xiaopeng.montecarlo.scenes.downloadscene.recycleview.holder.BaseHolder
    public void onBindHolder(CityItem cityItem, IOnRecyclerViewListener.OnItemClickListener onItemClickListener) {
        if (cityItem != null) {
            super.onBindHolder(cityItem, onItemClickListener);
        }
    }
}
