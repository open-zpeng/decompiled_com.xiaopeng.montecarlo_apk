package com.xiaopeng.montecarlo.mapoverlay.charge;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.xiaopeng.montecarlo.navcore.bean.map.XPPointBaseData;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.mapdisplay.MapViewWrapper;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
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

    public ChargeBizData generateChargeTextureView(MapViewWrapper mapViewWrapper, String str) {
        ChargeBizData chargeBizData = getChargeBizData(str);
        if (chargeBizData != null) {
            mapViewWrapper.cleanOverlayTexture(chargeBizData.getTextureMarkerId(), false);
            mapViewWrapper.cleanOverlayTexture(chargeBizData.getTextureFocusMarkerId(), false);
            createChargeTextureViewAync(mapViewWrapper, chargeBizData);
        }
        return chargeBizData;
    }

    public void createChargeTextureViewAync(final MapViewWrapper mapViewWrapper, final ChargeBizData chargeBizData) {
        WorkThreadUtil.getInstance().executeCachedTask(new Runnable() { // from class: com.xiaopeng.montecarlo.mapoverlay.charge.ChargeBizDataManager.1
            @Override // java.lang.Runnable
            public void run() {
                ChargeBizDataManager.this.createChargeTextureViewSync(mapViewWrapper, chargeBizData);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:98:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void createChargeTextureViewSync(com.xiaopeng.montecarlo.navcore.mapdisplay.MapViewWrapper r14, com.xiaopeng.montecarlo.mapoverlay.charge.ChargeBizData r15) {
        /*
            Method dump skipped, instructions count: 448
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.mapoverlay.charge.ChargeBizDataManager.createChargeTextureViewSync(com.xiaopeng.montecarlo.navcore.mapdisplay.MapViewWrapper, com.xiaopeng.montecarlo.mapoverlay.charge.ChargeBizData):void");
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
