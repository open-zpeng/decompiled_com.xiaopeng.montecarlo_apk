package com.xiaopeng.montecarlo.scenes.downloadscene.recycleview.holder;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.scenes.downloadscene.bean.BaseItem;
import com.xiaopeng.montecarlo.scenes.downloadscene.recycleview.listener.IOnRecyclerViewListener;
import com.xiaopeng.montecarlo.util.ThemeWatcherUtil;
import com.xiaopeng.xui.view.XView;
import com.xiaopeng.xui.widget.XTextView;
import javax.validation.constraints.NotNull;
/* loaded from: classes3.dex */
public abstract class BaseHolder<T extends BaseItem> extends RecyclerView.ViewHolder {
    protected XView mDivideLine;
    protected ViewGroup mGroupView;
    boolean mIsNeedShowDivider;
    protected XTextView mTvCityTitle;
    protected XTextView mTvDownloadState;

    public abstract String getCityName(@NotNull T t);

    public abstract View getClickableView();

    protected abstract Drawable getGroupViewBackgroundDrawable(@NotNull T t);

    public abstract String getProgressState(@NotNull T t);

    protected abstract boolean showDividerLine(@NotNull T t);

    public XTextView getMTvCityTitle() {
        return this.mTvCityTitle;
    }

    public ViewGroup getMGroupView() {
        return this.mGroupView;
    }

    public XView getMDivideLine() {
        return this.mDivideLine;
    }

    public XTextView getMTvDownloadState() {
        return this.mTvDownloadState;
    }

    public BaseHolder(View view) {
        super(view);
        this.mIsNeedShowDivider = true;
    }

    public void setShowDivideLine(boolean z) {
        this.mIsNeedShowDivider = z;
    }

    public void onBindHolder(T t, IOnRecyclerViewListener.OnItemClickListener onItemClickListener) {
        Drawable groupViewBackgroundDrawable;
        if (t == null) {
            return;
        }
        XTextView xTextView = this.mTvCityTitle;
        if (xTextView != null) {
            xTextView.setText(getCityName(t));
        }
        if (this.mGroupView != null && (groupViewBackgroundDrawable = getGroupViewBackgroundDrawable(t)) != null) {
            this.mGroupView.setBackground(groupViewBackgroundDrawable);
        }
        XView xView = this.mDivideLine;
        if (xView != null) {
            xView.setVisibility((this.mIsNeedShowDivider && showDividerLine(t)) ? 0 : 8);
        }
        if (this.mTvDownloadState != null) {
            if (t.isGrayColor()) {
                this.mTvDownloadState.setTextColor(ThemeWatcherUtil.getColor(R.color.primary_text03));
            } else {
                this.mTvDownloadState.setTextColor(ThemeWatcherUtil.getColor(R.color.primary_forward_color_normal));
            }
            this.mTvDownloadState.setText(getProgressState(t));
        }
    }
}
