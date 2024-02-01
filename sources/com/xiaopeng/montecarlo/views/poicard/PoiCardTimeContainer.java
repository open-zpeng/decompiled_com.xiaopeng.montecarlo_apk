package com.xiaopeng.montecarlo.views.poicard;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiCategory;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
import com.xiaopeng.montecarlo.scenes.searchscene.SearchSceneDataHelper;
import com.xiaopeng.montecarlo.util.OpenTimeUtils;
import com.xiaopeng.montecarlo.util.ThemeWatcherUtil;
import com.xiaopeng.montecarlo.views.NaviImageView;
import com.xiaopeng.montecarlo.views.poicard.PoiCardTimeContainer;
import com.xiaopeng.xui.widget.XRelativeLayout;
import com.xiaopeng.xui.widget.XTextView;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes3.dex */
public class PoiCardTimeContainer extends XRelativeLayout implements BasePoiCardViewContract {
    public static final String KEY_CARD_TYPE = "cardType";
    public static final String KEY_POI_INFO = "poiInfo";
    public static final String KEY_TIME_ON_ROAD = "timeOnRoad";
    private static final long OPEN_TIME_DALAY = 1800000;
    private static final L.Tag TAG = new L.Tag("Card_PCBB");
    private int mCardType;
    private XTextView mContactTime;
    private Context mContext;
    private Handler mHandler;
    private LayoutInflater mInflater;
    private OnChildLayoutCompletedListener mLayoutListener;
    private NaviImageView mOpenIcon;
    private NaviImageView mOpenTimeIcon;
    private XPPoiInfo mPoiInfo;
    private ViewGroup mRootView;
    private NaviImageView mTimeDivider;
    private long mTimeOnRoad;

    @Override // com.xiaopeng.montecarlo.views.poicard.BasePoiCardViewContract
    public void onInitOrThemeSwitch() {
    }

    @Override // com.xiaopeng.montecarlo.views.poicard.BasePoiCardViewContract
    public void setViewListener() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleTimeFormatCompleted(String str) {
        setContactTimeText(str);
        XTextView xTextView = this.mContactTime;
        if (xTextView != null) {
            xTextView.post(new Runnable() { // from class: com.xiaopeng.montecarlo.views.poicard.-$$Lambda$PoiCardTimeContainer$SnVK7vywMjrHr9fUgEsqI5tdJZI
                @Override // java.lang.Runnable
                public final void run() {
                    PoiCardTimeContainer.this.formatContactTimeDisplay();
                }
            });
        }
    }

    public PoiCardTimeContainer(Context context, Map<String, Object> map, OnChildLayoutCompletedListener onChildLayoutCompletedListener) {
        super(context);
        this.mLayoutListener = onChildLayoutCompletedListener;
        init(context, map);
    }

    private void initView() {
        this.mInflater = LayoutInflater.from(this.mContext);
        this.mRootView = (ViewGroup) this.mInflater.inflate(R.layout.layout_poi_time_container, (ViewGroup) this, true);
        this.mRootView.setMinimumHeight(ContextUtils.getDimensionPixelSize(R.dimen.poi_item_height));
        executeAfterViewInflated(this.mRootView);
    }

    public void hideContactTime() {
        XTextView xTextView = this.mContactTime;
        if (xTextView == null || xTextView.getVisibility() == 8) {
            return;
        }
        this.mContactTime.setVisibility(8);
    }

    public void showContactTime() {
        XTextView xTextView = this.mContactTime;
        if (xTextView == null || xTextView.getVisibility() == 0) {
            return;
        }
        this.mContactTime.setVisibility(0);
    }

    public void setContactTimeText(String str) {
        XTextView xTextView = this.mContactTime;
        if (xTextView != null) {
            xTextView.setText(str);
        }
    }

    public void setOpenIconBackground(Drawable drawable) {
        NaviImageView naviImageView = this.mOpenIcon;
        if (naviImageView != null) {
            naviImageView.setBackground(drawable);
        }
    }

