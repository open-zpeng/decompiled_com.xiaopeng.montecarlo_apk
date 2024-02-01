package com.autonavi.gbl.aosclient;

import android.util.Log;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.aosclient.impl.BLAosServiceManagerImpl;
import com.autonavi.gbl.aosclient.model.BLAosCookie;
import com.autonavi.gbl.aosclient.model.BLAosInitParam;
import com.autonavi.gbl.aosclient.model.BLRequestBase;
import com.autonavi.gbl.aosclient.model.EForeBackGround;
import com.autonavi.gbl.aosclient.model.GWsAuthcarServicelistResponseParam;
import com.autonavi.gbl.aosclient.model.GWsAuthcarTokenResponseParam;
import com.autonavi.gbl.aosclient.observer.IBLAosCallBack;
import com.autonavi.gbl.aosclient.observer.impl.IBLAosCallBackImpl;
import com.autonavi.gbl.servicemanager.IService;
import com.autonavi.gbl.util.model.NetworkStatus;
import com.autonavi.gbl.util.model.ServiceInitStatus;
import java.lang.reflect.Method;
@IntfAuto(target = BLAosServiceManagerImpl.class, type = BuildType.JCTRL)
/* loaded from: classes.dex */
public class BLAosServiceManager implements IService {
    private static String PACKAGE = ReflexTool.PN(BLAosServiceManager.class);
    private BLAosServiceManagerImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected void clean() {
    }

    protected BLAosServiceManager(long j, boolean z) {
        this((BLAosServiceManagerImpl) ReflexTool.invokeDeclConstructorSafe(BLAosServiceManagerImpl.class, new Class[]{Long.TYPE, Boolean.TYPE}, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(BLAosServiceManager.class, this, this.mControl);
        }
    }

    public BLAosServiceManager() {
        this(new BLAosServiceManagerImpl());
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(BLAosServiceManager.class, this, this.mControl);
        }
    }

    public BLAosServiceManager(BLAosServiceManagerImpl bLAosServiceManagerImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(bLAosServiceManagerImpl);
    }

