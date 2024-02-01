package com.xiaopeng.montecarlo.views;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.support.rastermill.FrameSequenceUtil;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.XpThemeSwitchReceiver;
import com.xiaopeng.montecarlo.navcore.sr.SRNaviManager;
import com.xiaopeng.montecarlo.root.datalog.BtnType;
import com.xiaopeng.montecarlo.root.datalog.DataLogUtil;
import com.xiaopeng.montecarlo.root.datalog.PageType;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.timer.XCountDownTimer;
import com.xiaopeng.montecarlo.util.ThemeWatcherUtil;
import com.xiaopeng.xui.widget.XImageView;
import com.xiaopeng.xui.widget.XLinearLayout;
import com.xiaopeng.xui.widget.XLoading;
import com.xiaopeng.xui.widget.XRelativeLayout;
import com.xiaopeng.xui.widget.XTextView;
/* loaded from: classes3.dex */
public class XpNgpPanelView extends XRelativeLayout implements View.OnClickListener, XCountDownTimer.ITimerCallback {
    private static final long NGP_PANEL_CLOSE_TIMER = 5000;
    private static final long NGP_PANEL_HIDE_TIMER = 30000;
    private static final L.Tag TAG = new L.Tag("XpNgpPanelView");
    private AnimationDrawable mAnimationDrawable;
    private AnimatorSet mAnimatorSet;
    private final XCountDownTimer mCountDownTimer;
    private final int mDriveLevelHeight;
    private final int mDriveLevelWidth;
    private int mIconResId;
    private boolean mIsIconAnimator;
    private boolean mIsWarningAnimator;
    private XTextView mLcTipsContentMain;
    private XTextView mLcTipsContentOperate;
    private XTextView mLcTipsDriveLevelContent;
    private XRelativeLayout mLcTipsDriveLevelLayout;
    private XImageView mLcTipsIcon;
    private XLinearLayout mLcTipsLayout;
    private final int mLcTipsLayoutTargetHeight;
    private int mLcTipsLayoutTargetWidth;
    private final int mLcTipsLayoutWidthOffset;
    private XImageView mLcTipsSingleIcon;
    private XRelativeLayout mLcTipsSingleLayout;
    private XLoading mLcTipsSingleLoading;
    private int mLcTipsStatus;
    private int mOperateType;
    private OnNgpPanelStatusListener mPanelListener;
    private int mPanelStatus;
    private final int mSingleHeight;
    private final int mSingleWidth;
    private XpThemeSwitchReceiver.ThemeSwitchListener mThemeSwitchListener;

    /* loaded from: classes3.dex */
    public interface OnNgpPanelStatusListener {
        void onClick(int i, int i2, View view);

        void onNgpPanelSizeChanged();

        default void onNgpPanelWidthChanged() {
        }
    }

    @Override // com.xiaopeng.montecarlo.root.util.timer.XCountDownTimer.ITimerCallback
    public void onTick(long j) {
    }

    public /* synthetic */ void lambda$new$0$XpNgpPanelView(int i) {
        updateTheme();
    }

    public XpNgpPanelView(Context context) {
        this(context, null);
    }

