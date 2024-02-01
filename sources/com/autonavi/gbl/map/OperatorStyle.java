package com.autonavi.gbl.map;

import android.util.Log;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.map.impl.IOperatorStyleImpl;
import com.autonavi.gbl.map.model.MapColorParam;
import com.autonavi.gbl.map.model.MapStyleParam;
import com.autonavi.gbl.map.model.MapStylesSetType;
import com.autonavi.gbl.map.observer.IMapStyleSwitchObserver;
import com.autonavi.gbl.map.observer.impl.IMapStyleSwitchObserverImpl;
import java.lang.reflect.Method;
@IntfAuto(target = IOperatorStyleImpl.class, type = BuildType.JCTRL)
/* loaded from: classes2.dex */
public class OperatorStyle {
    private static String PACKAGE = ReflexTool.PN(OperatorStyle.class);
    private IOperatorStyleImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected void clean() {
    }

    protected OperatorStyle(long j, boolean z) {
        this(new IOperatorStyleImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(OperatorStyle.class, this, this.mControl);
        }
    }

    public OperatorStyle(IOperatorStyleImpl iOperatorStyleImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iOperatorStyleImpl);
    }

    private void $constructor(IOperatorStyleImpl iOperatorStyleImpl) {
        if (iOperatorStyleImpl != null) {
            this.mControl = iOperatorStyleImpl;
            this.mTargetId = String.format("OperatorStyle_%s_%d", String.valueOf(IOperatorStyleImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected IOperatorStyleImpl getControl() {
        return this.mControl;
    }

    public boolean setMapStyle(MapStyleParam mapStyleParam, boolean z) {
        IOperatorStyleImpl iOperatorStyleImpl = this.mControl;
        if (iOperatorStyleImpl != null) {
            return iOperatorStyleImpl.setMapStyle(mapStyleParam, z);
        }
        return false;
    }

    public boolean setBusRoutePreview(boolean z) {
        IOperatorStyleImpl iOperatorStyleImpl = this.mControl;
        if (iOperatorStyleImpl != null) {
            return iOperatorStyleImpl.setBusRoutePreview(z);
        }
        return false;
    }

    public int getMapStyleMode() {
        IOperatorStyleImpl iOperatorStyleImpl = this.mControl;
        if (iOperatorStyleImpl != null) {
            return iOperatorStyleImpl.getMapStyleMode();
        }
        return 0;
    }

    public int getMapStyleTime() {
        IOperatorStyleImpl iOperatorStyleImpl = this.mControl;
        if (iOperatorStyleImpl != null) {
            return iOperatorStyleImpl.getMapStyleTime();
        }
        return 0;
    }

    public int getMapStyleState() {
        IOperatorStyleImpl iOperatorStyleImpl = this.mControl;
        if (iOperatorStyleImpl != null) {
            return iOperatorStyleImpl.getMapStyleState();
        }
        return 0;
    }

    public MapStyleParam getMapStyle() {
        IOperatorStyleImpl iOperatorStyleImpl = this.mControl;
        if (iOperatorStyleImpl != null) {
            return iOperatorStyleImpl.getMapStyle();
        }
        return null;
    }

    public void setRestoreMapStyle(MapStyleParam mapStyleParam) {
        IOperatorStyleImpl iOperatorStyleImpl = this.mControl;
        if (iOperatorStyleImpl != null) {
            iOperatorStyleImpl.setRestoreMapStyle(mapStyleParam);
        }
    }

    public MapStyleParam getRestoreMapStyle() {
        IOperatorStyleImpl iOperatorStyleImpl = this.mControl;
        if (iOperatorStyleImpl != null) {
            return iOperatorStyleImpl.getRestoreMapStyle();
        }
        return null;
    }

    public boolean isSkinExist(int i, int i2, int i3) {
        IOperatorStyleImpl iOperatorStyleImpl = this.mControl;
        if (iOperatorStyleImpl != null) {
            return iOperatorStyleImpl.isSkinExist(i, i2, i3);
        }
        return false;
    }

    public void setSkyTexture(byte[] bArr) {
        if (bArr != null && bArr.length == 0) {
            bArr = null;
        }
        IOperatorStyleImpl iOperatorStyleImpl = this.mControl;
        if (iOperatorStyleImpl != null) {
            iOperatorStyleImpl.setSkyTexture(bArr);
        }
    }

    public void setMapBoardTexture(byte[] bArr) {
        if (bArr != null && bArr.length == 0) {
            bArr = null;
        }
        IOperatorStyleImpl iOperatorStyleImpl = this.mControl;
        if (iOperatorStyleImpl != null) {
            iOperatorStyleImpl.setMapBoardTexture(bArr);
        }
    }

    public void setBackgroundColor(MapColorParam mapColorParam) {
        IOperatorStyleImpl iOperatorStyleImpl = this.mControl;
        if (iOperatorStyleImpl != null) {
            iOperatorStyleImpl.setBackgroundColor(mapColorParam);
        }
    }

    public MapColorParam getBackgroundColor() {
        IOperatorStyleImpl iOperatorStyleImpl = this.mControl;
        if (iOperatorStyleImpl != null) {
            return iOperatorStyleImpl.getBackgroundColor();
        }
        return null;
    }

    public void setMaskColor(MapColorParam mapColorParam) {
        IOperatorStyleImpl iOperatorStyleImpl = this.mControl;
        if (iOperatorStyleImpl != null) {
            iOperatorStyleImpl.setMaskColor(mapColorParam);
        }
    }

    public void setStyleParam(@MapStylesSetType.MapStylesSetType1 int i, boolean z) {
        IOperatorStyleImpl iOperatorStyleImpl = this.mControl;
        if (iOperatorStyleImpl != null) {
            iOperatorStyleImpl.setStyleParam(i, z);
        }
    }

    public boolean setMapStylePath(String str) {
        IOperatorStyleImpl iOperatorStyleImpl = this.mControl;
        if (iOperatorStyleImpl != null) {
            return iOperatorStyleImpl.setMapStylePath(str);
        }
        return false;
    }

    public void setMapStyleSwitchObserver(IMapStyleSwitchObserver iMapStyleSwitchObserver) {
        TypeHelper typeHelper;
        try {
            Method method = OperatorStyle.class.getMethod("setMapStyleSwitchObserver", IMapStyleSwitchObserver.class);
            IMapStyleSwitchObserverImpl iMapStyleSwitchObserverImpl = null;
            if (iMapStyleSwitchObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iMapStyleSwitchObserverImpl = (IMapStyleSwitchObserverImpl) typeHelper.transfer(method, 0, iMapStyleSwitchObserver);
            }
            IOperatorStyleImpl iOperatorStyleImpl = this.mControl;
            if (iOperatorStyleImpl != null) {
                iOperatorStyleImpl.setMapStyleSwitchObserver(iMapStyleSwitchObserverImpl);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public int getMapAssetStyleVersion() {
        IOperatorStyleImpl iOperatorStyleImpl = this.mControl;
        if (iOperatorStyleImpl != null) {
            return iOperatorStyleImpl.getMapAssetStyleVersion();
        }
        return 0;
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
