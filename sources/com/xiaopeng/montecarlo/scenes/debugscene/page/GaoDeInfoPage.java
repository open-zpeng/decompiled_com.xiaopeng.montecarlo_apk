package com.xiaopeng.montecarlo.scenes.debugscene.page;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.autonavi.common.tool.FDManager;
import com.autonavi.gbl.servicemanager.ServiceMgr;
import com.xiaopeng.montecarlo.R;
/* loaded from: classes3.dex */
public class GaoDeInfoPage extends BasePage {
    @Override // com.xiaopeng.montecarlo.scenes.debugscene.page.BasePage
    @NonNull
    public View onCreateView(LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        return layoutInflater.inflate(R.layout.debug_gaodeinfo_fragment, viewGroup, false);
    }

    @Override // com.xiaopeng.montecarlo.scenes.debugscene.page.BasePage
    public void onViewCreated(View view) {
        ((TextView) view.findViewById(R.id.antonavi_info)).setText("SDK Version:\t" + ServiceMgr.getVersion() + "\nEngine Version:\t" + ServiceMgr.getEngineVersion() + FDManager.LINE_SEPERATOR);
    }
}
