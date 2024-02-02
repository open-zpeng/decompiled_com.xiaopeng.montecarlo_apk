package com.autonavi.gbl.aosclient.model;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.EGAOSREQUESTTYPE;
import com.autonavi.gbl.aosclient.model.EGAOSSERVER;
import com.autonavi.gbl.aosclient.model.impl.BLAosRequestTypeImpl;
@IntfAuto(target = BLAosRequestTypeImpl.class, type = BuildType.JCTRL)
/* loaded from: classes.dex */
public class BLAosRequestType {
    private static String PACKAGE = ReflexTool.PN(BLAosRequestType.class);
    private static TypeHelper gTypeHelper = new TypeHelper(PACKAGE);
    private BLAosRequestTypeImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected BLAosRequestType(long j, boolean z) {
        this(new BLAosRequestTypeImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(BLAosRequestType.class, this, this.mControl);
        }
    }

    public BLAosRequestType() {
        this(new BLAosRequestTypeImpl());
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(BLAosRequestType.class, this, this.mControl);
        }
    }

    public BLAosRequestType(BLAosRequestTypeImpl bLAosRequestTypeImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(bLAosRequestTypeImpl);
    }

    private void $constructor(BLAosRequestTypeImpl bLAosRequestTypeImpl) {
        if (bLAosRequestTypeImpl != null) {
            this.mControl = bLAosRequestTypeImpl;
            this.mTargetId = String.format("BLAosRequestType_%s_%d", String.valueOf(BLAosRequestTypeImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected BLAosRequestTypeImpl getControl() {
        return this.mControl;
    }

    public static short[] getString(@EGAOSREQUESTTYPE.EGAOSREQUESTTYPE1 int i) {
        return BLAosRequestTypeImpl.getString(i);
    }

    public static String getString8(@EGAOSREQUESTTYPE.EGAOSREQUESTTYPE1 int i) {
        return BLAosRequestTypeImpl.getString8(i);
    }

    @EGAOSSERVER.EGAOSSERVER1
    public static int getServerByReqType(@EGAOSREQUESTTYPE.EGAOSREQUESTTYPE1 int i) {
        return BLAosRequestTypeImpl.getServerByReqType(i);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.model.BLAosRequestType.1
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
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.model.BLAosRequestType.2
        }));
    }

    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.model.BLAosRequestType.3
        }));
        if (!this.mHasDestroy) {
            onDestroy();
        }
        if (this.mTypeHelper != null) {
            TypeHelper typeHelper = this.mTypeHelper;
            TypeHelper.unbindAllTarget(PACKAGE, this);
        }
        if (this.mControl != null) {
            ReflexTool.invokeDeclMethodSafe(this.mControl, RequestParameters.SUBRESOURCE_DELETE, null, null);
            this.mControl = null;
        }
        unbind();
    }
}
