package com.alibaba.android.ark;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public abstract class AIMEngine {
    public static final int MAX_MANAGER_NUM = 10;

    public abstract void CreateIMManager(AIMUserId aIMUserId, HashMap<String, String> hashMap, AIMManagerCreateListener aIMManagerCreateListener);

    public abstract AIMManager GetIMManager(AIMUserId aIMUserId);

    public abstract long GetServerTimeClock();

    public abstract AIMSettingService GetSettingService();

    public abstract ArrayList<AIMUserId> GetUserIds();

    public abstract boolean IsStarted();

    public abstract void OnAppDidEnterBackground();

    public abstract void OnAppWillEnterForeground();

    public abstract AIMError RegisterModule(DPSModuleInfo dPSModuleInfo);

    public abstract void ReleaseIMManager(AIMUserId aIMUserId, AIMReleaseManagerListener aIMReleaseManagerListener);

    public abstract void SetListener(AIMEngineListener aIMEngineListener);

    public abstract void Start(AIMEngineStartListener aIMEngineStartListener);

    public static AIMEngine CreateAIMEngine() {
        return CppProxy.CreateAIMEngine();
    }

    public static AIMEngine GetAIMEngine() {
        return CppProxy.GetAIMEngine();
    }

    public static void SetLogHandler(AIMLogLevel aIMLogLevel, AIMLogHandler aIMLogHandler) {
        CppProxy.SetLogHandler(aIMLogLevel, aIMLogHandler);
    }

    public static void ReleaseAIMEngine() {
        CppProxy.ReleaseAIMEngine();
    }

    public static void ResetUserData(String str, AIMUserId aIMUserId, AIMResetUserDataListener aIMResetUserDataListener) {
        CppProxy.ResetUserData(str, aIMUserId, aIMResetUserDataListener);
    }

    /* loaded from: classes.dex */
    private static final class CppProxy extends AIMEngine {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        public static native AIMEngine CreateAIMEngine();

        private native void CreateIMManagerNative(long j, AIMUserId aIMUserId, HashMap<String, String> hashMap, AIMManagerCreateListener aIMManagerCreateListener);

        public static native AIMEngine GetAIMEngine();

        private native AIMManager GetIMManagerNative(long j, AIMUserId aIMUserId);

        private native long GetServerTimeClockNative(long j);

        private native AIMSettingService GetSettingServiceNative(long j);

        private native ArrayList<AIMUserId> GetUserIdsNative(long j);

        private native boolean IsStartedNative(long j);

        private native void OnAppDidEnterBackgroundNative(long j);

        private native void OnAppWillEnterForegroundNative(long j);

        private native AIMError RegisterModuleNative(long j, DPSModuleInfo dPSModuleInfo);

        public static native void ReleaseAIMEngine();

        private native void ReleaseIMManagerNative(long j, AIMUserId aIMUserId, AIMReleaseManagerListener aIMReleaseManagerListener);

        public static native void ResetUserData(String str, AIMUserId aIMUserId, AIMResetUserDataListener aIMResetUserDataListener);

        private native void SetListenerNative(long j, AIMEngineListener aIMEngineListener);

        public static native void SetLogHandler(AIMLogLevel aIMLogLevel, AIMLogHandler aIMLogHandler);

        private native void StartNative(long j, AIMEngineStartListener aIMEngineStartListener);

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

        @Override // com.alibaba.android.ark.AIMEngine
        public void OnAppDidEnterBackground() {
            OnAppDidEnterBackgroundNative(this.nativeRef);
        }

        @Override // com.alibaba.android.ark.AIMEngine
        public void OnAppWillEnterForeground() {
            OnAppWillEnterForegroundNative(this.nativeRef);
        }

        @Override // com.alibaba.android.ark.AIMEngine
        public AIMSettingService GetSettingService() {
            return GetSettingServiceNative(this.nativeRef);
        }

        @Override // com.alibaba.android.ark.AIMEngine
        public boolean IsStarted() {
            return IsStartedNative(this.nativeRef);
        }

        @Override // com.alibaba.android.ark.AIMEngine
        public void Start(AIMEngineStartListener aIMEngineStartListener) {
            StartNative(this.nativeRef, aIMEngineStartListener);
        }

        @Override // com.alibaba.android.ark.AIMEngine
        public void SetListener(AIMEngineListener aIMEngineListener) {
            SetListenerNative(this.nativeRef, aIMEngineListener);
        }

        @Override // com.alibaba.android.ark.AIMEngine
        public ArrayList<AIMUserId> GetUserIds() {
            return GetUserIdsNative(this.nativeRef);
        }

        @Override // com.alibaba.android.ark.AIMEngine
        public void CreateIMManager(AIMUserId aIMUserId, HashMap<String, String> hashMap, AIMManagerCreateListener aIMManagerCreateListener) {
            CreateIMManagerNative(this.nativeRef, aIMUserId, hashMap, aIMManagerCreateListener);
        }

        @Override // com.alibaba.android.ark.AIMEngine
        public AIMManager GetIMManager(AIMUserId aIMUserId) {
            return GetIMManagerNative(this.nativeRef, aIMUserId);
        }

        @Override // com.alibaba.android.ark.AIMEngine
        public void ReleaseIMManager(AIMUserId aIMUserId, AIMReleaseManagerListener aIMReleaseManagerListener) {
            ReleaseIMManagerNative(this.nativeRef, aIMUserId, aIMReleaseManagerListener);
        }

        @Override // com.alibaba.android.ark.AIMEngine
        public long GetServerTimeClock() {
            return GetServerTimeClockNative(this.nativeRef);
        }

        @Override // com.alibaba.android.ark.AIMEngine
        public AIMError RegisterModule(DPSModuleInfo dPSModuleInfo) {
            return RegisterModuleNative(this.nativeRef, dPSModuleInfo);
        }
    }
}
