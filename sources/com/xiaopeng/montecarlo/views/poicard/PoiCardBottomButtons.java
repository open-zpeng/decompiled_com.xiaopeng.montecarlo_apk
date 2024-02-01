package com.xiaopeng.montecarlo.views.poicard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.mapoverlay.DecoratorType;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.util.NaviUtil;
import com.xiaopeng.montecarlo.views.PoiCardButton;
import com.xiaopeng.xui.widget.XLinearLayout;
import java.util.Map;
/* loaded from: classes3.dex */
public class PoiCardBottomButtons extends XLinearLayout implements BasePoiCardViewContract, View.OnClickListener {
    public static final String KEY_CLICK_LISTENER = "clickListener";
    public static final String KEY_DECORATOR_TYPE = "decoratorType";
    public static final String KEY_IS_IN_NAVI = "isInNavi";
    public static final String KEY_IS_SETTING_HOME_OR_OFFICE = "isSettingHomeOrOffice";
    public static final String KEY_POI_INFO = "poiInfo";
    public static final String KEY_SEARCH_DEST = "searchDest";
    private static final L.Tag TAG = new L.Tag("Card_PCBB");
    private PoiCardButton mAddWayPoint;
    private OnPoiCardBottomButtonsClickListener mClickListener;
    private Context mContext;
    private DecoratorType mDecoratorType;
    private PoiCardButton mDeleteWayPoint;
    private LayoutInflater mInflater;
    private boolean mIsInNavi;
    private boolean mIsSettingHomeOrOffice;
    private OnChildLayoutCompletedListener mLayoutListener;
    private PoiCardButton mNavi;
    private XPPoiInfo mPoiInfo;
    private ViewGroup mRootView;
    private int mSearchDest;

    /* loaded from: classes3.dex */
    public interface OnPoiCardBottomButtonsClickListener {
        void onAddWayPointClicked();

        void onDeleteWayPointClicked();

        void onNaviClicked();
    }

    @Override // com.xiaopeng.montecarlo.views.poicard.BasePoiCardViewContract
    public void executeAfterViewInflated(View view) {
        if (view == null) {
            L.e(TAG, "execute after view inflated view is null");
            return;
        }
        this.mAddWayPoint = (PoiCardButton) view.findViewById(R.id.container_add_waypoint);
        this.mDeleteWayPoint = (PoiCardButton) view.findViewById(R.id.container_delete_waypoint);
        this.mNavi = (PoiCardButton) view.findViewById(R.id.container_navi);
        executeViewOperation();
        OnChildLayoutCompletedListener onChildLayoutCompletedListener = this.mLayoutListener;
        if (onChildLayoutCompletedListener != null) {
            onChildLayoutCompletedListener.onChildLayoutCompleted(this.mRootView);
        }
    }

    @Override // com.xiaopeng.montecarlo.views.poicard.BasePoiCardViewContract
    public void executeViewOperation() {
        setViewListener();
        renderStartNaviButtonStatus();
        renderWayPointButtonStatus();
        onInitOrThemeSwitch();
    }

    @Override // com.xiaopeng.montecarlo.views.poicard.BasePoiCardViewContract
    public void setViewListener() {
        PoiCardButton poiCardButton = this.mNavi;
        if (poiCardButton != null) {
            poiCardButton.setOnClickListener(this);
        }
        PoiCardButton poiCardButton2 = this.mAddWayPoint;
        if (poiCardButton2 != null) {
            poiCardButton2.setOnClickListener(this);
        }
        PoiCardButton poiCardButton3 = this.mDeleteWayPoint;
        if (poiCardButton3 != null) {
            poiCardButton3.setOnClickListener(this);
        }
    }

    @Override // com.xiaopeng.montecarlo.views.poicard.BasePoiCardViewContract
    public void onInitOrThemeSwitch() {
        switchAddWayPointStatus(1);
        switchDeleteWayPointStatus(0);
        switchNaviStatus(1 ^ (this.mIsInNavi ? 1 : 0));
    }