    public void hideOpenIcon() {
        NaviImageView naviImageView = this.mOpenIcon;
        if (naviImageView == null || naviImageView.getVisibility() == 8) {
            return;
        }
        this.mOpenIcon.setVisibility(8);
    }

    public void showOpenIcon() {
        NaviImageView naviImageView = this.mOpenIcon;
        if (naviImageView == null || naviImageView.getVisibility() == 0) {
            return;
        }
        this.mOpenIcon.setVisibility(0);
    }

    public void hideOpenTime() {
        NaviImageView naviImageView = this.mOpenTimeIcon;
        if (naviImageView == null || naviImageView.getVisibility() == 8) {
            return;
        }
        this.mOpenTimeIcon.setVisibility(8);
    }

    public void showOpenTime() {
        NaviImageView naviImageView = this.mOpenTimeIcon;
        if (naviImageView == null || naviImageView.getVisibility() == 0) {
            return;
        }
        this.mOpenTimeIcon.setVisibility(0);
    }

    public void setOpenTimeBackground(Drawable drawable) {
        NaviImageView naviImageView = this.mOpenTimeIcon;
        if (naviImageView != null) {
            naviImageView.setBackground(drawable);
        }
    }

    public void setTimeDividerImageResource(int i) {
        NaviImageView naviImageView = this.mTimeDivider;
        if (naviImageView != null) {
            naviImageView.setImageResource(i);
        }
    }

    @Override // com.xiaopeng.montecarlo.views.poicard.BasePoiCardViewContract
    public void init(Context context, Map<String, Object> map) {
        formatParams(context, map);
        this.mHandler = new Handler(Looper.getMainLooper());
        initView();
    }

    @Override // com.xiaopeng.montecarlo.views.poicard.BasePoiCardViewContract
    public void executeAfterViewInflated(View view) {
        if (view == null) {
            L.e(TAG, "execute after view inflated view is null");
            return;
        }
        this.mOpenIcon = (NaviImageView) view.findViewById(R.id.iv_open_icon);
        this.mOpenTimeIcon = (NaviImageView) view.findViewById(R.id.iv_open_time);
        this.mContactTime = (XTextView) view.findViewById(R.id.poi_contact_time);
        this.mTimeDivider = (NaviImageView) view.findViewById(R.id.poi_time_divider);
        executeViewOperation();
        OnChildLayoutCompletedListener onChildLayoutCompletedListener = this.mLayoutListener;
        if (onChildLayoutCompletedListener != null) {
            onChildLayoutCompletedListener.onChildLayoutCompleted(this.mRootView);
        }
    }

    @Override // com.xiaopeng.montecarlo.views.poicard.BasePoiCardViewContract
    public void executeViewOperation() {
        setViewListener();
        renderBusinessTimeInfo();
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
        if (map.get(KEY_TIME_ON_ROAD) != null) {
            this.mTimeOnRoad = ((Long) map.get(KEY_TIME_ON_ROAD)).longValue();
        }
        if (map.get("cardType") != null) {
            this.mCardType = ((Integer) map.get("cardType")).intValue();
        }
    }

