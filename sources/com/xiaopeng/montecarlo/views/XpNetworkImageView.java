package com.xiaopeng.montecarlo.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.XpThemeSwitchReceiver;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.util.ThemeWatcherUtil;
import com.xiaopeng.montecarlo.xpglide.IXpImageLoadListener;
import com.xiaopeng.xui.widget.XFrameLayout;
import com.xiaopeng.xui.widget.XLoading;
import com.xiaopeng.xui.widget.XRelativeLayout;
/* loaded from: classes3.dex */
public class XpNetworkImageView extends XFrameLayout implements IXpImageLoadListener {
    private static final int IMAGE_SIZE_BUFFER = 5;
    private XRelativeLayout mFailureLayer;
    private int mHeight;
    private LayoutInflater mInflater;
    private XpZoomImageView mIvPicture;
    private XFrameLayout mLoadingLayer;
    private XLoading mPbLoading;
    private XpThemeSwitchReceiver.ThemeSwitchListener mThemeSwitchReceiver;
    private int mWidth;

    public XpNetworkImageView(@NonNull Context context) {
        super(context);
        this.mWidth = 0;
        this.mHeight = 0;
        this.mThemeSwitchReceiver = new XpThemeSwitchReceiver.ThemeSwitchListener() { // from class: com.xiaopeng.montecarlo.views.XpNetworkImageView.1
            @Override // com.xiaopeng.montecarlo.XpThemeSwitchReceiver.ThemeSwitchListener
            public void onThemeSwitch(int i) {
                XpNetworkImageView.this.refreshImageView();
            }
        };
        init();
    }