    private void $constructor(BLAosServiceManagerImpl bLAosServiceManagerImpl) {
        if (bLAosServiceManagerImpl != null) {
            this.mControl = bLAosServiceManagerImpl;
            this.mTargetId = String.format("BLAosServiceManager_%s_%d", String.valueOf(BLAosServiceManagerImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected BLAosServiceManagerImpl getControl() {
        return this.mControl;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public boolean isRecycled() {
        BLAosServiceManagerImpl bLAosServiceManagerImpl = this.mControl;
        if (bLAosServiceManagerImpl != null) {
            return bLAosServiceManagerImpl.isRecycled();
        }
        return true;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public long getPtr() {
        BLAosServiceManagerImpl bLAosServiceManagerImpl = this.mControl;
        if (bLAosServiceManagerImpl != null) {
            return bLAosServiceManagerImpl.getPtr();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onCreate() {
        BLAosServiceManagerImpl bLAosServiceManagerImpl = this.mControl;
        if (bLAosServiceManagerImpl != null) {
            bLAosServiceManagerImpl.onCreate();
        }
    }

    public void unInit() {
        BLAosServiceManagerImpl bLAosServiceManagerImpl = this.mControl;
        if (bLAosServiceManagerImpl != null) {
            bLAosServiceManagerImpl.unInit();
        }
    }

    public String getVersion() {
        BLAosServiceManagerImpl bLAosServiceManagerImpl = this.mControl;
        if (bLAosServiceManagerImpl != null) {
            return bLAosServiceManagerImpl.getVersion();
        }
        return null;
    }

    public void logSwitch(int i) {
        BLAosServiceManagerImpl bLAosServiceManagerImpl = this.mControl;
        if (bLAosServiceManagerImpl != null) {
            bLAosServiceManagerImpl.logSwitch(i);
        }
    }

    public int getServiceID() {
        BLAosServiceManagerImpl bLAosServiceManagerImpl = this.mControl;
        if (bLAosServiceManagerImpl != null) {
            return bLAosServiceManagerImpl.getServiceID();
        }
        return 0;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    @ServiceInitStatus.ServiceInitStatus1
    public int isInit() {
        BLAosServiceManagerImpl bLAosServiceManagerImpl = this.mControl;
        if (bLAosServiceManagerImpl != null) {
            return bLAosServiceManagerImpl.isInit();
        }
        return Integer.MIN_VALUE;
    }

    public void init(BLAosInitParam bLAosInitParam) {
        BLAosServiceManagerImpl bLAosServiceManagerImpl = this.mControl;
        if (bLAosServiceManagerImpl != null) {
            bLAosServiceManagerImpl.init(bLAosInitParam);
        }
    }

    public void networkChange(@NetworkStatus.NetworkStatus1 int i) {
        BLAosServiceManagerImpl bLAosServiceManagerImpl = this.mControl;
        if (bLAosServiceManagerImpl != null) {
            bLAosServiceManagerImpl.networkChange(i);
        }
    }

    public void foreBackGround(@EForeBackGround.EForeBackGround1 int i) {
        BLAosServiceManagerImpl bLAosServiceManagerImpl = this.mControl;
        if (bLAosServiceManagerImpl != null) {
            bLAosServiceManagerImpl.foreBackGround(i);
        }
    }

    public void enableAlcFileUpload(boolean z, String str) {
        BLAosServiceManagerImpl bLAosServiceManagerImpl = this.mControl;
        if (bLAosServiceManagerImpl != null) {
            bLAosServiceManagerImpl.enableAlcFileUpload(z, str);
        }
    }

    public long excuteRequest(BLRequestBase bLRequestBase, IBLAosCallBack iBLAosCallBack) {
        TypeHelper typeHelper;
        try {
            Method method = BLAosServiceManager.class.getMethod("excuteRequest", BLRequestBase.class, IBLAosCallBack.class);
            IBLAosCallBackImpl iBLAosCallBackImpl = null;
            if (iBLAosCallBack != null && (typeHelper = this.mTypeHelper) != null) {
                iBLAosCallBackImpl = (IBLAosCallBackImpl) typeHelper.transfer(method, 1, iBLAosCallBack);
            }
            BLAosServiceManagerImpl bLAosServiceManagerImpl = this.mControl;
            if (bLAosServiceManagerImpl != null) {
                return bLAosServiceManagerImpl.excuteRequest(bLRequestBase, iBLAosCallBackImpl);
            }
            return 0L;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return 0L;
        }
    }

    public int abortRequest(long j) {
        BLAosServiceManagerImpl bLAosServiceManagerImpl = this.mControl;
        if (bLAosServiceManagerImpl != null) {
            return bLAosServiceManagerImpl.abortRequest(j);
        }
        return Integer.MIN_VALUE;
    }

    public BLAosCookie getCookie() {
        BLAosServiceManagerImpl bLAosServiceManagerImpl = this.mControl;
        if (bLAosServiceManagerImpl != null) {
            return bLAosServiceManagerImpl.getCookie();
        }
        return null;
    }

    public boolean setCookie(BLAosCookie bLAosCookie) {
        BLAosServiceManagerImpl bLAosServiceManagerImpl = this.mControl;
        if (bLAosServiceManagerImpl != null) {
            return bLAosServiceManagerImpl.setCookie(bLAosCookie);
        }
        return false;
    }

    public GWsAuthcarServicelistResponseParam getAuthcarServerlist() {
        BLAosServiceManagerImpl bLAosServiceManagerImpl = this.mControl;
        if (bLAosServiceManagerImpl != null) {
            return bLAosServiceManagerImpl.getAuthcarServerlist();
        }
        return null;
    }

    public GWsAuthcarTokenResponseParam getAuthcarToken() {
        BLAosServiceManagerImpl bLAosServiceManagerImpl = this.mControl;
        if (bLAosServiceManagerImpl != null) {
            return bLAosServiceManagerImpl.getAuthcarToken();
        }
        return null;
    }

    public void setUid(String str) {
        BLAosServiceManagerImpl bLAosServiceManagerImpl = this.mControl;
        if (bLAosServiceManagerImpl != null) {
            bLAosServiceManagerImpl.setUid(str);
        }
    }

    public void setScreenWithHeight(short s, short s2) {
        BLAosServiceManagerImpl bLAosServiceManagerImpl = this.mControl;
        if (bLAosServiceManagerImpl != null) {
            bLAosServiceManagerImpl.setScreenWithHeight(s, s2);
        }
    }

    public void setLonLat(int i, int i2) {
        BLAosServiceManagerImpl bLAosServiceManagerImpl = this.mControl;
        if (bLAosServiceManagerImpl != null) {
            bLAosServiceManagerImpl.setLonLat(i, i2);
        }
    }

    public void setCarInfo(String str, String str2, String str3) {
        BLAosServiceManagerImpl bLAosServiceManagerImpl = this.mControl;
        if (bLAosServiceManagerImpl != null) {
            bLAosServiceManagerImpl.setCarInfo(str, str2, str3);
        }
    }

    public String getRestSignature(String str, String str2, String str3) {
        BLAosServiceManagerImpl bLAosServiceManagerImpl = this.mControl;
        if (bLAosServiceManagerImpl != null) {
            return bLAosServiceManagerImpl.getRestSignature(str, str2, str3);
        }
        return null;
    }

    public String getRestEncryptData(String str) {
        BLAosServiceManagerImpl bLAosServiceManagerImpl = this.mControl;
        if (bLAosServiceManagerImpl != null) {
            return bLAosServiceManagerImpl.getRestEncryptData(str);
        }
        return null;
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
