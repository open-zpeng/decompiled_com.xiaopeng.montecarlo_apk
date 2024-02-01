package com.xiaopeng.montecarlo.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.XpThemeSwitchReceiver;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.util.ThemeWatcherUtil;
import com.xiaopeng.xui.widget.XLinearLayout;
import com.xiaopeng.xui.widget.XTextView;
/* loaded from: classes3.dex */
public class XpMixedTextView extends XLinearLayout {
    private static final boolean DEFAULT_VALUE_IS_COLOR_LIST = false;
    private static final boolean DEFAULT_VALUE_NEED_THEME_SWITCH = true;
    private Context mContext;
    private int mFirstFontStyle;
    private String mFirstValue;
    private XTextView mFirstView;
    private boolean mIsColorList;
    private boolean mNeedThemeSwitch;
    private int mSecondFontStyle;
    private String mSecondValue;
    private XTextView mSecondView;
    private XpThemeSwitchReceiver.ThemeSwitchListener mThemeSwitchListener;

    public void addOrUpdateText(String str, String str2) {
        addOrUpdateTextWithLayoutParams(str, null, str2, null);
    }

    public void addOrUpdateTextWithLayoutParams(String str, LinearLayout.LayoutParams layoutParams, String str2, LinearLayout.LayoutParams layoutParams2) {
        this.mFirstValue = str;
        this.mSecondValue = str2;
        this.mFirstView.setText(this.mFirstValue);
        this.mSecondView.setText(this.mSecondValue);
        setLayoutParams(layoutParams, layoutParams2);
    }

    public void setLayoutParams(LinearLayout.LayoutParams layoutParams, LinearLayout.LayoutParams layoutParams2) {
        if (layoutParams != null) {
            this.mFirstView.setLayoutParams(layoutParams);
        }
        if (layoutParams2 != null) {
            this.mSecondView.setLayoutParams(layoutParams2);
        }
    }

    public LinearLayout.LayoutParams getFirstLayoutParams() {
        return (LinearLayout.LayoutParams) this.mFirstView.getLayoutParams();
    }

    public LinearLayout.LayoutParams getSecondLayoutParams() {
        return (LinearLayout.LayoutParams) this.mSecondView.getLayoutParams();
    }

    public XpMixedTextView(Context context) {
        this(context, null);
    }

    public XpMixedTextView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public XpMixedTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mNeedThemeSwitch = true;
        this.mIsColorList = false;
        this.mThemeSwitchListener = new XpThemeSwitchReceiver.ThemeSwitchListener() { // from class: com.xiaopeng.montecarlo.views.XpMixedTextView.1
            @Override // com.xiaopeng.montecarlo.XpThemeSwitchReceiver.ThemeSwitchListener
            public void onThemeSwitch(int i2) {
                if (XpMixedTextView.this.mNeedThemeSwitch) {
                    XpMixedTextView.this.renderView();
                }
            }
        };
        this.mContext = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.XpMixedTextView);
        try {
            if (obtainStyledAttributes != null) {
                try {
                    this.mFirstFontStyle = obtainStyledAttributes.getResourceId(0, 0);
                    this.mSecondFontStyle = obtainStyledAttributes.getResourceId(3, 0);
                    this.mNeedThemeSwitch = obtainStyledAttributes.getBoolean(2, true);
                    this.mIsColorList = obtainStyledAttributes.getBoolean(1, false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            initView();
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private void initView() {
        LayoutInflater.from(this.mContext).inflate(R.layout.layout_xp_mixed_text, this);
        this.mFirstView = (XTextView) findViewById(R.id.mixed_first);
        this.mSecondView = (XTextView) findViewById(R.id.mixed_second);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void renderView() {
        int i = this.mFirstFontStyle;
        if (i > 0) {
            this.mFirstView.setTextAppearance(i);
            if (this.mIsColorList) {
                int colorResId = ThemeWatcherUtil.getColorResId(getTextColorResId(this.mContext, this.mFirstFontStyle));
                if (colorResId != 0) {
                    this.mFirstView.setTextColor(ContextUtils.getColorStateList(colorResId));
                }
            } else {
                int colorResId2 = ThemeWatcherUtil.getColorResId(getTextColorResId(this.mContext, this.mFirstFontStyle));
                if (colorResId2 != 0) {
                    this.mFirstView.setTextColor(ContextUtils.getColor(colorResId2));
                }
            }
        }
        int i2 = this.mSecondFontStyle;
        if (i2 > 0) {
            this.mSecondView.setTextAppearance(i2);
            if (this.mIsColorList) {
                int colorResId3 = ThemeWatcherUtil.getColorResId(getTextColorResId(this.mContext, this.mSecondFontStyle));
                if (colorResId3 != 0) {
                    this.mSecondView.setTextColor(ContextUtils.getColorStateList(colorResId3));
                    return;
                }
                return;
            }
            int colorResId4 = ThemeWatcherUtil.getColorResId(getTextColorResId(this.mContext, this.mSecondFontStyle));
            if (colorResId4 != 0) {
                this.mSecondView.setTextColor(ContextUtils.getColor(colorResId4));
            }
        }
    }

    private int getTextColorResId(Context context, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, new int[]{16842904});
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        return resourceId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.xui.widget.XLinearLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        renderView();
        if (this.mNeedThemeSwitch) {
            ThemeWatcherUtil.addXpThemeSwitchListener(this.mThemeSwitchListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.xui.widget.XLinearLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        if (this.mNeedThemeSwitch) {
            ThemeWatcherUtil.removeXpThemeListener(this.mThemeSwitchListener);
        }
        super.onDetachedFromWindow();
    }
}
