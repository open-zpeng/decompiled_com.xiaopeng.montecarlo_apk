package com.autonavi.gbl.aosclient;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.impl.BLAosDataToolImpl;
@IntfAuto(target = BLAosDataToolImpl.class, type = BuildType.JCTRL)
/* loaded from: classes.dex */
public class BLAosDataTool {
    private static String PACKAGE = ReflexTool.PN(BLAosDataTool.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private BLAosDataToolImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected void clean() {
    }

    protected BLAosDataTool(long j, boolean z) {
        this(new BLAosDataToolImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(BLAosDataTool.class, this, this.mControl);
        }
    }

    public BLAosDataTool() {
        this(new BLAosDataToolImpl());
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(BLAosDataTool.class, this, this.mControl);
        }
    }

    public BLAosDataTool(BLAosDataToolImpl bLAosDataToolImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(bLAosDataToolImpl);
    }

    private void $constructor(BLAosDataToolImpl bLAosDataToolImpl) {
        if (bLAosDataToolImpl != null) {
            this.mControl = bLAosDataToolImpl;
            this.mTargetId = String.format("BLAosDataTool_%s_%d", String.valueOf(BLAosDataToolImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected BLAosDataToolImpl getControl() {
        return this.mControl;
    }

    public static String getSessionid(String str) {
        return BLAosDataToolImpl.getSessionid(str);
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
