package com.xiaopeng.montecarlo.navcore.adasehp;

import com.autonavi.gbl.ehp.EHPService;
import com.autonavi.gbl.ehp.model.EHPDataOperateType;
import com.autonavi.gbl.ehp.model.EHPInitParam;
import com.autonavi.gbl.ehp.observer.IEHPOutputObserver;
import com.autonavi.gbl.servicemanager.ServiceMgr;
import com.xiaopeng.montecarlo.root.carfeature.CarFeatureManager;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import com.xiaopeng.montecarlo.root.util.ioutil.FileUtil;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class EHPServiceWrapper {
    private static final String ASSET_NAVI_CONFIG_NAME = "blRes/GNaviConfig.xml";
    private static final String CONFIG_NAME = "/EhpConfig.dat";
    private static final String NAVI_CONFIG_NAME = "/GNaviConfig.xml";
    private static final int RETRY_COUNT = 3;
    private static final L.Tag TAG = new L.Tag("EHPServiceWrapper");
    private EHPService mEHPService;

    public boolean afterMapDataOperation(ArrayList<Integer> arrayList, @EHPDataOperateType.EHPDataOperateType1 int i) {
        return false;
    }

    public boolean beforeMapDataOperation(ArrayList<Integer> arrayList, @EHPDataOperateType.EHPDataOperateType1 int i) {
        return false;
    }

    public boolean isEhpInited() {
        EHPService eHPService = this.mEHPService;
        return eHPService != null && eHPService.isInit() == 3;
    }

    public boolean init(boolean z) {
        EHPService eHPService = this.mEHPService;
        if (eHPService != null) {
            return 3 == eHPService.isInit();
        }
        this.mEHPService = (EHPService) ServiceMgr.getServiceMgrInstance().getBLService(20);
        EHPInitParam eHPInitParam = new EHPInitParam();
        eHPInitParam.configPath = RootUtil.SD_CARD_NAVI_PATH + CONFIG_NAME;
        eHPInitParam.enableNoRouteSendOnInit = z;
        boolean init = this.mEHPService.init(eHPInitParam);
        String configFolder = CarFeatureManager.INSTANCE.getConfigFolder();
        for (int i = 0; !init && i < 3; i++) {
            L.Tag tag = TAG;
            L.i(tag, "EHPService init fail retry retryCnt=" + i);
            FileUtil.deleteFile(RootUtil.SD_CARD_NAVI_PATH + NAVI_CONFIG_NAME);
            FileUtil.deleteFile(RootUtil.SD_CARD_NAVI_PATH + CONFIG_NAME);
            FileUtil.copyFileFromAssets(ASSET_NAVI_CONFIG_NAME, RootUtil.SD_CARD_NAVI_PATH, NAVI_CONFIG_NAME);
            if (configFolder != null) {
                FileUtil.copyFileFromAssets("blRes/" + configFolder + "EhpConfig.dat", RootUtil.SD_CARD_NAVI_PATH, CONFIG_NAME);
            }
            init = this.mEHPService.init(eHPInitParam);
        }
        return init;
    }

    public boolean uninit() {
        if (isEhpInited()) {
            this.mEHPService.clearOutputObserver();
            this.mEHPService.unInit();
            ServiceMgr.getServiceMgrInstance().removeBLService(20);
            this.mEHPService = null;
            return true;
        }
        return false;
    }

    public boolean setConfigValue(int i, int i2) {
        if (isEhpInited()) {
            return this.mEHPService.setConfigValue(i, i2);
        }
        return false;
    }

    public boolean setAutoUpdateRoute(boolean z) {
        boolean z2 = false;
        if (isEhpInited()) {
            EHPService eHPService = this.mEHPService;
            if (eHPService != null && eHPService.setAutoUpdateRoute(z)) {
                z2 = true;
            }
            L.i(TAG, "EHPService setAutoUpdateRoute autoNotify= " + z + " extendService = " + this.mEHPService + " result = " + z2);
        }
        return z2;
    }

    public boolean addEhpOutputObserver(IEHPOutputObserver iEHPOutputObserver) {
        if (iEHPOutputObserver == null || !isEhpInited()) {
            return false;
        }
        L.i(TAG, "EHPService addEhpOutputObserver");
        return this.mEHPService.addOutputObserver(iEHPOutputObserver);
    }

    public boolean removeEhpOutputObserver(IEHPOutputObserver iEHPOutputObserver) {
        if (iEHPOutputObserver == null || !isEhpInited()) {
            return false;
        }
        L.i(TAG, "EHPService removeEhpOutputObserver");
        return this.mEHPService.removeOutputObserver(iEHPOutputObserver);
    }

    public void updateNetworkStatus(int i) {
        if (isEhpInited()) {
            this.mEHPService.updateNetworkStatus(i);
        }
    }

    public String getEHPServiceVersion() {
        return isEhpInited() ? this.mEHPService.getVersion() : "";
    }

    public String getEHPServiceEngineeVersion() {
        return EHPService.getEngineVersion();
    }
}
