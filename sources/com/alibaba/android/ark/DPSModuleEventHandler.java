package com.alibaba.android.ark;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public abstract class DPSModuleEventHandler {
    public abstract void OnAppDidEnterBackground();

    public abstract void OnAppWillEnterForeground();

    public abstract void OnBeforeEngineStart();

    public abstract void OnBeforeManagerCreate(AIMUserId aIMUserId);

    public abstract void OnEngineReleased();

    public abstract void OnEngineStarted();

    public abstract DPSAuthHandler OnGetAuthHandler(AIMUserId aIMUserId);

    public abstract ArrayList<AIMSyncProtocolInfo> OnGetSyncProtocolInfo();

    public abstract void OnInitModuleForUser(AIMUserId aIMUserId, DPSModuleEventHandlerCallback dPSModuleEventHandlerCallback, DPSServiceProvider dPSServiceProvider);

    public abstract void OnManagerCreateFinished(AIMUserId aIMUserId, AIMError aIMError);

    public abstract void OnReleaseManager(AIMUserId aIMUserId);

    /* loaded from: classes.dex */
    private static final class CppProxy extends DPSModuleEventHandler {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        private native void OnAppDidEnterBackgroundNative(long j);

        private native void OnAppWillEnterForegroundNative(long j);

        private native void OnBeforeEngineStartNative(long j);

        private native void OnBeforeManagerCreateNative(long j, AIMUserId aIMUserId);

        private native void OnEngineReleasedNative(long j);

        private native void OnEngineStartedNative(long j);

        private native DPSAuthHandler OnGetAuthHandlerNative(long j, AIMUserId aIMUserId);

        private native ArrayList<AIMSyncProtocolInfo> OnGetSyncProtocolInfoNative(long j);

        private native void OnInitModuleForUserNative(long j, AIMUserId aIMUserId, DPSModuleEventHandlerCallback dPSModuleEventHandlerCallback, DPSServiceProvider dPSServiceProvider);

        private native void OnManagerCreateFinishedNative(long j, AIMUserId aIMUserId, AIMError aIMError);

        private native void OnReleaseManagerNative(long j, AIMUserId aIMUserId);

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

        @Override // com.alibaba.android.ark.DPSModuleEventHandler
        public void OnBeforeEngineStart() {
            OnBeforeEngineStartNative(this.nativeRef);
        }

        @Override // com.alibaba.android.ark.DPSModuleEventHandler
        public void OnEngineStarted() {
            OnEngineStartedNative(this.nativeRef);
        }

        @Override // com.alibaba.android.ark.DPSModuleEventHandler
        public void OnBeforeManagerCreate(AIMUserId aIMUserId) {
            OnBeforeManagerCreateNative(this.nativeRef, aIMUserId);
        }

        @Override // com.alibaba.android.ark.DPSModuleEventHandler
        public void OnInitModuleForUser(AIMUserId aIMUserId, DPSModuleEventHandlerCallback dPSModuleEventHandlerCallback, DPSServiceProvider dPSServiceProvider) {
            OnInitModuleForUserNative(this.nativeRef, aIMUserId, dPSModuleEventHandlerCallback, dPSServiceProvider);
        }

        @Override // com.alibaba.android.ark.DPSModuleEventHandler
        public void OnManagerCreateFinished(AIMUserId aIMUserId, AIMError aIMError) {
            OnManagerCreateFinishedNative(this.nativeRef, aIMUserId, aIMError);
        }

        @Override // com.alibaba.android.ark.DPSModuleEventHandler
        public void OnReleaseManager(AIMUserId aIMUserId) {
            OnReleaseManagerNative(this.nativeRef, aIMUserId);
        }

        @Override // com.alibaba.android.ark.DPSModuleEventHandler
        public void OnAppDidEnterBackground() {
            OnAppDidEnterBackgroundNative(this.nativeRef);
        }

        @Override // com.alibaba.android.ark.DPSModuleEventHandler
        public void OnAppWillEnterForeground() {
            OnAppWillEnterForegroundNative(this.nativeRef);
        }

        @Override // com.alibaba.android.ark.DPSModuleEventHandler
        public void OnEngineReleased() {
            OnEngineReleasedNative(this.nativeRef);
        }

        @Override // com.alibaba.android.ark.DPSModuleEventHandler
        public DPSAuthHandler OnGetAuthHandler(AIMUserId aIMUserId) {
            return OnGetAuthHandlerNative(this.nativeRef, aIMUserId);
        }

        @Override // com.alibaba.android.ark.DPSModuleEventHandler
        public ArrayList<AIMSyncProtocolInfo> OnGetSyncProtocolInfo() {
            return OnGetSyncProtocolInfoNative(this.nativeRef);
        }
    }
}
