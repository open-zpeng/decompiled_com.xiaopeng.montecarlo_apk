package com.autonavi.gbl.guide;

import android.util.Log;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.common.model.CalcRouteResultData;
import com.autonavi.gbl.common.model.ElecInfoConfig;
import com.autonavi.gbl.guide.impl.IGuideServiceImpl;
import com.autonavi.gbl.guide.model.CleanContinueGuide;
import com.autonavi.gbl.guide.model.ContinueGuidePath;
import com.autonavi.gbl.guide.model.GuideControlKey;
import com.autonavi.gbl.guide.model.ManeuverConfig;
import com.autonavi.gbl.guide.model.NaviPath;
import com.autonavi.gbl.guide.model.NaviType;
import com.autonavi.gbl.guide.model.QueryLanesInfo;
import com.autonavi.gbl.guide.model.guidecontrol.Param;
import com.autonavi.gbl.guide.model.guidecontrol.Type;
import com.autonavi.gbl.guide.model.impl.ContinueGuidePathImpl;
import com.autonavi.gbl.guide.model.impl.NaviPathImpl;
import com.autonavi.gbl.guide.observer.IContinueGuideInfoObserver;
import com.autonavi.gbl.guide.observer.ICruiseObserver;
import com.autonavi.gbl.guide.observer.INaviObserver;
import com.autonavi.gbl.guide.observer.ISoundPlayObserver;
import com.autonavi.gbl.guide.observer.impl.IContinueGuideInfoObserverImpl;
import com.autonavi.gbl.guide.observer.impl.ICruiseObserverImpl;
import com.autonavi.gbl.guide.observer.impl.INaviObserverImpl;
import com.autonavi.gbl.guide.observer.impl.ISoundPlayObserverImpl;
import com.autonavi.gbl.route.model.RouteRestorationResultData;
import com.autonavi.gbl.servicemanager.IService;
import com.autonavi.gbl.util.model.ServiceInitStatus;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;
@IntfAuto(target = IGuideServiceImpl.class, type = BuildType.JCTRL)
/* loaded from: classes.dex */
public class GuideService implements IService {
    private static String PACKAGE = ReflexTool.PN(GuideService.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private IGuideServiceImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected GuideService(long j, boolean z) {
        this((IGuideServiceImpl) ReflexTool.invokeDeclConstructorSafe(IGuideServiceImpl.class, new Class[]{Long.TYPE, Boolean.TYPE}, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(GuideService.class, this, this.mControl);
        }
    }

    public GuideService(IGuideServiceImpl iGuideServiceImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iGuideServiceImpl);
    }

    private void $constructor(IGuideServiceImpl iGuideServiceImpl) {
        if (iGuideServiceImpl != null) {
            this.mControl = iGuideServiceImpl;
            this.mTargetId = String.format("GuideService_%s_%d", String.valueOf(IGuideServiceImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected IGuideServiceImpl getControl() {
        return this.mControl;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public boolean isRecycled() {
        IGuideServiceImpl iGuideServiceImpl = this.mControl;
        if (iGuideServiceImpl != null) {
            return iGuideServiceImpl.isRecycled();
        }
        return true;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public long getPtr() {
        IGuideServiceImpl iGuideServiceImpl = this.mControl;
        if (iGuideServiceImpl != null) {
            return iGuideServiceImpl.getPtr();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onCreate() {
        IGuideServiceImpl iGuideServiceImpl = this.mControl;
        if (iGuideServiceImpl != null) {
            iGuideServiceImpl.onCreate();
        }
    }

    public static String getEngineVersion() {
        return IGuideServiceImpl.getEngineVersion();
    }

    public int init() {
        IGuideServiceImpl iGuideServiceImpl = this.mControl;
        if (iGuideServiceImpl != null) {
            return iGuideServiceImpl.init();
        }
        return Integer.MIN_VALUE;
    }

    public void unInit() {
        IGuideServiceImpl iGuideServiceImpl = this.mControl;
        if (iGuideServiceImpl != null) {
            iGuideServiceImpl.unInit();
        }
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    @ServiceInitStatus.ServiceInitStatus1
    public int isInit() {
        IGuideServiceImpl iGuideServiceImpl = this.mControl;
        if (iGuideServiceImpl != null) {
            return iGuideServiceImpl.isInit();
        }
        return Integer.MIN_VALUE;
    }

    public void logSwitch(int i) {
        IGuideServiceImpl iGuideServiceImpl = this.mControl;
        if (iGuideServiceImpl != null) {
            iGuideServiceImpl.logSwitch(i);
        }
    }

    public String getVersion() {
        IGuideServiceImpl iGuideServiceImpl = this.mControl;
        if (iGuideServiceImpl != null) {
            return iGuideServiceImpl.getVersion();
        }
        return null;
    }

    @Deprecated
    public boolean control(@GuideControlKey.GuideControlKey1 int i, String str) {
        IGuideServiceImpl iGuideServiceImpl = this.mControl;
        if (iGuideServiceImpl != null) {
            return iGuideServiceImpl.control(i, str);
        }
        return false;
    }

    public boolean setParam(Param param) {
        IGuideServiceImpl iGuideServiceImpl = this.mControl;
        if (iGuideServiceImpl != null) {
            return iGuideServiceImpl.setParam(param);
        }
        return false;
    }

    public Param getParam(@Type.Type1 int i) {
        IGuideServiceImpl iGuideServiceImpl = this.mControl;
        if (iGuideServiceImpl != null) {
            return iGuideServiceImpl.getParam(i);
        }
        return null;
    }

    public boolean setNaviPath(NaviPath naviPath) {
        TypeHelper typeHelper;
        try {
            Method method = GuideService.class.getMethod("setNaviPath", NaviPath.class);
            NaviPathImpl naviPathImpl = null;
            if (naviPath != null && (typeHelper = this.mTypeHelper) != null) {
                naviPathImpl = (NaviPathImpl) typeHelper.transfer(method, 0, naviPath);
            }
            IGuideServiceImpl iGuideServiceImpl = this.mControl;
            if (iGuideServiceImpl != null) {
                return iGuideServiceImpl.setNaviPath(naviPathImpl);
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    public void setElecInfoConfig(ElecInfoConfig elecInfoConfig) {
        IGuideServiceImpl iGuideServiceImpl = this.mControl;
        if (iGuideServiceImpl != null) {
            iGuideServiceImpl.setElecInfoConfig(elecInfoConfig);
        }
    }

    public void notifyRerouteFail(int i) {
        IGuideServiceImpl iGuideServiceImpl = this.mControl;
        if (iGuideServiceImpl != null) {
            iGuideServiceImpl.notifyRerouteFail(i);
        }
    }

    public void selectMainPathID(long j) {
        IGuideServiceImpl iGuideServiceImpl = this.mControl;
        if (iGuideServiceImpl != null) {
            iGuideServiceImpl.selectMainPathID(j);
        }
    }

    public void ignoreTmcSugguestNaviPath() {
        IGuideServiceImpl iGuideServiceImpl = this.mControl;
        if (iGuideServiceImpl != null) {
            iGuideServiceImpl.ignoreTmcSugguestNaviPath();
        }
    }

    public boolean startNavi(long j, @NaviType.NaviType1 int i) {
        IGuideServiceImpl iGuideServiceImpl = this.mControl;
        if (iGuideServiceImpl != null) {
            return iGuideServiceImpl.startNavi(j, i);
        }
        return false;
    }

    public boolean stopNavi(long j, boolean z) {
        IGuideServiceImpl iGuideServiceImpl = this.mControl;
        if (iGuideServiceImpl != null) {
            return iGuideServiceImpl.stopNavi(j, z);
        }
        return false;
    }

    public boolean stopNavi(long j) {
        IGuideServiceImpl iGuideServiceImpl = this.mControl;
        if (iGuideServiceImpl != null) {
            return iGuideServiceImpl.stopNavi(j);
        }
        return false;
    }

    public boolean pauseNavi(long j) {
        IGuideServiceImpl iGuideServiceImpl = this.mControl;
        if (iGuideServiceImpl != null) {
            return iGuideServiceImpl.pauseNavi(j);
        }
        return false;
    }

    public boolean resumeNavi(long j) {
        IGuideServiceImpl iGuideServiceImpl = this.mControl;
        if (iGuideServiceImpl != null) {
            return iGuideServiceImpl.resumeNavi(j);
        }
        return false;
    }

    public boolean playNaviManual() {
        IGuideServiceImpl iGuideServiceImpl = this.mControl;
        if (iGuideServiceImpl != null) {
            return iGuideServiceImpl.playNaviManual();
        }
        return false;
    }

    @Deprecated
    public boolean playTRManual(int i, int i2) {
        IGuideServiceImpl iGuideServiceImpl = this.mControl;
        if (iGuideServiceImpl != null) {
            return iGuideServiceImpl.playTRManual(i, i2);
        }
        return false;
    }

    @Deprecated
    public boolean playTRManual(int i) {
        IGuideServiceImpl iGuideServiceImpl = this.mControl;
        if (iGuideServiceImpl != null) {
            return iGuideServiceImpl.playTRManual(i);
        }
        return false;
    }

    public boolean playTRManualExt(int i) {
        IGuideServiceImpl iGuideServiceImpl = this.mControl;
        if (iGuideServiceImpl != null) {
            return iGuideServiceImpl.playTRManualExt(i);
        }
        return false;
    }

    public long obtainManeuverIconData(ManeuverConfig maneuverConfig) {
        IGuideServiceImpl iGuideServiceImpl = this.mControl;
        if (iGuideServiceImpl != null) {
            return iGuideServiceImpl.obtainManeuverIconData(maneuverConfig);
        }
        return 0L;
    }

    public long obtainAdvancedManeuverIconData(ManeuverConfig maneuverConfig) {
        IGuideServiceImpl iGuideServiceImpl = this.mControl;
        if (iGuideServiceImpl != null) {
            return iGuideServiceImpl.obtainAdvancedManeuverIconData(maneuverConfig);
        }
        return 0L;
    }

    public long obtainExitDirectionInfo(boolean z) {
        IGuideServiceImpl iGuideServiceImpl = this.mControl;
        if (iGuideServiceImpl != null) {
            return iGuideServiceImpl.obtainExitDirectionInfo(z);
        }
        return 0L;
    }

    public long obtainSAPAInfo(boolean z) {
        IGuideServiceImpl iGuideServiceImpl = this.mControl;
        if (iGuideServiceImpl != null) {
            return iGuideServiceImpl.obtainSAPAInfo(z);
        }
        return 0L;
    }

    public void setCustomizationInfo(String str) {
        IGuideServiceImpl iGuideServiceImpl = this.mControl;
        if (iGuideServiceImpl != null) {
            iGuideServiceImpl.setCustomizationInfo(str);
        }
    }

    public int queryAppointLanesInfo(QueryLanesInfo queryLanesInfo) {
        IGuideServiceImpl iGuideServiceImpl = this.mControl;
        if (iGuideServiceImpl != null) {
            return iGuideServiceImpl.queryAppointLanesInfo(queryLanesInfo);
        }
        return 0;
    }

    public int setPathData(CalcRouteResultData calcRouteResultData, RouteRestorationResultData routeRestorationResultData, long j) {
        IGuideServiceImpl iGuideServiceImpl = this.mControl;
        if (iGuideServiceImpl != null) {
            return iGuideServiceImpl.setPathData(calcRouteResultData, routeRestorationResultData, j);
        }
        return Integer.MIN_VALUE;
    }

    public int cleanContinueGuideInfo(CleanContinueGuide cleanContinueGuide) {
        IGuideServiceImpl iGuideServiceImpl = this.mControl;
        if (iGuideServiceImpl != null) {
            return iGuideServiceImpl.cleanContinueGuideInfo(cleanContinueGuide);
        }
        return Integer.MIN_VALUE;
    }

    public ContinueGuidePath getContinueGuidePath() {
        ContinueGuidePathImpl continueGuidePath;
        TypeHelper typeHelper;
        try {
            Method method = GuideService.class.getMethod("getContinueGuidePath", new Class[0]);
            IGuideServiceImpl iGuideServiceImpl = this.mControl;
            if (iGuideServiceImpl == null || (continueGuidePath = iGuideServiceImpl.getContinueGuidePath()) == null || (typeHelper = this.mTypeHelper) == null) {
                return null;
            }
            return (ContinueGuidePath) typeHelper.transfer(method, -1, (Object) continueGuidePath, true);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public NaviPath getContinueGuideNaviPath() {
        NaviPathImpl continueGuideNaviPath;
        TypeHelper typeHelper;
        try {
            Method method = GuideService.class.getMethod("getContinueGuideNaviPath", new Class[0]);
            IGuideServiceImpl iGuideServiceImpl = this.mControl;
            if (iGuideServiceImpl == null || (continueGuideNaviPath = iGuideServiceImpl.getContinueGuideNaviPath()) == null || (typeHelper = this.mTypeHelper) == null) {
                return null;
            }
            return (NaviPath) typeHelper.transfer(method, -1, (Object) continueGuideNaviPath, true);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public void addCruiseObserver(ICruiseObserver iCruiseObserver) {
        TypeHelper typeHelper;
        try {
            Method method = GuideService.class.getMethod("addCruiseObserver", ICruiseObserver.class);
            ICruiseObserverImpl iCruiseObserverImpl = null;
            if (iCruiseObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iCruiseObserverImpl = (ICruiseObserverImpl) typeHelper.transfer(method, 0, iCruiseObserver);
            }
            IGuideServiceImpl iGuideServiceImpl = this.mControl;
            if (iGuideServiceImpl != null) {
                iGuideServiceImpl.addCruiseObserver(iCruiseObserverImpl);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void removeCruiseObserver(ICruiseObserver iCruiseObserver) {
        TypeHelper typeHelper;
        try {
            Method method = GuideService.class.getMethod("removeCruiseObserver", ICruiseObserver.class);
            ICruiseObserverImpl iCruiseObserverImpl = null;
            if (iCruiseObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iCruiseObserverImpl = (ICruiseObserverImpl) typeHelper.transfer(method, 0, iCruiseObserver);
            }
            IGuideServiceImpl iGuideServiceImpl = this.mControl;
            if (iGuideServiceImpl != null) {
                iGuideServiceImpl.removeCruiseObserver(iCruiseObserverImpl);
                TypeHelper typeHelper2 = this.mTypeHelper;
                if (typeHelper2 != null) {
                    typeHelper2.unbind(method, 0, iCruiseObserver);
                }
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void addNaviObserver(INaviObserver iNaviObserver) {
        TypeHelper typeHelper;
        try {
            Method method = GuideService.class.getMethod("addNaviObserver", INaviObserver.class);
            INaviObserverImpl iNaviObserverImpl = null;
            if (iNaviObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iNaviObserverImpl = (INaviObserverImpl) typeHelper.transfer(method, 0, iNaviObserver);
            }
            IGuideServiceImpl iGuideServiceImpl = this.mControl;
            if (iGuideServiceImpl != null) {
                iGuideServiceImpl.addNaviObserver(iNaviObserverImpl);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void removeNaviObserver(INaviObserver iNaviObserver) {
        TypeHelper typeHelper;
        try {
            Method method = GuideService.class.getMethod("removeNaviObserver", INaviObserver.class);
            INaviObserverImpl iNaviObserverImpl = null;
            if (iNaviObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iNaviObserverImpl = (INaviObserverImpl) typeHelper.transfer(method, 0, iNaviObserver);
            }
            IGuideServiceImpl iGuideServiceImpl = this.mControl;
            if (iGuideServiceImpl != null) {
                iGuideServiceImpl.removeNaviObserver(iNaviObserverImpl);
                TypeHelper typeHelper2 = this.mTypeHelper;
                if (typeHelper2 != null) {
                    typeHelper2.unbind(method, 0, iNaviObserver);
                }
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void addSoundPlayObserver(ISoundPlayObserver iSoundPlayObserver) {
        TypeHelper typeHelper;
        try {
            Method method = GuideService.class.getMethod("addSoundPlayObserver", ISoundPlayObserver.class);
            ISoundPlayObserverImpl iSoundPlayObserverImpl = null;
            if (iSoundPlayObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iSoundPlayObserverImpl = (ISoundPlayObserverImpl) typeHelper.transfer(method, 0, iSoundPlayObserver);
            }
            IGuideServiceImpl iGuideServiceImpl = this.mControl;
            if (iGuideServiceImpl != null) {
                iGuideServiceImpl.addSoundPlayObserver(iSoundPlayObserverImpl);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void removeSoundPlayObserver(ISoundPlayObserver iSoundPlayObserver) {
        TypeHelper typeHelper;
        try {
            Method method = GuideService.class.getMethod("removeSoundPlayObserver", ISoundPlayObserver.class);
            ISoundPlayObserverImpl iSoundPlayObserverImpl = null;
            if (iSoundPlayObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iSoundPlayObserverImpl = (ISoundPlayObserverImpl) typeHelper.transfer(method, 0, iSoundPlayObserver);
            }
            IGuideServiceImpl iGuideServiceImpl = this.mControl;
            if (iGuideServiceImpl != null) {
                iGuideServiceImpl.removeSoundPlayObserver(iSoundPlayObserverImpl);
                TypeHelper typeHelper2 = this.mTypeHelper;
                if (typeHelper2 != null) {
                    typeHelper2.unbind(method, 0, iSoundPlayObserver);
                }
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public boolean addContinueGuideInfoObserver(IContinueGuideInfoObserver iContinueGuideInfoObserver) {
        TypeHelper typeHelper;
        try {
            Method method = GuideService.class.getMethod("addContinueGuideInfoObserver", IContinueGuideInfoObserver.class);
            IContinueGuideInfoObserverImpl iContinueGuideInfoObserverImpl = null;
            if (iContinueGuideInfoObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iContinueGuideInfoObserverImpl = (IContinueGuideInfoObserverImpl) typeHelper.transfer(method, 0, iContinueGuideInfoObserver);
            }
            IGuideServiceImpl iGuideServiceImpl = this.mControl;
            if (iGuideServiceImpl != null) {
                return iGuideServiceImpl.addContinueGuideInfoObserver(iContinueGuideInfoObserverImpl);
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    public boolean removeContinueGuideInfoObserver(IContinueGuideInfoObserver iContinueGuideInfoObserver) {
        TypeHelper typeHelper;
        try {
            Method method = GuideService.class.getMethod("removeContinueGuideInfoObserver", IContinueGuideInfoObserver.class);
            IContinueGuideInfoObserverImpl iContinueGuideInfoObserverImpl = null;
            if (iContinueGuideInfoObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iContinueGuideInfoObserverImpl = (IContinueGuideInfoObserverImpl) typeHelper.transfer(method, 0, iContinueGuideInfoObserver);
            }
            IGuideServiceImpl iGuideServiceImpl = this.mControl;
            if (iGuideServiceImpl != null) {
                boolean removeContinueGuideInfoObserver = iGuideServiceImpl.removeContinueGuideInfoObserver(iContinueGuideInfoObserverImpl);
                TypeHelper typeHelper2 = this.mTypeHelper;
                if (typeHelper2 != null) {
                    typeHelper2.unbind(method, 0, iContinueGuideInfoObserver);
                }
                return removeContinueGuideInfoObserver;
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mTypeHelper = null;
        }
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onDestroy() {
        this.mHasDestroy = true;
        clean();
    }

    protected void clean() {
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            Iterator it = ((HashSet) typeHelper.getBindSet("com.autonavi.gbl.guide.observer.ICruiseObserver")).iterator();
            while (it.hasNext()) {
                removeCruiseObserver((ICruiseObserver) it.next());
            }
        }
        TypeHelper typeHelper2 = this.mTypeHelper;
        if (typeHelper2 != null) {
            Iterator it2 = ((HashSet) typeHelper2.getBindSet("com.autonavi.gbl.guide.observer.INaviObserver")).iterator();
            while (it2.hasNext()) {
                removeNaviObserver((INaviObserver) it2.next());
            }
        }
        TypeHelper typeHelper3 = this.mTypeHelper;
        if (typeHelper3 != null) {
            Iterator it3 = ((HashSet) typeHelper3.getBindSet("com.autonavi.gbl.guide.observer.ISoundPlayObserver")).iterator();
            while (it3.hasNext()) {
                removeSoundPlayObserver((ISoundPlayObserver) it3.next());
            }
        }
        TypeHelper typeHelper4 = this.mTypeHelper;
        if (typeHelper4 != null) {
            Iterator it4 = ((HashSet) typeHelper4.getBindSet("com.autonavi.gbl.guide.observer.IContinueGuideInfoObserver")).iterator();
            while (it4.hasNext()) {
                removeContinueGuideInfoObserver((IContinueGuideInfoObserver) it4.next());
            }
        }
    }

    protected synchronized void delete() {
        if (!this.mHasDestroy) {
            onDestroy();
        }
        if (this.mTypeHelper != null) {
            TypeHelper typeHelper = this.mTypeHelper;
            TypeHelper.unbindAllTarget(PACKAGE, this);
        }
        if (this.mControl != null) {
            this.mControl = null;
        }
        unbind();
    }
}
