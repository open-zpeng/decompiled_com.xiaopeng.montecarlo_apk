package com.autonavi.gbl.data.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.data.VoiceService;
import com.autonavi.gbl.data.model.DownLoadMode;
import com.autonavi.gbl.data.model.OperationType;
import com.autonavi.gbl.data.model.Voice;
import com.autonavi.gbl.data.model.VoiceEngineType;
import com.autonavi.gbl.data.model.VoiceInitConfig;
import com.autonavi.gbl.data.observer.impl.IDataInitObserverImpl;
import com.autonavi.gbl.data.observer.impl.IDataListObserverImpl;
import com.autonavi.gbl.data.observer.impl.IDownloadObserverImpl;
import com.autonavi.gbl.data.observer.impl.IImageObserverImpl;
import com.autonavi.gbl.servicemanager.IService;
import com.autonavi.gbl.util.model.ServiceInitStatus;
import java.util.ArrayList;
@IntfAuto(target = VoiceService.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class IVoiceServiceImpl implements IService {
    private static BindTable BIND_TABLE = new BindTable(IVoiceServiceImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native int abortRequestDataImageNative(long j, IVoiceServiceImpl iVoiceServiceImpl, int i, int i2);

    private static native int abortRequestDataListCheckNative(long j, IVoiceServiceImpl iVoiceServiceImpl, int i);

    private static native int addNetDownloadObserverNative(long j, IVoiceServiceImpl iVoiceServiceImpl, long j2, IDownloadObserverImpl iDownloadObserverImpl);

    private static native int addUsbDownloadObserverNative(long j, IVoiceServiceImpl iVoiceServiceImpl, long j2, IDownloadObserverImpl iDownloadObserverImpl);

    private static native void changeDiskStatusNative(long j, IVoiceServiceImpl iVoiceServiceImpl, String str, int i);

    private static native int checkDataInDiskNative(long j, IVoiceServiceImpl iVoiceServiceImpl, int i, String str);

    private static native void destroyNativeObj(long j);

    private static native String getVersionNative(long j, IVoiceServiceImpl iVoiceServiceImpl);

    private static native int getVoiceIdList1Native(long j, IVoiceServiceImpl iVoiceServiceImpl, int i, int i2, ArrayList<Integer> arrayList);

    private static native int getVoiceIdListNative(long j, IVoiceServiceImpl iVoiceServiceImpl, int i, ArrayList<Integer> arrayList);

    private static native int getVoiceNative(long j, IVoiceServiceImpl iVoiceServiceImpl, int i, int i2, long j2, Voice voice);

    private static native int initNative(long j, IVoiceServiceImpl iVoiceServiceImpl, long j2, VoiceInitConfig voiceInitConfig, long j3, IDataInitObserverImpl iDataInitObserverImpl);

    private static native int isInitNative(long j, IVoiceServiceImpl iVoiceServiceImpl);

    private static native int operateNative(long j, IVoiceServiceImpl iVoiceServiceImpl, int i, int i2, ArrayList<Integer> arrayList);

    private static native int operateWorkingQueueNative(long j, IVoiceServiceImpl iVoiceServiceImpl, int i, int i2, int i3);

    private static native int removeDownloadObserverNative(long j, IVoiceServiceImpl iVoiceServiceImpl, int i, long j2, IDownloadObserverImpl iDownloadObserverImpl);

    private static native int removeNetDownloadObserverNative(long j, IVoiceServiceImpl iVoiceServiceImpl, long j2, IDownloadObserverImpl iDownloadObserverImpl);

    private static native int removeUsbDownloadObserverNative(long j, IVoiceServiceImpl iVoiceServiceImpl, long j2, IDownloadObserverImpl iDownloadObserverImpl);

    private static native int requestDataImageNative(long j, IVoiceServiceImpl iVoiceServiceImpl, int i, int i2, long j2, IImageObserverImpl iImageObserverImpl);

    private static native int requestDataListCheckNative(long j, IVoiceServiceImpl iVoiceServiceImpl, int i, String str, long j2, IDataListObserverImpl iDataListObserverImpl);

    private static native void unInitNative(long j, IVoiceServiceImpl iVoiceServiceImpl);

    private static native boolean updateVersionNative(long j, IVoiceServiceImpl iVoiceServiceImpl, String str, String str2);

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onCreate() {
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public void onDestroy() {
    }

    protected IVoiceServiceImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IVoiceServiceImpl) && getUID(this) == getUID((IVoiceServiceImpl) obj);
    }

    private static long getUID(IVoiceServiceImpl iVoiceServiceImpl) {
        long cPtr = getCPtr(iVoiceServiceImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IVoiceServiceImpl iVoiceServiceImpl) {
        if (iVoiceServiceImpl == null) {
            return 0L;
        }
        return iVoiceServiceImpl.swigCPtr;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public boolean isRecycled() {
        return this.swigCPtr == 0;
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    public long getPtr() {
        return this.swigCPtr;
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                destroyNativeObj(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public int init(VoiceInitConfig voiceInitConfig, IDataInitObserverImpl iDataInitObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return initNative(j, this, 0L, voiceInitConfig, IDataInitObserverImpl.getCPtr(iDataInitObserverImpl), iDataInitObserverImpl);
    }

    @Override // com.autonavi.gbl.servicemanager.IService
    @ServiceInitStatus.ServiceInitStatus1
    public int isInit() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return isInitNative(j, this);
    }

    public void unInit() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        unInitNative(j, this);
    }

    public String getVersion() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getVersionNative(j, this);
    }

    public int requestDataListCheck(@DownLoadMode.DownLoadMode1 int i, String str, IDataListObserverImpl iDataListObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return requestDataListCheckNative(j, this, i, str, IDataListObserverImpl.getCPtr(iDataListObserverImpl), iDataListObserverImpl);
    }

    public int abortRequestDataListCheck(@DownLoadMode.DownLoadMode1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return abortRequestDataListCheckNative(j, this, i);
    }

    public void changeDiskStatus(String str, int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        changeDiskStatusNative(j, this, str, i);
    }

    public int checkDataInDisk(@DownLoadMode.DownLoadMode1 int i, String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return checkDataInDiskNative(j, this, i, str);
    }

    public Voice getVoice(@DownLoadMode.DownLoadMode1 int i, int i2) {
        Voice voice = new Voice();
        if (Integer.valueOf(getVoice(i, i2, voice)).intValue() == 0) {
            return voice;
        }
        return null;
    }

    private int getVoice(@DownLoadMode.DownLoadMode1 int i, int i2, Voice voice) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getVoiceNative(j, this, i, i2, 0L, voice);
    }

    public ArrayList<Integer> getVoiceIdList(@DownLoadMode.DownLoadMode1 int i) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (Integer.valueOf(getVoiceIdList(i, arrayList)).intValue() == 0) {
            return arrayList;
        }
        return null;
    }

    private int getVoiceIdList(@DownLoadMode.DownLoadMode1 int i, ArrayList<Integer> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getVoiceIdListNative(j, this, i, arrayList);
    }

    public ArrayList<Integer> getVoiceIdList(@DownLoadMode.DownLoadMode1 int i, @VoiceEngineType.VoiceEngineType1 int i2) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (Integer.valueOf(getVoiceIdList(i, i2, arrayList)).intValue() == 0) {
            return arrayList;
        }
        return null;
    }

    private int getVoiceIdList(@DownLoadMode.DownLoadMode1 int i, @VoiceEngineType.VoiceEngineType1 int i2, ArrayList<Integer> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getVoiceIdList1Native(j, this, i, i2, arrayList);
    }

    public boolean updateVersion(String str, String str2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return updateVersionNative(j, this, str, str2);
    }

    public int addNetDownloadObserver(IDownloadObserverImpl iDownloadObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return addNetDownloadObserverNative(j, this, IDownloadObserverImpl.getCPtr(iDownloadObserverImpl), iDownloadObserverImpl);
    }

    public int addUsbDownloadObserver(IDownloadObserverImpl iDownloadObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return addUsbDownloadObserverNative(j, this, IDownloadObserverImpl.getCPtr(iDownloadObserverImpl), iDownloadObserverImpl);
    }

    public int removeDownloadObserver(@DownLoadMode.DownLoadMode1 int i, IDownloadObserverImpl iDownloadObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return removeDownloadObserverNative(j, this, i, IDownloadObserverImpl.getCPtr(iDownloadObserverImpl), iDownloadObserverImpl);
    }

    public int removeNetDownloadObserver(IDownloadObserverImpl iDownloadObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return removeNetDownloadObserverNative(j, this, IDownloadObserverImpl.getCPtr(iDownloadObserverImpl), iDownloadObserverImpl);
    }

    public int removeUsbDownloadObserver(IDownloadObserverImpl iDownloadObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return removeUsbDownloadObserverNative(j, this, IDownloadObserverImpl.getCPtr(iDownloadObserverImpl), iDownloadObserverImpl);
    }

    public int operate(@DownLoadMode.DownLoadMode1 int i, @OperationType.OperationType1 int i2, ArrayList<Integer> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return operateNative(j, this, i, i2, arrayList);
    }

    public int operateWorkingQueue(@DownLoadMode.DownLoadMode1 int i, @OperationType.OperationType1 int i2, @VoiceEngineType.VoiceEngineType1 int i3) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return operateWorkingQueueNative(j, this, i, i2, i3);
    }

    public int requestDataImage(@DownLoadMode.DownLoadMode1 int i, int i2, IImageObserverImpl iImageObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return requestDataImageNative(j, this, i, i2, IImageObserverImpl.getCPtr(iImageObserverImpl), iImageObserverImpl);
    }

    public int abortRequestDataImage(@DownLoadMode.DownLoadMode1 int i, int i2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return abortRequestDataImageNative(j, this, i, i2);
    }
}
