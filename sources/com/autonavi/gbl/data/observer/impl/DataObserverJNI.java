package com.autonavi.gbl.data.observer.impl;

import com.autonavi.gbl.data.model.AutoInitResponseData;
import com.autonavi.gbl.data.model.DataErrorType;
import com.autonavi.gbl.data.model.DataType;
import com.autonavi.gbl.data.model.DownLoadMode;
import com.autonavi.gbl.data.model.HotUpdateFileType;
import com.autonavi.gbl.data.model.LNDSFileRecoverStatus;
import com.autonavi.gbl.data.model.LNDSNearCityInfo;
import com.autonavi.gbl.data.model.LndsNetWorkError;
import com.autonavi.gbl.data.model.LndsSourceDataType;
import com.autonavi.gbl.data.model.MapNum;
import com.autonavi.gbl.data.model.MergedStatusInfo;
import com.autonavi.gbl.data.model.OperationType;
import com.autonavi.gbl.data.model.TaskStatusCode;
import java.math.BigInteger;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class DataObserverJNI {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void swig_jni_init() {
    }

    public static void SwigDirector_IDataInitObserverImpl_onInit(IDataInitObserverImpl iDataInitObserverImpl, @DownLoadMode.DownLoadMode1 int i, @DataType.DataType1 int i2, int i3) {
        iDataInitObserverImpl.onInit(i, i2, i3);
    }

    public static void SwigDirector_IDataListObserverImpl_onRequestDataListCheck(IDataListObserverImpl iDataListObserverImpl, @DownLoadMode.DownLoadMode1 int i, @DataType.DataType1 int i2, int i3) {
        iDataListObserverImpl.onRequestDataListCheck(i, i2, i3);
    }

    public static void SwigDirector_IDownloadObserverImpl_onOperated(IDownloadObserverImpl iDownloadObserverImpl, @DownLoadMode.DownLoadMode1 int i, @DataType.DataType1 int i2, @OperationType.OperationType1 int i3, ArrayList<Integer> arrayList) {
        iDownloadObserverImpl.onOperated(i, i2, i3, arrayList);
    }

    public static void SwigDirector_IDownloadObserverImpl_onDownLoadStatus(IDownloadObserverImpl iDownloadObserverImpl, @DownLoadMode.DownLoadMode1 int i, @DataType.DataType1 int i2, int i3, @TaskStatusCode.TaskStatusCode1 int i4, int i5) {
        iDownloadObserverImpl.onDownLoadStatus(i, i2, i3, i4, i5);
    }

    public static void SwigDirector_IDownloadObserverImpl_onPercent(IDownloadObserverImpl iDownloadObserverImpl, @DownLoadMode.DownLoadMode1 int i, @DataType.DataType1 int i2, int i3, int i4, float f) {
        iDownloadObserverImpl.onPercent(i, i2, i3, i4, f);
    }

    public static void SwigDirector_IErrorDataObserverImpl_onErrorNotify(IErrorDataObserverImpl iErrorDataObserverImpl, @DownLoadMode.DownLoadMode1 int i, @DataType.DataType1 int i2, int i3, @DataErrorType.DataErrorType1 int i4, String str) {
        iErrorDataObserverImpl.onErrorNotify(i, i2, i3, i4, str);
    }

    public static void SwigDirector_IErrorDataObserverImpl_onErrorNotifyH(IErrorDataObserverImpl iErrorDataObserverImpl, @DownLoadMode.DownLoadMode1 int i, @DataType.DataType1 int i2, int i3, @DataErrorType.DataErrorType1 int i4, String str) {
        iErrorDataObserverImpl.onErrorNotifyH(i, i2, i3, i4, str);
    }

    public static void SwigDirector_IErrorDataObserverImpl_onDeleteErrorData(IErrorDataObserverImpl iErrorDataObserverImpl, @DownLoadMode.DownLoadMode1 int i, @DataType.DataType1 int i2, int i3, int i4) {
        iErrorDataObserverImpl.onDeleteErrorData(i, i2, i3, i4);
    }

    public static void SwigDirector_IImageObserverImpl_onDownloadImage(IImageObserverImpl iImageObserverImpl, int i, int i2, String str, @DataType.DataType1 int i3) {
        iImageObserverImpl.onDownloadImage(i, i2, str, i3);
    }

    public static void SwigDirector_IDataDeletionObserverImpl_onBeforeDataDeletion(IDataDeletionObserverImpl iDataDeletionObserverImpl, @DownLoadMode.DownLoadMode1 int i, @DataType.DataType1 int i2, int i3) {
        iDataDeletionObserverImpl.onBeforeDataDeletion(i, i2, i3);
    }

    public static void SwigDirector_IDataDeletionObserverImpl_onAfterDataDeletion(IDataDeletionObserverImpl iDataDeletionObserverImpl, @DownLoadMode.DownLoadMode1 int i, @DataType.DataType1 int i2, int i3) {
        iDataDeletionObserverImpl.onAfterDataDeletion(i, i2, i3);
    }

    public static void SwigDirector_IHotUpdateCheckObserverImpl_onInitNotify(IHotUpdateCheckObserverImpl iHotUpdateCheckObserverImpl, int i, AutoInitResponseData autoInitResponseData) {
        iHotUpdateCheckObserverImpl.onInitNotify(i, autoInitResponseData);
    }

    public static void SwigDirector_IHotUpdateFileObserverImpl_onHotUpdateFile(IHotUpdateFileObserverImpl iHotUpdateFileObserverImpl, @HotUpdateFileType.HotUpdateFileType1 int i, int i2, String str) {
        iHotUpdateFileObserverImpl.onHotUpdateFile(i, i2, str);
    }

    public static void SwigDirector_IMapNumObserverImpl_onRequestMapNum(IMapNumObserverImpl iMapNumObserverImpl, int i, MapNum mapNum) {
        iMapNumObserverImpl.onRequestMapNum(i, mapNum);
    }

    public static boolean SwigDirector_ILNDSNearCityListObserverImpl_onNearCityRequestSuccess(ILNDSNearCityListObserverImpl iLNDSNearCityListObserverImpl, BigInteger bigInteger, ArrayList<LNDSNearCityInfo> arrayList) {
        return iLNDSNearCityListObserverImpl.onNearCityRequestSuccess(bigInteger, arrayList);
    }

    public static boolean SwigDirector_ILNDSNearCityListObserverImpl_onNearCityRequestError(ILNDSNearCityListObserverImpl iLNDSNearCityListObserverImpl, BigInteger bigInteger, @LndsNetWorkError.LndsNetWorkError1 int i) {
        return iLNDSNearCityListObserverImpl.onNearCityRequestError(bigInteger, i);
    }

    public static void SwigDirector_ILNDSDataVersionObserverImpl_onLNDSDataVersion(ILNDSDataVersionObserverImpl iLNDSDataVersionObserverImpl, BigInteger bigInteger, @LndsNetWorkError.LndsNetWorkError1 int i, String str) {
        iLNDSDataVersionObserverImpl.onLNDSDataVersion(bigInteger, i, str);
    }

    public static void SwigDirector_ILNDSGlobalFileUpdateObserverImpl_onGlobalFileUpdate(ILNDSGlobalFileUpdateObserverImpl iLNDSGlobalFileUpdateObserverImpl, BigInteger bigInteger, int i) {
        iLNDSGlobalFileUpdateObserverImpl.onGlobalFileUpdate(bigInteger, i);
    }

    public static void SwigDirector_ILNDSGlobalFileUpdateObserverImpl_onGlobalFileVersion(ILNDSGlobalFileUpdateObserverImpl iLNDSGlobalFileUpdateObserverImpl, BigInteger bigInteger, String str) {
        iLNDSGlobalFileUpdateObserverImpl.onGlobalFileVersion(bigInteger, str);
    }

    public static void SwigDirector_ILNDSGlobalFileUpdateObserverImpl_onTileGlobalFileUpdate(ILNDSGlobalFileUpdateObserverImpl iLNDSGlobalFileUpdateObserverImpl, BigInteger bigInteger, int i) {
        iLNDSGlobalFileUpdateObserverImpl.onTileGlobalFileUpdate(bigInteger, i);
    }

    public static void SwigDirector_ILNDSCityDownloadObserverImpl_onDownloadVersion(ILNDSCityDownloadObserverImpl iLNDSCityDownloadObserverImpl, int i, String str) {
        iLNDSCityDownloadObserverImpl.onDownloadVersion(i, str);
    }

    public static void SwigDirector_ILNDSCityDownloadObserverImpl_onDownloadStatus(ILNDSCityDownloadObserverImpl iLNDSCityDownloadObserverImpl, int i, @TaskStatusCode.TaskStatusCode1 int i2) {
        iLNDSCityDownloadObserverImpl.onDownloadStatus(i, i2);
    }

    public static void SwigDirector_ILNDSCityDownloadObserverImpl_onDownloadError(ILNDSCityDownloadObserverImpl iLNDSCityDownloadObserverImpl, int i, int i2) {
        iLNDSCityDownloadObserverImpl.onDownloadError(i, i2);
    }

    public static void SwigDirector_ILNDSCityDownloadObserverImpl_onDownloadProgress(ILNDSCityDownloadObserverImpl iLNDSCityDownloadObserverImpl, int i, long j, float f) {
        iLNDSCityDownloadObserverImpl.onDownloadProgress(i, j, f);
    }

    public static void SwigDirector_ILNDSCityDownloadObserverImpl_onMergeProgress(ILNDSCityDownloadObserverImpl iLNDSCityDownloadObserverImpl, int i, float f) {
        iLNDSCityDownloadObserverImpl.onMergeProgress(i, f);
    }

    public static void SwigDirector_ILNDSCityDownloadObserverImpl_onFileRecoverStatus(ILNDSCityDownloadObserverImpl iLNDSCityDownloadObserverImpl, @LNDSFileRecoverStatus.LNDSFileRecoverStatus1 int i) {
        iLNDSCityDownloadObserverImpl.onFileRecoverStatus(i);
    }

    public static void SwigDirector_ILndsDataDeleteObserverImpl_beforeDataDelete(ILndsDataDeleteObserverImpl iLndsDataDeleteObserverImpl, int i, @LndsSourceDataType.LndsSourceDataType1 int i2) {
        iLndsDataDeleteObserverImpl.beforeDataDelete(i, i2);
    }

    public static void SwigDirector_ILndsDataDeleteObserverImpl_afterDataDelete(ILndsDataDeleteObserverImpl iLndsDataDeleteObserverImpl, int i, @LndsSourceDataType.LndsSourceDataType1 int i2) {
        iLndsDataDeleteObserverImpl.afterDataDelete(i, i2);
    }

    public static void SwigDirector_IEHPDataObserverImpl_onEHPDataExistedAdcodeList(IEHPDataObserverImpl iEHPDataObserverImpl, @DownLoadMode.DownLoadMode1 int i, ArrayList<Integer> arrayList, ArrayList<Integer> arrayList2) {
        iEHPDataObserverImpl.onEHPDataExistedAdcodeList(i, arrayList, arrayList2);
    }

    public static void SwigDirector_IMergedStatusInfoObserverImpl_onMergedStatusInfo(IMergedStatusInfoObserverImpl iMergedStatusInfoObserverImpl, MergedStatusInfo mergedStatusInfo) {
        iMergedStatusInfoObserverImpl.onMergedStatusInfo(mergedStatusInfo);
    }
}
