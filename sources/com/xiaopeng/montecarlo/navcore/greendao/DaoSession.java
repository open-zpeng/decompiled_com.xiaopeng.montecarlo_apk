package com.xiaopeng.montecarlo.navcore.greendao;

import com.xiaopeng.montecarlo.navcore.database.bean.greendao.CPDeepInfo;
import com.xiaopeng.montecarlo.navcore.database.bean.greendao.CPInfo;
import com.xiaopeng.montecarlo.navcore.database.bean.greendao.CarWashInfo;
import com.xiaopeng.montecarlo.navcore.database.bean.greendao.LccGeoFenceInfo;
import com.xiaopeng.montecarlo.navcore.database.bean.greendao.Level500CellInfo;
import com.xiaopeng.montecarlo.navcore.database.bean.greendao.VPAInfo;
import com.xiaopeng.montecarlo.navcore.database.bean.greendao.XPKeywordConfigInfo;
import com.xiaopeng.montecarlo.navcore.database.bean.greendao.XPScratchSpotInfo;
import com.xiaopeng.montecarlo.navcore.database.bean.greendao.XPServiceCenterInfo;
import com.xiaopeng.montecarlo.navcore.database.bean.greendao.XPWebConfigInfo;
import java.util.Map;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;
/* loaded from: classes3.dex */
public class DaoSession extends AbstractDaoSession {
    private final CPDeepInfoDao cPDeepInfoDao;
    private final DaoConfig cPDeepInfoDaoConfig;
    private final CPInfoDao cPInfoDao;
    private final DaoConfig cPInfoDaoConfig;
    private final CarWashInfoDao carWashInfoDao;
    private final DaoConfig carWashInfoDaoConfig;
    private final LccGeoFenceInfoDao lccGeoFenceInfoDao;
    private final DaoConfig lccGeoFenceInfoDaoConfig;
    private final Level500CellInfoDao level500CellInfoDao;
    private final DaoConfig level500CellInfoDaoConfig;
    private final VPAInfoDao vPAInfoDao;
    private final DaoConfig vPAInfoDaoConfig;
    private final XPKeywordConfigInfoDao xPKeywordConfigInfoDao;
    private final DaoConfig xPKeywordConfigInfoDaoConfig;
    private final XPScratchSpotInfoDao xPScratchSpotInfoDao;
    private final DaoConfig xPScratchSpotInfoDaoConfig;
    private final XPServiceCenterInfoDao xPServiceCenterInfoDao;
    private final DaoConfig xPServiceCenterInfoDaoConfig;
    private final XPWebConfigInfoDao xPWebConfigInfoDao;
    private final DaoConfig xPWebConfigInfoDaoConfig;

