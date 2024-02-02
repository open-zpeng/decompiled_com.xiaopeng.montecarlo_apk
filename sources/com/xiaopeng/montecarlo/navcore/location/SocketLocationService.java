package com.xiaopeng.montecarlo.navcore.location;

import android.location.Location;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
/* loaded from: classes2.dex */
public class SocketLocationService {
    private static final int SERVER_PORT = 3000;
    private static final L.Tag TAG = new L.Tag("SocketLocationService");
    @Nullable
    private ServerSocket mServerSocket;
    @Nullable
    private IOSocketThread mSocketThread;
    private boolean mSocketRunningFlag = false;
    @NonNull
    private Object mMutex = new Object();

    public void startServerSocket() {
        synchronized (this.mMutex) {
            if (this.mSocketRunningFlag) {
                if (L.ENABLE) {
                    L.Tag tag = TAG;
                    L.d(tag, Thread.currentThread().getName() + ">>>> ServerSocket is running !!");
                }
                return;
            }
            try {
                this.mServerSocket = new ServerSocket(3000);
                Socket accept = this.mServerSocket.accept();
                this.mSocketRunningFlag = true;
                this.mSocketThread = new IOSocketThread(accept);
                WorkThreadUtil.getInstance().executeCachedTask(this.mSocketThread);
            } catch (IOException e) {
                e.printStackTrace();
                if (L.ENABLE) {
                    L.Tag tag2 = TAG;
                    L.d(tag2, Thread.currentThread().getName() + ">>>> startServerSocket fail");
                }
            }
        }
    }

    public void stopServerSocket() {
        synchronized (this.mMutex) {
            if (this.mSocketRunningFlag) {
                try {
                    if (L.ENABLE) {
                        L.Tag tag = TAG;
                        L.d(tag, Thread.currentThread().getName() + ">>>> stopServerSocket close mServerSocket");
                    }
                    if (this.mServerSocket != null) {
                        this.mServerSocket.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (this.mSocketThread != null) {
                    this.mSocketThread.setRunningFlag(false);
                }
                this.mSocketThread = null;
                this.mServerSocket = null;
                this.mSocketRunningFlag = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void restartServerSocket() {
        synchronized (this.mMutex) {
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, Thread.currentThread().getName() + ">>>>restart ServerSocket !");
            }
            try {
                if (this.mServerSocket != null) {
                    this.mServerSocket.close();
                }
                if (this.mSocketThread != null) {
                    this.mSocketThread.setRunningFlag(false);
                }
                this.mServerSocket = new ServerSocket(3000);
                Socket accept = this.mServerSocket.accept();
                this.mSocketRunningFlag = true;
                this.mSocketThread = new IOSocketThread(accept);
                WorkThreadUtil.getInstance().executeCachedTask(this.mSocketThread);
            } catch (IOException unused) {
                if (L.ENABLE) {
                    L.Tag tag2 = TAG;
                    L.d(tag2, Thread.currentThread().getName() + ">>>>restart ServerSocket fail");
                }
                this.mSocketRunningFlag = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class IOSocketThread implements Runnable {
        public Socket mSocket;
        private final L.Tag mTAG = new L.Tag("IOSocketThread");
        @NonNull
        private Location mClientData = new Location("gps");
        private volatile boolean mRunningFlag = true;

        public IOSocketThread(Socket socket) {
            this.mSocket = socket;
        }

        void setRunningFlag(boolean z) {
            if (L.ENABLE) {
                L.d(this.mTAG, ">>>> runningFlag stop !!");
            }
            this.mRunningFlag = z;
        }

        /* JADX WARN: Removed duplicated region for block: B:112:0x01ff A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:114:0x020b A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                Method dump skipped, instructions count: 533
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.navcore.location.SocketLocationService.IOSocketThread.run():void");
        }
    }
}
