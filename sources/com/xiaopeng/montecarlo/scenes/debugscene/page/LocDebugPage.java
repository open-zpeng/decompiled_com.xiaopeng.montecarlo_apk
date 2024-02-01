package com.xiaopeng.montecarlo.scenes.debugscene.page;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Switch;
import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.navcore.location.DRServiceManager;
import com.xiaopeng.montecarlo.views.dialog.XTextDialog;
import com.xiaopeng.xui.widget.XRadioButton;
/* loaded from: classes3.dex */
public class LocDebugPage extends BasePage {
    private Context mContext;
    private XRadioButton mLocDebugBench;
    private RadioGroup mLocDebugModeGroup;
    private Switch mLocDebugSwitch;
    private XRadioButton mLocDebugVehicle;
    private LinearLayout mLocResetLinear;
    private LinearLayout mLocSwitchLinear;
    private CompoundButton.OnCheckedChangeListener mOnCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() { // from class: com.xiaopeng.montecarlo.scenes.debugscene.page.LocDebugPage.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (compoundButton.getId() != R.id.loc_debug_switch) {
                return;
            }
            LocDebugPage.this.updateDebugMode(z);
            DRServiceManager.getInstance().setLocDebugSwitch(z);
        }
    };
    private RadioGroup.OnCheckedChangeListener mGroupListener = new RadioGroup.OnCheckedChangeListener() { // from class: com.xiaopeng.montecarlo.scenes.debugscene.page.LocDebugPage.2
        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            if (i == R.id.loc_debug_mode_bench) {
                DRServiceManager.getInstance().setLocDebugMode(1);
            } else if (i != R.id.loc_debug_mode_vehicle) {
            } else {
                DRServiceManager.getInstance().setLocDebugMode(2);
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.debugscene.page.LocDebugPage.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int id = view.getId();
            if (id == R.id.loc_debug_reset_text) {
                final XTextDialog xTextDialog = new XTextDialog(LocDebugPage.this.mContext);
                xTextDialog.setTitle(R.string.dialog_title_tips).setMessage(R.string.debug_list_reset_location_ttff_confirm);
                xTextDialog.setOkButtonClickListener(new View.OnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.debugscene.page.LocDebugPage.3.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        DRServiceManager.getInstance().resetLocDebugTtff();
                        xTextDialog.dismiss();
                    }
                });
                xTextDialog.setCancelButtonClickListener(new View.OnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.debugscene.page.LocDebugPage.3.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        xTextDialog.dismiss();
                    }
                });
                xTextDialog.show();
            } else if (id != R.id.loc_debug_switch_parent) {
            } else {
                boolean z = !DRServiceManager.getInstance().isLocDebugSwitch();
                LocDebugPage.this.mLocDebugSwitch.setChecked(z);
                LocDebugPage.this.updateDebugMode(z);
                DRServiceManager.getInstance().setLocDebugSwitch(z);
            }
        }
    };

    @Override // com.xiaopeng.montecarlo.scenes.debugscene.page.BasePage
    public View onCreateView(LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        this.mContext = viewGroup.getContext();
        return layoutInflater.inflate(R.layout.layout_loc_debug_page, (ViewGroup) null);
    }

    @Override // com.xiaopeng.montecarlo.scenes.debugscene.page.BasePage
    public void onViewCreated(View view) {
        this.mLocDebugSwitch = (Switch) view.findViewById(R.id.loc_debug_switch);
        this.mLocSwitchLinear = (LinearLayout) view.findViewById(R.id.loc_debug_switch_parent);
        this.mLocResetLinear = (LinearLayout) view.findViewById(R.id.loc_debug_reset_text);
        this.mLocDebugModeGroup = (RadioGroup) view.findViewById(R.id.loc_debug_mode_group);
        this.mLocDebugBench = (XRadioButton) view.findViewById(R.id.loc_debug_mode_bench);
        this.mLocDebugVehicle = (XRadioButton) view.findViewById(R.id.loc_debug_mode_vehicle);
        this.mLocDebugModeGroup.setOnCheckedChangeListener(this.mGroupListener);
        this.mLocResetLinear.setOnClickListener(this.mOnClickListener);
        this.mLocSwitchLinear.setOnClickListener(this.mOnClickListener);
        init();
    }

    private void init() {
        this.mLocDebugSwitch.setOnCheckedChangeListener(null);
        boolean isLocDebugSwitch = DRServiceManager.getInstance().isLocDebugSwitch();
        this.mLocDebugSwitch.setChecked(isLocDebugSwitch);
        updateDebugMode(isLocDebugSwitch);
        int locDebugMode = DRServiceManager.getInstance().getLocDebugMode();
        if (1 == locDebugMode) {
            this.mLocDebugBench.setChecked(true);
        } else if (2 == locDebugMode) {
            this.mLocDebugVehicle.setChecked(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDebugMode(boolean z) {
        if (z) {
            this.mLocDebugBench.setEnabled(true);
            this.mLocDebugVehicle.setEnabled(true);
            int color = this.mContext.getResources().getColor(R.color.common_white_100);
            this.mLocDebugBench.setTextColor(color);
            this.mLocDebugVehicle.setTextColor(color);
            return;
        }
        this.mLocDebugBench.setEnabled(false);
        this.mLocDebugVehicle.setEnabled(false);
        int color2 = this.mContext.getResources().getColor(R.color.common_white_30);
        this.mLocDebugBench.setTextColor(color2);
        this.mLocDebugVehicle.setTextColor(color2);
    }
}
