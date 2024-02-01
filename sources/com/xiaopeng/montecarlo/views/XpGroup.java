package com.xiaopeng.montecarlo.views;

import android.content.Context;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.Group;
import com.xiaopeng.xui.vui.VuiView;
/* loaded from: classes3.dex */
public class XpGroup extends Group implements VuiView {
    public XpGroup(Context context) {
        this(context, null);
    }

    public XpGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public XpGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initVui(this, attributeSet);
    }

    protected void finalize() throws Throwable {
        super.finalize();
        releaseVui();
    }
}
