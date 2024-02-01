package com.autonavi.gbl.multi.display;

import android.util.Log;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.multi.display.impl.IDisplayImpl;
import com.autonavi.gbl.multi.display.impl.IMultiDisplayServiceImpl;
import com.autonavi.gbl.multi.display.model.DisplayCreateParam;
import com.autonavi.gbl.multi.display.model.DisplayType;
import com.autonavi.gbl.multi.display.observer.IRemoteDisplayObserver;
import com.autonavi.gbl.multi.display.observer.impl.IRemoteDisplayObserverImpl;
import com.autonavi.gbl.servicemanager.IService;
import com.autonavi.gbl.util.model.ServiceInitStatus;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
@IntfAuto(target = IMultiDisplayServiceImpl.class, type = BuildType.JCTRL)
/* loaded from: classes2.dex */
public class MultiDisplayService implements IService {
    private static String PACKAGE = ReflexTool.PN(MultiDisplayService.class);
    private IMultiDisplayServiceImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected MultiDisplayService(long j, boolean z) {
        this((IMultiDisplayServiceImpl) ReflexTool.invokeDeclConstructorSafe(IMultiDisplayServiceImpl.class, new Class[]{Long.TYPE, Boolean.TYPE}, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(MultiDisplayService.class, this, this.mControl);
        }
    }

    public MultiDisplayService(IMultiDisplayServiceImpl iMultiDisplayServiceImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iMultiDisplayServiceImpl);
    }

