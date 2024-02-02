package com.autonavi.gbl.util.router;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.DebugTool;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.util.model.KeyValue;
import com.autonavi.gbl.util.model.NetworkStatus;
import com.autonavi.gbl.util.observer.IPlatformInterface;
import com.autonavi.gbl.util.observer.impl.IPlatformInterfaceImpl;
import java.util.ArrayList;
@IntfAuto(target = IPlatformInterface.class, type = BuildType.JROUTER)
/* loaded from: classes2.dex */
public class PlatformInterfaceRouter extends IPlatformInterfaceImpl {
    private static BindTable BIND_TABLE = new BindTable(PlatformInterfaceRouter.class);
    private static String PACKAGE = ReflexTool.PN(PlatformInterfaceRouter.class);
    private TypeHelper mHelper;
    private IPlatformInterface mObserver;
    private String mTargetId;

    private void $constructor(String str, IPlatformInterface iPlatformInterface) {
        this.mTargetId = String.format("router_%s_%s_%d", str, String.valueOf(IPlatformInterfaceImpl.getCPtr(this)), Long.valueOf(System.currentTimeMillis()));
        this.mHelper = new TypeHelper(this.mTargetId);
        this.mObserver = iPlatformInterface;
    }

    protected PlatformInterfaceRouter(String str, IPlatformInterface iPlatformInterface, long j, boolean z) {
        super(j, z);
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iPlatformInterface);
    }

    protected PlatformInterfaceRouter(String str, IPlatformInterface iPlatformInterface) {
        this.mTargetId = null;
        this.mHelper = null;
        this.mObserver = null;
        $constructor(str, iPlatformInterface);
    }

    protected void unbind() {
        Object[] objArr = new Object[2];
        objArr[0] = ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.util.router.PlatformInterfaceRouter.1
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
    @Override // com.autonavi.gbl.util.observer.impl.IPlatformInterfaceImpl
    public synchronized void delete() {
        DebugTool.d("%s", ReflexTool.EMD(new Object() { // from class: com.autonavi.gbl.util.router.PlatformInterfaceRouter.2
        }));
        super.delete();
        unbind();
    }

    @Override // com.autonavi.gbl.util.observer.impl.IPlatformInterfaceImpl
    public void copyAssetFile(String str, String str2) {
        IPlatformInterface iPlatformInterface = this.mObserver;
        if (iPlatformInterface != null) {
            iPlatformInterface.copyAssetFile(str, str2);
        }
    }

    @Override // com.autonavi.gbl.util.observer.impl.IPlatformInterfaceImpl
    public float getDensity(int i) {
        IPlatformInterface iPlatformInterface = this.mObserver;
        if (iPlatformInterface != null) {
            return iPlatformInterface.getDensity(i);
        }
        return 0.0f;
    }

    @Override // com.autonavi.gbl.util.observer.impl.IPlatformInterfaceImpl
    public int getDensityDpi(int i) {
        IPlatformInterface iPlatformInterface = this.mObserver;
        if (iPlatformInterface != null) {
            return iPlatformInterface.getDensityDpi(i);
        }
        return 0;
    }

    @Override // com.autonavi.gbl.util.observer.impl.IPlatformInterfaceImpl
    @NetworkStatus.NetworkStatus1
    public int getNetStatus() {
        IPlatformInterface iPlatformInterface = this.mObserver;
        if (iPlatformInterface != null) {
            return iPlatformInterface.getNetStatus();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.autonavi.gbl.util.observer.impl.IPlatformInterfaceImpl
    public ArrayList<KeyValue> getCdnNetworkParam() {
        IPlatformInterface iPlatformInterface = this.mObserver;
        if (iPlatformInterface != null) {
            return iPlatformInterface.getCdnNetworkParam();
        }
        return null;
    }

    @Override // com.autonavi.gbl.util.observer.impl.IPlatformInterfaceImpl
    public boolean getAosNetworkParam(ArrayList<KeyValue> arrayList) {
        IPlatformInterface iPlatformInterface = this.mObserver;
        if (iPlatformInterface != null) {
            return iPlatformInterface.getAosNetworkParam(arrayList);
        }
        return false;
    }

    @Override // com.autonavi.gbl.util.observer.impl.IPlatformInterfaceImpl
    public String amapEncode(byte[] bArr) {
        IPlatformInterface iPlatformInterface = this.mObserver;
        if (iPlatformInterface != null) {
            return iPlatformInterface.amapEncode(bArr);
        }
        return null;
    }

    @Override // com.autonavi.gbl.util.observer.impl.IPlatformInterfaceImpl
    public String amapEncodeBinary(byte[] bArr) {
        IPlatformInterface iPlatformInterface = this.mObserver;
        if (iPlatformInterface != null) {
            return iPlatformInterface.amapEncodeBinary(bArr);
        }
        return null;
    }

    @Override // com.autonavi.gbl.util.observer.impl.IPlatformInterfaceImpl
    public String amapDecode(byte[] bArr) {
        IPlatformInterface iPlatformInterface = this.mObserver;
        if (iPlatformInterface != null) {
            return iPlatformInterface.amapDecode(bArr);
        }
        return null;
    }

    @Override // com.autonavi.gbl.util.observer.impl.IPlatformInterfaceImpl
    public boolean getAosSign(String str, String[] strArr) {
        IPlatformInterface iPlatformInterface = this.mObserver;
        if (iPlatformInterface != null) {
            return iPlatformInterface.getAosSign(str, strArr);
        }
        return false;
    }
}
