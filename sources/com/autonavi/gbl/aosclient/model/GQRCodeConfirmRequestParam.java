package com.autonavi.gbl.aosclient.model;

import com.xiaopeng.montecarlo.navresetore.NavRestoreManager;
import java.io.Serializable;
/* loaded from: classes.dex */
public class GQRCodeConfirmRequestParam extends BLRequestBase implements Serializable {
    public int TypeId = 1;
    public String QRCodeId = "";
    public long TcpTimeout = NavRestoreManager.WAKELOCK_TIMEOUT_10SEC;

    public GQRCodeConfirmRequestParam() {
        this.mEAosRequestType = 200007;
    }
}
