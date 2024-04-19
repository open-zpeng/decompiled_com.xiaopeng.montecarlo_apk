package com.xiaopeng.montecarlo.appengine;

import com.xiaopeng.lib.apirouter.server.IServicePublisher;
import com.xiaopeng.lib.apirouter.server.Publish;
import com.xiaopeng.montecarlo.navcore.account.XPAccountServiceWrapper;
import com.xiaopeng.montecarlo.navcore.setting.SettingWrapper;
import com.xiaopeng.montecarlo.root.util.L;
/* loaded from: classes2.dex */
public class AccountDataService implements IServicePublisher {
    private static final int DATA_TYPE_FAVORITE = 1;
    private static final int DATA_TYPE_HISTORY = 2;
    private static final L.Tag TAG = new L.Tag("AccountDataService");

    @Publish
    public String getAccountId() {
        L.Tag tag = TAG;
        L.i(tag, "getAccountId:" + XPAccountServiceWrapper.getInstance().getUserId());
        return XPAccountServiceWrapper.getInstance().getUserId();
    }

    @Publish
    public String getAccountSid() {
        L.Tag tag = TAG;
        L.i(tag, "getAccountSid:" + SettingWrapper.getAccountSid());
        return SettingWrapper.getAccountSid();
    }

    @Publish
    public String getAccountOpenId() {
        L.Tag tag = TAG;
        L.i(tag, "getAccountOpenId:" + SettingWrapper.getAccountOpenId());
        return SettingWrapper.getAccountOpenId();
    }

    @Publish
    public String getDataVersion(int i) {
        if (i == 1) {
            return String.valueOf(SettingWrapper.getAccountMaxFavoriteVersion());
        }
        return i == 2 ? String.valueOf(SettingWrapper.getAccountMaxHistoryVersion()) : "-1";
    }
}
