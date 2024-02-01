package com.xiaopeng.montecarlo.views.poicard;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.xui.widget.XLinearLayout;
import com.xiaopeng.xui.widget.XRelativeLayout;
import com.xiaopeng.xui.widget.XTextView;
import java.util.Map;
/* loaded from: classes3.dex */
public class PoiCardHomeCompanyContainer extends XLinearLayout implements BasePoiCardViewContract, View.OnClickListener {
    public static final String KEY_CLICK_LISTENER = "clickListener";
    public static final String KEY_SEARCH_DEST = "searchDest";
    private static final L.Tag TAG = new L.Tag("Card_PCHCC");
    private XTextView mBtnSettingCompany;
    private XTextView mBtnSettingHome;
    private OnPoiCardHomeCompanyContainerClickListener mClickListener;
    private XRelativeLayout mCompany;
    private Context mContext;
    private XRelativeLayout mHome;
    private LayoutInflater mInflater;
    private OnChildLayoutCompletedListener mLayoutListener;
    private ViewGroup mRootView;
    private int mSearchDest;

    /* loaded from: classes3.dex */
    public interface OnPoiCardHomeCompanyContainerClickListener {
        void onSettingCompanyContainerClick();

        void onSettingHomeContainerClick();
    }

    @Override // com.xiaopeng.montecarlo.views.poicard.BasePoiCardViewContract
    public void onInitOrThemeSwitch() {
    }

    @Override // com.xiaopeng.montecarlo.views.poicard.BasePoiCardViewContract
    public void executeAfterViewInflated(View view) {
        if (view == null) {
            L.e(TAG, "execute after view inflated view is null");
            return;
        }
        this.mHome = (XRelativeLayout) view.findViewById(R.id.setting_home_container);
        this.mBtnSettingHome = (XTextView) view.findViewById(R.id.poi_btn_setting_home);
        this.mCompany = (XRelativeLayout) view.findViewById(R.id.setting_company_container);
        this.mBtnSettingCompany = (XTextView) view.findViewById(R.id.poi_btn_setting_company);
        executeViewOperation();
        OnChildLayoutCompletedListener onChildLayoutCompletedListener = this.mLayoutListener;
        if (onChildLayoutCompletedListener != null) {
            onChildLayoutCompletedListener.onChildLayoutCompleted(this.mRootView);
        }
    }

    @Override // com.xiaopeng.montecarlo.views.poicard.BasePoiCardViewContract
    public void executeViewOperation() {
        setViewListener();
        renderLayout();
    }

    @Override // com.xiaopeng.montecarlo.views.poicard.BasePoiCardViewContract
    public void setViewListener() {
        XRelativeLayout xRelativeLayout = this.mHome;
        if (xRelativeLayout != null) {
            xRelativeLayout.setOnClickListener(this);
        }
        XRelativeLayout xRelativeLayout2 = this.mCompany;
        if (xRelativeLayout2 != null) {
            xRelativeLayout2.setOnClickListener(this);
        }
    }

    private void renderLayout() {
        hideHomeContainer();
        hideCompanyContainer();
        int i = this.mSearchDest;
        if (i == 1001) {
            showHomeContainer();
        } else if (i == 1002) {
            showCompanyContainer();
        }
    }

    public PoiCardHomeCompanyContainer(Context context, Map<String, Object> map, OnChildLayoutCompletedListener onChildLayoutCompletedListener) {
        super(context);
        this.mSearchDest = 1000;
        this.mLayoutListener = onChildLayoutCompletedListener;
        init(context, map);
    }

