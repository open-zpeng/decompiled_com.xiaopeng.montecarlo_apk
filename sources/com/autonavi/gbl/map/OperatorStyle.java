package com.autonavi.gbl.map;

import android.util.Log;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.map.impl.OperatorStyleImpl;
import com.autonavi.gbl.map.model.MapColorParam;
import com.autonavi.gbl.map.model.MapStyleParam;
import com.autonavi.gbl.map.model.MapStylesSetType;
import com.autonavi.gbl.map.observer.IMapStyleSwitchObserver;
import com.autonavi.gbl.map.observer.impl.IMapStyleSwitchObserverImpl;
import java.lang.reflect.Method;
@IntfAuto(target = OperatorStyleImpl.class, type = BuildType.JCTRL)
/* loaded from: classes.dex */
public class OperatorStyle {
    private static String PACKAGE = ReflexTool.PN(OperatorStyle.class);
    private OperatorStyleImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected OperatorStyle(long j, boolean z) {
        this(new OperatorStyleImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(OperatorStyle.class, this, this.mControl);
        }
    }

    public OperatorStyle(OperatorStyleImpl operatorStyleImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(operatorStyleImpl);
    }

    private void $constructor(OperatorStyleImpl operatorStyleImpl) {
        if (operatorStyleImpl != null) {
            this.mControl = operatorStyleImpl;
            this.mTargetId = String.format("OperatorStyle_%s_%d", String.valueOf(OperatorStyleImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected OperatorStyleImpl getControl() {
        return this.mControl;
    }

    public boolean setMapStyle(MapStyleParam mapStyleParam, boolean z) {
        OperatorStyleImpl operatorStyleImpl = this.mControl;
        if (operatorStyleImpl != null) {
            return operatorStyleImpl.setMapStyle(mapStyleParam, z);
        }
        return false;
    }

    public boolean setBusRoutePreview(boolean z) {
        OperatorStyleImpl operatorStyleImpl = this.mControl;
        if (operatorStyleImpl != null) {
            return operatorStyleImpl.setBusRoutePreview(z);
        }
        return false;
    }

    public int getMapStyleMode() {
        OperatorStyleImpl operatorStyleImpl = this.mControl;
        if (operatorStyleImpl != null) {
            return operatorStyleImpl.getMapStyleMode();
        }
        return 0;
    }

    public int getMapStyleTime() {
        OperatorStyleImpl operatorStyleImpl = this.mControl;
        if (operatorStyleImpl != null) {
            return operatorStyleImpl.getMapStyleTime();
        }
        return 0;
    }

    public int getMapStyleState() {
        OperatorStyleImpl operatorStyleImpl = this.mControl;
        if (operatorStyleImpl != null) {
            return operatorStyleImpl.getMapStyleState();
        }
        return 0;
    }

    public MapStyleParam getMapStyle() {
        OperatorStyleImpl operatorStyleImpl = this.mControl;
        if (operatorStyleImpl != null) {
            return operatorStyleImpl.getMapStyle();
        }
        return null;
    }

    public void setRestoreMapStyle(MapStyleParam mapStyleParam) {
        OperatorStyleImpl operatorStyleImpl = this.mControl;
        if (operatorStyleImpl != null) {
            operatorStyleImpl.setRestoreMapStyle(mapStyleParam);
        }
    }

    public MapStyleParam getRestoreMapStyle() {
        OperatorStyleImpl operatorStyleImpl = this.mControl;
        if (operatorStyleImpl != null) {
            return operatorStyleImpl.getRestoreMapStyle();
        }
        return null;
    }

    public boolean isSkinExist(int i, int i2, int i3) {
        OperatorStyleImpl operatorStyleImpl = this.mControl;
        if (operatorStyleImpl != null) {
            return operatorStyleImpl.isSkinExist(i, i2, i3);
        }
        return false;
    }

    public void setSkyTexture(byte[] bArr) {
        if (bArr != null && bArr.length == 0) {
            bArr = null;
        }
        OperatorStyleImpl operatorStyleImpl = this.mControl;
        if (operatorStyleImpl != null) {
            operatorStyleImpl.setSkyTexture(bArr);
        }
    }

    public void setMapBoardTexture(byte[] bArr) {
        if (bArr != null && bArr.length == 0) {
            bArr = null;
        }
        OperatorStyleImpl operatorStyleImpl = this.mControl;
        if (operatorStyleImpl != null) {
            operatorStyleImpl.setMapBoardTexture(bArr);
        }
    }

    public void setBackgroundColor(MapColorParam mapColorParam) {
        OperatorStyleImpl operatorStyleImpl = this.mControl;
        if (operatorStyleImpl != null) {
            operatorStyleImpl.setBackgroundColor(mapColorParam);
        }
    }

    public MapColorParam getBackgroundColor() {
        OperatorStyleImpl operatorStyleImpl = this.mControl;
        if (operatorStyleImpl != null) {
            return operatorStyleImpl.getBackgroundColor();
        }
        return null;
    }

    public void setMaskColor(MapColorParam mapColorParam) {
        OperatorStyleImpl operatorStyleImpl = this.mControl;
        if (operatorStyleImpl != null) {
            operatorStyleImpl.setMaskColor(mapColorParam);
        }
    }

    public void setStyleParam(@MapStylesSetType.MapStylesSetType1 int i, boolean z) {
        OperatorStyleImpl operatorStyleImpl = this.mControl;
        if (operatorStyleImpl != null) {
            operatorStyleImpl.setStyleParam(i, z);
        }
    }

    public boolean setMapStylePath(String str) {
        OperatorStyleImpl operatorStyleImpl = this.mControl;
        if (operatorStyleImpl != null) {
            return operatorStyleImpl.setMapStylePath(str);
        }
        return false;
    }

    public void setMapStyleSwitchObserver(IMapStyleSwitchObserver iMapStyleSwitchObserver) {
        try {
            Method method = OperatorStyle.class.getMethod("setMapStyleSwitchObserver", IMapStyleSwitchObserver.class);
            if (iMapStyleSwitchObserver != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r1 = typeHelper != null ? (IMapStyleSwitchObserverImpl) typeHelper.transfer(method, 0, iMapStyleSwitchObserver) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $observer == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.OperatorStyle.1
                    }));
                }
            }
            OperatorStyleImpl operatorStyleImpl = this.mControl;
            if (operatorStyleImpl != null) {
                operatorStyleImpl.setMapStyleSwitchObserver(r1);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public int getMapAssetStyleVersion() {
        OperatorStyleImpl operatorStyleImpl = this.mControl;
        if (operatorStyleImpl != null) {
            return operatorStyleImpl.getMapAssetStyleVersion();
        }
        return 0;
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.OperatorStyle.2
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
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.OperatorStyle.3
        }));
    }

    protected synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.OperatorStyle.4
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
