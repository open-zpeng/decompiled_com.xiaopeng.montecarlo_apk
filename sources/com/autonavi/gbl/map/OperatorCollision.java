package com.autonavi.gbl.map;

import android.util.Log;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.map.impl.ICollisionEntityImpl;
import com.autonavi.gbl.map.impl.OperatorCollisionImpl;
import com.autonavi.gbl.map.observer.ICollisionEntity;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;
@IntfAuto(target = OperatorCollisionImpl.class, type = BuildType.JCTRL)
/* loaded from: classes2.dex */
public class OperatorCollision {
    private static String PACKAGE = ReflexTool.PN(OperatorCollision.class);
    private OperatorCollisionImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected OperatorCollision(long j, boolean z) {
        this(new OperatorCollisionImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(OperatorCollision.class, this, this.mControl);
        }
    }

    public OperatorCollision(OperatorCollisionImpl operatorCollisionImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(operatorCollisionImpl);
    }

    private void $constructor(OperatorCollisionImpl operatorCollisionImpl) {
        if (operatorCollisionImpl != null) {
            this.mControl = operatorCollisionImpl;
            this.mTargetId = String.format("OperatorCollision_%s_%d", String.valueOf(OperatorCollisionImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected OperatorCollisionImpl getControl() {
        return this.mControl;
    }

    public boolean addEntity(ICollisionEntity iCollisionEntity) {
        try {
            Method method = OperatorCollision.class.getMethod("addEntity", ICollisionEntity.class);
            if (iCollisionEntity != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r2 = typeHelper != null ? (ICollisionEntityImpl) typeHelper.transfer(method, 0, iCollisionEntity) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $entity == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.OperatorCollision.1
                    }));
                    return false;
                }
            }
            OperatorCollisionImpl operatorCollisionImpl = this.mControl;
            if (operatorCollisionImpl != null) {
                return operatorCollisionImpl.addEntity(r2);
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    public boolean removeEntity(ICollisionEntity iCollisionEntity) {
        try {
            Method method = OperatorCollision.class.getMethod("removeEntity", ICollisionEntity.class);
            if (iCollisionEntity != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r2 = typeHelper != null ? (ICollisionEntityImpl) typeHelper.transfer(method, 0, iCollisionEntity) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $entity == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.OperatorCollision.2
                    }));
                    return false;
                }
            }
            OperatorCollisionImpl operatorCollisionImpl = this.mControl;
            if (operatorCollisionImpl != null) {
                boolean removeEntity = operatorCollisionImpl.removeEntity(r2);
                TypeHelper typeHelper2 = this.mTypeHelper;
                if (typeHelper2 != null) {
                    typeHelper2.unbind(method, 0, iCollisionEntity);
                }
                return removeEntity;
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    public void initCalculate() {
        OperatorCollisionImpl operatorCollisionImpl = this.mControl;
        if (operatorCollisionImpl != null) {
            operatorCollisionImpl.initCalculate();
        }
    }

    public void calculate() {
        OperatorCollisionImpl operatorCollisionImpl = this.mControl;
        if (operatorCollisionImpl != null) {
            operatorCollisionImpl.calculate();
        }
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.OperatorCollision.3
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
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.OperatorCollision.4
        }));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            Iterator it = ((HashSet) typeHelper.getBindSet("com.autonavi.gbl.map.observer.ICollisionEntity")).iterator();
            while (it.hasNext()) {
                removeEntity((ICollisionEntity) it.next());
            }
        }
    }

    protected synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.map.OperatorCollision.5
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
