package com.xiaopeng.montecarlo.views;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.bean.traffic.TrafficEventData;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import com.xiaopeng.montecarlo.trafficevent.ITrafficEventContract;
import com.xiaopeng.montecarlo.trafficevent.TrafficEventPresenter;
import com.xiaopeng.montecarlo.util.ResUtil;
import com.xiaopeng.montecarlo.util.ThemeWatcherUtil;
import com.xiaopeng.montecarlo.util.Utils;
import com.xiaopeng.xui.view.XView;
import com.xiaopeng.xui.widget.XImageView;
import com.xiaopeng.xui.widget.XRelativeLayout;
import com.xiaopeng.xui.widget.XTextView;
import com.xiaopeng.xui.widget.XViewPager;
/* loaded from: classes3.dex */
public class TrafficEventPopView extends XRelativeLayout implements ITrafficEventContract.ITrafficEventPopView {
    private static final L.Tag TAG = new L.Tag("TrafficEventPopView");
    private Animation mAlphaIn;
    private Animation mAlphaOut;
    private ITrafficEventContract.ITrafficEventPopView.ICallBack mCallback;
    private Context mContext;
    private XRelativeLayout mIncidentContentPanel;
    private XTextView mIncidentDes2View;
    private XTextView mIncidentDes3IconView;
    private XTextView mIncidentDesView;
    private XImageView mIncidentIconView;
    private XRelativeLayout mIncidentLoadingContainer;
    private XTextView mIncidentSubTitleView;
    private XTextView mIncidentTitleView;
    private volatile boolean mIsVisible;
    private View mLoadingFailedView;
    private XView mLoadingView;
    private IconPageAdapter mPoiIconAdapter;
    private XViewPager mPoiIconContainer;
    private TrafficEventPresenter mPresenter;
    private View mRootView;
    private int mTrafficIconId;
    private XRelativeLayout mTrafficPopContainer;
    private XTextView mTvReloading;

    public TrafficEventPopView(Context context) {
        this(context, null);
    }

