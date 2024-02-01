package com.autonavi.gbl.user.account;

import android.util.Log;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.intfauto.ReflexTool;
import com.autonavi.auto.intfauto.TypeHelper;
import com.autonavi.gbl.servicemanager.IService;
import com.autonavi.gbl.user.account.impl.IAccountServiceImpl;
import com.autonavi.gbl.user.account.model.AccountCheckRequest;
import com.autonavi.gbl.user.account.model.AccountLogoutRequest;
import com.autonavi.gbl.user.account.model.AccountProfile;
import com.autonavi.gbl.user.account.model.AccountProfileRequest;
import com.autonavi.gbl.user.account.model.AccountRegisterRequest;
import com.autonavi.gbl.user.account.model.AccountServiceParam;
import com.autonavi.gbl.user.account.model.AccountUnRegisterRequest;
import com.autonavi.gbl.user.account.model.AvatarRequest;
import com.autonavi.gbl.user.account.model.BindMobileRequest;
import com.autonavi.gbl.user.account.model.CarltdAuthInfoRequest;
import com.autonavi.gbl.user.account.model.CarltdBindRequest;
import com.autonavi.gbl.user.account.model.CarltdCheckBindRequest;
import com.autonavi.gbl.user.account.model.CarltdCheckTokenRequest;
import com.autonavi.gbl.user.account.model.CarltdLoginRequest;
import com.autonavi.gbl.user.account.model.CarltdQLoginRequest;
import com.autonavi.gbl.user.account.model.CarltdUnBindRequest;
import com.autonavi.gbl.user.account.model.MobileLoginRequest;
import com.autonavi.gbl.user.account.model.QRCodeLoginConfirmRequest;
import com.autonavi.gbl.user.account.model.QRCodeLoginRequest;
import com.autonavi.gbl.user.account.model.UnBindMobileRequest;
import com.autonavi.gbl.user.account.model.VerificationCodeRequest;
import com.autonavi.gbl.user.account.observer.IAccountServiceObserver;
import com.autonavi.gbl.user.account.observer.impl.IAccountServiceObserverImpl;
import com.autonavi.gbl.util.model.ServiceInitStatus;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;
@IntfAuto(target = IAccountServiceImpl.class, type = BuildType.JCTRL)
/* loaded from: classes2.dex */
public class AccountService implements IService {
    private static String PACKAGE = ReflexTool.PN(AccountService.class);
    private IAccountServiceImpl mControl;
    private boolean mHasDestroy;
    private String mTargetId;
    private TypeHelper mTypeHelper;

