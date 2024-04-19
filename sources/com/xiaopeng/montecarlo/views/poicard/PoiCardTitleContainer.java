package com.xiaopeng.montecarlo.views.poicard;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiCategory;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.util.Utils;
import com.xiaopeng.montecarlo.views.NaviImageView;
import com.xiaopeng.xui.widget.XRelativeLayout;
import com.xiaopeng.xui.widget.XTextView;
import java.util.Map;
/* loaded from: classes3.dex */
public class PoiCardTitleContainer extends XRelativeLayout implements BasePoiCardViewContract {
    public static final String KEY_POI_INFO = "poiInfo";
    private static final L.Tag TAG = new L.Tag("Card_PCTC");
    private Context mContext;
    private LayoutInflater mInflater;
    private OnChildLayoutCompletedListener mLayoutListener;
    private XPPoiInfo mPoiInfo;
    private XTextView mPoiName;
    private NaviImageView mPoiType;
    private ViewGroup mRootView;

    @Override // com.xiaopeng.montecarlo.views.poicard.BasePoiCardViewContract
    public void onInitOrThemeSwitch() {
    }

    @Override // com.xiaopeng.montecarlo.views.poicard.BasePoiCardViewContract
    public void setViewListener() {
    }

    public PoiCardTitleContainer(Context context, Map<String, Object> map, OnChildLayoutCompletedListener onChildLayoutCompletedListener) {
        super(context);
        this.mLayoutListener = onChildLayoutCompletedListener;
        init(context, map);
    }

    private void initView() {
        this.mInflater = LayoutInflater.from(this.mContext);
        this.mRootView = (ViewGroup) this.mInflater.inflate(R.layout.layout_poi_card_title_container, (ViewGroup) this, true);
        executeAfterViewInflated(this.mRootView);
    }

    public void setPoiTypeImageDrawable(Drawable drawable) {
        NaviImageView naviImageView = this.mPoiType;
        if (naviImageView != null) {
            naviImageView.setImageDrawable(drawable);
        }
    }

    public void showPoiType() {
        NaviImageView naviImageView = this.mPoiType;
        if (naviImageView != null) {
            naviImageView.setVisibility(0);
        }
    }

    public void hidePoiType() {
        NaviImageView naviImageView = this.mPoiType;
        if (naviImageView != null) {
            naviImageView.setVisibility(8);
        }
    }

    public void setPoiNameTextColor(int i) {
        XTextView xTextView = this.mPoiName;
        if (xTextView != null) {
            xTextView.setTextColor(i);
        }
    }

    public void setPoiNameText(String str) {
        XTextView xTextView = this.mPoiName;
        if (xTextView != null) {
            xTextView.setText(str);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mPoiName.getLayoutParams();
            int i = 0;
            NaviImageView naviImageView = this.mPoiType;
            if (naviImageView != null && naviImageView.getVisibility() == 0) {
                if (Utils.isClearFontStyle(this.mPoiName)) {
                    i = ContextUtils.getDimensionPixelSize(R.dimen.poi_name_top_margin_clear_font_style);
                } else {
                    i = ContextUtils.getDimensionPixelSize(R.dimen.poi_name_top_margin_delicate_font_style);
                }
                if (L.ENABLE) {
                    L.Tag tag = TAG;
                    L.d(tag, "setPoiNameText current topMargin:" + marginLayoutParams.topMargin + ",topMargin:" + i);
                }
            }
            if (marginLayoutParams.topMargin != i) {
                marginLayoutParams.topMargin = i;
                this.mPoiName.requestLayout();
            }
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
        this.mPoiType = (NaviImageView) view.findViewById(R.id.poi_type);
        this.mPoiName = (XTextView) view.findViewById(R.id.poi_name);
        executeViewOperation();
        OnChildLayoutCompletedListener onChildLayoutCompletedListener = this.mLayoutListener;
        if (onChildLayoutCompletedListener != null) {
            onChildLayoutCompletedListener.onChildLayoutCompleted(this.mRootView);
        }
    }

    @Override // com.xiaopeng.montecarlo.views.poicard.BasePoiCardViewContract
    public void executeViewOperation() {
        setViewListener();
        renderBasicInfo();
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

    private void renderBasicInfo() {
        renderPoiTypeInfo();
        renderPoiNameInfo();
    }

    private void renderPoiNameInfo() {
        if (this.mPoiInfo == null) {
            return;
        }
        setVisibility(0);
        setPoiNameText(this.mPoiInfo.getName());
    }

    private void renderPoiTypeInfo() {
        XPPoiInfo xPPoiInfo = this.mPoiInfo;
        if (xPPoiInfo == null) {
            return;
        }
        if (XPPoiCategory.isXPSelfCharge(xPPoiInfo.getCategory())) {
            showPoiType();
        } else {
            hidePoiType();
        }
    }

    public CharSequence getTitle() {
        XTextView xTextView = this.mPoiName;
        if (xTextView != null) {
            return xTextView.getText();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.xui.widget.XRelativeLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mLayoutListener = null;
    }
}
