package com.autonavi.gbl.layer.creflex;

import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.ICRfxProto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.gbl.map.layer.impl.BaseLayerImpl;
import com.autonavi.gbl.map.layer.impl.MassDataLayerImpl;
import com.autonavi.gbl.map.layer.impl.MassPointLayerImpl;
import com.autonavi.gbl.map.layer.impl.QuadrantLayerImpl;
import com.autonavi.gbl.map.layer.impl.RoutePathLayerImpl;
import com.autonavi.gbl.map.layer.impl.VectorCrossLayerImpl;
/* loaded from: classes.dex */
public class BaseLayerCRfxProto implements ICRfxProto {
    @Override // com.autonavi.auto.intfauto.ICRfxProto
    public String getObjectTypeId(Object obj) {
        String str = obj != null ? (String) ReflexTool.invokeDeclMethodSafe(obj, "getTypeIdName", null, null) : null;
        if (str == null) {
            Object[] objArr = new Object[1];
            objArr[0] = obj == null ? "null" : ReflexTool.PN(obj.getClass());
            DebugTool.e("BaseLayerCRfxProto.getObjectTypeId: typeId = null, inst = %s", objArr);
        }
        return str;
    }

    @Override // com.autonavi.auto.intfauto.ICRfxProto
    public String getClassTypeId(Class cls) {
        String str = cls != null ? (String) ReflexTool.invokeDeclMethodSafe(cls, "getClassTypeName", null, null) : null;
        if (str == null) {
            Object[] objArr = new Object[1];
            objArr[0] = cls == null ? "null" : ReflexTool.PN(cls);
            DebugTool.e("BaseLayerCRfxProto.getClassTypeId: typeId = null, cls = %s", objArr);
        }
        return str;
    }

    @Override // com.autonavi.auto.intfauto.ICRfxProto
    public Class[] getRelatedClassList() {
        return new Class[]{BaseLayerImpl.class, MassDataLayerImpl.class, MassPointLayerImpl.class, QuadrantLayerImpl.class, RoutePathLayerImpl.class, VectorCrossLayerImpl.class};
    }
}
