package com.xiaopeng.montecarlo.scenes.navi.dataprovider;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPCrossImageInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPObtainInfo;
import com.xiaopeng.montecarlo.root.dataprovider.BaseCallBack;
import com.xiaopeng.montecarlo.root.dataprovider.BaseDataProvider;
import com.xiaopeng.montecarlo.root.dataprovider.DataProviderException;
import com.xiaopeng.montecarlo.root.dataprovider.DataProviderResponse;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.util.NaviUtil;
/* loaded from: classes3.dex */
public class NaviDataProvider extends BaseDataProvider<NaviReturnData, NaviRequestParam, BaseCallBack> {
    private static final L.Tag TAG = new L.Tag("NaviDataProvider");

    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseDataProvider
    protected String getErrorMessage(int i) {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.root.dataprovider.BaseDataProvider
    public DataProviderResponse fetchDataDelegate(NaviRequestParam naviRequestParam) throws DataProviderException {
        int naviRequestType = naviRequestParam.getNaviRequestType();
        if (naviRequestType != 0) {
            if (naviRequestType != 1) {
                return null;
            }
            return fetchCrossIcon(naviRequestParam);
        }
        return fetchTurnIcon(naviRequestParam);
    }

    private DataProviderResponse fetchCrossIcon(NaviRequestParam naviRequestParam) throws DataProviderException {
        Bitmap bitmap;
        if (L.ENABLE) {
            L.d(TAG, "fetchCrossIcon");
        }
        if (naviRequestParam == null) {
            throw new DataProviderException("param is null");
        }
        XPCrossImageInfo crossImageInfo = naviRequestParam.getCrossImageInfo();
        if (crossImageInfo == null || crossImageInfo.mDataBuf == null || crossImageInfo.mDataBuf.length <= 0) {
            bitmap = null;
        } else {
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(crossImageInfo.mDataBuf, 0, crossImageInfo.mDataBuf.length);
            Bitmap decodeByteArray2 = BitmapFactory.decodeByteArray(crossImageInfo.mArrowDataBuf, 0, crossImageInfo.mArrowDataBuf.length);
            int i = ContextUtils.getInt(R.integer.navi_corss_img_radius);
            bitmap = NaviUtil.eraseArrayBackground(decodeByteArray2, decodeByteArray, i, i, naviRequestParam.getRadianType());
            if (decodeByteArray != null && !decodeByteArray.isRecycled()) {
                decodeByteArray.recycle();
            }
            if (decodeByteArray2 != null && !decodeByteArray2.isRecycled()) {
                decodeByteArray2.recycle();
            }
        }
        NaviReturnData naviReturnData = new NaviReturnData();
        naviReturnData.setCrossIcon(bitmap);
        naviReturnData.setCrossImageInfo(crossImageInfo);
        naviReturnData.setRequestType(1);
        DataProviderResponse dataProviderResponse = new DataProviderResponse();
        dataProviderResponse.setResultData(naviReturnData);
        return dataProviderResponse;
    }

    private DataProviderResponse fetchTurnIcon(NaviRequestParam naviRequestParam) throws DataProviderException {
        if (L.ENABLE) {
            L.d(TAG, "fetchTurnIcon");
        }
        if (naviRequestParam == null) {
            throw new DataProviderException("param is null");
        }
        Bitmap bitmap = null;
        XPObtainInfo obtainInfo = naviRequestParam.getObtainInfo();
        if (obtainInfo != null && obtainInfo.mData != null) {
            bitmap = BitmapFactory.decodeByteArray(obtainInfo.mData, 0, obtainInfo.mData.length);
        }
        NaviReturnData naviReturnData = new NaviReturnData();
        naviReturnData.setTurnIcon(bitmap);
        naviReturnData.setRequestType(0);
        DataProviderResponse dataProviderResponse = new DataProviderResponse();
        dataProviderResponse.setResultData(naviReturnData);
        return dataProviderResponse;
    }

    public void fetchIcon(NaviRequestParam naviRequestParam, BaseCallBack<NaviRequestParam, NaviReturnData> baseCallBack) {
        doFetchData(naviRequestParam, baseCallBack);
    }
}
