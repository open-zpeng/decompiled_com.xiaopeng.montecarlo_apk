package com.xiaopeng.montecarlo.navcore.util;

import androidx.annotation.Nullable;
import com.autonavi.gbl.common.model.Coord2DInt32;
import com.xiaopeng.montecarlo.root.util.L;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class SpatialInt32Utils {
    private static final int DEFAULT_EPSILON_IN_METER = 10;
    private static final double METER_MD5_FACTOR = 111320.0d;
    private static final L.Tag TAG = new L.Tag("SpatialUtils");

    @Nullable
    public static List<Coord2DInt32> reducePoints(List<Coord2DInt32> list) {
        return reducePoints(list, 10);
    }

    @Nullable
    public static List<Coord2DInt32> reducePoints(@Nullable List<Coord2DInt32> list, int i) {
        int i2;
        if (list == null || list.size() <= 2) {
            return list;
        }
        double d = 0.0d;
        int size = list.size();
        int i3 = 1;
        int i4 = 0;
        while (true) {
            i2 = size - 1;
            if (i3 >= i2) {
                break;
            }
            double calculateDistance = calculateDistance(list.get(i3), list.get(0), list.get(i2));
            if (calculateDistance > d) {
                i4 = i3;
                d = calculateDistance;
            }
            i3++;
        }
        ArrayList arrayList = new ArrayList();
        if (d > i) {
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            for (int i5 = 0; i5 < size; i5++) {
                if (i5 <= i4) {
                    arrayList2.add(list.get(i5));
                    if (i5 == i4) {
                        arrayList3.add(list.get(i5));
                    }
                } else {
                    arrayList3.add(list.get(i5));
                }
            }
            new ArrayList();
            new ArrayList();
            List<Coord2DInt32> reducePoints = reducePoints(arrayList2, i);
            List<Coord2DInt32> reducePoints2 = reducePoints(arrayList3, i);
            reducePoints2.remove(0);
            reducePoints.addAll(reducePoints2);
            return reducePoints;
        }
        arrayList.add(list.get(0));
        arrayList.add(list.get(i2));
        return arrayList;
    }

    public static boolean checkInRange(@Nullable Coord2DInt32 coord2DInt32, @Nullable List<Coord2DInt32> list, double d) {
        if (list != null && coord2DInt32 != null) {
            if (1 == list.size()) {
                return ((double) calculateDistance(coord2DInt32, list.get(0))) <= d;
            }
            double d2 = Double.MAX_VALUE;
            for (int i = 1; i < list.size(); i++) {
                double calculateDistance = calculateDistance(coord2DInt32, list.get(i - 1), list.get(i));
                if (d2 >= calculateDistance) {
                    d2 = calculateDistance;
                }
                if (calculateDistance <= d) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int calculateDistance(Coord2DInt32 coord2DInt32, Coord2DInt32 coord2DInt322) {
        double cos = Math.cos((((coord2DInt32.lat + coord2DInt322.lon) / 2.0d) * 3.141592653589793d) / 180.0d);
        double d = coord2DInt32.lat - coord2DInt322.lat;
        double d2 = (coord2DInt32.lon - coord2DInt322.lon) * cos;
        return (int) (Math.sqrt((d * d) + (d2 * d2)) * METER_MD5_FACTOR);
    }

    public static double calculateDistance(Coord2DInt32 coord2DInt32, Coord2DInt32 coord2DInt322, Coord2DInt32 coord2DInt323) {
        int calculateDistance;
        int i = coord2DInt32.lat;
        int i2 = coord2DInt32.lon;
        int i3 = coord2DInt322.lat;
        int i4 = coord2DInt322.lon;
        int i5 = coord2DInt323.lat - i3;
        int i6 = coord2DInt323.lon - i4;
        int i7 = ((i2 - i4) * i6) + ((i - i3) * i5);
        int i8 = (i6 * i6) + (i5 * i5);
        if (Math.abs(i8) < 1.0E-10d) {
            calculateDistance = calculateDistance(coord2DInt322, coord2DInt32);
        } else if (i7 < 0) {
            calculateDistance = calculateDistance(coord2DInt32, coord2DInt322);
        } else if (i7 > i8) {
            calculateDistance = calculateDistance(coord2DInt32, coord2DInt323);
        } else {
            int i9 = i7 / i8;
            calculateDistance = calculateDistance(coord2DInt32, new Coord2DInt32(i4 + (i9 * i6), i3 + (i5 * i9)));
        }
        return calculateDistance;
    }

    public static double calculateDistance(@Nullable Coord2DInt32 coord2DInt32, @Nullable List<Coord2DInt32> list) {
        if (list == null || coord2DInt32 == null) {
            return 2.147483647E9d;
        }
        if (1 == list.size()) {
            return calculateDistance(coord2DInt32, list.get(0));
        }
        double d = Double.MAX_VALUE;
        for (int i = 1; i < list.size(); i++) {
            double calculateDistance = calculateDistance(coord2DInt32, list.get(i - 1), list.get(i));
            if (calculateDistance < d) {
                d = calculateDistance;
            }
        }
        return d;
    }
}
