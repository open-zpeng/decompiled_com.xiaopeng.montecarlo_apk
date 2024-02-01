package com.autonavi.gbl.consis.router;

import android.util.Log;
import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.consis.ChannelParcel;
import com.autonavi.gbl.consis.impl.ChannelParcelImpl;
import com.autonavi.gbl.consis.model.ChannelMsgHead;
import com.autonavi.gbl.consis.observer.IConsisObserver;
import com.autonavi.gbl.consis.observer.impl.IConsisObserverImpl;
import java.lang.reflect.Method;
@IntfAuto(target = IConsisObserver.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class ConsisObserverRouter extends IConsisObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(ConsisObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(ConsisObserverRouter.class);
    private TypeHelper mHelper;
    private IConsisObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, IConsisObserver iConsisObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IConsisObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iConsisObserver;
    }

    protected ConsisObserverRouter(String str, IConsisObserver iConsisObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iConsisObserver);
    }

    protected ConsisObserverRouter(String str, IConsisObserver iConsisObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iConsisObserver);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.consis.observer.impl.IConsisObserverImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.consis.observer.impl.IConsisObserverImpl
    public void onSendMessage(ChannelMsgHead channelMsgHead, ChannelParcelImpl channelParcelImpl) {
        TypeHelper typeHelper;
        try {
            Method method = ConsisObserverRouter.class.getMethod("onSendMessage", ChannelMsgHead.class, ChannelParcelImpl.class);
            ChannelParcel channelParcel = null;
            if (channelParcelImpl != null && (typeHelper = this.mHelper) != null) {
                channelParcel = (ChannelParcel) typeHelper.transfer(method, 1, channelParcelImpl);
            }
            IConsisObserver iConsisObserver = this.mObserver;
            if (iConsisObserver != null) {
                iConsisObserver.onSendMessage(channelMsgHead, channelParcel);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    @Override // com.autonavi.gbl.consis.observer.impl.IConsisObserverImpl
    public void onReceiveMessage(ChannelMsgHead channelMsgHead, ChannelParcelImpl channelParcelImpl) {
        TypeHelper typeHelper;
        try {
            Method method = ConsisObserverRouter.class.getMethod("onReceiveMessage", ChannelMsgHead.class, ChannelParcelImpl.class);
            ChannelParcel channelParcel = null;
            if (channelParcelImpl != null && (typeHelper = this.mHelper) != null) {
                channelParcel = (ChannelParcel) typeHelper.transfer(method, 1, channelParcelImpl);
            }
            IConsisObserver iConsisObserver = this.mObserver;
            if (iConsisObserver != null) {
                iConsisObserver.onReceiveMessage(channelMsgHead, channelParcel);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }
}
