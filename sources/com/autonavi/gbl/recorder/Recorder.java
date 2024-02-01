package com.autonavi.gbl.recorder;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.recorder.impl.IRecorderImpl;
import com.autonavi.gbl.recorder.model.RecordParam;
@IntfAuto(target = IRecorderImpl.class, type = BuildType.JCTRL)
/* loaded from: classes2.dex */
public class Recorder {
    private static String PACKAGE = ReflexTool.PN(Recorder.class);
    private IRecorderImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected void clean() {
    }

    protected Recorder(long j, boolean z) {
        this(new IRecorderImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(Recorder.class, this, this.mControl);
        }
    }

    public Recorder(IRecorderImpl iRecorderImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iRecorderImpl);
    }

    private void $constructor(IRecorderImpl iRecorderImpl) {
        if (iRecorderImpl != null) {
            this.mControl = iRecorderImpl;
            this.mTargetId = String.format("Recorder_%s_%d", String.valueOf(IRecorderImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected IRecorderImpl getControl() {
        return this.mControl;
    }

    public int setParam(RecordParam recordParam) {
        IRecorderImpl iRecorderImpl = this.mControl;
        if (iRecorderImpl != null) {
            return iRecorderImpl.setParam(recordParam);
        }
        return Integer.MIN_VALUE;
    }

    public RecordParam getParam() {
        IRecorderImpl iRecorderImpl = this.mControl;
        if (iRecorderImpl != null) {
            return iRecorderImpl.getParam();
        }
        return null;
    }

    public int start() {
        IRecorderImpl iRecorderImpl = this.mControl;
        if (iRecorderImpl != null) {
            return iRecorderImpl.start();
        }
        return Integer.MIN_VALUE;
    }

    public int stop() {
        IRecorderImpl iRecorderImpl = this.mControl;
        if (iRecorderImpl != null) {
            return iRecorderImpl.stop();
        }
        return Integer.MIN_VALUE;
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
