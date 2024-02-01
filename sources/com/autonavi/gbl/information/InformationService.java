package com.autonavi.gbl.information;

import android.util.Log;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.information.impl.IInformationServiceImpl;
import com.autonavi.gbl.information.model.InformationInitParam;
import com.autonavi.gbl.information.nearby.NearbyRecommendControl;
import com.autonavi.gbl.information.nearby.impl.INearbyRecommendControlImpl;
import com.autonavi.gbl.information.trade.TradeControl;
import com.autonavi.gbl.information.trade.impl.ITradeControlImpl;
import com.autonavi.gbl.servicemanager.IService;
import com.autonavi.gbl.util.model.ServiceInitStatus;
import java.lang.reflect.Method;
@IntfAuto(target = IInformationServiceImpl.class, type = BuildType.JCTRL)
/* loaded from: classes.dex */
public class InformationService implements IService {
    private static String PACKAGE = ReflexTool.PN(InformationService.class);
    private IInformationServiceImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected void clean() {
    }

    protected InformationService(long j, boolean z) {
        this((IInformationServiceImpl) ReflexTool.invokeDeclConstructorSafe(IInformationServiceImpl.class, new Class[]{Long.TYPE, Boolean.TYPE}, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(InformationService.class, this, this.mControl);
        }
    }

    public InformationService(IInformationServiceImpl iInformationServiceImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iInformationServiceImpl);
    }

    private void $constructor(IInformationServiceImpl iInformationServiceImpl) {
        if (iInformationServiceImpl != null) {
            this.mControl = iInformationServiceImpl;
            this.mTargetId = String.format("InformationService_%s_%d", String.valueOf(IInformationServiceImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected IInformationServiceImpl getControl() {
        return this.mControl;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public boolean isRecycled() {
        IInformationServiceImpl iInformationServiceImpl = this.mControl;
        if (iInformationServiceImpl != null) {
            return iInformationServiceImpl.isRecycled();
        }
        return true;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public long getPtr() {
        IInformationServiceImpl iInformationServiceImpl = this.mControl;
        if (iInformationServiceImpl != null) {
            return iInformationServiceImpl.getPtr();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onCreate() {
        IInformationServiceImpl iInformationServiceImpl = this.mControl;
        if (iInformationServiceImpl != null) {
            iInformationServiceImpl.onCreate();
        }
    }

    public int init(InformationInitParam informationInitParam) {
        IInformationServiceImpl iInformationServiceImpl = this.mControl;
        if (iInformationServiceImpl != null) {
            return iInformationServiceImpl.init(informationInitParam);
        }
        return Integer.MIN_VALUE;
    }

    public void unInit() {
        IInformationServiceImpl iInformationServiceImpl = this.mControl;
        if (iInformationServiceImpl != null) {
            iInformationServiceImpl.unInit();
        }
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    @ServiceInitStatus.ServiceInitStatus1
    public int isInit() {
        IInformationServiceImpl iInformationServiceImpl = this.mControl;
        if (iInformationServiceImpl != null) {
            return iInformationServiceImpl.isInit();
        }
        return Integer.MIN_VALUE;
    }

    public String getVersion() {
        IInformationServiceImpl iInformationServiceImpl = this.mControl;
        if (iInformationServiceImpl != null) {
            return iInformationServiceImpl.getVersion();
        }
        return null;
    }

    public TradeControl getTradeControl() {
        ITradeControlImpl tradeControl;
        TypeHelper typeHelper;
        try {
            Method method = InformationService.class.getMethod("getTradeControl", new Class[0]);
            IInformationServiceImpl iInformationServiceImpl = this.mControl;
            if (iInformationServiceImpl == null || (tradeControl = iInformationServiceImpl.getTradeControl()) == null || (typeHelper = this.mTypeHelper) == null) {
                return null;
            }
            return (TradeControl) typeHelper.transfer(method, -1, (Object) tradeControl, true);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    public NearbyRecommendControl getNearbyRecommendControl() {
        INearbyRecommendControlImpl nearbyRecommendControl;
        TypeHelper typeHelper;
        try {
            Method method = InformationService.class.getMethod("getNearbyRecommendControl", new Class[0]);
            IInformationServiceImpl iInformationServiceImpl = this.mControl;
            if (iInformationServiceImpl == null || (nearbyRecommendControl = iInformationServiceImpl.getNearbyRecommendControl()) == null || (typeHelper = this.mTypeHelper) == null) {
                return null;
            }
            return (NearbyRecommendControl) typeHelper.transfer(method, -1, (Object) nearbyRecommendControl, true);
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return null;
        }
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mTypeHelper = null;
        }
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onDestroy() {
        this.mHasDestroy = true;
        clean();
    }

    protected synchronized void delete() {
        if (!this.mHasDestroy) {
            onDestroy();
        }
        if (this.mTypeHelper != null) {
            TypeHelper typeHelper = this.mTypeHelper;
            TypeHelper.unbindAllTarget(PACKAGE, this);
        }
        if (this.mControl != null) {
            this.mControl = null;
        }
        unbind();
    }
}
