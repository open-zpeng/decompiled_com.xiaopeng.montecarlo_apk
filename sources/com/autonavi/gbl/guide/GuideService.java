package com.autonavi.gbl.guide;

import android.util.Log;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.common.model.ElecInfoConfig;
import com.autonavi.gbl.guide.impl.IGuideServiceImpl;
import com.autonavi.gbl.guide.model.GuideControlKey;
import com.autonavi.gbl.guide.model.ManeuverConfig;
import com.autonavi.gbl.guide.model.NaviExtraInfoType;
import com.autonavi.gbl.guide.model.NaviPath;
import com.autonavi.gbl.guide.model.NaviType;
import com.autonavi.gbl.guide.model.guidecontrol.Param;
import com.autonavi.gbl.guide.model.impl.NaviPathImpl;
import com.autonavi.gbl.guide.observer.ICruiseObserver;
import com.autonavi.gbl.guide.observer.IGuideOperateObserver;
import com.autonavi.gbl.guide.observer.INaviObserver;
import com.autonavi.gbl.guide.observer.ISoundPlayObserver;
import com.autonavi.gbl.guide.observer.impl.ICruiseObserverImpl;
import com.autonavi.gbl.guide.observer.impl.IGuideOperateObserverImpl;
import com.autonavi.gbl.guide.observer.impl.INaviObserverImpl;
import com.autonavi.gbl.guide.observer.impl.ISoundPlayObserverImpl;
import com.autonavi.gbl.servicemanager.IService;
import com.autonavi.gbl.util.model.ErrorCode;
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

    @ErrorCode.ErrorCode1
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

    public boolean setNaviPath(NaviPath naviPath, long j) {
        try {
            Method method = GuideService.class.getMethod("setNaviPath", NaviPath.class, Long.TYPE);
            if (naviPath != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r2 = typeHelper != null ? (NaviPathImpl) typeHelper.transfer(method, 0, naviPath) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $naviPath == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.guide.GuideService.1
                    }));
                    return false;
                }
            }
            IGuideServiceImpl iGuideServiceImpl = this.mControl;
            if (iGuideServiceImpl != null) {
                return iGuideServiceImpl.setNaviPath(r2, j);
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

    public boolean playTRManual(int i, int i2) {
        IGuideServiceImpl iGuideServiceImpl = this.mControl;
        if (iGuideServiceImpl != null) {
            return iGuideServiceImpl.playTRManual(i, i2);
        }
        return false;
    }

    public boolean playTRManual(int i) {
        IGuideServiceImpl iGuideServiceImpl = this.mControl;
        if (iGuideServiceImpl != null) {
            return iGuideServiceImpl.playTRManual(i);
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

    public void setExtraInfoData(@NaviExtraInfoType.NaviExtraInfoType1 int i, String str) {
        IGuideServiceImpl iGuideServiceImpl = this.mControl;
        if (iGuideServiceImpl != null) {
            iGuideServiceImpl.setExtraInfoData(i, str);
        }
    }

    public void setExtraInfoParam(@NaviExtraInfoType.NaviExtraInfoType1 int i, String str) {
        IGuideServiceImpl iGuideServiceImpl = this.mControl;
        if (iGuideServiceImpl != null) {
            iGuideServiceImpl.setExtraInfoParam(i, str);
        }
    }

    public void addCruiseObserver(ICruiseObserver iCruiseObserver) {
        try {
            Method method = GuideService.class.getMethod("addCruiseObserver", ICruiseObserver.class);
            if (iCruiseObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r1 = typeHelper != null ? (ICruiseObserverImpl) typeHelper.transfer(method, 0, iCruiseObserver) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $ob == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.guide.GuideService.2
                    }));
                }
            }
            IGuideServiceImpl iGuideServiceImpl = this.mControl;
            if (iGuideServiceImpl != null) {
                iGuideServiceImpl.addCruiseObserver(r1);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void removeCruiseObserver(ICruiseObserver iCruiseObserver) {
        try {
            Method method = GuideService.class.getMethod("removeCruiseObserver", ICruiseObserver.class);
            if (iCruiseObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r1 = typeHelper != null ? (ICruiseObserverImpl) typeHelper.transfer(method, 0, iCruiseObserver) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $ob == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.guide.GuideService.3
                    }));
                }
            }
            IGuideServiceImpl iGuideServiceImpl = this.mControl;
            if (iGuideServiceImpl != null) {
                iGuideServiceImpl.removeCruiseObserver(r1);
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
        try {
            Method method = GuideService.class.getMethod("addNaviObserver", INaviObserver.class);
            if (iNaviObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r1 = typeHelper != null ? (INaviObserverImpl) typeHelper.transfer(method, 0, iNaviObserver) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $ob == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.guide.GuideService.4
                    }));
                }
            }
            IGuideServiceImpl iGuideServiceImpl = this.mControl;
            if (iGuideServiceImpl != null) {
                iGuideServiceImpl.addNaviObserver(r1);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void removeNaviObserver(INaviObserver iNaviObserver) {
        try {
            Method method = GuideService.class.getMethod("removeNaviObserver", INaviObserver.class);
            if (iNaviObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r1 = typeHelper != null ? (INaviObserverImpl) typeHelper.transfer(method, 0, iNaviObserver) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $ob == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.guide.GuideService.5
                    }));
                }
            }
            IGuideServiceImpl iGuideServiceImpl = this.mControl;
            if (iGuideServiceImpl != null) {
                iGuideServiceImpl.removeNaviObserver(r1);
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
        try {
            Method method = GuideService.class.getMethod("addSoundPlayObserver", ISoundPlayObserver.class);
            if (iSoundPlayObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r1 = typeHelper != null ? (ISoundPlayObserverImpl) typeHelper.transfer(method, 0, iSoundPlayObserver) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $ob == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.guide.GuideService.6
                    }));
                }
            }
            IGuideServiceImpl iGuideServiceImpl = this.mControl;
            if (iGuideServiceImpl != null) {
                iGuideServiceImpl.addSoundPlayObserver(r1);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public void removeSoundPlayObserver(ISoundPlayObserver iSoundPlayObserver) {
        try {
            Method method = GuideService.class.getMethod("removeSoundPlayObserver", ISoundPlayObserver.class);
            if (iSoundPlayObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r1 = typeHelper != null ? (ISoundPlayObserverImpl) typeHelper.transfer(method, 0, iSoundPlayObserver) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $ob == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.guide.GuideService.7
                    }));
                }
            }
            IGuideServiceImpl iGuideServiceImpl = this.mControl;
            if (iGuideServiceImpl != null) {
                iGuideServiceImpl.removeSoundPlayObserver(r1);
                TypeHelper typeHelper2 = this.mTypeHelper;
                if (typeHelper2 != null) {
                    typeHelper2.unbind(method, 0, iSoundPlayObserver);
                }
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public boolean addGuideOperateObserver(IGuideOperateObserver iGuideOperateObserver) {
        try {
            Method method = GuideService.class.getMethod("addGuideOperateObserver", IGuideOperateObserver.class);
            if (iGuideOperateObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r2 = typeHelper != null ? (IGuideOperateObserverImpl) typeHelper.transfer(method, 0, iGuideOperateObserver) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $pOb == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.guide.GuideService.8
                    }));
                    return false;
                }
            }
            IGuideServiceImpl iGuideServiceImpl = this.mControl;
            if (iGuideServiceImpl != null) {
                return iGuideServiceImpl.addGuideOperateObserver(r2);
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    public boolean removeGuideOperateObserver(IGuideOperateObserver iGuideOperateObserver) {
        try {
            Method method = GuideService.class.getMethod("removeGuideOperateObserver", IGuideOperateObserver.class);
            if (iGuideOperateObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r2 = typeHelper != null ? (IGuideOperateObserverImpl) typeHelper.transfer(method, 0, iGuideOperateObserver) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $pOb == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.guide.GuideService.9
                    }));
                    return false;
                }
            }
            IGuideServiceImpl iGuideServiceImpl = this.mControl;
            if (iGuideServiceImpl != null) {
                return iGuideServiceImpl.removeGuideOperateObserver(r2);
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.guide.GuideService.10
        });
        objArr[1] = String.valueOf(this.mTypeHelper != null);
        DebugTool.d("%s: mTypeHelper=%s", objArr);
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
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.guide.GuideService.11
        }));
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
    }

    protected synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.guide.GuideService.12
        }));
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
