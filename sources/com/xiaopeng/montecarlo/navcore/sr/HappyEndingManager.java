package com.xiaopeng.montecarlo.navcore.sr;

import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.xiaopeng.lib.apirouter.ApiRouter;
import com.xiaopeng.lib.framework.ipcmodule.IpcModuleEntry;
import com.xiaopeng.lib.framework.module.Module;
import com.xiaopeng.lib.framework.moduleinterface.ipcmodule.IIpcService;
import com.xiaopeng.libconfig.ipc.IpcConfig;
import com.xiaopeng.libconfig.ipc.bean.MessageCenterBean;
import com.xiaopeng.libconfig.ipc.bean.MessageContentBean;
import com.xiaopeng.montecarlo.navcore.R;
import com.xiaopeng.montecarlo.navcore.apirouter.IpcRouterUtil;
import com.xiaopeng.montecarlo.navcore.event.AiMessageEvent;
import com.xiaopeng.montecarlo.navcore.search.param.CPSearchParam;
import com.xiaopeng.montecarlo.navcore.sr.data.HappyEnding;
import com.xiaopeng.montecarlo.navcore.xptbt.bean.AiMsgConfirmBean;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPNaviInfo;
import com.xiaopeng.montecarlo.root.carfeature.CarFeatureManager;
import com.xiaopeng.montecarlo.root.provider.dataset.DataSetHelper;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.GsonUtil;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
/* loaded from: classes3.dex */
public class HappyEndingManager {
    private static final int MIN_C_NGP_TOTAL_MILEAGE = 1000;
    private static final L.Tag TAG = new L.Tag("HappyEndingManager");
    private static final String XPU_AUTHORITY = "com.xiaopeng.xpuservice.NgpSrObserver";
    private static final String XPU_PATH_DETAIL = "naviGetItineraryCount";
    private static final String XPU_PATH_RESET = "resetItinerary";
    private static final String XPU_QUERY_TIME = "time";
    private IHappyEnding mIHappyEnding;
    private XPNaviInfo mLastNaviInfo;
    private boolean mInCityNGP = false;
    private double mCurrentCNGPTotalMileage = DataSetHelper.GlobalSet.getDouble(DataSetHelper.GlobalSet.CACHE_C_NGP_TOTAL_MILEAGE, 0.0d);

