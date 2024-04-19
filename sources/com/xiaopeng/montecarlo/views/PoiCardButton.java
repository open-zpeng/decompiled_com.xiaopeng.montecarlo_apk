package com.xiaopeng.montecarlo.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.annotation.RequiresApi;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.UiHandlerUtil;
import com.xiaopeng.montecarlo.util.ThemeWatcherUtil;
import com.xiaopeng.xui.widget.XRelativeLayout;
import com.xiaopeng.xui.widget.XTextView;
/* loaded from: classes3.dex */
public class PoiCardButton extends XRelativeLayout {
    public static final int STATUS_FOCUS = 1;
    public static final int STATUS_UNFOCUS = 0;
    private XTextView mCarButtonTv;
    private int mFocusBackground;
    private int mFocusIcon;
    private int mFocusTextColor;
    private View mRootView;
    private int mStatus;
    private int mText;
    private int mUnfocusBackground;
    private int mUnfocusIcon;
    private int mUnfocusTextColor;

    public PoiCardButton(Context context) {
        super(context);
        this.mStatus = 0;
        this.mUnfocusIcon = 0;
        this.mFocusIcon = 0;
        this.mUnfocusTextColor = 0;
        this.mFocusTextColor = 0;
        this.mUnfocusBackground = 0;
        this.mFocusBackground = 0;
        this.mText = 0;
        init(context, null, -1, -1);
    }

    public PoiCardButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mStatus = 0;
        this.mUnfocusIcon = 0;
        this.mFocusIcon = 0;
        this.mUnfocusTextColor = 0;
        this.mFocusTextColor = 0;
        this.mUnfocusBackground = 0;
        this.mFocusBackground = 0;
        this.mText = 0;
        init(context, attributeSet, -1, -1);
    }

    public PoiCardButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mStatus = 0;
        this.mUnfocusIcon = 0;
        this.mFocusIcon = 0;
        this.mUnfocusTextColor = 0;
        this.mFocusTextColor = 0;
        this.mUnfocusBackground = 0;
        this.mFocusBackground = 0;
        this.mText = 0;
        init(context, attributeSet, i, -1);
    }

    @RequiresApi(api = 21)
    public PoiCardButton(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mStatus = 0;
        this.mUnfocusIcon = 0;
        this.mFocusIcon = 0;
        this.mUnfocusTextColor = 0;
        this.mFocusTextColor = 0;
        this.mUnfocusBackground = 0;
        this.mFocusBackground = 0;
        this.mText = 0;
        init(context, attributeSet, i, i2);
    }

    private void init(Context context, AttributeSet attributeSet, int i, int i2) {
        TypedArray obtainStyledAttributes;
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.layout_poi_button, this);
        initViews();
        if (attributeSet != null && (obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.PoiCardButton, i, i2)) != null) {
            this.mStatus = obtainStyledAttributes.getInt(4, 0);
            this.mUnfocusIcon = obtainStyledAttributes.getResourceId(6, 0);
            this.mFocusIcon = obtainStyledAttributes.getResourceId(2, 0);
            this.mUnfocusTextColor = obtainStyledAttributes.getResourceId(7, 0);
            this.mFocusTextColor = obtainStyledAttributes.getResourceId(3, 0);
            this.mUnfocusBackground = obtainStyledAttributes.getResourceId(5, 0);
            this.mFocusBackground = obtainStyledAttributes.getResourceId(1, 0);
            this.mText = obtainStyledAttributes.getResourceId(0, 0);
            obtainStyledAttributes.recycle();
        }
        renderByTheme();
    }

    private void renderByTheme() {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.views.PoiCardButton.1
            @Override // java.lang.Runnable
            public void run() {
                if (PoiCardButton.this.mStatus == 0) {
                    PoiCardButton.this.mCarButtonTv.setText(PoiCardButton.this.mText);
                    PoiCardButton poiCardButton = PoiCardButton.this;
                    poiCardButton.setBackground(ContextUtils.getDrawable(ThemeWatcherUtil.getDrawableResId(poiCardButton.mUnfocusBackground)));
                    PoiCardButton.this.mCarButtonTv.setTextColor(ContextUtils.getColor(ThemeWatcherUtil.getColorResId(PoiCardButton.this.mUnfocusTextColor)));
                    Drawable drawable = ContextUtils.getDrawable(ThemeWatcherUtil.getDrawableResId(PoiCardButton.this.mUnfocusIcon));
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    PoiCardButton.this.mCarButtonTv.setCompoundDrawables(drawable, null, null, null);
                    return;
                }
                PoiCardButton.this.mCarButtonTv.setText(PoiCardButton.this.mText);
                PoiCardButton poiCardButton2 = PoiCardButton.this;
                poiCardButton2.setBackground(ThemeWatcherUtil.getDrawable(poiCardButton2.mFocusBackground));
                PoiCardButton.this.mCarButtonTv.setTextColor(ContextUtils.getColor(ThemeWatcherUtil.getColorResId(PoiCardButton.this.mFocusTextColor)));
                Drawable drawable2 = ContextUtils.getDrawable(ThemeWatcherUtil.getDrawableResId(PoiCardButton.this.mFocusIcon));
                drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                PoiCardButton.this.mCarButtonTv.setCompoundDrawables(drawable2, null, null, null);
            }
        });
    }

    private void initViews() {
        this.mCarButtonTv = (XTextView) this.mRootView.findViewById(R.id.tv_car_button);
        setGravity(17);
    }

    public void refreshByTheme() {
        renderByTheme();
    }

    public void switchStatus() {
        if (this.mStatus == 0) {
            this.mStatus = 1;
        } else {
            this.mStatus = 0;
        }
        refreshByTheme();
    }

    public void switchStatus(int i) {
        this.mStatus = i;
        refreshByTheme();
    }
}
