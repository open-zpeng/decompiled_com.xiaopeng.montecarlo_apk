package com.autonavi.gbl.layer;

import android.util.Log;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.layer.impl.IBizCustomControlImpl;
import com.autonavi.gbl.layer.model.BizCustomArrowInfo;
import com.autonavi.gbl.layer.model.BizCustomCircleInfo;
import com.autonavi.gbl.layer.model.BizCustomGradientPolygonInfo;
import com.autonavi.gbl.layer.model.BizCustomLineInfo;
import com.autonavi.gbl.layer.model.BizCustomPlaneInfo;
import com.autonavi.gbl.layer.model.BizCustomPointInfo;
import com.autonavi.gbl.layer.model.BizCustomPolygonInfo;
import com.autonavi.gbl.layer.model.BizCustomTypeArrow;
import com.autonavi.gbl.layer.model.BizCustomTypeCircle;
import com.autonavi.gbl.layer.model.BizCustomTypeLine;
import com.autonavi.gbl.layer.model.BizCustomTypePlane;
import com.autonavi.gbl.layer.model.BizCustomTypePoint;
import com.autonavi.gbl.layer.model.BizCustomTypePolygon;
import com.autonavi.gbl.map.layer.BaseLayer;
import com.autonavi.gbl.map.layer.impl.BaseLayerImpl;
import java.lang.reflect.Method;
import java.util.ArrayList;
@IntfAuto(target = IBizCustomControlImpl.class, type = BuildType.JCTRL)
/* loaded from: classes.dex */
public class BizCustomControl extends BizControl {
    private static String PACKAGE = ReflexTool.PN(BizCustomControl.class);
    private IBizCustomControlImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected BizCustomControl(long j, boolean z) {
        this(new IBizCustomControlImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(BizCustomControl.class, this, this.mControl);
        }
    }

    public BizCustomControl(IBizCustomControlImpl iBizCustomControlImpl) {
        super(iBizCustomControlImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iBizCustomControlImpl);
    }