    public XpNgpPanelView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public XpNgpPanelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mPanelStatus = -1;
        this.mIsWarningAnimator = false;
        this.mIconResId = -1;
        this.mIsIconAnimator = false;
        this.mThemeSwitchListener = new XpThemeSwitchReceiver.ThemeSwitchListener() { // from class: com.xiaopeng.montecarlo.views.-$$Lambda$XpNgpPanelView$IjUw6Tz-NXEyLe1yBJy2eYCTkAA
            @Override // com.xiaopeng.montecarlo.XpThemeSwitchReceiver.ThemeSwitchListener
            public final void onThemeSwitch(int i2) {
                XpNgpPanelView.this.lambda$new$0$XpNgpPanelView(i2);
            }
        };
        init();
        this.mDriveLevelWidth = ContextUtils.getDimensionPixelSize(R.dimen.ngp_panel_lc_tips_drive_level_layout_width);
        this.mDriveLevelHeight = ContextUtils.getDimensionPixelSize(R.dimen.ngp_panel_lc_tips_drive_level_layout_height);
        this.mSingleWidth = ContextUtils.getDimensionPixelSize(R.dimen.ngp_panel_lc_tips_single_layout_width);
        this.mSingleHeight = ContextUtils.getDimensionPixelSize(R.dimen.ngp_panel_lc_tips_single_layout_height);
        this.mLcTipsLayoutWidthOffset = (ContextUtils.getDimensionPixelSize(R.dimen.ngp_panel_lc_tips_layout_padding) * 2) + ContextUtils.getDimensionPixelSize(R.dimen.ngp_panel_lc_tips_icon_width) + ContextUtils.getDimensionPixelSize(R.dimen.ngp_panel_lc_tips_icon_margin_left) + ContextUtils.getDimensionPixelSize(R.dimen.ngp_panel_lc_tips_margin_right) + ContextUtils.getDimensionPixelSize(R.dimen.ngp_panel_lc_tips_margin_left);
        this.mLcTipsLayoutTargetHeight = ContextUtils.getDimensionPixelSize(R.dimen.ngp_panel_lc_tips_layout_height);
        setClickable(true);
        this.mCountDownTimer = new XCountDownTimer(5000L, this);
    }

    private void init() {
        View inflate = LayoutInflater.from(ContextUtils.getContext()).inflate(R.layout.layout_ngp_panel_view, (ViewGroup) this, true);
        this.mLcTipsDriveLevelLayout = (XRelativeLayout) inflate.findViewById(R.id.ngp_panel_lc_tips_drive_level_layout);
        this.mLcTipsDriveLevelContent = (XTextView) inflate.findViewById(R.id.ngp_panel_lc_tips_auto_drive_content);
        this.mLcTipsSingleLayout = (XRelativeLayout) inflate.findViewById(R.id.ngp_panel_lc_tips_single_layout);
        this.mLcTipsSingleIcon = (XImageView) inflate.findViewById(R.id.ngp_panel_lc_tips_single_icon);
        this.mLcTipsSingleLoading = (XLoading) inflate.findViewById(R.id.ngp_panel_lc_tips_single_loading);
        this.mLcTipsLayout = (XLinearLayout) inflate.findViewById(R.id.ngp_panel_lc_tips_layout);
        this.mLcTipsIcon = (XImageView) inflate.findViewById(R.id.ngp_panel_lc_tips_icon);
        this.mLcTipsContentMain = (XTextView) inflate.findViewById(R.id.ngp_panel_lc_tips_content_main);
        this.mLcTipsContentOperate = (XTextView) inflate.findViewById(R.id.ngp_panel_lc_tips_content_operate);
        refreshLcTipsLayoutTargetWidth();
    }

    private void updateTheme() {
        setLcTipsLayoutBackgroundByIsWarning(this.mIsWarningAnimator);
        if (this.mIsWarningAnimator) {
            stopWarningAnimation();
            startWarningAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.xui.widget.XRelativeLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ThemeWatcherUtil.addXpThemeSwitchListener(this.mThemeSwitchListener);
        updateTheme();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.xui.widget.XRelativeLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ThemeWatcherUtil.removeXpThemeListener(this.mThemeSwitchListener);
        this.mIsWarningAnimator = false;
        AnimationDrawable animationDrawable = this.mAnimationDrawable;
        if (animationDrawable != null) {
            animationDrawable.stop();
            this.mAnimationDrawable = null;
        }
        XCountDownTimer xCountDownTimer = this.mCountDownTimer;
        if (xCountDownTimer != null) {
            xCountDownTimer.stop();
        }
        stopAnimSet();
        stopArrowAnim();
        this.mIconResId = -1;
        this.mIsIconAnimator = false;
    }

    public void updateNgpOperateTips(int i, String str) {
        this.mOperateType = i;
        this.mLcTipsContentOperate.setText(str);
        if (TextUtils.isEmpty(str)) {
            this.mLcTipsContentOperate.setVisibility(8);
        } else {
            this.mLcTipsContentOperate.setVisibility(0);
        }
        refreshLcTipsLayoutTargetWidth();
    }

    public void updateNgpOperateBtnStatus(boolean z) {
        this.mLcTipsContentOperate.setVisibility((!z || TextUtils.isEmpty(this.mLcTipsContentOperate.getText().toString())) ? 8 : 0);
        refreshLcTipsLayoutTargetWidth();
    }

    public void updateNgpLcTips(int i, int i2, boolean z, Drawable drawable, String str) {
        this.mLcTipsStatus = i2;
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "updateNgpLcTipsAndOddStatus lcTipsStatus = " + i2 + " lcTipsText = " + str);
        }
        this.mCountDownTimer.stop();
        int ngpPanelStatus = SRNaviManager.getInstance().getNgpPanelStatus();
        if (2 == i) {
            if (1 == ngpPanelStatus) {
                updateAutoLayout(str);
                i = ngpPanelStatus;
            } else {
                updateAutoSmallLayout(str);
            }
        } else if (3 == i || 4 == i) {
            updateNormalSingleLayout(drawable, str);
        } else if (5 == i) {
            updateLoadingLayout();
        } else {
            updateNormalLayout(drawable, str);
        }
        this.mPanelStatus = i;
        SRNaviManager.getInstance().updateNgpPanelStatus(this.mPanelStatus);
        if (this.mIsWarningAnimator != z) {
            setLcTipsLayoutBackgroundByIsWarning(z);
            this.mIsWarningAnimator = z;
            if (z) {
                stopWarningAnimation();
                startWarningAnimation();
                return;
            }
            stopWarningAnimation();
        }
    }

    private void setLcTipsLayoutBackgroundByIsWarning(boolean z) {
        int paddingLeft = this.mLcTipsLayout.getPaddingLeft();
        this.mLcTipsLayout.setBackground(ThemeWatcherUtil.getDrawable(z ? R.drawable.ngp_panel_lctips_view_animator_bg : R.drawable.ngp_panel_lctips_view_bg));
        this.mLcTipsLayout.setPadding(paddingLeft, paddingLeft, paddingLeft, paddingLeft);
    }

    public void updateLcTipsArrow(int i, boolean z) {
        this.mIsIconAnimator = z;
        this.mIconResId = i;
        if (!z || i == -1) {
            return;
        }
        startArrowAnim(i);
    }

    private View getCurrentLayout() {
        int i = this.mPanelStatus;
        if (1 == i) {
            return this.mLcTipsDriveLevelLayout;
        }
        if (i == 0) {
            return this.mLcTipsLayout;
        }
        return this.mLcTipsSingleLayout;
    }

    private void updateAutoLayout(String str) {
        stopArrowAnim();
        this.mLcTipsDriveLevelContent.setText(str);
        stopAnimSet();
        startToDriveLevelAnim();
        setOnClickListener(null);
        this.mCountDownTimer.setMillisInFuture(NGP_PANEL_HIDE_TIMER);
        this.mCountDownTimer.start();
    }

    private void updateAutoSmallLayout(String str) {
        stopArrowAnim();
        stopAnimSet();
        this.mLcTipsSingleIcon.setVisibility(0);
        this.mLcTipsSingleLoading.setVisibility(8);
        this.mLcTipsDriveLevelContent.setText(str);
        this.mLcTipsSingleIcon.setImageDrawable(ThemeWatcherUtil.getDrawable(R.drawable.vector_ic_ngp_turnoff));
        setOnClickListener(this);
        this.mLcTipsDriveLevelLayout.setVisibility(8);
        this.mLcTipsLayout.setVisibility(8);
        this.mLcTipsSingleLayout.setVisibility(0);
    }

    private void updateNormalSingleLayout(Drawable drawable, String str) {
        stopArrowAnim();
        this.mLcTipsSingleIcon.setVisibility(0);
        this.mLcTipsSingleLoading.setVisibility(8);
        this.mLcTipsSingleIcon.setImageDrawable(drawable);
        this.mLcTipsIcon.setImageDrawable(drawable);
        if (TextUtils.isEmpty(str)) {
            this.mLcTipsContentMain.setText(R.string.srnavi_ngp_panel_driving);
        } else {
            this.mLcTipsContentMain.setText(str);
        }
        refreshLcTipsLayoutTargetWidth();
        stopAnimSet();
        startToNormalAnim(3);
        setOnClickListener(this);
    }

    private void updateLoadingLayout() {
        stopArrowAnim();
        this.mLcTipsSingleIcon.setVisibility(8);
        this.mLcTipsSingleLoading.setVisibility(0);
        stopAnimSet();
        this.mLcTipsDriveLevelLayout.setVisibility(8);
        this.mLcTipsLayout.setVisibility(8);
        this.mLcTipsSingleLayout.setVisibility(0);
    }

    private void updateNormalLayout(Drawable drawable, String str) {
        stopArrowAnim();
        this.mLcTipsIcon.setImageDrawable(drawable);
        this.mLcTipsSingleIcon.setImageDrawable(drawable);
        if (TextUtils.isEmpty(str)) {
            this.mLcTipsContentMain.setText(R.string.srnavi_ngp_panel_driving);
        } else {
            this.mLcTipsContentMain.setText(str);
        }
        refreshLcTipsLayoutTargetWidth();
        setOnClickListener(this);
        stopAnimSet();
        startToNormalAnim(0);
    }

    private void updateNormalPanel(boolean z) {
        updateLcTipsArrow(this.mIconResId, this.mIsIconAnimator);
        if (z) {
            stopAnimSet();
            startNormalToSingleAnim();
            return;
        }
        stopAnimSet();
        startSingleToNormalAnim();
    }

    private void stopAnimSet() {
        AnimatorSet animatorSet = this.mAnimatorSet;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.mAnimatorSet = null;
        }
    }

    private void startToDriveLevelAnim() {
        int i = this.mPanelStatus == 0 ? this.mLcTipsLayoutTargetWidth : this.mSingleWidth;
        int i2 = this.mPanelStatus == 0 ? this.mLcTipsLayoutTargetHeight : this.mSingleHeight;
        int i3 = this.mDriveLevelWidth;
        int i4 = this.mDriveLevelHeight;
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "startToDriveLevelAnim oldWidth = " + i + " oldHeight = " + i2 + " targetWidth = " + i3 + " targetHeight = " + i4);
        }
        this.mLcTipsDriveLevelLayout.setVisibility(0);
        this.mLcTipsLayout.setVisibility(8);
        this.mLcTipsSingleLayout.setVisibility(8);
        this.mAnimatorSet = new AnimatorSet();
        this.mAnimatorSet.playTogether(createZoomXAnim(this.mLcTipsDriveLevelLayout, i, i3), createZoomYAnim(this.mLcTipsDriveLevelLayout, i2, i4), ObjectAnimator.ofFloat(this.mLcTipsDriveLevelLayout, "alpha", 0.0f, 1.0f));
        this.mAnimatorSet.setDuration(300L);
        this.mAnimatorSet.start();
    }

    private void startToNormalAnim(int i) {
        if (1 == this.mPanelStatus) {
            driveLevelToNormalAnim(i);
            return;
        }
        if (i == 0) {
            this.mLcTipsDriveLevelLayout.setVisibility(8);
            this.mLcTipsLayout.setVisibility(0);
            this.mLcTipsSingleLayout.setVisibility(8);
        } else {
            this.mLcTipsDriveLevelLayout.setVisibility(8);
            this.mLcTipsLayout.setVisibility(8);
            this.mLcTipsSingleLayout.setVisibility(0);
        }
        if (this.mPanelStatus == 0 && i != 0) {
            startNormalToSingleAnim();
            return;
        }
        int i2 = this.mPanelStatus;
        if (i2 == 0 || -1 == i2 || i != 0) {
            return;
        }
        startSingleToNormalAnim();
    }

    private void driveLevelToNormalAnim(final int i) {
        int i2 = this.mDriveLevelWidth;
        int i3 = this.mDriveLevelHeight;
        int i4 = i == 0 ? this.mLcTipsLayoutTargetWidth : this.mSingleWidth;
        int i5 = i == 0 ? this.mLcTipsLayoutTargetHeight : this.mSingleHeight;
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "driveLevelToNormalAnim oldWidth = " + i2 + " oldHeight = " + i3 + " targetWidth = " + i4 + " targetHeight = " + i5);
        }
        this.mAnimatorSet = new AnimatorSet();
        this.mAnimatorSet.playTogether(createZoomXAnim(this.mLcTipsDriveLevelLayout, i2, i4), createZoomYAnim(this.mLcTipsDriveLevelLayout, i3, i5), ObjectAnimator.ofFloat(this.mLcTipsDriveLevelLayout, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(i == 0 ? this.mLcTipsLayout : this.mLcTipsSingleLayout, "alpha", 0.0f, 1.0f));
        this.mAnimatorSet.setDuration(300L);
        this.mAnimatorSet.addListener(new Animator.AnimatorListener() { // from class: com.xiaopeng.montecarlo.views.XpNgpPanelView.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (i == 0) {
                    XpNgpPanelView.this.mLcTipsDriveLevelLayout.setVisibility(0);
                    XpNgpPanelView.this.mLcTipsLayout.setVisibility(0);
                    XpNgpPanelView.this.mLcTipsSingleLayout.setVisibility(8);
                    return;
                }
                XpNgpPanelView.this.mLcTipsDriveLevelLayout.setVisibility(0);
                XpNgpPanelView.this.mLcTipsLayout.setVisibility(8);
                XpNgpPanelView.this.mLcTipsSingleLayout.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (i == 0) {
                    XpNgpPanelView.this.mLcTipsDriveLevelLayout.setVisibility(8);
                    XpNgpPanelView.this.mLcTipsLayout.setVisibility(0);
                    XpNgpPanelView.this.mLcTipsSingleLayout.setVisibility(8);
                    return;
                }
                XpNgpPanelView.this.mLcTipsDriveLevelLayout.setVisibility(8);
                XpNgpPanelView.this.mLcTipsLayout.setVisibility(8);
                XpNgpPanelView.this.mLcTipsSingleLayout.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                if (i == 0) {
                    XpNgpPanelView.this.mLcTipsDriveLevelLayout.setVisibility(8);
                    XpNgpPanelView.this.mLcTipsLayout.setVisibility(0);
                    XpNgpPanelView.this.mLcTipsSingleLayout.setVisibility(8);
                    XpNgpPanelView.this.mLcTipsLayout.setAlpha(1.0f);
                    return;
                }
                XpNgpPanelView.this.mLcTipsDriveLevelLayout.setVisibility(8);
                XpNgpPanelView.this.mLcTipsLayout.setVisibility(8);
                XpNgpPanelView.this.mLcTipsSingleLayout.setVisibility(0);
                XpNgpPanelView.this.mLcTipsSingleLayout.setAlpha(1.0f);
            }
        });
        this.mAnimatorSet.start();
    }

    private void startNormalToSingleAnim() {
        int i = this.mSingleWidth;
        int i2 = this.mLcTipsLayoutTargetWidth;
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "startNormalToSingleAnim oldWidth = " + i2 + " targetWidth = " + i);
        }
        ValueAnimator createZoomXAnim = createZoomXAnim(this.mLcTipsLayout, i2, i);
        this.mAnimatorSet = new AnimatorSet();
        this.mAnimatorSet.play(createZoomXAnim);
        this.mAnimatorSet.setDuration(300L);
        this.mAnimatorSet.addListener(new Animator.AnimatorListener() { // from class: com.xiaopeng.montecarlo.views.XpNgpPanelView.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                XpNgpPanelView.this.resetLcTipsLayoutParam();
                XpNgpPanelView.this.mLcTipsSingleLayout.setVisibility(0);
                XpNgpPanelView.this.mLcTipsLayout.setVisibility(8);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                XpNgpPanelView.this.resetLcTipsLayoutParam();
                XpNgpPanelView.this.mLcTipsSingleLayout.setVisibility(0);
                XpNgpPanelView.this.mLcTipsLayout.setVisibility(8);
            }
        });
        this.mAnimatorSet.start();
    }

    private void refreshLcTipsLayoutTargetWidth() {
        int measureText = (this.mLcTipsContentOperate.getVisibility() != 0 || TextUtils.isEmpty(this.mLcTipsContentOperate.getText())) ? 0 : (int) this.mLcTipsContentOperate.getPaint().measureText(this.mLcTipsContentOperate.getText().toString());
        if (this.mLcTipsContentMain.getVisibility() == 0 && !TextUtils.isEmpty(this.mLcTipsContentMain.getText())) {
            measureText = Math.max(measureText, (int) this.mLcTipsContentMain.getPaint().measureText(this.mLcTipsContentMain.getText().toString()));
        }
        this.mLcTipsLayoutTargetWidth = this.mLcTipsLayoutWidthOffset + measureText;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetLcTipsLayoutParam() {
        ViewGroup.LayoutParams layoutParams = this.mLcTipsLayout.getLayoutParams();
        layoutParams.width = -2;
        this.mLcTipsLayout.setLayoutParams(layoutParams);
    }

    private void startSingleToNormalAnim() {
        int i = this.mSingleWidth;
        int i2 = this.mLcTipsLayoutTargetWidth;
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "startSingleToNormalAnim oldWidth = " + i + " targetWidth = " + i2);
        }
        this.mLcTipsSingleLayout.setVisibility(8);
        this.mLcTipsLayout.setVisibility(0);
        ValueAnimator createZoomXAnim = createZoomXAnim(this.mLcTipsLayout, i, i2);
        this.mAnimatorSet = new AnimatorSet();
        this.mAnimatorSet.play(createZoomXAnim);
        this.mAnimatorSet.setDuration(300L);
        this.mAnimatorSet.addListener(new Animator.AnimatorListener() { // from class: com.xiaopeng.montecarlo.views.XpNgpPanelView.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                XpNgpPanelView.this.resetLcTipsLayoutParam();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                XpNgpPanelView.this.resetLcTipsLayoutParam();
            }
        });
        this.mAnimatorSet.start();
    }

    private ValueAnimator createZoomXAnim(final View view, int i, int i2) {
        ValueAnimator ofInt = ValueAnimator.ofInt(i, i2);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.xiaopeng.montecarlo.views.-$$Lambda$XpNgpPanelView$o6FdFwANxbFXfTo0FeqnsZdbZLA
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                XpNgpPanelView.lambda$createZoomXAnim$1(view, valueAnimator);
            }
        });
        return ofInt;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$createZoomXAnim$1(View view, ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = intValue;
        view.setLayoutParams(layoutParams);
    }

    private ValueAnimator createZoomYAnim(final View view, int i, int i2) {
        ValueAnimator ofInt = ValueAnimator.ofInt(i, i2);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.xiaopeng.montecarlo.views.-$$Lambda$XpNgpPanelView$42f5M72_DpAwT3KZWAbG0Dq-718
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                XpNgpPanelView.lambda$createZoomYAnim$2(view, valueAnimator);
            }
        });
        return ofInt;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$createZoomYAnim$2(View view, ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = intValue;
        view.setLayoutParams(layoutParams);
    }

    private void startArrowAnim(int i) {
        XImageView xImageView = this.mPanelStatus == 0 ? this.mLcTipsIcon : this.mLcTipsSingleIcon;
        if (xImageView == null) {
            return;
        }
        FrameSequenceUtil.with(xImageView).resourceId(i).loopBehavior(2).applyAsync();
        FrameSequenceUtil.start(xImageView);
    }

    private void stopArrowAnim() {
        XImageView xImageView = this.mPanelStatus == 0 ? this.mLcTipsIcon : this.mLcTipsSingleIcon;
        if (xImageView != null) {
            FrameSequenceUtil.stop(xImageView);
        }
    }

    private void startWarningAnimation() {
        if (this.mAnimationDrawable == null) {
            this.mAnimationDrawable = (AnimationDrawable) this.mLcTipsLayout.getBackground();
        }
        AnimationDrawable animationDrawable = this.mAnimationDrawable;
        if (animationDrawable != null) {
            animationDrawable.start();
        }
    }

    private void stopWarningAnimation() {
        AnimationDrawable animationDrawable = this.mAnimationDrawable;
        if (animationDrawable != null) {
            animationDrawable.stop();
            this.mAnimationDrawable = null;
        }
    }

    private void startToAutoSmallAnimation() {
        this.mPanelStatus = 2;
        SRNaviManager.getInstance().updateNgpPanelStatus(this.mPanelStatus);
        this.mLcTipsSingleIcon.setImageDrawable(ThemeWatcherUtil.getDrawable(R.drawable.vector_ic_ngp_turnoff));
        setOnClickListener(this);
        driveLevelToNormalAnim(this.mPanelStatus);
        OnNgpPanelStatusListener onNgpPanelStatusListener = this.mPanelListener;
        if (onNgpPanelStatusListener != null) {
            onNgpPanelStatusListener.onNgpPanelSizeChanged();
        }
    }

    public void setOnNgpPanelListener(OnNgpPanelStatusListener onNgpPanelStatusListener) {
        this.mPanelListener = onNgpPanelStatusListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mPanelListener != null) {
            L.Tag tag = TAG;
            L.i(tag, "click panel view mOperateType = " + this.mOperateType);
            int i = this.mPanelStatus;
            if (3 == i) {
                stopArrowAnim();
                this.mPanelStatus = 0;
                SRNaviManager.getInstance().updateNgpPanelStatus(this.mPanelStatus);
                updateNormalPanel(false);
                this.mCountDownTimer.setMillisInFuture(5000L);
                this.mCountDownTimer.start();
                DataLogUtil.sendStatData(PageType.NAVI_SR_PAGE_OPERATION, BtnType.NGP_PANEL_EXPAND_PANEL, new Object[0]);
            } else if (2 == i) {
                startToDriveLevelAnim();
                this.mPanelStatus = 1;
                SRNaviManager.getInstance().updateNgpPanelStatus(this.mPanelStatus);
                setOnClickListener(null);
                this.mCountDownTimer.setMillisInFuture(NGP_PANEL_HIDE_TIMER);
                this.mCountDownTimer.start();
                OnNgpPanelStatusListener onNgpPanelStatusListener = this.mPanelListener;
                if (onNgpPanelStatusListener != null) {
                    onNgpPanelStatusListener.onNgpPanelSizeChanged();
                }
                DataLogUtil.sendStatData(PageType.NAVI_SR_PAGE_OPERATION, BtnType.NGP_PANEL_COLLAPSE, new Object[0]);
            } else {
                if (this.mLcTipsContentOperate.getVisibility() == 0) {
                    int i2 = this.mOperateType;
                    if (i2 == 1) {
                        DataLogUtil.sendStatData(PageType.NAVI_SR_PAGE_OPERATION, BtnType.NGP_PANEL_UPGRADE_TO_NGP, new Object[0]);
                    } else if (i2 == 2) {
                        DataLogUtil.sendStatData(PageType.NAVI_SR_PAGE_OPERATION, BtnType.NGP_PANEL_DOWNGRADE_TO_LCC, new Object[0]);
                    } else if (i2 == 3) {
                        DataLogUtil.sendStatData(PageType.NAVI_SR_PAGE_OPERATION, BtnType.NGP_PANEL_CANCEL_CHANGE_LANE, new Object[0]);
                    }
                }
                this.mPanelListener.onClick(this.mOperateType, this.mLcTipsStatus, view);
            }
        }
    }

    @Override // com.xiaopeng.montecarlo.root.util.timer.XCountDownTimer.ITimerCallback
    public void onTimeOut() {
        int i = this.mPanelStatus;
        if (i != 0) {
            if (1 == i) {
                startToAutoSmallAnimation();
                return;
            }
            return;
        }
        stopArrowAnim();
        this.mPanelStatus = 3;
        SRNaviManager.getInstance().updateNgpPanelStatus(this.mPanelStatus);
        updateNormalPanel(true);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            notifyViewWidthChange();
        }
    }

    private void notifyViewWidthChange() {
        OnNgpPanelStatusListener onNgpPanelStatusListener = this.mPanelListener;
        if (onNgpPanelStatusListener != null) {
            onNgpPanelStatusListener.onNgpPanelWidthChanged();
        }
    }
}
