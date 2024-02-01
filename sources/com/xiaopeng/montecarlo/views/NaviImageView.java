package com.xiaopeng.montecarlo.views;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.xui.widget.XImageView;
/* loaded from: classes3.dex */
public class NaviImageView extends XImageView {
    private static final L.Tag TAG = new L.Tag("NaviImageView");

    public NaviImageView(Context context) {
        super(context);
    }

    public NaviImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public NaviImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        try {
            super.onDraw(canvas);
        } catch (Exception e) {
            e.printStackTrace();
            L.Tag tag = TAG;
            L.e(tag, "ImageView id:" + getId() + ", " + getVuiElementId());
            throw new RuntimeException("NaviImageView onDraw error");
        }
    }
}
