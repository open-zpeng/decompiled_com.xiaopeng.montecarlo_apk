package com.xiaopeng.montecarlo.dynamiclevel.cruise;

import android.os.Handler;
import com.xiaopeng.montecarlo.dynamiclevel.base.DynamicLevelHelper;
import com.xiaopeng.montecarlo.navcore.mapdisplay.MapViewWrapper;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.root.util.L;
/* loaded from: classes.dex */
public class CruiseDynamicLevelHelper extends DynamicLevelHelper implements Handler.Callback {
    private static final int GRADUAL_CHANGE_SECONDS = 5;
    private static final L.Tag TAG = new L.Tag("CruiseDynamicLevelHelper");

    @Override // com.xiaopeng.montecarlo.dynamiclevel.base.DynamicLevelHelper
    protected boolean isNeedUpdate() {
        return true;
    }

    @Override // com.xiaopeng.montecarlo.dynamiclevel.base.DynamicLevelHelper
    protected void reset() {
    }

    public CruiseDynamicLevelHelper(MapViewWrapper mapViewWrapper) {
        super(mapViewWrapper, new CuriseDynamicLevelSetting());
    }

    @Override // com.xiaopeng.montecarlo.dynamiclevel.base.DynamicLevelHelper
    protected void startDynamicLevel() {
        sendUpdateInfoMsg();
    }

    @Override // com.xiaopeng.montecarlo.dynamiclevel.base.DynamicLevelHelper
    protected void stopDynamicLevel() {
        ((CuriseDynamicLevelSetting) this.mDynamicLevelSetting).resetCruiseSettingInfo();
    }

    @Override // com.xiaopeng.montecarlo.dynamiclevel.base.DynamicLevelHelper
    protected void updateInfo(Object obj) {
        sendUpdateInfoMsgDelayed(1);
        if (this.mIsGradualChange) {
            if (this.mGradualTimeCounts >= 5) {
                this.mIsGradualChange = false;
            } else {
                sendRefreshMsg();
            }
            this.mGradualTimeCounts++;
            return;
        }
        CuriseDynamicLevelSetting curiseDynamicLevelSetting = (CuriseDynamicLevelSetting) this.mDynamicLevelSetting;
        float carSpeed = TBTManager.getInstance().getCarSpeed();
        curiseDynamicLevelSetting.update(carSpeed);
        if (curiseDynamicLevelSetting.isNeedUpdate()) {
            if (L.ENABLE) {
                L.v(TAG, " isNeedUpdate true carSpeed:" + carSpeed);
            }
            if (updateInterval(5)) {
                if (L.ENABLE) {
                    L.v(TAG, " updateInterval start carSpeed:" + carSpeed);
                }
                this.mIsGradualChange = true;
                this.mGradualTimeCounts = 0;
                sendRefreshMsg();
            }
        }
    }
}
