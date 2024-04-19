package com.xiaopeng.montecarlo.views;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.base.MainContext;
import com.xiaopeng.montecarlo.datalog.DataLogHelper;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.root.datalog.BtnType;
import com.xiaopeng.montecarlo.root.network.XPNetworkManager;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.timer.XCountDownTimer;
import com.xiaopeng.montecarlo.stat.NaviStatUtil;
import com.xiaopeng.montecarlo.util.Utils;
import com.xiaopeng.xui.view.XView;
import com.xiaopeng.xui.widget.XRelativeLayout;
import com.xiaopeng.xui.widget.XTextView;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes3.dex */
public class OfflinePopView extends XRelativeLayout implements View.OnClickListener {
    private static final int FIRST_ANIMA_STEP = 1;
    private static final int MAX_TIME = 15;
    private static final int NOT_ANIMA_STEP = 0;
    private static final int SECOND_ANIMA_STEP = 2;
    private static final L.Tag TAG = new L.Tag("OfflinePopView");
    private static final int TIPS_MAX_TIME = 6;
    private int mAnimStep;
    private AnimatorSet mAnimatorSet;
    private XView mBgRecount;
    private XTextView mClockTv;
    private XRelativeLayout mCollapseContainer;
    private View mCollapseInner;
    private XRelativeLayout mExpandContainer;
    private XRelativeLayout mGuideContainer;
    private boolean mIsAlive;
    private boolean mIsOfflineReRoute;
    private XRelativeLayout mLeftBtn;
    private LinearLayout mLeftGuidePanel;
    private IOfflinePopActionListener mListener;
    private MainContext mMainContext;
    private int mRemainTime;
    private Animator.AnimatorListener mShowTipsListener;
    private XCountDownTimer mTimer;
    private XTextView mTitle;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface AnimStep {
    }

    /* loaded from: classes3.dex */
    public interface IOfflinePopActionListener {
        void onVisibleStateExchanged(boolean z);

        void reRoute();
    }

    static /* synthetic */ int access$410(OfflinePopView offlinePopView) {
        int i = offlinePopView.mRemainTime;
        offlinePopView.mRemainTime = i - 1;
        return i;
    }

