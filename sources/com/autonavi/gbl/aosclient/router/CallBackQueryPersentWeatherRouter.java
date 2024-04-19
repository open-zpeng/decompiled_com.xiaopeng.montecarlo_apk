package com.autonavi.gbl.aosclient.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.model.GQueryPersentWeatherResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackQueryPersentWeather;
import com.autonavi.gbl.aosclient.observer.impl.ICallBackQueryPersentWeatherImpl;
@IntfAuto(target = ICallBackQueryPersentWeather.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class CallBackQueryPersentWeatherRouter extends ICallBackQueryPersentWeatherImpl {
    private static BindTable BIND_TABLE = new BindTable(CallBackQueryPersentWeatherRouter.class);
    private static String PACKAGE = ReflexTool.PN(CallBackQueryPersentWeatherRouter.class);
    private TypeHelper mHelper;
    private ICallBackQueryPersentWeather mObserver;
    private String mTargetId;

    private void $constructor(String str, ICallBackQueryPersentWeather iCallBackQueryPersentWeather) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(ICallBackQueryPersentWeatherImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iCallBackQueryPersentWeather;
    }

    protected CallBackQueryPersentWeatherRouter(String str, ICallBackQueryPersentWeather iCallBackQueryPersentWeather, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackQueryPersentWeather);
    }

    protected CallBackQueryPersentWeatherRouter(String str, ICallBackQueryPersentWeather iCallBackQueryPersentWeather) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iCallBackQueryPersentWeather);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackQueryPersentWeatherRouter.1
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
    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackQueryPersentWeatherImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.aosclient.router.CallBackQueryPersentWeatherRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.aosclient.observer.impl.ICallBackQueryPersentWeatherImpl
    public void onRecvAck(GQueryPersentWeatherResponseParam gQueryPersentWeatherResponseParam) {
        ICallBackQueryPersentWeather iCallBackQueryPersentWeather = this.mObserver;
        if (iCallBackQueryPersentWeather != null) {
            iCallBackQueryPersentWeather.onRecvAck(gQueryPersentWeatherResponseParam);
        }
    }
}
