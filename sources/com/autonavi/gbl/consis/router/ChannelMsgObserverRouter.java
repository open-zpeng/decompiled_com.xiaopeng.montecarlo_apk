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
import com.autonavi.gbl.consis.model.ChannelMsgHead;
import com.autonavi.gbl.consis.observer.IChannelMsgObserver;
import com.autonavi.gbl.consis.observer.impl.IChannelMsgObserverImpl;
import java.lang.reflect.Method;
@IntfAuto(target = IChannelMsgObserver.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class ChannelMsgObserverRouter extends IChannelMsgObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(ChannelMsgObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(ChannelMsgObserverRouter.class);
    private TypeHelper mHelper;
    private IChannelMsgObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, IChannelMsgObserver iChannelMsgObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IChannelMsgObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iChannelMsgObserver;
    }

    protected ChannelMsgObserverRouter(String str, IChannelMsgObserver iChannelMsgObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iChannelMsgObserver);
    }

    protected ChannelMsgObserverRouter(String str, IChannelMsgObserver iChannelMsgObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iChannelMsgObserver);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.consis.router.ChannelMsgObserverRouter.1
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
    @Override // com.autonavi.gbl.consis.observer.impl.IChannelMsgObserverImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.consis.router.ChannelMsgObserverRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.consis.observer.impl.IChannelMsgObserverImpl
    public int onNotifyMsg(ChannelMsgHead channelMsgHead, ChannelParcelImpl channelParcelImpl) {
        try {
            Method method = ChannelMsgObserverRouter.class.getMethod("onNotifyMsg", ChannelMsgHead.class, ChannelParcelImpl.class);
            if (channelParcelImpl != null) {
                TypeHelper typeHelper = this.mHelper;
                r2 = typeHelper != null ? (ChannelParcel) typeHelper.transfer(method, 1, channelParcelImpl) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $data == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.consis.router.ChannelMsgObserverRouter.3
                    }));
                }
            }
            IChannelMsgObserver iChannelMsgObserver = this.mObserver;
            if (iChannelMsgObserver != null) {
                return iChannelMsgObserver.onNotifyMsg(channelMsgHead, r2);
            }
            return 0;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0;
        }
    }
}
