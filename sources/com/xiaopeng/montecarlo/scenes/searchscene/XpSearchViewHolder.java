package com.xiaopeng.montecarlo.scenes.searchscene;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
/* loaded from: classes3.dex */
public abstract class XpSearchViewHolder extends RecyclerView.ViewHolder {
    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract XPPoiInfo getPoiInfo(int i);

    public XpSearchViewHolder(@NonNull View view) {
        super(view);
    }
}
