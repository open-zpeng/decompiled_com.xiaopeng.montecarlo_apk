package com.xiaopeng.montecarlo.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.util.ThemeWatcherUtil;
import com.xiaopeng.xui.widget.XImageView;
import com.xiaopeng.xui.widget.XRelativeLayout;
/* loaded from: classes3.dex */
public class AccountTypeView extends XRelativeLayout {
    private int mAccountIconSize;
    private XImageView mAccountLogon;
    private int mAccountLogonRes;
    private int mAccountLogonSize;
    private XImageView mAccountType;
    private int mAccountTypeRes;
    private Context mContext;

    public AccountTypeView(@NonNull Context context) {
        this(context, null, -1);
    }

    public AccountTypeView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public AccountTypeView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        init(attributeSet, i);
    }

    private void init(AttributeSet attributeSet, int i) {
        initViewRes(attributeSet, i);
        initView();
        updateThemeRes();
    }

    private void initView() {
        LayoutInflater.from(this.mContext).inflate(R.layout.layout_account_type_view, this);
        this.mAccountType = (XImageView) findViewById(R.id.account_icon);
        this.mAccountLogon = (XImageView) findViewById(R.id.account_logon);
        this.mAccountType.setImageResource(this.mAccountTypeRes);
        this.mAccountLogon.setImageResource(this.mAccountLogonRes);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mAccountType.getLayoutParams();
        int i = this.mAccountIconSize;
        layoutParams.height = i;
        layoutParams.width = i;
        this.mAccountType.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mAccountLogon.getLayoutParams();
        int i2 = this.mAccountLogonSize;
        layoutParams2.height = i2;
        layoutParams2.width = i2;
        layoutParams2.leftMargin = this.mAccountIconSize - (i2 / 2);
        this.mAccountLogon.setLayoutParams(layoutParams2);
    }

    private void initViewRes(AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = this.mContext.getTheme().obtainStyledAttributes(attributeSet, R.styleable.AccountTypeView, i, 0);
        try {
            if (obtainStyledAttributes != null) {
                try {
                    this.mAccountTypeRes = obtainStyledAttributes.getResourceId(0, 0);
                    this.mAccountLogonRes = obtainStyledAttributes.getResourceId(2, 0);
                    this.mAccountIconSize = (int) obtainStyledAttributes.getDimension(1, 50.0f);
                    this.mAccountLogonSize = (int) obtainStyledAttributes.getDimension(3, 24.0f);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private void updateThemeRes() {
        int i;
        int i2;
        XImageView xImageView = this.mAccountType;
        if (xImageView != null && (i2 = this.mAccountTypeRes) > 0) {
            xImageView.setImageResource(ThemeWatcherUtil.getDrawableResId(i2));
        }
        XImageView xImageView2 = this.mAccountLogon;
        if (xImageView2 == null || (i = this.mAccountLogonRes) <= 0) {
            return;
        }
        xImageView2.setImageResource(ThemeWatcherUtil.getDrawableResId(i));
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
    }

    public void updateSelectedStatus(boolean z) {
        this.mAccountType.setSelected(z);
    }

    public void updateLogonStatus(boolean z) {
        this.mAccountLogon.setVisibility(z ? 0 : 8);
    }
}
