package com.xiaopeng.montecarlo.speech.command.setting;

import com.xiaopeng.montecarlo.navcore.speech.stat.SpeechStatProxy;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand;
import com.xiaopeng.montecarlo.speech.command.CommandPriority;
import com.xiaopeng.montecarlo.speech.command.navi.lane.ExitSrOrLaneModeCommand;
import com.xiaopeng.montecarlo.speech.utils.SpeechSettingUtil;
import com.xiaopeng.montecarlo.util.SRUtil;
import com.xiaopeng.speech.protocol.SpeechUtils;
import java.util.ArrayList;
import java.util.List;
@CommandPriority(priority = 40)
/* loaded from: classes3.dex */
public class ModifySettingCommand extends BaseSpeechCommand {
    private static final L.Tag TAG = new L.Tag("ModifySettingCommand");
    private SettingParam mParam;

    /* loaded from: classes3.dex */
    public enum SettingParam {
        AVOID_CHARGE,
        AVOID_CHARGE_OFF,
        AVOID_CONGESTION,
        AVOID_CONGESTION_CLOSE,
        AVOID_HIGHWAY,
        AVOID_HIGHWAY_CLOSE,
        HIGHWAY_FIRST,
        HIGHWAY_FIRST_CLOSE,
        CLOSE_CHARGE,
        OPEN_CHARGE,
        CLOSE_TRAFFIC,
        OPEN_TRAFFIC,
        DETAIL_BROADCAST,
        SIMPLE_BROADCAST,
        AVOID_CONTROLS_ON,
        AVOID_CONTROLS_OFF,
        RADAR_ROUTE_ON,
        RADAR_ROUTE_OFF,
        CONTROL_SPEECH_SUPER_SIMPLE,
        CONTROL_SPEECH_GENERAL,
        SPEECH_EYE_ON,
        SPEECH_EYE_OFF,
        SMART_SCALE_ON,
        SMART_SCALE_OFF,
        RECOMMEND_PARK_ON,
        RECOMMEND_PARK_OFF,
        SECURITY_REMIND_ON,
        SECURITY_REMIND_OFF,
        ROAD_AHEAD_ON,
        ROAD_AHEAD_OFF,
        SMALL_MAP_OPEN,
        SMALL_MAP_CLOSE,
        RIBBON_MAP_OPEN,
        RIBBON_MAP_CLOSE,
        SCRATCH_SPOT_BROADCAST_OPEN,
        SCRATCH_SPOT_BROADCAST_CLOSE
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandFunction
    public <T extends BaseSpeechCommand> boolean canMergeCommand(T t) {
        return false;
    }

