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
import com.autonavi.gbl.consis.observer.IChannelMessageObserver;
import com.autonavi.gbl.consis.observer.impl.IChannelMessageObserverImpl;
import java.lang.reflect.Method;
@IntfAuto(target = IChannelMessageObserver.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class ChannelMessageObserverRouter extends IChannelMessageObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(ChannelMessageObserverRouter.class);
    private static String PACKAGE = ReflexTool.PN(ChannelMessageObserverRouter.class);
    private TypeHelper mHelper;
    private IChannelMessageObserver mObserver;
    private String mTargetId;

    private void $constructor(String str, IChannelMessageObserver iChannelMessageObserver) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IChannelMessageObserverImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iChannelMessageObserver;
    }

    protected ChannelMessageObserverRouter(String str, IChannelMessageObserver iChannelMessageObserver, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iChannelMessageObserver);
    }

    protected ChannelMessageObserverRouter(String str, IChannelMessageObserver iChannelMessageObserver) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iChannelMessageObserver);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.consis.observer.impl.IChannelMessageObserverImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.consis.observer.impl.IChannelMessageObserverImpl
    public void onNotifyMsg(ChannelMsgHead channelMsgHead, ChannelParcelImpl channelParcelImpl) {
        TypeHelper typeHelper;
        try {
            Method method = ChannelMessageObserverRouter.class.getMethod("onNotifyMsg", ChannelMsgHead.class, ChannelParcelImpl.class);
            ChannelParcel channelParcel = null;
            if (channelParcelImpl != null && (typeHelper = this.mHelper) != null) {
                channelParcel = (ChannelParcel) typeHelper.transfer(method, 1, channelParcelImpl);
            }
            IChannelMessageObserver iChannelMessageObserver = this.mObserver;
            if (iChannelMessageObserver != null) {
                iChannelMessageObserver.onNotifyMsg(channelMsgHead, channelParcel);
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }
}
