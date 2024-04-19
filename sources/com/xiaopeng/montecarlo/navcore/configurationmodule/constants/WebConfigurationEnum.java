package com.xiaopeng.montecarlo.navcore.configurationmodule.constants;

import com.xiaopeng.lib.bughunter.anr.UILooperObserver;
import com.xiaopeng.montecarlo.navcore.bean.sr.SrMuteNaviTtsStrategyInfo;
import com.xiaopeng.montecarlo.navcore.configurationmodule.ConfigurationModuleManager;
import com.xiaopeng.montecarlo.navcore.datarecord.SrDataRecordStrategyInfo;
import com.xiaopeng.montecarlo.root.util.GsonUtil;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
/* loaded from: classes2.dex */
public enum WebConfigurationEnum {
    SR_MUTE_NAVI_TTS_STRATEGY("json.strategy.sr.mute_navi_tts", "", new WebConfigurationVerifier() { // from class: com.xiaopeng.montecarlo.navcore.configurationmodule.constants.-$$Lambda$WebConfigurationEnum$6IyDff4cIlgePg-A1argmy5wcvs
        @Override // com.xiaopeng.montecarlo.navcore.configurationmodule.constants.WebConfigurationEnum.WebConfigurationVerifier
        public final boolean isValid(String str) {
            return WebConfigurationEnum.lambda$static$0(str);
        }
    }),
    RECORD_DATA_STRATEGY("json.strategy.sr.data_record", "", new WebConfigurationVerifier() { // from class: com.xiaopeng.montecarlo.navcore.configurationmodule.constants.-$$Lambda$WebConfigurationEnum$_An9fhgTsru7JDghj6lFzJ3vZcE
        @Override // com.xiaopeng.montecarlo.navcore.configurationmodule.constants.WebConfigurationEnum.WebConfigurationVerifier
        public final boolean isValid(String str) {
            return WebConfigurationEnum.lambda$static$1(str);
        }
    }),
    SCRATCH_SPOT("boolean.setting.scratch", "", new WebConfigurationVerifier() { // from class: com.xiaopeng.montecarlo.navcore.configurationmodule.constants.-$$Lambda$WebConfigurationEnum$FLNsj5vLNEPMbIL93NvQ59L2xFo
        @Override // com.xiaopeng.montecarlo.navcore.configurationmodule.constants.WebConfigurationEnum.WebConfigurationVerifier
        public final boolean isValid(String str) {
            return WebConfigurationEnum.lambda$static$2(str);
        }
    }),
    PING("text.montecarlo.ping", "", null);
    
    private static final L.Tag TAG = new L.Tag("WebConfigurationEnum");
    private String mDefaultValue;
    private String mKey;
    private WebConfigurationVerifier mVerifier;

    @FunctionalInterface
    /* loaded from: classes2.dex */
    public interface WebConfigurationVerifier {
        boolean isValid(String str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean lambda$static$0(String str) {
        return GsonUtil.fromJson(str, (Class<Object>) SrMuteNaviTtsStrategyInfo.class) != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean lambda$static$1(String str) {
        return GsonUtil.fromJson(str, (Class<Object>) SrDataRecordStrategyInfo.class) != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean lambda$static$2(String str) {
        return ("true".equalsIgnoreCase(str) ? Boolean.TRUE : "false".equalsIgnoreCase(str) ? Boolean.FALSE : null) != null;
    }

    WebConfigurationEnum(String str, String str2, WebConfigurationVerifier webConfigurationVerifier) {
        this.mKey = str;
        this.mDefaultValue = (String) Optional.ofNullable(str2).orElse("");
        this.mVerifier = webConfigurationVerifier;
    }

    public String getValueFromWeb() {
        FutureTask futureTask = new FutureTask(new Callable() { // from class: com.xiaopeng.montecarlo.navcore.configurationmodule.constants.-$$Lambda$WebConfigurationEnum$_qDtmo-VUdByjX754tVIGoBFy5A
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return WebConfigurationEnum.this.lambda$getValueFromWeb$3$WebConfigurationEnum();
            }
        });
        WorkThreadUtil.getInstance().executeCachedTask(futureTask);
        try {
            String str = (String) futureTask.get(UILooperObserver.ANR_TRIGGER_TIME, TimeUnit.MILLISECONDS);
            L.Tag tag = TAG;
            L.i(tag, "getValueFromWeb, key=" + this.mKey + ", resultFromWeb=" + str);
            return str;
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            L.printStackTrace(TAG, e);
            return this.mDefaultValue;
        }
    }

    public /* synthetic */ String lambda$getValueFromWeb$3$WebConfigurationEnum() throws Exception {
        return ConfigurationModuleManager.getInstance().getConfigurationFromWeb(this.mKey, this.mDefaultValue);
    }

    public String getKey() {
        return this.mKey;
    }

    public String getDefaultValue() {
        return this.mDefaultValue;
    }

    public boolean isValid(String str) {
        if (str == null) {
            return false;
        }
        WebConfigurationVerifier webConfigurationVerifier = this.mVerifier;
        if (webConfigurationVerifier == null) {
            return true;
        }
        return webConfigurationVerifier.isValid(str);
    }

    public boolean isForceDisabledByAdmin(String str) {
        return "montecarlo_admin_disable".equalsIgnoreCase(str);
    }

    public static WebConfigurationEnum parse(String str) {
        WebConfigurationEnum[] values;
        for (WebConfigurationEnum webConfigurationEnum : values()) {
            if (webConfigurationEnum.getKey().equalsIgnoreCase(str)) {
                return webConfigurationEnum;
            }
        }
        return null;
    }
}