    public TrafficEventPopView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TrafficEventPopView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mIsVisible = false;
        this.mContext = context;
        initView();
    }

    @Override // com.xiaopeng.montecarlo.trafficevent.ITrafficEventContract.ITrafficEventPopView
    public void setPresenter(TrafficEventPresenter trafficEventPresenter) {
        this.mPresenter = trafficEventPresenter;
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(R.layout.layout_traffic_incident_info, this);
        this.mTrafficPopContainer = (XRelativeLayout) this.mRootView.findViewById(R.id.traffic_pop_container);
        this.mPoiIconAdapter = new IconPageAdapter(getContext(), ContextUtils.getDimensionPixelSize(R.dimen.traffic_incident_picture_width), ContextUtils.getDimensionPixelSize(R.dimen.traffic_incident_picture_height));
        this.mPoiIconContainer = (XViewPager) this.mRootView.findViewById(R.id.incident_icon_container);
        this.mPoiIconContainer.setAdapter(this.mPoiIconAdapter);
        this.mPoiIconContainer.setOffscreenPageLimit(3);
        this.mPoiIconContainer.setPageMargin(ContextUtils.getDimensionPixelSize(R.dimen.traffic_incident_picture_gap));
        this.mIncidentIconView = (XImageView) this.mRootView.findViewById(R.id.incident_icon);
        this.mIncidentTitleView = (XTextView) this.mRootView.findViewById(R.id.incident_title);
        this.mIncidentSubTitleView = (XTextView) this.mRootView.findViewById(R.id.incident_sub_title);
        this.mIncidentDesView = (XTextView) this.mRootView.findViewById(R.id.incident_description_1);
        this.mIncidentDes2View = (XTextView) this.mRootView.findViewById(R.id.incident_discription_2);
        this.mIncidentDes3IconView = (XTextView) this.mRootView.findViewById(R.id.incident_description_3_with_icon);
        this.mIncidentLoadingContainer = (XRelativeLayout) this.mRootView.findViewById(R.id.traffic_event_loading_container);
        this.mIncidentContentPanel = (XRelativeLayout) this.mRootView.findViewById(R.id.traffic_content_panel);
        this.mLoadingFailedView = this.mRootView.findViewById(R.id.traffic_event_loading_failed_container);
        this.mLoadingView = (XView) this.mRootView.findViewById(R.id.traffic_loading_progress_container);
        this.mTvReloading = (XTextView) this.mRootView.findViewById(R.id.loading_again);
        this.mTvReloading.setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.montecarlo.views.TrafficEventPopView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TrafficEventPopView.this.switchToLoading();
                if (TrafficEventPopView.this.mCallback != null) {
                    TrafficEventPopView.this.mCallback.onReload();
                }
            }
        });
        this.mIsVisible = getVisibility() == 0;
        this.mAlphaIn = AnimationUtils.loadAnimation(this.mContext, R.anim.anim_traffic_alpha_in);
        this.mAlphaOut = AnimationUtils.loadAnimation(this.mContext, R.anim.anim_traffic_alpha_out);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), 0), View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i2), 0));
    }

    private void switchToNormal() {
        this.mTrafficPopContainer.startAnimation(this.mAlphaOut);
        this.mAlphaOut.setAnimationListener(new Animation.AnimationListener() { // from class: com.xiaopeng.montecarlo.views.TrafficEventPopView.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                TrafficEventPopView.this.mLoadingView.setVisibility(8);
                TrafficEventPopView.this.mIncidentLoadingContainer.setVisibility(8);
                TrafficEventPopView.this.mIncidentContentPanel.setVisibility(0);
                TrafficEventPopView.this.mLoadingFailedView.setVisibility(8);
                TrafficEventPopView.this.mTrafficPopContainer.startAnimation(TrafficEventPopView.this.mAlphaIn);
            }
        });
        updateNormalTheme();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void switchToLoading() {
        this.mLoadingView.setVisibility(0);
        this.mIncidentLoadingContainer.setVisibility(0);
        this.mIncidentContentPanel.setVisibility(8);
        this.mLoadingFailedView.setVisibility(8);
    }

    private void switchToFailed() {
        this.mLoadingView.setVisibility(8);
        this.mIncidentLoadingContainer.setVisibility(8);
        this.mIncidentContentPanel.setVisibility(8);
        this.mLoadingFailedView.setVisibility(0);
    }

    private void movePosition(int i, int i2) {
        int measuredWidth = i - (getMeasuredWidth() / 2);
        int visibleBottom = (RootUtil.getVisibleBottom() - i2) + ContextUtils.getDimensionPixelSize(R.dimen.traffic_event_pop_y_offset);
        float translationX = getTranslationX();
        float translationY = getTranslationY();
        float f = measuredWidth;
        if (translationX == f && translationY == visibleBottom) {
            if (L.ENABLE) {
                L.d(TAG, "updateCardPosition translation is already same with rect");
            }
        } else if (Utils.isPortrait()) {
            setTranslationX(f);
            setTranslationY(-visibleBottom);
        }
    }

    private void updateData(TrafficEventData trafficEventData) {
        if (trafficEventData == null) {
            switchToFailed();
            return;
        }
        if (!TextUtils.isEmpty(trafficEventData.getLayerTag())) {
            this.mTrafficIconId = ResUtil.getTrafficEventIconId(trafficEventData.getLayerTag(), true);
            this.mIncidentIconView.setImageResource(ThemeWatcherUtil.getDrawableResId(this.mTrafficIconId));
            this.mIncidentTitleView.setText(ResUtil.getTrafficName(trafficEventData.getLayerTag()));
        } else {
            if (trafficEventData.getTrafficIconId() != 0) {
                this.mTrafficIconId = trafficEventData.getTrafficIconId();
                this.mIncidentIconView.setImageResource(ThemeWatcherUtil.getDrawableResId(this.mTrafficIconId));
            }
            if (!TextUtils.isEmpty(trafficEventData.getIncidentTitle())) {
                this.mIncidentTitleView.setText(trafficEventData.getIncidentTitle());
            }
        }
        if (!TextUtils.isEmpty(trafficEventData.getIncidentSubTitle())) {
            this.mIncidentSubTitleView.setText(trafficEventData.getIncidentSubTitle());
            this.mIncidentSubTitleView.setVisibility(0);
        } else {
            this.mIncidentSubTitleView.setVisibility(8);
        }
        if (!TextUtils.isEmpty(trafficEventData.getIncidentDes1())) {
            this.mIncidentDesView.setText(trafficEventData.getIncidentDes1());
            this.mIncidentDesView.setVisibility(0);
        } else {
            this.mIncidentDesView.setVisibility(8);
        }
        if (!TextUtils.isEmpty(trafficEventData.getIncidentDes2())) {
            this.mIncidentDes2View.setText(trafficEventData.getIncidentDes2());
            this.mIncidentDes2View.setVisibility(0);
        } else {
            this.mIncidentDes2View.setVisibility(8);
        }
        if (!TextUtils.isEmpty(trafficEventData.getIncidentDes3())) {
            this.mIncidentDes3IconView.setText(trafficEventData.getIncidentDes3());
            this.mIncidentDes3IconView.setVisibility(0);
            if (trafficEventData.isOfficial()) {
                Drawable drawable = ThemeWatcherUtil.getDrawable(R.drawable.icon_20_normal_traffic_v);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.mIncidentDes3IconView.setCompoundDrawables(drawable, null, null, null);
                this.mIncidentDes3IconView.setCompoundDrawablePadding(ContextUtils.getDimensionPixelSize(R.dimen.traffic_event_user_indicator_drawable_padding));
            } else {
                this.mIncidentDes3IconView.setCompoundDrawables(null, null, null, null);
                this.mIncidentDes3IconView.setCompoundDrawablePadding(0);
            }
        } else {
            this.mIncidentDes3IconView.setVisibility(8);
        }
        if (CollectionUtils.isNotEmpty(trafficEventData.getUrls())) {
            this.mPoiIconAdapter.setIconsUrls(trafficEventData.getUrls());
            this.mPoiIconContainer.setVisibility(0);
        } else {
            this.mPoiIconContainer.setVisibility(8);
        }
        switchToNormal();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.xui.widget.XRelativeLayout, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        updateTheme();
    }

    public void updateTheme() {
        updateNormalTheme();
    }

    private void updateNormalTheme() {
        this.mIncidentIconView.setImageResource(ThemeWatcherUtil.getDrawableResId(this.mTrafficIconId));
        if (this.mPoiIconContainer.getVisibility() == 0) {
            this.mPoiIconContainer.setAdapter(this.mPoiIconAdapter);
        }
    }

    public void setPopLocation() {
        TrafficEventPresenter trafficEventPresenter = this.mPresenter;
        if (trafficEventPresenter != null) {
            trafficEventPresenter.setTrafficPopViewLocation();
        }
    }

    @Override // com.xiaopeng.montecarlo.trafficevent.ITrafficEventContract.ITrafficEventPopView
    public void show() {
        setVisibility(0);
        this.mIsVisible = true;
    }

    @Override // com.xiaopeng.montecarlo.trafficevent.ITrafficEventContract.ITrafficEventPopView
    public void close() {
        setVisibility(8);
        this.mIsVisible = false;
    }

    @Override // com.xiaopeng.montecarlo.trafficevent.ITrafficEventContract.ITrafficEventPopView
    public void showLoading() {
        switchToLoading();
    }

    @Override // com.xiaopeng.montecarlo.trafficevent.ITrafficEventContract.ITrafficEventPopView
    public void showFailed() {
        switchToFailed();
    }

    @Override // com.xiaopeng.montecarlo.trafficevent.ITrafficEventContract.ITrafficEventPopView
    public void showEventData(TrafficEventData trafficEventData) {
        updateData(trafficEventData);
    }

    @Override // com.xiaopeng.montecarlo.trafficevent.ITrafficEventContract.ITrafficEventPopView
    public void move(int i, int i2) {
        movePosition(i, i2);
    }

    @Override // com.xiaopeng.montecarlo.trafficevent.ITrafficEventContract.ITrafficEventPopView
    public void setCallback(ITrafficEventContract.ITrafficEventPopView.ICallBack iCallBack) {
        this.mCallback = iCallBack;
        IconPageAdapter iconPageAdapter = this.mPoiIconAdapter;
        if (iconPageAdapter != null) {
            iconPageAdapter.setCallback(this.mCallback);
        }
    }

    @Override // com.xiaopeng.montecarlo.trafficevent.ITrafficEventContract.ITrafficEventPopView
    public boolean isVisible() {
        return getVisibility() == 0;
    }
}
