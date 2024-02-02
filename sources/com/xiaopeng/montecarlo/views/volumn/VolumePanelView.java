package com.xiaopeng.montecarlo.views.volumn;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.SeekBar;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.navresetore.NavRestoreManager;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.timer.XCountDownTimer;
import com.xiaopeng.montecarlo.util.AudioUtil;
import com.xiaopeng.montecarlo.util.Utils;
import com.xiaopeng.montecarlo.views.volumn.seekbar.VerticalSeekBar;
import com.xiaopeng.xui.widget.XImageButton;
import com.xiaopeng.xui.widget.slider.XSlider;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
/* loaded from: classes3.dex */
public class VolumePanelView implements PopupWindow.OnDismissListener, SeekBar.OnSeekBarChangeListener {
    private static final L.Tag TAG = new L.Tag("VolumePanelView");
    private static final int TIMEOUT_MILLIS = 10000;
    public static final int VOLUME_LEVEL_LARGE = 3;
    public static final int VOLUME_LEVEL_MEDIUM = 2;
    public static final int VOLUME_LEVEL_MUTE = 0;
    public static final int VOLUME_LEVEL_SMALL = 1;
    public static final float VOLUME_PERCENT_LARGE = 0.6f;
    public static final float VOLUME_PERCENT_SMALL = 0.2f;
    private View mAnchorView;
    private Context mContext;
    private Disposable mDisposable;
    private boolean mIgnoreAnchorViewEvent;
    private int mInitialCurVolume;
    private IVolumePanelEventListener mListener;
    private XImageButton mMuteBtn;
    private int mRotationAngle;
    private XCountDownTimer mTimer;
    private PopupWindow mVolumePanel;
    private View mVolumePanelLayout;
    private VerticalSeekBar mVolumeSeekBar;
    private XSlider mVolumeSliderBar;
    private boolean mIgnoreSendData = false;
    private boolean mPendingShow = false;
    private boolean mPendingMute = false;
    private int mMaxVolume = 0;
    private boolean mShow = false;
    private boolean mIsViewComplete = false;

    /* loaded from: classes3.dex */
    public interface IVolumePanelEventListener {
        void onMuteClick();

        void onPanelHide();

        void onPanelProcessChanged(int i, boolean z, boolean z2);

        void onUserTouchEnd();
    }

    /* loaded from: classes3.dex */
    public static class Builder {
        private View mAnchorView;
        private boolean mIgnoreAnchorViewEvent;
        private IVolumePanelEventListener mListener;
        private int mMaxVolumn;
        private int mRotationAngle = VerticalSeekBar.ROTATION_ANGLE_CW_270;
        private VolumePanelView mVolumePanelView;

        public Builder setMaxVolume(int i) {
            this.mMaxVolumn = i;
            return this;
        }

        public Builder setAnchorView(View view) {
            this.mAnchorView = view;
            return this;
        }

        public Builder setIgnoreAnchorViewTouchEvent(boolean z) {
            this.mIgnoreAnchorViewEvent = z;
            return this;
        }

        public Builder setOnViewChangedListener(IVolumePanelEventListener iVolumePanelEventListener) {
            this.mListener = iVolumePanelEventListener;
            return this;
        }

        public Builder setRotationAngle(int i) {
            this.mRotationAngle = i;
            return this;
        }

