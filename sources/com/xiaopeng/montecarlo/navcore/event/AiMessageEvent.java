package com.xiaopeng.montecarlo.navcore.event;

import com.xiaopeng.montecarlo.navcore.aimessage.type.AiMsg;
/* loaded from: classes2.dex */
public final class AiMessageEvent {
    public static final int BIZ_TYPE = 2;
    public static final int SCENE_ACC_MSG_ACC_ENTER_TOLL_GATE_WARNING = 2511;
    public static final int SCENE_ACC_MSG_CLOSE = 2506;
    public static final int SCENE_ACC_MSG_EXIT_CONTROL_ACCESS_ROAD_WARNING = 2510;
    public static final int SCENE_ACC_MSG_OPENED_AFTER_SUGGEST = 2505;
    public static final int SCENE_ACC_MSG_OPENED_WARNING = 2509;
    public static final int SCENE_ACC_MSG_SUGGEST_OPEN = 2507;
    public static final int SCENE_ACC_MSG_TO_CLOSE = 2508;
    public static final int SCENE_BL_SENDTOCAR = 2504;
    public static final int SCENE_BL_SENDTOCAR_ROUTE = 2513;
    public static final int SCENE_DEFAULT = 2999;
    public static final int SCENE_HAPPY_ENDING = 2514;
    public static final int SCENE_RECOMMEND_PARK = 2503;
    public static final int SCENE_SELECT_ROUTE = 2502;
    public static final int SCENE_SWITCH_ROUTE_FORCE = 2512;
    public static final int SCENE_SWITCH_ROUTE_SUGGEST = 2501;
    public static final int SENDER_ACC_MODULE = 101;
    public static final int SENDER_BLMSG_PUSH = 100;
    private AiMsg mAiMsg;
    private int mSender = 0;
    private int mScene = SCENE_DEFAULT;

    public int getScene() {
        return this.mScene;
    }

    public void setScene(int i) {
        this.mScene = i;
    }

    public int getSender() {
        return this.mSender;
    }

    public void setSender(int i) {
        this.mSender = i;
    }

    public AiMsg getAiMsg() {
        return this.mAiMsg;
    }

    public void setAiMsg(AiMsg aiMsg) {
        this.mAiMsg = aiMsg;
    }
}
