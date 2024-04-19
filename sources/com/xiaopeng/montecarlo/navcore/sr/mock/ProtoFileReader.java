package com.xiaopeng.montecarlo.navcore.sr.mock;

import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.root.util.L;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import lane.auto_pilot.data.AutoPilotDataOuterClass;
import xpilot.sr.proto.Imudata;
import xpilot.sr.proto.Nmeadata;
import xpilot.sr.proto.Overall;
/* loaded from: classes3.dex */
public class ProtoFileReader {
    private static final L.Tag TAG = new L.Tag("ProtoFileReader");

    public Overall.total_overall.Builder readProtoData(String str) {
        try {
            if (L.ENABLE) {
                L.d(TAG, "protoPath = " + str);
            }
            File[] listFiles = new File(str).listFiles();
            Arrays.sort(listFiles, Comparator.comparing($$Lambda$kCyoVs8f1BQue13GsNsOg7QJhsA.INSTANCE));
            Overall.total_overall.Builder newBuilder = Overall.total_overall.newBuilder();
            if (listFiles != null) {
                if (L.ENABLE) {
                    L.d(TAG, "files = " + listFiles.length);
                }
                for (File file : listFiles) {
                    if (file.isFile() && file.exists() && file.getPath().endsWith("proto")) {
                        if (L.ENABLE) {
                            L.d(TAG, "file = " + file.getName());
                        }
                        try {
                            FileInputStream fileInputStream = new FileInputStream(file);
                            newBuilder.addAllOverall(Overall.total_overall.parseFrom(fileInputStream).getOverallList());
                            fileInputStream.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                            if (L.ENABLE) {
                                L.d(TAG, "readFile error, exception = " + e.toString());
                            }
                            if (newBuilder.getOverallCount() == 0) {
                                return null;
                            }
                        }
                    }
                }
                if (L.ENABLE) {
                    L.d(TAG, "mOverallBuilder.getOverallCount() = " + newBuilder.getOverallCount());
                }
            }
            return newBuilder;
        } catch (Exception e2) {
            e2.printStackTrace();
            if (L.ENABLE) {
                L.d(TAG, "readProtoData error, exception = " + e2.toString());
            }
            return null;
        }
    }

    public Overall.total_xpu_overall.Builder readXpuProtoData(String str) {
        try {
            if (L.ENABLE) {
                L.d(TAG, "protoPath = " + str);
            }
            File[] listFiles = new File(str).listFiles();
            Arrays.sort(listFiles, Comparator.comparing($$Lambda$kCyoVs8f1BQue13GsNsOg7QJhsA.INSTANCE));
            Overall.total_xpu_overall.Builder newBuilder = Overall.total_xpu_overall.newBuilder();
            HashMap hashMap = new HashMap();
            if (listFiles != null) {
                if (L.ENABLE) {
                    L.d(TAG, "files = " + listFiles.length);
                }
                for (File file : listFiles) {
                    if (file.isFile() && file.exists() && file.getPath().endsWith("proto")) {
                        if (L.ENABLE) {
                            L.d(TAG, "file = " + file.getName());
                        }
                        try {
                            FileInputStream fileInputStream = new FileInputStream(file);
                            Overall.save_sr_overall parseFrom = Overall.save_sr_overall.parseFrom(fileInputStream);
                            Overall.overall_cdutime overallData = parseFrom.getOverallData();
                            Overall.imu_cdutime imuData = parseFrom.getImuData();
                            Overall.gnss_cdutime gnssData = parseFrom.getGnssData();
                            if (overallData != null) {
                                parseXpuProtoData(hashMap, overallData);
                            }
                            if (imuData != null) {
                                parseXpuImuData(hashMap, imuData);
                            }
                            if (gnssData != null) {
                                parseXpuGnssData(hashMap, gnssData);
                            }
                            fileInputStream.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                            if (L.ENABLE) {
                                L.d(TAG, "readFile error, exception = " + e.toString());
                            }
                            if (hashMap.size() == 0) {
                                return null;
                            }
                        }
                    }
                }
                Iterator<Overall.xpu_data_to_app.Builder> it = sortByTimeAsc(hashMap).iterator();
                while (it.hasNext()) {
                    newBuilder.addXpuOverall(it.next());
                }
                if (L.ENABLE) {
                    L.d(TAG, "readXpuProtoData mOverallBuilder.getXpuOverallCount() = " + newBuilder.getXpuOverallCount());
                }
            }
            return newBuilder;
        } catch (Exception e2) {
            e2.printStackTrace();
            if (L.ENABLE) {
                L.d(TAG, "readXpuProtoData error, exception = " + e2.toString());
            }
            return null;
        }
    }