    private void $constructor(IBizCustomControlImpl iBizCustomControlImpl) {
        if (iBizCustomControlImpl != null) {
            this.mControl = iBizCustomControlImpl;
            this.mTargetId = String.format("BizCustomControl_%s_%d", String.valueOf(IBizCustomControlImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.layer.BizControl
    public IBizCustomControlImpl getControl() {
        return this.mControl;
    }

    public void updateCustomPoint(ArrayList<BizCustomPointInfo> arrayList, @BizCustomTypePoint.BizCustomTypePoint1 int i) {
        IBizCustomControlImpl iBizCustomControlImpl = this.mControl;
        if (iBizCustomControlImpl != null) {
            iBizCustomControlImpl.updateCustomPoint(arrayList, i);
        }
    }

    public void addCustomPoint(ArrayList<BizCustomPointInfo> arrayList, @BizCustomTypePoint.BizCustomTypePoint1 int i) {
        IBizCustomControlImpl iBizCustomControlImpl = this.mControl;
        if (iBizCustomControlImpl != null) {
            iBizCustomControlImpl.addCustomPoint(arrayList, i);
        }
    }

    public void updateCustomLine(ArrayList<BizCustomLineInfo> arrayList, @BizCustomTypeLine.BizCustomTypeLine1 int i) {
        IBizCustomControlImpl iBizCustomControlImpl = this.mControl;
        if (iBizCustomControlImpl != null) {
            iBizCustomControlImpl.updateCustomLine(arrayList, i);
        }
    }

    public void addCustomLine(ArrayList<BizCustomLineInfo> arrayList, @BizCustomTypeLine.BizCustomTypeLine1 int i) {
        IBizCustomControlImpl iBizCustomControlImpl = this.mControl;
        if (iBizCustomControlImpl != null) {
            iBizCustomControlImpl.addCustomLine(arrayList, i);
        }
    }

    public void updateCustomPolygon(ArrayList<BizCustomPolygonInfo> arrayList, @BizCustomTypePolygon.BizCustomTypePolygon1 int i) {
        IBizCustomControlImpl iBizCustomControlImpl = this.mControl;
        if (iBizCustomControlImpl != null) {
            iBizCustomControlImpl.updateCustomPolygon(arrayList, i);
        }
    }

    public void addCustomPolygon(ArrayList<BizCustomPolygonInfo> arrayList, @BizCustomTypePolygon.BizCustomTypePolygon1 int i) {
        IBizCustomControlImpl iBizCustomControlImpl = this.mControl;
        if (iBizCustomControlImpl != null) {
            iBizCustomControlImpl.addCustomPolygon(arrayList, i);
        }
    }

    public void updateCustomCircle(ArrayList<BizCustomCircleInfo> arrayList, @BizCustomTypeCircle.BizCustomTypeCircle1 int i) {
        IBizCustomControlImpl iBizCustomControlImpl = this.mControl;
        if (iBizCustomControlImpl != null) {
            iBizCustomControlImpl.updateCustomCircle(arrayList, i);
        }
    }

    public void addCustomCircle(ArrayList<BizCustomCircleInfo> arrayList, @BizCustomTypeCircle.BizCustomTypeCircle1 int i) {
        IBizCustomControlImpl iBizCustomControlImpl = this.mControl;
        if (iBizCustomControlImpl != null) {
            iBizCustomControlImpl.addCustomCircle(arrayList, i);
        }
    }

    public void updateCustomArrow(ArrayList<BizCustomArrowInfo> arrayList, @BizCustomTypeArrow.BizCustomTypeArrow1 int i) {
        IBizCustomControlImpl iBizCustomControlImpl = this.mControl;
        if (iBizCustomControlImpl != null) {
            iBizCustomControlImpl.updateCustomArrow(arrayList, i);
        }
    }

    public void addCustomArrow(ArrayList<BizCustomArrowInfo> arrayList, @BizCustomTypeArrow.BizCustomTypeArrow1 int i) {
        IBizCustomControlImpl iBizCustomControlImpl = this.mControl;
        if (iBizCustomControlImpl != null) {
            iBizCustomControlImpl.addCustomArrow(arrayList, i);
        }
    }

    public void updateCustomPlane(ArrayList<BizCustomPlaneInfo> arrayList, @BizCustomTypePlane.BizCustomTypePlane1 int i) {
        IBizCustomControlImpl iBizCustomControlImpl = this.mControl;
        if (iBizCustomControlImpl != null) {
            iBizCustomControlImpl.updateCustomPlane(arrayList, i);
        }
    }

    public void addCustomPlane(ArrayList<BizCustomPlaneInfo> arrayList, @BizCustomTypePlane.BizCustomTypePlane1 int i) {
        IBizCustomControlImpl iBizCustomControlImpl = this.mControl;
        if (iBizCustomControlImpl != null) {
            iBizCustomControlImpl.addCustomPlane(arrayList, i);
        }
    }

    public void updateCustomGradientPolygon(ArrayList<BizCustomGradientPolygonInfo> arrayList, @BizCustomTypePolygon.BizCustomTypePolygon1 int i) {
        IBizCustomControlImpl iBizCustomControlImpl = this.mControl;
        if (iBizCustomControlImpl != null) {
            iBizCustomControlImpl.updateCustomGradientPolygon(arrayList, i);
        }
    }

    public void addCustomGradientPolygon(ArrayList<BizCustomGradientPolygonInfo> arrayList, @BizCustomTypePolygon.BizCustomTypePolygon1 int i) {
        IBizCustomControlImpl iBizCustomControlImpl = this.mControl;
        if (iBizCustomControlImpl != null) {
            iBizCustomControlImpl.addCustomGradientPolygon(arrayList, i);
        }
    }

    public BaseLayer getCustomLayer(long j) {
        BaseLayerImpl customLayer;
        TypeHelper typeHelper;
        try {
            Method method = BizCustomControl.class.getMethod("getCustomLayer", Long.TYPE);
            IBizCustomControlImpl iBizCustomControlImpl = this.mControl;
            if (iBizCustomControlImpl == null || (customLayer = iBizCustomControlImpl.getCustomLayer(j)) == null || (typeHelper = this.mTypeHelper) == null) {
                return null;
            }
            return (BaseLayer) typeHelper.transfer(method, -1, (Object) customLayer, true);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.layer.BizControl
    public void unbind() {
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mTypeHelper = null;
        }
        super.unbind();
    }

    @Override // com.autonavi.gbl.layer.BizControl
    public void onDestroy() {
        this.mHasDestroy = true;
        clean();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.layer.BizControl
    public void clean() {
        super.clean();
    }

    @Override // com.autonavi.gbl.layer.BizControl
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