    public XpNetworkImageView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mWidth = 0;
        this.mHeight = 0;
        this.mThemeSwitchReceiver = new XpThemeSwitchReceiver.ThemeSwitchListener() { // from class: com.xiaopeng.montecarlo.views.XpNetworkImageView.1
            @Override // com.xiaopeng.montecarlo.XpThemeSwitchReceiver.ThemeSwitchListener
            public void onThemeSwitch(int i) {
                XpNetworkImageView.this.refreshImageView();
            }
        };
        init();
    }

    public XpNetworkImageView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mWidth = 0;
        this.mHeight = 0;
        this.mThemeSwitchReceiver = new XpThemeSwitchReceiver.ThemeSwitchListener() { // from class: com.xiaopeng.montecarlo.views.XpNetworkImageView.1
            @Override // com.xiaopeng.montecarlo.XpThemeSwitchReceiver.ThemeSwitchListener
            public void onThemeSwitch(int i2) {
                XpNetworkImageView.this.refreshImageView();
            }
        };
        init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshImageView() {
        this.mPbLoading.invalidateDrawable(ThemeWatcherUtil.getDrawable(R.drawable.rotate_traffic_loading_icon));
    }

    private void init() {
        initView();
    }

    private void initView() {
        this.mInflater = LayoutInflater.from(getContext());
        this.mInflater.inflate(R.layout.layout_xp_network_image_view, (ViewGroup) this, true);
        this.mLoadingLayer = (XFrameLayout) findViewById(R.id.layer_loading);
        this.mPbLoading = (XLoading) findViewById(R.id.pb_loading);
        this.mIvPicture = (XpZoomImageView) findViewById(R.id.iv_picture);
        this.mFailureLayer = (XRelativeLayout) findViewById(R.id.layer_failure);
    }

    private void resizeFailureLayer() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mFailureLayer.getLayoutParams();
        int i = this.mWidth;
        if (i <= 0) {
            i = ContextUtils.getDimensionPixelSize(R.dimen.poi_pop_pic_height);
        }
        layoutParams.width = i;
        int i2 = this.mHeight;
        if (i2 <= 0) {
            i2 = ContextUtils.getDimensionPixelSize(R.dimen.poi_pop_pic_height);
        }
        layoutParams.height = i2;
    }

    private void resizeLoadingLayer() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mLoadingLayer.getLayoutParams();
        int i = this.mWidth;
        if (i <= 0) {
            i = ContextUtils.getDimensionPixelSize(R.dimen.poi_pop_pic_height);
        }
        layoutParams.width = i;
        int i2 = this.mHeight;
        if (i2 <= 0) {
            i2 = ContextUtils.getDimensionPixelSize(R.dimen.poi_pop_pic_height);
        }
        layoutParams.height = i2;
    }

    private void resetLayer() {
        this.mLoadingLayer.setVisibility(8);
        this.mIvPicture.setVisibility(8);
        this.mFailureLayer.setVisibility(8);
    }

    public void resetMatrix() {
        this.mIvPicture.reset();
    }

    private void registerThemeWatcher() {
        ThemeWatcherUtil.addXpThemeSwitchListener(this.mThemeSwitchReceiver);
    }

    public void unregisterThemeWatcher() {
        ThemeWatcherUtil.removeXpThemeListener(this.mThemeSwitchReceiver);
    }

    public XpNetworkImageViewTarget renderPicture(String str, int i, int i2) {
        return renderPicture(str, i, i2, ContextUtils.getDimensionPixelSize(R.dimen.com_pic_round_corner__radius));
    }

    public XpNetworkImageViewTarget renderPicture(String str) {
        return renderPicture(str, ContextUtils.getDimensionPixelSize(R.dimen.com_pic_round_corner__radius));
    }

    public XpNetworkImageViewTarget renderPicture(String str, int i) {
        return renderPicture(str, 0, 0, i);
    }

    public XpNetworkImageViewTarget renderPicture(String str, int i, int i2, int i3) {
        int i4;
        this.mWidth = i;
        this.mHeight = i2;
        XpNetworkImageViewTarget xpNetworkImageViewTarget = new XpNetworkImageViewTarget(getContext(), this.mIvPicture, 0, 0, this);
        RequestOptions centerCrop = new RequestOptions().centerCrop();
        int i5 = this.mWidth;
        if (i5 > 0 && (i4 = this.mHeight) > 0) {
            centerCrop.override(i5, i4);
        }
        if (i3 > 0) {
            RequestOptions.bitmapTransform(new RoundedCorners(i3));
        }
        xpNetworkImageViewTarget.loadImageWithRetry(centerCrop, str);
        return xpNetworkImageViewTarget;
    }

    @Override // com.xiaopeng.montecarlo.xpglide.IXpImageLoadListener
    public void onLoadStarted() {
        resetLayer();
        this.mLoadingLayer.setVisibility(0);
        resizeLoadingLayer();
    }

    @Override // com.xiaopeng.montecarlo.xpglide.IXpImageLoadListener
    public void onLoadSuccess(@NonNull Bitmap bitmap) {
        int height = bitmap.getHeight();
        int width = bitmap.getWidth();
        int dimensionPixelSize = ContextUtils.getDimensionPixelSize(R.dimen.poi_pop_pic_height);
        int dimensionPixelSize2 = ContextUtils.getDimensionPixelSize(R.dimen.poi_pop_pic_height);
        int i = height - width;
        if (i > 5) {
            dimensionPixelSize2 = ContextUtils.getDimensionPixelSize(R.dimen.poi_pop_pic_height);
            dimensionPixelSize = ContextUtils.getDimensionPixelSize(R.dimen.poi_pop_pic_width_vertical);
        } else if (i < 5) {
            dimensionPixelSize2 = ContextUtils.getDimensionPixelSize(R.dimen.poi_pop_pic_height_horizontal);
            dimensionPixelSize = ContextUtils.getDimensionPixelSize(R.dimen.dimen_poi_card_view_large_poi_icon_container_width);
        }
        this.mIvPicture.setLayoutParams(new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize2));
        resetLayer();
        this.mIvPicture.setVisibility(0);
    }

    @Override // com.xiaopeng.montecarlo.xpglide.IXpImageLoadListener
    public void onLoadFailed() {
        resetLayer();
        this.mFailureLayer.setVisibility(0);
        resizeFailureLayer();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.xui.widget.XFrameLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        registerThemeWatcher();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.xui.widget.XFrameLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        unregisterThemeWatcher();
    }
}
