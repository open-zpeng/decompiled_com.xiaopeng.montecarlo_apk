package com.xiaopeng.montecarlo.navcore.configurationmodule;

import android.app.Application;
import android.text.TextUtils;
import com.irdeto.securesdk.core.SSUtils;
import com.xiaopeng.lib.framework.configuration.ConfigurationModuleEntry;
import com.xiaopeng.lib.framework.module.Module;
import com.xiaopeng.lib.framework.moduleinterface.configurationmodule.ConfigurationChangeEvent;
import com.xiaopeng.lib.framework.moduleinterface.configurationmodule.IConfiguration;
import com.xiaopeng.lib.framework.moduleinterface.configurationmodule.IConfigurationData;
import com.xiaopeng.montecarlo.navcore.configurationmodule.constants.WebConfigurationEnum;
import com.xiaopeng.montecarlo.navcore.configurationmodule.listener.IOnWebConfigurationChangeListener;
import com.xiaopeng.montecarlo.navcore.configurationmodule.listener.ScratchSpotConfigListener;
import com.xiaopeng.montecarlo.navcore.database.XpWebConfigDataHelper;
import com.xiaopeng.montecarlo.navcore.exceptions.OnMainThreadException;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.GsonUtil;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
/* loaded from: classes3.dex */
public class ConfigurationModuleManager {
    private static final L.Tag TAG = new L.Tag("ConfigurationModuleManager");
    private static ConfigurationModuleManager sConfigurationModuleManager = new ConfigurationModuleManager();
    private XpWebConfigDataHelper mDatabase = new XpWebConfigDataHelper();
    private List<IOnWebConfigurationChangeListener> mListener = new CopyOnWriteArrayList();
    private final ConcurrentHashMap<String, String> mConfigMap = new ConcurrentHashMap<>();

    private ConfigurationModuleManager() {
    }

    public static ConfigurationModuleManager getInstance() {
        return sConfigurationModuleManager;
    }

