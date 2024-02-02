package com.xiaopeng.montecarlo.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatButton;
/* loaded from: classes3.dex */
public class ImageTextButton extends AppCompatButton {
    public ImageTextButton(Context context) {
        super(context);
    }

    public ImageTextButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ImageTextButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        Drawable drawable = getCompoundDrawables()[0];
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth() + getCompoundDrawablePadding();
            canvas.save();
            canvas.translate((getWidth() - (intrinsicWidth + ((int) getPaint().measureText(getText().toString().trim())))) / 2, 0.0f);
        }
        super.onDraw(canvas);
    }
}
