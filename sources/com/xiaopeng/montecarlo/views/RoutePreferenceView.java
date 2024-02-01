package com.xiaopeng.montecarlo.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.XpThemeSwitchReceiver;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.util.ThemeWatcherUtil;
import com.xiaopeng.xui.widget.XImageButton;
import com.xiaopeng.xui.widget.XLinearLayout;
import com.xiaopeng.xui.widget.XTextView;
/* loaded from: classes3.dex */
public class RoutePreferenceView extends XLinearLayout implements View.OnClickListener {
    private static final L.Tag TAG = new L.Tag("RoutePreferenceView");
    private IActionListener mListener;
    private XImageButton mPreferenceNextButton;
    private XTextView mPreferenceTextView;
    private XpThemeSwitchReceiver.ThemeSwitchListener mThemeSwitchListener;

    /* loaded from: classes3.dex */
    public interface IActionListener {
        void onRoutePreferenceClick(View view);
    }

    public RoutePreferenceView(Context context) {
        this(context, null);
    }

    public RoutePreferenceView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoutePreferenceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mThemeSwitchListener = new XpThemeSwitchReceiver.ThemeSwitchListener() { // from class: com.xiaopeng.montecarlo.views.RoutePreferenceView.1
            @Override // com.xiaopeng.montecarlo.XpThemeSwitchReceiver.ThemeSwitchListener
            public void onThemeSwitch(int i2) {
                RoutePreferenceView.this.updateTheme();
            }
        };
        init();
        int dimensionPixelSize = ContextUtils.getDimensionPixelSize(R.dimen.route_preference_view_padding);
        setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
        setGravity(16);
        setClickable(true);
        setLayoutParams(new LinearLayout.LayoutParams(-2, ContextUtils.getDimensionPixelSize(R.dimen.route_preference_view_height)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTheme() {
        setBackground(ThemeWatcherUtil.getDrawable(R.drawable.layer_bg_route_preference));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.xui.widget.XLinearLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ThemeWatcherUtil.addXpThemeSwitchListener(this.mThemeSwitchListener);
        updateTheme();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.xui.widget.XLinearLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ThemeWatcherUtil.removeXpThemeListener(this.mThemeSwitchListener);
    }

    public void setClickListener(IActionListener iActionListener) {
        this.mListener = iActionListener;
    }

    public void setPreferenceText(String str) {
        this.mPreferenceTextView.setText(str);
    }

    private void init() {
        View inflate = LayoutInflater.from(ContextUtils.getContext()).inflate(R.layout.layout_route_preference, (ViewGroup) this, true);
        this.mPreferenceTextView = (XTextView) inflate.findViewById(R.id.route_preference_text);
        this.mPreferenceNextButton = (XImageButton) inflate.findViewById(R.id.route_preference_next);
        this.mPreferenceNextButton.setOnClickListener(this);
        setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IActionListener iActionListener = this.mListener;
        if (iActionListener != null) {
            iActionListener.onRoutePreferenceClick(view);
        }
    }
}
