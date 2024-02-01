package com.xiaopeng.montecarlo.scenes.routescene;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.views.font.XpFontTagHandler;
import com.xiaopeng.xui.widget.XTextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class CountDownModel {
    private static final int ROUTE_COUNTDOWN_TO_GUIDE_MAX_PROGRESS = 15;
    public static final int ROUTE_COUNTDOWN_TO_GUIDE_MAX_PROGRESS_AI_MSG = 170;
    public static final int ROUTE_COUNTDOWN_TO_GUIDE_MAX_PROGRESS_NAV = 300;
    private static final int ROUTE_COUNTDOWN_TO_GUIDE_TIME_SPAN = 1000;
    private static final int ROUTE_COUNTDOWN_TO_GUIDE_TIME_UPDATE = 50;
    private static final L.Tag TAG = new L.Tag("CountDownModel");
    private GuideCountDownRunnable mGuideCountDownRunnable;
    private boolean mMsgFromAI;
    private int mMaxProcess = 300;
    private final XpFontTagHandler mXpFontTagHandler = new XpFontTagHandler(ContextUtils.getContext().getResources().getDisplayMetrics());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface CountDownCallback {
        void onEnd();

        void onStart();

        void onViewAdded();

        void onViewRemoved();
    }

    public void setMsgFromAI(boolean z) {
        this.mMsgFromAI = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void startCountDown(@NonNull ViewGroup viewGroup, boolean z, CountDownCallback countDownCallback) {
        XTextView xTextView;
        if (L.ENABLE) {
            L.d(TAG, "countDownModel startCountDown");
        }
        cancelCountDown(viewGroup);
        if (viewGroup.isAttachedToWindow()) {
            if (this.mMsgFromAI) {
                xTextView = (XTextView) viewGroup.findViewById(R.id.btn_cancel_route);
            } else {
                xTextView = (XTextView) viewGroup.findViewById(R.id.tv_start_navi);
            }
            GuideCountDownRunnable guideCountDownRunnable = this.mGuideCountDownRunnable;
            if (guideCountDownRunnable == null) {
                this.mGuideCountDownRunnable = new GuideCountDownRunnable(viewGroup);
            } else {
                guideCountDownRunnable.resume(z);
            }
            this.mGuideCountDownRunnable.setCountDownCallback(countDownCallback);
            if (xTextView != null) {
                xTextView.post(this.mGuideCountDownRunnable);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void stopCountDown(@NonNull ViewGroup viewGroup, boolean z) {
        XTextView xTextView;
        XTextView xTextView2;
        if (L.ENABLE) {
            L.d(TAG, "countDownModel stopCountDown");
        }
        if (this.mMsgFromAI) {
            if (!z && (xTextView2 = (XTextView) viewGroup.findViewById(R.id.btn_cancel_route)) != null) {
                xTextView2.setText(ContextUtils.getString(R.string.route_exit_text));
            }
            GuideCountDownRunnable guideCountDownRunnable = this.mGuideCountDownRunnable;
            if (guideCountDownRunnable != null) {
                guideCountDownRunnable.stop();
                return;
            }
            return;
        }
        if (!z && (xTextView = (XTextView) viewGroup.findViewById(R.id.tv_start_navi)) != null) {
            xTextView.setText(ContextUtils.getString(R.string.go_here));
        }
        GuideCountDownRunnable guideCountDownRunnable2 = this.mGuideCountDownRunnable;
        if (guideCountDownRunnable2 != null) {
            guideCountDownRunnable2.stop();
        }
    }

    void cancelCountDown(@NonNull ViewGroup viewGroup) {
        GuideCountDownRunnable guideCountDownRunnable = this.mGuideCountDownRunnable;
        if (guideCountDownRunnable != null) {
            guideCountDownRunnable.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isRun() {
        GuideCountDownRunnable guideCountDownRunnable = this.mGuideCountDownRunnable;
        return guideCountDownRunnable != null && guideCountDownRunnable.isRun();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getRouteDownCountRemain() {
        GuideCountDownRunnable guideCountDownRunnable = this.mGuideCountDownRunnable;
        return 15 - (guideCountDownRunnable != null ? guideCountDownRunnable.mDownCount : 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class GuideCountDownRunnable implements Runnable {
        private CountDownCallback mCountDownCallback;
        private final ViewGroup mDependView;
        private long mStartTime = 0;
        private long mEndTime = 0;
        private long mLeftTime = 0;
        private int mDownCount = 0;
        private boolean mStopped = false;
        private boolean mIsEnd = false;

        GuideCountDownRunnable(@NonNull ViewGroup viewGroup) {
            this.mDependView = viewGroup;
        }

        void setCountDownCallback(CountDownCallback countDownCallback) {
            this.mCountDownCallback = countDownCallback;
        }

        boolean isRun() {
            return (this.mStopped || this.mIsEnd) ? false : true;
        }

        void stop() {
            this.mStopped = true;
            this.mLeftTime = this.mEndTime - System.currentTimeMillis();
            if (L.ENABLE) {
                L.d(CountDownModel.TAG, "countDownModel stop");
            }
        }

        void cancel() {
            ViewGroup viewGroup = this.mDependView;
            if (viewGroup != null) {
                viewGroup.removeCallbacks(this);
            }
        }

        void resume(boolean z) {
            if (z) {
                if (0 != this.mLeftTime) {
                    this.mEndTime = System.currentTimeMillis() + (Math.round((((float) this.mLeftTime) * 1.0f) / 1000.0f) * 1000);
                }
            } else {
                this.mEndTime = System.currentTimeMillis() + 15000;
            }
            this.mStopped = false;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mStopped) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (this.mStartTime == 0) {
                this.mStartTime = currentTimeMillis;
                this.mEndTime = this.mStartTime + 15000;
            }
            CountDownCallback countDownCallback = this.mCountDownCallback;
            if (countDownCallback != null) {
                if (this.mDownCount == 0) {
                    countDownCallback.onStart();
                } else if (currentTimeMillis >= this.mEndTime) {
                    countDownCallback.onEnd();
                    this.mIsEnd = true;
                    this.mStartTime = 0L;
                    return;
                }
            }
            if (CountDownModel.this.mMsgFromAI) {
                ((XTextView) this.mDependView.findViewById(R.id.btn_cancel_route)).setText(ContextUtils.getString(R.string.route_cancel, Integer.valueOf(Math.round((((float) (this.mEndTime - currentTimeMillis)) * 1.0f) / 1000.0f))));
            } else {
                ((XTextView) this.mDependView.findViewById(R.id.tv_start_navi)).setText(ContextUtils.getString(R.string.tips_go_here, Integer.valueOf(Math.round((((float) (this.mEndTime - currentTimeMillis)) * 1.0f) / 1000.0f))));
            }
            this.mDependView.postDelayed(this, 1000L);
            this.mDownCount++;
        }
    }
}
