package com.xiaopeng.montecarlo.navcore.httpclient;

import android.os.Build;
import com.xiaopeng.lib.utils.NetUtils;
import com.xiaopeng.lib.utils.SystemPropertyUtil;
import com.xiaopeng.lib.utils.info.BuildInfoUtils;
import com.xiaopeng.montecarlo.navcore.account.XPAccountServiceWrapper;
import com.xiaopeng.montecarlo.navcore.setting.SettingWrapper;
import com.xiaopeng.montecarlo.root.httpclient.IHttpDependency;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.RootUtil;
/* loaded from: classes2.dex */
public class HttpDependencyImpl implements IHttpDependency {
    @Override // com.xiaopeng.montecarlo.root.httpclient.IHttpDependency
    public String getPackageName() {
        return RootUtil.getPackageName();
    }

    @Override // com.xiaopeng.montecarlo.root.httpclient.IHttpDependency
    public String getVersionCode() {
        return RootUtil.getVersionCode();
    }

    @Override // com.xiaopeng.montecarlo.root.httpclient.IHttpDependency
    public String getSystemVersion() {
        return BuildInfoUtils.getSystemVersion();
    }

    @Override // com.xiaopeng.montecarlo.root.httpclient.IHttpDependency
    public String getBuildModel() {
        return Build.MODEL;
    }

    @Override // com.xiaopeng.montecarlo.root.httpclient.IHttpDependency
    public String getHardwareId() {
        return SystemPropertyUtil.getHardwareId();
    }

    @Override // com.xiaopeng.montecarlo.root.httpclient.IHttpDependency
    public String getVin() {
        return RootUtil.getVin();
    }

    @Override // com.xiaopeng.montecarlo.root.httpclient.IHttpDependency
    public String getUserId() {
        return XPAccountServiceWrapper.getInstance().getUserId();
    }

    @Override // com.xiaopeng.montecarlo.root.httpclient.IHttpDependency
    public String getAuthToken() {
        return XPAccountServiceWrapper.getInstance().fetchAuthToken();
    }

    @Override // com.xiaopeng.montecarlo.root.httpclient.IHttpDependency
    public String getOpenId() {
        return SettingWrapper.getAccountOpenId();
    }

    @Override // com.xiaopeng.montecarlo.root.httpclient.IHttpDependency
    public String getSid() {
        return SettingWrapper.getAccountSid();
    }

    @Override // com.xiaopeng.montecarlo.root.httpclient.IHttpDependency
    public int getNetworkType() {
        return NetUtils.getNetworkType(ContextUtils.getContext());
    }
}
