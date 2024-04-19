package com.xiaopeng.montecarlo.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.XpThemeSwitchReceiver;
import com.xiaopeng.montecarlo.bridge.StatusConst;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.timer.XCountDownTimer;
import com.xiaopeng.montecarlo.scenes.restrictscene.RestrictUtils;
import com.xiaopeng.montecarlo.stat.RestrictStatUtil;
import com.xiaopeng.montecarlo.util.ThemeWatcherUtil;
import com.xiaopeng.xui.widget.XRelativeLayout;
import com.xiaopeng.xui.widget.XTextView;
/* loaded from: classes3.dex */
public class RestrictPopView extends XRelativeLayout implements View.OnClickListener {
    private static final int MAX_TIME = 15;
    private XTextView mActionBtn;
    private XTextView mClockTv;
    private boolean mIsAlive;
    private IRestrictPopActionListener mListener;
    private int mMode;
    private View mRootView;
    private StatusConst.Mode mSceneMode;
    private long mStartTime;
    private XpThemeSwitchReceiver.ThemeSwitchListener mThemeSwitchListener;
    private XCountDownTimer mTimer;
    private String mTitle;
    private String mTitleCity;
    private XTextView mTitleTv;
    private XTextView mTitleTvTip;
    private boolean mUseBgImage;
    private IRestrictVbChangedListener mVbChangeListener;

    /* loaded from: classes3.dex */
    public interface IRestrictPopActionListener {
        void openRestrictSwitch();

        void setPlateLicense();

        void showDetailRestrict();
    }

    /* loaded from: classes3.dex */
    public interface IRestrictVbChangedListener {
        void onRestrictViewVisibilityChanged(int i);
    }

