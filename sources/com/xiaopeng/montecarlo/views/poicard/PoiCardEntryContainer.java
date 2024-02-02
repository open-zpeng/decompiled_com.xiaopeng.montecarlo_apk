package com.xiaopeng.montecarlo.views.poicard;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.util.ThemeWatcherUtil;
import com.xiaopeng.xui.widget.XLinearLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class PoiCardEntryContainer extends XLinearLayout implements BasePoiCardViewContract {
    public static final String KEY_CARD_TYPE = "cardType";
    public static final String KEY_CLICK_LISTENER = "clickListener";
    public static final String KEY_IS_SETTING_HOME_OR_OFFICE = "isSettingHomeOrOffice";
    public static final String KEY_MAIN_CONTEXT = "mainContext";
    public static final String KEY_POI_INFO = "poiInfo";
    public static final String KEY_SEARCH_MODE = "searchMode";
    private static final int MAX_COLUMN = 3;
    private static final L.Tag TAG = new L.Tag("Card_PCEC");
    private int mCardType;
    private final EntryDisplayConfig mConfig;
    private Context mContext;
    private XLinearLayout mEntryContainer;
    private LayoutInflater mInflater;
    private boolean mIsSettingHomeOrOffice;
    private OnChildLayoutCompletedListener mLayoutListener;
    private List<View> mLineViews;
    private onPopDialogShow mNumPopListener;
    private Map<String, Object> mParams;
    private PoiCardFavoriteEntry mPoiCardFavoriteEntry;
    private XPPoiInfo mPoiInfo;
    private ViewGroup mRootView;
    private int mSearchMode;
    private List<View> mViews;
    private PoiCardContactEntry poiCardContactEntry;

    /* loaded from: classes3.dex */
    public interface OnPoiCardEntryContainerClickListener {
        void onBtnFavoriteClicked();

        void onBtnParkClicked();

        void onBtnSearchClicked();
    }

    @Override // com.xiaopeng.montecarlo.views.poicard.BasePoiCardViewContract
    public void setViewListener() {
    }

    public void setonNumPopDialogShow(onPopDialogShow onpopdialogshow) {
        this.mNumPopListener = onpopdialogshow;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class EntryDisplayConfig {
        boolean mIsSearchVisible = false;
        boolean mIsFavoriteVisible = false;
        boolean mIsContactVisible = false;

        EntryDisplayConfig() {
        }

        public String toString() {
            return "EntryDisplayConfig{mIsSearchVisible=" + this.mIsSearchVisible + ", mIsFavoriteVisible=" + this.mIsFavoriteVisible + ", mIsContactVisible=" + this.mIsContactVisible + '}';
        }
    }

    public PoiCardEntryContainer(Context context, Map<String, Object> map, OnChildLayoutCompletedListener onChildLayoutCompletedListener) {
        super(context);
        this.mViews = new ArrayList();
        this.mLineViews = new ArrayList();
        this.mConfig = new EntryDisplayConfig();
        this.mLayoutListener = onChildLayoutCompletedListener;
        init(context, map);
    }

    private void initView() {
        this.mInflater = LayoutInflater.from(this.mContext);
        this.mRootView = (ViewGroup) this.mInflater.inflate(R.layout.layout_poi_entry_container, (ViewGroup) this, true);
        setOrientation(1);
        executeAfterViewInflated(this.mRootView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.xui.widget.XLinearLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mLayoutListener = null;
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
        this.mEntryContainer = (XLinearLayout) view.findViewById(R.id.poi_entry_container);
        executeViewOperation();
        OnChildLayoutCompletedListener onChildLayoutCompletedListener = this.mLayoutListener;
        if (onChildLayoutCompletedListener != null) {
            onChildLayoutCompletedListener.onChildLayoutCompleted(this.mRootView);
        }
    }

    @Override // com.xiaopeng.montecarlo.views.poicard.BasePoiCardViewContract
    public void executeViewOperation() {
        XLinearLayout xLinearLayout = this.mEntryContainer;
        if (xLinearLayout != null) {
            xLinearLayout.removeAllViews();
        }
        this.mViews.clear();
        this.mLineViews.clear();
        if (this.mConfig.mIsSearchVisible) {
            this.mViews.add(new PoiCardSearchEntry(this.mContext, this.mParams, this.mLayoutListener));
        }
        if (this.mConfig.mIsFavoriteVisible) {
            PoiCardFavoriteEntry poiCardFavoriteEntry = this.mPoiCardFavoriteEntry;
            if (poiCardFavoriteEntry == null) {
                this.mPoiCardFavoriteEntry = new PoiCardFavoriteEntry(this.mContext, this.mParams, this.mLayoutListener);
            } else {
                if (poiCardFavoriteEntry.getParent() instanceof LinearLayout) {
                    ((LinearLayout) this.mPoiCardFavoriteEntry.getParent()).removeView(this.mPoiCardFavoriteEntry);
                }
                this.mPoiCardFavoriteEntry.refresh(this.mContext, this.mParams, this.mLayoutListener);
            }
            this.mViews.add(this.mPoiCardFavoriteEntry);
        } else {
            this.mPoiCardFavoriteEntry = null;
        }
        if (this.mConfig.mIsContactVisible) {
            this.poiCardContactEntry = new PoiCardContactEntry(this.mContext, this.mParams, this.mLayoutListener);
            this.poiCardContactEntry.setOnNumPopDialogShowListener(this.mNumPopListener);
            this.mViews.add(this.poiCardContactEntry);
        }
        renderEntry();
        onInitOrThemeSwitch();
    }

    private void renderEntry() {
        View view;
        int size = this.mViews.size() % 3 == 0 ? this.mViews.size() / 3 : (this.mViews.size() / 3) + 1;
        for (int i = 0; i < size; i++) {
            LinearLayout linearLayout = new LinearLayout(this.mContext);
            linearLayout.setOrientation(1);
            linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, ContextUtils.getDimensionPixelSize(R.dimen.poi_item_height)));
            View view2 = new View(this.mContext);
            view2.setLayoutParams(new LinearLayout.LayoutParams(-1, ContextUtils.getDimensionPixelSize(R.dimen.divider_width)));
            linearLayout.addView(view2);
            this.mLineViews.add(view2);
            LinearLayout linearLayout2 = new LinearLayout(this.mContext);
            linearLayout2.setOrientation(0);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.weight = 1.0f;
            linearLayout2.setLayoutParams(layoutParams);
            int i2 = i * 3;
            int i3 = i2 + 3;
            while (i2 < i3) {
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -1);
                if (i2 < this.mViews.size()) {
                    view = this.mViews.get(i2);
                } else {
                    view = new View(this.mContext);
                }
                int i4 = i2 % 3;
                int i5 = i4 == 0 ? 8388627 : i4 == 2 ? 8388629 : 17;
                layoutParams2.weight = 1.0f;
                view.setLayoutParams(layoutParams2);
                if (view instanceof LinearLayout) {
                    ((LinearLayout) view).setGravity(i5);
                }
                linearLayout2.addView(view);
                i2++;
            }
            linearLayout.addView(linearLayout2);
            this.mEntryContainer.addView(linearLayout);
        }
    }

    @Override // com.xiaopeng.montecarlo.views.poicard.BasePoiCardViewContract
    public void onInitOrThemeSwitch() {
        Drawable drawable = ThemeWatcherUtil.getDrawable(ThemeWatcherUtil.getColorResId(R.color.color_poi_card_view_line_color_poi_pop_content_item));
        for (View view : this.mLineViews) {
            view.setBackground(drawable);
        }
    }

    @Override // com.xiaopeng.montecarlo.views.poicard.BasePoiCardViewContract
    public void refresh(Context context, Map<String, Object> map, OnChildLayoutCompletedListener onChildLayoutCompletedListener) {
        this.mLayoutListener = onChildLayoutCompletedListener;
        formatParams(context, map);
        executeViewOperation();
    }

    @Override // com.xiaopeng.montecarlo.views.poicard.BasePoiCardViewContract
    public void formatParams(Context context, Map<String, Object> map) {
        this.mContext = context;
        this.mParams = map;
        if (map.get("poiInfo") != null) {
            this.mPoiInfo = (XPPoiInfo) map.get("poiInfo");
        }
        if (map.get(KEY_SEARCH_MODE) != null) {
            this.mSearchMode = ((Integer) map.get(KEY_SEARCH_MODE)).intValue();
        }
        if (map.get("isSettingHomeOrOffice") != null) {
            this.mIsSettingHomeOrOffice = ((Boolean) map.get("isSettingHomeOrOffice")).booleanValue();
        }
        if (map.get("cardType") != null) {
            this.mCardType = ((Integer) map.get("cardType")).intValue();
        }
        formatDisplayConfig();
    }

    private void formatDisplayConfig() {
        boolean z = true;
        this.mConfig.mIsSearchVisible = (this.mSearchMode == 101 || this.mIsSettingHomeOrOffice) ? false : true;
        EntryDisplayConfig entryDisplayConfig = this.mConfig;
        XPPoiInfo xPPoiInfo = this.mPoiInfo;
        entryDisplayConfig.mIsFavoriteVisible = (xPPoiInfo == null || TextUtils.isEmpty(xPPoiInfo.getAddress()) || TextUtils.isEmpty(this.mPoiInfo.getName()) || this.mIsSettingHomeOrOffice) ? false : true;
        EntryDisplayConfig entryDisplayConfig2 = this.mConfig;
        XPPoiInfo xPPoiInfo2 = this.mPoiInfo;
        if (xPPoiInfo2 == null || this.mCardType == 5 || TextUtils.isEmpty(xPPoiInfo2.getTel())) {
            z = false;
        }
        entryDisplayConfig2.mIsContactVisible = z;
        if (L.ENABLE) {
            L.d(TAG, "formatDisplayConfig config:" + this.mConfig);
        }
    }
}