    public HappyEndingManager() {
        if (RootUtil.compareDouble(this.mCurrentCNGPTotalMileage, 0.0d)) {
            WorkThreadUtil.getInstance().executeCachedTask(new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.sr.-$$Lambda$HappyEndingManager$UrMjcHphLl3g-mrr71eu6b0rmn0
                @Override // java.lang.Runnable
                public final void run() {
                    HappyEndingManager.this.reset();
                }
            });
        }
    }

    public void setCurrentCNGPTotalMileage(int i) {
        L.Tag tag = TAG;
        L.i(tag, "setCurrentCNGPTotalMileage currentCNGPTotalMileage : " + i);
        this.mCurrentCNGPTotalMileage = (double) i;
    }

    public void setIHappyEnding(IHappyEnding iHappyEnding) {
        this.mIHappyEnding = iHappyEnding;
    }

    public void showHappyEnding(HappyEnding happyEnding) {
        L.Tag tag = TAG;
        L.i(tag, "showHappyEnding happyEnding : " + happyEnding);
        IHappyEnding iHappyEnding = this.mIHappyEnding;
        if (iHappyEnding == null || happyEnding == null) {
            return;
        }
        iHappyEnding.onShow(happyEnding);
    }

    public void saveCurrentCNGPTotalMileage() {
        L.Tag tag = TAG;
        L.i(tag, "saveCurrentCNGPTotalMileage mCurrentCNGPTotalMileage : " + this.mCurrentCNGPTotalMileage);
        DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.CACHE_C_NGP_TOTAL_MILEAGE, this.mCurrentCNGPTotalMileage);
        this.mCurrentCNGPTotalMileage = 0.0d;
        this.mLastNaviInfo = null;
    }

    public void restoreCurrentCNGPTotalMileage() {
        this.mCurrentCNGPTotalMileage = DataSetHelper.GlobalSet.getDouble(DataSetHelper.GlobalSet.CACHE_C_NGP_TOTAL_MILEAGE, 0.0d);
        L.Tag tag = TAG;
        L.i(tag, "restoreCurrentCNGPTotalMileage mCurrentCNGPTotalMileage : " + this.mCurrentCNGPTotalMileage);
    }

    public void onNaviStop() {
        L.Tag tag = TAG;
        L.i(tag, "onNaviStop mCurrentCNGPTotalMileage : " + this.mCurrentCNGPTotalMileage);
        if (RootUtil.compareDouble(this.mCurrentCNGPTotalMileage, 0.0d)) {
            return;
        }
        WorkThreadUtil.getInstance().executeCachedTask(new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.sr.-$$Lambda$HappyEndingManager$Zbr2-RKa4hpbJGPFxs3zeIxvoks
            @Override // java.lang.Runnable
            public final void run() {
                HappyEndingManager.this.lambda$onNaviStop$0$HappyEndingManager();
            }
        });
    }

    public /* synthetic */ void lambda$onNaviStop$0$HappyEndingManager() {
        HappyEnding happyEnding;
        String detail = detail();
        L.Tag tag = TAG;
        L.i(tag, "pushCityNGPInfo detail = " + detail);
        if (!TextUtils.isEmpty(detail) && (happyEnding = (HappyEnding) GsonUtil.fromJson(detail, (Class<Object>) HappyEnding.class)) != null) {
            happyEnding.setTotalMileage(this.mCurrentCNGPTotalMileage);
            happyEnding.setTime(System.currentTimeMillis());
            pushAiMsg(happyEnding);
        }
        reset();
    }

    public void updateNaviInfo(XPNaviInfo xPNaviInfo) {
        XPNaviInfo xPNaviInfo2;
        if (xPNaviInfo != null) {
            if (L.ENABLE) {
                L.d(TAG, "updateNaviInfo mInCityNGP : " + this.mInCityNGP + " , mCurrentCNGPTotalMileage : " + this.mCurrentCNGPTotalMileage);
            }
            if (this.mInCityNGP && (xPNaviInfo2 = this.mLastNaviInfo) != null && xPNaviInfo2.mPathID == xPNaviInfo.mPathID) {
                this.mCurrentCNGPTotalMileage += this.mLastNaviInfo.mRouteRemainDist - xPNaviInfo.mRouteRemainDist;
            }
            this.mLastNaviInfo = xPNaviInfo;
        }
    }

    public void setInCityNGP(boolean z) {
        if (this.mInCityNGP != z) {
            L.Tag tag = TAG;
            L.i(tag, "setInCityNGP inCityNGP : " + z);
            this.mLastNaviInfo = null;
            this.mInCityNGP = z;
        }
    }

    public void pushAiMsg(@NonNull HappyEnding happyEnding) {
        L.Tag tag = TAG;
        L.i(tag, "pushAiMsg happyEnding : " + happyEnding);
        if (happyEnding.getTotalMileage() > 1000.0d || RootUtil.compareDouble(happyEnding.getTotalMileage(), 1000.0d)) {
            MessageContentBean createContent = MessageContentBean.createContent();
            createContent.setType(1);
            createContent.addTitle(ContextUtils.getString(R.string.ai_message_happy_ending_title));
            createContent.addTitle(ContextUtils.getString(R.string.ai_message_happy_ending_sub_title));
            createContent.setTts("~");
            createContent.setPermanent(1);
            AiMsgConfirmBean aiMsgConfirmBean = new AiMsgConfirmBean();
            aiMsgConfirmBean.setType(1);
            aiMsgConfirmBean.setStatus(true);
            aiMsgConfirmBean.setExtra(GsonUtil.toJson(happyEnding));
            createContent.addButton(MessageContentBean.MsgButton.create(ContextUtils.getString(R.string.ai_message_happy_ending_detail), ContextUtils.getContext().getPackageName(), GsonUtil.toJson(aiMsgConfirmBean)));
            MessageCenterBean create = MessageCenterBean.create(2, createContent);
            long currentTimeMillis = System.currentTimeMillis() + 1296000000;
            create.setValidEndTs(currentTimeMillis);
            create.getContentBean().setValidTime(currentTimeMillis);
            create.setScene(AiMessageEvent.SCENE_HAPPY_ENDING);
            create.getContentObject().setPosition(1);
            create.setRead_state(1);
            Bundle bundle = new Bundle();
            bundle.putString(IpcConfig.IPCKey.STRING_MSG, GsonUtil.toJson(create));
            if (CarFeatureManager.INSTANCE.isIpcExchange2Apirouter()) {
                IpcRouterUtil.sendData(10009, bundle, "com.xiaopeng.aiassistant");
            } else {
                ((IIpcService) Module.get(IpcModuleEntry.class).get(IIpcService.class)).sendData(10009, bundle, IpcConfig.App.MESSAGE_CENTER);
            }
            L.Tag tag2 = TAG;
            L.i(tag2, "Ai message sent, mAiMessageId: " + create.getMessageId() + "scene id:" + create.getScene());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        long uptimeMillis = SystemClock.uptimeMillis();
        L.Tag tag = TAG;
        L.i(tag, "reset time : " + uptimeMillis);
        Uri.Builder builder = new Uri.Builder();
        builder.authority(XPU_AUTHORITY).path(XPU_PATH_RESET).appendQueryParameter("time", String.valueOf(uptimeMillis));
        try {
            this.mCurrentCNGPTotalMileage = 0.0d;
            this.mLastNaviInfo = null;
            DataSetHelper.GlobalSet.set(DataSetHelper.GlobalSet.CACHE_C_NGP_TOTAL_MILEAGE, 0.0f);
            L.Tag tag2 = TAG;
            L.i(tag2, "reset result = " + ((String) ApiRouter.route(builder.build())));
        } catch (Exception e) {
            L.Tag tag3 = TAG;
            L.e(tag3, "reset" + e);
        }
    }

    private String detail() {
        long uptimeMillis = SystemClock.uptimeMillis();
        L.Tag tag = TAG;
        L.i(tag, "detail time : " + uptimeMillis);
        Uri.Builder builder = new Uri.Builder();
        builder.authority(XPU_AUTHORITY).path(XPU_PATH_DETAIL).appendQueryParameter("time", String.valueOf(uptimeMillis));
        try {
            return (String) ApiRouter.route(builder.build());
        } catch (Exception e) {
            L.Tag tag2 = TAG;
            L.e(tag2, CPSearchParam.PARAM_KEY_DETAIL + e);
            return null;
        }
    }
}
