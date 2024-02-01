package com.xiaopeng.montecarlo.scenes.debugscene.page;

import android.app.UiModeManager;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.root.provider.dataset.DataSetHelper;
import com.xiaopeng.montecarlo.scenes.debugscene.AutoListView;
import com.xiaopeng.montecarlo.scenes.debugscene.DebugItemTag;
/* loaded from: classes3.dex */
public class DayNightPage extends BasePage {
    private AutoListView mAutoListView;
    private Context mContext;
    private UiModeManager mUiModeManager = null;

    @Override // com.xiaopeng.montecarlo.scenes.debugscene.page.BasePage
    public void onViewCreated(View view) {
    }

    @Override // com.xiaopeng.montecarlo.scenes.debugscene.page.BasePage
    public View onCreateView(LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        this.mContext = viewGroup.getContext();
        this.mAutoListView = new AutoListView(this.mContext, null, 16842868);
        this.mUiModeManager = (UiModeManager) this.mContext.getSystemService("uimode");
        this.mAutoListView.setItemObj(this, R.layout.debug_list_item, R.id.debug_list_item_text);
        return this.mAutoListView;
    }

    @DebugItemTag(initMethod = "initSystem", stringValue = "自动切换", value = 0)
    public void menu0_system(View view) {
        if (!(DataSetHelper.GlobalSet.getInt(DataSetHelper.GlobalSet.DAY_NIGHT_MODE_SET, 0) == 0)) {
            DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.DAY_NIGHT_MODE_SET, 0);
            this.mUiModeManager.setNightMode(0);
        }
        this.mAutoListView.notifyDataSetChanged();
    }

    public void initSystem(View view, int i) {
        ((Switch) view.findViewById(R.id.debug_list_item_switch)).setChecked(DataSetHelper.GlobalSet.getInt(DataSetHelper.GlobalSet.DAY_NIGHT_MODE_SET, 0) == 0);
    }

    @DebugItemTag(initMethod = "initDay", stringValue = "白天模式", value = 0)
    public void menu1_day(View view) {
        if (!(DataSetHelper.GlobalSet.getInt(DataSetHelper.GlobalSet.DAY_NIGHT_MODE_SET, 0) == 1)) {
            DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.DAY_NIGHT_MODE_SET, 1);
            this.mUiModeManager.setNightMode(1);
        }
        this.mAutoListView.notifyDataSetChanged();
    }

    public void initDay(View view, int i) {
        ((Switch) view.findViewById(R.id.debug_list_item_switch)).setChecked(DataSetHelper.GlobalSet.getInt(DataSetHelper.GlobalSet.DAY_NIGHT_MODE_SET, 0) == 1);
    }

    @DebugItemTag(initMethod = "initNight", stringValue = "黑夜模式", value = 0)
    public void menu2_night(View view) {
        if (!(DataSetHelper.GlobalSet.getInt(DataSetHelper.GlobalSet.DAY_NIGHT_MODE_SET, 0) == 2)) {
            DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.DAY_NIGHT_MODE_SET, 2);
            this.mUiModeManager.setNightMode(2);
        }
        this.mAutoListView.notifyDataSetChanged();
    }

    public void initNight(View view, int i) {
        ((Switch) view.findViewById(R.id.debug_list_item_switch)).setChecked(DataSetHelper.GlobalSet.getInt(DataSetHelper.GlobalSet.DAY_NIGHT_MODE_SET, -1) == 2);
    }
}
