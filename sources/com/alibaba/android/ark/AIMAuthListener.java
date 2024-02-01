package com.alibaba.android.ark;
/* loaded from: classes.dex */
public interface AIMAuthListener {
    void OnConnectionStatusChanged(AIMConnectionStatus aIMConnectionStatus);

    void OnDeviceStatus(int i, int i2, int i3, long j);

    void OnGetAuthCodeFailed(int i, String str);

    void OnKickout(String str);

    void OnLocalLogin();

    void OnMainServerCookieRefresh(String str);
}
