package com.xiaopeng.montecarlo.views.poicard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.xui.widget.XLinearLayout;
import com.xiaopeng.xui.widget.XTextView;
import java.util.Map;
/* loaded from: classes3.dex */
public class PoiCardEvaluationContainer extends XLinearLayout implements BasePoiCardViewContract {
    public static final String KEY_POI_INFO = "poiInfo";
    private static final L.Tag TAG = new L.Tag("Card_PCEC");
    private Context mContext;
    private XTextView mEvaluationCount;
    private LayoutInflater mInflater;
    private OnChildLayoutCompletedListener mLayoutListener;
    private XPPoiInfo mPoiInfo;
    private ViewGroup mRootView;
    private XTextView mTvStopFavourable;
    private XTextView mVisitCount;

    @Override // com.xiaopeng.montecarlo.views.poicard.BasePoiCardViewContract
    public void onInitOrThemeSwitch() {
    }

    @Override // com.xiaopeng.montecarlo.views.poicard.BasePoiCardViewContract
    public void setViewListener() {
    }

    public PoiCardEvaluationContainer(Context context, Map<String, Object> map, OnChildLayoutCompletedListener onChildLayoutCompletedListener) {
        super(context);
        this.mLayoutListener = onChildLayoutCompletedListener;
        init(context, map);
    }

    private void initView() {
        this.mInflater = LayoutInflater.from(this.mContext);
        this.mRootView = (ViewGroup) this.mInflater.inflate(R.layout.layout_poi_card_evaluation_container, (ViewGroup) this, true);
        executeAfterViewInflated(this.mRootView);
    }

    public void setVisitCountText(String str) {
        XTextView xTextView = this.mVisitCount;
        if (xTextView != null) {
            xTextView.setText(str);
        }
    }

    public void showVisitCount() {
        XTextView xTextView = this.mVisitCount;
        if (xTextView != null) {
            xTextView.setVisibility(0);
        }
    }

    public void hideVisitCount() {
        XTextView xTextView = this.mVisitCount;
        if (xTextView != null) {
            xTextView.setVisibility(8);
        }
    }

    public void setEvaluationCountTextColor(int i) {
        XTextView xTextView = this.mEvaluationCount;
        if (xTextView != null) {
            xTextView.setTextColor(i);
        }
    }

    public void showEvaluationCount() {
        XTextView xTextView = this.mEvaluationCount;
        if (xTextView != null) {
            xTextView.setVisibility(0);
        }
    }

    public void hideEvaluationCount() {
        XTextView xTextView = this.mEvaluationCount;
        if (xTextView != null) {
            xTextView.setVisibility(8);
        }
    }

    public void setEvaluationCountText(String str) {
        XTextView xTextView = this.mEvaluationCount;
        if (xTextView != null) {
            xTextView.setText(str);
        }
    }

    @Override // com.xiaopeng.montecarlo.views.poicard.BasePoiCardViewContract
    public void init(Context context, Map<String, Object> map) {
        formatParams(context, map);
        initView();
    }

    @Override // com.xiaopeng.montecarlo.views.poicard.BasePoiCardViewContract
    public void executeAfterViewInflated(View view) {
        if (view == null) {
            L.e(TAG, "execute after view inflated view is null");
            return;
        }
        this.mVisitCount = (XTextView) view.findViewById(R.id.tv_visit_count);
        this.mTvStopFavourable = (XTextView) view.findViewById(R.id.tv_stop_favourable);
        this.mEvaluationCount = (XTextView) view.findViewById(R.id.tv_evaluation_count);
        executeViewOperation();
        OnChildLayoutCompletedListener onChildLayoutCompletedListener = this.mLayoutListener;
        if (onChildLayoutCompletedListener != null) {
            onChildLayoutCompletedListener.onChildLayoutCompleted(this.mRootView);
        }
    }

    @Override // com.xiaopeng.montecarlo.views.poicard.BasePoiCardViewContract
    public void executeViewOperation() {
        setViewListener();
        renderEvaluteTag();
    }

    @Override // com.xiaopeng.montecarlo.views.poicard.BasePoiCardViewContract
    public void refresh(Context context, Map<String, Object> map, OnChildLayoutCompletedListener onChildLayoutCompletedListener) {
        this.mLayoutListener = onChildLayoutCompletedListener;
        formatParams(context, map);
        executeViewOperation();
    }

    @Override // com.xiaopeng.montecarlo.views.poicard.BasePoiCardViewContract
    public void formatParams(Context context, Map<String, Object> map) {
        if (context == null) {
            throw new IllegalArgumentException("context can not be null");
        }
        if (map == null) {
            throw new IllegalArgumentException("params can not be null");
        }
        this.mContext = context;
        if (map.get("poiInfo") != null) {
            this.mPoiInfo = (XPPoiInfo) map.get("poiInfo");
        }
    }

    private void renderEvaluteTag() {
        XPPoiInfo xPPoiInfo = this.mPoiInfo;
        if (xPPoiInfo == null) {
            return;
        }
        boolean z = xPPoiInfo.getVisitCount() > 0 || this.mPoiInfo.getEvaluationCount() > 0 || this.mPoiInfo.isFreeParking();
        setVisibility(z ? 0 : 8);
        if (z) {
            if (this.mPoiInfo.getVisitCount() > 0) {
                showVisitCount();
                setVisitCountText(String.format(ContextUtils.getString(R.string.search_result_visit_count), Integer.valueOf(this.mPoiInfo.getVisitCount())));
            } else {
                hideVisitCount();
            }
            this.mTvStopFavourable.setVisibility(this.mPoiInfo.isFreeParking() ? 0 : 8);
            if (this.mPoiInfo.getEvaluationCount() > 0) {
                showEvaluationCount();
                setEvaluationCountText(String.format(ContextUtils.getString(R.string.search_result_evaluation_count), Integer.valueOf(this.mPoiInfo.getEvaluationCount())));
                return;
            }
            hideEvaluationCount();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.xui.widget.XLinearLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mLayoutListener = null;
    }
}
