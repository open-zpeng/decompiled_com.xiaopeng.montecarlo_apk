package com.autonavi.gbl.layer;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.layer.impl.CruiseCongestionExtendImpl;
@IntfAuto(target = CruiseCongestionExtendImpl.class, type = BuildType.JCTRL)
/* loaded from: classes.dex */
public class CruiseCongestionExtend {
    private static String PACKAGE = ReflexTool.PN(CruiseCongestionExtend.class);
    private CruiseCongestionExtendImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected void clean() {
    }

    protected CruiseCongestionExtend(long j, boolean z) {
        this(new CruiseCongestionExtendImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(CruiseCongestionExtend.class, this, this.mControl);
        }
    }

    public CruiseCongestionExtend() {
        this(new CruiseCongestionExtendImpl());
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(CruiseCongestionExtend.class, this, this.mControl);
        }
    }

    public CruiseCongestionExtend(CruiseCongestionExtendImpl cruiseCongestionExtendImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(cruiseCongestionExtendImpl);
    }

    private void $constructor(CruiseCongestionExtendImpl cruiseCongestionExtendImpl) {
        if (cruiseCongestionExtendImpl != null) {
            this.mControl = cruiseCongestionExtendImpl;
            this.mTargetId = String.format("CruiseCongestionExtend_%s_%d", String.valueOf(CruiseCongestionExtendImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected CruiseCongestionExtendImpl getControl() {
        return this.mControl;
    }

    public boolean parse(String str) {
        CruiseCongestionExtendImpl cruiseCongestionExtendImpl = this.mControl;
        if (cruiseCongestionExtendImpl != null) {
            return cruiseCongestionExtendImpl.parse(str);
        }
        return false;
    }

    public boolean isEmpty() {
        CruiseCongestionExtendImpl cruiseCongestionExtendImpl = this.mControl;
        if (cruiseCongestionExtendImpl != null) {
            return cruiseCongestionExtendImpl.isEmpty();
        }
        return false;
    }

    public String getString() {
        CruiseCongestionExtendImpl cruiseCongestionExtendImpl = this.mControl;
        if (cruiseCongestionExtendImpl != null) {
            return cruiseCongestionExtendImpl.getString();
        }
        return null;
    }

    public void setMExtend(String str) {
        CruiseCongestionExtendImpl cruiseCongestionExtendImpl = this.mControl;
        if (cruiseCongestionExtendImpl != null) {
            cruiseCongestionExtendImpl.setMExtend(str);
        }
    }

    public String getMExtend() {
        CruiseCongestionExtendImpl cruiseCongestionExtendImpl = this.mControl;
        if (cruiseCongestionExtendImpl != null) {
            return cruiseCongestionExtendImpl.getMExtend();
        }
        return null;
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

    public synchronized void delete() {
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
