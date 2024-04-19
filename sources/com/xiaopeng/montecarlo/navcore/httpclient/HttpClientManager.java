package com.xiaopeng.montecarlo.navcore.httpclient;

import android.app.Application;
import com.xiaopeng.lib.framework.module.Module;
import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IHttp;
import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.remotestorage.IRemoteStorage;
import com.xiaopeng.lib.framework.netchannelmodule.NetworkChannelsEntry;
import com.xiaopeng.lib.framework.netchannelmodule.remotestorage.RemoteStorageImpl;
import com.xiaopeng.lib.http.HttpsUtils;
import com.xiaopeng.montecarlo.root.httpclient.IHttpDependency;
import com.xiaopeng.montecarlo.root.httpclient.core.HardCodedTarget;
import com.xiaopeng.montecarlo.root.httpclient.core.RemoteClientParser;
import com.xiaopeng.montecarlo.root.httpclient.core.RemoteClientProxyInvocationHandler;
import com.xiaopeng.montecarlo.root.httpclient.hosts.XpServiceHostManager;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import com.xiaopeng.montecarlo.root.util.TraceUtils;
import java.lang.reflect.Proxy;
/* loaded from: classes2.dex */
public class HttpClientManager {
    private static final int HTTP_CONNECT_TIMEOUT = 3000;
    private static final int HTTP_READ_TIMEOUT = 7000;
    private static final int HTTP_WRITE_TIMEOUT = 3000;
    private static final L.Tag TAG = new L.Tag("HttpClientManager");
    private static final HttpClientManager sHttpClientManager = new HttpClientManager();
    private RemoteClientParser mRemoteClientParser = new RemoteClientParser();
    private IRemoteStorage mRemoteStorage = new RemoteStorageImpl();
    private IHttpDependency mHttpDependency = new HttpDependencyImpl();

    public static HttpClientManager getInstance() {
        return sHttpClientManager;
    }

    public void init(Application application) {
        TraceUtils.alwaysTraceBegin("Application_init_NetworkChannelsEntry");
        if (!RootUtil.isTabletApp()) {
            HttpsUtils.init(application, false);
        }
        XpServiceHostManager.getInstance().init();
        Module.register(NetworkChannelsEntry.class, new NetworkChannelsEntry());
        TraceUtils.alwaysTraceEnd();
        TraceUtils.alwaysTraceBegin("Application_init_IRemoteStorage");
        ((IHttp) Module.get(NetworkChannelsEntry.class).get(IHttp.class)).config().connectTimeout(3000).readTimeout(7000).writeTimeout(3000).retryCount(0).applicationContext(application).enableTrafficStats().apply();
        try {
            this.mRemoteStorage.initWithContext(application);
        } catch (Exception e) {
            L.printStackTrace(TAG, e);
        }
        TraceUtils.alwaysTraceEnd();
    }

    public IRemoteStorage getRemoteStorage() {
        return this.mRemoteStorage;
    }

    public <T> T getService(Class<T> cls) {
        HardCodedTarget hardCodedTarget = new HardCodedTarget(cls);
        return cls.cast(Proxy.newProxyInstance(hardCodedTarget.type().getClassLoader(), new Class[]{hardCodedTarget.type()}, new RemoteClientProxyInvocationHandler(this.mRemoteClientParser.parseOneInterface(cls), this.mHttpDependency)));
    }
}
