package com.xiaopeng.montecarlo.service.minimap.dynamiclevel;

import com.xiaopeng.montecarlo.dynamiclevel.base.DynamicLevelSetting;
import com.xiaopeng.montecarlo.root.util.L;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class MiniMapCuriseDynamicLevelSetting extends DynamicLevelSetting {
    private static final int MAX_TIMER_COUNTS = 100;
    private static final int SPEED_COLLECT_NUMBER = 5;
    private static final L.Tag TAG = new L.Tag("MiniMapCuriseDynamicLevelSetting");
    private CruiseSettingInfo mCruiseSettingInfo;
    private List<CruiseSettingInfo> mCruiseSettingInfoList = new ArrayList();
    private int mLastIndex;

    @Override // com.xiaopeng.montecarlo.dynamiclevel.base.DynamicLevelSetting
    public boolean isEnableDynamicDegree() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MiniMapCuriseDynamicLevelSetting() {
        this.mCruiseSettingInfoList.add(new CruiseSettingInfo(0, 60, 17, 60.0f));
        this.mCruiseSettingInfoList.add(new CruiseSettingInfo(60, Integer.MAX_VALUE, 15, 60.0f));
    }

    @Override // com.xiaopeng.montecarlo.dynamiclevel.base.DynamicLevelSetting
    public float getLevel() {
        CruiseSettingInfo cruiseSettingInfo = this.mCruiseSettingInfo;
        if (cruiseSettingInfo != null) {
            return cruiseSettingInfo.level;
        }
        return -1.0f;
    }

    @Override // com.xiaopeng.montecarlo.dynamiclevel.base.DynamicLevelSetting
    public float getCameraDegree() {
        CruiseSettingInfo cruiseSettingInfo = this.mCruiseSettingInfo;
        if (cruiseSettingInfo != null) {
            return cruiseSettingInfo.degree;
        }
        return -1.0f;
    }

    public boolean isNeedUpdate() {
        return isValidCruiseSettingInfo(this.mCruiseSettingInfo);
    }

    public void update(float f) {
        CruiseSettingInfo cruiseSettingInfo = null;
        int i = 0;
        while (true) {
            if (i >= this.mCruiseSettingInfoList.size()) {
                break;
            }
            cruiseSettingInfo = this.mCruiseSettingInfoList.get(i);
            if (f < cruiseSettingInfo.start || f >= cruiseSettingInfo.end) {
                i++;
            } else {
                int i2 = this.mLastIndex;
                if (i2 == i || i2 == -1) {
                    if (cruiseSettingInfo.timerCounts < 100) {
                        cruiseSettingInfo.timerCounts++;
                    }
                } else if (i2 >= 0 && i2 < this.mCruiseSettingInfoList.size()) {
                    resetCruiseSettingInfo(this.mCruiseSettingInfoList.get(this.mLastIndex));
                }
                this.mLastIndex = i;
            }
        }
        if (L.ENABLE && cruiseSettingInfo != null) {
            L.v(TAG, "update  speed:" + f + " degree:" + cruiseSettingInfo.degree + " timecounts:" + cruiseSettingInfo.timerCounts + " isValid:" + cruiseSettingInfo.isValid);
        }
        this.mCruiseSettingInfo = cruiseSettingInfo;
    }

    private boolean isValidCruiseSettingInfo(CruiseSettingInfo cruiseSettingInfo) {
        if (cruiseSettingInfo == null || cruiseSettingInfo.timerCounts < 5 || !cruiseSettingInfo.isValid) {
            return false;
        }
        cruiseSettingInfo.isValid = false;
        return true;
    }

    private void resetCruiseSettingInfo(CruiseSettingInfo cruiseSettingInfo) {
        if (cruiseSettingInfo != null) {
            cruiseSettingInfo.timerCounts = 0;
            cruiseSettingInfo.isValid = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class CruiseSettingInfo extends DynamicLevelSetting.SettingInfo {
        public float degree;
        public boolean isValid;
        public int timerCounts;

        CruiseSettingInfo(int i, int i2, int i3, float f) {
            super(i, i2, i3);
            this.degree = f;
            this.timerCounts = 0;
            this.isValid = true;
        }
    }
}
