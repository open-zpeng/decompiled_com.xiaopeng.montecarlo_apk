package com.autonavi.gbl.common.path.option;

import android.util.Log;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.common.model.Coord2DInt32;
import com.autonavi.gbl.common.model.Coord3DInt32;
import com.autonavi.gbl.common.path.model.AssistantAction;
import com.autonavi.gbl.common.path.model.MainAction;
import com.autonavi.gbl.common.path.model.ManeuverIcon;
import com.autonavi.gbl.common.path.model.Slope;
import com.autonavi.gbl.common.path.option.impl.LinkInfoImpl;
import com.autonavi.gbl.common.path.option.impl.SegmentInfoImpl;
import java.lang.reflect.Method;
import java.util.ArrayList;
@IntfAuto(target = SegmentInfoImpl.class, type = BuildType.JCTRL)
/* loaded from: classes.dex */
public class SegmentInfo {
    private static String PACKAGE = ReflexTool.PN(SegmentInfo.class);
    private SegmentInfoImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected SegmentInfo(long j, boolean z) {
        this(new SegmentInfoImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(SegmentInfo.class, this, this.mControl);
        }
    }

    public SegmentInfo() {
        this(new SegmentInfoImpl());
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(SegmentInfo.class, this, this.mControl);
        }
    }

    public SegmentInfo(SegmentInfo segmentInfo) {
        this(new SegmentInfoImpl((SegmentInfoImpl) new TypeHelper(PACKAGE).transfer("com.autonavi.gbl.common.path.option.SegmentInfo", segmentInfo)));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(SegmentInfo.class, this, this.mControl);
        }
    }

    public SegmentInfo(SegmentInfoImpl segmentInfoImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(segmentInfoImpl);
    }

    private void $constructor(SegmentInfoImpl segmentInfoImpl) {
        if (segmentInfoImpl != null) {
            this.mControl = segmentInfoImpl;
            this.mTargetId = String.format("SegmentInfo_%s_%d", String.valueOf(SegmentInfoImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected SegmentInfoImpl getControl() {
        return this.mControl;
    }

    public LinkInfo getLinkInfo(long j) {
        LinkInfoImpl linkInfo;
        try {
            Method method = SegmentInfo.class.getMethod("getLinkInfo", Long.TYPE);
            SegmentInfoImpl segmentInfoImpl = this.mControl;
            if (segmentInfoImpl != null && (linkInfo = segmentInfoImpl.getLinkInfo(j)) != null) {
                TypeHelper typeHelper = this.mTypeHelper;
                r0 = typeHelper != null ? (LinkInfo) typeHelper.transfer(method, -1, (Object) linkInfo, true) : null;
                if (r0 == null) {
                    DebugTool.e("%s: $ret == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.common.path.option.SegmentInfo.1
                    }));
                }
            }
            return r0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public ArrayList<Coord2DInt32> getPoints() {
        SegmentInfoImpl segmentInfoImpl = this.mControl;
        if (segmentInfoImpl != null) {
            return segmentInfoImpl.getPoints();
        }
        return null;
    }

    public ArrayList<Coord3DInt32> get3DPoints() {
        SegmentInfoImpl segmentInfoImpl = this.mControl;
        if (segmentInfoImpl != null) {
            return segmentInfoImpl.get3DPoints();
        }
        return null;
    }

    public boolean isValid() {
        SegmentInfoImpl segmentInfoImpl = this.mControl;
        if (segmentInfoImpl != null) {
            return segmentInfoImpl.isValid();
        }
        return false;
    }

    public long getRelatedPathID() {
        SegmentInfoImpl segmentInfoImpl = this.mControl;
        if (segmentInfoImpl != null) {
            return segmentInfoImpl.getRelatedPathID();
        }
        return 0L;
    }

    public int getSegmentIndex() {
        SegmentInfoImpl segmentInfoImpl = this.mControl;
        if (segmentInfoImpl != null) {
            return segmentInfoImpl.getSegmentIndex();
        }
        return 0;
    }

    @MainAction.MainAction1
    public int getMainAction() {
        SegmentInfoImpl segmentInfoImpl = this.mControl;
        if (segmentInfoImpl != null) {
            return segmentInfoImpl.getMainAction();
        }
        return Integer.MIN_VALUE;
    }

    @AssistantAction.AssistantAction1
    public int getAssistantAction() {
        SegmentInfoImpl segmentInfoImpl = this.mControl;
        if (segmentInfoImpl != null) {
            return segmentInfoImpl.getAssistantAction();
        }
        return Integer.MIN_VALUE;
    }

    @Slope.Slope1
    public int getSlope() {
        SegmentInfoImpl segmentInfoImpl = this.mControl;
        if (segmentInfoImpl != null) {
            return segmentInfoImpl.getSlope();
        }
        return Integer.MIN_VALUE;
    }

    public long getLength() {
        SegmentInfoImpl segmentInfoImpl = this.mControl;
        if (segmentInfoImpl != null) {
            return segmentInfoImpl.getLength();
        }
        return 0L;
    }

    public int getTollCost() {
        SegmentInfoImpl segmentInfoImpl = this.mControl;
        if (segmentInfoImpl != null) {
            return segmentInfoImpl.getTollCost();
        }
        return 0;
    }

    public long getTollDist() {
        SegmentInfoImpl segmentInfoImpl = this.mControl;
        if (segmentInfoImpl != null) {
            return segmentInfoImpl.getTollDist();
        }
        return 0L;
    }

    public void setTravelTime(long j) {
        SegmentInfoImpl segmentInfoImpl = this.mControl;
        if (segmentInfoImpl != null) {
            segmentInfoImpl.setTravelTime(j);
        }
    }

    public long getTravelTime() {
        SegmentInfoImpl segmentInfoImpl = this.mControl;
        if (segmentInfoImpl != null) {
            return segmentInfoImpl.getTravelTime();
        }
        return 0L;
    }

    public long getTrafficLightNum() {
        SegmentInfoImpl segmentInfoImpl = this.mControl;
        if (segmentInfoImpl != null) {
            return segmentInfoImpl.getTrafficLightNum();
        }
        return 0L;
    }

    public long getLinkCount() {
        SegmentInfoImpl segmentInfoImpl = this.mControl;
        if (segmentInfoImpl != null) {
            return segmentInfoImpl.getLinkCount();
        }
        return 0L;
    }

    public boolean hasCrossImage() {
        SegmentInfoImpl segmentInfoImpl = this.mControl;
        if (segmentInfoImpl != null) {
            return segmentInfoImpl.hasCrossImage();
        }
        return false;
    }

    public boolean isReqVectorCross() {
        SegmentInfoImpl segmentInfoImpl = this.mControl;
        if (segmentInfoImpl != null) {
            return segmentInfoImpl.isReqVectorCross();
        }
        return false;
    }

    public boolean isRightPassArea() {
        SegmentInfoImpl segmentInfoImpl = this.mControl;
        if (segmentInfoImpl != null) {
            return segmentInfoImpl.isRightPassArea();
        }
        return false;
    }

    public boolean is3DJunction() {
        SegmentInfoImpl segmentInfoImpl = this.mControl;
        if (segmentInfoImpl != null) {
            return segmentInfoImpl.is3DJunction();
        }
        return false;
    }

    public boolean isEndOfRoad() {
        SegmentInfoImpl segmentInfoImpl = this.mControl;
        if (segmentInfoImpl != null) {
            return segmentInfoImpl.isEndOfRoad();
        }
        return false;
    }

    public short get3DJunctionIndex() {
        SegmentInfoImpl segmentInfoImpl = this.mControl;
        if (segmentInfoImpl != null) {
            return segmentInfoImpl.get3DJunctionIndex();
        }
        return (short) 0;
    }

    public String getTollRoadName() {
        SegmentInfoImpl segmentInfoImpl = this.mControl;
        if (segmentInfoImpl != null) {
            return segmentInfoImpl.getTollRoadName();
        }
        return null;
    }

    public String getGuideboardName() {
        SegmentInfoImpl segmentInfoImpl = this.mControl;
        if (segmentInfoImpl != null) {
            return segmentInfoImpl.getGuideboardName();
        }
        return null;
    }

    public String getExitName() {
        SegmentInfoImpl segmentInfoImpl = this.mControl;
        if (segmentInfoImpl != null) {
            return segmentInfoImpl.getExitName();
        }
        return null;
    }

    public String getCrossingName() {
        SegmentInfoImpl segmentInfoImpl = this.mControl;
        if (segmentInfoImpl != null) {
            return segmentInfoImpl.getCrossingName();
        }
        return null;
    }

    public ManeuverIcon getManeuverIcon() {
        SegmentInfoImpl segmentInfoImpl = this.mControl;
        if (segmentInfoImpl != null) {
            return segmentInfoImpl.getManeuverIcon();
        }
        return null;
    }

    public long getPlayPointCount() {
        SegmentInfoImpl segmentInfoImpl = this.mControl;
        if (segmentInfoImpl != null) {
            return segmentInfoImpl.getPlayPointCount();
        }
        return 0L;
    }

    public short getUturnAndArrivedest() {
        SegmentInfoImpl segmentInfoImpl = this.mControl;
        if (segmentInfoImpl != null) {
            return segmentInfoImpl.getUturnAndArrivedest();
        }
        return (short) 0;
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.common.path.option.SegmentInfo.2
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
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.common.path.option.SegmentInfo.3
        }));
    }

    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.common.path.option.SegmentInfo.4
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