    public RestrictPopView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTitleCity = "";
        this.mMode = -1;
        this.mTitle = "";
        this.mStartTime = 0L;
        this.mIsAlive = false;
        this.mThemeSwitchListener = new XpThemeSwitchReceiver.ThemeSwitchListener() { // from class: com.xiaopeng.montecarlo.views.RestrictPopView.1
            @Override // com.xiaopeng.montecarlo.XpThemeSwitchReceiver.ThemeSwitchListener
            public void onThemeSwitch(int i) {
                RestrictPopView.this.updateTheme();
            }
        };
        this.mTimer = new XCountDownTimer(15000L, new XCountDownTimer.ITimerCallback() { // from class: com.xiaopeng.montecarlo.views.RestrictPopView.2
            @Override // com.xiaopeng.montecarlo.root.util.timer.XCountDownTimer.ITimerCallback
            public void onTick(long j) {
                RestrictPopView.this.setCloseTv(j);
            }

            @Override // com.xiaopeng.montecarlo.root.util.timer.XCountDownTimer.ITimerCallback
            public void onTimeOut() {
                RestrictPopView.this.hide(true);
            }
        });
    }

    public void setSceneMode(StatusConst.Mode mode) {
        this.mSceneMode = mode;
    }

    public void setUseBgImage(boolean z) {
        this.mUseBgImage = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTheme() {
        XTextView xTextView = this.mActionBtn;
        if (xTextView != null) {
            xTextView.setBackground(ThemeWatcherUtil.getDrawable(R.drawable.layer_bg_restrict_detail_btn));
        }
        int i = this.mMode;
        if (i < 1 || i > 4) {
            return;
        }
        Drawable drawable = ThemeWatcherUtil.getDrawable(R.drawable.layer_bg_restrict_pop_view_content);
        int color = ThemeWatcherUtil.getColor(R.color.colour_palette_orange);
        int color2 = ThemeWatcherUtil.getColor(R.color.colour_palette_stroke_orange);
        if (this.mMode == 3) {
            drawable = ThemeWatcherUtil.getDrawable(R.drawable.layer_bg_restrict_pop_view_content);
            color = ThemeWatcherUtil.getColor(R.color.colour_palette_normal);
            color2 = ThemeWatcherUtil.getColor(R.color.colour_palette_stroke_normal);
        }
        setBackground(drawable);
        this.mActionBtn.setTextColor(color);
        if (this.mUseBgImage) {
            return;
        }
        setClockTvBackground(color, color2);
        XTextView xTextView2 = this.mTitleTvTip;
        if (xTextView2 != null) {
            xTextView2.setTextColor(color);
        }
        XTextView xTextView3 = this.mTitleTv;
        if (xTextView3 != null) {
            xTextView3.setTextColor(color);
        }
    }

    private void setClockTvBackground(int i, int i2) {
        Drawable drawable;
        XTextView xTextView = this.mClockTv;
        if (xTextView != null) {
            xTextView.setTextColor(i);
            Drawable drawable2 = ContextUtils.getContext().getDrawable(R.drawable.layer_bg_restrict_close);
            if (drawable2 != null) {
                if (drawable2 instanceof GradientDrawable) {
                    ((GradientDrawable) drawable2).setStroke(ContextUtils.getDimensionPixelSize(R.dimen.restrict_bg_stroke_width), i2);
                } else if ((drawable2 instanceof LayerDrawable) && (drawable = ((LayerDrawable) drawable2).getDrawable(0)) != null && (drawable instanceof GradientDrawable)) {
                    ((GradientDrawable) drawable).setStroke(ContextUtils.getDimensionPixelSize(R.dimen.restrict_bg_stroke_width), i2);
                }
                this.mClockTv.setBackground(drawable2);
            }
        }
    }

    public void setCloseTv(long j) {
        this.mClockTv.setText(String.format(getResources().getString(R.string.restricted_rule_detail_guide_close_btn_name), Long.valueOf(j)));
    }

    public void setActionListener(IRestrictPopActionListener iRestrictPopActionListener) {
        this.mListener = iRestrictPopActionListener;
    }

    public void setVbChangeListener(IRestrictVbChangedListener iRestrictVbChangedListener) {
        this.mVbChangeListener = iRestrictVbChangedListener;
    }

    private void initView() {
        int i = this.mMode;
        if (i == -1) {
            return;
        }
        if (i == 1) {
            setUpView(ThemeWatcherUtil.getDrawable(R.drawable.layer_bg_restrict_pop_view_content), ThemeWatcherUtil.getColor(R.color.colour_palette_orange), ThemeWatcherUtil.getColor(R.color.colour_palette_stroke_orange), R.string.restrict_rule_set, String.format(getResources().getString(R.string.restricted_rule_detail_guide_title_name_noplate), this.mTitleCity), true, R.string.restricted_rule_detail_guide_nopalate_tip);
        } else if (i == 2) {
            setUpView(ThemeWatcherUtil.getDrawable(R.drawable.layer_bg_restrict_pop_view_content), ThemeWatcherUtil.getColor(R.color.colour_palette_orange), ThemeWatcherUtil.getColor(R.color.colour_palette_stroke_orange), R.string.restrict_rule_open, String.format(getResources().getString(R.string.restrict_pop_title_open), this.mTitleCity), false, 0);
        } else if (i == 3) {
            setUpView(ThemeWatcherUtil.getDrawable(R.drawable.layer_bg_restrict_pop_view_content), ThemeWatcherUtil.getColor(R.color.colour_palette_normal), ThemeWatcherUtil.getColor(R.color.colour_palette_stroke_normal), R.string.restricted_rule_detail_guide_open_btn_name, this.mTitle, false, 0);
        } else if (i != 4) {
        } else {
            setUpView(ThemeWatcherUtil.getDrawable(R.drawable.layer_bg_restrict_pop_view_content), ThemeWatcherUtil.getColor(R.color.colour_palette_orange), ThemeWatcherUtil.getColor(R.color.colour_palette_stroke_orange), R.string.restricted_rule_detail_guide_open_btn_name, this.mTitle, false, 0);
        }
    }

    private void setUpView(Drawable drawable, int i, int i2, int i3, String str, boolean z, int i4) {
        View inflate;
        removeAllViews();
        if (z) {
            inflate = LayoutInflater.from(getContext()).inflate(R.layout.layout_restricted_rule_guide_with_tips, this);
        } else {
            inflate = LayoutInflater.from(getContext()).inflate(R.layout.layout_restricted_rule_guide, this);
        }
        this.mTitleTv = (XTextView) inflate.findViewById(R.id.restricted_rule_detail_guide_title);
        this.mActionBtn = (XTextView) inflate.findViewById(R.id.restricted_rule_detail_btn);
        this.mClockTv = (XTextView) inflate.findViewById(R.id.clock_close);
        setBackground(drawable);
        this.mActionBtn.setTextColor(i);
        this.mActionBtn.setText(i3, (TextView.BufferType) null);
        if (!TextUtils.isEmpty(str)) {
            str = str.replaceAll("，", ",");
        }
        this.mTitleTv.setText(str);
        if (!this.mUseBgImage) {
            this.mTitleTv.setTextColor(i);
        }
        this.mClockTv.setText(String.format(getResources().getString(R.string.restricted_rule_detail_guide_close_btn_name), 15));
        if (!this.mUseBgImage) {
            setClockTvBackground(i, i2);
        }
        this.mTitleTvTip = (XTextView) inflate.findViewById(R.id.restricted_rule_detail_guide_title_tip);
        XTextView xTextView = this.mTitleTvTip;
        if (xTextView == null) {
            return;
        }
        if (z) {
            xTextView.setText(i4);
            this.mTitleTvTip.setVisibility(0);
            if (this.mUseBgImage) {
                return;
            }
            this.mTitleTvTip.setTextColor(i);
            return;
        }
        xTextView.setVisibility(8);
    }

    private void initClickListener() {
        this.mActionBtn.setOnClickListener(this);
        this.mClockTv.setOnClickListener(this);
    }

    public void setData(@RestrictUtils.RestrictMode int i, String str, String str2) {
        this.mMode = i;
        this.mTitle = str;
        this.mTitleCity = str2;
        initView();
        initClickListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.xui.widget.XRelativeLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ThemeWatcherUtil.removeXpThemeListener(this.mThemeSwitchListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.xui.widget.XRelativeLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ThemeWatcherUtil.addXpThemeSwitchListener(this.mThemeSwitchListener);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(@NonNull View view, int i) {
        super.onVisibilityChanged(view, i);
        IRestrictVbChangedListener iRestrictVbChangedListener = this.mVbChangeListener;
        if (iRestrictVbChangedListener == null) {
            return;
        }
        iRestrictVbChangedListener.onRestrictViewVisibilityChanged(i);
    }

    public void show() {
        if (getVisibility() != 0) {
            setVisibility(0);
        }
        this.mIsAlive = true;
        this.mTimer.start();
        updateTheme();
    }

    public boolean restoreShow() {
        if (this.mIsAlive) {
            if (getVisibility() != 0) {
                setVisibility(0);
            }
            updateTheme();
            return true;
        }
        return false;
    }

    public void hide(boolean z, boolean z2) {
        StatusConst.Mode mode;
        if (getVisibility() == 0) {
            setVisibility(8);
        }
        if (!z2) {
            this.mTimer.stop();
            this.mIsAlive = false;
        }
        if (z && (mode = this.mSceneMode) != null && mode == StatusConst.Mode.ROUTE) {
            RestrictStatUtil.sendStatDataWhenRestrictClose();
        }
    }

    public void hide(boolean z) {
        hide(z, false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.clock_close) {
            hide(true);
        } else if (id != R.id.restricted_rule_detail_btn) {
        } else {
            hide(false);
            int i = this.mMode;
            if (i == 1) {
                RestrictStatUtil.sendStatDataWhenSettingPlate();
                this.mListener.setPlateLicense();
            } else if (i == 2) {
                this.mListener.openRestrictSwitch();
            } else if (i == 3 || i == 4) {
                RestrictStatUtil.sendStatDataWhenReadDetail();
                this.mListener.showDetailRestrict();
            }
        }
    }
}
