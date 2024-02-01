package com.autonavi.gbl.multi.router;

import android.util.Log;
import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.consis.ChannelParcel;
import com.autonavi.gbl.consis.impl.ChannelParcelImpl;
import com.autonavi.gbl.consis.model.ChannelMessageType;
import com.autonavi.gbl.multi.display.Display;
import com.autonavi.gbl.multi.display.DisplayCrop;
import com.autonavi.gbl.multi.display.impl.IDisplayCropImpl;
import com.autonavi.gbl.multi.display.impl.IDisplayImpl;
import com.autonavi.gbl.multi.display.model.DisplayType;
import com.autonavi.gbl.multi.display.observer.IMapDisplayObserver;
import com.autonavi.gbl.multi.display.observer.impl.IMapDisplayObserverImpl;
import java.lang.reflect.Method;
@IntfAuto(target = IMapDisplayObserver.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class MapDisplayObserverRouter extends IMapDisplayObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(MapDisplayObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(MapDisplayObserverRouter.class);
    private TypeHelper mHelper;
    private IMapDisplayObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, IMapDisplayObserver iMapDisplayObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IMapDisplayObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iMapDisplayObserver;
    }

    protected MapDisplayObserverRouter(String str, IMapDisplayObserver iMapDisplayObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iMapDisplayObserver);
    }

    protected MapDisplayObserverRouter(String str, IMapDisplayObserver iMapDisplayObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iMapDisplayObserver);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.multi.display.observer.impl.IMapDisplayObserverImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.multi.display.observer.impl.IMapDisplayObserverImpl
    public void onDisplayCreated(int i, @DisplayType.DisplayType1 int i2) {
        IMapDisplayObserver iMapDisplayObserver = this.mObserver;
        if (iMapDisplayObserver != null) {
            iMapDisplayObserver.onDisplayCreated(i, i2);
        }
    }

    @Override // com.autonavi.gbl.multi.display.observer.impl.IMapDisplayObserverImpl
    public void onDisplayCropCustom(IDisplayImpl iDisplayImpl, IDisplayCropImpl iDisplayCropImpl) {
        TypeHelper typeHelper;
        TypeHelper typeHelper2;
        try {
            Method method = MapDisplayObserverRouter.class.getMethod("onDisplayCropCustom", IDisplayImpl.class, IDisplayCropImpl.class);
            DisplayCrop displayCrop = null;
            Display display = (iDisplayImpl == null || (typeHelper2 = this.mHelper) == null) ? null : (Display) typeHelper2.transfer(method, 0, iDisplayImpl);
            if (iDisplayCropImpl != null && (typeHelper = this.mHelper) != null) {
                displayCrop = (DisplayCrop) typeHelper.transfer(method, 1, iDisplayCropImpl);
            }
            IMapDisplayObserver iMapDisplayObserver = this.mObserver;
            if (iMapDisplayObserver != null) {
                iMapDisplayObserver.onDisplayCropCustom(display, displayCrop);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    @Override // com.autonavi.gbl.multi.display.observer.impl.IMapDisplayObserverImpl
    public void onMapFirstPaint(int i, @DisplayType.DisplayType1 int i2) {
        IMapDisplayObserver iMapDisplayObserver = this.mObserver;
        if (iMapDisplayObserver != null) {
            iMapDisplayObserver.onMapFirstPaint(i, i2);
        }
    }

    @Override // com.autonavi.gbl.multi.display.observer.impl.IMapDisplayObserverImpl
    public void onMainDisplayCreated(int i) {
        IMapDisplayObserver iMapDisplayObserver = this.mObserver;
        if (iMapDisplayObserver != null) {
            iMapDisplayObserver.onMainDisplayCreated(i);
        }
    }

    @Override // com.autonavi.gbl.multi.display.observer.impl.IMapDisplayObserverImpl
    public void beforeEGLDevCreated(IDisplayImpl iDisplayImpl) {
        TypeHelper typeHelper;
        try {
            Method method = MapDisplayObserverRouter.class.getMethod("beforeEGLDevCreated", IDisplayImpl.class);
            Display display = null;
            if (iDisplayImpl != null && (typeHelper = this.mHelper) != null) {
                display = (Display) typeHelper.transfer(method, 0, iDisplayImpl);
            }
            IMapDisplayObserver iMapDisplayObserver = this.mObserver;
            if (iMapDisplayObserver != null) {
                iMapDisplayObserver.beforeEGLDevCreated(display);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    @Override // com.autonavi.gbl.multi.display.observer.impl.IMapDisplayObserverImpl
    public void beforeEGLMapCreated(IDisplayImpl iDisplayImpl) {
        TypeHelper typeHelper;
        try {
            Method method = MapDisplayObserverRouter.class.getMethod("beforeEGLMapCreated", IDisplayImpl.class);
            Display display = null;
            if (iDisplayImpl != null && (typeHelper = this.mHelper) != null) {
                display = (Display) typeHelper.transfer(method, 0, iDisplayImpl);
            }
            IMapDisplayObserver iMapDisplayObserver = this.mObserver;
            if (iMapDisplayObserver != null) {
                iMapDisplayObserver.beforeEGLMapCreated(display);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    @Override // com.autonavi.gbl.multi.display.observer.impl.IMapDisplayObserverImpl
    public void onMapDoRender(int i, @DisplayType.DisplayType1 int i2) {
        IMapDisplayObserver iMapDisplayObserver = this.mObserver;
        if (iMapDisplayObserver != null) {
            iMapDisplayObserver.onMapDoRender(i, i2);
        }
    }

    @Override // com.autonavi.gbl.multi.display.observer.impl.IMapDisplayObserverImpl
    public boolean onCheckSyncAllowed(int i, int i2, int i3) {
        IMapDisplayObserver iMapDisplayObserver = this.mObserver;
        if (iMapDisplayObserver != null) {
            return iMapDisplayObserver.onCheckSyncAllowed(i, i2, i3);
        }
        return false;
    }

    @Override // com.autonavi.gbl.multi.display.observer.impl.IMapDisplayObserverImpl
    public boolean onProcessCustomInComeMsg(int i, @ChannelMessageType.ChannelMessageType1 int i2, int i3, ChannelParcelImpl channelParcelImpl) {
        TypeHelper typeHelper;
        try {
            Method method = MapDisplayObserverRouter.class.getMethod("onProcessCustomInComeMsg", Integer.TYPE, Integer.TYPE, Integer.TYPE, ChannelParcelImpl.class);
            ChannelParcel channelParcel = null;
            if (channelParcelImpl != null && (typeHelper = this.mHelper) != null) {
                channelParcel = (ChannelParcel) typeHelper.transfer(method, 3, channelParcelImpl);
            }
            IMapDisplayObserver iMapDisplayObserver = this.mObserver;
            if (iMapDisplayObserver != null) {
                return iMapDisplayObserver.onProcessCustomInComeMsg(i, i2, i3, channelParcel);
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }
}
