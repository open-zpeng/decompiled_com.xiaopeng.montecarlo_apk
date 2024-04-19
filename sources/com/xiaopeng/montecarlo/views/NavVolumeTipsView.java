package com.xiaopeng.montecarlo.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import com.xiaopeng.montecarlo.R;
/* loaded from: classes3.dex */
public class NavVolumeTipsView extends PopupWindow {
    public NavVolumeTipsView(Context context) {
        super(context);
        setContentView(intView(context));
    }

    private View intView(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.layout_navi_volume_tips, (ViewGroup) null);
    }
}
