package com.xiaopeng.montecarlo.views.keyboard;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import androidx.core.content.ContextCompat;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.xui.widget.XTextView;
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes3.dex */
public class KeyView extends XTextView {
    private KeyEntry mBoundKey;

    public KeyView(Context context) {
        this(context, null);
    }

    public KeyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setPadding(0, 0, 0, 0);
        setGravity(17);
        setVuiAction(ContextUtils.getString(R.string.vui_action_click));
    }

    public KeyEntry getBoundKey() {
        return this.mBoundKey;
    }

    public void bindKey(KeyEntry keyEntry) {
        this.mBoundKey = keyEntry;
        setTextColor(ContextCompat.getColorStateList(ContextUtils.getContext(), R.color.keyboard_key_text));
    }
}
