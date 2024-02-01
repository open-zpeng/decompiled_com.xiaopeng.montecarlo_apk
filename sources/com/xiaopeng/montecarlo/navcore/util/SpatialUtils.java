package com.xiaopeng.montecarlo.navcore.util;

import androidx.annotation.Nullable;
import com.autonavi.gbl.common.model.Coord2DDouble;
import com.xiaopeng.montecarlo.root.util.L;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class SpatialUtils {
    private static final int DEFAULT_EPSILON_IN_METER = 10;
    private static final double METER_MD5_FACTOR = 111320.0d;
    private static final L.Tag TAG = new L.Tag("SpatialUtils");

    @Nullable
    public static List<Coord2DDouble> reducePoints(List<Coord2DDouble> list) {
        return reducePoints(list, 10);
    }

    @Nullable
    public static List<Coord2DDouble> reducePoints(@Nullable List<Coord2DDouble> list, int i) {
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
            List<Coord2DDouble> reducePoints = reducePoints(arrayList2, i);
            List<Coord2DDouble> reducePoints2 = reducePoints(arrayList3, i);
            reducePoints2.remove(0);
            reducePoints.addAll(reducePoints2);
            return reducePoints;
        }
        arrayList.add(list.get(0));
        arrayList.add(list.get(i2));
        return arrayList;
    }

    public static boolean checkInRange(@Nullable Coord2DDouble coord2DDouble, @Nullable List<Coord2DDouble> list, double d) {
        if (list != null && coord2DDouble != null) {
            if (1 == list.size()) {
                return ((double) calculateDistance(coord2DDouble, list.get(0))) <= d;
            }
            double d2 = Double.MAX_VALUE;
            for (int i = 1; i < list.size(); i++) {
                double calculateDistance = calculateDistance(coord2DDouble, list.get(i - 1), list.get(i));
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

    public static int calculateDistance(Coord2DDouble coord2DDouble, Coord2DDouble coord2DDouble2) {
        double cos = Math.cos((((coord2DDouble.lat + coord2DDouble2.lon) / 2.0d) * 3.141592653589793d) / 180.0d);
        double d = coord2DDouble.lat - coord2DDouble2.lat;
        double d2 = (coord2DDouble.lon - coord2DDouble2.lon) * cos;
        return (int) (Math.sqrt((d * d) + (d2 * d2)) * METER_MD5_FACTOR);
    }

    public static double calculateDistance(Coord2DDouble coord2DDouble, Coord2DDouble coord2DDouble2, Coord2DDouble coord2DDouble3) {
        int calculateDistance;
        double d = coord2DDouble.lat;
        double d2 = coord2DDouble.lon;
        double d3 = coord2DDouble2.lat;
        double d4 = coord2DDouble2.lon;
        double d5 = coord2DDouble3.lat - d3;
        double d6 = coord2DDouble3.lon - d4;
        double d7 = ((d2 - d4) * d6) + ((d - d3) * d5);
        double d8 = (d6 * d6) + (d5 * d5);
        if (Math.abs(d8) < 1.0E-10d) {
            calculateDistance = calculateDistance(coord2DDouble2, coord2DDouble);
        } else if (d7 < 0.0d) {
            calculateDistance = calculateDistance(coord2DDouble, coord2DDouble2);
        } else if (d7 > d8) {
            calculateDistance = calculateDistance(coord2DDouble, coord2DDouble3);
        } else {
            double d9 = d7 / d8;
            calculateDistance = calculateDistance(coord2DDouble, new Coord2DDouble(d4 + (d9 * d6), d3 + (d5 * d9)));
        }
        return calculateDistance;
    }

    public static double calculateDistance(@Nullable Coord2DDouble coord2DDouble, @Nullable List<Coord2DDouble> list) {
        if (list == null || coord2DDouble == null) {
            return 2.147483647E9d;
        }
        if (1 == list.size()) {
            return calculateDistance(coord2DDouble, list.get(0));
        }
        double d = Double.MAX_VALUE;
        for (int i = 1; i < list.size(); i++) {
            double calculateDistance = calculateDistance(coord2DDouble, list.get(i - 1), list.get(i));
            if (calculateDistance < d) {
                d = calculateDistance;
            }
        }
        return d;
    }
}