    @Override // com.xiaopeng.montecarlo.views.poicard.BasePoiCardViewContract
    public void refresh(Context context, Map<String, Object> map, OnChildLayoutCompletedListener onChildLayoutCompletedListener) {
        this.mLayoutListener = onChildLayoutCompletedListener;
        formatParams(context, map);
        executeViewOperation();
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
        if (map.get(KEY_IS_IN_NAVI) != null) {
            this.mIsInNavi = ((Boolean) map.get(KEY_IS_IN_NAVI)).booleanValue();
        }
        if (map.get("poiInfo") != null) {
            this.mPoiInfo = (XPPoiInfo) map.get("poiInfo");
        }
        if (map.get("searchDest") != null) {
            this.mSearchDest = ((Integer) map.get("searchDest")).intValue();
        }
        if (map.get(KEY_DECORATOR_TYPE) != null) {
            this.mDecoratorType = (DecoratorType) map.get(KEY_DECORATOR_TYPE);
        }
        if (map.get("isSettingHomeOrOffice") != null) {
            this.mIsSettingHomeOrOffice = ((Boolean) map.get("isSettingHomeOrOffice")).booleanValue();
        }
        if (map.get("clickListener") != null) {
            this.mClickListener = (OnPoiCardBottomButtonsClickListener) map.get("clickListener");
        }
    }

    public PoiCardBottomButtons(Context context, Map<String, Object> map, OnChildLayoutCompletedListener onChildLayoutCompletedListener) {
        super(context);
        this.mIsInNavi = false;
        this.mIsSettingHomeOrOffice = false;
        this.mLayoutListener = onChildLayoutCompletedListener;
        init(context, map);
    }