    public DaoSession(Database database, IdentityScopeType identityScopeType, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig> map) {
        super(database);
        this.cPDeepInfoDaoConfig = map.get(CPDeepInfoDao.class).clone();
        this.cPDeepInfoDaoConfig.initIdentityScope(identityScopeType);
        this.cPInfoDaoConfig = map.get(CPInfoDao.class).clone();
        this.cPInfoDaoConfig.initIdentityScope(identityScopeType);
        this.carWashInfoDaoConfig = map.get(CarWashInfoDao.class).clone();
        this.carWashInfoDaoConfig.initIdentityScope(identityScopeType);
        this.lccGeoFenceInfoDaoConfig = map.get(LccGeoFenceInfoDao.class).clone();
        this.lccGeoFenceInfoDaoConfig.initIdentityScope(identityScopeType);
        this.level500CellInfoDaoConfig = map.get(Level500CellInfoDao.class).clone();
        this.level500CellInfoDaoConfig.initIdentityScope(identityScopeType);
        this.vPAInfoDaoConfig = map.get(VPAInfoDao.class).clone();
        this.vPAInfoDaoConfig.initIdentityScope(identityScopeType);
        this.xPKeywordConfigInfoDaoConfig = map.get(XPKeywordConfigInfoDao.class).clone();
        this.xPKeywordConfigInfoDaoConfig.initIdentityScope(identityScopeType);
        this.xPScratchSpotInfoDaoConfig = map.get(XPScratchSpotInfoDao.class).clone();
        this.xPScratchSpotInfoDaoConfig.initIdentityScope(identityScopeType);
        this.xPServiceCenterInfoDaoConfig = map.get(XPServiceCenterInfoDao.class).clone();
        this.xPServiceCenterInfoDaoConfig.initIdentityScope(identityScopeType);
        this.xPWebConfigInfoDaoConfig = map.get(XPWebConfigInfoDao.class).clone();
        this.xPWebConfigInfoDaoConfig.initIdentityScope(identityScopeType);
        this.cPDeepInfoDao = new CPDeepInfoDao(this.cPDeepInfoDaoConfig, this);
        this.cPInfoDao = new CPInfoDao(this.cPInfoDaoConfig, this);
        this.carWashInfoDao = new CarWashInfoDao(this.carWashInfoDaoConfig, this);
        this.lccGeoFenceInfoDao = new LccGeoFenceInfoDao(this.lccGeoFenceInfoDaoConfig, this);
        this.level500CellInfoDao = new Level500CellInfoDao(this.level500CellInfoDaoConfig, this);
        this.vPAInfoDao = new VPAInfoDao(this.vPAInfoDaoConfig, this);
        this.xPKeywordConfigInfoDao = new XPKeywordConfigInfoDao(this.xPKeywordConfigInfoDaoConfig, this);
        this.xPScratchSpotInfoDao = new XPScratchSpotInfoDao(this.xPScratchSpotInfoDaoConfig, this);
        this.xPServiceCenterInfoDao = new XPServiceCenterInfoDao(this.xPServiceCenterInfoDaoConfig, this);
        this.xPWebConfigInfoDao = new XPWebConfigInfoDao(this.xPWebConfigInfoDaoConfig, this);
        registerDao(CPDeepInfo.class, this.cPDeepInfoDao);
        registerDao(CPInfo.class, this.cPInfoDao);
        registerDao(CarWashInfo.class, this.carWashInfoDao);
        registerDao(LccGeoFenceInfo.class, this.lccGeoFenceInfoDao);
        registerDao(Level500CellInfo.class, this.level500CellInfoDao);
        registerDao(VPAInfo.class, this.vPAInfoDao);
        registerDao(XPKeywordConfigInfo.class, this.xPKeywordConfigInfoDao);
        registerDao(XPScratchSpotInfo.class, this.xPScratchSpotInfoDao);
        registerDao(XPServiceCenterInfo.class, this.xPServiceCenterInfoDao);
        registerDao(XPWebConfigInfo.class, this.xPWebConfigInfoDao);
    }

    public void clear() {
        this.cPDeepInfoDaoConfig.clearIdentityScope();
        this.cPInfoDaoConfig.clearIdentityScope();
        this.carWashInfoDaoConfig.clearIdentityScope();
        this.lccGeoFenceInfoDaoConfig.clearIdentityScope();
        this.level500CellInfoDaoConfig.clearIdentityScope();
        this.vPAInfoDaoConfig.clearIdentityScope();
        this.xPKeywordConfigInfoDaoConfig.clearIdentityScope();
        this.xPScratchSpotInfoDaoConfig.clearIdentityScope();
        this.xPServiceCenterInfoDaoConfig.clearIdentityScope();
        this.xPWebConfigInfoDaoConfig.clearIdentityScope();
    }

    public CPDeepInfoDao getCPDeepInfoDao() {
        return this.cPDeepInfoDao;
    }

    public CPInfoDao getCPInfoDao() {
        return this.cPInfoDao;
    }

    public CarWashInfoDao getCarWashInfoDao() {
        return this.carWashInfoDao;
    }

    public LccGeoFenceInfoDao getLccGeoFenceInfoDao() {
        return this.lccGeoFenceInfoDao;
    }

    public Level500CellInfoDao getLevel500CellInfoDao() {
        return this.level500CellInfoDao;
    }

    public VPAInfoDao getVPAInfoDao() {
        return this.vPAInfoDao;
    }

    public XPKeywordConfigInfoDao getXPKeywordConfigInfoDao() {
        return this.xPKeywordConfigInfoDao;
    }

    public XPScratchSpotInfoDao getXPScratchSpotInfoDao() {
        return this.xPScratchSpotInfoDao;
    }

    public XPServiceCenterInfoDao getXPServiceCenterInfoDao() {
        return this.xPServiceCenterInfoDao;
    }

    public XPWebConfigInfoDao getXPWebConfigInfoDao() {
        return this.xPWebConfigInfoDao;
    }
}
