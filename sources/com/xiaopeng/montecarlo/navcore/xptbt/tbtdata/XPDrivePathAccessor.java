package com.xiaopeng.montecarlo.navcore.xptbt.tbtdata;

import androidx.annotation.NonNull;
import com.autonavi.gbl.common.model.Coord2DDouble;
import com.autonavi.gbl.common.model.RectDouble;
import com.autonavi.gbl.common.path.model.AvoidTrafficJamInfo;
import com.autonavi.gbl.common.path.model.LabelInfo;
import com.autonavi.gbl.common.path.model.LightBarItem;
import com.autonavi.gbl.common.path.model.OddSegInfo;
import com.autonavi.gbl.common.path.model.POIInfo;
import com.autonavi.gbl.common.path.model.RestAreaInfo;
import com.autonavi.gbl.common.path.model.RestrictionInfo;
import com.autonavi.gbl.common.path.model.TrafficIncident;
import com.autonavi.gbl.common.path.model.ViaPointInfo;
import com.autonavi.gbl.common.path.option.PathInfo;
import com.autonavi.gbl.common.path.option.SegmentInfo;
import com.xiaopeng.montecarlo.root.util.L;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class XPDrivePathAccessor {
    private static final L.Tag TAG = new L.Tag("XPDrivePathAccessor");
    private boolean mIsRecycle = false;
    private PathInfo mVariantPath;
    private final IPathResult mXPPathResult;
    private XPBaseSegmentAccessor mXpSegmentAccessor;

    private XPDrivePathAccessor(@NonNull PathInfo pathInfo, @NonNull IPathResult iPathResult) {
        this.mXPPathResult = iPathResult;
        this.mVariantPath = pathInfo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static XPDrivePathAccessor obtain(@NonNull PathInfo pathInfo, @NonNull IPathResult iPathResult) {
        if (pathInfo == null || iPathResult == null) {
            throw new IllegalArgumentException("variantPath or xpPathResult should not be null");
        }
        if (iPathResult.addRef()) {
            try {
                return new XPDrivePathAccessor(pathInfo, iPathResult);
            } catch (Exception unused) {
                iPathResult.delRef();
            }
        }
        return null;
    }

    public void recycle() {
        if (this.mIsRecycle) {
            return;
        }
        this.mIsRecycle = true;
        XPBaseSegmentAccessor xPBaseSegmentAccessor = this.mXpSegmentAccessor;
        if (xPBaseSegmentAccessor != null && !xPBaseSegmentAccessor.isRecycled()) {
            this.mXpSegmentAccessor.recycle();
            this.mXpSegmentAccessor = null;
        }
        this.mXPPathResult.delRef();
    }

    public long getPathID() {
        return this.mVariantPath.getPathID();
    }

    public long getPathLength() {
        return this.mVariantPath.getLength();
    }

    public long getSegmentCount() {
        return this.mVariantPath.getSegmentCount();
    }

    public XPBaseSegmentAccessor getSegmentAccessor(long j) {
        XPBaseSegmentAccessor xPBaseSegmentAccessor = this.mXpSegmentAccessor;
        if (xPBaseSegmentAccessor != null) {
            if (!xPBaseSegmentAccessor.isRecycled() && this.mXpSegmentAccessor.getIndex() == j) {
                return this.mXpSegmentAccessor;
            }
            if (!this.mXpSegmentAccessor.isRecycled()) {
                this.mXpSegmentAccessor.recycle();
            }
            this.mXpSegmentAccessor = null;
        }
        SegmentInfo segmentInfo = this.mVariantPath.getSegmentInfo(j);
        if (segmentInfo == null) {
            return null;
        }
        this.mXpSegmentAccessor = new XPBaseSegmentAccessor(j, segmentInfo);
        return this.mXpSegmentAccessor;
    }

    public RectDouble getBound(long j, long j2, long j3) {
        return this.mVariantPath.getBound(j, j2, j3);
    }

    public short getLabelInfoCount() {
        return this.mVariantPath.getLabelInfoCount();
    }

    public LabelInfo getLabelInfo(short s) {
        return this.mVariantPath.getLabelInfo(s);
    }

    public boolean isValid() {
        return this.mVariantPath.isValid();
    }

    public long getLength() {
        return this.mVariantPath.getLength();
    }

    public long getStrategy() {
        return this.mVariantPath.getStrategy();
    }

    public long getTravelTime() {
        return this.mVariantPath.getTravelTime();
    }

    public long getStaticTravelTime() {
        return this.mVariantPath.getStaticTravelTime();
    }

    public int getTollCost() {
        return this.mVariantPath.getTollCost();
    }

    public long getTrafficLightCount() {
        return this.mVariantPath.getTrafficLightCount();
    }

    public boolean isOnline() {
        return this.mVariantPath.isOnline();
    }

    public RestrictionInfo getRestrictionInfo() {
        return this.mVariantPath.getRestrictionInfo();
    }

    public short getTrafficIncidentCount(boolean z) {
        return this.mVariantPath.getTrafficIncidentCount(z);
    }

    public TrafficIncident getTrafficIncident(short s, boolean z) {
        return this.mVariantPath.getTrafficIncident(s, z);
    }

    public short getAvoidTrafficJamCount() {
        return this.mVariantPath.getAvoidTrafficJamCount();
    }

    public AvoidTrafficJamInfo getAvoidTrafficJam(short s) {
        return this.mVariantPath.getAvoidTrafficJam(s);
    }

    public POIInfo getEndPoi() {
        return this.mVariantPath.getEndPoi();
    }

    public ArrayList<LightBarItem> getLightBarItems() {
        return this.mVariantPath.getLightBarItems();
    }

    public int getViaPointInfoCount() {
        ArrayList<ViaPointInfo> viaPointInfo = this.mVariantPath.getViaPointInfo();
        if (viaPointInfo != null) {
            return viaPointInfo.size();
        }
        return 0;
    }

    public ArrayList<ViaPointInfo> getViaPointInfo() {
        return this.mVariantPath.getViaPointInfo();
    }

    public List<RestAreaInfo> getRestAreas(long j, long j2) {
        return this.mVariantPath.getRestAreas(j, j2);
    }

    public List<OddSegInfo> getOddSegInfos() {
        return this.mVariantPath.getOddSegInfos();
    }

    public List<Coord2DDouble> getOddPoints(long j) {
        return this.mVariantPath.getODDPoints(j);
    }
}
