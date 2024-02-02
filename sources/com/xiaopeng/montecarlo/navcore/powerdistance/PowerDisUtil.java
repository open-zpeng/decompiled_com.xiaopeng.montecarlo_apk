package com.xiaopeng.montecarlo.navcore.powerdistance;

import androidx.annotation.NonNull;
import com.autonavi.gbl.common.model.Coord2DDouble;
import com.xiaopeng.montecarlo.navcore.httpclient.dto.RoadSeqStageInfo;
import com.xiaopeng.montecarlo.navcore.powerdistance.dataprovider.PdExternalData;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IPathResult;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IVariantPath;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPBaseLinkAccessor;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPBaseSegmentAccessor;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPDrivePathAccessor;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPVariantPath;
import com.xiaopeng.montecarlo.root.carservice.CarServiceManager;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.GsonUtil;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class PowerDisUtil {
    private static final int KEY_ROUTE_POINTS_MAX_COUNT = 17;
    private static final L.Tag TAG = new L.Tag("PowerDisUtil");
    private static String sPreviousStateListLog = null;

    public static int getTransRouteRemainDis(List<RoadSeqStageInfo> list) {
        L.Tag tag = TAG;
        L.i(tag, "getRouteRemainDis stageList isNotEmpty:" + CollectionUtils.isNotEmpty(list));
        double d = 0.0d;
        if (CollectionUtils.isNotEmpty(list)) {
            for (int i = 0; i < list.size(); i++) {
                RoadSeqStageInfo roadSeqStageInfo = list.get(i);
                d += getKBySpeed(getSpeed(roadSeqStageInfo)) * ((float) roadSeqStageInfo.getDs());
            }
        }
        return (int) d;
    }

    public static int getRemainDis(int i, int i2, int i3, @NonNull IVariantPath iVariantPath, @NonNull IPathResult iPathResult) {
        List<RoadSeqStageInfo> stageList = getStageList(i, i2, i3, iVariantPath, iPathResult);
        long pathLength = iVariantPath.getPathLength();
        int transRouteRemainDis = getTransRouteRemainDis(stageList);
        if (RootUtil.compareFloat(transRouteRemainDis, 0.0f)) {
            transRouteRemainDis = (int) pathLength;
        }
        if (L.ENABLE) {
            if (stageList != null) {
                L.Tag tag = TAG;
                L.d(tag, "getRemainDis- stagelist:" + GsonUtil.toJson(stageList) + "    pathLength:" + pathLength + "  routeRemainDis:" + transRouteRemainDis);
            } else {
                L.Tag tag2 = TAG;
                L.d(tag2, " getRemainDis- stagelist null --path.getPathLength：" + pathLength + "  routeRemainDis:" + transRouteRemainDis);
            }
        }
        int carRemainDistance = CarServiceManager.getInstance().getCarRemainDistance() - transRouteRemainDis;
        if (L.ENABLE) {
            StringBuilder sb = new StringBuilder();
            sb.append("getRemainDis--");
            sb.append(" startSegIndex:" + i);
            sb.append(" startLinkIndex:" + i2);
            sb.append(" disToTarget:" + i3);
            sb.append(" pathLength:" + pathLength);
            sb.append(" routeRemainDis:" + transRouteRemainDis);
            sb.append(" remainDis:" + carRemainDistance);
            sb.append(" path:" + iVariantPath);
            sb.append(" pathResult:" + iPathResult);
            L.d(TAG, sb.toString());
        }
        return carRemainDistance;
    }

    private static float getKBySpeed(double d) {
        float f;
        List<EnergyInfo> energyInfoList = PowerDistanceManager.getInstance().getEnergyInfoList();
        boolean hVACPowerMode = CarServiceManager.getInstance().getHVACPowerMode();
        if (CollectionUtils.isNotEmpty(energyInfoList)) {
            for (int i = 0; i < energyInfoList.size(); i++) {
                EnergyInfo energyInfo = energyInfoList.get(i);
                if (d >= energyInfo.getRangeStart() && d < energyInfo.getRangeEnd()) {
                    f = hVACPowerMode ? energyInfo.getAirConditionOnK() : energyInfo.getAirConditionOffK();
                    return f * PowerDistanceManager.getInstance().getKAdjRate();
                }
            }
        }
        f = 1.0f;
        return f * PowerDistanceManager.getInstance().getKAdjRate();
    }

    private static boolean isInterrupted() {
        return Thread.currentThread().isInterrupted();
    }

    public static List<RoadSeqStageInfo> getStageList(int i, int i2, int i3, IVariantPath iVariantPath, IPathResult iPathResult) {
        return getStageList(i, i2, i3, iVariantPath, iPathResult, null);
    }

    public static List<RoadSeqStageInfo> getStageList(int i, int i2, int i3, IVariantPath iVariantPath, IPathResult iPathResult, PdExternalData pdExternalData) {
        boolean z;
        ArrayList arrayList;
        XPDrivePathAccessor xPDrivePathAccessor;
        int i4;
        boolean z2;
        int i5;
        int i6;
        XPBaseLinkAccessor xPBaseLinkAccessor;
        long j;
        boolean z3;
        XPBaseSegmentAccessor xPBaseSegmentAccessor;
        int i7;
        long j2;
        int i8 = i;
        int i9 = i2;
        if (iVariantPath == null || iPathResult == null) {
            L.i(TAG, "getStageList return null for reason( path = null)");
            return null;
        }
        XPVariantPath xPVariantPath = (XPVariantPath) iVariantPath;
        if (xPVariantPath.getVariantPath() == null || isInterrupted()) {
            L.i(TAG, "getStageList return null for reason( xpVariantPath：" + xPVariantPath + " isInterrupted:" + isInterrupted());
            return null;
        }
        XPDrivePathAccessor drivePathAccessor = iVariantPath.getDrivePathAccessor();
        if (drivePathAccessor == null) {
            L.i(TAG, "getStageList return null for reason( pathAccessor = null)");
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        long travelTime = drivePathAccessor.getTravelTime() / 17;
        long j3 = 0;
        if (pdExternalData == null || pdExternalData.getType() != 0) {
            z = false;
        } else {
            pdExternalData.putData(PdExternalData.KEY_HIGHWAY_DIS, 0L);
            pdExternalData.putData(PdExternalData.KEY_ROUTE_POINTS, arrayList3);
            z = true;
        }
        if (i8 >= 0 && i8 < drivePathAccessor.getSegmentCount() && i9 >= 0) {
            int i10 = i8;
            long j4 = 0;
            int i11 = 0;
            while (!isInterrupted()) {
                long j5 = i10;
                if (j5 >= drivePathAccessor.getSegmentCount()) {
                    break;
                }
                XPBaseSegmentAccessor segmentAccessor = drivePathAccessor.getSegmentAccessor(j5);
                if (segmentAccessor == null) {
                    xPDrivePathAccessor = drivePathAccessor;
                } else {
                    if (i10 == i8) {
                        xPDrivePathAccessor = drivePathAccessor;
                        if (i9 < segmentAccessor.getLinkCount()) {
                            if (segmentAccessor.getTravelTime() < travelTime) {
                                j3 = segmentAccessor.getTravelTime();
                                z3 = false;
                            } else {
                                z3 = true;
                            }
                            int i12 = i9;
                            long j6 = j4;
                            int i13 = i11;
                            long j7 = j6;
                            while (!isInterrupted()) {
                                long j8 = i12;
                                if (j8 >= segmentAccessor.getLinkCount()) {
                                    break;
                                }
                                XPBaseLinkAccessor linkAccessor = segmentAccessor.getLinkAccessor(j8);
                                if (linkAccessor != null) {
                                    if (z) {
                                        j2 = addHighWayDis(linkAccessor, j7);
                                        if (z3) {
                                            xPBaseSegmentAccessor = segmentAccessor;
                                            i7 = i10;
                                            j3 = addKeyPoint(j3, travelTime, linkAccessor, arrayList3);
                                        } else {
                                            xPBaseSegmentAccessor = segmentAccessor;
                                            i7 = i10;
                                        }
                                    } else {
                                        xPBaseSegmentAccessor = segmentAccessor;
                                        i7 = i10;
                                        j2 = j7;
                                    }
                                    arrayList2.add(new RoadSeqStageInfo().setDs(linkAccessor.getLength()).setTs(linkAccessor.getTravelTime()));
                                    int length = i13 + linkAccessor.getLength();
                                    if (length > i3) {
                                        xPDrivePathAccessor.recycle();
                                        return arrayList2;
                                    }
                                    i13 = length;
                                    j7 = j2;
                                } else {
                                    xPBaseSegmentAccessor = segmentAccessor;
                                    i7 = i10;
                                }
                                i12++;
                                segmentAccessor = xPBaseSegmentAccessor;
                                i10 = i7;
                            }
                            i4 = i10;
                            i11 = i13;
                            j4 = j7;
                        }
                    } else {
                        xPDrivePathAccessor = drivePathAccessor;
                        i4 = i10;
                        if (segmentAccessor.getTravelTime() + j3 < travelTime) {
                            j3 += segmentAccessor.getTravelTime();
                            z2 = false;
                        } else {
                            z2 = true;
                        }
                        if (i11 + segmentAccessor.getLength() > i3) {
                            i5 = i11;
                            int i14 = 0;
                            long j9 = j4;
                            while (!isInterrupted()) {
                                long j10 = i14;
                                if (j10 >= segmentAccessor.getLinkCount()) {
                                    break;
                                }
                                XPBaseLinkAccessor linkAccessor2 = segmentAccessor.getLinkAccessor(j10);
                                if (linkAccessor2 != null) {
                                    if (z) {
                                        j = addHighWayDis(linkAccessor2, j9);
                                        if (z2) {
                                            xPBaseLinkAccessor = linkAccessor2;
                                            j3 = addKeyPoint(j3, travelTime, linkAccessor2, arrayList3);
                                        } else {
                                            xPBaseLinkAccessor = linkAccessor2;
                                        }
                                    } else {
                                        xPBaseLinkAccessor = linkAccessor2;
                                        j = j9;
                                    }
                                    arrayList2.add(new RoadSeqStageInfo().setDs(xPBaseLinkAccessor.getLength()).setTs(xPBaseLinkAccessor.getTravelTime()));
                                    i5 += xPBaseLinkAccessor.getLength();
                                    if (i5 > i3) {
                                        xPDrivePathAccessor.recycle();
                                        return arrayList2;
                                    }
                                    j9 = j;
                                }
                                i14++;
                            }
                            j4 = j9;
                        } else {
                            if (z && z2) {
                                int i15 = 0;
                                while (!isInterrupted()) {
                                    long j11 = i15;
                                    if (j11 >= segmentAccessor.getLinkCount()) {
                                        break;
                                    }
                                    XPBaseLinkAccessor linkAccessor3 = segmentAccessor.getLinkAccessor(j11);
                                    if (linkAccessor3 != null) {
                                        i6 = i11;
                                        j3 = addKeyPoint(j3, travelTime, linkAccessor3, arrayList3);
                                    } else {
                                        i6 = i11;
                                    }
                                    i15++;
                                    i11 = i6;
                                }
                            }
                            i5 = i11;
                        }
                        int length2 = (int) (i5 + segmentAccessor.getLength());
                        arrayList2.add(new RoadSeqStageInfo().setDs(segmentAccessor.getLength()).setTs(segmentAccessor.getTravelTime()));
                        i11 = length2;
                    }
                    i10 = i4 + 1;
                    i8 = i;
                    i9 = i2;
                    drivePathAccessor = xPDrivePathAccessor;
                }
                i4 = i10;
                i10 = i4 + 1;
                i8 = i;
                i9 = i2;
                drivePathAccessor = xPDrivePathAccessor;
            }
        }
        XPDrivePathAccessor xPDrivePathAccessor2 = drivePathAccessor;
        if (isInterrupted()) {
            L.i(TAG, "getStageList return null for reason( interrupted)");
            arrayList = null;
        } else {
            arrayList = arrayList2;
        }
        String str = "getStageList return stageList isNotEmpty:" + CollectionUtils.isNotEmpty(arrayList);
        if (!str.equals(sPreviousStateListLog)) {
            sPreviousStateListLog = str;
            L.i(TAG, str);
        }
        xPDrivePathAccessor2.recycle();
        return arrayList;
    }

    private static long addHighWayDis(XPBaseLinkAccessor xPBaseLinkAccessor, long j) {
        return xPBaseLinkAccessor.getRoadClass() == 0 ? xPBaseLinkAccessor.getLength() + j : j;
    }

    private static long addKeyPoint(long j, long j2, XPBaseLinkAccessor xPBaseLinkAccessor, List<Coord2DDouble> list) {
        long travelTime;
        long size;
        if (xPBaseLinkAccessor.getTravelTime() + j > j2) {
            ArrayList<Coord2DDouble> points = xPBaseLinkAccessor.getPoints();
            if (CollectionUtils.isNotEmpty(points)) {
                long travelTime2 = xPBaseLinkAccessor.getTravelTime() / points.size();
                if (travelTime2 > 0) {
                    size = (j2 - j) / travelTime2;
                } else {
                    size = points.size() - 1;
                }
                list.add(points.get(Math.min(Math.max((int) size, 0), points.size() - 1)));
                return 0L;
            }
            travelTime = xPBaseLinkAccessor.getTravelTime();
        } else {
            travelTime = xPBaseLinkAccessor.getTravelTime();
        }
        return j + travelTime;
    }

    public static double getSpeed(RoadSeqStageInfo roadSeqStageInfo) {
        return (((float) roadSeqStageInfo.getDs()) / ((float) roadSeqStageInfo.getTs())) * 3.6d;
    }
}
