package com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene.dataprovider;

import com.xiaopeng.montecarlo.root.dataprovider.BaseParameter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes3.dex */
public class LinkSeamlessRequestParam extends BaseParameter {
    public static final int LINK_SEAMLESS_TYPE_BIND_AMAP = 9;
    public static final int LINK_SEAMLESS_TYPE_CHECK_BIND_STATUS = -1;
    public static final int LINK_SEAMLESS_TYPE_CHECK_IS_AMAP_ACCOUNT = 1;
    public static final int LINK_SEAMLESS_TYPE_GET_AMAP_ACCOUNT = 7;
    public static final int LINK_SEAMLESS_TYPE_GET_AMAP_QRCODE = 6;
    public static final int LINK_SEAMLESS_TYPE_GET_USERINFO = 0;
    public static final int LINK_SEAMLESS_TYPE_GET_WECHAT_QRCODE = 4;
    public static final int LINK_SEAMLESS_TYPE_LOGIN_AMAP_BY_QRCODE = 8;
    public static final int LINK_SEAMLESS_TYPE_ONE_SEC_BIND = 3;
    public static final int LINK_SEAMLESS_TYPE_UNBIND_AMAP = 5;
    public static final int LINK_SEAMLESS_TYPE_XP_LOGIN = 2;
    private boolean mIsSync = true;
    private int mTaskId = -1;
    protected int mLinkSemalessType = -1;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface LinkSeamlessType {
    }

    public int getTaskId() {
        return this.mTaskId;
    }

    public void setTaskId(int i) {
        this.mTaskId = i;
    }

    public boolean isSync() {
        return this.mIsSync;
    }

    public void setSync(boolean z) {
        this.mIsSync = z;
    }

    public int getLinkSemalessType() {
        return this.mLinkSemalessType;
    }

    public void setLinkSemalessType(int i) {
        this.mLinkSemalessType = i;
    }
}
