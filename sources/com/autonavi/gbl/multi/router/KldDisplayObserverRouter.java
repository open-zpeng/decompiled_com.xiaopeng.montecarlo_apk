package com.autonavi.gbl.multi.router;

import android.util.Log;
import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.consis.ChannelParcel;
import com.autonavi.gbl.consis.impl.ChannelParcelImpl;
import com.autonavi.gbl.consis.model.CHANNEL_MSG_TYPE;
import com.autonavi.gbl.multi.KldDisplay;
import com.autonavi.gbl.multi.impl.CKldSceneContextImpl;
import com.autonavi.gbl.multi.impl.IKldDisplayCrop;
import com.autonavi.gbl.multi.impl.IKldDisplayImpl;
import com.autonavi.gbl.multi.model.DisplayType;
import com.autonavi.gbl.multi.observer.IKldDisplayObserver;
import com.autonavi.gbl.multi.observer.impl.IKldDisplayObserverImpl;
import java.lang.reflect.Method;
@IntfAuto(target = IKldDisplayObserver.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class KldDisplayObserverRouter extends IKldDisplayObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(KldDisplayObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(KldDisplayObserverRouter.class);
    private TypeHelper mHelper;
    private IKldDisplayObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, IKldDisplayObserver iKldDisplayObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IKldDisplayObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iKldDisplayObserver;
    }

    protected KldDisplayObserverRouter(String str, IKldDisplayObserver iKldDisplayObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iKldDisplayObserver);
    }

    protected KldDisplayObserverRouter(String str, IKldDisplayObserver iKldDisplayObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iKldDisplayObserver);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.router.KldDisplayObserverRouter.1
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
    @Override // com.autonavi.gbl.multi.observer.impl.IKldDisplayObserverImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.router.KldDisplayObserverRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldDisplayObserverImpl
    public void onDisplayCreated(int i, @DisplayType.DisplayType1 int i2) {
        IKldDisplayObserver iKldDisplayObserver = this.mObserver;
        if (iKldDisplayObserver != null) {
            iKldDisplayObserver.onDisplayCreated(i, i2);
        }
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldDisplayObserverImpl
    public void onDisplayCropCustom(IKldDisplayImpl iKldDisplayImpl, IKldDisplayCrop iKldDisplayCrop) {
        try {
            Method method = KldDisplayObserverRouter.class.getMethod("onDisplayCropCustom", IKldDisplayImpl.class, IKldDisplayCrop.class);
            if (iKldDisplayImpl != null) {
                TypeHelper typeHelper = this.mHelper;
                r1 = typeHelper != null ? (KldDisplay) typeHelper.transfer(method, 0, iKldDisplayImpl) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $display == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.router.KldDisplayObserverRouter.3
                    }));
                }
            }
            IKldDisplayObserver iKldDisplayObserver = this.mObserver;
            if (iKldDisplayObserver != null) {
                iKldDisplayObserver.onDisplayCropCustom(r1, iKldDisplayCrop);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldDisplayObserverImpl
    public void onMapFirstPaint(int i, @DisplayType.DisplayType1 int i2) {
        IKldDisplayObserver iKldDisplayObserver = this.mObserver;
        if (iKldDisplayObserver != null) {
            iKldDisplayObserver.onMapFirstPaint(i, i2);
        }
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldDisplayObserverImpl
    public void onMainDisplayCreated(int i) {
        IKldDisplayObserver iKldDisplayObserver = this.mObserver;
        if (iKldDisplayObserver != null) {
            iKldDisplayObserver.onMainDisplayCreated(i);
        }
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldDisplayObserverImpl
    public void beforeSceneContextInit(CKldSceneContextImpl cKldSceneContextImpl) {
        IKldDisplayObserver iKldDisplayObserver = this.mObserver;
        if (iKldDisplayObserver != null) {
            iKldDisplayObserver.beforeSceneContextInit(cKldSceneContextImpl);
        }
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldDisplayObserverImpl
    public void beforeEGLDevCreated(IKldDisplayImpl iKldDisplayImpl) {
        try {
            Method method = KldDisplayObserverRouter.class.getMethod("beforeEGLDevCreated", IKldDisplayImpl.class);
            if (iKldDisplayImpl != null) {
                TypeHelper typeHelper = this.mHelper;
                r1 = typeHelper != null ? (KldDisplay) typeHelper.transfer(method, 0, iKldDisplayImpl) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $display == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.router.KldDisplayObserverRouter.4
                    }));
                }
            }
            IKldDisplayObserver iKldDisplayObserver = this.mObserver;
            if (iKldDisplayObserver != null) {
                iKldDisplayObserver.beforeEGLDevCreated(r1);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldDisplayObserverImpl
    public void beforeEGLMapCreated(IKldDisplayImpl iKldDisplayImpl) {
        try {
            Method method = KldDisplayObserverRouter.class.getMethod("beforeEGLMapCreated", IKldDisplayImpl.class);
            if (iKldDisplayImpl != null) {
                TypeHelper typeHelper = this.mHelper;
                r1 = typeHelper != null ? (KldDisplay) typeHelper.transfer(method, 0, iKldDisplayImpl) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $display == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.router.KldDisplayObserverRouter.5
                    }));
                }
            }
            IKldDisplayObserver iKldDisplayObserver = this.mObserver;
            if (iKldDisplayObserver != null) {
                iKldDisplayObserver.beforeEGLMapCreated(r1);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldDisplayObserverImpl
    public void onMapDoRender(int i, @DisplayType.DisplayType1 int i2) {
        IKldDisplayObserver iKldDisplayObserver = this.mObserver;
        if (iKldDisplayObserver != null) {
            iKldDisplayObserver.onMapDoRender(i, i2);
        }
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldDisplayObserverImpl
    public boolean onCheckSyncAllowed(int i, int i2, int i3) {
        IKldDisplayObserver iKldDisplayObserver = this.mObserver;
        if (iKldDisplayObserver != null) {
            return iKldDisplayObserver.onCheckSyncAllowed(i, i2, i3);
        }
        return false;
    }

    @Override // com.autonavi.gbl.multi.observer.impl.IKldDisplayObserverImpl
    public boolean onProcessCustomInComeMsg(int i, @CHANNEL_MSG_TYPE.CHANNEL_MSG_TYPE1 int i2, int i3, ChannelParcelImpl channelParcelImpl) {
        try {
            Method method = KldDisplayObserverRouter.class.getMethod("onProcessCustomInComeMsg", Integer.TYPE, Integer.TYPE, Integer.TYPE, ChannelParcelImpl.class);
            if (channelParcelImpl != null) {
                TypeHelper typeHelper = this.mHelper;
                r2 = typeHelper != null ? (ChannelParcel) typeHelper.transfer(method, 3, channelParcelImpl) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $data == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.multi.router.KldDisplayObserverRouter.6
                    }));
                }
            }
            IKldDisplayObserver iKldDisplayObserver = this.mObserver;
            if (iKldDisplayObserver != null) {
                return iKldDisplayObserver.onProcessCustomInComeMsg(i, i2, i3, r2);
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }
}
