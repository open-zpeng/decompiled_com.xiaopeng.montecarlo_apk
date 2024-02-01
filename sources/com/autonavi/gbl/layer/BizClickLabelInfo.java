package com.autonavi.gbl.layer;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.layer.impl.BizClickLabelInfoImpl;
@IntfAuto(target = BizClickLabelInfoImpl.class, type = BuildType.JCTRL)
/* loaded from: classes.dex */
public class BizClickLabelInfo {
    private static String PACKAGE = ReflexTool.PN(BizClickLabelInfo.class);
    private BizClickLabelInfoImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected void clean() {
    }

    protected BizClickLabelInfo(long j, boolean z) {
        this(new BizClickLabelInfoImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(BizClickLabelInfo.class, this, this.mControl);
        }
    }

    public BizClickLabelInfo() {
        this(new BizClickLabelInfoImpl());
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(BizClickLabelInfo.class, this, this.mControl);
        }
    }

    public BizClickLabelInfo(BizClickLabelInfoImpl bizClickLabelInfoImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(bizClickLabelInfoImpl);
    }

    private void $constructor(BizClickLabelInfoImpl bizClickLabelInfoImpl) {
        if (bizClickLabelInfoImpl != null) {
            this.mControl = bizClickLabelInfoImpl;
            this.mTargetId = String.format("BizClickLabelInfo_%s_%d", String.valueOf(BizClickLabelInfoImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected BizClickLabelInfoImpl getControl() {
        return this.mControl;
    }

    public void reset() {
        BizClickLabelInfoImpl bizClickLabelInfoImpl = this.mControl;
        if (bizClickLabelInfoImpl != null) {
            bizClickLabelInfoImpl.reset();
        }
    }

    public boolean isVaild() {
        BizClickLabelInfoImpl bizClickLabelInfoImpl = this.mControl;
        if (bizClickLabelInfoImpl != null) {
            return bizClickLabelInfoImpl.isVaild();
        }
        return false;
    }

    public void setPosition(Coord3DDouble coord3DDouble) {
        BizClickLabelInfoImpl bizClickLabelInfoImpl = this.mControl;
        if (bizClickLabelInfoImpl != null) {
            bizClickLabelInfoImpl.setPosition(coord3DDouble);
        }
    }

    public Coord3DDouble getPosition() {
        BizClickLabelInfoImpl bizClickLabelInfoImpl = this.mControl;
        if (bizClickLabelInfoImpl != null) {
            return bizClickLabelInfoImpl.getPosition();
        }
        return null;
    }

    public void setName(String str) {
        BizClickLabelInfoImpl bizClickLabelInfoImpl = this.mControl;
        if (bizClickLabelInfoImpl != null) {
            bizClickLabelInfoImpl.setName(str);
        }
    }

    public String getName() {
        BizClickLabelInfoImpl bizClickLabelInfoImpl = this.mControl;
        if (bizClickLabelInfoImpl != null) {
            return bizClickLabelInfoImpl.getName();
        }
        return null;
    }

    public void setMainkey(int i) {
        BizClickLabelInfoImpl bizClickLabelInfoImpl = this.mControl;
        if (bizClickLabelInfoImpl != null) {
            bizClickLabelInfoImpl.setMainkey(i);
        }
    }

    public int getMainkey() {
        BizClickLabelInfoImpl bizClickLabelInfoImpl = this.mControl;
        if (bizClickLabelInfoImpl != null) {
            return bizClickLabelInfoImpl.getMainkey();
        }
        return 0;
    }

    public void setSubkey(int i) {
        BizClickLabelInfoImpl bizClickLabelInfoImpl = this.mControl;
        if (bizClickLabelInfoImpl != null) {
            bizClickLabelInfoImpl.setSubkey(i);
        }
    }

    public int getSubkey() {
        BizClickLabelInfoImpl bizClickLabelInfoImpl = this.mControl;
        if (bizClickLabelInfoImpl != null) {
            return bizClickLabelInfoImpl.getSubkey();
        }
        return 0;
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
