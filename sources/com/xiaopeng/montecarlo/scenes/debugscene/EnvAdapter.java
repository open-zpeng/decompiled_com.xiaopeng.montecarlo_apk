package com.xiaopeng.montecarlo.scenes.debugscene;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.root.provider.dataset.DataSetHelper;
import com.xiaopeng.montecarlo.root.util.L;
import java.util.List;
/* loaded from: classes3.dex */
public class EnvAdapter extends BaseAdapter {
    private static final L.Tag TAG = new L.Tag("EnvAdapter");
    private Context mContext;
    private List<String> mFunctions;

    /* JADX INFO: Access modifiers changed from: private */
    public int getCheckedEnv(int i) {
        switch (i) {
            case R.id.env_dev /* 2131296620 */:
                return 0;
            case R.id.env_pre /* 2131296621 */:
                return 2;
            case R.id.env_product /* 2131296622 */:
                return 3;
            case R.id.env_setting_list /* 2131296623 */:
            default:
                return -1;
            case R.id.env_test /* 2131296624 */:
                return 1;
        }
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public EnvAdapter(List<String> list, Context context) {
        this.mFunctions = list;
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<String> list = this.mFunctions;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        List<String> list = this.mFunctions;
        if (list == null) {
            return null;
        }
        return list.get(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(R.layout.env_item, viewGroup, false);
            viewHolder = new ViewHolder();
            viewHolder.mFunctionName = (TextView) view.findViewById(R.id.function_name);
            viewHolder.mRadioGroup = (RadioGroup) view.findViewById(R.id.radio_group);
            viewHolder.mDevEnv = (RadioButton) view.findViewById(R.id.env_dev);
            viewHolder.mTestEnv = (RadioButton) view.findViewById(R.id.env_test);
            viewHolder.mPreEnv = (RadioButton) view.findViewById(R.id.env_pre);
            viewHolder.mProductEnv = (RadioButton) view.findViewById(R.id.env_product);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        if (i == 1 || i == 3 || i == 4 || i == 5 || i == 7 || i == 8 || i == 9) {
            viewHolder.mPreEnv.setVisibility(0);
        } else {
            viewHolder.mPreEnv.setVisibility(8);
        }
        viewHolder.mRadioGroup.setOnCheckedChangeListener(null);
        settingSelectStatus(i, viewHolder);
        viewHolder.mFunctionName.setText(this.mFunctions.get(i));
        addRadioGroupChangeListener(i, viewHolder.mRadioGroup);
        return view;
    }

    private void addRadioGroupChangeListener(final int i, RadioGroup radioGroup) {
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.xiaopeng.montecarlo.scenes.debugscene.EnvAdapter.1
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup radioGroup2, int i2) {
                int checkedEnv = EnvAdapter.this.getCheckedEnv(i2);
                L.Tag tag = EnvAdapter.TAG;
                L.i(tag, "setting position:" + i + ",env:" + checkedEnv);
                switch (i) {
                    case 0:
                        DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.CACHE_FUCTION_ACCOUNT_SERVICE_ENV, checkedEnv);
                        return;
                    case 1:
                        DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.CACHE_FUCTION_CHARGE_SERVICE_ENV, checkedEnv);
                        return;
                    case 2:
                        DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.CACHE_FUCTION_ASSISTANT_SERVICE_ENV, checkedEnv);
                        return;
                    case 3:
                        DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.CACHE_FUCTION_BIZ_SERVICE_ENV, checkedEnv);
                        return;
                    case 4:
                    case 7:
                    default:
                        return;
                    case 5:
                        DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.CACHE_MAP_SERVER_SERVICE_ENV, checkedEnv);
                        return;
                    case 6:
                        DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.CACHE_FUCTION_XP_COMMON_CONFIG_SERVICE_ENV, checkedEnv);
                        return;
                    case 8:
                        DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.CACHE_FUCTION_RECOMMEND_PARKING_SERVICE_ENV, checkedEnv);
                        return;
                    case 9:
                        DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.CACHE_SERVICE_XP_XUI_SERVICE_ENV, checkedEnv);
                        return;
                }
            }
        });
    }

    private void settingSelectStatus(int i, ViewHolder viewHolder) {
        int i2;
        switch (i) {
            case 0:
                i2 = DataSetHelper.GlobalSet.getInt(DataSetHelper.GlobalSet.CACHE_FUCTION_ACCOUNT_SERVICE_ENV, 3);
                break;
            case 1:
                i2 = DataSetHelper.GlobalSet.getInt(DataSetHelper.GlobalSet.CACHE_FUCTION_CHARGE_SERVICE_ENV, 3);
                break;
            case 2:
                i2 = DataSetHelper.GlobalSet.getInt(DataSetHelper.GlobalSet.CACHE_FUCTION_ASSISTANT_SERVICE_ENV, 3);
                break;
            case 3:
                i2 = DataSetHelper.GlobalSet.getInt(DataSetHelper.GlobalSet.CACHE_FUCTION_BIZ_SERVICE_ENV, 3);
                break;
            case 4:
            case 7:
            default:
                i2 = -1;
                break;
            case 5:
                i2 = DataSetHelper.GlobalSet.getInt(DataSetHelper.GlobalSet.CACHE_MAP_SERVER_SERVICE_ENV, 3);
                break;
            case 6:
                i2 = DataSetHelper.GlobalSet.getInt(DataSetHelper.GlobalSet.CACHE_FUCTION_XP_COMMON_CONFIG_SERVICE_ENV, 3);
                break;
            case 8:
                i2 = DataSetHelper.GlobalSet.getInt(DataSetHelper.GlobalSet.CACHE_FUCTION_RECOMMEND_PARKING_SERVICE_ENV, 3);
                break;
            case 9:
                i2 = DataSetHelper.GlobalSet.getInt(DataSetHelper.GlobalSet.CACHE_SERVICE_XP_XUI_SERVICE_ENV, 3);
                break;
        }
        L.Tag tag = TAG;
        L.i(tag, "get position:" + i + ",env:" + i2);
        if (i2 == 0) {
            viewHolder.mDevEnv.setChecked(true);
        } else if (i2 == 1) {
            viewHolder.mTestEnv.setChecked(true);
        } else if (i2 == 2) {
            viewHolder.mPreEnv.setChecked(true);
        } else if (i2 != 3) {
        } else {
            viewHolder.mProductEnv.setChecked(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class ViewHolder {
        RadioButton mDevEnv;
        TextView mFunctionName;
        RadioButton mPreEnv;
        RadioButton mProductEnv;
        RadioGroup mRadioGroup;
        RadioButton mTestEnv;

        ViewHolder() {
        }
    }
}
