package com.alibaba.android.ark;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public abstract class AIMSettingService {
    public abstract void AddSyncProtocolSetting(ArrayList<AIMSyncProtocolInfo> arrayList);

    public abstract void SetAppKey(String str);

    public abstract void SetAppLocale(String str);

    public abstract void SetAppName(String str);

    public abstract void SetAppVersion(String str);

    public abstract void SetAuthTokenCallback(AIMAuthTokenCallback aIMAuthTokenCallback);

    public abstract void SetCustomUserAgent(String str);

    public abstract void SetDataPath(String str);

    public abstract void SetDeviceId(String str);

    public abstract void SetDeviceLocale(String str);

    public abstract void SetDeviceName(String str);

    public abstract void SetDeviceType(String str);

    public abstract void SetDisableSslVerify(boolean z);

    public abstract void SetEnableFileTransportCache(boolean z);

    public abstract void SetEnableIpv6(boolean z);

    public abstract void SetFileUploadConnectionType(AIMConnectionType aIMConnectionType);

    public abstract void SetFileUploadServerAddress(String str);

    public abstract void SetFirstLoginConvSize(int i);

    public abstract void SetGreySwitchCallback(AIMGreySwitchCallback aIMGreySwitchCallback);

    public abstract void SetLongLinkConnectionType(AIMConnectionType aIMConnectionType);

    public abstract void SetLonglinkServerAddress(String str);

    public abstract void SetMediaHost(ArrayList<AIMMediaHost> arrayList);

    public abstract void SetMultiConvSupport(boolean z);

    public abstract void SetOSName(String str);

    public abstract void SetOSVersion(String str);

    public abstract void SetProxyInfo(AIMProxyInfo aIMProxyInfo);

    public abstract void SetRPCTimeout(long j);

    public abstract void SetSamplingRateCallback(AIMSettingSamplingRateCallback aIMSettingSamplingRateCallback);

    public abstract void SetTimeZone(String str);

    public abstract void SetTlsVerifyHost(String str);

    /* loaded from: classes.dex */
    private static final class CppProxy extends AIMSettingService {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        private native void AddSyncProtocolSettingNative(long j, ArrayList<AIMSyncProtocolInfo> arrayList);

        private native void SetAppKeyNative(long j, String str);

        private native void SetAppLocaleNative(long j, String str);

        private native void SetAppNameNative(long j, String str);

        private native void SetAppVersionNative(long j, String str);

        private native void SetAuthTokenCallbackNative(long j, AIMAuthTokenCallback aIMAuthTokenCallback);

        private native void SetCustomUserAgentNative(long j, String str);

        private native void SetDataPathNative(long j, String str);

        private native void SetDeviceIdNative(long j, String str);

        private native void SetDeviceLocaleNative(long j, String str);

        private native void SetDeviceNameNative(long j, String str);

        private native void SetDeviceTypeNative(long j, String str);

        private native void SetDisableSslVerifyNative(long j, boolean z);

        private native void SetEnableFileTransportCacheNative(long j, boolean z);

        private native void SetEnableIpv6Native(long j, boolean z);

        private native void SetFileUploadConnectionTypeNative(long j, AIMConnectionType aIMConnectionType);

        private native void SetFileUploadServerAddressNative(long j, String str);

        private native void SetFirstLoginConvSizeNative(long j, int i);

        private native void SetGreySwitchCallbackNative(long j, AIMGreySwitchCallback aIMGreySwitchCallback);

        private native void SetLongLinkConnectionTypeNative(long j, AIMConnectionType aIMConnectionType);

        private native void SetLonglinkServerAddressNative(long j, String str);

        private native void SetMediaHostNative(long j, ArrayList<AIMMediaHost> arrayList);

        private native void SetMultiConvSupportNative(long j, boolean z);

        private native void SetOSNameNative(long j, String str);

        private native void SetOSVersionNative(long j, String str);

        private native void SetProxyInfoNative(long j, AIMProxyInfo aIMProxyInfo);

        private native void SetRPCTimeoutNative(long j, long j2);

        private native void SetSamplingRateCallbackNative(long j, AIMSettingSamplingRateCallback aIMSettingSamplingRateCallback);

        private native void SetTimeZoneNative(long j, String str);

        private native void SetTlsVerifyHostNative(long j, String str);

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

        @Override // com.alibaba.android.ark.AIMSettingService
        public void SetMediaHost(ArrayList<AIMMediaHost> arrayList) {
            SetMediaHostNative(this.nativeRef, arrayList);
        }

        @Override // com.alibaba.android.ark.AIMSettingService
        public void SetAppKey(String str) {
            SetAppKeyNative(this.nativeRef, str);
        }

        @Override // com.alibaba.android.ark.AIMSettingService
        public void SetDataPath(String str) {
            SetDataPathNative(this.nativeRef, str);
        }

        @Override // com.alibaba.android.ark.AIMSettingService
        public void SetAppName(String str) {
            SetAppNameNative(this.nativeRef, str);
        }

        @Override // com.alibaba.android.ark.AIMSettingService
        public void SetAppVersion(String str) {
            SetAppVersionNative(this.nativeRef, str);
        }

        @Override // com.alibaba.android.ark.AIMSettingService
        public void SetAppLocale(String str) {
            SetAppLocaleNative(this.nativeRef, str);
        }

        @Override // com.alibaba.android.ark.AIMSettingService
        public void SetOSName(String str) {
            SetOSNameNative(this.nativeRef, str);
        }

        @Override // com.alibaba.android.ark.AIMSettingService
        public void SetOSVersion(String str) {
            SetOSVersionNative(this.nativeRef, str);
        }

        @Override // com.alibaba.android.ark.AIMSettingService
        public void SetDeviceName(String str) {
            SetDeviceNameNative(this.nativeRef, str);
        }

        @Override // com.alibaba.android.ark.AIMSettingService
        public void SetDeviceType(String str) {
            SetDeviceTypeNative(this.nativeRef, str);
        }

        @Override // com.alibaba.android.ark.AIMSettingService
        public void SetDeviceLocale(String str) {
            SetDeviceLocaleNative(this.nativeRef, str);
        }

        @Override // com.alibaba.android.ark.AIMSettingService
        public void SetDeviceId(String str) {
            SetDeviceIdNative(this.nativeRef, str);
        }

        @Override // com.alibaba.android.ark.AIMSettingService
        public void SetTimeZone(String str) {
            SetTimeZoneNative(this.nativeRef, str);
        }

        @Override // com.alibaba.android.ark.AIMSettingService
        public void SetLonglinkServerAddress(String str) {
            SetLonglinkServerAddressNative(this.nativeRef, str);
        }

        @Override // com.alibaba.android.ark.AIMSettingService
        public void SetFileUploadServerAddress(String str) {
            SetFileUploadServerAddressNative(this.nativeRef, str);
        }

        @Override // com.alibaba.android.ark.AIMSettingService
        public void SetFirstLoginConvSize(int i) {
            SetFirstLoginConvSizeNative(this.nativeRef, i);
        }

        @Override // com.alibaba.android.ark.AIMSettingService
        public void SetAuthTokenCallback(AIMAuthTokenCallback aIMAuthTokenCallback) {
            SetAuthTokenCallbackNative(this.nativeRef, aIMAuthTokenCallback);
        }

        @Override // com.alibaba.android.ark.AIMSettingService
        public void SetSamplingRateCallback(AIMSettingSamplingRateCallback aIMSettingSamplingRateCallback) {
            SetSamplingRateCallbackNative(this.nativeRef, aIMSettingSamplingRateCallback);
        }

        @Override // com.alibaba.android.ark.AIMSettingService
        public void AddSyncProtocolSetting(ArrayList<AIMSyncProtocolInfo> arrayList) {
            AddSyncProtocolSettingNative(this.nativeRef, arrayList);
        }

        @Override // com.alibaba.android.ark.AIMSettingService
        public void SetMultiConvSupport(boolean z) {
            SetMultiConvSupportNative(this.nativeRef, z);
        }

        @Override // com.alibaba.android.ark.AIMSettingService
        public void SetLongLinkConnectionType(AIMConnectionType aIMConnectionType) {
            SetLongLinkConnectionTypeNative(this.nativeRef, aIMConnectionType);
        }

        @Override // com.alibaba.android.ark.AIMSettingService
        public void SetFileUploadConnectionType(AIMConnectionType aIMConnectionType) {
            SetFileUploadConnectionTypeNative(this.nativeRef, aIMConnectionType);
        }

        @Override // com.alibaba.android.ark.AIMSettingService
        public void SetCustomUserAgent(String str) {
            SetCustomUserAgentNative(this.nativeRef, str);
        }

        @Override // com.alibaba.android.ark.AIMSettingService
        public void SetEnableIpv6(boolean z) {
            SetEnableIpv6Native(this.nativeRef, z);
        }

        @Override // com.alibaba.android.ark.AIMSettingService
        public void SetDisableSslVerify(boolean z) {
            SetDisableSslVerifyNative(this.nativeRef, z);
        }

        @Override // com.alibaba.android.ark.AIMSettingService
        public void SetGreySwitchCallback(AIMGreySwitchCallback aIMGreySwitchCallback) {
            SetGreySwitchCallbackNative(this.nativeRef, aIMGreySwitchCallback);
        }

        @Override // com.alibaba.android.ark.AIMSettingService
        public void SetTlsVerifyHost(String str) {
            SetTlsVerifyHostNative(this.nativeRef, str);
        }

        @Override // com.alibaba.android.ark.AIMSettingService
        public void SetEnableFileTransportCache(boolean z) {
            SetEnableFileTransportCacheNative(this.nativeRef, z);
        }

        @Override // com.alibaba.android.ark.AIMSettingService
        public void SetProxyInfo(AIMProxyInfo aIMProxyInfo) {
            SetProxyInfoNative(this.nativeRef, aIMProxyInfo);
        }

        @Override // com.alibaba.android.ark.AIMSettingService
        public void SetRPCTimeout(long j) {
            SetRPCTimeoutNative(this.nativeRef, j);
        }
    }
}