    protected AccountService(long j, boolean z) {
        this((IAccountServiceImpl) ReflexTool.invokeDeclConstructorSafe(IAccountServiceImpl.class, new Class[]{Long.TYPE, Boolean.TYPE}, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}));
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            typeHelper.bind(AccountService.class, this, this.mControl);
        }
    }

    public AccountService(IAccountServiceImpl iAccountServiceImpl) {
        this.mTargetId = null;
        this.mTypeHelper = null;
        this.mHasDestroy = false;
        this.mControl = null;
        $constructor(iAccountServiceImpl);
    }

    private void $constructor(IAccountServiceImpl iAccountServiceImpl) {
        if (iAccountServiceImpl != null) {
            this.mControl = iAccountServiceImpl;
            this.mTargetId = String.format("AccountService_%s_%d", String.valueOf(IAccountServiceImpl.getCPtr(this.mControl)), Long.valueOf(System.currentTimeMillis()));
            this.mTypeHelper = new TypeHelper(this.mTargetId);
        }
    }

    protected IAccountServiceImpl getControl() {
        return this.mControl;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public boolean isRecycled() {
        IAccountServiceImpl iAccountServiceImpl = this.mControl;
        if (iAccountServiceImpl != null) {
            return iAccountServiceImpl.isRecycled();
        }
        return true;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public long getPtr() {
        IAccountServiceImpl iAccountServiceImpl = this.mControl;
        if (iAccountServiceImpl != null) {
            return iAccountServiceImpl.getPtr();
        }
        return 0L;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onCreate() {
        IAccountServiceImpl iAccountServiceImpl = this.mControl;
        if (iAccountServiceImpl != null) {
            iAccountServiceImpl.onCreate();
        }
    }

    public int init(AccountServiceParam accountServiceParam) {
        IAccountServiceImpl iAccountServiceImpl = this.mControl;
        if (iAccountServiceImpl != null) {
            return iAccountServiceImpl.init(accountServiceParam);
        }
        return Integer.MIN_VALUE;
    }

    public void unInit() {
        IAccountServiceImpl iAccountServiceImpl = this.mControl;
        if (iAccountServiceImpl != null) {
            iAccountServiceImpl.unInit();
        }
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    @ServiceInitStatus.ServiceInitStatus1
    public int isInit() {
        IAccountServiceImpl iAccountServiceImpl = this.mControl;
        if (iAccountServiceImpl != null) {
            return iAccountServiceImpl.isInit();
        }
        return Integer.MIN_VALUE;
    }

    public String getVersion() {
        IAccountServiceImpl iAccountServiceImpl = this.mControl;
        if (iAccountServiceImpl != null) {
            return iAccountServiceImpl.getVersion();
        }
        return null;
    }

    public void logSwitch(int i) {
        IAccountServiceImpl iAccountServiceImpl = this.mControl;
        if (iAccountServiceImpl != null) {
            iAccountServiceImpl.logSwitch(i);
        }
    }

    public int addObserver(IAccountServiceObserver iAccountServiceObserver) {
        TypeHelper typeHelper;
        try {
            Method method = AccountService.class.getMethod("addObserver", IAccountServiceObserver.class);
            IAccountServiceObserverImpl iAccountServiceObserverImpl = null;
            if (iAccountServiceObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iAccountServiceObserverImpl = (IAccountServiceObserverImpl) typeHelper.transfer(method, 0, iAccountServiceObserver);
            }
            IAccountServiceImpl iAccountServiceImpl = this.mControl;
            if (iAccountServiceImpl != null) {
                return iAccountServiceImpl.addObserver(iAccountServiceObserverImpl);
            }
            return Integer.MIN_VALUE;
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
            return Integer.MIN_VALUE;
        }
    }

    public void removeObserver(IAccountServiceObserver iAccountServiceObserver) {
        TypeHelper typeHelper;
        try {
            Method method = AccountService.class.getMethod("removeObserver", IAccountServiceObserver.class);
            IAccountServiceObserverImpl iAccountServiceObserverImpl = null;
            if (iAccountServiceObserver != null && (typeHelper = this.mTypeHelper) != null) {
                iAccountServiceObserverImpl = (IAccountServiceObserverImpl) typeHelper.transfer(method, 0, iAccountServiceObserver);
            }
            IAccountServiceImpl iAccountServiceImpl = this.mControl;
            if (iAccountServiceImpl != null) {
                iAccountServiceImpl.removeObserver(iAccountServiceObserverImpl);
                TypeHelper typeHelper2 = this.mTypeHelper;
                if (typeHelper2 != null) {
                    typeHelper2.unbind(method, 0, iAccountServiceObserver);
                }
            }
        } catch (Exception e) {
            Log.w("INTFAUTO", Log.getStackTraceString(e));
        }
    }

    public int executeRequest(AccountCheckRequest accountCheckRequest) {
        IAccountServiceImpl iAccountServiceImpl = this.mControl;
        if (iAccountServiceImpl != null) {
            return iAccountServiceImpl.executeRequest(accountCheckRequest);
        }
        return Integer.MIN_VALUE;
    }

    public int executeRequest(BindMobileRequest bindMobileRequest) {
        IAccountServiceImpl iAccountServiceImpl = this.mControl;
        if (iAccountServiceImpl != null) {
            return iAccountServiceImpl.executeRequest(bindMobileRequest);
        }
        return Integer.MIN_VALUE;
    }

    public int executeRequest(UnBindMobileRequest unBindMobileRequest) {
        IAccountServiceImpl iAccountServiceImpl = this.mControl;
        if (iAccountServiceImpl != null) {
            return iAccountServiceImpl.executeRequest(unBindMobileRequest);
        }
        return Integer.MIN_VALUE;
    }

    public int executeRequest(VerificationCodeRequest verificationCodeRequest) {
        IAccountServiceImpl iAccountServiceImpl = this.mControl;
        if (iAccountServiceImpl != null) {
            return iAccountServiceImpl.executeRequest(verificationCodeRequest);
        }
        return Integer.MIN_VALUE;
    }

    public int executeRequest(MobileLoginRequest mobileLoginRequest) {
        IAccountServiceImpl iAccountServiceImpl = this.mControl;
        if (iAccountServiceImpl != null) {
            return iAccountServiceImpl.executeRequest(mobileLoginRequest);
        }
        return Integer.MIN_VALUE;
    }

    public int executeRequest(QRCodeLoginRequest qRCodeLoginRequest) {
        IAccountServiceImpl iAccountServiceImpl = this.mControl;
        if (iAccountServiceImpl != null) {
            return iAccountServiceImpl.executeRequest(qRCodeLoginRequest);
        }
        return Integer.MIN_VALUE;
    }

    public int executeRequest(QRCodeLoginConfirmRequest qRCodeLoginConfirmRequest) {
        IAccountServiceImpl iAccountServiceImpl = this.mControl;
        if (iAccountServiceImpl != null) {
            return iAccountServiceImpl.executeRequest(qRCodeLoginConfirmRequest);
        }
        return Integer.MIN_VALUE;
    }

    public int executeRequest(AccountLogoutRequest accountLogoutRequest) {
        IAccountServiceImpl iAccountServiceImpl = this.mControl;
        if (iAccountServiceImpl != null) {
            return iAccountServiceImpl.executeRequest(accountLogoutRequest);
        }
        return Integer.MIN_VALUE;
    }

    public int executeRequest(AccountRegisterRequest accountRegisterRequest) {
        IAccountServiceImpl iAccountServiceImpl = this.mControl;
        if (iAccountServiceImpl != null) {
            return iAccountServiceImpl.executeRequest(accountRegisterRequest);
        }
        return Integer.MIN_VALUE;
    }

    public int executeRequest(AccountUnRegisterRequest accountUnRegisterRequest) {
        IAccountServiceImpl iAccountServiceImpl = this.mControl;
        if (iAccountServiceImpl != null) {
            return iAccountServiceImpl.executeRequest(accountUnRegisterRequest);
        }
        return Integer.MIN_VALUE;
    }

    public int executeRequest(AccountProfileRequest accountProfileRequest) {
        IAccountServiceImpl iAccountServiceImpl = this.mControl;
        if (iAccountServiceImpl != null) {
            return iAccountServiceImpl.executeRequest(accountProfileRequest);
        }
        return Integer.MIN_VALUE;
    }

    public int executeRequest(AvatarRequest avatarRequest) {
        IAccountServiceImpl iAccountServiceImpl = this.mControl;
        if (iAccountServiceImpl != null) {
            return iAccountServiceImpl.executeRequest(avatarRequest);
        }
        return Integer.MIN_VALUE;
    }

    public int executeRequest(CarltdCheckBindRequest carltdCheckBindRequest) {
        IAccountServiceImpl iAccountServiceImpl = this.mControl;
        if (iAccountServiceImpl != null) {
            return iAccountServiceImpl.executeRequest(carltdCheckBindRequest);
        }
        return Integer.MIN_VALUE;
    }

    public int executeRequest(CarltdCheckTokenRequest carltdCheckTokenRequest) {
        IAccountServiceImpl iAccountServiceImpl = this.mControl;
        if (iAccountServiceImpl != null) {
            return iAccountServiceImpl.executeRequest(carltdCheckTokenRequest);
        }
        return Integer.MIN_VALUE;
    }

    public int executeRequest(CarltdBindRequest carltdBindRequest) {
        IAccountServiceImpl iAccountServiceImpl = this.mControl;
        if (iAccountServiceImpl != null) {
            return iAccountServiceImpl.executeRequest(carltdBindRequest);
        }
        return Integer.MIN_VALUE;
    }

    public int executeRequest(CarltdLoginRequest carltdLoginRequest) {
        IAccountServiceImpl iAccountServiceImpl = this.mControl;
        if (iAccountServiceImpl != null) {
            return iAccountServiceImpl.executeRequest(carltdLoginRequest);
        }
        return Integer.MIN_VALUE;
    }

    public int executeRequest(CarltdQLoginRequest carltdQLoginRequest) {
        IAccountServiceImpl iAccountServiceImpl = this.mControl;
        if (iAccountServiceImpl != null) {
            return iAccountServiceImpl.executeRequest(carltdQLoginRequest);
        }
        return Integer.MIN_VALUE;
    }

    public int executeRequest(CarltdUnBindRequest carltdUnBindRequest) {
        IAccountServiceImpl iAccountServiceImpl = this.mControl;
        if (iAccountServiceImpl != null) {
            return iAccountServiceImpl.executeRequest(carltdUnBindRequest);
        }
        return Integer.MIN_VALUE;
    }

    public int executeRequest(CarltdAuthInfoRequest carltdAuthInfoRequest) {
        IAccountServiceImpl iAccountServiceImpl = this.mControl;
        if (iAccountServiceImpl != null) {
            return iAccountServiceImpl.executeRequest(carltdAuthInfoRequest);
        }
        return Integer.MIN_VALUE;
    }

    public int abortRequest(long j) {
        IAccountServiceImpl iAccountServiceImpl = this.mControl;
        if (iAccountServiceImpl != null) {
            return iAccountServiceImpl.abortRequest(j);
        }
        return Integer.MIN_VALUE;
    }

    public AccountProfile getUserData() {
        IAccountServiceImpl iAccountServiceImpl = this.mControl;
        if (iAccountServiceImpl != null) {
            return iAccountServiceImpl.getUserData();
        }
        return null;
    }

    public int deleteUserData() {
        IAccountServiceImpl iAccountServiceImpl = this.mControl;
        if (iAccountServiceImpl != null) {
            return iAccountServiceImpl.deleteUserData();
        }
        return Integer.MIN_VALUE;
    }

    public int saveUserData(AccountProfile accountProfile) {
        IAccountServiceImpl iAccountServiceImpl = this.mControl;
        if (iAccountServiceImpl != null) {
            return iAccountServiceImpl.saveUserData(accountProfile);
        }
        return Integer.MIN_VALUE;
    }

    public boolean getCarLoginFlag() {
        IAccountServiceImpl iAccountServiceImpl = this.mControl;
        if (iAccountServiceImpl != null) {
            return iAccountServiceImpl.getCarLoginFlag();
        }
        return false;
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

    protected void clean() {
        TypeHelper typeHelper = this.mTypeHelper;
        if (typeHelper != null) {
            Iterator it = ((HashSet) typeHelper.getBindSet("com.autonavi.gbl.user.account.observer.IAccountServiceObserver")).iterator();
            while (it.hasNext()) {
                removeObserver((IAccountServiceObserver) it.next());
            }
        }
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
