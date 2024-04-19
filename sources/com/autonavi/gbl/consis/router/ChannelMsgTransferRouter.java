package com.autonavi.gbl.consis.router;

import android.util.Log;
import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.consis.observer.IChannelMsgTransfer;
import com.autonavi.gbl.consis.observer.impl.IChannelMsgTransferImpl;
import com.autonavi.gbl.guide.model.NaviPath;
import com.autonavi.gbl.guide.model.NaviType;
import com.autonavi.gbl.guide.model.impl.NaviPathImpl;
import java.lang.reflect.Method;
@IntfAuto(target = IChannelMsgTransfer.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class ChannelMsgTransferRouter extends IChannelMsgTransferImpl {
    private static BindTable BIND_TABLE = new BindTable(ChannelMsgTransferRouter.class);
    private static String PACKAGE = ReflexTool.PN(ChannelMsgTransferRouter.class);
    private TypeHelper mHelper;
    private IChannelMsgTransfer mObserver;
    private String mTargetId;

    private void $constructor(String str, IChannelMsgTransfer iChannelMsgTransfer) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IChannelMsgTransferImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iChannelMsgTransfer;
    }

    protected ChannelMsgTransferRouter(String str, IChannelMsgTransfer iChannelMsgTransfer, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iChannelMsgTransfer);
    }

    protected ChannelMsgTransferRouter(String str, IChannelMsgTransfer iChannelMsgTransfer) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iChannelMsgTransfer);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.consis.router.ChannelMsgTransferRouter.1
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
    @Override // com.autonavi.gbl.consis.observer.impl.IChannelMsgTransferImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.consis.router.ChannelMsgTransferRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.consis.observer.impl.IChannelMsgTransferImpl
    public boolean onStartNavi(long j, @NaviType.NaviType1 int i, int i2) {
        IChannelMsgTransfer iChannelMsgTransfer = this.mObserver;
        if (iChannelMsgTransfer != null) {
            return iChannelMsgTransfer.onStartNavi(j, i, i2);
        }
        return false;
    }

    @Override // com.autonavi.gbl.consis.observer.impl.IChannelMsgTransferImpl
    public boolean onStopNavi(long j, int i) {
        IChannelMsgTransfer iChannelMsgTransfer = this.mObserver;
        if (iChannelMsgTransfer != null) {
            return iChannelMsgTransfer.onStopNavi(j, i);
        }
        return false;
    }

    @Override // com.autonavi.gbl.consis.observer.impl.IChannelMsgTransferImpl
    public boolean onPauseNavi(long j, int i) {
        IChannelMsgTransfer iChannelMsgTransfer = this.mObserver;
        if (iChannelMsgTransfer != null) {
            return iChannelMsgTransfer.onPauseNavi(j, i);
        }
        return false;
    }

    @Override // com.autonavi.gbl.consis.observer.impl.IChannelMsgTransferImpl
    public boolean onResumeNavi(long j, int i) {
        IChannelMsgTransfer iChannelMsgTransfer = this.mObserver;
        if (iChannelMsgTransfer != null) {
            return iChannelMsgTransfer.onResumeNavi(j, i);
        }
        return false;
    }

    @Override // com.autonavi.gbl.consis.observer.impl.IChannelMsgTransferImpl
    public boolean onSetNaviPath(NaviPathImpl naviPathImpl, long j, int i) {
        try {
            Method method = ChannelMsgTransferRouter.class.getMethod("onSetNaviPath", NaviPathImpl.class, Long.TYPE, Integer.TYPE);
            if (naviPathImpl != null) {
                TypeHelper typeHelper = this.mHelper;
                r2 = typeHelper != null ? (NaviPath) typeHelper.transfer(method, 0, naviPathImpl) : null;
                if (r2 == null) {
                    DebugTool.e("%s: $naviPath == null", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.consis.router.ChannelMsgTransferRouter.3
                    }));
                }
            }
            IChannelMsgTransfer iChannelMsgTransfer = this.mObserver;
            if (iChannelMsgTransfer != null) {
                return iChannelMsgTransfer.onSetNaviPath(r2, j, i);
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    @Override // com.autonavi.gbl.consis.observer.impl.IChannelMsgTransferImpl
    public void onSelectMainPathID(long j, int i) {
        IChannelMsgTransfer iChannelMsgTransfer = this.mObserver;
        if (iChannelMsgTransfer != null) {
            iChannelMsgTransfer.onSelectMainPathID(j, i);
        }
    }
}
