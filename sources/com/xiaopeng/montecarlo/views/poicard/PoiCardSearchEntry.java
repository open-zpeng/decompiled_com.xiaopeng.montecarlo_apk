package com.xiaopeng.montecarlo.views.poicard;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.XpThemeSwitchReceiver;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.util.ThemeWatcherUtil;
import com.xiaopeng.montecarlo.util.Utils;
import com.xiaopeng.montecarlo.views.poicard.PoiCardEntryContainer;
import com.xiaopeng.xui.widget.XLinearLayout;
import com.xiaopeng.xui.widget.XTextView;
import java.util.Map;
/* loaded from: classes3.dex */
public class PoiCardSearchEntry extends XLinearLayout implements XpThemeSwitchReceiver.ThemeSwitchListener, BasePoiCardViewContract, View.OnClickListener {
    private static final L.Tag TAG = new L.Tag("PoiCardSearchEntry");
    private XTextView mBtnSearch;
    private XLinearLayout mBtnSearchContainer;
    private PoiCardEntryContainer.OnPoiCardEntryContainerClickListener mClickListener;
    private Context mContext;
    private LayoutInflater mInflater;
    private boolean mIsSettingHomeOrOffice;
    private OnChildLayoutCompletedListener mLayoutListener;
    private ViewGroup mRootView;
    private int mSearchMode;

    @Override // com.xiaopeng.montecarlo.views.poicard.BasePoiCardViewContract
    public void refresh(Context context, Map<String, Object> map, OnChildLayoutCompletedListener onChildLayoutCompletedListener) {
    }

    public PoiCardSearchEntry(Context context, Map<String, Object> map, OnChildLayoutCompletedListener onChildLayoutCompletedListener) {
        super(context);
        this.mLayoutListener = onChildLayoutCompletedListener;
        init(context, map);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.xui.widget.XLinearLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        L.Tag tag = TAG;
        L.i(tag, L.filterStackByTag(L.printDebugStackTrace(tag, new Error()), Utils.getPackageName(ContextUtils.getContext())));
        ThemeWatcherUtil.addXpThemeSwitchListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.xui.widget.XLinearLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ThemeWatcherUtil.removeXpThemeListener(this);
        this.mLayoutListener = null;
    }

    @Override // com.xiaopeng.montecarlo.views.poicard.BasePoiCardViewContract
    public void formatParams(Context context, Map<String, Object> map) {
        this.mContext = context;
        if (map.get(PoiCardEntryContainer.KEY_SEARCH_MODE) != null) {
            this.mSearchMode = ((Integer) map.get(PoiCardEntryContainer.KEY_SEARCH_MODE)).intValue();
        }
        if (map.get("isSettingHomeOrOffice") != null) {
            this.mIsSettingHomeOrOffice = ((Boolean) map.get("isSettingHomeOrOffice")).booleanValue();
        }
        if (map.get("clickListener") != null) {
            this.mClickListener = (PoiCardEntryContainer.OnPoiCardEntryContainerClickListener) map.get("clickListener");
        }
    }

    private void executeAfterViewInflated(ViewGroup viewGroup) {
        if (viewGroup == null) {
            L.e(TAG, "execute after view inflated view is null");
            return;
        }
        this.mBtnSearchContainer = (XLinearLayout) viewGroup.findViewById(R.id.poi_btn_search_container);
        this.mBtnSearch = (XTextView) viewGroup.findViewById(R.id.poi_btn_search);
        executeViewOperation();
        OnChildLayoutCompletedListener onChildLayoutCompletedListener = this.mLayoutListener;
        if (onChildLayoutCompletedListener != null) {
            onChildLayoutCompletedListener.onChildLayoutCompleted(this.mRootView);
        }
    }

    @Override // com.xiaopeng.montecarlo.views.poicard.BasePoiCardViewContract
    public void init(Context context, Map<String, Object> map) {
        formatParams(context, map);
        initView();
    }