    public ModifySettingCommand(SettingParam settingParam) {
        this.mParam = settingParam;
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public void doSomething() {
        L.Tag tag = TAG;
        L.i(tag, "doSomething mParam:" + this.mParam);
        switch (this.mParam) {
            case AVOID_CHARGE:
                SpeechSettingUtil.setAvoidCharge(true);
                return;
            case AVOID_CHARGE_OFF:
                SpeechSettingUtil.setAvoidCharge(false);
                return;
            case AVOID_HIGHWAY:
                SpeechSettingUtil.setAvoidFreeway(true);
                return;
            case AVOID_HIGHWAY_CLOSE:
                SpeechSettingUtil.setAvoidFreeway(false);
                return;
            case HIGHWAY_FIRST:
                SpeechSettingUtil.setHighwayPriority(true);
                return;
            case HIGHWAY_FIRST_CLOSE:
                SpeechSettingUtil.setHighwayPriority(false);
                return;
            case AVOID_CONGESTION:
                SpeechSettingUtil.setAvoidCongestion(true);
                return;
            case AVOID_CONGESTION_CLOSE:
                SpeechSettingUtil.setAvoidCongestion(false);
                return;
            case OPEN_CHARGE:
                SpeechSettingUtil.setChargingStationShowState(true);
                return;
            case CLOSE_CHARGE:
                L.i(TAG, "CLOSE_CHARGE");
                SpeechSettingUtil.setChargingStationShowState(false);
                return;
            case OPEN_TRAFFIC:
                SpeechSettingUtil.setRealTimeTrafficState(true);
                return;
            case CLOSE_TRAFFIC:
                SpeechSettingUtil.setRealTimeTrafficState(false);
                return;
            case DETAIL_BROADCAST:
                SpeechSettingUtil.enableDetailBroadcast();
                return;
            case SIMPLE_BROADCAST:
                SpeechSettingUtil.enableSimpleBroadcast();
                return;
            case AVOID_CONTROLS_ON:
                SpeechSettingUtil.setAvoidControlsState(true);
                return;
            case AVOID_CONTROLS_OFF:
                SpeechSettingUtil.setAvoidControlsState(false);
                return;
            case RADAR_ROUTE_ON:
                SpeechSettingUtil.setRadarRouteState(true);
                return;
            case RADAR_ROUTE_OFF:
                SpeechSettingUtil.setRadarRouteState(false);
                return;
            case CONTROL_SPEECH_SUPER_SIMPLE:
                SpeechSettingUtil.enableControlSpeechSuperSimple();
                return;
            case CONTROL_SPEECH_GENERAL:
                SpeechSettingUtil.enableControlSpeechGeneral();
                return;
            case SPEECH_EYE_ON:
                SpeechSettingUtil.setControlSpeechEyeState(true);
                return;
            case SPEECH_EYE_OFF:
                SpeechSettingUtil.setControlSpeechEyeState(false);
                return;
            case SMART_SCALE_ON:
                SpeechSettingUtil.setControlSmartScaleState(true);
                return;
            case SMART_SCALE_OFF:
                SpeechSettingUtil.setControlSmartScaleState(false);
                return;
            case RECOMMEND_PARK_ON:
                SpeechSettingUtil.setControlRecommendParkState(true);
                return;
            case RECOMMEND_PARK_OFF:
                SpeechSettingUtil.setControlRecommendParkState(false);
                return;
            case SECURITY_REMIND_ON:
                SpeechSettingUtil.setControlSecurityRemindState(true);
                return;
            case SECURITY_REMIND_OFF:
                SpeechSettingUtil.setControlSecurityRemindState(false);
                return;
            case ROAD_AHEAD_ON:
                SpeechSettingUtil.setControlRoadAheadState(true);
                return;
            case ROAD_AHEAD_OFF:
                SpeechSettingUtil.setControlRoadAheadState(false);
                return;
            case RIBBON_MAP_OPEN:
                SpeechSettingUtil.setRibbonMapState(true);
                return;
            case RIBBON_MAP_CLOSE:
                SpeechSettingUtil.setRibbonMapState(false);
                return;
            case SCRATCH_SPOT_BROADCAST_OPEN:
                SpeechSettingUtil.setScratchSpotBroadcastState(true);
                return;
            case SCRATCH_SPOT_BROADCAST_CLOSE:
                SpeechSettingUtil.setScratchSpotBroadcastState(false);
                return;
            default:
                return;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007b  */
    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onSuccess() {
        /*
            Method dump skipped, instructions count: 356
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.speech.command.setting.ModifySettingCommand.onSuccess():void");
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public void onFailed() {
        int i = AnonymousClass1.$SwitchMap$com$xiaopeng$montecarlo$speech$command$setting$ModifySettingCommand$SettingParam[this.mParam.ordinal()];
        if (i == 1) {
            SpeechStatProxy.getInstance().sendStatDataForSpeech(14, 3);
        } else if (i == 3) {
            SpeechStatProxy.getInstance().sendStatDataForSpeech(15, 3);
        } else if (i == 5) {
            SpeechStatProxy.getInstance().sendStatDataForSpeech(16, 3);
        } else if (i == 7) {
            SpeechStatProxy.getInstance().sendStatDataForSpeech(13, 3);
        } else {
            switch (i) {
                case 9:
                    SpeechUtils.replySupport("native://navi.control.charge.open", false);
                    SpeechStatProxy.getInstance().sendStatDataForSpeech(11, 3);
                    return;
                case 10:
                    SpeechUtils.replySupport("native://navi.control.charge.close", false);
                    SpeechStatProxy.getInstance().sendStatDataForSpeech(12, 3);
                    return;
                case 11:
                    SpeechStatProxy.getInstance().sendStatDataForSpeech(4, 3);
                    return;
                case 12:
                    SpeechStatProxy.getInstance().sendStatDataForSpeech(5, 3);
                    return;
                case 13:
                    SpeechStatProxy.getInstance().sendStatDataForSpeech(25, 3);
                    return;
                case 14:
                    SpeechStatProxy.getInstance().sendStatDataForSpeech(24, 3);
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public boolean isAchieveGoals() {
        switch (this.mParam) {
            case AVOID_CHARGE:
                return SpeechSettingUtil.isSettingOptionSelected(2);
            case AVOID_CHARGE_OFF:
                return !SpeechSettingUtil.isSettingOptionSelected(2);
            case AVOID_HIGHWAY:
                return SpeechSettingUtil.isSettingOptionSelected(4);
            case AVOID_HIGHWAY_CLOSE:
                return !SpeechSettingUtil.isSettingOptionSelected(4);
            case HIGHWAY_FIRST:
                return SpeechSettingUtil.isSettingOptionSelected(8);
            case HIGHWAY_FIRST_CLOSE:
                return !SpeechSettingUtil.isSettingOptionSelected(8);
            case AVOID_CONGESTION:
                return SpeechSettingUtil.isSettingOptionSelected(1);
            case AVOID_CONGESTION_CLOSE:
                return !SpeechSettingUtil.isSettingOptionSelected(1);
            case OPEN_CHARGE:
                return SpeechSettingUtil.isSettingOptionSelected(16384);
            case CLOSE_CHARGE:
                return !SpeechSettingUtil.isSettingOptionSelected(16384);
            case OPEN_TRAFFIC:
                return SpeechSettingUtil.isSettingOptionSelected(32768);
            case CLOSE_TRAFFIC:
                return !SpeechSettingUtil.isSettingOptionSelected(32768);
            case DETAIL_BROADCAST:
                return SpeechSettingUtil.isSettingOptionSelected(16);
            case SIMPLE_BROADCAST:
            case CONTROL_SPEECH_SUPER_SIMPLE:
                return SpeechSettingUtil.isSettingOptionSelected(1048576);
            case AVOID_CONTROLS_ON:
                return SpeechSettingUtil.isSettingOptionSelected(512);
            case AVOID_CONTROLS_OFF:
                return !SpeechSettingUtil.isSettingOptionSelected(512);
            case RADAR_ROUTE_ON:
                return SpeechSettingUtil.isSettingOptionSelected(1024);
            case RADAR_ROUTE_OFF:
                return !SpeechSettingUtil.isSettingOptionSelected(1024);
            case CONTROL_SPEECH_GENERAL:
                return SpeechSettingUtil.isSettingOptionSelected(32);
            case SPEECH_EYE_ON:
                return SpeechSettingUtil.isSettingOptionSelected(128);
            case SPEECH_EYE_OFF:
                return !SpeechSettingUtil.isSettingOptionSelected(128);
            case SMART_SCALE_ON:
                return SpeechSettingUtil.isSettingOptionSelected(131072);
            case SMART_SCALE_OFF:
                return !SpeechSettingUtil.isSettingOptionSelected(131072);
            case RECOMMEND_PARK_ON:
                return SpeechSettingUtil.isSettingOptionSelected(16777216);
            case RECOMMEND_PARK_OFF:
                return !SpeechSettingUtil.isSettingOptionSelected(16777216);
            case SECURITY_REMIND_ON:
                return SpeechSettingUtil.isSettingOptionSelected(256);
            case SECURITY_REMIND_OFF:
                return !SpeechSettingUtil.isSettingOptionSelected(256);
            case ROAD_AHEAD_ON:
                return SpeechSettingUtil.isSettingOptionSelected(64);
            case ROAD_AHEAD_OFF:
                return !SpeechSettingUtil.isSettingOptionSelected(64);
            case RIBBON_MAP_OPEN:
                return SpeechSettingUtil.isSettingOptionSelected(524288);
            case RIBBON_MAP_CLOSE:
                return !SpeechSettingUtil.isSettingOptionSelected(524288);
            case SCRATCH_SPOT_BROADCAST_OPEN:
            case SCRATCH_SPOT_BROADCAST_CLOSE:
            default:
                return false;
            case SMALL_MAP_OPEN:
                return SpeechSettingUtil.isSettingOptionSelected(262144);
            case SMALL_MAP_CLOSE:
                return !SpeechSettingUtil.isSettingOptionSelected(262144);
        }
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandRecorder
    public void noNeedToExecute() {
        int i = AnonymousClass1.$SwitchMap$com$xiaopeng$montecarlo$speech$command$setting$ModifySettingCommand$SettingParam[this.mParam.ordinal()];
        if (i == 9) {
            SpeechUtils.replySupport("native://navi.control.charge.open", true);
            SpeechStatProxy.getInstance().sendStatDataForSpeech(11, 0);
        } else if (i == 10) {
            SpeechUtils.replySupport("native://navi.control.charge.close", true);
            SpeechStatProxy.getInstance().sendStatDataForSpeech(12, 0);
        } else {
            super.noNeedToExecute();
        }
    }

    @Override // com.xiaopeng.montecarlo.speech.command.BaseSpeechCommand, com.xiaopeng.montecarlo.speech.command.ICommandFunction
    public List<Class<? extends BaseSpeechCommand>> getFixContextList() {
        if (SettingParam.OPEN_CHARGE == this.mParam && SRUtil.isLaneMode()) {
            if (L.ENABLE) {
                L.d(TAG, "getFixContextList add ExitSrOrLaneModeCommand to fix list");
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(ExitSrOrLaneModeCommand.class);
            return arrayList;
        }
        return null;
    }
}
