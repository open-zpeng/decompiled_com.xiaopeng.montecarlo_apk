package com.xiaopeng.montecarlo.navcore.util;

import android.annotation.SuppressLint;
import android.car.hardware.xpu.XpuProtoMessage;
import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.root.util.L;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class XPUDataFormatHelper {
    private static final L.Tag TAG = new L.Tag("XPUDataFormatUtils");

    /* loaded from: classes3.dex */
    private static final class Holder {
        @SuppressLint({"StaticFieldLeak"})
        static XPUDataFormatHelper INSTANCE = new XPUDataFormatHelper();

        private Holder() {
        }
    }

    public static XPUDataFormatHelper getInstance() {
        return Holder.INSTANCE;
    }

    private XPUDataFormatHelper() {
    }

    public ArrayList<XpuProtoMessage.V2_Point> getCurrentRouteAllPoints() {
        List<XPCoordinate2DDouble> currentRouteAllPoints = TBTManager.getInstance().getCurrentRouteAllPoints();
        ArrayList<XpuProtoMessage.V2_Point> arrayList = new ArrayList<>();
        if (currentRouteAllPoints != null && !currentRouteAllPoints.isEmpty()) {
            L.Tag tag = TAG;
            L.i(tag, "getCurrentRouteAllPoints currentRoutePoints size : " + currentRouteAllPoints.size());
            for (int i = 0; i < currentRouteAllPoints.size(); i++) {
                XPCoordinate2DDouble xPCoordinate2DDouble = currentRouteAllPoints.get(i);
                if (xPCoordinate2DDouble != null) {
                    XpuProtoMessage.V2_Point.Builder newBuilder = XpuProtoMessage.V2_Point.newBuilder();
                    newBuilder.setLat((float) xPCoordinate2DDouble.mLat);
                    newBuilder.setLon((float) xPCoordinate2DDouble.mLon);
                    arrayList.add(newBuilder.build());
                }
            }
        }
        return arrayList;
    }
}