    public OfflinePopView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRemainTime = 15;
        this.mMainContext = null;
        this.mAnimStep = 0;
        this.mShowTipsListener = new Animator.AnimatorListener() { // from class: com.xiaopeng.montecarlo.views.OfflinePopView.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                OfflinePopView.this.mAnimStep = 2;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                OfflinePopView.this.mAnimatorSet.removeAllListeners();
                OfflinePopView.this.mAnimStep = 0;
                OfflinePopView.this.showCollapseButton();
            }
        };
        this.mIsOfflineReRoute = false;
        this.mTimer = null;
        this.mIsAlive = false;
        LayoutInflater.from(context).inflate(R.layout.layout_offline_guide, this);
        this.mTitle = (XTextView) findViewById(R.id.title);
        this.mClockTv = (XTextView) findViewById(R.id.clock_close);
        this.mExpandContainer = (XRelativeLayout) findViewById(R.id.expand);
        this.mCollapseContainer = (XRelativeLayout) findViewById(R.id.container_collapse);
        this.mCollapseInner = findViewById(R.id.container_collapse_inner);
        this.mLeftBtn = (XRelativeLayout) findViewById(R.id.left_btn);
        this.mBgRecount = (XView) findViewById(R.id.bg_recount);
        initClickListener();
    }

    public void setLandscapeParentView(XRelativeLayout xRelativeLayout, LinearLayout linearLayout) {
        this.mGuideContainer = xRelativeLayout;
        this.mLeftGuidePanel = linearLayout;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.xui.widget.XRelativeLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.xui.widget.XRelativeLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        int i = this.mAnimStep;
        if (i == 1) {
            this.mExpandContainer.animate().cancel();
            this.mExpandContainer.animate().setListener(null);
        } else if (i != 2) {
        } else {
            this.mExpandContainer.animate().cancel();
            this.mExpandContainer.animate().setListener(null);
            this.mAnimatorSet.cancel();
            this.mAnimatorSet.removeAllListeners();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showCollapseButton() {
        this.mExpandContainer.setVisibility(8);
        this.mLeftBtn.setVisibility(8);
        this.mClockTv.setVisibility(8);
        this.mCollapseContainer.setVisibility(0);
        if (Utils.isLandscape()) {
            LinearLayout linearLayout = this.mLeftGuidePanel;
            if (linearLayout != null && linearLayout.indexOfChild(this) > 0) {
                if (L.ENABLE) {
                    L.d(TAG, "mLeftGuidePanel container offline");
                    return;
                }
                return;
            }
            XRelativeLayout xRelativeLayout = this.mGuideContainer;
            if (xRelativeLayout == null || xRelativeLayout.indexOfChild(this) <= 0) {
                return;
            }
            this.mGuideContainer.removeView(this);
            LinearLayout linearLayout2 = this.mLeftGuidePanel;
            if (linearLayout2 != null) {
                linearLayout2.addView(this, linearLayout2.indexOfChild(linearLayout2.findViewById(R.id.srnavi_acc_view_text)));
            }
        }
    }

    public int getRemainTime() {
        XCountDownTimer xCountDownTimer = this.mTimer;
        if (xCountDownTimer != null) {
            return Math.round((((float) xCountDownTimer.getLeftTickTime()) * 1.0f) / 1000.0f);
        }
        return 0;
    }

    public void setRemainTime(int i) {
        this.mRemainTime = i;
    }

    public void setActionListener(IOfflinePopActionListener iOfflinePopActionListener) {
        this.mListener = iOfflinePopActionListener;
    }

    private void initClickListener() {
        this.mBgRecount.setOnClickListener(this);
        this.mClockTv.setOnClickListener(this);
        this.mExpandContainer.setOnClickListener(this);
        this.mCollapseInner.setOnClickListener(this);
    }

    private void initTimer() {
        this.mRemainTime = 15;
        this.mClockTv.setText(String.format(getResources().getString(R.string.restricted_rule_detail_guide_close_btn_name), Integer.valueOf(this.mRemainTime)));
        if (this.mTimer == null) {
            this.mTimer = new XCountDownTimer(this.mRemainTime * 1000, new XCountDownTimer.ITimerCallback() { // from class: com.xiaopeng.montecarlo.views.OfflinePopView.2
                @Override // com.xiaopeng.montecarlo.root.util.timer.XCountDownTimer.ITimerCallback
                public void onTick(long j) {
                    OfflinePopView.this.mClockTv.setText(String.format(OfflinePopView.this.getResources().getString(R.string.restricted_rule_detail_guide_close_btn_name), Long.valueOf(j)));
                    OfflinePopView.access$410(OfflinePopView.this);
                }

                @Override // com.xiaopeng.montecarlo.root.util.timer.XCountDownTimer.ITimerCallback
                public void onTimeOut() {
                    OfflinePopView.this.changeToRight();
                }
            });
        }
        XCountDownTimer xCountDownTimer = this.mTimer;
        if (xCountDownTimer != null) {
            xCountDownTimer.start();
        }
    }

    public int getTipsLeft() {
        return ContextUtils.getDimensionPixelSize(R.dimen.navi_offline_pop_view_tips_gone_left);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void destroyTimer() {
        XCountDownTimer xCountDownTimer = this.mTimer;
        if (xCountDownTimer != null) {
            xCountDownTimer.stop();
        }
    }

    private boolean isShow() {
        return getVisibility() == 0;
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        IOfflinePopActionListener iOfflinePopActionListener = this.mListener;
        if (iOfflinePopActionListener != null) {
            iOfflinePopActionListener.onVisibleStateExchanged(i == 0);
        }
    }

    public void show(boolean z) {
        this.mIsOfflineReRoute = false;
        this.mIsAlive = true;
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "show:" + this.mGuideContainer + "," + this.mLeftGuidePanel);
        }
        if (!z) {
            setVisibility(0);
            showCollapseButton();
        } else if (isShow()) {
        } else {
            setVisibility(0);
            initTimer();
            if (Utils.isLandscape()) {
                XRelativeLayout xRelativeLayout = this.mGuideContainer;
                if (xRelativeLayout != null && xRelativeLayout.indexOfChild(this) > 0) {
                    if (L.ENABLE) {
                        L.d(TAG, "mGuideContainer container offline");
                        return;
                    }
                    return;
                }
                LinearLayout linearLayout = this.mLeftGuidePanel;
                if (linearLayout == null || linearLayout.indexOfChild(this) <= 0) {
                    return;
                }
                this.mLeftGuidePanel.removeView(this);
                if (this.mGuideContainer != null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(14);
                    this.mGuideContainer.addView(this, layoutParams);
                }
            }
        }
    }

    public void reStartCountDown() {
        if (this.mClockTv.getVisibility() == 0) {
            this.mIsOfflineReRoute = false;
            initTimer();
        }
    }

    public boolean restoreShow() {
        if (this.mIsAlive) {
            if (!isShow()) {
                show(this.mRemainTime > 0);
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void newRightView() {
        this.mAnimatorSet = new AnimatorSet();
        this.mBgRecount.post(new Runnable() { // from class: com.xiaopeng.montecarlo.views.OfflinePopView.3
            @Override // java.lang.Runnable
            public void run() {
                OfflinePopView.this.mCollapseContainer.setVisibility(0);
                OfflinePopView.this.mAnimatorSet.play(ObjectAnimator.ofFloat(OfflinePopView.this.mCollapseContainer, "alpha", 0.0f, 1.0f));
                OfflinePopView.this.mAnimatorSet.setDuration(600L);
                OfflinePopView.this.mAnimatorSet.setInterpolator(new DecelerateInterpolator());
                OfflinePopView.this.mAnimatorSet.addListener(OfflinePopView.this.mShowTipsListener);
                OfflinePopView.this.mAnimatorSet.start();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeToRight() {
        if (this.mClockTv.getVisibility() == 8) {
            return;
        }
        if (Utils.isLandscape()) {
            this.mAnimatorSet = new AnimatorSet();
            this.mExpandContainer.post(new Runnable() { // from class: com.xiaopeng.montecarlo.views.OfflinePopView.4
                @Override // java.lang.Runnable
                public void run() {
                    OfflinePopView.this.mClockTv.setVisibility(8);
                    OfflinePopView.this.mTitle.setVisibility(8);
                    OfflinePopView.this.mExpandContainer.setPivotX(20.0f);
                    OfflinePopView.this.mExpandContainer.setPivotY(20.0f);
                    ObjectAnimator ofFloat = ObjectAnimator.ofFloat(OfflinePopView.this.mExpandContainer, "scaleX", 1.0f, 0.386f);
                    ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(OfflinePopView.this.mExpandContainer, "scaleY", 1.0f, 0.518f);
                    OfflinePopView.this.mBgRecount.setVisibility(8);
                    ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(OfflinePopView.this.mLeftBtn, "translationX", 0.0f, -40.0f);
                    OfflinePopView.this.mAnimatorSet.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ObjectAnimator.ofFloat(OfflinePopView.this.mLeftBtn, "translationY", 0.0f, -90.0f));
                    OfflinePopView.this.mAnimatorSet.setDuration(600L);
                    OfflinePopView.this.mAnimatorSet.setInterpolator(new DecelerateInterpolator());
                    OfflinePopView.this.mAnimatorSet.addListener(OfflinePopView.this.mShowTipsListener);
                    OfflinePopView.this.showCollapseButton();
                    OfflinePopView.this.destroyTimer();
                }
            });
            return;
        }
        this.mExpandContainer.post(new Runnable() { // from class: com.xiaopeng.montecarlo.views.OfflinePopView.5
            @Override // java.lang.Runnable
            public void run() {
                OfflinePopView.this.mClockTv.setVisibility(8);
                OfflinePopView.this.mLeftBtn.setVisibility(8);
                OfflinePopView.this.mExpandContainer.setPivotX(OfflinePopView.this.mExpandContainer.getWidth() - 20);
                OfflinePopView.this.mExpandContainer.animate().setListener(new Animator.AnimatorListener() { // from class: com.xiaopeng.montecarlo.views.OfflinePopView.5.1
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        OfflinePopView.this.mExpandContainer.animate().setListener(null);
                        OfflinePopView.this.mExpandContainer.setVisibility(8);
                        OfflinePopView.this.newRightView();
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        OfflinePopView.this.mAnimStep = 1;
                    }
                }).scaleX(0.0f).setDuration(300L).setInterpolator(new DecelerateInterpolator()).start();
                OfflinePopView.this.destroyTimer();
            }
        });
    }

    private void restoreExpand() {
        if (isExpand()) {
            return;
        }
        this.mCollapseContainer.setVisibility(8);
        this.mExpandContainer.setVisibility(0);
        this.mClockTv.setVisibility(0);
        this.mLeftBtn.setVisibility(0);
        this.mBgRecount.setVisibility(0);
        if (Utils.isPortrait()) {
            this.mExpandContainer.getLayoutParams().width = -1;
            XRelativeLayout xRelativeLayout = this.mExpandContainer;
            xRelativeLayout.setPivotX(xRelativeLayout.getWidth() - 20);
            this.mExpandContainer.setScaleX(1.0f);
            this.mCollapseContainer.setAlpha(1.0f);
            return;
        }
        this.mTitle.setVisibility(0);
        this.mExpandContainer.setScaleX(1.0f);
        this.mExpandContainer.setScaleY(1.0f);
        this.mLeftBtn.setTranslationX(0.0f);
        this.mLeftBtn.setTranslationY(0.0f);
    }

    public void hide(boolean z) {
        if (getVisibility() == 0) {
            setVisibility(8);
        }
        if (z) {
            return;
        }
        destroyTimer();
        restoreExpand();
        this.mIsAlive = false;
    }

    public void hide() {
        hide(false);
    }

    public boolean isReRoute() {
        return this.mIsOfflineReRoute;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bg_recount /* 2131296398 */:
            case R.id.container_collapse_inner /* 2131296515 */:
                preventMultClick(view);
                checkNetWork();
                NaviStatUtil.sendStatDataForOfflineView(DataLogHelper.getPageType(), TBTManager.getInstance().getPosServiceWrapper().getCurrentLocation(), BtnType.ROUTE_OFFLINEVIEW_CLICK);
                return;
            case R.id.clock_close /* 2131296494 */:
                destroyTimer();
                changeToRight();
                return;
            case R.id.expand /* 2131296632 */:
                if (this.mTitle.getVisibility() != 0) {
                    preventMultClick(view);
                    checkNetWork();
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void preventMultClick(final View view) {
        view.setClickable(false);
        view.postDelayed(new Runnable() { // from class: com.xiaopeng.montecarlo.views.-$$Lambda$OfflinePopView$3TYNqdSKSarpSgVxMivtq1Qxgfw
            @Override // java.lang.Runnable
            public final void run() {
                view.setClickable(true);
            }
        }, 500L);
    }

    private void checkNetWork() {
        MainContext mainContext;
        destroyTimer();
        if (XPNetworkManager.INSTANCE.isNetworkConnected()) {
            this.mClockTv.setText(R.string.restricted_rule_no_plate_guide_close_btn_name);
            this.mListener.reRoute();
            this.mIsOfflineReRoute = true;
            return;
        }
        changeToRight();
        if (this.mAnimStep != 0 || (mainContext = this.mMainContext) == null) {
            return;
        }
        mainContext.showPrompt(R.string.offline_pop_toast);
    }

    public boolean isExpand() {
        return this.mExpandContainer.getVisibility() == 0;
    }

    public void setMainContext(MainContext mainContext) {
        this.mMainContext = mainContext;
    }
}
