package com.xiaopeng.montecarlo.scenes.downloadscene.recycleview.holder;

import android.view.View;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.scenes.downloadscene.bean.CityItem;
import com.xiaopeng.montecarlo.scenes.downloadscene.recycleview.listener.IOnRecyclerViewListener;
import com.xiaopeng.montecarlo.scenes.downloadscene.recycleview.util.DownloadUtils;
import com.xiaopeng.xui.widget.XCircularProgressBar;
import javax.validation.constraints.NotNull;
/* loaded from: classes2.dex */
public abstract class AbstractCityViewHolder extends BaseHolder<CityItem> {
    private static final L.Tag TAG = new L.Tag("AbstractCityViewHolder");
    protected XCircularProgressBar mDownloadProgressBar;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.scenes.downloadscene.recycleview.holder.BaseHolder
    public boolean showDividerLine(@NotNull CityItem cityItem) {
        return true;
    }

    public XCircularProgressBar getDownloadProgressBar() {
        return this.mDownloadProgressBar;
    }

    public AbstractCityViewHolder(View view) {
        super(view);
    }

    public View getTouchArea() {
        return this.mDownloadProgressBar;
    }

    @Override // com.xiaopeng.montecarlo.scenes.downloadscene.recycleview.holder.BaseHolder
    public String getCityName(@NotNull CityItem cityItem) {
        return cityItem.getCityTitle();
    }

    @Override // com.xiaopeng.montecarlo.scenes.downloadscene.recycleview.holder.BaseHolder
    public String getProgressState(@NotNull CityItem cityItem) {
        return DownloadUtils.getCityTaskStatus(cityItem);
    }

    @Override // com.xiaopeng.montecarlo.scenes.downloadscene.recycleview.holder.BaseHolder
    public void onBindHolder(final CityItem cityItem, final IOnRecyclerViewListener.OnItemClickListener onItemClickListener) {
        if (cityItem != null) {
            updateProgressUi(cityItem);
            super.onBindHolder((AbstractCityViewHolder) cityItem, onItemClickListener);
            if (getTouchArea() == null) {
                return;
            }
            getTouchArea().setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.downloadscene.recycleview.holder.-$$Lambda$AbstractCityViewHolder$gQgTTkhBWjNYO16u26rvFHqArEY
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AbstractCityViewHolder.this.lambda$onBindHolder$0$AbstractCityViewHolder(onItemClickListener, cityItem, view);
                }
            });
        }
    }

    public /* synthetic */ void lambda$onBindHolder$0$AbstractCityViewHolder(IOnRecyclerViewListener.OnItemClickListener onItemClickListener, CityItem cityItem, View view) {
        if (onItemClickListener != null) {
            onItemClickListener.onChildItemClick(cityItem, this);
        }
    }

    private void updateProgressUi(CityItem cityItem) {
        XCircularProgressBar xCircularProgressBar = this.mDownloadProgressBar;
        if (xCircularProgressBar == null || cityItem == null) {
            L.Tag tag = TAG;
            L.w(tag, "updateProgressUi failed " + this.mDownloadProgressBar + ", " + cityItem);
            return;
        }
        xCircularProgressBar.setVisibility(4);
        if (cityItem.isNeedShowProgressBar()) {
            if (cityItem.isReady()) {
                this.mDownloadProgressBar.setIndicatorType(3);
            } else {
                if (cityItem.isPaused()) {
                    this.mDownloadProgressBar.setIndicatorType(0);
                }
                if (cityItem.isDownloading() || cityItem.isWaiting()) {
                    this.mDownloadProgressBar.setIndicatorType(2);
                }
            }
            this.mDownloadProgressBar.setProgress(cityItem.getDownloadPercent());
            this.mDownloadProgressBar.setVisibility(0);
            return;
        }
        this.mDownloadProgressBar.setVisibility(8);
    }
}