    private void initView() {
        this.mInflater = LayoutInflater.from(this.mContext);
        this.mRootView = (ViewGroup) this.mInflater.inflate(R.layout.layout_poi_entry_item_search, (ViewGroup) this, true);
        executeAfterViewInflated(this.mRootView);
    }

    @Override // com.xiaopeng.montecarlo.views.poicard.BasePoiCardViewContract
    public void executeAfterViewInflated(View view) {
        if (view == null) {
            L.e(TAG, "execute after view inflated view is null");
            return;
        }
        this.mBtnSearchContainer = (XLinearLayout) view.findViewById(R.id.poi_btn_search_container);
        this.mBtnSearch = (XTextView) view.findViewById(R.id.poi_btn_search);
        executeViewOperation();
        OnChildLayoutCompletedListener onChildLayoutCompletedListener = this.mLayoutListener;
        if (onChildLayoutCompletedListener != null) {
            onChildLayoutCompletedListener.onChildLayoutCompleted(this.mRootView);
        }
    }

    @Override // com.xiaopeng.montecarlo.views.poicard.BasePoiCardViewContract
    public void executeViewOperation() {
        setViewListener();
        renderSearch();
        onInitOrThemeSwitch();
    }

    private void renderSearch() {
        if (this.mSearchMode == 101 || this.mIsSettingHomeOrOffice) {
            hideSearchContainer();
        } else {
            showSearchContainer();
        }
    }

    public void hideSearchContainer() {
        hideBtnSearchContainer();
    }

    public void showSearchContainer() {
        showBtnSearchContainer();
        setVisibility(0);
    }

    public void hideBtnSearchContainer() {
        XLinearLayout xLinearLayout = this.mBtnSearchContainer;
        if (xLinearLayout == null || xLinearLayout.getVisibility() == 8) {
            return;
        }
        this.mBtnSearchContainer.setVisibility(8);
    }

    public void showBtnSearchContainer() {
        XLinearLayout xLinearLayout = this.mBtnSearchContainer;
        if (xLinearLayout == null || xLinearLayout.getVisibility() == 0) {
            return;
        }
        this.mBtnSearchContainer.setVisibility(0);
    }

    @Override // com.xiaopeng.montecarlo.views.poicard.BasePoiCardViewContract
    public void setViewListener() {
        XTextView xTextView = this.mBtnSearch;
        if (xTextView != null) {
            xTextView.setOnClickListener(this);
        }
    }

    @Override // com.xiaopeng.montecarlo.XpThemeSwitchReceiver.ThemeSwitchListener
    public void onThemeSwitch(int i) {
        onInitOrThemeSwitch();
    }

    @Override // com.xiaopeng.montecarlo.views.poicard.BasePoiCardViewContract
    public void onInitOrThemeSwitch() {
        setBtnSearchCompoundDrawable(ContextUtils.getDrawable(ThemeWatcherUtil.getDrawableResId(R.drawable.vector_ic_small_search_gray)));
        setBtnSearchTextColor(ContextUtils.getColorStateList(ThemeWatcherUtil.getColorResId(R.color.poi_card_text_color_01)));
    }

    public void setBtnSearchCompoundDrawable(Drawable drawable) {
        if (this.mBtnSearch == null || drawable == null) {
            return;
        }
        int dimensionPixelSize = ContextUtils.getDimensionPixelSize(R.dimen.poi_card_entry_left_drawable_size);
        drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
        this.mBtnSearch.setCompoundDrawables(drawable, null, null, null);
    }

    public void setBtnSearchTextColor(ColorStateList colorStateList) {
        XTextView xTextView = this.mBtnSearch;
        if (xTextView != null) {
            xTextView.setTextColor(colorStateList);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PoiCardEntryContainer.OnPoiCardEntryContainerClickListener onPoiCardEntryContainerClickListener;
        if (view.getId() == R.id.poi_btn_search && (onPoiCardEntryContainerClickListener = this.mClickListener) != null) {
            onPoiCardEntryContainerClickListener.onBtnSearchClicked();
        }
    }
}
