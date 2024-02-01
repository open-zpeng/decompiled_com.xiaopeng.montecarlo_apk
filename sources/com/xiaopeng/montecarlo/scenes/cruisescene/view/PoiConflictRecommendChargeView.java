package com.xiaopeng.montecarlo.scenes.cruisescene.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.navcore.search.charge.RecommendChargerBean;
import com.xiaopeng.montecarlo.root.carservice.CarServiceManager;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.scenes.cruisescene.util.ToggleShowCardConflictHelper;
import com.xiaopeng.montecarlo.views.OnViewStateChangedListener;
import com.xiaopeng.montecarlo.views.RecommendChargerView;
import com.xiaopeng.xui.widget.XLinearLayout;
import java.util.List;
/* loaded from: classes3.dex */
public class PoiConflictRecommendChargeView extends XLinearLayout implements ToggleShowCardConflictHelper.IConflictControlView {
    private boolean mCanShowByOther;
    private int mDataSize;
    private OnViewStateChangedListener mVisibilityChangeListener;

    @Override // com.xiaopeng.montecarlo.scenes.cruisescene.util.ToggleShowCardConflictHelper.IConflictControlView
    public ViewGroup getToggleView() {
        return this;
    }

    public PoiConflictRecommendChargeView(Context context) {
        this(context, null);
    }

    public PoiConflictRecommendChargeView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PoiConflictRecommendChargeView(Context context, @Nullable AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public PoiConflictRecommendChargeView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mCanShowByOther = true;
        this.mDataSize = 0;
    }

    public void setOnVisibilityChangeListener(OnViewStateChangedListener onViewStateChangedListener) {
        this.mVisibilityChangeListener = onViewStateChangedListener;
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        OnViewStateChangedListener onViewStateChangedListener = this.mVisibilityChangeListener;
        if (onViewStateChangedListener != null) {
            onViewStateChangedListener.onVisibleStateChanged(this, this, i);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.cruisescene.util.ToggleShowCardConflictHelper.IConflictControlView
    public void setCanShowByOther(boolean z) {
        this.mCanShowByOther = z;
    }

    public void setRecommendViewDataList(List<RecommendChargerBean> list, RecommendChargerView.RecommendChargeClickListener recommendChargeClickListener) {
        if (CollectionUtils.isEmpty(list)) {
            this.mDataSize = 0;
            setVisibility(8);
            return;
        }
        this.mDataSize = list.size();
        setVisibility(this.mCanShowByOther ? 0 : 8);
        int carRemainDistance = CarServiceManager.getInstance().getCarRemainDistance();
        int i = 0;
        while (i < list.size()) {
            RecommendChargerBean recommendChargerBean = list.get(i);
            int i2 = i + 1;
            if (getChildCount() < i2) {
                addView(new RecommendChargerView(getContext()));
            }
            RecommendChargerView recommendChargerView = (RecommendChargerView) getChildAt(i);
            recommendChargerView.setVisibility(0);
            recommendChargerView.updateRecommendViewData(recommendChargerBean, carRemainDistance);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) recommendChargerView.getLayoutParams();
            if (i == 0) {
                layoutParams.topMargin = 0;
            } else {
                layoutParams.topMargin = ContextUtils.getDimensionPixelSize(R.dimen.charge_shadow_margin) * (-1);
            }
            recommendChargerView.setLayoutParams(layoutParams);
            recommendChargerView.setListener(recommendChargeClickListener);
            i = i2;
        }
        for (int size = list.size(); size < getChildCount(); size++) {
            getChildAt(size).setVisibility(8);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.cruisescene.util.ToggleShowCardConflictHelper.IConflictControlView
    public boolean hasData() {
        return this.mDataSize > 0;
    }
}
