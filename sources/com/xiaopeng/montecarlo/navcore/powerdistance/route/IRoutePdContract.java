package com.xiaopeng.montecarlo.navcore.powerdistance.route;

import com.xiaopeng.montecarlo.navcore.powerdistance.dataprovider.PdExternalData;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IPathResult;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IVariantPath;
/* loaded from: classes3.dex */
public interface IRoutePdContract {

    /* loaded from: classes3.dex */
    public interface LogicView {
        void onError();

        void onExternalDataFetched(PdExternalData pdExternalData);

        void onSuccess(double d);

        void onUpdateRemainDis(int i, int i2);
    }

    /* loaded from: classes3.dex */
    public interface Presenter {
        void close();

        void refreshOnlineK(int i, int i2, int i3, IVariantPath iVariantPath, IPathResult iPathResult, boolean z);

        void refreshWithOfflineK(int i, int i2, int i3, IVariantPath iVariantPath, IPathResult iPathResult);

        void refreshWithOfflineK(int i, int i2, int i3, IVariantPath iVariantPath, IPathResult iPathResult, boolean z);
    }
}
