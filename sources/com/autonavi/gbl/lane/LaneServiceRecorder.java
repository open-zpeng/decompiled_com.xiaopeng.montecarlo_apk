package com.autonavi.gbl.lane;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.lane.impl.ILaneServiceRecorderImpl;
@IntfAuto(target = ILaneServiceRecorderImpl.class, type = BuildType.JCTRL)
/* loaded from: classes.dex */
public class LaneServiceRecorder {
    private static String PACKAGE = ReflexTool.PN(LaneServiceRecorder.class);
    private ILaneServiceRecorderImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected LaneServiceRecorder(long j, boolean z) {
        this(new ILaneServiceRecorderImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(LaneServiceRecorder.class, this, this.mControl);
        }
    }

    public LaneServiceRecorder(ILaneServiceRecorderImpl iLaneServiceRecorderImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iLaneServiceRecorderImpl);
    }

    private void $constructor(ILaneServiceRecorderImpl iLaneServiceRecorderImpl) {
        if (iLaneServiceRecorderImpl != null) {
            this.mControl = iLaneServiceRecorderImpl;
            this.mTargetId = String.format("LaneServiceRecorder_%s_%d", String.valueOf(ILaneServiceRecorderImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected ILaneServiceRecorderImpl getControl() {
        return this.mControl;
    }

    public boolean setAutoDeleteRecord(boolean z, int i, int i2) {
        ILaneServiceRecorderImpl iLaneServiceRecorderImpl = this.mControl;
        if (iLaneServiceRecorderImpl != null) {
            return iLaneServiceRecorderImpl.setAutoDeleteRecord(z, i, i2);
        }
        return false;
    }

    public boolean setRecordPath(String str) {
        ILaneServiceRecorderImpl iLaneServiceRecorderImpl = this.mControl;
        if (iLaneServiceRecorderImpl != null) {
            return iLaneServiceRecorderImpl.setRecordPath(str);
        }
        return false;
    }

    public boolean enableRecordLaneResource(boolean z) {
        ILaneServiceRecorderImpl iLaneServiceRecorderImpl = this.mControl;
        if (iLaneServiceRecorderImpl != null) {
            return iLaneServiceRecorderImpl.enableRecordLaneResource(z);
        }
        return false;
    }

    public boolean startRecord() {
        ILaneServiceRecorderImpl iLaneServiceRecorderImpl = this.mControl;
        if (iLaneServiceRecorderImpl != null) {
            return iLaneServiceRecorderImpl.startRecord();
        }
        return false;
    }

    public boolean stopRecord() {
        ILaneServiceRecorderImpl iLaneServiceRecorderImpl = this.mControl;
        if (iLaneServiceRecorderImpl != null) {
            return iLaneServiceRecorderImpl.stopRecord();
        }
        return false;
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.lane.LaneServiceRecorder.1
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
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.lane.LaneServiceRecorder.2
        }));
    }

    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.lane.LaneServiceRecorder.3
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