    private void renderBusinessTimeInfo() {
        hideTimeContainer();
        XPPoiInfo xPPoiInfo = this.mPoiInfo;
        if (xPPoiInfo == null) {
            return;
        }
        if (this.mCardType == 5) {
            if (L.ENABLE) {
                L.d(TAG, "renderBusinessTimeInfo mCardType: PoiCardType.CARD_TYPE_RGC");
            }
        } else if (TextUtils.isEmpty(xPPoiInfo.getOpenTime())) {
            hideTimeContainer();
        } else {
            showContactTimeContainer();
            String openTime = this.mPoiInfo.getOpenTime();
            showTimeInfo(openTime);
            if (this.mCardType == 1 || XPPoiCategory.isCharge(this.mPoiInfo.getCategory())) {
                if (OpenTimeUtils.is24Hour(openTime)) {
                    setContactTimeBackground(ThemeWatcherUtil.getDrawable(R.drawable.vector_tag_texttag_midoperateid_24hour));
                    return;
                } else if (openTime.contains(ContextUtils.getString(R.string.search_result_workday))) {
                    setContactTimeBackground(null);
                    return;
                } else {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE HH:mm", Locale.getDefault());
                    String[] split = simpleDateFormat.format(Long.valueOf(System.currentTimeMillis() + this.mTimeOnRoad)).split(" ");
                    String[] split2 = simpleDateFormat.format(Long.valueOf(System.currentTimeMillis() + this.mTimeOnRoad + OPEN_TIME_DALAY)).split(" ");
                    if (OpenTimeUtils.isOpenTime(openTime, split[0], split[1]) || OpenTimeUtils.isOpenTime(openTime, split2[0], split2[1])) {
                        setContactTimeBackground(ThemeWatcherUtil.getDrawable(R.drawable.vector_tag_texttag_midoperateid_ing));
                        return;
                    } else {
                        setContactTimeBackground(null);
                        return;
                    }
                }
            }
            setContactTimeBackground(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formatContactTimeDisplay() {
        formatOpenIconLayout();
        formatOpenTimeIconLayout();
    }

    private void formatOpenIconLayout() {
        NaviImageView naviImageView = this.mOpenIcon;
        if (naviImageView == null || naviImageView.getVisibility() != 0) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(20);
        layoutParams.topMargin = ContextUtils.getDimensionPixelSize(R.dimen.poi_openicon_top);
        if (this.mContactTime.getLineCount() > 1) {
            layoutParams.addRule(10);
        } else {
            layoutParams.addRule(15);
        }
        this.mOpenIcon.setLayoutParams(layoutParams);
    }

    private void formatOpenTimeIconLayout() {
        NaviImageView naviImageView = this.mOpenTimeIcon;
        if (naviImageView == null || naviImageView.getVisibility() != 0) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mOpenTimeIcon.getLayoutParams();
        if (this.mContactTime.getLineCount() > 1) {
            layoutParams.topMargin = ContextUtils.getDimensionPixelSize(R.dimen.poi_opentime_top);
            layoutParams.gravity = 8388659;
        } else {
            layoutParams.topMargin = 0;
            layoutParams.gravity = 16;
        }
        this.mOpenTimeIcon.setLayoutParams(layoutParams);
    }

    private void showContactTimeContainer() {
        setVisibility(0);
    }

    private void hideTimeContainer() {
        setVisibility(8);
        hideOpenIcon();
        hideOpenTime();
        hideContactTime();
    }

    public void showTimeInfo(String str) {
        showOpenIcon();
        showContactTime();
        WorkThreadUtil.getInstance().executeCachedTask(new AnonymousClass1(str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.xiaopeng.montecarlo.views.poicard.PoiCardTimeContainer$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public class AnonymousClass1 implements Runnable {
        final /* synthetic */ String val$deepInfo;

        AnonymousClass1(String str) {
            this.val$deepInfo = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            final String formatContactTime = SearchSceneDataHelper.formatContactTime(this.val$deepInfo);
            PoiCardTimeContainer.this.mHandler.post(new Runnable() { // from class: com.xiaopeng.montecarlo.views.poicard.-$$Lambda$PoiCardTimeContainer$1$zO2EcJSmpEFugVD88gRrzy3UgJo
                @Override // java.lang.Runnable
                public final void run() {
                    PoiCardTimeContainer.AnonymousClass1.this.lambda$run$0$PoiCardTimeContainer$1(formatContactTime);
                }
            });
        }

        public /* synthetic */ void lambda$run$0$PoiCardTimeContainer$1(String str) {
            PoiCardTimeContainer.this.handleTimeFormatCompleted(str);
        }
    }

    public void setContactTimeBackground(Drawable drawable) {
        setOpenTimeBackground(drawable);
        if (drawable == null) {
            hideOpenTime();
        } else {
            showOpenTime();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.xui.widget.XRelativeLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mLayoutListener = null;
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
