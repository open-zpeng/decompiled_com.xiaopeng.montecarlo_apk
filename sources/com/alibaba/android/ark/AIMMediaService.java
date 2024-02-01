package com.alibaba.android.ark;

import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public abstract class AIMMediaService {
    public abstract void CancelFileTask(String str);

    public abstract void DownloadFile(AIMDownloadFileParam aIMDownloadFileParam, AIMDownloadFileListener aIMDownloadFileListener);

    public abstract String GetUrlConstantPart(String str);

    public abstract String TransferMediaIdToAuthImageUrl(String str, AIMImageSizeType aIMImageSizeType, AIMMediaAuthInfo aIMMediaAuthInfo);

    public abstract String TransferMediaIdToAuthImageUrlBizType(String str, AIMImageSizeType aIMImageSizeType, AIMMediaAuthInfo aIMMediaAuthInfo, String str2);

    public abstract String TransferMediaIdToAuthUrl(String str, AIMMediaAuthInfo aIMMediaAuthInfo);

    public abstract String TransferMediaIdToAuthUrlBizType(String str, AIMMediaAuthInfo aIMMediaAuthInfo, String str2);

    public abstract String TransferMediaIdToImageUrl(String str, AIMImageSizeType aIMImageSizeType);

    public abstract String TransferMediaIdToImageUrlWithBizType(String str, AIMImageSizeType aIMImageSizeType, String str2);

    public abstract String TransferMediaIdToUrl(String str);

    public abstract String TransferMediaIdToUrlWithBizType(String str, String str2);

    public abstract void UploadFile(AIMUploadFileParam aIMUploadFileParam, AIMUploadFileListener aIMUploadFileListener);

    /* loaded from: classes.dex */
    private static final class CppProxy extends AIMMediaService {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        private native void CancelFileTaskNative(long j, String str);

        private native void DownloadFileNative(long j, AIMDownloadFileParam aIMDownloadFileParam, AIMDownloadFileListener aIMDownloadFileListener);

        private native String GetUrlConstantPartNative(long j, String str);

        private native String TransferMediaIdToAuthImageUrlBizTypeNative(long j, String str, AIMImageSizeType aIMImageSizeType, AIMMediaAuthInfo aIMMediaAuthInfo, String str2);

        private native String TransferMediaIdToAuthImageUrlNative(long j, String str, AIMImageSizeType aIMImageSizeType, AIMMediaAuthInfo aIMMediaAuthInfo);

        private native String TransferMediaIdToAuthUrlBizTypeNative(long j, String str, AIMMediaAuthInfo aIMMediaAuthInfo, String str2);

        private native String TransferMediaIdToAuthUrlNative(long j, String str, AIMMediaAuthInfo aIMMediaAuthInfo);

        private native String TransferMediaIdToImageUrlNative(long j, String str, AIMImageSizeType aIMImageSizeType);

        private native String TransferMediaIdToImageUrlWithBizTypeNative(long j, String str, AIMImageSizeType aIMImageSizeType, String str2);

        private native String TransferMediaIdToUrlNative(long j, String str);

        private native String TransferMediaIdToUrlWithBizTypeNative(long j, String str, String str2);

        private native void UploadFileNative(long j, AIMUploadFileParam aIMUploadFileParam, AIMUploadFileListener aIMUploadFileListener);

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

        @Override // com.alibaba.android.ark.AIMMediaService
        public void UploadFile(AIMUploadFileParam aIMUploadFileParam, AIMUploadFileListener aIMUploadFileListener) {
            UploadFileNative(this.nativeRef, aIMUploadFileParam, aIMUploadFileListener);
        }

        @Override // com.alibaba.android.ark.AIMMediaService
        public void DownloadFile(AIMDownloadFileParam aIMDownloadFileParam, AIMDownloadFileListener aIMDownloadFileListener) {
            DownloadFileNative(this.nativeRef, aIMDownloadFileParam, aIMDownloadFileListener);
        }

        @Override // com.alibaba.android.ark.AIMMediaService
        public void CancelFileTask(String str) {
            CancelFileTaskNative(this.nativeRef, str);
        }

        @Override // com.alibaba.android.ark.AIMMediaService
        public String TransferMediaIdToImageUrl(String str, AIMImageSizeType aIMImageSizeType) {
            return TransferMediaIdToImageUrlNative(this.nativeRef, str, aIMImageSizeType);
        }

        @Override // com.alibaba.android.ark.AIMMediaService
        public String TransferMediaIdToImageUrlWithBizType(String str, AIMImageSizeType aIMImageSizeType, String str2) {
            return TransferMediaIdToImageUrlWithBizTypeNative(this.nativeRef, str, aIMImageSizeType, str2);
        }

        @Override // com.alibaba.android.ark.AIMMediaService
        public String TransferMediaIdToUrl(String str) {
            return TransferMediaIdToUrlNative(this.nativeRef, str);
        }

        @Override // com.alibaba.android.ark.AIMMediaService
        public String TransferMediaIdToUrlWithBizType(String str, String str2) {
            return TransferMediaIdToUrlWithBizTypeNative(this.nativeRef, str, str2);
        }

        @Override // com.alibaba.android.ark.AIMMediaService
        public String TransferMediaIdToAuthImageUrl(String str, AIMImageSizeType aIMImageSizeType, AIMMediaAuthInfo aIMMediaAuthInfo) {
            return TransferMediaIdToAuthImageUrlNative(this.nativeRef, str, aIMImageSizeType, aIMMediaAuthInfo);
        }

        @Override // com.alibaba.android.ark.AIMMediaService
        public String TransferMediaIdToAuthImageUrlBizType(String str, AIMImageSizeType aIMImageSizeType, AIMMediaAuthInfo aIMMediaAuthInfo, String str2) {
            return TransferMediaIdToAuthImageUrlBizTypeNative(this.nativeRef, str, aIMImageSizeType, aIMMediaAuthInfo, str2);
        }

        @Override // com.alibaba.android.ark.AIMMediaService
        public String TransferMediaIdToAuthUrl(String str, AIMMediaAuthInfo aIMMediaAuthInfo) {
            return TransferMediaIdToAuthUrlNative(this.nativeRef, str, aIMMediaAuthInfo);
        }

        @Override // com.alibaba.android.ark.AIMMediaService
        public String TransferMediaIdToAuthUrlBizType(String str, AIMMediaAuthInfo aIMMediaAuthInfo, String str2) {
            return TransferMediaIdToAuthUrlBizTypeNative(this.nativeRef, str, aIMMediaAuthInfo, str2);
        }

        @Override // com.alibaba.android.ark.AIMMediaService
        public String GetUrlConstantPart(String str) {
            return GetUrlConstantPartNative(this.nativeRef, str);
        }
    }
}
