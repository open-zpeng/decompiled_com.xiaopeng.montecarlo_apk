package com.xiaopeng.montecarlo.scenes.linkseamlessnaviscene;

import com.xiaopeng.montecarlo.navcore.event.AccountEvent;
/* loaded from: classes3.dex */
public class ILinkQRCodeContract {

    /* loaded from: classes3.dex */
    public interface LogicView {
        void onAmapQRCodeSuccess(AccountEvent accountEvent);

        void onError(String str);

        void onWechatQRCodeSuccess(String str);
    }

    /* loaded from: classes3.dex */
    public interface Presenter {
        void requestAmapQRCode();

        void requestWechatQRCode();
    }
}
