package com.autonavi.gbl.data.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.data.model.DownLoadMode;
import com.autonavi.gbl.data.router.EHPDataObserverRouter;
import java.util.ArrayList;
@IntfAuto(target = EHPDataObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface IEHPDataObserver {
    void onEHPDataExistedAdcodeList(@DownLoadMode.DownLoadMode1 int i, ArrayList<Integer> arrayList, ArrayList<Integer> arrayList2);
}
