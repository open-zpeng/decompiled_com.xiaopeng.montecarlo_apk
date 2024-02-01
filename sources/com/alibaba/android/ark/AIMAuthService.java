package com.alibaba.android.ark;

import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public abstract class AIMAuthService {
    public abstract boolean AddListener(AIMAuthListener aIMAuthListener);

    public abstract AIMConnectionStatus GetConnectionStatus();

    public abstract AIMNetType GetNetType();

    public abstract boolean IsLocalLogin();

    public abstract boolean IsNetworkAvailable();

    public abstract void Kickout(int i, String str, AIMKickoutListener aIMKickoutListener);

    public abstract void Login();

    public abstract void Logout(AIMLogoutListener aIMLogoutListener);

    public abstract void RemoveAllListeners();

    public abstract boolean RemoveListener(AIMAuthListener aIMAuthListener);

    /* loaded from: classes.dex */
    private static final class CppProxy extends AIMAuthService {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        private native boolean AddListenerNative(long j, AIMAuthListener aIMAuthListener);

        private native AIMConnectionStatus GetConnectionStatusNative(long j);

        private native AIMNetType GetNetTypeNative(long j);

        private native boolean IsLocalLoginNative(long j);

        private native boolean IsNetworkAvailableNative(long j);

        private native void KickoutNative(long j, int i, String str, AIMKickoutListener aIMKickoutListener);

        private native void LoginNative(long j);

        private native void LogoutNative(long j, AIMLogoutListener aIMLogoutListener);

        private native void RemoveAllListenersNative(long j);

        private native boolean RemoveListenerNative(long j, AIMAuthListener aIMAuthListener);

        private native void nativeDestroy(long j);

        private CppProxy(long j) {
            if (j == 0) {
                throw new RuntimeException("nativeRef is zero");
            }
            this.nativeRef = j;
        }

        public void djinniPrivateDestroy() {
            if (this.destroyed.getAndSet(true)) {
                return;
            }
            nativeDestroy(this.nativeRef);
        }

        protected void finalize() throws Throwable {
            djinniPrivateDestroy();
            super.finalize();
        }

        @Override // com.alibaba.android.ark.AIMAuthService
        public boolean IsNetworkAvailable() {
            return IsNetworkAvailableNative(this.nativeRef);
        }

        @Override // com.alibaba.android.ark.AIMAuthService
        public AIMNetType GetNetType() {
            return GetNetTypeNative(this.nativeRef);
        }

        @Override // com.alibaba.android.ark.AIMAuthService
        public AIMConnectionStatus GetConnectionStatus() {
            return GetConnectionStatusNative(this.nativeRef);
        }

        @Override // com.alibaba.android.ark.AIMAuthService
        public boolean IsLocalLogin() {
            return IsLocalLoginNative(this.nativeRef);
        }

        @Override // com.alibaba.android.ark.AIMAuthService
        public void Login() {
            LoginNative(this.nativeRef);
        }

        @Override // com.alibaba.android.ark.AIMAuthService
        public void Logout(AIMLogoutListener aIMLogoutListener) {
            LogoutNative(this.nativeRef, aIMLogoutListener);
        }

        @Override // com.alibaba.android.ark.AIMAuthService
        public void Kickout(int i, String str, AIMKickoutListener aIMKickoutListener) {
            KickoutNative(this.nativeRef, i, str, aIMKickoutListener);
        }

        @Override // com.alibaba.android.ark.AIMAuthService
        public boolean AddListener(AIMAuthListener aIMAuthListener) {
            return AddListenerNative(this.nativeRef, aIMAuthListener);
        }

        @Override // com.alibaba.android.ark.AIMAuthService
        public boolean RemoveListener(AIMAuthListener aIMAuthListener) {
            return RemoveListenerNative(this.nativeRef, aIMAuthListener);
        }

        @Override // com.alibaba.android.ark.AIMAuthService
        public void RemoveAllListeners() {
            RemoveAllListenersNative(this.nativeRef);
        }
    }
}
