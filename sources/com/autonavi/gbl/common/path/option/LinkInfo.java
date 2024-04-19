package com.autonavi.gbl.common.path.option;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.common.model.Coord2DInt32;
import com.autonavi.gbl.common.model.Coord3DInt32;
import com.autonavi.gbl.common.path.model.AssistantAction;
import com.autonavi.gbl.common.path.model.Camera;
import com.autonavi.gbl.common.path.model.Camera3d;
import com.autonavi.gbl.common.path.model.ExactTrafficItem;
import com.autonavi.gbl.common.path.model.FloorInfo;
import com.autonavi.gbl.common.path.model.Formway;
import com.autonavi.gbl.common.path.model.GantryInfo;
import com.autonavi.gbl.common.path.model.HeightDiffData;
import com.autonavi.gbl.common.path.model.LinkType;
import com.autonavi.gbl.common.path.model.MainAction;
import com.autonavi.gbl.common.path.model.Ownership;
import com.autonavi.gbl.common.path.model.RoadClass;
import com.autonavi.gbl.common.path.model.RoadFacility;
import com.autonavi.gbl.common.path.model.RoadSlopeInfo;
import com.autonavi.gbl.common.path.model.SlopeInfo;
import com.autonavi.gbl.common.path.model.TurnInfo;
import com.autonavi.gbl.common.path.option.impl.LinkInfoImpl;
import java.math.BigInteger;
import java.util.ArrayList;
@IntfAuto(target = LinkInfoImpl.class, type = BuildType.JCTRL)
/* loaded from: classes.dex */
public class LinkInfo {
    private static String PACKAGE = ReflexTool.PN(LinkInfo.class);
    private LinkInfoImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected LinkInfo(long j, boolean z) {
        this(new LinkInfoImpl(j, z));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(LinkInfo.class, this, this.mControl);
        }
    }

    public LinkInfo() {
        this(new LinkInfoImpl());
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(LinkInfo.class, this, this.mControl);
        }
    }

    public LinkInfo(LinkInfo linkInfo) {
        this(new LinkInfoImpl((LinkInfoImpl) new TypeHelper(PACKAGE).transfer("com.autonavi.gbl.common.path.option.LinkInfo", linkInfo)));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(LinkInfo.class, this, this.mControl);
        }
    }

    public LinkInfo(LinkInfoImpl linkInfoImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(linkInfoImpl);
    }

    private void $constructor(LinkInfoImpl linkInfoImpl) {
        if (linkInfoImpl != null) {
            this.mControl = linkInfoImpl;
            this.mTargetId = String.format("LinkInfo_%s_%d", String.valueOf(LinkInfoImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected LinkInfoImpl getControl() {
        return this.mControl;
    }

    public ArrayList<Coord2DInt32> getPoints() {
        LinkInfoImpl linkInfoImpl = this.mControl;
        if (linkInfoImpl != null) {
            return linkInfoImpl.getPoints();
        }
        return null;
    }

    public ArrayList<Coord3DInt32> get3DPoints() {
        LinkInfoImpl linkInfoImpl = this.mControl;
        if (linkInfoImpl != null) {
            return linkInfoImpl.get3DPoints();
        }
        return null;
    }

    public FloorInfo getFloorInfo() {
        LinkInfoImpl linkInfoImpl = this.mControl;
        if (linkInfoImpl != null) {
            return linkInfoImpl.getFloorInfo();
        }
        return null;
    }

    public ArrayList<SlopeInfo> getAllSlopeInfo() {
        LinkInfoImpl linkInfoImpl = this.mControl;
        if (linkInfoImpl != null) {
            return linkInfoImpl.getAllSlopeInfo();
        }
        return null;
    }

    public ArrayList<GantryInfo> getGantryInfos() {
        LinkInfoImpl linkInfoImpl = this.mControl;
        if (linkInfoImpl != null) {
            return linkInfoImpl.getGantryInfos();
        }
        return null;
    }

    public Camera3d convertCameraTo3DCamera(Camera camera) {
        LinkInfoImpl linkInfoImpl = this.mControl;
        if (linkInfoImpl != null) {
            return linkInfoImpl.convertCameraTo3DCamera(camera);
        }
        return null;
    }

    public boolean isValid() {
        LinkInfoImpl linkInfoImpl = this.mControl;
        if (linkInfoImpl != null) {
            return linkInfoImpl.isValid();
        }
        return false;
    }

    public long getRelatedPathID() {
        LinkInfoImpl linkInfoImpl = this.mControl;
        if (linkInfoImpl != null) {
            return linkInfoImpl.getRelatedPathID();
        }
        return 0L;
    }

    public int getRelatedSegmentIndex() {
        LinkInfoImpl linkInfoImpl = this.mControl;
        if (linkInfoImpl != null) {
            return linkInfoImpl.getRelatedSegmentIndex();
        }
        return 0;
    }

    public int getLinkIndex() {
        LinkInfoImpl linkInfoImpl = this.mControl;
        if (linkInfoImpl != null) {
            return linkInfoImpl.getLinkIndex();
        }
        return 0;
    }

    public int getLength() {
        LinkInfoImpl linkInfoImpl = this.mControl;
        if (linkInfoImpl != null) {
            return linkInfoImpl.getLength();
        }
        return 0;
    }

    public void setTravelTime(long j) {
        LinkInfoImpl linkInfoImpl = this.mControl;
        if (linkInfoImpl != null) {
            linkInfoImpl.setTravelTime(j);
        }
    }

    public long getTravelTime() {
        LinkInfoImpl linkInfoImpl = this.mControl;
        if (linkInfoImpl != null) {
            return linkInfoImpl.getTravelTime();
        }
        return 0L;
    }

    public long getStaticTravelTime() {
        LinkInfoImpl linkInfoImpl = this.mControl;
        if (linkInfoImpl != null) {
            return linkInfoImpl.getStaticTravelTime();
        }
        return 0L;
    }

    public String getRoadName() {
        LinkInfoImpl linkInfoImpl = this.mControl;
        if (linkInfoImpl != null) {
            return linkInfoImpl.getRoadName();
        }
        return null;
    }

    public short getRoadFacilityCount() {
        LinkInfoImpl linkInfoImpl = this.mControl;
        if (linkInfoImpl != null) {
            return linkInfoImpl.getRoadFacilityCount();
        }
        return (short) 0;
    }

    public RoadFacility getRoadFacility(short s) {
        LinkInfoImpl linkInfoImpl = this.mControl;
        if (linkInfoImpl != null) {
            return linkInfoImpl.getRoadFacility(s);
        }
        return null;
    }

    public long get32TopoID() {
        LinkInfoImpl linkInfoImpl = this.mControl;
        if (linkInfoImpl != null) {
            return linkInfoImpl.get32TopoID();
        }
        return 0L;
    }

    public BigInteger get64TopoID() {
        LinkInfoImpl linkInfoImpl = this.mControl;
        if (linkInfoImpl != null) {
            return linkInfoImpl.get64TopoID();
        }
        return null;
    }

    public int getURID() {
        LinkInfoImpl linkInfoImpl = this.mControl;
        if (linkInfoImpl != null) {
            return linkInfoImpl.getURID();
        }
        return 0;
    }

    public long getTileID() {
        LinkInfoImpl linkInfoImpl = this.mControl;
        if (linkInfoImpl != null) {
            return linkInfoImpl.getTileID();
        }
        return 0L;
    }

    public long getTPID() {
        LinkInfoImpl linkInfoImpl = this.mControl;
        if (linkInfoImpl != null) {
            return linkInfoImpl.getTPID();
        }
        return 0L;
    }

    public short getLinkDirection() {
        LinkInfoImpl linkInfoImpl = this.mControl;
        if (linkInfoImpl != null) {
            return linkInfoImpl.getLinkDirection();
        }
        return (short) 0;
    }

    @MainAction.MainAction1
    public int getMainAction() {
        LinkInfoImpl linkInfoImpl = this.mControl;
        if (linkInfoImpl != null) {
            return linkInfoImpl.getMainAction();
        }
        return Integer.MIN_VALUE;
    }

    @AssistantAction.AssistantAction1
    public int getAssistantAction() {
        LinkInfoImpl linkInfoImpl = this.mControl;
        if (linkInfoImpl != null) {
            return linkInfoImpl.getAssistantAction();
        }
        return Integer.MIN_VALUE;
    }

    public long getAdcode() {
        LinkInfoImpl linkInfoImpl = this.mControl;
        if (linkInfoImpl != null) {
            return linkInfoImpl.getAdcode();
        }
        return 0L;
    }

    @LinkType.LinkType1
    public int getLinkType() {
        LinkInfoImpl linkInfoImpl = this.mControl;
        if (linkInfoImpl != null) {
            return linkInfoImpl.getLinkType();
        }
        return Integer.MIN_VALUE;
    }

    @Formway.Formway1
    public int getFormway() {
        LinkInfoImpl linkInfoImpl = this.mControl;
        if (linkInfoImpl != null) {
            return linkInfoImpl.getFormway();
        }
        return Integer.MIN_VALUE;
    }

    @RoadClass.RoadClass1
    public int getRoadClass() {
        LinkInfoImpl linkInfoImpl = this.mControl;
        if (linkInfoImpl != null) {
            return linkInfoImpl.getRoadClass();
        }
        return Integer.MIN_VALUE;
    }

    public short getRoadDirection() {
        LinkInfoImpl linkInfoImpl = this.mControl;
        if (linkInfoImpl != null) {
            return linkInfoImpl.getRoadDirection();
        }
        return (short) 0;
    }

    @Ownership.Ownership1
    public int getOwnership() {
        LinkInfoImpl linkInfoImpl = this.mControl;
        if (linkInfoImpl != null) {
            return linkInfoImpl.getOwnership();
        }
        return Integer.MIN_VALUE;
    }

    public boolean isToll() {
        LinkInfoImpl linkInfoImpl = this.mControl;
        if (linkInfoImpl != null) {
            return linkInfoImpl.isToll();
        }
        return false;
    }

    public boolean isOverHead() {
        LinkInfoImpl linkInfoImpl = this.mControl;
        if (linkInfoImpl != null) {
            return linkInfoImpl.isOverHead();
        }
        return false;
    }

    public boolean hasParallelRoad() {
        LinkInfoImpl linkInfoImpl = this.mControl;
        if (linkInfoImpl != null) {
            return linkInfoImpl.hasParallelRoad();
        }
        return false;
    }

    public boolean hasMultiOut() {
        LinkInfoImpl linkInfoImpl = this.mControl;
        if (linkInfoImpl != null) {
            return linkInfoImpl.hasMultiOut();
        }
        return false;
    }

    public boolean hasTrafficLight() {
        LinkInfoImpl linkInfoImpl = this.mControl;
        if (linkInfoImpl != null) {
            return linkInfoImpl.hasTrafficLight();
        }
        return false;
    }

    public boolean hasMixFork() {
        LinkInfoImpl linkInfoImpl = this.mControl;
        if (linkInfoImpl != null) {
            return linkInfoImpl.hasMixFork();
        }
        return false;
    }

    public boolean isAtService() {
        LinkInfoImpl linkInfoImpl = this.mControl;
        if (linkInfoImpl != null) {
            return linkInfoImpl.isAtService();
        }
        return false;
    }

    public boolean isSupport3DNavigation() {
        LinkInfoImpl linkInfoImpl = this.mControl;
        if (linkInfoImpl != null) {
            return linkInfoImpl.isSupport3DNavigation();
        }
        return false;
    }

    public boolean isRestricting() {
        LinkInfoImpl linkInfoImpl = this.mControl;
        if (linkInfoImpl != null) {
            return linkInfoImpl.isRestricting();
        }
        return false;
    }

    public short getSpeedLimit() {
        LinkInfoImpl linkInfoImpl = this.mControl;
        if (linkInfoImpl != null) {
            return linkInfoImpl.getSpeedLimit();
        }
        return (short) 0;
    }

    public short getLimitFlag() {
        LinkInfoImpl linkInfoImpl = this.mControl;
        if (linkInfoImpl != null) {
            return linkInfoImpl.getLimitFlag();
        }
        return (short) 0;
    }

    public short getSpeed() {
        LinkInfoImpl linkInfoImpl = this.mControl;
        if (linkInfoImpl != null) {
            return linkInfoImpl.getSpeed();
        }
        return (short) 0;
    }

    public short getStatus() {
        LinkInfoImpl linkInfoImpl = this.mControl;
        if (linkInfoImpl != null) {
            return linkInfoImpl.getStatus();
        }
        return (short) 0;
    }

    public int getFineStatus() {
        LinkInfoImpl linkInfoImpl = this.mControl;
        if (linkInfoImpl != null) {
            return linkInfoImpl.getFineStatus();
        }
        return 0;
    }

    public short getCameraCount() {
        LinkInfoImpl linkInfoImpl = this.mControl;
        if (linkInfoImpl != null) {
            return linkInfoImpl.getCameraCount();
        }
        return (short) 0;
    }

    public Camera getCamera(short s) {
        LinkInfoImpl linkInfoImpl = this.mControl;
        if (linkInfoImpl != null) {
            return linkInfoImpl.getCamera(s);
        }
        return null;
    }

    public boolean convertCameraTo3DCamera(Camera camera, Camera3d camera3d) {
        LinkInfoImpl linkInfoImpl = this.mControl;
        if (linkInfoImpl != null) {
            return linkInfoImpl.convertCameraTo3DCamera(camera, camera3d);
        }
        return false;
    }

    public short getTurnInfoCount() {
        LinkInfoImpl linkInfoImpl = this.mControl;
        if (linkInfoImpl != null) {
            return linkInfoImpl.getTurnInfoCount();
        }
        return (short) 0;
    }

    public TurnInfo getTurnInfo(short s) {
        LinkInfoImpl linkInfoImpl = this.mControl;
        if (linkInfoImpl != null) {
            return linkInfoImpl.getTurnInfo(s);
        }
        return null;
    }

    public ExactTrafficItem get3DExactTrafficItem() {
        LinkInfoImpl linkInfoImpl = this.mControl;
        if (linkInfoImpl != null) {
            return linkInfoImpl.get3DExactTrafficItem();
        }
        return null;
    }

    public ExactTrafficItem getExactTrafficItem() {
        LinkInfoImpl linkInfoImpl = this.mControl;
        if (linkInfoImpl != null) {
            return linkInfoImpl.getExactTrafficItem();
        }
        return null;
    }

    public HeightDiffData getHeightDiffData() {
        LinkInfoImpl linkInfoImpl = this.mControl;
        if (linkInfoImpl != null) {
            return linkInfoImpl.getHeightDiffData();
        }
        return null;
    }

    public String getServiceName() {
        LinkInfoImpl linkInfoImpl = this.mControl;
        if (linkInfoImpl != null) {
            return linkInfoImpl.getServiceName();
        }
        return null;
    }

    public long getNativeTypeHandle() {
        LinkInfoImpl linkInfoImpl = this.mControl;
        if (linkInfoImpl != null) {
            return linkInfoImpl.getNativeTypeHandle();
        }
        return 0L;
    }

    public RoadSlopeInfo getRoadSlopInfo() {
        LinkInfoImpl linkInfoImpl = this.mControl;
        if (linkInfoImpl != null) {
            return linkInfoImpl.getRoadSlopInfo();
        }
        return null;
    }

    public short getGantryInfos(ArrayList<GantryInfo> arrayList) {
        LinkInfoImpl linkInfoImpl = this.mControl;
        if (linkInfoImpl != null) {
            return linkInfoImpl.getGantryInfos(arrayList);
        }
        return (short) 0;
    }

    public boolean getInnerRoad() {
        LinkInfoImpl linkInfoImpl = this.mControl;
        if (linkInfoImpl != null) {
            return linkInfoImpl.getInnerRoad();
        }
        return false;
    }

    public boolean isParkingRoad() {
        LinkInfoImpl linkInfoImpl = this.mControl;
        if (linkInfoImpl != null) {
            return linkInfoImpl.isParkingRoad();
        }
        return false;
    }

    public short getLaneNum() {
        LinkInfoImpl linkInfoImpl = this.mControl;
        if (linkInfoImpl != null) {
            return linkInfoImpl.getLaneNum();
        }
        return (short) 0;
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.common.path.option.LinkInfo.1
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
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.common.path.option.LinkInfo.2
        }));
    }

    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.common.path.option.LinkInfo.3
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
