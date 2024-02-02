package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GMojiWeatherResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackMojiWeather;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackMojiWeatherImpl;
@IntfAuto(target = ICallBackMojiWeather.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackMojiWeatherRouter extends ICallBackMojiWeatherImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackMojiWeatherRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackMojiWeatherRouter.class);
    private TypeHelper mHelper;
    private ICallBackMojiWeather mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackMojiWeather iCallBackMojiWeather) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackMojiWeatherImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackMojiWeather;
    }

    protected CallBackMojiWeatherRouter(String str, ICallBackMojiWeather iCallBackMojiWeather, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackMojiWeather);
    }

    protected CallBackMojiWeatherRouter(String str, ICallBackMojiWeather iCallBackMojiWeather) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackMojiWeather);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackMojiWeatherRouter.1
        });
        objArr[1] = String.valueOf(this.mHelper != null);
        DebugTool.d("%s: mHelper=%s", objArr);
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackMojiWeatherImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackMojiWeatherRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackMojiWeatherImpl
    public void onRecvAck(GMojiWeatherResponseParam gMojiWeatherResponseParam) {
        ICallBackMojiWeather iCallBackMojiWeather = this.mObserver;
        if (iCallBackMojiWeather != null) {
            iCallBackMojiWeather.onRecvAck(gMojiWeatherResponseParam);
        }
    }
}