    private void initView() {
        this.mInflater = LayoutInflater.from(this.mContext);
        this.mRootView = (ViewGroup) this.mInflater.inflate(R.layout.layout_poi_setting_home_or_company_container, (ViewGroup) this, true);
        this.mRootView.setPadding(ContextUtils.getDimensionPixelSize(R.dimen.poi_card_content_left_offset), this.mRootView.getPaddingTop(), ContextUtils.getDimensionPixelSize(R.dimen.poi_card_content_right_offset), this.mRootView.getPaddingBottom());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mRootView.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(-1, -2);
        }
        layoutParams.height = ContextUtils.getDimensionPixelSize(R.dimen.dimen_poi_card_view_poi_button_container_height);
        layoutParams.topMargin = ContextUtils.getDimensionPixelSize(R.dimen.poi_item_offset);
        this.mRootView.setLayoutParams(layoutParams);
        executeAfterViewInflated(this.mRootView);
    }

    public void setHomeContainerBg(Drawable drawable) {
        XRelativeLayout xRelativeLayout = this.mHome;
        if (xRelativeLayout != null) {
            xRelativeLayout.setBackground(drawable);
        }
    }

    public void setCompanyContainerBg(Drawable drawable) {
        XRelativeLayout xRelativeLayout = this.mCompany;
        if (xRelativeLayout != null) {
            xRelativeLayout.setBackground(drawable);
        }
    }

    public void setBtnSettingHomeTextColor(int i) {
        XTextView xTextView = this.mBtnSettingHome;
        if (xTextView != null) {
            xTextView.setTextColor(i);
        }
    }

    public void setBtnSettingCompanyTextColor(int i) {
        XTextView xTextView = this.mBtnSettingCompany;
        if (xTextView != null) {
            xTextView.setTextColor(i);
        }
    }

    public void showHomeContainer() {
        XRelativeLayout xRelativeLayout = this.mHome;
        if (xRelativeLayout != null) {
            xRelativeLayout.setVisibility(0);
        }
    }

    public void hideHomeContainer() {
        XRelativeLayout xRelativeLayout = this.mHome;
        if (xRelativeLayout != null) {
            xRelativeLayout.setVisibility(8);
        }
    }

    public void showCompanyContainer() {
        XRelativeLayout xRelativeLayout = this.mCompany;
        if (xRelativeLayout != null) {
            xRelativeLayout.setVisibility(0);
        }
    }

    public void hideCompanyContainer() {
        XRelativeLayout xRelativeLayout = this.mCompany;
        if (xRelativeLayout != null) {
            xRelativeLayout.setVisibility(8);
        }
    }

    @Override // com.xiaopeng.montecarlo.views.poicard.BasePoiCardViewContract
    public void refresh(Context context, Map<String, Object> map, OnChildLayoutCompletedListener onChildLayoutCompletedListener) {
        this.mLayoutListener = onChildLayoutCompletedListener;
        formatParams(context, map);
        initView();
    }

    @Override // com.xiaopeng.montecarlo.views.poicard.BasePoiCardViewContract
    public void init(Context context, Map<String, Object> map) {
        formatParams(context, map);
        initView();
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
        if (map.get("searchDest") != null) {
            this.mSearchDest = ((Integer) map.get("searchDest")).intValue();
        }
        if (map.get("clickListener") != null) {
            this.mClickListener = (OnPoiCardHomeCompanyContainerClickListener) map.get("clickListener");
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        OnPoiCardHomeCompanyContainerClickListener onPoiCardHomeCompanyContainerClickListener;
        int id = view.getId();
        if (id != R.id.setting_company_container) {
            if (id == R.id.setting_home_container && (onPoiCardHomeCompanyContainerClickListener = this.mClickListener) != null) {
                onPoiCardHomeCompanyContainerClickListener.onSettingHomeContainerClick();
                return;
            }
            return;
        }
        OnPoiCardHomeCompanyContainerClickListener onPoiCardHomeCompanyContainerClickListener2 = this.mClickListener;
        if (onPoiCardHomeCompanyContainerClickListener2 != null) {
            onPoiCardHomeCompanyContainerClickListener2.onSettingCompanyContainerClick();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.xui.widget.XLinearLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mLayoutListener = null;
    }
}
