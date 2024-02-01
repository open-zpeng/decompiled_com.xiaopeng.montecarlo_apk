package com.xiaopeng.montecarlo.scenes.debugscene.page;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.navcore.location.DRServiceManager;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.scenes.debugscene.AutoListView;
import com.xiaopeng.montecarlo.scenes.debugscene.DebugItemTag;
import com.xiaopeng.montecarlo.views.dialog.XNoTitleDialog;
/* loaded from: classes3.dex */
public class DrSetPage extends BasePage {
    private Context mContext;

    @Override // com.xiaopeng.montecarlo.scenes.debugscene.page.BasePage
    public void onViewCreated(View view) {
    }

    @Override // com.xiaopeng.montecarlo.scenes.debugscene.page.BasePage
    public View onCreateView(LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        this.mContext = viewGroup.getContext();
        AutoListView autoListView = new AutoListView(this.mContext, null, 16842868);
        autoListView.setItemObj(this, R.layout.debug_list_item, R.id.debug_list_item_text);
        return autoListView;
    }

    @DebugItemTag(initMethod = "initDrTest", value = R.string.debug_list_dr_test_mode)
    public void menu0_DrTest(View view) {
        boolean isTestModeEnabled = DRServiceManager.getInstance().isTestModeEnabled();
        Switch r3 = (Switch) view.findViewById(R.id.debug_list_item_switch);
        r3.setChecked(!isTestModeEnabled);
        DRServiceManager.getInstance().setTestMode(r3.isChecked());
    }

    public void initDrTest(View view, int i) {
        ((Switch) view.findViewById(R.id.debug_list_item_switch)).setChecked(DRServiceManager.getInstance().isTestModeEnabled());
    }

    @DebugItemTag(enableInUserVersion = true, initMethod = "initRecalibration", value = R.string.debug_list_dr_recalibration)
    public void menu1_Recalibration(View view) {
        String string = ContextUtils.getString(R.string.debug_recalibration_alert_message);
        final XNoTitleDialog xNoTitleDialog = new XNoTitleDialog(this.mContext);
        xNoTitleDialog.setOkButtonClickListener(new View.OnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.debugscene.page.DrSetPage.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TBTManager.getInstance().clearCalibrationAndReboot();
                xNoTitleDialog.dismiss();
            }
        });
        xNoTitleDialog.setCancelButtonClickListener(new View.OnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.debugscene.page.DrSetPage.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                xNoTitleDialog.dismiss();
            }
        });
        xNoTitleDialog.setContentText(string);
        xNoTitleDialog.show();
    }

    public void initRecalibration(View view, int i) {
        View findViewById = view.findViewById(R.id.debug_list_item_switch);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
    }
}