    private void parseXpuProtoData(@NonNull Map<Long, Overall.xpu_data_to_app.Builder> map, @NonNull Overall.overall_cdutime overall_cdutimeVar) {
        byte[] byteArray;
        byte[] byteArray2;
        if (overall_cdutimeVar.getCduTimeCount() == overall_cdutimeVar.getOverallGaodeCount()) {
            int cduTimeCount = overall_cdutimeVar.getCduTimeCount();
            for (int i = 0; i < cduTimeCount; i++) {
                long cduTime = overall_cdutimeVar.getCduTime(i);
                Overall.overall_gaode overallGaode = overall_cdutimeVar.getOverallGaode(i);
                if (overallGaode != null) {
                    AutoPilotDataOuterClass.AutoPilotData autoPilotData = overallGaode.getAutoPilotData();
                    Overall.overall overall = overallGaode.getOverall();
                    if (autoPilotData != null && ((byteArray2 = autoPilotData.toByteArray()) == null || byteArray2.length == 0)) {
                        L.i(TAG, "111 setTONull");
                        autoPilotData = null;
                    }
                    if (overall != null && ((byteArray = overall.toByteArray()) == null || byteArray.length == 0)) {
                        L.i(TAG, "222 srData2App setTONull");
                        overall = null;
                    }
                    if (autoPilotData != null || overall != null) {
                        Overall.xpu_data_to_app.Builder builder = map.get(Long.valueOf(cduTime));
                        if (builder == null) {
                            builder = Overall.xpu_data_to_app.newBuilder();
                            map.put(Long.valueOf(cduTime), builder);
                        }
                        builder.setCduTime(cduTime);
                        builder.setAutoPilotData(autoPilotData);
                        builder.setOverall(overall);
                    }
                }
            }
            return;
        }
        L.e(TAG, "1.cduTimeCount :" + overall_cdutimeVar.getCduTimeCount() + " != protoCount:" + overall_cdutimeVar.getOverallGaodeCount());
    }

    private void parseXpuImuData(@NonNull Map<Long, Overall.xpu_data_to_app.Builder> map, @NonNull Overall.imu_cdutime imu_cdutimeVar) {
        if (imu_cdutimeVar.getCduTimeCount() == imu_cdutimeVar.getImuInfoCount()) {
            int cduTimeCount = imu_cdutimeVar.getCduTimeCount();
            for (int i = 0; i < cduTimeCount; i++) {
                long cduTime = imu_cdutimeVar.getCduTime(i);
                Imudata.ImuInfo imuInfo = imu_cdutimeVar.getImuInfo(i);
                if (imuInfo != null) {
                    Overall.xpu_data_to_app.Builder builder = map.get(Long.valueOf(cduTime));
                    if (builder == null) {
                        builder = Overall.xpu_data_to_app.newBuilder();
                        map.put(Long.valueOf(cduTime), builder);
                    }
                    builder.setCduTime(cduTime);
                    builder.setImuInfo(imuInfo);
                }
            }
            return;
        }
        L.Tag tag = TAG;
        L.e(tag, "2.cduTimeCount :" + imu_cdutimeVar.getCduTimeCount() + " != imuInfoCount:" + imu_cdutimeVar.getImuInfoCount());
    }

    private void parseXpuGnssData(@NonNull Map<Long, Overall.xpu_data_to_app.Builder> map, @NonNull Overall.gnss_cdutime gnss_cdutimeVar) {
        if (gnss_cdutimeVar.getCduTimeCount() == gnss_cdutimeVar.getNmeadataInfoCount()) {
            int cduTimeCount = gnss_cdutimeVar.getCduTimeCount();
            for (int i = 0; i < cduTimeCount; i++) {
                long cduTime = gnss_cdutimeVar.getCduTime(i);
                Nmeadata.NmeadataInfo nmeadataInfo = gnss_cdutimeVar.getNmeadataInfo(i);
                if (nmeadataInfo != null) {
                    Overall.xpu_data_to_app.Builder builder = map.get(Long.valueOf(cduTime));
                    if (builder == null) {
                        builder = Overall.xpu_data_to_app.newBuilder();
                        map.put(Long.valueOf(cduTime), builder);
                    }
                    builder.setCduTime(cduTime);
                    builder.setNmeadataInfo(nmeadataInfo);
                }
            }
            return;
        }
        L.Tag tag = TAG;
        L.e(tag, "3.cduTimeCount :" + gnss_cdutimeVar.getCduTimeCount() + " !=  NmeadataInfoCount:" + gnss_cdutimeVar.getNmeadataInfoCount());
    }

    private ArrayList<Overall.xpu_data_to_app.Builder> sortByTimeAsc(@NonNull Map<Long, Overall.xpu_data_to_app.Builder> map) {
        ArrayList<Overall.xpu_data_to_app.Builder> arrayList = new ArrayList<>(map.values());
        arrayList.sort(new Comparator() { // from class: com.xiaopeng.montecarlo.navcore.sr.mock.-$$Lambda$ProtoFileReader$l995R5qdfh7gqhzrJeL1oMlWPB8
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int compare;
                compare = Long.compare(((Overall.xpu_data_to_app.Builder) obj).getCduTime(), ((Overall.xpu_data_to_app.Builder) obj2).getCduTime());
                return compare;
            }
        });
        return arrayList;
    }
}
