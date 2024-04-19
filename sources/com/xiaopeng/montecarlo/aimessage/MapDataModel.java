package com.xiaopeng.montecarlo.aimessage;

import androidx.annotation.NonNull;
import com.xiaopeng.libconfig.ipc.IpcConfig;
import com.xiaopeng.montecarlo.aimessage.AiMsgManager;
import com.xiaopeng.montecarlo.aimessage.type.CommMsg;
import com.xiaopeng.montecarlo.navcore.download.IMapDataOperator;
import com.xiaopeng.montecarlo.navcore.download.MapDataManager;
import com.xiaopeng.montecarlo.navcore.download.dataoperator.MapDataContent;
import com.xiaopeng.montecarlo.root.util.GsonUtil;
import com.xiaopeng.montecarlo.root.util.L;
/* loaded from: classes2.dex */
public class MapDataModel {
    public static final int SCENE_MAP_DATA_OPERATE = 2701;
    private static final L.Tag TAG = new L.Tag("tMapDataModel");
    AiMsgManager.MsgListener mMsgListener = new AiMsgManager.MsgListener() { // from class: com.xiaopeng.montecarlo.aimessage.MapDataModel.1
        @Override // com.xiaopeng.montecarlo.aimessage.AiMsgManager.MsgListener
        public String getName() {
            return "MapDataModel";
        }

        @Override // com.xiaopeng.montecarlo.aimessage.AiMsgManager.MsgListener
        public void onReceive(@NonNull AiMsgManager.IpcMessage ipcMessage) {
            IMapDataOperator mapDataOperator;
            L.Tag tag = MapDataModel.TAG;
            L.i(tag, "onReceive  111   message=" + ipcMessage);
            if (IpcConfig.App.DEVICE_COMMUNICATION.equals(ipcMessage.getSenderPackageName()) && 10010 == ipcMessage.mMsgID) {
                try {
                    L.Tag tag2 = MapDataModel.TAG;
                    L.i(tag2, "onReceive message 222  getMsg()=" + ipcMessage.getMsg());
                    CommMsg commMsg = (CommMsg) GsonUtil.fromJson(ipcMessage.getMsg(), (Class<Object>) CommMsg.class);
                    L.Tag tag3 = MapDataModel.TAG;
                    L.i(tag3, "onReceive message 333  fromJson =" + commMsg);
                    if (commMsg == null || commMsg.getScene() != 2701) {
                        return;
                    }
                    L.Tag tag4 = MapDataModel.TAG;
                    L.i(tag4, "onReceive message 444  content =" + commMsg.getContent());
                    MapDataContent mapDataContent = (MapDataContent) GsonUtil.fromJson(commMsg.getContent(), (Class<Object>) MapDataContent.class);
                    if (mapDataContent == null || (mapDataOperator = MapDataManager.getInstance().getMapDataOperator()) == null) {
                        return;
                    }
                    mapDataOperator.handlePushMessage(mapDataContent);
                } catch (Exception e) {
                    e.printStackTrace();
                    L.e(MapDataModel.TAG, L.printStackTrace(MapDataModel.TAG, e));
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bind(@NonNull LocalAiMsgService localAiMsgService) {
        localAiMsgService.register(this.mMsgListener);
    }
}
