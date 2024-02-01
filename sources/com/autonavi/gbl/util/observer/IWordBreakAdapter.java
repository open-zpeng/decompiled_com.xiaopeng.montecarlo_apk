package com.autonavi.gbl.util.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.util.router.WordBreakAdapterRouter;
import java.util.ArrayList;
@IntfAuto(target = WordBreakAdapterRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface IWordBreakAdapter {
    boolean breakText(String str, ArrayList<String> arrayList);
}
