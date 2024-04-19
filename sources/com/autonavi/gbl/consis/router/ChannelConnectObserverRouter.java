package com.autonavi.gbl.consis.router;

import android.util.Log;
import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.consis.ChannelParcel;
import com.autonavi.gbl.consis.impl.ChannelParcelImpl;
import com.autonavi.gbl.consis.model.ConnectMsgHead;
import com.autonavi.gbl.consis.observer.ChannelTransProxy;
import com.autonavi.gbl.consis.observer.IChannelConnectObserver;
import com.autonavi.gbl.consis.observer.impl.IChannelConnectObserverImpl;
import com.autonavi.gbl.consis.observer.impl.IChannelTransProxyImpl;
import java.lang.reflect.Method;
@IntfAuto(target = IChannelConnectObserver.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class ChannelConnectObserverRouter extends IChannelConnectObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(ChannelConnectObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(ChannelConnectObserverRouter.class);
    private TypeHelper mHelper;
    private IChannelConnectObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, IChannelConnectObserver iChannelConnectObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IChannelConnectObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iChannelConnectObserver;
    }

    protected ChannelConnectObserverRouter(String str, IChannelConnectObserver iChannelConnectObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iChannelConnectObserver);
    }

    protected ChannelConnectObserverRouter(String str, IChannelConnectObserver iChannelConnectObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iChannelConnectObserver);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.consis.router.ChannelConnectObserverRouter.1
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
    @Override // com.autonavi.gbl.consis.observer.impl.IChannelConnectObserverImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.consis.router.ChannelConnectObserverRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.consis.observer.impl.IChannelConnectObserverImpl
    public void onCustomDataIncome(ChannelParcelImpl channelParcelImpl, IChannelTransProxyImpl iChannelTransProxyImpl) {
        ChannelParcel channelParcel;
        try {
            Method method = ChannelConnectObserverRouter.class.getMethod("onCustomDataIncome", ChannelParcelImpl.class, IChannelTransProxyImpl.class);
            if (channelParcelImpl != null) {
                TypeHelper typeHelper = this.mHelper;
                channelParcel = typeHelper != null ? (ChannelParcel) typeHelper.transfer(method, 0, channelParcelImpl) : null;
                if (channelParcel == null) {
                    DebugTool.e("%s: $data == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.consis.router.ChannelConnectObserverRouter.3
                    }));
                }
            } else {
                channelParcel = null;
            }
            if (iChannelTransProxyImpl != null) {
                TypeHelper typeHelper2 = this.mHelper;
                r1 = typeHelper2 != null ? (ChannelTransProxy) typeHelper2.transfer(method, 1, iChannelTransProxyImpl) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $proxy == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.consis.router.ChannelConnectObserverRouter.4
                    }));
                }
            }
            IChannelConnectObserver iChannelConnectObserver = this.mObserver;
            if (iChannelConnectObserver != null) {
                iChannelConnectObserver.onCustomDataIncome(channelParcel, r1);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    @Override // com.autonavi.gbl.consis.observer.impl.IChannelConnectObserverImpl
    public void onChannelConnect(ConnectMsgHead connectMsgHead, IChannelTransProxyImpl iChannelTransProxyImpl) {
        try {
            Method method = ChannelConnectObserverRouter.class.getMethod("onChannelConnect", ConnectMsgHead.class, IChannelTransProxyImpl.class);
            if (iChannelTransProxyImpl != null) {
                TypeHelper typeHelper = this.mHelper;
                r1 = typeHelper != null ? (ChannelTransProxy) typeHelper.transfer(method, 1, iChannelTransProxyImpl) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $pProxy == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.consis.router.ChannelConnectObserverRouter.5
                    }));
                }
            }
            IChannelConnectObserver iChannelConnectObserver = this.mObserver;
            if (iChannelConnectObserver != null) {
                iChannelConnectObserver.onChannelConnect(connectMsgHead, r1);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    @Override // com.autonavi.gbl.consis.observer.impl.IChannelConnectObserverImpl
    public void onChannelDestroy(ConnectMsgHead connectMsgHead, IChannelTransProxyImpl iChannelTransProxyImpl) {
        try {
            Method method = ChannelConnectObserverRouter.class.getMethod("onChannelDestroy", ConnectMsgHead.class, IChannelTransProxyImpl.class);
            if (iChannelTransProxyImpl != null) {
                TypeHelper typeHelper = this.mHelper;
                r1 = typeHelper != null ? (ChannelTransProxy) typeHelper.transfer(method, 1, iChannelTransProxyImpl) : null;
                if (r1 == null) {
                    DebugTool.e("%s: $pProxy == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.consis.router.ChannelConnectObserverRouter.6
                    }));
                }
            }
            IChannelConnectObserver iChannelConnectObserver = this.mObserver;
            if (iChannelConnectObserver != null) {
                iChannelConnectObserver.onChannelDestroy(connectMsgHead, r1);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }
}
