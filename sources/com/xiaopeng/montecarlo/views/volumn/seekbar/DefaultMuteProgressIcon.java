package com.xiaopeng.montecarlo.views.volumn.seekbar;

import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.LevelListDrawable;
import android.widget.AbsSeekBar;
import com.xiaopeng.montecarlo.root.util.L;
/* loaded from: classes3.dex */
public class DefaultMuteProgressIcon {
    public static final int S_MUTE_ICON_LEVEL = 10001;
    private static final L.Tag TAG = new L.Tag("DefaultMuteProgressIcon");
    private AbsSeekBar mAbsSeekBar;
    private boolean mIsMute = false;

    public DefaultMuteProgressIcon(AbsSeekBar absSeekBar) {
        if (absSeekBar == null) {
            return;
        }
        this.mAbsSeekBar = absSeekBar;
    }

    public boolean isMute() {
        return this.mAbsSeekBar != null && this.mIsMute;
    }

    public void toggleMuteLevelShow(boolean z) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "toggleMu-__" + z);
        }
        AbsSeekBar absSeekBar = this.mAbsSeekBar;
        if (absSeekBar == null) {
            return;
        }
        this.mIsMute = z;
        int progress = z ? 10001 : absSeekBar.getProgress() * 100;
        Drawable progressDrawable = this.mAbsSeekBar.getProgressDrawable();
        if (progressDrawable != null && (progressDrawable instanceof LayerDrawable)) {
            LayerDrawable layerDrawable = (LayerDrawable) progressDrawable;
            Drawable findDrawableByLayerId = layerDrawable.findDrawableByLayerId(16908288);
            Drawable findDrawableByLayerId2 = layerDrawable.findDrawableByLayerId(16908301);
            if (findDrawableByLayerId != null) {
                findDrawableByLayerId.setLevel(progress);
            }
            if (findDrawableByLayerId2 != null && (findDrawableByLayerId2 instanceof ClipDrawable)) {
                ((ClipDrawable) findDrawableByLayerId2).getDrawable().setLevel(progress);
            }
        }
        Drawable thumb = this.mAbsSeekBar.getThumb();
        if (thumb != null && (thumb instanceof LevelListDrawable)) {
            thumb.setLevel(progress);
        }
    }

    /* loaded from: classes3.dex */
    public static final class Builder {
        AbsSeekBar mAbsSeekBar;

        public Builder setProgressDrawableTarget(AbsSeekBar absSeekBar) {
            this.mAbsSeekBar = absSeekBar;
            return this;
        }

        public DefaultMuteProgressIcon build() {
            return new DefaultMuteProgressIcon(this.mAbsSeekBar);
        }
    }
}
