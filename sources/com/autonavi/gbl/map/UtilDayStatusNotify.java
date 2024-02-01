package com.autonavi.gbl.map;

import android.util.Log;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.map.impl.IDayStatusListenerImpl;
import com.autonavi.gbl.map.impl.IDayStatusSystemUtilImpl;
import com.autonavi.gbl.map.impl.IUtilDayStatusNotifyImpl;
import com.autonavi.gbl.map.model.DAY_STATUS;
import com.autonavi.gbl.map.observer.IDayStatusListener;
import com.autonavi.gbl.map.observer.IDayStatusSystemUtil;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
@IntfAuto(target = IUtilDayStatusNotifyImpl.class, type = BuildType.JCTRL)
/* loaded from: classes2.dex */
public class UtilDayStatusNotify {
    private static String PACKAGE = ReflexTool.PN(UtilDayStatusNotify.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private IUtilDayStatusNotifyImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected UtilDayStatusNotify(long j, boolean z) {
        this(new IUtilDayStatusNotifyImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(UtilDayStatusNotify.class, this, this.mControl);
        }
    }

    public UtilDayStatusNotify(IUtilDayStatusNotifyImpl iUtilDayStatusNotifyImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iUtilDayStatusNotifyImpl);
    }

    private void $constructor(IUtilDayStatusNotifyImpl iUtilDayStatusNotifyImpl) {
        if (iUtilDayStatusNotifyImpl != null) {
            this.mControl = iUtilDayStatusNotifyImpl;
            this.mTargetId = String.format("UtilDayStatusNotify_%s_%d", String.valueOf(IUtilDayStatusNotifyImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected IUtilDayStatusNotifyImpl getControl() {
        return this.mControl;
    }

    public static UtilDayStatusNotify getInstance() {
        TypeHelper typeHelper;
        try {
            Method method = UtilDayStatusNotify.class.getMethod("getInstance", new Class[0]);
            IUtilDayStatusNotifyImpl iUtilDayStatusNotifyImpl = IUtilDayStatusNotifyImpl.getInstance();
            if (iUtilDayStatusNotifyImpl == null || (typeHelper = gTypeHelper) == null) {
                return null;
            }
            return (UtilDayStatusNotify) typeHelper.transfer(method, -1, (Object) iUtilDayStatusNotifyImpl, true);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public void init() {
        IUtilDayStatusNotifyImpl iUtilDayStatusNotifyImpl = this.mControl;
        if (iUtilDayStatusNotifyImpl != null) {
            iUtilDayStatusNotifyImpl.init();
        }
    }

    public void unInit() {
        IUtilDayStatusNotifyImpl iUtilDayStatusNotifyImpl = this.mControl;
        if (iUtilDayStatusNotifyImpl != null) {
            iUtilDayStatusNotifyImpl.unInit();
        }
    }

    public ArrayList<IDayStatusListener> getListeners() {
        ArrayList<IDayStatusListenerImpl> listeners;
        TypeHelper typeHelper;
        try {
            Method method = UtilDayStatusNotify.class.getMethod("getListeners", new Class[0]);
            IUtilDayStatusNotifyImpl iUtilDayStatusNotifyImpl = this.mControl;
            if (iUtilDayStatusNotifyImpl == null || (listeners = iUtilDayStatusNotifyImpl.getListeners()) == null || (typeHelper = this.mTypeHelper) == null) {
                return null;
            }
            return (ArrayList) typeHelper.transfer(method, -1, (ArrayList) listeners, true);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public void setSystemUtil(IDayStatusSystemUtil iDayStatusSystemUtil) {
        HashSet hashSet;
        TypeHelper typeHelper;
        try {
            Method method = UtilDayStatusNotify.class.getMethod("setSystemUtil", IDayStatusSystemUtil.class);
            TypeHelper typeHelper2 = this.mTypeHelper;
            if (typeHelper2 != null) {
                hashSet = (HashSet) typeHelper2.getBindSet(method, 0);
            } else {
                hashSet = new HashSet();
            }
            hashSet.remove(iDayStatusSystemUtil);
            IDayStatusSystemUtilImpl iDayStatusSystemUtilImpl = null;
            if (iDayStatusSystemUtil != null && (typeHelper = this.mTypeHelper) != null) {
                iDayStatusSystemUtilImpl = (IDayStatusSystemUtilImpl) typeHelper.transfer(method, 0, iDayStatusSystemUtil);
            }
            IUtilDayStatusNotifyImpl iUtilDayStatusNotifyImpl = this.mControl;
            if (iUtilDayStatusNotifyImpl != null) {
                iUtilDayStatusNotifyImpl.setSystemUtil(iDayStatusSystemUtilImpl);
                TypeHelper typeHelper3 = this.mTypeHelper;
                if (typeHelper3 != null) {
                    typeHelper3.unbindSet(method, 0, hashSet);
                }
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public boolean addListener(IDayStatusListener iDayStatusListener) {
        TypeHelper typeHelper;
        try {
            Method method = UtilDayStatusNotify.class.getMethod("addListener", IDayStatusListener.class);
            IDayStatusListenerImpl iDayStatusListenerImpl = null;
            if (iDayStatusListener != null && (typeHelper = this.mTypeHelper) != null) {
                iDayStatusListenerImpl = (IDayStatusListenerImpl) typeHelper.transfer(method, 0, iDayStatusListener);
            }
            IUtilDayStatusNotifyImpl iUtilDayStatusNotifyImpl = this.mControl;
            if (iUtilDayStatusNotifyImpl != null) {
                return iUtilDayStatusNotifyImpl.addListener(iDayStatusListenerImpl);
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    public boolean removeListener(IDayStatusListener iDayStatusListener) {
        TypeHelper typeHelper;
        try {
            Method method = UtilDayStatusNotify.class.getMethod("removeListener", IDayStatusListener.class);
            IDayStatusListenerImpl iDayStatusListenerImpl = null;
            if (iDayStatusListener != null && (typeHelper = this.mTypeHelper) != null) {
                iDayStatusListenerImpl = (IDayStatusListenerImpl) typeHelper.transfer(method, 0, iDayStatusListener);
            }
            IUtilDayStatusNotifyImpl iUtilDayStatusNotifyImpl = this.mControl;
            if (iUtilDayStatusNotifyImpl != null) {
                boolean removeListener = iUtilDayStatusNotifyImpl.removeListener(iDayStatusListenerImpl);
                TypeHelper typeHelper2 = this.mTypeHelper;
                if (typeHelper2 != null) {
                    typeHelper2.unbind(method, 0, iDayStatusListener);
                }
                return removeListener;
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    public void start() {
        IUtilDayStatusNotifyImpl iUtilDayStatusNotifyImpl = this.mControl;
        if (iUtilDayStatusNotifyImpl != null) {
            iUtilDayStatusNotifyImpl.start();
        }
    }

    public void stop() {
        IUtilDayStatusNotifyImpl iUtilDayStatusNotifyImpl = this.mControl;
        if (iUtilDayStatusNotifyImpl != null) {
            iUtilDayStatusNotifyImpl.stop();
        }
    }

    @DAY_STATUS.DAY_STATUS1
    public int getDayStatus() {
        IUtilDayStatusNotifyImpl iUtilDayStatusNotifyImpl = this.mControl;
        if (iUtilDayStatusNotifyImpl != null) {
            return iUtilDayStatusNotifyImpl.getDayStatus();
        }
        return Integer.MIN_VALUE;
    }

    public ArrayList getSunTime() {
        IUtilDayStatusNotifyImpl iUtilDayStatusNotifyImpl = this.mControl;
        if (iUtilDayStatusNotifyImpl != null) {
            return iUtilDayStatusNotifyImpl.getSunTime();
        }
        return null;
    }

    public static boolean isNormalDay(@DAY_STATUS.DAY_STATUS1 int i) {
        return IUtilDayStatusNotifyImpl.isNormalDay(i);
    }

    public static boolean isNormalNight(@DAY_STATUS.DAY_STATUS1 int i) {
        return IUtilDayStatusNotifyImpl.isNormalNight(i);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mTypeHelper = null;
        }
    }

    public void onDestroy() {
        this.mHasDestroy = true;
        clean();
    }

    protected void clean() {
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            Iterator it = ((HashSet) typeHelper.getBindSet("com.autonavi.gbl.map.observer.IDayStatusListener")).iterator();
            while (it.hasNext()) {
                removeListener((IDayStatusListener) it.next());
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
