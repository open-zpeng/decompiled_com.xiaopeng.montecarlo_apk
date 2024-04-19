package com.xiaopeng.montecarlo.views.poicard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.util.ThemeWatcherUtil;
import com.xiaopeng.montecarlo.views.NaviImageView;
import com.xiaopeng.xui.widget.XRelativeLayout;
import com.xiaopeng.xui.widget.XTextView;
import java.util.Map;
/* loaded from: classes3.dex */
public class PoiCardParkContainer extends XRelativeLayout implements BasePoiCardViewContract {
    public static final String KEY_POI_INFO = "poiInfo";
    private static final L.Tag TAG = new L.Tag("Card_PCPC");
    private Context mContext;
    private LayoutInflater mInflater;
    private OnChildLayoutCompletedListener mLayoutListener;
    private NaviImageView mParkDivider;
    private NaviImageView mParkIcon;
    private XTextView mParkInfoLeft;
    private XTextView mParkInfoTotal;
    private XPPoiInfo mPoiInfo;
    private ViewGroup mRootView;

    @Override // com.xiaopeng.montecarlo.views.poicard.BasePoiCardViewContract
    public void setViewListener() {
    }

    public PoiCardParkContainer(Context context, Map<String, Object> map, OnChildLayoutCompletedListener onChildLayoutCompletedListener) {
        super(context);
        this.mLayoutListener = onChildLayoutCompletedListener;
        init(context, map);
    }

    private void initView() {
        this.mInflater = LayoutInflater.from(this.mContext);
        this.mRootView = (ViewGroup) this.mInflater.inflate(R.layout.layout_poi_item_park, (ViewGroup) this, true);
        this.mRootView.setMinimumHeight(ContextUtils.getDimensionPixelSize(R.dimen.poi_item_height));
        executeAfterViewInflated(this.mRootView);
    }

    public void setParkIconImageResource() {
        XPPoiInfo xPPoiInfo = this.mPoiInfo;
        if (xPPoiInfo == null || this.mParkIcon == null) {
            return;
        }
        if (xPPoiInfo.getParkTotal() == 0 && this.mPoiInfo.getParkRemain() == 0) {
            this.mParkIcon.setImageResource(ThemeWatcherUtil.getDrawableResId(R.drawable.vector_tag_texttag_smallunavailable_p));
        } else {
            this.mParkIcon.setImageResource(ThemeWatcherUtil.getDrawableResId(R.drawable.vector_tag_texttag_smallp));
        }
    }

    public void setParkInfoLeftTextColor(int i) {
        XTextView xTextView = this.mParkInfoLeft;
        if (xTextView != null) {
            xTextView.setTextColor(i);
        }
    }

    public void hideParkInfoLeft() {
        XTextView xTextView = this.mParkInfoLeft;
        if (xTextView == null || xTextView.getVisibility() == 8) {
            return;
        }
        this.mParkInfoLeft.setVisibility(8);
    }

    public void showParkInfoLeft() {
        XTextView xTextView = this.mParkInfoLeft;
        if (xTextView == null || xTextView.getVisibility() == 0) {
            return;
        }
        this.mParkInfoLeft.setVisibility(0);
    }

    public void setParkInfoLeftText(String str) {
        XTextView xTextView = this.mParkInfoLeft;
        if (xTextView != null) {
            xTextView.setText(str);
        }
    }

    public void setParkInfoTotalTextColor(int i) {
        XTextView xTextView = this.mParkInfoTotal;
        if (xTextView != null) {
            xTextView.setTextColor(i);
        }
    }

    public void hideParkInfoTotal() {
        XTextView xTextView = this.mParkInfoTotal;
        if (xTextView == null || xTextView.getVisibility() == 8) {
            return;
        }
        this.mParkInfoTotal.setVisibility(8);
    }

    public void showParkInfoTotal() {
        XTextView xTextView = this.mParkInfoTotal;
        if (xTextView == null || xTextView.getVisibility() == 0) {
            return;
        }
        this.mParkInfoTotal.setVisibility(0);
    }

    public void setParkInfoTotalText(String str) {
        XTextView xTextView = this.mParkInfoTotal;
        if (xTextView != null) {
            xTextView.setText(str);
        }
    }

    public void setParkDividerImageResource(int i) {
        NaviImageView naviImageView = this.mParkDivider;
        if (naviImageView != null) {
            naviImageView.setImageResource(i);
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
        this.mParkIcon = (NaviImageView) view.findViewById(R.id.icon_poi_park);
        this.mParkInfoLeft = (XTextView) view.findViewById(R.id.tv_park_info_left);
        this.mParkInfoTotal = (XTextView) view.findViewById(R.id.tv_park_info_total);
        this.mParkDivider = (NaviImageView) view.findViewById(R.id.poi_park_divider);
        executeViewOperation();
        OnChildLayoutCompletedListener onChildLayoutCompletedListener = this.mLayoutListener;
        if (onChildLayoutCompletedListener != null) {
            onChildLayoutCompletedListener.onChildLayoutCompleted(this.mRootView);
        }
    }

    @Override // com.xiaopeng.montecarlo.views.poicard.BasePoiCardViewContract
    public void executeViewOperation() {
        setViewListener();
        renderParkInfo();
        onInitOrThemeSwitch();
    }

    @Override // com.xiaopeng.montecarlo.views.poicard.BasePoiCardViewContract
    public void onInitOrThemeSwitch() {
        setParkIconImageResource();
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

    private void renderParkInfo() {
        resetPartInfoLayout();
        XPPoiInfo xPPoiInfo = this.mPoiInfo;
        if (xPPoiInfo == null) {
            return;
        }
        if (xPPoiInfo.getParkTotal() == 0 && this.mPoiInfo.getParkRemain() == 0) {
            showParkIsFull();
        } else if (this.mPoiInfo.getParkTotal() > 0 && this.mPoiInfo.getParkRemain() > 0) {
            showParkInfoWithRemain();
        } else if (this.mPoiInfo.getParkTotal() > 0 && this.mPoiInfo.getParkRemain() < 0) {
            showTotalPark();
        } else {
            showNonePark();
        }
    }

    private void resetPartInfoLayout() {
        hideParkInfoLeft();
        hideParkInfoTotal();
    }

    private void showParkIsFull() {
        setVisibility(0);
        showParkInfoTotal();
        setParkInfoTotalText(ContextUtils.getString(R.string.park_info_full_card));
    }

    private void showParkInfoWithRemain() {
        setVisibility(0);
        showParkInfoLeft();
        setParkInfoLeftText(String.format(ContextUtils.getString(R.string.park_info_remain_card_left), Integer.valueOf(this.mPoiInfo.getParkRemain())));
        showParkInfoTotal();
        setParkInfoTotalText("/" + String.format(ContextUtils.getString(R.string.park_info_total_card), Integer.valueOf(this.mPoiInfo.getParkTotal())));
    }

    private void showTotalPark() {
        setVisibility(0);
        showParkInfoTotal();
        setParkInfoTotalText(String.format(ContextUtils.getString(R.string.park_info_total), Integer.valueOf(this.mPoiInfo.getParkTotal())));
    }

    private void showNonePark() {
        setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.xui.widget.XRelativeLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mLayoutListener = null;
    }
}