    private void $constructor(IMultiDisplayServiceImpl iMultiDisplayServiceImpl) {
        if (iMultiDisplayServiceImpl != null) {
            this.mControl = iMultiDisplayServiceImpl;
            this.mTargetId = String.format("MultiDisplayService_%s_%d", String.valueOf(IMultiDisplayServiceImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected IMultiDisplayServiceImpl getControl() {
        return this.mControl;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public boolean isRecycled() {
        IMultiDisplayServiceImpl iMultiDisplayServiceImpl = this.mControl;
        if (iMultiDisplayServiceImpl != null) {
            return iMultiDisplayServiceImpl.isRecycled();
        }
        return true;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public long getPtr() {
        IMultiDisplayServiceImpl iMultiDisplayServiceImpl = this.mControl;
        if (iMultiDisplayServiceImpl != null) {
            return iMultiDisplayServiceImpl.getPtr();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onCreate() {
        IMultiDisplayServiceImpl iMultiDisplayServiceImpl = this.mControl;
        if (iMultiDisplayServiceImpl != null) {
            iMultiDisplayServiceImpl.onCreate();
        }
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    @ServiceInitStatus.ServiceInitStatus1
    public int isInit() {
        IMultiDisplayServiceImpl iMultiDisplayServiceImpl = this.mControl;
        if (iMultiDisplayServiceImpl != null) {
            return iMultiDisplayServiceImpl.isInit();
        }
        return Integer.MIN_VALUE;
    }

    public void unInit() {
        IMultiDisplayServiceImpl iMultiDisplayServiceImpl = this.mControl;
        if (iMultiDisplayServiceImpl != null) {
            iMultiDisplayServiceImpl.unInit();
        }
    }

    public Display createDisplay(DisplayCreateParam displayCreateParam) {
        IDisplayImpl createDisplay;
        TypeHelper typeHelper;
        try {
            Method method = MultiDisplayService.class.getMethod("createDisplay", DisplayCreateParam.class);
            IMultiDisplayServiceImpl iMultiDisplayServiceImpl = this.mControl;
            if (iMultiDisplayServiceImpl == null || (createDisplay = iMultiDisplayServiceImpl.createDisplay(displayCreateParam)) == null || (typeHelper = this.mTypeHelper) == null) {
                return null;
            }
            return (Display) typeHelper.transfer(method, -1, (Object) createDisplay, true);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public void destroyDisplay(Display display) {
        TypeHelper typeHelper;
        try {
            Method method = MultiDisplayService.class.getMethod("destroyDisplay", Display.class);
            IDisplayImpl iDisplayImpl = null;
            if (display != null && (typeHelper = this.mTypeHelper) != null) {
                iDisplayImpl = (IDisplayImpl) typeHelper.transfer(method, 0, display);
            }
            IMultiDisplayServiceImpl iMultiDisplayServiceImpl = this.mControl;
            if (iMultiDisplayServiceImpl != null) {
                iMultiDisplayServiceImpl.destroyDisplay(iDisplayImpl);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public Display getDisplay(@DisplayType.DisplayType1 int i) {
        IDisplayImpl display;
        TypeHelper typeHelper;
        try {
            Method method = MultiDisplayService.class.getMethod("getDisplay", Integer.TYPE);
            IMultiDisplayServiceImpl iMultiDisplayServiceImpl = this.mControl;
            if (iMultiDisplayServiceImpl == null || (display = iMultiDisplayServiceImpl.getDisplay(i)) == null || (typeHelper = this.mTypeHelper) == null) {
                return null;
            }
            return (Display) typeHelper.transfer(method, -1, (Object) display, true);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public Display getDisplay(long j) {
        IDisplayImpl display;
        TypeHelper typeHelper;
        try {
            Method method = MultiDisplayService.class.getMethod("getDisplay", Long.TYPE);
            IMultiDisplayServiceImpl iMultiDisplayServiceImpl = this.mControl;
            if (iMultiDisplayServiceImpl == null || (display = iMultiDisplayServiceImpl.getDisplay(j)) == null || (typeHelper = this.mTypeHelper) == null) {
                return null;
            }
            return (Display) typeHelper.transfer(method, -1, (Object) display, true);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public Display getDisplay(String str) {
        IDisplayImpl display;
        TypeHelper typeHelper;
        try {
            Method method = MultiDisplayService.class.getMethod("getDisplay", String.class);
            IMultiDisplayServiceImpl iMultiDisplayServiceImpl = this.mControl;
            if (iMultiDisplayServiceImpl == null || (display = iMultiDisplayServiceImpl.getDisplay(str)) == null || (typeHelper = this.mTypeHelper) == null) {
                return null;
            }
            return (Display) typeHelper.transfer(method, -1, (Object) display, true);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public ArrayList<Display> getAllDisplays() {
        ArrayList<IDisplayImpl> allDisplays;
        TypeHelper typeHelper;
        try {
            Method method = MultiDisplayService.class.getMethod("getAllDisplays", new Class[0]);
            IMultiDisplayServiceImpl iMultiDisplayServiceImpl = this.mControl;
            if (iMultiDisplayServiceImpl == null || (allDisplays = iMultiDisplayServiceImpl.getAllDisplays()) == null || (typeHelper = this.mTypeHelper) == null) {
                return null;
            }
            return (ArrayList) typeHelper.transfer(method, -1, (ArrayList) allDisplays, true);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public boolean addObserver(IRemoteDisplayObserver iRemoteDisplayObserver) {
        TypeHelper typeHelper;
        try {
            Method method = MultiDisplayService.class.getMethod("addObserver", IRemoteDisplayObserver.class);
            IRemoteDisplayObserverImpl iRemoteDisplayObserverImpl = null;
            if (iRemoteDisplayObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iRemoteDisplayObserverImpl = (IRemoteDisplayObserverImpl) typeHelper.transfer(method, 0, iRemoteDisplayObserver);
            }
            IMultiDisplayServiceImpl iMultiDisplayServiceImpl = this.mControl;
            if (iMultiDisplayServiceImpl != null) {
                return iMultiDisplayServiceImpl.addObserver(iRemoteDisplayObserverImpl);
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    public boolean removeObserver(IRemoteDisplayObserver iRemoteDisplayObserver) {
        TypeHelper typeHelper;
        try {
            Method method = MultiDisplayService.class.getMethod("removeObserver", IRemoteDisplayObserver.class);
            IRemoteDisplayObserverImpl iRemoteDisplayObserverImpl = null;
            if (iRemoteDisplayObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iRemoteDisplayObserverImpl = (IRemoteDisplayObserverImpl) typeHelper.transfer(method, 0, iRemoteDisplayObserver);
            }
            IMultiDisplayServiceImpl iMultiDisplayServiceImpl = this.mControl;
            if (iMultiDisplayServiceImpl != null) {
                boolean removeObserver = iMultiDisplayServiceImpl.removeObserver(iRemoteDisplayObserverImpl);
                TypeHelper typeHelper2 = this.mTypeHelper;
                if (typeHelper2 != null) {
                    typeHelper2.unbind(method, 0, iRemoteDisplayObserver);
                }
                return removeObserver;
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
            Iterator it = ((HashSet) typeHelper.getBindSet("com.autonavi.gbl.multi.display.observer.IRemoteDisplayObserver")).iterator();
            while (it.hasNext()) {
                removeObserver((IRemoteDisplayObserver) it.next());
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
