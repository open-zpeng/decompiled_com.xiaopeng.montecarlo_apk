package com.xiaopeng.montecarlo.scenes.debugscene.page;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.scenes.debugscene.EnvAdapter;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class EnvSetPage extends BasePage {
    private Context mContext;
    private EnvAdapter mEnvAdapter;
    private ListView mEnvList;

    @Override // com.xiaopeng.montecarlo.scenes.debugscene.page.BasePage
    @NonNull
    public View onCreateView(LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        this.mContext = viewGroup.getContext();
        return layoutInflater.inflate(R.layout.debug_envset_fragment, viewGroup, false);
    }

    @Override // com.xiaopeng.montecarlo.scenes.debugscene.page.BasePage
    public void onViewCreated(View view) {
        this.mEnvList = (ListView) view.findViewById(R.id.env_setting_list);
        initEnv();
    }

    private void initEnv() {
        String[] stringArray = this.mContext.getResources().getStringArray(R.array.function_arr);
        ArrayList arrayList = new ArrayList();
        for (String str : stringArray) {
            arrayList.add(str);
        }
        this.mEnvAdapter = new EnvAdapter(arrayList, this.mContext);
        this.mEnvList.setAdapter((ListAdapter) this.mEnvAdapter);
    }
}
