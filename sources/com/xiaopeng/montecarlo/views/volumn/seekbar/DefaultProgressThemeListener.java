package com.xiaopeng.montecarlo.views.volumn.seekbar;

import android.graphics.drawable.Drawable;
import androidx.annotation.DrawableRes;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.XpThemeSwitchReceiver;
import com.xiaopeng.montecarlo.root.theme.ThemeType;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.util.ThemeWatcherUtil;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
/* loaded from: classes3.dex */
public class DefaultProgressThemeListener implements XpThemeSwitchReceiver.ThemeSwitchListener {
    @DrawableRes
    public static final int S_PROGRESS_DRAWABLE = 2131231029;
    private static final L.Tag TAG = new L.Tag("DefaultProgressThemeListener");
    private ThemeType mCurrentThemeType = ThemeType.DEFAULT_THEME_TYPE;
    private Drawable mDayBgDrawable;
    private Disposable mDisposable;
    private ILoadNewDrawableListener mILoadNewDrawableListener;
    private Drawable mNightBgDrawable;

    /* loaded from: classes3.dex */
    public interface ILoadNewDrawableListener {
        void loadNewDrawable(Drawable drawable);
    }

    public DefaultProgressThemeListener(ILoadNewDrawableListener iLoadNewDrawableListener) {
        this.mILoadNewDrawableListener = iLoadNewDrawableListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cacheDrawable(Drawable drawable) {
        if (this.mCurrentThemeType.isDayMode()) {
            this.mDayBgDrawable = drawable;
        } else {
            this.mNightBgDrawable = drawable;
        }
    }

    private void checkAndLoadDrawable(Drawable drawable) {
        if (drawable == null) {
            this.mDisposable = Single.create(new SingleOnSubscribe<Drawable>() { // from class: com.xiaopeng.montecarlo.views.volumn.seekbar.DefaultProgressThemeListener.2
                @Override // io.reactivex.SingleOnSubscribe
                public void subscribe(SingleEmitter<Drawable> singleEmitter) throws Exception {
                    Drawable drawable2 = ThemeWatcherUtil.getDrawable(R.drawable.layer_map_blue_dot_seekbar);
                    DefaultProgressThemeListener.this.cacheDrawable(drawable2);
                    if (drawable2 != null) {
                        singleEmitter.onSuccess(drawable2);
                    }
                }
            }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<Drawable>() { // from class: com.xiaopeng.montecarlo.views.volumn.seekbar.DefaultProgressThemeListener.1
                @Override // io.reactivex.functions.Consumer
                public void accept(Drawable drawable2) throws Exception {
                    if (DefaultProgressThemeListener.this.mILoadNewDrawableListener != null) {
                        DefaultProgressThemeListener.this.mILoadNewDrawableListener.loadNewDrawable(drawable2);
                    }
                }
            });
        } else {
            this.mILoadNewDrawableListener.loadNewDrawable(drawable);
        }
    }

    public void disposeLoadDrawable() {
        Disposable disposable = this.mDisposable;
        if (disposable == null || disposable.isDisposed()) {
            return;
        }
        this.mDisposable.dispose();
        this.mDisposable = null;
    }

    public void updateBg() {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "updateBg" + ThemeWatcherUtil.getCurrentTheme());
        }
        if (this.mCurrentThemeType != ThemeWatcherUtil.getCurrentTheme()) {
            this.mCurrentThemeType = ThemeWatcherUtil.getCurrentTheme();
            if (this.mCurrentThemeType.isDayMode()) {
                checkAndLoadDrawable(this.mDayBgDrawable);
            } else {
                checkAndLoadDrawable(this.mNightBgDrawable);
            }
        }
    }

    @Override // com.xiaopeng.montecarlo.XpThemeSwitchReceiver.ThemeSwitchListener
    public void onThemeSwitch(int i) {
        updateBg();
    }
}
