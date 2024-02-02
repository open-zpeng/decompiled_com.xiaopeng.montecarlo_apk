package com.xiaopeng.montecarlo.views.span;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.xiaopeng.montecarlo.root.util.L;
/* loaded from: classes3.dex */
public class TextAlignVerticalCenterSpan extends ReplacementSpan {
    private static final L.Tag TAG = new L.Tag("TextAlign");

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i, int i2, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        return (int) paint.measureText(charSequence, i, i2);
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "y" + i4 + "___bottom" + i5 + "_____height" + (paint.getFontMetrics().descent - paint.getFontMetrics().ascent) + "____textsize" + paint.getTextSize());
        }
        canvas.drawText(charSequence, i, i2, f, i4 - ((i4 - ((int) (paint.getFontMetrics().descent - paint.getFontMetrics().ascent))) / 2), paint);
    }
}
