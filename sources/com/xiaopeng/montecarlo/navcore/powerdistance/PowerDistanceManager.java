package com.xiaopeng.montecarlo.navcore.powerdistance;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.LongSparseArray;
import androidx.annotation.Nullable;
import com.xiaopeng.montecarlo.root.carservice.CarServiceManager;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import java.util.List;
/* loaded from: classes2.dex */
public class PowerDistanceManager {
    private static final String BROADCAST_ACTION_DAY_CHANGE = "com.xiaopeng.montecarlo.broadcast.DAY_CHANGE";
    private static final float CLTC_K_ADJ = 1.0f;
    public static final float DEFAULT_K = 1.0f;
    private static final float NEDC_K_ADJ = 1.0f;
    private static final float WLPT_K_ADJ = 0.89f;
    private Context mContext;
    private EnergyDataHelper mEnergyDataHelper;
    private LongSparseArray<Double> mLongSparseArray = new LongSparseArray<>();
    @Nullable
    private BroadcastReceiver mUpdateEnergyDataReceiver;
    private static final L.Tag TAG = new L.Tag("PowerDistanceManager");
    private static volatile PowerDistanceManager sInstance = new PowerDistanceManager();

    private PowerDistanceManager() {
    }

    public static PowerDistanceManager getInstance() {
        return sInstance;
    }

    public void init(Context context) {
        this.mContext = context;
        this.mUpdateEnergyDataReceiver = new BroadcastReceiver() { // from class: com.xiaopeng.montecarlo.navcore.powerdistance.PowerDistanceManager.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                L.Tag tag = PowerDistanceManager.TAG;
                L.i(tag, "onReceive: " + intent.getAction());
                if (PowerDistanceManager.BROADCAST_ACTION_DAY_CHANGE.equals(intent.getAction())) {
                    PowerDistanceManager.this.mEnergyDataHelper.updateOfflineData();
                }
            }
        };
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(BROADCAST_ACTION_DAY_CHANGE);
        ContextUtils.getContext().registerReceiver(this.mUpdateEnergyDataReceiver, intentFilter);
        this.mEnergyDataHelper = new EnergyDataHelper();
        this.mEnergyDataHelper.initOfflineData();
    }

    public List<EnergyInfo> getEnergyInfoList() {
        return this.mEnergyDataHelper.getEnergyInfoList();
    }

    public void close() {
        this.mEnergyDataHelper.close();
        ContextUtils.getContext().unregisterReceiver(this.mUpdateEnergyDataReceiver);
    }

    public float getKAdjRate() {
        int enduranceMileageMode = CarServiceManager.getInstance().getEnduranceMileageMode();
        if (enduranceMileageMode != 0) {
            if (enduranceMileageMode != 1) {
                if (enduranceMileageMode != 2) {
                }
                return 1.0f;
            }
            return WLPT_K_ADJ;
        }
        return 1.0f;
    }

    public void addKValue(long j, double d) {
        L.Tag tag = TAG;
        L.i(tag, "pathId:" + j + ", k:" + d);
        this.mLongSparseArray.put(j, Double.valueOf(d));
    }

    public double getKValue(long j) {
        return this.mLongSparseArray.get(j, Double.valueOf(1.0d)).doubleValue() * getKAdjRate();
    }

    public void clearKValue() {
        L.i(TAG, "clearKValue");
        this.mLongSparseArray.clear();
    }
}
