package com.autonavi.gbl.lane;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.common.path.option.PathInfo;
import com.autonavi.gbl.lane.impl.ILaneServiceToolImpl;
import com.autonavi.gbl.lane.model.LaneRenderScreen;
import java.util.ArrayList;
@IntfAuto(target = ILaneServiceToolImpl.class, type = BuildType.JCTRL)
/* loaded from: classes.dex */
public class LaneServiceTool {
    private static String PACKAGE = ReflexTool.PN(LaneServiceTool.class);
    private ILaneServiceToolImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected void clean() {
    }

    protected LaneServiceTool(long j, boolean z) {
        this(new ILaneServiceToolImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(LaneServiceTool.class, this, this.mControl);
        }
    }

    public LaneServiceTool(ILaneServiceToolImpl iLaneServiceToolImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iLaneServiceToolImpl);
    }

    private void $constructor(ILaneServiceToolImpl iLaneServiceToolImpl) {
        if (iLaneServiceToolImpl != null) {
            this.mControl = iLaneServiceToolImpl;
            this.mTargetId = String.format("LaneServiceTool_%s_%d", String.valueOf(ILaneServiceToolImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected ILaneServiceToolImpl getControl() {
        return this.mControl;
    }

    public ArrayList<Long> getPathCityList(PathInfo pathInfo) {
        ILaneServiceToolImpl iLaneServiceToolImpl = this.mControl;
        if (iLaneServiceToolImpl != null) {
            return iLaneServiceToolImpl.getPathCityList(pathInfo);
        }
        return null;
    }

    public boolean enableDynamicLevelUseExternalSpeed(@LaneRenderScreen.LaneRenderScreen1 int i, boolean z) {
        ILaneServiceToolImpl iLaneServiceToolImpl = this.mControl;
        if (iLaneServiceToolImpl != null) {
            return iLaneServiceToolImpl.enableDynamicLevelUseExternalSpeed(i, z);
        }
        return false;
    }

    public boolean setDynamicLevelExternalSpeed(@LaneRenderScreen.LaneRenderScreen1 int i, float f) {
        ILaneServiceToolImpl iLaneServiceToolImpl = this.mControl;
        if (iLaneServiceToolImpl != null) {
            return iLaneServiceToolImpl.setDynamicLevelExternalSpeed(i, f);
        }
        return false;
    }

    public String getProjectInfo() {
        ILaneServiceToolImpl iLaneServiceToolImpl = this.mControl;
        if (iLaneServiceToolImpl != null) {
            return iLaneServiceToolImpl.getProjectInfo();
        }
        return null;
    }

    public boolean setProjectInfo(String str) {
        ILaneServiceToolImpl iLaneServiceToolImpl = this.mControl;
        if (iLaneServiceToolImpl != null) {
            return iLaneServiceToolImpl.setProjectInfo(str);
        }
        return false;
    }

    public boolean openDCLUpload(boolean z) {
        ILaneServiceToolImpl iLaneServiceToolImpl = this.mControl;
        if (iLaneServiceToolImpl != null) {
            return iLaneServiceToolImpl.openDCLUpload(z);
        }
        return false;
    }

    public boolean sendHdDataVersion(String str) {
        ILaneServiceToolImpl iLaneServiceToolImpl = this.mControl;
        if (iLaneServiceToolImpl != null) {
            return iLaneServiceToolImpl.sendHdDataVersion(str);
        }
        return false;
    }

    public boolean openWaterArrow(@LaneRenderScreen.LaneRenderScreen1 int i, boolean z) {
        ILaneServiceToolImpl iLaneServiceToolImpl = this.mControl;
        if (iLaneServiceToolImpl != null) {
            return iLaneServiceToolImpl.openWaterArrow(i, z);
        }
        return false;
    }

    public boolean openRenderOutline(@LaneRenderScreen.LaneRenderScreen1 int i, boolean z) {
        ILaneServiceToolImpl iLaneServiceToolImpl = this.mControl;
        if (iLaneServiceToolImpl != null) {
            return iLaneServiceToolImpl.openRenderOutline(i, z);
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
