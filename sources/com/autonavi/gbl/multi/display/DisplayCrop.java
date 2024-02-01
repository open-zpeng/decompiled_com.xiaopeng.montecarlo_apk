package com.autonavi.gbl.multi.display;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.multi.display.impl.IDisplayCropImpl;
import com.autonavi.gbl.servicemanager.model.BusBusinessType;
@IntfAuto(target = IDisplayCropImpl.class, type = BuildType.JCTRL)
/* loaded from: classes2.dex */
public class DisplayCrop {
    private static String PACKAGE = ReflexTool.PN(DisplayCrop.class);
    private IDisplayCropImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected void clean() {
    }

    protected DisplayCrop(long j, boolean z) {
        this(new IDisplayCropImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(DisplayCrop.class, this, this.mControl);
        }
    }

    public DisplayCrop(IDisplayCropImpl iDisplayCropImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iDisplayCropImpl);
    }

    private void $constructor(IDisplayCropImpl iDisplayCropImpl) {
        if (iDisplayCropImpl != null) {
            this.mControl = iDisplayCropImpl;
            this.mTargetId = String.format("DisplayCrop_%s_%d", String.valueOf(IDisplayCropImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected IDisplayCropImpl getControl() {
        return this.mControl;
    }

    public void openMode() {
        IDisplayCropImpl iDisplayCropImpl = this.mControl;
        if (iDisplayCropImpl != null) {
            iDisplayCropImpl.openMode();
        }
    }

    public void showMapAllContent(boolean z) {
        IDisplayCropImpl iDisplayCropImpl = this.mControl;
        if (iDisplayCropImpl != null) {
            iDisplayCropImpl.showMapAllContent(z);
        }
    }

    public void showMapRealCity(boolean z) {
        IDisplayCropImpl iDisplayCropImpl = this.mControl;
        if (iDisplayCropImpl != null) {
            iDisplayCropImpl.showMapRealCity(z);
        }
    }

    public void setMapCallbackEnable(boolean z, boolean z2) {
        IDisplayCropImpl iDisplayCropImpl = this.mControl;
        if (iDisplayCropImpl != null) {
            iDisplayCropImpl.setMapCallbackEnable(z, z2);
        }
    }

    public void enableAllVirtualBuses(boolean z) {
        IDisplayCropImpl iDisplayCropImpl = this.mControl;
        if (iDisplayCropImpl != null) {
            iDisplayCropImpl.enableAllVirtualBuses(z);
        }
    }

    public void enableVirtualBus(@BusBusinessType.BusBusinessType1 int i, boolean z) {
        IDisplayCropImpl iDisplayCropImpl = this.mControl;
        if (iDisplayCropImpl != null) {
            iDisplayCropImpl.enableVirtualBus(i, z);
        }
    }

    public void setLayerCollisionEnable(boolean z) {
        IDisplayCropImpl iDisplayCropImpl = this.mControl;
        if (iDisplayCropImpl != null) {
            iDisplayCropImpl.setLayerCollisionEnable(z);
        }
    }

    public void addGuideRouteObByCarControl() {
        IDisplayCropImpl iDisplayCropImpl = this.mControl;
        if (iDisplayCropImpl != null) {
            iDisplayCropImpl.addGuideRouteObByCarControl();
        }
    }

    public void removeGuideRouteObByCarControl() {
        IDisplayCropImpl iDisplayCropImpl = this.mControl;
        if (iDisplayCropImpl != null) {
            iDisplayCropImpl.removeGuideRouteObByCarControl();
        }
    }

    public void addMapViewObByFlyLineControl() {
        IDisplayCropImpl iDisplayCropImpl = this.mControl;
        if (iDisplayCropImpl != null) {
            iDisplayCropImpl.addMapViewObByFlyLineControl();
        }
    }

    public void removeMapViewObByFlyLineControl() {
        IDisplayCropImpl iDisplayCropImpl = this.mControl;
        if (iDisplayCropImpl != null) {
            iDisplayCropImpl.removeMapViewObByFlyLineControl();
        }
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
