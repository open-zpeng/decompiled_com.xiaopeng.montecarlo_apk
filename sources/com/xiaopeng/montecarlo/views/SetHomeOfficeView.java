package com.xiaopeng.montecarlo.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.util.ThemeWatcherUtil;
import com.xiaopeng.vui.commons.VuiElementType;
import com.xiaopeng.xui.widget.XImageView;
import com.xiaopeng.xui.widget.XLinearLayout;
import com.xiaopeng.xui.widget.XTextView;
/* loaded from: classes3.dex */
public class SetHomeOfficeView extends XLinearLayout implements View.OnClickListener {
    public static final int DEST_SET_COMPANY = 1;
    public static final int DEST_SET_HOME = 0;
    private static final L.Tag TAG = new L.Tag("SetHomeOfficeView");
    private int mHeight;
    private XImageView mIvSetHomeOffice;
    private SetHomeOfficeClickListener mListener;
    private ViewGroup mRootView;
    private XTextView mTvSetHomeOffice;
    private int mViewType;
    private int mWidth;

    /* loaded from: classes3.dex */
    public interface SetHomeOfficeClickListener {
        void onClickSetHome(View view);

        void onClickSetOffice(View view);
    }

    public SetHomeOfficeView(Context context) {
        super(context);
        initView();
    }

    public SetHomeOfficeView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public SetHomeOfficeView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }

    public TextView getViewText() {
        return this.mTvSetHomeOffice;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SetHomeOfficeClickListener setHomeOfficeClickListener = this.mListener;
        if (setHomeOfficeClickListener == null) {
            return;
        }
        if (this.mViewType == 0) {
            setHomeOfficeClickListener.onClickSetHome(view);
        } else {
            setHomeOfficeClickListener.onClickSetOffice(view);
        }
    }

    public void setViewType(int i) {
        this.mViewType = i;
        if (this.mViewType == 0) {
            this.mWidth = ContextUtils.getDimensionPixelSize(R.dimen.search_set_home_width);
        } else {
            this.mWidth = ContextUtils.getDimensionPixelSize(R.dimen.search_set_office_width);
        }
        this.mHeight = ContextUtils.getDimensionPixelSize(R.dimen.search_set_office_height);
        updateTheme();
    }

    public int getViewType() {
        return this.mViewType;
    }

    public void setListener(SetHomeOfficeClickListener setHomeOfficeClickListener) {
        this.mListener = setHomeOfficeClickListener;
    }

    public void updateTheme() {
        setBackground(ThemeWatcherUtil.getDrawable(R.drawable.layer_bg_search_set_waypoint));
        if (this.mViewType == 0) {
            this.mIvSetHomeOffice.setImageResource(ThemeWatcherUtil.getDrawableResId(R.drawable.vector_ic_small_home));
            this.mTvSetHomeOffice.setText(ContextUtils.getString(R.string.action_set_home));
            return;
        }
        this.mIvSetHomeOffice.setImageResource(ThemeWatcherUtil.getDrawableResId(R.drawable.vector_ic_small_company));
        this.mTvSetHomeOffice.setText(ContextUtils.getString(R.string.action_set_company));
    }

    private void initView() {
        this.mRootView = (ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout.layout_set_home_office, (ViewGroup) this, true);
        this.mIvSetHomeOffice = (XImageView) this.mRootView.findViewById(R.id.iv_set_home_office);
        this.mTvSetHomeOffice = (XTextView) this.mRootView.findViewById(R.id.tv_set_home_office);
        setOrientation(0);
        setGravity(17);
        setVuiAction(ContextUtils.getString(R.string.vui_action_click));
        setVuiElementType(VuiElementType.GROUP);
        setVuiLayoutLoadable(true);
        setOnClickListener(this);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int i3 = this.mHeight;
        if (i3 != size2) {
            i2 = View.MeasureSpec.makeMeasureSpec(i3, 0);
        }
        int i4 = this.mWidth;
        if (i4 != size) {
            i = View.MeasureSpec.makeMeasureSpec(i4, 0);
        }
        setMeasuredDimension(i, i2);
    }
}
