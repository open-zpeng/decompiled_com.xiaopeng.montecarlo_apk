package com.autonavi.gbl.guide.router;

import android.util.Log;
import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.common.path.option.PathInfo;
import com.autonavi.gbl.common.path.option.impl.PathInfoImpl;
import com.autonavi.gbl.guide.model.NaviPath;
import com.autonavi.gbl.guide.model.NaviType;
import com.autonavi.gbl.guide.model.impl.NaviPathImpl;
import com.autonavi.gbl.guide.observer.IGuideOperateObserver;
import com.autonavi.gbl.guide.observer.impl.IGuideOperateObserverImpl;
import java.lang.reflect.Method;
@IntfAuto(target = IGuideOperateObserver.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class GuideOperateObserverRouter extends IGuideOperateObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(GuideOperateObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(GuideOperateObserverRouter.class);
    private TypeHelper mHelper;
    private IGuideOperateObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, IGuideOperateObserver iGuideOperateObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IGuideOperateObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iGuideOperateObserver;
    }

    protected GuideOperateObserverRouter(String str, IGuideOperateObserver iGuideOperateObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iGuideOperateObserver);
    }

    protected GuideOperateObserverRouter(String str, IGuideOperateObserver iGuideOperateObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iGuideOperateObserver);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.guide.router.GuideOperateObserverRouter.1
        });
        objArr[1] = String.valueOf(this.mHelper != null);
        DebugTool.d("%s: mHelper=%s", objArr);
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.guide.observer.impl.IGuideOperateObserverImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.guide.router.GuideOperateObserverRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.guide.observer.impl.IGuideOperateObserverImpl
    public boolean startNavi(@NaviType.NaviType1 int i) {
        IGuideOperateObserver iGuideOperateObserver = this.mObserver;
        if (iGuideOperateObserver != null) {
            return iGuideOperateObserver.startNavi(i);
        }
        return false;
    }

    @Override // com.autonavi.gbl.guide.observer.impl.IGuideOperateObserverImpl
    public boolean stopNavi() {
        IGuideOperateObserver iGuideOperateObserver = this.mObserver;
        if (iGuideOperateObserver != null) {
            return iGuideOperateObserver.stopNavi();
        }
        return false;
    }

    @Override // com.autonavi.gbl.guide.observer.impl.IGuideOperateObserverImpl
    public boolean pauseNavi() {
        IGuideOperateObserver iGuideOperateObserver = this.mObserver;
        if (iGuideOperateObserver != null) {
            return iGuideOperateObserver.pauseNavi();
        }
        return false;
    }

    @Override // com.autonavi.gbl.guide.observer.impl.IGuideOperateObserverImpl
    public boolean resumeNavi() {
        IGuideOperateObserver iGuideOperateObserver = this.mObserver;
        if (iGuideOperateObserver != null) {
            return iGuideOperateObserver.resumeNavi();
        }
        return false;
    }

    @Override // com.autonavi.gbl.guide.observer.impl.IGuideOperateObserverImpl
    public boolean setNaviPath(NaviPathImpl naviPathImpl, int i) {
        try {
            Method method = GuideOperateObserverRouter.class.getMethod("setNaviPath", NaviPathImpl.class, Integer.TYPE);
            if (naviPathImpl != null) {
                TypeHelper typeHelper = this.mHelper;
                r2 = typeHelper != null ? (NaviPath) typeHelper.transfer(method, 0, naviPathImpl) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $naviPath == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.guide.router.GuideOperateObserverRouter.3
                    }));
                }
            }
            IGuideOperateObserver iGuideOperateObserver = this.mObserver;
            if (iGuideOperateObserver != null) {
                return iGuideOperateObserver.setNaviPath(r2, i);
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    @Override // com.autonavi.gbl.guide.observer.impl.IGuideOperateObserverImpl
    public boolean onUpdateMainNaviPath(PathInfoImpl pathInfoImpl) {
        try {
            Method method = GuideOperateObserverRouter.class.getMethod("onUpdateMainNaviPath", PathInfoImpl.class);
            if (pathInfoImpl != null) {
                TypeHelper typeHelper = this.mHelper;
                r2 = typeHelper != null ? (PathInfo) typeHelper.transfer(method, 0, pathInfoImpl) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $pathInfo == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.guide.router.GuideOperateObserverRouter.4
                    }));
                }
            }
            IGuideOperateObserver iGuideOperateObserver = this.mObserver;
            if (iGuideOperateObserver != null) {
                return iGuideOperateObserver.onUpdateMainNaviPath(r2);
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }
}
