package com.autonavi.gbl.map;

import android.util.Log;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.map.impl.CollisionEntityImpl;
import com.autonavi.gbl.map.impl.IOperatorCollisionImpl;
import com.autonavi.gbl.map.observer.ICollisionEntity;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;
@IntfAuto(target = IOperatorCollisionImpl.class, type = BuildType.JCTRL)
/* loaded from: classes2.dex */
public class OperatorCollision {
    private static String PACKAGE = ReflexTool.PN(OperatorCollision.class);
    private IOperatorCollisionImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected OperatorCollision(long j, boolean z) {
        this(new IOperatorCollisionImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(OperatorCollision.class, this, this.mControl);
        }
    }

    public OperatorCollision(IOperatorCollisionImpl iOperatorCollisionImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iOperatorCollisionImpl);
    }

    private void $constructor(IOperatorCollisionImpl iOperatorCollisionImpl) {
        if (iOperatorCollisionImpl != null) {
            this.mControl = iOperatorCollisionImpl;
            this.mTargetId = String.format("OperatorCollision_%s_%d", String.valueOf(IOperatorCollisionImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected IOperatorCollisionImpl getControl() {
        return this.mControl;
    }

    public boolean addEntity(ICollisionEntity iCollisionEntity) {
        TypeHelper typeHelper;
        try {
            Method method = OperatorCollision.class.getMethod("addEntity", ICollisionEntity.class);
            CollisionEntityImpl collisionEntityImpl = null;
            if (iCollisionEntity != null && (typeHelper = this.mTypeHelper) != null) {
                collisionEntityImpl = (CollisionEntityImpl) typeHelper.transfer(method, 0, iCollisionEntity);
            }
            IOperatorCollisionImpl iOperatorCollisionImpl = this.mControl;
            if (iOperatorCollisionImpl != null) {
                return iOperatorCollisionImpl.addEntity(collisionEntityImpl);
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    public boolean removeEntity(ICollisionEntity iCollisionEntity) {
        TypeHelper typeHelper;
        try {
            Method method = OperatorCollision.class.getMethod("removeEntity", ICollisionEntity.class);
            CollisionEntityImpl collisionEntityImpl = null;
            if (iCollisionEntity != null && (typeHelper = this.mTypeHelper) != null) {
                collisionEntityImpl = (CollisionEntityImpl) typeHelper.transfer(method, 0, iCollisionEntity);
            }
            IOperatorCollisionImpl iOperatorCollisionImpl = this.mControl;
            if (iOperatorCollisionImpl != null) {
                boolean removeEntity = iOperatorCollisionImpl.removeEntity(collisionEntityImpl);
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
        IOperatorCollisionImpl iOperatorCollisionImpl = this.mControl;
        if (iOperatorCollisionImpl != null) {
            iOperatorCollisionImpl.initCalculate();
        }
    }

    public void calculate() {
        IOperatorCollisionImpl iOperatorCollisionImpl = this.mControl;
        if (iOperatorCollisionImpl != null) {
            iOperatorCollisionImpl.calculate();
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

    protected void clean() {
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            Iterator it = ((HashSet) typeHelper.getBindSet("com.autonavi.gbl.map.observer.ICollisionEntity")).iterator();
            while (it.hasNext()) {
                removeEntity((ICollisionEntity) it.next());
            }
        }
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
