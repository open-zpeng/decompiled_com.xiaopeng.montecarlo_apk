package com.xiaopeng.montecarlo.scenes.debugscene.page;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.autonavi.common.tool.FDManager;
import com.autonavi.gbl.servicemanager.ServiceMgr;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.root.carservice.CarServiceManager;
/* loaded from: classes3.dex */
public class GaoDeInfoPage extends BasePage {
    @Override // com.xiaopeng.montecarlo.scenes.debugscene.page.BasePage
    @NonNull
    public View onCreateView(LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        return layoutInflater.inflate(R.layout.debug_gaodeinfo_fragment, viewGroup, false);
    }

    @Override // com.xiaopeng.montecarlo.scenes.debugscene.page.BasePage
    public void onViewCreated(View view) {
        TextView textView = (TextView) view.findViewById(R.id.antonavi_info);
        StringBuilder sb = new StringBuilder();
        sb.append("SDK Version:\t");
        sb.append(ServiceMgr.getVersion());
        sb.append("\nEngine Version:\t");
        sb.append(ServiceMgr.getEngineVersion());
        sb.append(FDManager.LINE_SEPERATOR);
        if (CarServiceManager.getInstance().hasXpuForNgp()) {
            sb.append("LANE SDK Version:\t");
            sb.append(ServiceMgr.getVersion());
            sb.append("\nEngine Version:\t");
            sb.append(ServiceMgr.getEngineVersion());
        }
        textView.setText(sb.toString());
    }
}
