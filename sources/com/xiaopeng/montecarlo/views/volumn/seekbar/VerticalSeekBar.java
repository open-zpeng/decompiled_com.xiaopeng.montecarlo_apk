package com.xiaopeng.montecarlo.views.volumn.seekbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatSeekBar;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.util.ThemeWatcherUtil;
import com.xiaopeng.montecarlo.views.volumn.seekbar.DefaultMuteProgressIcon;
import com.xiaopeng.montecarlo.views.volumn.seekbar.DefaultProgressThemeListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes3.dex */
public class VerticalSeekBar extends AppCompatSeekBar implements DefaultProgressThemeListener.ILoadNewDrawableListener {
    public static final int ROTATION_ANGLE_CW_0 = 0;
    public static final int ROTATION_ANGLE_CW_270 = 270;
    public static final int ROTATION_ANGLE_CW_90 = 90;
    private static final L.Tag TAG = new L.Tag("VerticalSeekBar");
    private DefaultMuteProgressIcon mDefaultMuteProgressIcon;
    private Method mMethodSetProgressFromUser;
    private DefaultProgressThemeListener mProgressThemeListener;
    private int mRotationAngle;

    private static boolean isValidRotationAngle(int i) {
        return i == 90 || i == 270 || i == 0;
    }

    public VerticalSeekBar(Context context) {
        this(context, null);
    }

    public VerticalSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VerticalSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, 0);
        this.mRotationAngle = ROTATION_ANGLE_CW_270;
        initialize(context, attributeSet, 0, 0);
    }

    private void initialize(Context context, AttributeSet attributeSet, int i, int i2) {
        setLayoutDirection(0);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.VerticalSeekBar, i, i2);
            int integer = obtainStyledAttributes.getInteger(0, 0);
            if (isValidRotationAngle(integer)) {
                this.mRotationAngle = integer;
            }
            obtainStyledAttributes.recycle();
            this.mDefaultMuteProgressIcon = new DefaultMuteProgressIcon.Builder().setProgressDrawableTarget(this).build();
            this.mProgressThemeListener = new DefaultProgressThemeListener(this);
            setThumbOffset(0);
        }
    }

    @Override // android.widget.AbsSeekBar, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return onTouchEventUseViewRotation(motionEvent);
    }

    private boolean onTouchEventUseViewRotation(MotionEvent motionEvent) {
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        if (onTouchEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                attemptClaimDrag(true);
            } else if (action == 1 || action == 3) {
                attemptClaimDrag(false);
            }
        }
        return onTouchEvent;
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (L.ENABLE) {
            L.d(TAG, "onAttachedToWindow");
        }
        ThemeWatcherUtil.addXpThemeSwitchListener(this.mProgressThemeListener);
        this.mProgressThemeListener.updateBg();
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (L.ENABLE) {
            L.d(TAG, "onDetachedFromWindow");
        }
        this.mProgressThemeListener.disposeLoadDrawable();
        ThemeWatcherUtil.removeXpThemeListener(this.mProgressThemeListener);
    }

    private void attemptClaimDrag(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001a, code lost:
        if (r4.mRotationAngle == 270) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x001c, code lost:
        r1 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x001e, code lost:
        r1 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x001f, code lost:
        r0 = r1;
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0013, code lost:
        if (r4.mRotationAngle == 90) goto L19;
     */
    @Override // android.widget.AbsSeekBar, android.view.View, android.view.KeyEvent.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onKeyDown(int r5, android.view.KeyEvent r6) {
        /*
            r4 = this;
            boolean r0 = r4.isEnabled()
            if (r0 == 0) goto L39
            r0 = -1
            r1 = 0
            r2 = 1
            switch(r5) {
                case 19: goto L16;
                case 20: goto Lf;
                case 21: goto Le;
                case 22: goto Le;
                default: goto Lc;
            }
        Lc:
            r0 = r1
            goto L21
        Le:
            return r1
        Lf:
            int r1 = r4.mRotationAngle
            r3 = 90
            if (r1 != r3) goto L1e
            goto L1c
        L16:
            int r1 = r4.mRotationAngle
            r3 = 270(0x10e, float:3.78E-43)
            if (r1 != r3) goto L1e
        L1c:
            r1 = r2
            goto L1f
        L1e:
            r1 = r0
        L1f:
            r0 = r1
            r1 = r2
        L21:
            if (r1 == 0) goto L39
            int r5 = r4.getKeyProgressIncrement()
            int r6 = r4.getProgress()
            int r0 = r0 * r5
            int r6 = r6 + r0
            if (r6 < 0) goto L38
            int r5 = r4.getMax()
            if (r6 > r5) goto L38
            r4.setProgressFromUsers(r6, r2)
        L38:
            return r2
        L39:
            boolean r5 = super.onKeyDown(r5, r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.views.volumn.seekbar.VerticalSeekBar.onKeyDown(int, android.view.KeyEvent):boolean");
    }

    @Override // android.widget.ProgressBar
    public synchronized void setProgress(int i) {
        super.setProgress(i);
    }

    public boolean isMute() {
        DefaultMuteProgressIcon defaultMuteProgressIcon = this.mDefaultMuteProgressIcon;
        return defaultMuteProgressIcon != null && defaultMuteProgressIcon.isMute();
    }

    public void toggleMute(boolean z) {
        DefaultMuteProgressIcon defaultMuteProgressIcon = this.mDefaultMuteProgressIcon;
        if (defaultMuteProgressIcon != null) {
            defaultMuteProgressIcon.toggleMuteLevelShow(z);
        }
    }

    private synchronized void setProgressFromUsers(int i, boolean z) {
        if (this.mMethodSetProgressFromUser == null) {
            try {
                Method declaredMethod = ProgressBar.class.getDeclaredMethod("setProgressInternal", Integer.TYPE, Boolean.TYPE, Boolean.TYPE);
                declaredMethod.setAccessible(true);
                this.mMethodSetProgressFromUser = declaredMethod;
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
        if (this.mMethodSetProgressFromUser != null) {
            try {
                this.mMethodSetProgressFromUser.invoke(this, Integer.valueOf(i), Boolean.valueOf(z), false);
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e2) {
                e2.printStackTrace();
            }
        } else {
            super.setProgress(i);
        }
        refreshThumb();
    }

    public int getRotationAngle() {
        return this.mRotationAngle;
    }

    public void setRotationAngle(int i) {
        this.mRotationAngle = i;
    }

    private void refreshThumb() {
        onSizeChanged(super.getWidth(), super.getHeight(), 0, 0);
    }

    @Override // com.xiaopeng.montecarlo.views.volumn.seekbar.DefaultProgressThemeListener.ILoadNewDrawableListener
    public void loadNewDrawable(Drawable drawable) {
        setProgressDrawable(drawable);
        if (isMute()) {
            this.mDefaultMuteProgressIcon.toggleMuteLevelShow(true);
        }
    }
}
