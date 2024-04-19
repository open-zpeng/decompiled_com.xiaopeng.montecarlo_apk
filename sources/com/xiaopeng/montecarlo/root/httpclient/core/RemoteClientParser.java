package com.xiaopeng.montecarlo.root.httpclient.core;

import com.xiaopeng.montecarlo.root.httpclient.annotations.GetMapping;
import com.xiaopeng.montecarlo.root.httpclient.annotations.Header;
import com.xiaopeng.montecarlo.root.httpclient.annotations.PostMapping;
import com.xiaopeng.montecarlo.root.httpclient.annotations.RemoteClient;
import com.xiaopeng.montecarlo.root.httpclient.constants.EncryptTypeEnum;
import com.xiaopeng.montecarlo.root.httpclient.constants.RequestType;
import com.xiaopeng.montecarlo.root.httpclient.core.RemoteClientDefine;
import com.xiaopeng.montecarlo.root.httpclient.exception.RemoteClientParseException;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.L;
import java.lang.reflect.Method;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class RemoteClientParser {
    private static final L.Tag TAG = new L.Tag("RemoteClientParser");

    public RemoteClientDefine parseOneInterface(Class<?> cls) throws RuntimeException {
        RemoteClientDefine remoteClientDefine = new RemoteClientDefine();
        if (!cls.isInterface()) {
            throw new RemoteClientParseException(">>>  getService FAILED!!!  <<< Not a interface");
        }
        if (cls.isAnnotationPresent(RemoteClient.class)) {
            RemoteClient remoteClient = (RemoteClient) cls.getAnnotation(RemoteClient.class);
            remoteClientDefine.setParentPath(remoteClient.path()).setServiceName(remoteClient.serviceName()).setSpecialUrl(remoteClient.url());
            if (cls.isAnnotationPresent(Header.class)) {
                remoteClientDefine.setHeaders(parseHeader((Header) cls.getAnnotation(Header.class)));
            } else {
                remoteClientDefine.setHeaders(new RemoteClientHeaderDefine());
            }
            Method[] methods = cls.getMethods();
            if (CollectionUtils.isEmpty(methods)) {
                throw new RemoteClientParseException(">>>  getService FAILED!!!  <<< Must define at lease one method");
            }
            HashMap hashMap = new HashMap();
            for (Method method : methods) {
                RemoteClientDefine.RemoteClientMethodDefine remoteClientMethodDefine = new RemoteClientDefine.RemoteClientMethodDefine();
                remoteClientMethodDefine.setParameterAnnotations(method.getParameterAnnotations());
                if (method.isAnnotationPresent(GetMapping.class) && method.isAnnotationPresent(PostMapping.class)) {
                    throw new RemoteClientParseException(">>>  getService FAILED!!!  <<< Cannot place both GetMapping & PostMapping at the same method");
                }
                if (method.isAnnotationPresent(GetMapping.class)) {
                    remoteClientMethodDefine.setRequestType(RequestType.GET).setChildPath(((GetMapping) method.getAnnotation(GetMapping.class)).path());
                } else if (method.isAnnotationPresent(PostMapping.class)) {
                    remoteClientMethodDefine.setRequestType(RequestType.POST).setChildPath(((PostMapping) method.getAnnotation(PostMapping.class)).path());
                } else {
                    L.d(TAG, "not a remote interface: " + method.getName());
                }
                remoteClientMethodDefine.setResponseType(method.getGenericReturnType());
                hashMap.put(method, remoteClientMethodDefine);
            }
            remoteClientDefine.setMethodMap(hashMap);
            return remoteClientDefine;
        }
        throw new RemoteClientParseException(">>>  getService FAILED!!!  <<< Not a RemoteClient");
    }

    private RemoteClientHeaderDefine parseHeader(Header header) {
        RemoteClientHeaderDefine remoteClientHeaderDefine = new RemoteClientHeaderDefine();
        if (header == null) {
            return remoteClientHeaderDefine;
        }
        remoteClientHeaderDefine.setEncryptType(header.encryptType()).setClientType(header.clientType()).setClientEncodingType(header.clientEncodingType());
        if (header.requireOpenId()) {
            remoteClientHeaderDefine.setRequireOpenId(true);
        }
        if (header.requireSid()) {
            remoteClientHeaderDefine.setRequireSid(true);
        }
        if (header.requireVin()) {
            remoteClientHeaderDefine.setRequireVin(true);
        }
        if (header.requireUid()) {
            remoteClientHeaderDefine.setRequireUserId(true);
        }
        if (header.requireOtp()) {
            if (header.encryptType() == EncryptTypeEnum.XP_ENCRYPT_TYPE_NONE) {
                throw new RemoteClientParseException("requireOtp should be encrypted");
            }
            remoteClientHeaderDefine.setRequireOtp(true);
        }
        if (header.requireClientKey()) {
            remoteClientHeaderDefine.setRequireClientKey(true);
        }
        if (header.requireNonce()) {
            remoteClientHeaderDefine.setRequireNonce(true);
        }
        return remoteClientHeaderDefine;
    }
}
