package com.autonavi.gbl.consis.router;

import android.util.Log;
import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.consis.observer.IConsisMessageAdapter;
import com.autonavi.gbl.consis.observer.impl.IConsisMessageAdapterImpl;
import com.autonavi.gbl.guide.model.NaviPath;
import com.autonavi.gbl.guide.model.NaviType;
import com.autonavi.gbl.guide.model.impl.NaviPathImpl;
import java.lang.reflect.Method;
@IntfAuto(target = IConsisMessageAdapter.class, type = BuildType.JROUTER)
/* loaded from: classes.dex */
public class ConsisMessageAdapterRouter extends IConsisMessageAdapterImpl {
    private static BindTable BIND_TABLE = new BindTable(ConsisMessageAdapterRouter.class);
    private static String PACKAGE = ReflexTool.PN(ConsisMessageAdapterRouter.class);
    private TypeHelper mHelper;
    private IConsisMessageAdapter mObserver;
    private String mTargetId;

    private void $constructor(String str, IConsisMessageAdapter iConsisMessageAdapter) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IConsisMessageAdapterImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iConsisMessageAdapter;
    }

    protected ConsisMessageAdapterRouter(String str, IConsisMessageAdapter iConsisMessageAdapter, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iConsisMessageAdapter);
    }

    protected ConsisMessageAdapterRouter(String str, IConsisMessageAdapter iConsisMessageAdapter) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iConsisMessageAdapter);
    }

    protected void unbind() {
        TypeHelper typeHelper = this.mHelper;
        if (typeHelper != null) {
            typeHelper.delete();
            this.mHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.consis.observer.impl.IConsisMessageAdapterImpl
    public synchronized void delete() {
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.consis.observer.impl.IConsisMessageAdapterImpl
    public boolean onStartNavi(long j, @NaviType.NaviType1 int i, int i2) {
        IConsisMessageAdapter iConsisMessageAdapter = this.mObserver;
        if (iConsisMessageAdapter != null) {
            return iConsisMessageAdapter.onStartNavi(j, i, i2);
        }
        return false;
    }

    @Override // com.autonavi.gbl.consis.observer.impl.IConsisMessageAdapterImpl
    public boolean onStopNavi(long j, int i) {
        IConsisMessageAdapter iConsisMessageAdapter = this.mObserver;
        if (iConsisMessageAdapter != null) {
            return iConsisMessageAdapter.onStopNavi(j, i);
        }
        return false;
    }

    @Override // com.autonavi.gbl.consis.observer.impl.IConsisMessageAdapterImpl
    public boolean onPauseNavi(long j, int i) {
        IConsisMessageAdapter iConsisMessageAdapter = this.mObserver;
        if (iConsisMessageAdapter != null) {
            return iConsisMessageAdapter.onPauseNavi(j, i);
        }
        return false;
    }

    @Override // com.autonavi.gbl.consis.observer.impl.IConsisMessageAdapterImpl
    public boolean onResumeNavi(long j, int i) {
        IConsisMessageAdapter iConsisMessageAdapter = this.mObserver;
        if (iConsisMessageAdapter != null) {
            return iConsisMessageAdapter.onResumeNavi(j, i);
        }
        return false;
    }

    @Override // com.autonavi.gbl.consis.observer.impl.IConsisMessageAdapterImpl
    public boolean onSetNaviPath(NaviPathImpl naviPathImpl, int i) {
        TypeHelper typeHelper;
        try {
            Method method = ConsisMessageAdapterRouter.class.getMethod("onSetNaviPath", NaviPathImpl.class, Integer.TYPE);
            NaviPath naviPath = null;
            if (naviPathImpl != null && (typeHelper = this.mHelper) != null) {
                naviPath = (NaviPath) typeHelper.transfer(method, 0, naviPathImpl);
            }
            IConsisMessageAdapter iConsisMessageAdapter = this.mObserver;
            if (iConsisMessageAdapter != null) {
                return iConsisMessageAdapter.onSetNaviPath(naviPath, i);
            }
            return false;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return false;
        }
    }

    @Override // com.autonavi.gbl.consis.observer.impl.IConsisMessageAdapterImpl
    public void onSelectMainPathID(long j, int i) {
        IConsisMessageAdapter iConsisMessageAdapter = this.mObserver;
        if (iConsisMessageAdapter != null) {
            iConsisMessageAdapter.onSelectMainPathID(j, i);
        }
    }
}
