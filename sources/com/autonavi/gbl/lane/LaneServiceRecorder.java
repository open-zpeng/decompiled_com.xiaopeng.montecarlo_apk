package com.autonavi.gbl.lane;

import com.autonavi.auto.intfauto.BuildType;
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

    protected void clean() {
    }

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
