package com.autonavi.gbl.guide.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.common.path.option.PathInfo;
import com.autonavi.gbl.guide.model.NaviPath;
import com.autonavi.gbl.guide.model.NaviType;
import com.autonavi.gbl.guide.router.GuideOperateObserverRouter;
@IntfAuto(target = GuideOperateObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface IGuideOperateObserver {
    boolean onUpdateMainNaviPath(PathInfo pathInfo);

    boolean pauseNavi();

    boolean resumeNavi();

    boolean setNaviPath(NaviPath naviPath, int i);

    boolean startNavi(@NaviType.NaviType1 int i);

    boolean stopNavi();
}
