package com.xiaopeng.montecarlo.scenes.debugscene.page;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.root.provider.dataset.DataSetHelper;
import com.xiaopeng.montecarlo.root.util.DebugCacheConsts;
import com.xiaopeng.montecarlo.scenes.debugscene.AutoListView;
import com.xiaopeng.montecarlo.scenes.debugscene.DebugItemTag;
/* loaded from: classes2.dex */
public class RecommendPage extends BasePage {
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

    @DebugItemTag(initMethod = "initPack", value = R.string.debug_list_recommend_park)
    public void menu0_Pack(View view) {
        Switch r2 = (Switch) view.findViewById(R.id.debug_list_item_switch);
        r2.setChecked(!r2.isChecked());
        DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.CACHE_IS_OPEN_XP_RECOMMEND_PARK, r2.isChecked());
    }

    public void initPack(View view, int i) {
        ((Switch) view.findViewById(R.id.debug_list_item_switch)).setChecked(DataSetHelper.GlobalSet.getBoolean(DataSetHelper.GlobalSet.CACHE_IS_OPEN_XP_RECOMMEND_PARK, DebugCacheConsts.DEFAULT_VALUE_CACHE_IS_OPEN_RECOMMEND_PARK));
    }
}
