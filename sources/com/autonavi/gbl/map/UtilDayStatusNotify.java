package com.autonavi.gbl.map;

import android.util.Log;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.map.impl.IDayStatusListenerImpl;
import com.autonavi.gbl.map.impl.IDayStatusSystemUtilImpl;
import com.autonavi.gbl.map.impl.UtilDayStatusNotifyImpl;
import com.autonavi.gbl.map.model.DAY_STATUS;
import com.autonavi.gbl.map.observer.IDayStatusListener;
import com.autonavi.gbl.map.observer.IDayStatusSystemUtil;
import com.autonavi.gbl.util.model.DateTime;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
@IntfAuto(target = UtilDayStatusNotifyImpl.class, type = BuildType.JCTRL)
/* loaded from: classes2.dex */
public class UtilDayStatusNotify {
    private static String PACKAGE = ReflexTool.PN(UtilDayStatusNotify.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private UtilDayStatusNotifyImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected UtilDayStatusNotify(long j, boolean z) {
        this(new UtilDayStatusNotifyImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(UtilDayStatusNotify.class, this, this.mControl);
        }
    }

    public UtilDayStatusNotify(UtilDayStatusNotifyImpl utilDayStatusNotifyImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(utilDayStatusNotifyImpl);
    }

    private void $constructor(UtilDayStatusNotifyImpl utilDayStatusNotifyImpl) {
        if (utilDayStatusNotifyImpl != null) {
            this.mControl = utilDayStatusNotifyImpl;
            this.mTargetId = String.format("UtilDayStatusNotify_%s_%d", String.valueOf(UtilDayStatusNotifyImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected UtilDayStatusNotifyImpl getControl() {
        return this.mControl;
    }

    public static UtilDayStatusNotify getInstance() {
        try {
            Method method = UtilDayStatusNotify.class.getMethod("getInstance", new Class[0]);
            UtilDayStatusNotifyImpl utilDayStatusNotifyImpl = UtilDayStatusNotifyImpl.getInstance();
            if (utilDayStatusNotifyImpl != null) {
                TypeHelper typeHelper = gTypeHelper;
                r0 = typeHelper != null ? (UtilDayStatusNotify) typeHelper.transfer(method, -1, (Object) utilDayStatusNotifyImpl, true) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.UtilDayStatusNotify.1
                    }));
                }
            }
            return r0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public void init() {
        UtilDayStatusNotifyImpl utilDayStatusNotifyImpl = this.mControl;
        if (utilDayStatusNotifyImpl != null) {
            utilDayStatusNotifyImpl.init();
        }
    }

    public void unInit() {
        UtilDayStatusNotifyImpl utilDayStatusNotifyImpl = this.mControl;
        if (utilDayStatusNotifyImpl != null) {
            utilDayStatusNotifyImpl.unInit();
        }
    }

    public ArrayList<IDayStatusListener> getListeners() {
        ArrayList<IDayStatusListenerImpl> listeners;
        try {
            Method method = UtilDayStatusNotify.class.getMethod("getListeners", new Class[0]);
            UtilDayStatusNotifyImpl utilDayStatusNotifyImpl = this.mControl;
            if (utilDayStatusNotifyImpl != null && (listeners = utilDayStatusNotifyImpl.getListeners()) != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r0 = typeHelper != null ? (ArrayList) typeHelper.transfer(method, -1, (ArrayList) listeners, true) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.UtilDayStatusNotify.2
                    }));
                }
            }
            return r0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public void setSystemUtil(IDayStatusSystemUtil iDayStatusSystemUtil) {
        HashSet hashSet;
        try {
            Method method = UtilDayStatusNotify.class.getMethod("setSystemUtil", IDayStatusSystemUtil.class);
            TypeHelper typeHelper = this.mTypeHelper;
            if (typeHelper != null) {
                hashSet = (HashSet) typeHelper.getBindSet(method, 0);
            } else {
                hashSet = new HashSet();
            }
            hashSet.remove(iDayStatusSystemUtil);
            if (iDayStatusSystemUtil != null) {
                TypeHelper typeHelper2 = this.mTypeHelper;
                r3 = typeHelper2 != null ? (IDayStatusSystemUtilImpl) typeHelper2.transfer(method, 0, iDayStatusSystemUtil) : null;
                if (r3 == null) {
                    DebugTool.e("%s: $util == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.UtilDayStatusNotify.3
                    }));
                }
            }
            UtilDayStatusNotifyImpl utilDayStatusNotifyImpl = this.mControl;
            if (utilDayStatusNotifyImpl != null) {
                utilDayStatusNotifyImpl.setSystemUtil(r3);
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
        try {
            Method method = UtilDayStatusNotify.class.getMethod("addListener", IDayStatusListener.class);
            if (iDayStatusListener != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r2 = typeHelper != null ? (IDayStatusListenerImpl) typeHelper.transfer(method, 0, iDayStatusListener) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $pListener == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.UtilDayStatusNotify.4
                    }));
                    return false;
                }
            }
            UtilDayStatusNotifyImpl utilDayStatusNotifyImpl = this.mControl;
            if (utilDayStatusNotifyImpl != null) {
                return utilDayStatusNotifyImpl.addListener(r2);
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    public boolean removeListener(IDayStatusListener iDayStatusListener) {
        try {
            Method method = UtilDayStatusNotify.class.getMethod("removeListener", IDayStatusListener.class);
            if (iDayStatusListener != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r2 = typeHelper != null ? (IDayStatusListenerImpl) typeHelper.transfer(method, 0, iDayStatusListener) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $pListener == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.UtilDayStatusNotify.5
                    }));
                    return false;
                }
            }
            UtilDayStatusNotifyImpl utilDayStatusNotifyImpl = this.mControl;
            if (utilDayStatusNotifyImpl != null) {
                boolean removeListener = utilDayStatusNotifyImpl.removeListener(r2);
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
        UtilDayStatusNotifyImpl utilDayStatusNotifyImpl = this.mControl;
        if (utilDayStatusNotifyImpl != null) {
            utilDayStatusNotifyImpl.start();
        }
    }

    public void stop() {
        UtilDayStatusNotifyImpl utilDayStatusNotifyImpl = this.mControl;
        if (utilDayStatusNotifyImpl != null) {
            utilDayStatusNotifyImpl.stop();
        }
    }

    @DAY_STATUS.DAY_STATUS1
    public int getDayStatus() {
        UtilDayStatusNotifyImpl utilDayStatusNotifyImpl = this.mControl;
        if (utilDayStatusNotifyImpl != null) {
            return utilDayStatusNotifyImpl.getDayStatus();
        }
        return Integer.MIN_VALUE;
    }

    public boolean getBLDateTime(DateTime dateTime) {
        UtilDayStatusNotifyImpl utilDayStatusNotifyImpl = this.mControl;
        if (utilDayStatusNotifyImpl != null) {
            return utilDayStatusNotifyImpl.getBLDateTime(dateTime);
        }
        return false;
    }

    public static boolean isNormalDay(@DAY_STATUS.DAY_STATUS1 int i) {
        return UtilDayStatusNotifyImpl.isNormalDay(i);
    }

    public static boolean isNormalNight(@DAY_STATUS.DAY_STATUS1 int i) {
        return UtilDayStatusNotifyImpl.isNormalNight(i);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.UtilDayStatusNotify.6
        });
        objArr[1] = String.valueOf(this.mTypeHelper != null);
        DebugTool.d("%s: mTypeHelper=%s", objArr);
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
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.UtilDayStatusNotify.7
        }));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            Iterator it = ((HashSet) typeHelper.getBindSet("com.autonavi.gbl.map.observer.IDayStatusListener")).iterator();
            while (it.hasNext()) {
                removeListener((IDayStatusListener) it.next());
            }
        }
    }

    protected synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.UtilDayStatusNotify.8
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
