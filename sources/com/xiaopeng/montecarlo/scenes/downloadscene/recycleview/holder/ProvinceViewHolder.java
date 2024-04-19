package com.xiaopeng.montecarlo.scenes.downloadscene.recycleview.holder;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.scenes.downloadscene.bean.ProvinceItem;
import com.xiaopeng.montecarlo.scenes.downloadscene.recycleview.listener.IOnRecyclerViewListener;
import com.xiaopeng.montecarlo.scenes.downloadscene.recycleview.util.DownloadUtils;
import com.xiaopeng.montecarlo.util.ThemeWatcherUtil;
import com.xiaopeng.xui.view.XView;
import com.xiaopeng.xui.widget.XImageButton;
import com.xiaopeng.xui.widget.XTextView;
import javax.validation.constraints.NotNull;
/* loaded from: classes3.dex */
public class ProvinceViewHolder extends BaseHolder<ProvinceItem> {
    private XImageButton mImgProvinceArrow;

    public XImageButton getImgProvinceArrow() {
        return this.mImgProvinceArrow;
    }

    public ProvinceViewHolder(View view) {
        super(view);
        this.mGroupView = (ViewGroup) view.findViewById(R.id.recycle_expand_group);
        this.mDivideLine = (XView) view.findViewById(R.id.province_item_line_1);
        this.mTvCityTitle = (XTextView) view.findViewById(R.id.tv_province_title);
        this.mTvDownloadState = (XTextView) view.findViewById(R.id.tv_total_size);
        this.mImgProvinceArrow = (XImageButton) view.findViewById(R.id.img_province_arrow);
    }

    @Override // com.xiaopeng.montecarlo.scenes.downloadscene.recycleview.holder.BaseHolder
    public View getClickableView() {
        return this.mGroupView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.scenes.downloadscene.recycleview.holder.BaseHolder
    public boolean showDividerLine(@NotNull ProvinceItem provinceItem) {
        return provinceItem.isExpand();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.scenes.downloadscene.recycleview.holder.BaseHolder
    public Drawable getGroupViewBackgroundDrawable(@NotNull ProvinceItem provinceItem) {
        return ThemeWatcherUtil.getDrawable(provinceItem.isExpand() ? R.drawable.shape_bg_list_item_top : R.drawable.shape_bg_list_item_normal);
    }

    @Override // com.xiaopeng.montecarlo.scenes.downloadscene.recycleview.holder.BaseHolder
    public void onBindHolder(ProvinceItem provinceItem, IOnRecyclerViewListener.OnItemClickListener onItemClickListener) {
        if (provinceItem != null) {
            if (this.mImgProvinceArrow != null) {
                if (provinceItem.isExpand()) {
                    this.mImgProvinceArrow.setImageResource(R.drawable.vector_ic_xsmall_upper);
                } else {
                    this.mImgProvinceArrow.setImageResource(R.drawable.vector_ic_xsmall_lower);
                }
                if (getClickableView() != null) {
                    this.mImgProvinceArrow.setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.downloadscene.recycleview.holder.-$$Lambda$ProvinceViewHolder$R9bDeXQcHICCLdILtFkMEDIdp-0
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            ProvinceViewHolder.this.lambda$onBindHolder$0$ProvinceViewHolder(view);
                        }
                    });
                }
            }
            super.onBindHolder((ProvinceViewHolder) provinceItem, onItemClickListener);
        }
    }

    public /* synthetic */ void lambda$onBindHolder$0$ProvinceViewHolder(View view) {
        getClickableView().callOnClick();
    }

    @Override // com.xiaopeng.montecarlo.scenes.downloadscene.recycleview.holder.BaseHolder
    public String getCityName(@NotNull ProvinceItem provinceItem) {
        return provinceItem.getProvinceTitle();
    }

    @Override // com.xiaopeng.montecarlo.scenes.downloadscene.recycleview.holder.BaseHolder
    public String getProgressState(@NotNull ProvinceItem provinceItem) {
        return DownloadUtils.getProvinceState(provinceItem);
    }
}
