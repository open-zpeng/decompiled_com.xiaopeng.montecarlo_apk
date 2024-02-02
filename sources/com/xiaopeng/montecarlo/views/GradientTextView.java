package com.xiaopeng.montecarlo.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.xui.widget.XTextView;
/* loaded from: classes3.dex */
public class GradientTextView extends XTextView {
    public static final int LIMIT_4 = 4;
    public static final int LIMIT_5 = 5;
    private static final int OFFSET = 10;
    private String mCurrentText;
    private int mLimit;
    private float mLinearGradientX0;
    private float mLinearGradientX1;
    private Shader mShaderHorizontal;

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        String charSequence2 = charSequence.toString();
        String str = this.mCurrentText;
        if (str == null || !str.equals(charSequence2)) {
            this.mCurrentText = charSequence2;
            this.mShaderHorizontal = null;
            getPaint().setShader(this.mShaderHorizontal);
            if (!TextUtils.isEmpty(charSequence2)) {
                TextPaint paint = getPaint();
                L.Tag tag = new L.Tag("GradientTextView");
                L.i(tag, " text:" + charSequence2 + "  len:" + charSequence2.length());
                if (charSequence2.length() > this.mLimit) {
                    Rect rect = new Rect();
                    paint.getTextBounds(charSequence2, 0, this.mLimit + 1, rect);
                    Rect rect2 = new Rect();
                    paint.getTextBounds(charSequence2, 0, this.mLimit, rect2);
                    L.Tag tag2 = new L.Tag("GradientTextView");
                    L.i(tag2, " limit width:" + rect2.width() + "  bounds:" + rect.width());
                    this.mLinearGradientX0 = (float) (rect2.width() + (-10));
                    this.mLinearGradientX1 = (float) rect.width();
                    this.mShaderHorizontal = new LinearGradient(this.mLinearGradientX0, 0.0f, this.mLinearGradientX1, 0.0f, new int[]{getCurrentTextColor(), 0}, (float[]) null, Shader.TileMode.CLAMP);
                    setText(charSequence2.subSequence(0, this.mLimit + 1));
                }
            }
            invalidate();
        }
    }

    public GradientTextView(Context context) {
        super(context);
        this.mLimit = 5;
        this.mLinearGradientX0 = 0.0f;
        this.mLinearGradientX1 = 0.0f;
    }

    public GradientTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mLimit = 5;
        this.mLinearGradientX0 = 0.0f;
        this.mLinearGradientX1 = 0.0f;
    }

    @Override // android.widget.TextView
    public void setTextColor(int i) {
        super.setTextColor(i);
        if (this.mShaderHorizontal != null) {
            this.mShaderHorizontal = new LinearGradient(this.mLinearGradientX0, 0.0f, this.mLinearGradientX1, 0.0f, new int[]{getCurrentTextColor(), 0}, (float[]) null, Shader.TileMode.CLAMP);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.mShaderHorizontal != null) {
            getPaint().setShader(this.mShaderHorizontal);
            Paint.FontMetrics fontMetrics = getPaint().getFontMetrics();
            canvas.drawText(getText().toString(), 0.0f, (getMeasuredHeight() / 2) + ((-(fontMetrics.descent + fontMetrics.ascent)) / 2.0f), getPaint());
            return;
        }
        super.onDraw(canvas);
    }

    public void setLimit(int i) {
        this.mLimit = i;
    }
}
