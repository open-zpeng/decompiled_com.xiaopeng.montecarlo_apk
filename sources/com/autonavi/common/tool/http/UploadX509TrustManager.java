package com.autonavi.common.tool.http;

import com.autonavi.common.tool.util.LogUtil;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import libcore.io.IoUtils;
/* loaded from: classes.dex */
public class UploadX509TrustManager implements X509TrustManager {
    private String caCertsPath;
    private CertificateFactory mCertFactory;
    private Set<X509Certificate> mCertificates;
    private File mDir;
    private final Object mLock = new Object();
    private boolean mNeedCheck;

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
    }

    public UploadX509TrustManager(boolean z, String str) {
        this.mNeedCheck = false;
        this.caCertsPath = "";
        this.mNeedCheck = z;
        if (this.mNeedCheck) {
            this.caCertsPath = str;
            this.mDir = new File(this.caCertsPath);
            try {
                this.mCertFactory = CertificateFactory.getInstance("X.509");
                this.mCertificates = initCertificates();
            } catch (CertificateException unused) {
                LogUtil.logE("Failed to obtain X.509 CertificateFactory");
            }
        }
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        if (this.mNeedCheck) {
            for (X509Certificate x509Certificate : x509CertificateArr) {
                for (X509Certificate x509Certificate2 : this.mCertificates) {
                    try {
                        x509Certificate.verify(x509Certificate2.getPublicKey());
                        return;
                    } catch (Exception e) {
                        LogUtil.logE("Failed to verify with message" + e.getMessage());
                    }
                }
            }
            LogUtil.logE("Failed to verify with custom certs");
            X509TrustManager systemDefaultTrustManager = getSystemDefaultTrustManager();
            if (systemDefaultTrustManager == null) {
                throw new CertificateException();
            }
            systemDefaultTrustManager.checkServerTrusted(x509CertificateArr, str);
        }
    }

    @Override // javax.net.ssl.X509TrustManager
    public X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[0];
    }

    private Set<X509Certificate> initCertificates() {
        synchronized (this.mLock) {
            if (this.mCertificates != null) {
                return this.mCertificates;
            }
            HashSet hashSet = new HashSet();
            if (this.mDir.isDirectory()) {
                for (String str : this.mDir.list()) {
                    X509Certificate readCertificate = readCertificate(str);
                    if (readCertificate != null) {
                        hashSet.add(readCertificate);
                    }
                }
            }
            this.mCertificates = hashSet;
            return this.mCertificates;
        }
    }

    private X509Certificate readCertificate(String str) {
        BufferedInputStream bufferedInputStream;
        try {
            try {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(new File(this.mDir, str)));
            } catch (Throwable th) {
                th = th;
                IoUtils.closeQuietly((AutoCloseable) null);
                throw th;
            }
        } catch (IOException e) {
            e = e;
            bufferedInputStream = null;
            LogUtil.logE("Failed to read certificate from " + str + "exception :" + e.getMessage());
            IoUtils.closeQuietly(bufferedInputStream);
            return null;
        } catch (CertificateException e2) {
            e = e2;
            bufferedInputStream = null;
            LogUtil.logE("Failed to read certificate from " + str + "exception :" + e.getMessage());
            IoUtils.closeQuietly(bufferedInputStream);
            return null;
        } catch (Throwable th2) {
            th = th2;
            IoUtils.closeQuietly((AutoCloseable) null);
            throw th;
        }
        try {
            X509Certificate x509Certificate = (X509Certificate) this.mCertFactory.generateCertificate(bufferedInputStream);
            IoUtils.closeQuietly(bufferedInputStream);
            return x509Certificate;
        } catch (IOException e3) {
            e = e3;
            LogUtil.logE("Failed to read certificate from " + str + "exception :" + e.getMessage());
            IoUtils.closeQuietly(bufferedInputStream);
            return null;
        } catch (CertificateException e4) {
            e = e4;
            LogUtil.logE("Failed to read certificate from " + str + "exception :" + e.getMessage());
            IoUtils.closeQuietly(bufferedInputStream);
            return null;
        }
    }

    private X509TrustManager getSystemDefaultTrustManager() {
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init((KeyStore) null);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            if (trustManagers.length == 1 && (trustManagers[0] instanceof X509TrustManager)) {
                return (X509TrustManager) trustManagers[0];
            }
            LogUtil.logE("Unexpected default trust managers:" + Arrays.toString(trustManagers));
            return null;
        } catch (GeneralSecurityException e) {
            LogUtil.logE("Unexpected exception" + e.getMessage());
            return null;
        }
    }
}
