package com.xiaopeng.montecarlo.appengine;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.xiaopeng.lib.apirouter.ApiRouter;
import com.xiaopeng.lib.apirouter.server.IServicePublisher;
import com.xiaopeng.lib.apirouter.server.Publish;
import com.xiaopeng.montecarlo.navcore.bean.VPABean;
import com.xiaopeng.montecarlo.navcore.database.VPADataHelper;
import com.xiaopeng.montecarlo.navcore.database.bean.greendao.VPAInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.root.util.GsonUtil;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class MapVPAService implements IServicePublisher {
    private static final String AUTHORITY = "com.xiaopeng.montecarlo.MapVPAService";
    private static final L.Tag TAG = new L.Tag("MapVPAService");
    private static final String VPA_FILE_PATH = RootUtil.SD_CARD_FULL_MAP_PATH + "/listF_@{version}.json";
    private static final MutableLiveData<String> sVPAVersion = new MutableLiveData<>();

    public static void testUpdateVPA(String str) {
        try {
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, "testUpdateVPA version = " + str + ", thread = " + Thread.currentThread().getName());
            }
            Uri.Builder builder = new Uri.Builder();
            builder.authority(AUTHORITY).path("update").appendQueryParameter("version", str);
            ApiRouter.route(builder.build());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void observerVPA(@NonNull LifecycleOwner lifecycleOwner, Observer<String> observer) {
        sVPAVersion.observe(lifecycleOwner, observer);
    }

    public static void checkVPAVersion() {
        try {
            Uri.Builder builder = new Uri.Builder();
            builder.authority("com.xiaopeng.hiddenCam.RouteSrHdPkmap").path("routeNavi2HdPkmapApplyListF");
            ApiRouter.route(builder.build());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Publish
    public void update(final String str) {
        L.Tag tag = TAG;
        L.i(tag, "update version = " + str + ", thread = " + Thread.currentThread().getName());
        WorkThreadUtil.getInstance().executeIOTask(new Runnable() { // from class: com.xiaopeng.montecarlo.appengine.-$$Lambda$MapVPAService$iThKrbfnV27jzLzC_nscK-NtTzE
            @Override // java.lang.Runnable
            public final void run() {
                MapVPAService.this.lambda$update$0$MapVPAService(str);
            }
        });
    }

    public /* synthetic */ void lambda$update$0$MapVPAService(String str) {
        if (TextUtils.isEmpty(str)) {
            VPADataHelper.clearData();
            return;
        }
        String readVPAFile = readVPAFile(VPA_FILE_PATH.replace("@{version}", str));
        if (TextUtils.isEmpty(readVPAFile)) {
            return;
        }
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "update version = " + str + " , json = " + readVPAFile);
        }
        VPABean vPABean = (VPABean) GsonUtil.fromJson(readVPAFile, (Class<Object>) VPABean.class);
        if (vPABean == null) {
            L.e(TAG, "update vpa == null");
        } else if (updateDB(vPABean)) {
            L.Tag tag2 = TAG;
            L.i(tag2, "update vpa version = " + str);
            sVPAVersion.postValue(str);
        }
    }

    private boolean updateDB(@NonNull VPABean vPABean) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "update vpa = " + vPABean.toString());
        }
        ArrayList arrayList = new ArrayList();
        if (vPABean.getCities() == null) {
            return false;
        }
        for (VPABean.Cities cities : vPABean.getCities()) {
            if (cities != null && cities.getGarages() != null) {
                for (VPABean.Cities.Garages garages : cities.getGarages()) {
                    if (garages != null) {
                        VPAInfo vPAInfo = new VPAInfo();
                        vPAInfo.setCityCode(cities.getCityId());
                        vPAInfo.setCityName(cities.getName());
                        vPAInfo.setGarageId(garages.getId());
                        StringBuilder sb = new StringBuilder();
                        if (garages.getVenue() != null) {
                            for (String str : garages.getVenue()) {
                                sb.append(str);
                                sb.append(",");
                            }
                            vPAInfo.setPath(sb.toString());
                        }
                        if (garages.getEntranceLoc() != null && garages.getEntranceLoc().size() == 2) {
                            Coord3DDouble coord3DDouble = new Coord3DDouble();
                            coord3DDouble.lon = garages.getEntranceLoc().get(0).doubleValue();
                            coord3DDouble.lat = garages.getEntranceLoc().get(1).doubleValue();
                            Coord3DDouble encryptLonLat = TBTManager.getInstance().getPosServiceWrapper().encryptLonLat(coord3DDouble);
                            if (encryptLonLat != null) {
                                if (L.ENABLE) {
                                    L.Tag tag2 = TAG;
                                    L.d(tag2, "VPA wgsPoint.lat = " + coord3DDouble.lat + " , wgsPoint.lon = " + coord3DDouble.lon);
                                    L.Tag tag3 = TAG;
                                    L.d(tag3, "VPA encryptPoint.lat = " + encryptLonLat.lat + " , encryptPoint.lon = " + encryptLonLat.lon);
                                }
                                vPAInfo.setLat(encryptLonLat.lat);
                                vPAInfo.setLon(encryptLonLat.lon);
                                arrayList.add(vPAInfo);
                            }
                        }
                    }
                }
            }
        }
        if (L.ENABLE) {
            L.Tag tag4 = TAG;
            L.d(tag4, "list.size = " + arrayList.toString());
        }
        return VPADataHelper.replaceAllData(arrayList);
    }

    private String readVPAFile(String str) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(str))));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb.append(readLine);
                } else {
                    String sb2 = sb.toString();
                    bufferedReader.close();
                    return sb2;
                }
            }
        } catch (Exception e) {
            L.Tag tag = TAG;
            L.e(tag, "readVPAFile Exception : " + e);
            return null;
        }
    }
}
