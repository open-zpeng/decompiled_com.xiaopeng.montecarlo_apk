package com.xiaopeng.montecarlo.views.road.congestion;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.annotation.ColorInt;
import androidx.appcompat.widget.AppCompatTextView;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.util.ThemeWatcherUtil;
/* loaded from: classes3.dex */
public class CongestionTextView extends AppCompatTextView {
    private static final L.Tag TAG = new L.Tag("CongestionTextView");

    public CongestionTextView(Context context) {
        this(context, null);
    }

    public CongestionTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public CongestionTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setShowCongestion(CharSequence charSequence, @ColorInt int i) {
        L.Tag tag = TAG;
        L.i(tag, "setShowCongestion：" + ((Object) charSequence));
        if (TextUtils.isEmpty(charSequence)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        setText(charSequence);
        setTextColor(i);
        setBackgroundDrawable(ThemeWatcherUtil.getDrawable(R.drawable.png_blmap_cruisingtraffic));
    }
}