    public void init(Application application) {
        Module.register(ConfigurationModuleEntry.class, new ConfigurationModuleEntry());
        getConfigurationInterface().init(application, ContextUtils.getContext().getPackageName());
        WorkThreadUtil.getInstance().executeScheduledIoTask(new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.configurationmodule.-$$Lambda$ConfigurationModuleManager$HXWDbMi8EaWqd5v-ywSatepvCiQ
            @Override // java.lang.Runnable
            public final void run() {
                ConfigurationModuleManager.this.syncWebConfig();
            }
        }, 20L, TimeUnit.SECONDS);
        initListener();
    }

    private void initListener() {
        this.mListener.add(new ScratchSpotConfigListener());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void syncWebConfig() {
        WebConfigurationEnum[] values;
        L.i(TAG, "start syncWebConfig");
        for (WebConfigurationEnum webConfigurationEnum : WebConfigurationEnum.values()) {
            saveConfig(webConfigurationEnum, webConfigurationEnum.getValueFromWeb());
        }
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onWebConfigurationChanged(ConfigurationChangeEvent configurationChangeEvent) {
        List list = (List) Optional.ofNullable(configurationChangeEvent.getChangeList()).orElse(new ArrayList());
        L.Tag tag = TAG;
        L.i(tag, "onConfigurationChanged, list size=" + list.size());
        int i = 0;
        while (i < list.size()) {
            IConfigurationData iConfigurationData = (IConfigurationData) list.get(i);
            String value = iConfigurationData.getValue();
            L.Tag tag2 = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append(SSUtils.O000000o);
            i++;
            sb.append(i);
            sb.append(" = ");
            sb.append(iConfigurationData.getKey());
            sb.append(", ");
            sb.append(value);
            L.d(tag2, sb.toString());
            WebConfigurationEnum parse = WebConfigurationEnum.parse(iConfigurationData.getKey());
            if (parse != null) {
                saveConfig(parse, value);
            }
        }
    }

    private void saveConfig(WebConfigurationEnum webConfigurationEnum, String str) {
        if (webConfigurationEnum.isForceDisabledByAdmin(str)) {
            this.mDatabase.insertOrUpdate(webConfigurationEnum.getKey(), "");
            L.Tag tag = TAG;
            L.i(tag, "saveConfig, force disable config:" + webConfigurationEnum + ", value=" + str);
        } else if (!webConfigurationEnum.isValid(str)) {
            L.Tag tag2 = TAG;
            L.i(tag2, "invalid value, keyEnum=" + webConfigurationEnum + ", value=" + str);
        } else {
            String value = this.mDatabase.getValue(webConfigurationEnum);
            this.mConfigMap.put(webConfigurationEnum.getKey(), str);
            boolean insertOrUpdate = this.mDatabase.insertOrUpdate(webConfigurationEnum.getKey(), str);
            L.Tag tag3 = TAG;
            L.i(tag3, "insertOrUpdate " + webConfigurationEnum.getKey() + " " + insertOrUpdate);
            for (IOnWebConfigurationChangeListener iOnWebConfigurationChangeListener : this.mListener) {
                if (iOnWebConfigurationChangeListener.getTargetConfiguration() == webConfigurationEnum && iOnWebConfigurationChangeListener.isNeedReply(value, str)) {
                    iOnWebConfigurationChangeListener.onConfigurationChange(webConfigurationEnum, str);
                }
            }
        }
    }

    public String getConfigurationFromWeb(String str, String str2) {
        if (RootUtil.isMainThread()) {
            throw new OnMainThreadException();
        }
        String configuration = getConfigurationInterface().getConfiguration(str, str2);
        L.Tag tag = TAG;
        L.i(tag, "getConfigurationFromWeb, key=" + str + ", value=" + configuration);
        return configuration;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.lang.String] */
    public <T> T getConfigurationFromDatabase(WebConfigurationEnum webConfigurationEnum, Class<T> cls) {
        T t;
        if (this.mConfigMap.containsKey(webConfigurationEnum.getKey())) {
            ?? r0 = (T) this.mConfigMap.get(webConfigurationEnum.getKey());
            L.Tag tag = TAG;
            L.i(tag, "getConfigurationFromDatabase mConfigMap, key=" + webConfigurationEnum.getKey() + ", value=" + ((String) r0));
            t = r0;
        } else {
            ?? r02 = (T) new XpWebConfigDataHelper().getValue(webConfigurationEnum);
            if (r02 != 0) {
                this.mConfigMap.put(webConfigurationEnum.getKey(), r02);
            }
            L.Tag tag2 = TAG;
            L.i(tag2, "getConfigurationFromDatabase database , key=" + webConfigurationEnum.getKey() + ", value=" + ((String) r02));
            t = r02;
        }
        if (TextUtils.isEmpty((CharSequence) t)) {
            return null;
        }
        if (cls == String.class) {
            return t;
        }
        if (cls == Character.class) {
            if (TextUtils.isEmpty((CharSequence) t)) {
                return null;
            }
            return (T) Character.valueOf(((String) t).toCharArray()[0]);
        } else if (cls == Boolean.class) {
            if ("true".equalsIgnoreCase((String) t)) {
                return (T) Boolean.TRUE;
            }
            if ("false".equalsIgnoreCase((String) t)) {
                return (T) Boolean.FALSE;
            }
            return null;
        } else if (cls == Integer.class) {
            return (T) Integer.valueOf((String) t);
        } else {
            if (cls == Short.class) {
                return (T) Short.valueOf((String) t);
            }
            if (cls == Long.class) {
                return (T) Long.valueOf((String) t);
            }
            if (cls == Float.class) {
                return (T) Float.valueOf((String) t);
            }
            if (cls == Double.class) {
                return (T) Double.valueOf((String) t);
            }
            if (cls == Byte.class) {
                return (T) Byte.valueOf((String) t);
            }
            String str = webConfigurationEnum.getKey().split("\\.")[0];
            if ("json".equalsIgnoreCase(str)) {
                return (T) GsonUtil.fromJson((String) t, (Class<Object>) cls);
            }
            L.Tag tag3 = TAG;
            L.i(tag3, "getConfigurationFromDatabase failed, type=" + str + ", class=" + cls.getSimpleName());
            return null;
        }
    }

    private IConfiguration getConfigurationInterface() {
        return (IConfiguration) Module.get(ConfigurationModuleEntry.class).get(IConfiguration.class);
    }

    public void registerWebConfigurationListener(IOnWebConfigurationChangeListener iOnWebConfigurationChangeListener) {
        if (iOnWebConfigurationChangeListener == null || this.mListener.contains(iOnWebConfigurationChangeListener)) {
            return;
        }
        this.mListener.add(iOnWebConfigurationChangeListener);
    }

    public void unregisterWebConfigurationListener(IOnWebConfigurationChangeListener iOnWebConfigurationChangeListener) {
        if (iOnWebConfigurationChangeListener == null) {
            return;
        }
        this.mListener.remove(iOnWebConfigurationChangeListener);
    }

    public void clearConfigMap() {
        this.mConfigMap.clear();
    }
}
