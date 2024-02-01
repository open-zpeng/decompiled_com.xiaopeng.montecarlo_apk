package com.xiaopeng.montecarlo.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.util.ThemeWatcherUtil;
import com.xiaopeng.xui.view.XView;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class MapScaleLineView extends XView {
    private int mLineWith;
    private Paint mPaint;
    private ArrayList<Rect> mRectList;

    public MapScaleLineView(Context context) {
        this(context, null);
    }

    public MapScaleLineView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MapScaleLineView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mPaint = new Paint();
        this.mLineWith = 4;
        this.mRectList = new ArrayList<>();
        this.mPaint.setColor(ThemeWatcherUtil.getColor(R.color.main_title_text_color));
    }

    public void setPaintColor(int i) {
        this.mPaint.setColor(i);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mRectList.clear();
        int i5 = i2 - 1;
        this.mRectList.add(new Rect(0, 0, this.mLineWith, i5));
        ArrayList<Rect> arrayList = this.mRectList;
        int i6 = this.mLineWith;
        int i7 = i - 1;
        arrayList.add(new Rect(i6, i5 - i6, i7 - i6, i5));
        this.mRectList.add(new Rect(i7 - this.mLineWith, 0, i7, i5));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Iterator<Rect> it = this.mRectList.iterator();
        while (it.hasNext()) {
            canvas.drawRect(it.next(), this.mPaint);
        }
    }
}
