package com.xiaopeng.montecarlo.views.camera;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes3.dex */
public class RestrictSpeedTextDrawable extends Drawable {
    private CharSequence mShowText;
    private TextPaint mTextPaint = new TextPaint(1);

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public RestrictSpeedTextDrawable(int i, @ColorInt int i2, Typeface typeface) {
        this.mTextPaint.setTextAlign(Paint.Align.CENTER);
        this.mTextPaint.setTextSize(i);
        this.mTextPaint.setTypeface(typeface);
        this.mTextPaint.setColor(i2);
    }

    public void setText(CharSequence charSequence) {
        this.mShowText = charSequence;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (TextUtils.isEmpty(this.mShowText)) {
            return;
        }
        Rect bounds = getBounds();
        CharSequence charSequence = this.mShowText;
        canvas.drawText(charSequence, 0, charSequence.length(), (bounds.right + bounds.left) / 2.0f, (((bounds.top + bounds.bottom) - this.mTextPaint.getFontMetrics().descent) - this.mTextPaint.getFontMetrics().ascent) / 2.0f, this.mTextPaint);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.mTextPaint.setAlpha(i);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.mTextPaint.setColorFilter(colorFilter);
        invalidateSelf();
    }
}
