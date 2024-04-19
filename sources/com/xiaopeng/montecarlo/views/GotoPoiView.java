package com.xiaopeng.montecarlo.views;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.util.Utils;
import com.xiaopeng.vui.commons.VuiElementType;
import com.xiaopeng.xui.widget.XLinearLayout;
import com.xiaopeng.xui.widget.XTextView;
/* loaded from: classes3.dex */
public class GotoPoiView extends XLinearLayout implements View.OnClickListener {
    private static final int THRESHOLD_MAX = 7;
    private static final int THRESHOLD_MIM = 6;
    private int mHeight;
    private GotoPoiClickListener mListener;
    private int mMaxWidth;
    private XTextView mTvGotoPoi;
    private int mWidth;

    /* loaded from: classes3.dex */
    public interface GotoPoiClickListener {
        void onClickGotoPoi(View view);
    }

    public XLinearLayout getContainerGotoPoi() {
        return this;
    }

    public GotoPoiView(Context context) {
        super(context);
        initView();
    }

    public GotoPoiView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    public GotoPoiView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        GotoPoiClickListener gotoPoiClickListener = this.mListener;
        if (gotoPoiClickListener == null) {
            return;
        }
        gotoPoiClickListener.onClickGotoPoi(view);
    }

    public void setListener(GotoPoiClickListener gotoPoiClickListener) {
        this.mListener = gotoPoiClickListener;
    }

    public CharSequence getText() {
        return this.mTvGotoPoi.getText();
    }

    public void setText(String str) {
        if (this.mTvGotoPoi == null) {
            return;
        }
        if (Utils.isLandscape() && !TextUtils.isEmpty(str)) {
            str = str.replaceAll(" ", "");
        }
        this.mTvGotoPoi.setText(str);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        XTextView xTextView;
        super.onMeasure(i, i2);
        int i3 = this.mWidth;
        if (Utils.isLandscape() && (xTextView = this.mTvGotoPoi) != null) {
            String str = (String) xTextView.getText();
            if (!TextUtils.isEmpty(str)) {
                String replaceAll = str.replaceAll(" ", "");
                if (replaceAll.length() >= (replaceAll.indexOf(".") > -1 ? 7 : 6)) {
                    i3 = this.mMaxWidth;
                }
            }
        }
        int i4 = this.mHeight;
        int size = View.MeasureSpec.getSize(i);
        if (i4 != View.MeasureSpec.getSize(i2)) {
            i2 = View.MeasureSpec.makeMeasureSpec(i4, 0);
        }
        if (i3 != size) {
            i = View.MeasureSpec.makeMeasureSpec(i3, 0);
        }
        setMeasuredDimension(i, i2);
    }

    private void initView() {
        this.mWidth = ContextUtils.getDimensionPixelSize(R.dimen.search_goto_poi_width);
        this.mMaxWidth = ContextUtils.getDimensionPixelSize(R.dimen.search_goto_poi_max_width);
        this.mHeight = ContextUtils.getDimensionPixelSize(R.dimen.search_goto_poi_height);
        this.mTvGotoPoi = (XTextView) LayoutInflater.from(getContext()).inflate(R.layout.layout_goto_poi, (ViewGroup) this, true).findViewById(R.id.tv_goto_poi);
        setOrientation(0);
        setGravity(17);
        setVuiAction(ContextUtils.getString(R.string.vui_action_click));
        setVuiElementType(VuiElementType.GROUP);
        setOnClickListener(this);
    }
}
