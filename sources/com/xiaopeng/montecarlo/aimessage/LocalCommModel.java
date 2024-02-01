package com.xiaopeng.montecarlo.aimessage;

import android.os.Handler;
import androidx.annotation.NonNull;
import com.xiaopeng.libconfig.ipc.bean.MessageCenterBean;
import com.xiaopeng.libconfig.ipc.bean.MessageContentBean;
import com.xiaopeng.montecarlo.aimessage.type.MapAiBtnContent;
import com.xiaopeng.montecarlo.navcore.aimessage.type.AiMsg;
import com.xiaopeng.montecarlo.navcore.event.AiMessageBtnEvent;
import com.xiaopeng.montecarlo.navcore.event.AiMessageEvent;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.GsonUtil;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
import java.util.ArrayList;
import java.util.Arrays;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
/* loaded from: classes.dex */
public class LocalCommModel {
    private static final L.Tag TAG = new L.Tag("LocalCommModel");
    private static LocalCommModel sInstance = new LocalCommModel();
    private boolean mIsBindService = false;
    private Handler mMyHandler;
    private LocalAiMsgService mService;

    private LocalCommModel() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static LocalCommModel getInstance() {
        return sInstance;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bind(@NonNull LocalAiMsgService localAiMsgService) {
        if (localAiMsgService == null) {
            throw new IllegalArgumentException("LocalAiMsgService is null");
        }
        L.i(TAG, "LocalCommModel bind");
        if (this.mIsBindService) {
            return;
        }
        this.mIsBindService = true;
        this.mService = localAiMsgService;
        this.mMyHandler = new Handler(WorkThreadUtil.getInstance().getSpeechAndAiThreadLooper());
        EventBus.getDefault().register(this);
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onEvent(final AiMessageEvent aiMessageEvent) {
        this.mMyHandler.post(new Runnable() { // from class: com.xiaopeng.montecarlo.aimessage.LocalCommModel.1
            @Override // java.lang.Runnable
            public void run() {
                AiMsg aiMsg = aiMessageEvent.getAiMsg();
                if (aiMsg == null || LocalCommModel.this.mService == null) {
                    return;
                }
                MessageContentBean.MsgButton[] buttons = aiMsg.getButtons();
                ArrayList arrayList = new ArrayList();
                if (buttons != null) {
                    for (MessageContentBean.MsgButton msgButton : buttons) {
                        String content = msgButton.getContent();
                        MapAiBtnContent mapAiBtnContent = new MapAiBtnContent();
                        mapAiBtnContent.setContent(content);
                        mapAiBtnContent.setTag("LocalCommModel");
                        mapAiBtnContent.setSender(aiMessageEvent.getSender());
                        mapAiBtnContent.setScene(aiMessageEvent.getScene());
                        msgButton.setContent(GsonUtil.toJson(mapAiBtnContent));
                        msgButton.setPack(ContextUtils.getContext().getPackageName());
                        MessageContentBean.MsgButton msgButton2 = new MessageContentBean.MsgButton();
                        msgButton2.setContent(msgButton.getContent());
                        msgButton2.setName(msgButton.getName());
                        msgButton2.setPack(msgButton.getPack());
                        msgButton2.setSpeechResponse(msgButton.isSpeechResponse());
                        msgButton2.setResponseWord(msgButton.getResponseWord());
                        msgButton2.setResponseTTS(msgButton.getResponseTTS());
                        arrayList.add(msgButton2);
                    }
                }
                MessageContentBean messageContentBean = new MessageContentBean();
                messageContentBean.setTitles(Arrays.asList(aiMsg.getTitles()));
                messageContentBean.setButtons(arrayList);
                messageContentBean.setTts(aiMsg.getTts());
                messageContentBean.setType(aiMsg.getType());
                messageContentBean.setPermanent(aiMsg.getPermanent());
                messageContentBean.setTts(aiMsg.getTts());
                MessageCenterBean create = MessageCenterBean.create(2, messageContentBean);
                create.setScene(aiMessageEvent.getScene());
                if (0 != aiMsg.getTs()) {
                    create.setTs(aiMsg.getTs());
                }
                if (0 != aiMsg.getValidStartTs()) {
                    create.setValidStartTs(aiMsg.getValidStartTs());
                }
                if (0 != aiMsg.getValidEndTs()) {
                    messageContentBean.setValidTime(aiMsg.getValidEndTs());
                    create.setValidEndTs(aiMsg.getValidEndTs());
                }
                create.getContentObject().setPosition(aiMsg.getPosition());
                if (create.getContentObject().getPosition() == 2) {
                    create.setRead_state(1);
                }
                LocalCommModel.this.mService.sendToMessageCenter(GsonUtil.toJson(create), false);
            }
        });
    }

    public void onReceive(@NonNull final MapAiBtnContent mapAiBtnContent) {
        this.mMyHandler.post(new Runnable() { // from class: com.xiaopeng.montecarlo.aimessage.LocalCommModel.2
            @Override // java.lang.Runnable
            public void run() {
                String content = mapAiBtnContent.getContent();
                AiMessageBtnEvent aiMessageBtnEvent = new AiMessageBtnEvent();
                aiMessageBtnEvent.setBtnContent(content);
                aiMessageBtnEvent.setSender(mapAiBtnContent.getSender());
                aiMessageBtnEvent.setScene(mapAiBtnContent.getScene());
                EventBus.getDefault().post(aiMessageBtnEvent);
            }
        });
    }
}
