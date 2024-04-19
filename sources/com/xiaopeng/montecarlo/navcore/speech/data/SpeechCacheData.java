package com.xiaopeng.montecarlo.navcore.speech.data;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.xiaopeng.montecarlo.navcore.bean.sync.FavoriteType;
import com.xiaopeng.montecarlo.navcore.httpclient.HttpClientManager;
import com.xiaopeng.montecarlo.navcore.httpclient.interfaces.IAssistantLocationService;
import com.xiaopeng.montecarlo.navcore.httpclient.requests.AssistantLocationFeedbackRequest;
import com.xiaopeng.montecarlo.root.httpclient.core.ResponseWrapper;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
import com.xiaopeng.speech.protocol.node.navi.bean.AddressBean;
import com.xiaopeng.speech.protocol.node.navi.bean.PoiBean;
/* loaded from: classes3.dex */
public class SpeechCacheData {
    private static final L.Tag TAG = new L.Tag("SpeechCacheData");
    @NonNull
    private static SpeechCacheData sInstance = new SpeechCacheData();
    private IAssistantLocationService mAssistantLocationService = (IAssistantLocationService) HttpClientManager.getInstance().getService(IAssistantLocationService.class);
    @Nullable
    public PoiBean mHomeFromBigData = null;
    @Nullable
    public PoiBean mCompanyFromBigData = null;

    @NonNull
    public static SpeechCacheData getInstance() {
        return sInstance;
    }

    @Nullable
    public PoiBean getHomeFromBigData() {
        L.Tag tag = TAG;
        L.i(tag, "getHomeFromBigData, mHomeFromBigData is " + this.mHomeFromBigData);
        return this.mHomeFromBigData;
    }

    public void setHomeFromBigData(PoiBean poiBean) {
        this.mHomeFromBigData = poiBean;
    }

    @Nullable
    public PoiBean getCompanyFromBigData() {
        L.Tag tag = TAG;
        L.i(tag, "getCompanyFromBigData, mCompanyFromBigData is " + this.mCompanyFromBigData);
        return this.mCompanyFromBigData;
    }

    public void setCompanyFromBigData(PoiBean poiBean) {
        this.mCompanyFromBigData = poiBean;
    }

    public void feedbackToCloud(String str) {
        String poiId;
        String str2;
        if (AddressBean.ADDRESS_TYPE_HOME.equals(str)) {
            PoiBean poiBean = this.mHomeFromBigData;
            if (poiBean != null) {
                poiId = poiBean.getPoiId();
                str2 = "home";
            }
            poiId = null;
            str2 = null;
        } else if (!AddressBean.ADDRESS_TYPE_COMPANY.equals(str)) {
            return;
        } else {
            PoiBean poiBean2 = this.mCompanyFromBigData;
            if (poiBean2 != null) {
                poiId = poiBean2.getPoiId();
                str2 = FavoriteType.COMPANY_STRING;
            }
            poiId = null;
            str2 = null;
        }
        if (poiId == null || str2 == null) {
            return;
        }
        feedbackToCloud(str2, poiId);
        if (AddressBean.ADDRESS_TYPE_HOME.equals(str)) {
            this.mHomeFromBigData = null;
        }
        if (AddressBean.ADDRESS_TYPE_COMPANY.equals(str)) {
            this.mCompanyFromBigData = null;
        }
    }

    private void feedbackToCloud(final String str, final String str2) {
        WorkThreadUtil.getInstance().executeCachedTask(new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.speech.data.-$$Lambda$SpeechCacheData$sRT4d6My3D5Qp-aco3gGzQWIXdg
            @Override // java.lang.Runnable
            public final void run() {
                SpeechCacheData.this.lambda$feedbackToCloud$0$SpeechCacheData(str2, str);
            }
        });
    }

    public /* synthetic */ void lambda$feedbackToCloud$0$SpeechCacheData(String str, String str2) {
        ResponseWrapper feedback = this.mAssistantLocationService.feedback(new AssistantLocationFeedbackRequest().setPoiId(str).setUserId(0L).setKind(str2).setVin(RootUtil.getVin()).setTs(Long.valueOf(System.currentTimeMillis())));
        if (feedback.getCode() == 200) {
            L.i(TAG, "feedbackToCloud onSuccess");
            return;
        }
        L.Tag tag = TAG;
        L.i(tag, "feedbackToCloud onFailure code=" + feedback.getCode());
    }
}
