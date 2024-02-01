package com.xiaopeng.montecarlo.root.httpclient.core;

import android.text.TextUtils;
import com.xiaopeng.montecarlo.root.httpclient.IHttpDependency;
import com.xiaopeng.montecarlo.root.httpclient.annotations.Header;
import com.xiaopeng.montecarlo.root.httpclient.annotations.RequestBody;
import com.xiaopeng.montecarlo.root.httpclient.annotations.RequestParam;
import com.xiaopeng.montecarlo.root.httpclient.core.RemoteClientDefine;
import com.xiaopeng.montecarlo.root.httpclient.exception.RemoteClientException;
import com.xiaopeng.montecarlo.root.httpclient.http.IHttpService;
import com.xiaopeng.montecarlo.root.httpclient.http.OkHttpService;
import com.xiaopeng.montecarlo.root.httpclient.http.XpHttpService;
import com.xiaopeng.montecarlo.root.util.L;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class RemoteClientProxyInvocationHandler implements InvocationHandler {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final L.Tag TAG = new L.Tag("RemoteClientProxy");
    private RemoteClientDefine mDefine;
    private IHttpDependency mDependency;

    public RemoteClientProxyInvocationHandler(RemoteClientDefine remoteClientDefine, IHttpDependency iHttpDependency) {
        this.mDefine = remoteClientDefine;
        this.mDependency = iHttpDependency;
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) {
        Object obj2;
        Annotation[] annotationArr;
        IHttpService httpClient = getHttpClient();
        RemoteClientDefine.RemoteClientMethodDefine remoteClientMethodDefine = this.mDefine.getMethodMap().get(method);
        if (remoteClientMethodDefine == null) {
            throw new RemoteClientException("MethodDefine is null");
        }
        String url = httpClient.getUrl(this.mDefine);
        String str = this.mDefine.getParentPath() + remoteClientMethodDefine.getChildPath();
        String secretKey = httpClient.getSecretKey(this.mDefine);
        Map<String, String> injectHeaders = httpClient.injectHeaders(this.mDefine.getHeaders());
        HashMap hashMap = new HashMap();
        Annotation[][] parameterAnnotations = remoteClientMethodDefine.getParameterAnnotations();
        if (objArr != null) {
            Object obj3 = null;
            int i = 0;
            while (i < objArr.length) {
                Object obj4 = objArr[i];
                Object obj5 = obj3;
                for (Annotation annotation : parameterAnnotations[i]) {
                    if (annotation.annotationType() == RequestParam.class) {
                        hashMap.put(((RequestParam) annotation).value(), obj4);
                    }
                    if (annotation.annotationType() == RequestBody.class) {
                        if (obj5 != null) {
                            throw new RemoteClientException("Contains multi request bodies");
                        }
                        obj5 = obj4;
                    }
                    if (annotation.annotationType() == Header.class) {
                        if (obj4 instanceof Map) {
                            injectHeaders.putAll((Map) obj4);
                        } else {
                            throw new RemoteClientException("Only support Map<String, String> type as RuntimeHeader");
                        }
                    }
                }
                i++;
                obj3 = obj5;
            }
            obj2 = obj3;
        } else {
            obj2 = null;
        }
        return httpClient.parseJson2Object(httpClient.executeWithHttpClient(remoteClientMethodDefine.getRequestType(), url, str, injectHeaders, hashMap, obj2, secretKey), remoteClientMethodDefine.getResponseType(), remoteClientMethodDefine.isResponseWrapper());
    }

    private IHttpService getHttpClient() {
        if (this.mDefine.getServiceName() != null) {
            return new XpHttpService(this.mDependency);
        }
        if (!TextUtils.isEmpty(this.mDefine.getSpecialUrl())) {
            return new OkHttpService(this.mDependency);
        }
        throw new RemoteClientException("Invoke failed, url is empty");
    }
}
