package com.xiaopeng.montecarlo.scenes.settingscene.dataprovider;

import com.xiaopeng.montecarlo.root.dataprovider.BaseParameter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes3.dex */
public class SettingRequestParam extends BaseParameter {
    public static final int SETTING_CHECK_AMAP_BIND = 1;
    public static final int SETTING_DELETE_USER_DATA = 0;
    public static final int SETTING_TYPE_INVALID = -1;
    protected int mTaskId = -1;
    protected int mSettingType = -1;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface SettingType {
    }

    public int getSettingType() {
        return this.mSettingType;
    }

    public void setSettingType(int i) {
        this.mTaskId = (int) System.currentTimeMillis();
        this.mSettingType = i;
    }
}
