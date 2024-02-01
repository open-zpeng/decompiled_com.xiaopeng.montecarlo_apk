package com.xiaopeng.montecarlo.mapoverlay.charge;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.xiaopeng.montecarlo.navcore.bean.map.XPPointBaseData;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.mapdisplay.MapViewWrapper;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
import com.xiaopeng.montecarlo.util.ViewCacheManager;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class ChargeBizDataManager {
    private static final L.Tag TAG = new L.Tag("ChargeBizDataManager");
    private static final ChargeBizDataManager sChargeBizDataManager = new ChargeBizDataManager();
    private final HashMap<String, ChargeBizData> mChargeMap = new HashMap<>();
    private final HashMap<Integer, ChargeBizData> mExistTextureIds = new HashMap<>();
    private AtomicInteger mAtomicInteger = new AtomicInteger(0);

    private ChargeBizDataManager() {
    }

    public static ChargeBizDataManager getInstance() {
        return sChargeBizDataManager;
    }

    public void createChargeBizData(XPPoiInfo xPPoiInfo, XPPointBaseData xPPointBaseData) {
        if (xPPoiInfo == null || xPPointBaseData == null || TextUtils.isEmpty(xPPointBaseData.id)) {
            L.d(TAG, "poi info id is invalid");
            return;
        }
        ChargeBizData chargeBizData = this.mChargeMap.get(xPPointBaseData.id);
        if (chargeBizData == null) {
            chargeBizData = new ChargeBizData();
            int[] generateTextureMarkerId = generateTextureMarkerId();
            chargeBizData.setTextureMarkerId(generateTextureMarkerId[0]);
            chargeBizData.setTextureFocusMarkerId(generateTextureMarkerId[1]);
            this.mExistTextureIds.put(Integer.valueOf(chargeBizData.getTextureMarkerId()), chargeBizData);
            this.mChargeMap.put(xPPointBaseData.id, chargeBizData);
        }
        chargeBizData.setXPPoiInfo(xPPoiInfo);
        chargeBizData.setBizPointBaseData(xPPointBaseData);
    }

    public ChargeBizData generateChargeTextureView(MapViewWrapper mapViewWrapper, String str, int i, ViewCacheManager viewCacheManager) {
        ChargeBizData chargeBizData = getChargeBizData(str);
        if (chargeBizData != null) {
            mapViewWrapper.cleanOverlayTexture(chargeBizData.getTextureMarkerId(), false);
            mapViewWrapper.cleanOverlayTexture(chargeBizData.getTextureFocusMarkerId(), false);
            createChargeTextureViewAync(mapViewWrapper, chargeBizData, i, viewCacheManager);
        }
        return chargeBizData;
    }

    public void createChargeTextureViewAync(final MapViewWrapper mapViewWrapper, final ChargeBizData chargeBizData, final int i, final ViewCacheManager viewCacheManager) {
        WorkThreadUtil.getInstance().executeCachedTask(new Runnable() { // from class: com.xiaopeng.montecarlo.mapoverlay.charge.ChargeBizDataManager.1
            @Override // java.lang.Runnable
            public void run() {
                ChargeBizDataManager.this.createChargeTextureViewSync(mapViewWrapper, chargeBizData, i, viewCacheManager);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0125 A[Catch: all -> 0x01ea, TryCatch #2 {, blocks: (B:4:0x0003, B:8:0x000d, B:13:0x001c, B:15:0x0050, B:17:0x005a, B:87:0x019f, B:89:0x01be, B:91:0x01cb, B:93:0x01d5, B:92:0x01d2, B:20:0x0076, B:23:0x0081, B:24:0x009d, B:28:0x00ae, B:30:0x00be, B:32:0x00c8, B:35:0x00d3, B:41:0x00ee, B:43:0x0101, B:44:0x010d, B:49:0x0125, B:53:0x0136, B:55:0x013e, B:59:0x0146, B:61:0x014d, B:65:0x015a, B:70:0x0169, B:72:0x016f, B:76:0x017c, B:81:0x018d), top: B:106:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x019f A[Catch: all -> 0x01ea, TryCatch #2 {, blocks: (B:4:0x0003, B:8:0x000d, B:13:0x001c, B:15:0x0050, B:17:0x005a, B:87:0x019f, B:89:0x01be, B:91:0x01cb, B:93:0x01d5, B:92:0x01d2, B:20:0x0076, B:23:0x0081, B:24:0x009d, B:28:0x00ae, B:30:0x00be, B:32:0x00c8, B:35:0x00d3, B:41:0x00ee, B:43:0x0101, B:44:0x010d, B:49:0x0125, B:53:0x0136, B:55:0x013e, B:59:0x0146, B:61:0x014d, B:65:0x015a, B:70:0x0169, B:72:0x016f, B:76:0x017c, B:81:0x018d), top: B:106:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01be A[Catch: all -> 0x01ea, TryCatch #2 {, blocks: (B:4:0x0003, B:8:0x000d, B:13:0x001c, B:15:0x0050, B:17:0x005a, B:87:0x019f, B:89:0x01be, B:91:0x01cb, B:93:0x01d5, B:92:0x01d2, B:20:0x0076, B:23:0x0081, B:24:0x009d, B:28:0x00ae, B:30:0x00be, B:32:0x00c8, B:35:0x00d3, B:41:0x00ee, B:43:0x0101, B:44:0x010d, B:49:0x0125, B:53:0x0136, B:55:0x013e, B:59:0x0146, B:61:0x014d, B:65:0x015a, B:70:0x0169, B:72:0x016f, B:76:0x017c, B:81:0x018d), top: B:106:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void createChargeTextureViewSync(com.xiaopeng.montecarlo.navcore.mapdisplay.MapViewWrapper r16, com.xiaopeng.montecarlo.mapoverlay.charge.ChargeBizData r17, int r18, com.xiaopeng.montecarlo.util.ViewCacheManager r19) {
        /*
            Method dump skipped, instructions count: 495
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.mapoverlay.charge.ChargeBizDataManager.createChargeTextureViewSync(com.xiaopeng.montecarlo.navcore.mapdisplay.MapViewWrapper, com.xiaopeng.montecarlo.mapoverlay.charge.ChargeBizData, int, com.xiaopeng.montecarlo.util.ViewCacheManager):void");
    }

    public void clearChargeBizData() {
        this.mExistTextureIds.clear();
        this.mChargeMap.clear();
    }

    @Nullable
    public ChargeBizData getChargeBizData(@NonNull String str) {
        return this.mChargeMap.get(str);
    }

    private int[] generateTextureMarkerId() {
        int[] iArr = new int[2];
        int i = this.mAtomicInteger.get();
        int andIncrement = this.mAtomicInteger.getAndIncrement();
        if (andIncrement >= 49) {
            this.mAtomicInteger.set(0);
        }
        while (true) {
            if (isIdValid(233 - andIncrement)) {
                break;
            }
            andIncrement = this.mAtomicInteger.getAndIncrement();
            if (andIncrement >= 49) {
                this.mAtomicInteger.set(0);
                continue;
            }
            if (andIncrement == i) {
                if (L.ENABLE) {
                    L.d(TAG, "POP=> generateTextureMarkerId dynamicId == dynamicIdBak");
                }
            }
        }
        iArr[0] = 233 - andIncrement;
        iArr[1] = 283 - andIncrement;
        return iArr;
    }

    private boolean isIdValid(int i) {
        return !this.mExistTextureIds.containsKey(Integer.valueOf(i));
    }

    public void clearChargeBizData(List<XPPointBaseData> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            ChargeBizData chargeBizData = getChargeBizData(list.get(i).id);
            if (chargeBizData != null) {
                this.mExistTextureIds.remove(Integer.valueOf(chargeBizData.getTextureMarkerId()));
                this.mChargeMap.remove(list.get(i).id);
                if (L.ENABLE) {
                    L.Tag tag = TAG;
                    L.d(tag, "POP=> clearChargeBizData removed.get(i).id = " + list.get(i).id);
                }
            }
        }
    }
}