        public VolumePanelView build(Context context) {
            this.mVolumePanelView = new VolumePanelView();
            this.mVolumePanelView.setAnchorView(this.mAnchorView);
            this.mVolumePanelView.setOnViewChangedListener(this.mListener);
            this.mVolumePanelView.setIgnoreAnchorViewTouchEvent(this.mIgnoreAnchorViewEvent);
            this.mVolumePanelView.setMaxVolume(this.mMaxVolumn);
            this.mVolumePanelView.setRotationAngle(this.mRotationAngle);
            this.mVolumePanelView.setupInThread(context);
            return this.mVolumePanelView;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ClickableViewAccessibility"})
    public void setUp(Context context) {
        if (this.mVolumePanelLayout == null) {
            this.mVolumePanelLayout = LayoutInflater.from(context).inflate(R.layout.layout_volume_panel, (ViewGroup) null);
            this.mMuteBtn = (XImageButton) this.mVolumePanelLayout.findViewById(R.id.btn_volume_mute);
            XImageButton xImageButton = this.mMuteBtn;
            if (xImageButton != null) {
                xImageButton.setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.montecarlo.views.volumn.-$$Lambda$VolumePanelView$3Vnx4YJexgImAAioqKyCCxi3rxU
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        VolumePanelView.this.lambda$setUp$0$VolumePanelView(view);
                    }
                });
            }
        }
        if (this.mVolumePanel == null) {
            if (this.mRotationAngle == 0) {
                this.mVolumePanel = new PopupWindow(ContextUtils.getDimensionPixelSize(R.dimen.layout_map_volume_panel_horizontal_width), ContextUtils.getDimensionPixelSize(R.dimen.layout_map_volume_panel_horizontal_height));
                this.mVolumePanel.setAnimationStyle(R.style.pop_right_anim);
            } else {
                this.mVolumePanel = new PopupWindow(ContextUtils.getDimensionPixelSize(R.dimen.layout_map_volume_panel_vertical_width), ContextUtils.getDimensionPixelSize(R.dimen.layout_map_volume_panel_vertical_height));
                this.mVolumePanel.setAnimationStyle(R.style.pop_bottom_anim);
            }
            this.mVolumePanel.setOutsideTouchable(true);
            this.mVolumePanel.setTouchInterceptor(new View.OnTouchListener() { // from class: com.xiaopeng.montecarlo.views.volumn.VolumePanelView.1
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 4) {
                        if (VolumePanelView.this.isTouchOnAnchorView(motionEvent) || VolumePanelView.this.mListener == null) {
                            return true;
                        }
                        VolumePanelView.this.mListener.onPanelHide();
                        return true;
                    }
                    return false;
                }
            });
            this.mVolumePanel.setFocusable(false);
            this.mVolumePanel.setOnDismissListener(this);
        }
        if (this.mVolumePanel.getContentView() == null) {
            this.mVolumePanel.setContentView(this.mVolumePanelLayout);
        }
        if (Utils.isPortrait()) {
            if (this.mVolumeSliderBar == null) {
                this.mVolumeSliderBar = (XSlider) this.mVolumePanelLayout.findViewById(R.id.sliderBar);
                this.mVolumeSliderBar.setEndIndex(this.mMaxVolume);
                ((FrameLayout) this.mVolumePanelLayout.findViewById(R.id.touchOut)).setOnTouchListener(new View.OnTouchListener() { // from class: com.xiaopeng.montecarlo.views.volumn.-$$Lambda$VolumePanelView$0yENwPb37I6Uo6yN1xRXo0JzjBE
                    @Override // android.view.View.OnTouchListener
                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        return VolumePanelView.this.lambda$setUp$1$VolumePanelView(view, motionEvent);
                    }
                });
                this.mVolumeSliderBar.setProgressChangeListener(new XSlider.ProgressChangeListener() { // from class: com.xiaopeng.montecarlo.views.volumn.-$$Lambda$VolumePanelView$D-qEIlVav1zh_IcLeVqh5pYehI0
                    @Override // com.xiaopeng.xui.widget.slider.XSlider.ProgressChangeListener
                    public final void onProgressChanged(XSlider xSlider, float f, String str, boolean z) {
                        VolumePanelView.this.lambda$setUp$2$VolumePanelView(xSlider, f, str, z);
                    }
                });
                this.mVolumeSliderBar.setSliderProgressListener(new XSlider.SliderProgressListener() { // from class: com.xiaopeng.montecarlo.views.volumn.VolumePanelView.2
                    @Override // com.xiaopeng.xui.widget.slider.XSlider.SliderProgressListener
                    public void onProgressChanged(XSlider xSlider, float f, String str) {
                        VolumePanelView.this.onProgressChanged(null, (int) f, true);
                    }

                    @Override // com.xiaopeng.xui.widget.slider.XSlider.SliderProgressListener
                    public void onStartTrackingTouch(XSlider xSlider) {
                        VolumePanelView.this.onStartTrackingTouch(null);
                    }

                    @Override // com.xiaopeng.xui.widget.slider.XSlider.SliderProgressListener
                    public void onStopTrackingTouch(XSlider xSlider) {
                        VolumePanelView.this.onStopTrackingTouch(null);
                    }
                });
            }
            L.Tag tag = TAG;
            L.i(tag, "mVolumeSliderBar w:" + this.mVolumeSliderBar.getWidth() + ", mVolumePanel w:" + this.mVolumePanel.getWidth() + ", mVolumePanelLayout w:" + this.mVolumePanelLayout.getWidth());
        } else {
            if (this.mVolumeSeekBar == null) {
                this.mVolumeSeekBar = (VerticalSeekBar) this.mVolumePanelLayout.findViewById(R.id.verticalSeekBar);
                this.mVolumeSeekBar.setMax(this.mMaxVolume);
                this.mVolumeSeekBar.setRotationAngle(this.mRotationAngle);
                this.mVolumeSeekBar.setOnSeekBarChangeListener(this);
            }
            L.Tag tag2 = TAG;
            L.i(tag2, "mVolumeSeekBar w:" + this.mVolumeSeekBar.getWidth() + ", mVolumePanel w:" + this.mVolumePanel.getWidth() + ", mVolumePanelLayout w:" + this.mVolumePanelLayout.getWidth());
        }
        initTimer();
    }

    public /* synthetic */ void lambda$setUp$0$VolumePanelView(View view) {
        IVolumePanelEventListener iVolumePanelEventListener = this.mListener;
        if (iVolumePanelEventListener != null) {
            iVolumePanelEventListener.onMuteClick();
        }
    }

    public /* synthetic */ boolean lambda$setUp$1$VolumePanelView(View view, MotionEvent motionEvent) {
        this.mVolumeSliderBar.onTouchEvent(motionEvent);
        return true;
    }

    public /* synthetic */ void lambda$setUp$2$VolumePanelView(XSlider xSlider, float f, String str, boolean z) {
        onProgressChanged(null, (int) f, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setupInThread(final Context context) {
        if (L.ENABLE) {
            L.d(TAG, "setupInThread");
        }
        this.mContext = context;
        this.mDisposable = Single.create(new SingleOnSubscribe<Boolean>() { // from class: com.xiaopeng.montecarlo.views.volumn.VolumePanelView.4
            @Override // io.reactivex.SingleOnSubscribe
            public void subscribe(SingleEmitter<Boolean> singleEmitter) throws Exception {
                VolumePanelView.this.setUp(context);
                singleEmitter.onSuccess(true);
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<Boolean>() { // from class: com.xiaopeng.montecarlo.views.volumn.VolumePanelView.3
            @Override // io.reactivex.functions.Consumer
            public void accept(Boolean bool) throws Exception {
                VolumePanelView.this.mIsViewComplete = bool.booleanValue();
                if (VolumePanelView.this.mPendingShow) {
                    VolumePanelView.this.show();
                }
            }
        });
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.mTimer.pause();
        this.mShow = false;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        L.Tag tag = TAG;
        L.i(tag, "onVolumeChanged progress = " + i + "fromUser = " + z + "listener" + this.mListener);
        IVolumePanelEventListener iVolumePanelEventListener = this.mListener;
        if (iVolumePanelEventListener != null) {
            iVolumePanelEventListener.onPanelProcessChanged(i, z, this.mIgnoreSendData);
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        XCountDownTimer xCountDownTimer = this.mTimer;
        if (xCountDownTimer != null) {
            xCountDownTimer.pause();
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        XCountDownTimer xCountDownTimer = this.mTimer;
        if (xCountDownTimer != null) {
            xCountDownTimer.pause();
            this.mTimer.reset();
        }
        IVolumePanelEventListener iVolumePanelEventListener = this.mListener;
        if (iVolumePanelEventListener != null) {
            iVolumePanelEventListener.onUserTouchEnd();
        }
    }

    private void initTimer() {
        this.mTimer = new XCountDownTimer(NavRestoreManager.WAKELOCK_TIMEOUT_10SEC, new XCountDownTimer.ITimerCallback() { // from class: com.xiaopeng.montecarlo.views.volumn.VolumePanelView.5
            @Override // com.xiaopeng.montecarlo.root.util.timer.XCountDownTimer.ITimerCallback
            public void onTick(long j) {
            }

            @Override // com.xiaopeng.montecarlo.root.util.timer.XCountDownTimer.ITimerCallback
            public void onTimeOut() {
                if (L.ENABLE) {
                    L.d(VolumePanelView.TAG, "onTimeOut dismiss volume panel");
                }
                if (VolumePanelView.this.mListener != null) {
                    VolumePanelView.this.mListener.onPanelHide();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAnchorView(View view) {
        this.mAnchorView = view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMaxVolume(int i) {
        this.mMaxVolume = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIgnoreAnchorViewTouchEvent(boolean z) {
        this.mIgnoreAnchorViewEvent = z;
    }

    public void setRotationAngle(int i) {
        this.mRotationAngle = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOnViewChangedListener(IVolumePanelEventListener iVolumePanelEventListener) {
        this.mListener = iVolumePanelEventListener;
    }

    public void toggleMute(boolean z) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "toggleMute " + z + " ,volume = " + AudioUtil.getInstance().getVolume());
        }
        if (Utils.isPortrait()) {
            if (this.mVolumeSliderBar == null || this.mMuteBtn == null) {
                return;
            }
            int volume = z ? 0 : AudioUtil.getInstance().getVolume();
            if (volume == 0 || volume != ((int) this.mVolumeSliderBar.getIndicatorValue())) {
                this.mVolumeSliderBar.setCurrentIndex(volume);
            }
            this.mMuteBtn.setImageResource(z ? R.drawable.vector_ic_mid_volume_mute_on : R.drawable.vector_ic_mid_volume_mute_off);
            return;
        }
        VerticalSeekBar verticalSeekBar = this.mVolumeSeekBar;
        if (verticalSeekBar == null || verticalSeekBar.isMute() == z) {
            return;
        }
        this.mVolumeSeekBar.toggleMute(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void show() {
        if (L.ENABLE) {
            L.d(TAG, "show private");
        }
        show(this.mInitialCurVolume, this.mPendingMute);
    }

    public void show(final int i, final boolean z) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "onVolumeChanged__show " + i + "__" + z);
        }
        if (this.mContext == null) {
            return;
        }
        if (!this.mIsViewComplete) {
            this.mPendingShow = true;
            this.mPendingMute = z;
            this.mInitialCurVolume = i;
            return;
        }
        if (this.mVolumePanel.isShowing()) {
            update(i, true, z);
        } else {
            this.mVolumePanelLayout.post(new Runnable() { // from class: com.xiaopeng.montecarlo.views.volumn.-$$Lambda$VolumePanelView$EkbuD6IVW5VnI8kiEgT-m_pqTLk
                @Override // java.lang.Runnable
                public final void run() {
                    VolumePanelView.this.lambda$show$3$VolumePanelView(i, z);
                }
            });
            if (this.mRotationAngle == 0) {
                this.mVolumePanel.showAsDropDown(this.mAnchorView, this.mAnchorView.getWidth(), ((-this.mAnchorView.getHeight()) / 2) - (this.mVolumePanel.getHeight() / 2));
            } else {
                this.mVolumePanel.showAsDropDown(this.mAnchorView, 0, ContextUtils.getDimensionPixelSize(R.dimen.layout_map_volume_pannel_margin_bottom), 83);
            }
            L.Tag tag2 = TAG;
            L.i(tag2, "show pos:" + this.mAnchorView.getLeft());
            this.mTimer.start();
        }
        this.mShow = true;
    }

    public /* synthetic */ void lambda$show$3$VolumePanelView(int i, boolean z) {
        update(i, true, z);
    }

    public void hide() {
        if (L.ENABLE) {
            L.d(TAG, "hide");
        }
        Disposable disposable = this.mDisposable;
        if (disposable != null && !disposable.isDisposed()) {
            this.mDisposable.dispose();
            this.mDisposable = null;
        }
        PopupWindow popupWindow = this.mVolumePanel;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
        this.mShow = false;
        this.mPendingShow = false;
    }

    public boolean isShowing() {
        return this.mShow;
    }

    public void update(int i, boolean z, boolean z2) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "onVolumeChanged__update_volume = " + i + "____" + z2);
        }
        this.mPendingMute = z2;
        this.mIgnoreSendData = z;
        if (Utils.isPortrait()) {
            XSlider xSlider = this.mVolumeSliderBar;
            if (xSlider != null && (i == 0 || i != ((int) xSlider.getIndicatorValue()))) {
                this.mVolumeSliderBar.setCurrentIndex(i);
            }
        } else {
            VerticalSeekBar verticalSeekBar = this.mVolumeSeekBar;
            if (verticalSeekBar != null) {
                verticalSeekBar.setProgress(i);
            }
        }
        toggleMute(z2);
        this.mTimer.pause();
        this.mTimer.reset();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isTouchOnAnchorView(MotionEvent motionEvent) {
        if (this.mIgnoreAnchorViewEvent) {
            float rawX = motionEvent.getRawX();
            float rawY = motionEvent.getRawY();
            int[] iArr = new int[2];
            this.mAnchorView.getLocationOnScreen(iArr);
            float f = iArr[0];
            float f2 = iArr[1];
            if (L.ENABLE) {
                L.d(TAG, "MotionEvent, rawX = " + motionEvent.getRawX() + "rawY = " + motionEvent.getRawY() + "viewX + mAnchorView.getMeasuredWidth() = " + (this.mAnchorView.getMeasuredWidth() + f) + "viewY + mAnchorView.getMeasuredHeight() = " + (this.mAnchorView.getMeasuredWidth() + f2));
            }
            return rawX >= f && rawX <= f + ((float) this.mAnchorView.getMeasuredWidth()) && rawY >= f2 && rawY <= f2 + ((float) this.mAnchorView.getMeasuredHeight());
        }
        return false;
    }
}
