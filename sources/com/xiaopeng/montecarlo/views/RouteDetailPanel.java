package com.xiaopeng.montecarlo.views;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.LinearLayout;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.XpThemeSwitchReceiver;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.util.ThemeWatcherUtil;
import com.xiaopeng.montecarlo.util.Utils;
import com.xiaopeng.xui.view.XView;
import com.xiaopeng.xui.widget.XLinearLayout;
import com.xiaopeng.xui.widget.XRelativeLayout;
import com.xiaopeng.xui.widget.XTextView;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class RouteDetailPanel extends XpLinearLayout implements View.OnClickListener {
    public static final int ACTION_ADD_WAYPOINT = 1;
    public static final int ACTION_EXIT = 4;
    public static final int ACTION_START_EXPLORE = 3;
    public static final int ACTION_START_NAVI = 2;
    private static final long MULTI_CLICK_INTERVAL = 500;
    private static final L.Tag TAG = new L.Tag("RouteDetailPanel");
    private IActionListener mActionListener;
    private XLinearLayout mAddWayPointContainer;
    private ViewGroup mBottomPanel;
    private XView mBottomPanelDivider;
    private ViewStub mBottomStub;
    private XTextView mBtnCancelRoute;
    private XRelativeLayout mBtnExplore;
    private XRelativeLayout mBtnStartNavi;
    private Context mContext;
    private boolean mIsRelease;
    private long mLastClickTime;
    private View mRootView;
    private XLinearLayout mRoutDetailContainer;
    private XRelativeLayout mRouteCancelContainer;
    private String mThemeName;
    private XpThemeSwitchReceiver.ThemeSwitchListener mThemeSwitchListener;

    /* loaded from: classes3.dex */
    public interface IActionListener {
        void onActionPerformed(View view, int i);

        void onInflateFinished(RouteDetailPanel routeDetailPanel);
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface Visibility {
    }

    @Override // com.xiaopeng.xui.vui.VuiView, com.xiaopeng.vui.commons.IVuiElement
    public JSONObject getVuiProps() {
        return null;
    }

    @Override // com.xiaopeng.xui.vui.VuiView, com.xiaopeng.vui.commons.IVuiElement
    public void setVuiProps(JSONObject jSONObject) {
    }

    public RouteDetailPanel(Context context) {
        this(context, null);
    }

    public RouteDetailPanel(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public RouteDetailPanel(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mIsRelease = false;
        this.mThemeSwitchListener = new XpThemeSwitchReceiver.ThemeSwitchListener() { // from class: com.xiaopeng.montecarlo.views.RouteDetailPanel.1
            @Override // com.xiaopeng.montecarlo.XpThemeSwitchReceiver.ThemeSwitchListener
            public void onThemeSwitch(int i2) {
                RouteDetailPanel.this.updateTheme();
            }
        };
        this.mContext = context;
        setVuiLayoutLoadable(true);
        init();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RouteDetailPanel, i, 0);
        if (obtainStyledAttributes != null) {
            try {
                try {
                    int resourceId = obtainStyledAttributes.getResourceId(0, R.layout.layout_route_detail_panel_bottom);
                    if (resourceId > 0) {
                        this.mBottomStub.setLayoutResource(resourceId);
                    }
                    this.mBottomStub.inflate();
                    initBottomPanel();
                } finally {
                    obtainStyledAttributes.recycle();
                }
            } catch (Resources.NotFoundException | UnsupportedOperationException e) {
                e.printStackTrace();
            }
        }
        int dimensionPixelSize = ContextUtils.getDimensionPixelSize(R.dimen.shadow_margin);
        setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        setOrientation(1);
        setClickable(true);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 1;
        setLayoutParams(layoutParams);
    }

    public void setExitButtonText(CharSequence charSequence) {
        this.mBtnCancelRoute.setText(charSequence);
    }

    public void setRouteDetailPanelActionListener(IActionListener iActionListener) {
        this.mActionListener = iActionListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTheme() {
        if (Utils.isLandscape()) {
            this.mRoutDetailContainer.setDividerDrawable(ThemeWatcherUtil.getDrawable(R.drawable.shape_card_horizontal_route_line));
        } else {
            this.mRoutDetailContainer.setDividerDrawable(ThemeWatcherUtil.getDrawable(R.drawable.shape_card_vertical_route_line));
        }
        Drawable drawable = ThemeWatcherUtil.getDrawable(R.drawable.selector_cancel_button);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        this.mBtnCancelRoute.setCompoundDrawables(drawable, null, null, null);
        setBackground(ThemeWatcherUtil.getDrawable(R.drawable.layer_bg_big_panel));
        this.mBottomPanel.setBackground(ThemeWatcherUtil.getDrawable(R.drawable.shape_bg_route_detail_panel_bottom));
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.layout_route_detail_panel, (ViewGroup) this, true);
        this.mBottomStub = (ViewStub) this.mRootView.findViewById(R.id.background_route_bottom_panel_stub);
        this.mBottomPanelDivider = (XView) this.mRootView.findViewById(R.id.route_view_divider_line);
        this.mRoutDetailContainer = (XLinearLayout) this.mRootView.findViewById(R.id.route_view_container);
    }

    private void initBottomPanel() {
        this.mBottomPanel = (ViewGroup) this.mRootView.findViewById(R.id.background_route_bottom_panel);
        this.mBtnCancelRoute = (XTextView) this.mRootView.findViewById(R.id.btn_cancel_route);
        this.mAddWayPointContainer = (XLinearLayout) this.mRootView.findViewById(R.id.btn_add_waypoint_container);
        this.mRouteCancelContainer = (XRelativeLayout) this.mRootView.findViewById(R.id.route_cancel_panel);
        this.mBtnExplore = (XRelativeLayout) this.mRootView.findViewById(R.id.btn_explore);
        this.mBtnStartNavi = (XRelativeLayout) this.mRootView.findViewById(R.id.btn_start_navi);
        this.mAddWayPointContainer.setOnClickListener(this);
        this.mBtnStartNavi.setOnClickListener(this);
        this.mBtnExplore.setOnClickListener(this);
        this.mRouteCancelContainer.setOnClickListener(this);
        IActionListener iActionListener = this.mActionListener;
        if (iActionListener != null) {
            iActionListener.onInflateFinished(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.xui.widget.XLinearLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mThemeName = ThemeWatcherUtil.newThemeNameForRepeatView(getClass().getSimpleName());
        ThemeWatcherUtil.register(getContext(), this.mRootView, this.mThemeName);
        ThemeWatcherUtil.addXpThemeSwitchListener(this.mThemeSwitchListener);
        updateTheme();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.xui.widget.XLinearLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ThemeWatcherUtil.unregister(getContext(), this.mThemeName);
        ThemeWatcherUtil.removeXpThemeListener(this.mThemeSwitchListener);
    }

    public void showExploreButton(int i) {
        this.mBtnExplore.setVisibility(i);
    }

    public void showBottomPanel(int i) {
        this.mBottomPanel.setVisibility(i);
        this.mBottomPanelDivider.setVisibility(i);
    }

    public boolean isBottomPanelVisible() {
        return this.mBottomPanel.getVisibility() == 0;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (preventMultiClick()) {
            int id = view.getId();
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, "onClick viewID:" + view.getResources().getResourceName(id));
            }
            IActionListener iActionListener = this.mActionListener;
            if (iActionListener != null) {
                switch (id) {
                    case R.id.btn_add_waypoint_container /* 2131296415 */:
                        iActionListener.onActionPerformed(view, 1);
                        return;
                    case R.id.btn_explore /* 2131296426 */:
                        iActionListener.onActionPerformed(view, 3);
                        return;
                    case R.id.btn_start_navi /* 2131296451 */:
                        iActionListener.onActionPerformed(view, 2);
                        return;
                    case R.id.route_cancel_panel /* 2131297106 */:
                        iActionListener.onActionPerformed(view, 4);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    private boolean preventMultiClick() {
        boolean z = SystemClock.elapsedRealtime() - this.mLastClickTime >= MULTI_CLICK_INTERVAL;
        this.mLastClickTime = SystemClock.elapsedRealtime();
        return z;
    }

    public void release() {
        this.mIsRelease = true;
        setRouteDetailPanelActionListener(null);
        setClickable(false);
        setOnClickListener(null);
        XLinearLayout xLinearLayout = this.mAddWayPointContainer;
        if (xLinearLayout != null) {
            xLinearLayout.setOnClickListener(null);
        }
        XRelativeLayout xRelativeLayout = this.mBtnStartNavi;
        if (xRelativeLayout != null) {
            xRelativeLayout.setOnClickListener(null);
        }
        XRelativeLayout xRelativeLayout2 = this.mBtnExplore;
        if (xRelativeLayout2 != null) {
            xRelativeLayout2.setOnClickListener(null);
        }
        XRelativeLayout xRelativeLayout3 = this.mRouteCancelContainer;
        if (xRelativeLayout3 != null) {
            xRelativeLayout3.setOnClickListener(null);
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.mIsRelease) {
            return;
        }
        super.requestLayout();
    }
}