    private void initView() {
        this.mInflater = LayoutInflater.from(this.mContext);
        this.mRootView = (ViewGroup) this.mInflater.inflate(R.layout.layout_bottom_btns_container, (ViewGroup) this, true);
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

    public void switchNaviStatus(int i) {
        PoiCardButton poiCardButton = this.mNavi;
        if (poiCardButton != null) {
            poiCardButton.switchStatus(i);
        }
    }

    public void poiHide() {
        PoiCardButton poiCardButton = this.mNavi;
        if (poiCardButton != null) {
            poiCardButton.setVisibility(8);
        }
        PoiCardButton poiCardButton2 = this.mAddWayPoint;
        if (poiCardButton2 != null) {
            poiCardButton2.setVisibility(8);
        }
        PoiCardButton poiCardButton3 = this.mDeleteWayPoint;
        if (poiCardButton3 != null) {
            poiCardButton3.setVisibility(8);
        }
    }

    public void switchAddWayPointStatus(int i) {
        PoiCardButton poiCardButton = this.mAddWayPoint;
        if (poiCardButton != null) {
            poiCardButton.switchStatus(i);
        }
    }

    public void switchDeleteWayPointStatus(int i) {
        PoiCardButton poiCardButton = this.mDeleteWayPoint;
        if (poiCardButton != null) {
            poiCardButton.switchStatus(i);
        }
    }

    public void hideNavi() {
        PoiCardButton poiCardButton = this.mNavi;
        if (poiCardButton != null) {
            poiCardButton.setVisibility(8);
        }
    }

    public void showNavi() {
        PoiCardButton poiCardButton = this.mNavi;
        if (poiCardButton != null) {
            poiCardButton.setVisibility(0);
        }
    }

    public void showAddWayPoint() {
        PoiCardButton poiCardButton = this.mAddWayPoint;
        if (poiCardButton != null) {
            poiCardButton.setVisibility(0);
        }
        hideDeleteWayPoint();
    }

    public void hideAddWayPoint() {
        PoiCardButton poiCardButton = this.mAddWayPoint;
        if (poiCardButton != null) {
            poiCardButton.setVisibility(8);
        }
    }

    public void showDeleteWayPoint() {
        hideAddWayPoint();
        PoiCardButton poiCardButton = this.mDeleteWayPoint;
        if (poiCardButton != null) {
            poiCardButton.setVisibility(0);
        }
    }

    public void hideDeleteWayPoint() {
        PoiCardButton poiCardButton = this.mDeleteWayPoint;
        if (poiCardButton != null) {
            poiCardButton.setVisibility(8);
        }
    }

    public void hideWayPointContainer() {
        hideAddWayPoint();
        hideDeleteWayPoint();
    }

    public void renderWayPointButtonStatus() {
        if (checkShouldHideWaypointLayout()) {
            hideWayPointContainer();
            return;
        }
        hideWayPointContainer();
        if (this.mDecoratorType == DecoratorType.WAY_POINT) {
            boolean isViaPassed = NaviUtil.isViaPassed(this.mPoiInfo);
            if (isViaPassed) {
                showAddWayPoint();
            } else {
                showDeleteWayPoint();
            }
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, "PoiCardView mDecoratorType=" + this.mDecoratorType + "isVarPassed=" + isViaPassed);
                return;
            }
            return;
        }
        boolean isViaPassed2 = NaviUtil.isViaPassed(this.mPoiInfo);
        if (NaviUtil.isExistedViaPoi(this.mPoiInfo) && !isViaPassed2) {
            showDeleteWayPoint();
        } else {
            showAddWayPoint();
        }
        if (L.ENABLE) {
            L.Tag tag2 = TAG;
            L.d(tag2, "PoiCardView mDecoratorType=" + this.mDecoratorType + " isViaPassed=" + isViaPassed2);
        }
    }

    private boolean checkShouldHideWaypointLayout() {
        boolean z = false;
        boolean z2 = this.mPoiInfo == null;
        boolean z3 = !this.mIsInNavi;
        int i = this.mSearchDest;
        boolean z4 = i == 1001 || i == 1002;
        boolean z5 = this.mDecoratorType == DecoratorType.START_POINT || this.mDecoratorType == DecoratorType.END_POINT;
        if (z2 || z3 || z4 || z5) {
            z = true;
        }
        if (L.ENABLE) {
            L.d(TAG, "checkShouldHideWaypointLayout isPoiIllegal:" + z2 + ",isRouteIllegal:" + z3 + ",isActionIllegal:" + z4 + ",isPositionIllegal:" + z5 + ",flag:" + z);
        }
        return z;
    }

    public void visibleStateExchange(boolean z) {
        setVisibility(z ? 8 : 0);
    }

    public void renderStartNaviButtonStatus() {
        if (this.mDecoratorType == DecoratorType.END_POINT || this.mDecoratorType == DecoratorType.START_POINT || this.mIsSettingHomeOrOffice) {
            setVisibility(8);
            hideNavi();
            return;
        }
        setVisibility(0);
        showNavi();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        OnPoiCardBottomButtonsClickListener onPoiCardBottomButtonsClickListener;
        int id = view.getId();
        if (id == R.id.container_add_waypoint) {
            OnPoiCardBottomButtonsClickListener onPoiCardBottomButtonsClickListener2 = this.mClickListener;
            if (onPoiCardBottomButtonsClickListener2 != null) {
                onPoiCardBottomButtonsClickListener2.onAddWayPointClicked();
            }
        } else if (id != R.id.container_delete_waypoint) {
            if (id == R.id.container_navi && (onPoiCardBottomButtonsClickListener = this.mClickListener) != null) {
                onPoiCardBottomButtonsClickListener.onNaviClicked();
            }
        } else {
            OnPoiCardBottomButtonsClickListener onPoiCardBottomButtonsClickListener3 = this.mClickListener;
            if (onPoiCardBottomButtonsClickListener3 != null) {
                onPoiCardBottomButtonsClickListener3.onDeleteWayPointClicked();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.xui.widget.XLinearLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mLayoutListener = null;
    }
}
