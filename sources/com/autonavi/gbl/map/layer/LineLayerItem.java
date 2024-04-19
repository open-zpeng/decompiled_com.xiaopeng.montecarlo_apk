package com.autonavi.gbl.map.layer;

import android.util.Log;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.map.layer.impl.LayerItemImpl;
import com.autonavi.gbl.map.layer.impl.LineLayerItemImpl;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.LineLayerItemStyle;
import com.autonavi.gbl.map.layer.observer.ILineLayerItem;
import com.autonavi.gbl.map.router.LineLayerItemRouter;
import java.lang.reflect.Method;
import java.util.ArrayList;
@IntfAuto(target = LineLayerItemRouter.class, type = BuildType.JOBIMPL)
/* loaded from: classes2.dex */
public class LineLayerItem extends LayerItem implements ILineLayerItem {
    private static String PACKAGE = ReflexTool.PN(LineLayerItem.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private boolean mHasDestroy;
    private LineLayerItemImpl mService;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected LineLayerItem(long j, boolean z) {
        this(new LineLayerItemRouter("LineLayerItem", null, j, z));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{ILineLayerItem.class}, new Object[]{this});
    }

    public LineLayerItem() {
        this(new LineLayerItemRouter("LineLayerItem", null));
        ReflexTool.invokeDeclMethodSafe(this.mService, "bindObserver", new Class[]{ILineLayerItem.class}, new Object[]{this});
    }

    public LineLayerItem(LineLayerItemImpl lineLayerItemImpl) {
        super(lineLayerItemImpl);
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mService = null;
        this.mHasDestroy = false;
        $constructor(lineLayerItemImpl);
    }

    private void $constructor(LineLayerItemImpl lineLayerItemImpl) {
        if (lineLayerItemImpl != null) {
            this.mService = lineLayerItemImpl;
            this.mTargetId = String.format("LineLayerItem_%s_%d", String.valueOf(LineLayerItemImpl.getCPtr(this.mService)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    @Override // com.autonavi.gbl.map.layer.LayerItem
    public LineLayerItemImpl getService() {
        return this.mService;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.LayerItem
    public void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.layer.LineLayerItem.1
        });
        objArr[1] = String.valueOf(this.mTypeHelper != null);
        DebugTool.d("%s: mTypeHelper=%s", objArr);
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mTypeHelper = null;
        }
        super.unbind();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.LayerItem
    public void clean() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.layer.LineLayerItem.2
        }));
        super.clean();
    }

    @Override // com.autonavi.gbl.map.layer.LayerItem
    public void onDestroy() {
        this.mHasDestroy = true;
        clean();
    }

    @Override // com.autonavi.gbl.map.layer.LayerItem
    public synchronized void delete() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.layer.LineLayerItem.3
        });
        objArr[1] = String.valueOf(this.mService != null);
        DebugTool.d("%s: mService=%s", objArr);
        if (!this.mHasDestroy) {
            onDestroy();
        }
        if (this.mService != null) {
            if (this.mTypeHelper != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                TypeHelper.unbindAllTarget(ReflexTool.PN(this.mService.getClass()), this.mService);
            }
            this.mService = null;
        }
        unbind();
    }

    public static String getClassTypeName() {
        return LineLayerItemImpl.getClassTypeName();
    }

    public void setPoints(ArrayList<Coord3DDouble> arrayList) {
        LineLayerItemImpl lineLayerItemImpl = this.mService;
        if (lineLayerItemImpl != null) {
            lineLayerItemImpl.$explicit_setPoints(arrayList);
        }
    }

    public void setColor(long j, long j2) {
        LineLayerItemImpl lineLayerItemImpl = this.mService;
        if (lineLayerItemImpl != null) {
            lineLayerItemImpl.$explicit_setColor(j, j2);
        }
    }

    public void setWidth(int i, int i2) {
        LineLayerItemImpl lineLayerItemImpl = this.mService;
        if (lineLayerItemImpl != null) {
            lineLayerItemImpl.$explicit_setWidth(i, i2);
        }
    }

    @Override // com.autonavi.gbl.map.layer.LayerItem
    public void updateStyle() {
        LineLayerItemImpl lineLayerItemImpl = this.mService;
        if (lineLayerItemImpl != null) {
            lineLayerItemImpl.$explicit_updateStyle();
        }
    }

    @Override // com.autonavi.gbl.map.layer.LayerItem
    public void updateStyle(LayerItem layerItem) {
        try {
            Method method = LineLayerItem.class.getMethod("updateStyle", LayerItem.class);
            if (layerItem != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r1 = typeHelper != null ? (LayerItemImpl) typeHelper.transfer(method, 0, layerItem) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $pItem == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.layer.LineLayerItem.4
                    }));
                }
            }
            LineLayerItemImpl lineLayerItemImpl = this.mService;
            if (lineLayerItemImpl != null) {
                lineLayerItemImpl.$explicit_updateStyle(r1);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    @Override // com.autonavi.gbl.map.layer.LayerItem, com.autonavi.gbl.map.layer.observer.ILayerItem, com.autonavi.gbl.map.layer.observer.IArrowLayerItem
    @LayerItemType.LayerItemType1
    public int getItemType() {
        LineLayerItemImpl lineLayerItemImpl = this.mService;
        if (lineLayerItemImpl != null) {
            return lineLayerItemImpl.$explicit_getItemType();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.map.layer.observer.ILineLayerItem
    public LineLayerItemStyle getStyle() {
        LineLayerItemStyle lineLayerItemStyle = new LineLayerItemStyle();
        getStyle(lineLayerItemStyle);
        return lineLayerItemStyle;
    }

    private void getStyle(LineLayerItemStyle lineLayerItemStyle) {
        LineLayerItemImpl lineLayerItemImpl = this.mService;
        if (lineLayerItemImpl != null) {
            lineLayerItemImpl.$explicit_getStyle(lineLayerItemStyle);
        }
    }
}
