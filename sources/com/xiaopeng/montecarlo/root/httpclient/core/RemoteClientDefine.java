package com.xiaopeng.montecarlo.root.httpclient.core;

import com.google.gson.internal.C$Gson$Types;
import com.xiaopeng.montecarlo.root.httpclient.constants.RemoteServiceNameEnum;
import com.xiaopeng.montecarlo.root.httpclient.constants.RequestType;
import com.xiaopeng.montecarlo.root.httpclient.exception.RemoteClientException;
import com.xiaopeng.montecarlo.root.util.reflect.ParameterizedTypeImpl;
import java.lang.annotation.Annotation;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Map;
/* loaded from: classes2.dex */
public class RemoteClientDefine {
    private RemoteClientHeaderDefine mHeaders;
    private Map<Method, RemoteClientMethodDefine> mMethodMap;
    private String mParentPath;
    private RemoteServiceNameEnum mServiceName;
    private String mSpecialUrl;

    protected boolean canEqual(Object obj) {
        return obj instanceof RemoteClientDefine;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof RemoteClientDefine) {
            RemoteClientDefine remoteClientDefine = (RemoteClientDefine) obj;
            if (remoteClientDefine.canEqual(this)) {
                String parentPath = getParentPath();
                String parentPath2 = remoteClientDefine.getParentPath();
                if (parentPath != null ? parentPath.equals(parentPath2) : parentPath2 == null) {
                    RemoteClientHeaderDefine headers = getHeaders();
                    RemoteClientHeaderDefine headers2 = remoteClientDefine.getHeaders();
                    if (headers != null ? headers.equals(headers2) : headers2 == null) {
                        RemoteServiceNameEnum serviceName = getServiceName();
                        RemoteServiceNameEnum serviceName2 = remoteClientDefine.getServiceName();
                        if (serviceName != null ? serviceName.equals(serviceName2) : serviceName2 == null) {
                            String specialUrl = getSpecialUrl();
                            String specialUrl2 = remoteClientDefine.getSpecialUrl();
                            if (specialUrl != null ? specialUrl.equals(specialUrl2) : specialUrl2 == null) {
                                Map<Method, RemoteClientMethodDefine> methodMap = getMethodMap();
                                Map<Method, RemoteClientMethodDefine> methodMap2 = remoteClientDefine.getMethodMap();
                                return methodMap != null ? methodMap.equals(methodMap2) : methodMap2 == null;
                            }
                            return false;
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        String parentPath = getParentPath();
        int hashCode = parentPath == null ? 43 : parentPath.hashCode();
        RemoteClientHeaderDefine headers = getHeaders();
        int hashCode2 = ((hashCode + 59) * 59) + (headers == null ? 43 : headers.hashCode());
        RemoteServiceNameEnum serviceName = getServiceName();
        int hashCode3 = (hashCode2 * 59) + (serviceName == null ? 43 : serviceName.hashCode());
        String specialUrl = getSpecialUrl();
        int hashCode4 = (hashCode3 * 59) + (specialUrl == null ? 43 : specialUrl.hashCode());
        Map<Method, RemoteClientMethodDefine> methodMap = getMethodMap();
        return (hashCode4 * 59) + (methodMap != null ? methodMap.hashCode() : 43);
    }

    public RemoteClientDefine setHeaders(RemoteClientHeaderDefine remoteClientHeaderDefine) {
        this.mHeaders = remoteClientHeaderDefine;
        return this;
    }

    public RemoteClientDefine setMethodMap(Map<Method, RemoteClientMethodDefine> map) {
        this.mMethodMap = map;
        return this;
    }

    public RemoteClientDefine setParentPath(String str) {
        this.mParentPath = str;
        return this;
    }

    public RemoteClientDefine setServiceName(RemoteServiceNameEnum remoteServiceNameEnum) {
        this.mServiceName = remoteServiceNameEnum;
        return this;
    }

    public RemoteClientDefine setSpecialUrl(String str) {
        this.mSpecialUrl = str;
        return this;
    }

    public String toString() {
        return "RemoteClientDefine(mParentPath=" + getParentPath() + ", mHeaders=" + getHeaders() + ", mServiceName=" + getServiceName() + ", mSpecialUrl=" + getSpecialUrl() + ", mMethodMap=" + getMethodMap() + ")";
    }

    public String getParentPath() {
        return this.mParentPath;
    }

    public RemoteClientHeaderDefine getHeaders() {
        return this.mHeaders;
    }

    public RemoteServiceNameEnum getServiceName() {
        return this.mServiceName;
    }

    public String getSpecialUrl() {
        return this.mSpecialUrl;
    }

    public Map<Method, RemoteClientMethodDefine> getMethodMap() {
        return this.mMethodMap;
    }

    /* loaded from: classes2.dex */
    public static class RemoteClientMethodDefine {
        private String mChildPath;
        private boolean mIsResponseWrapper = false;
        private Annotation[][] mParameterAnnotations;
        private RequestType mRequestType;
        private Type mResponseType;

        protected boolean canEqual(Object obj) {
            return obj instanceof RemoteClientMethodDefine;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof RemoteClientMethodDefine) {
                RemoteClientMethodDefine remoteClientMethodDefine = (RemoteClientMethodDefine) obj;
                if (remoteClientMethodDefine.canEqual(this) && isResponseWrapper() == remoteClientMethodDefine.isResponseWrapper()) {
                    String childPath = getChildPath();
                    String childPath2 = remoteClientMethodDefine.getChildPath();
                    if (childPath != null ? childPath.equals(childPath2) : childPath2 == null) {
                        RequestType requestType = getRequestType();
                        RequestType requestType2 = remoteClientMethodDefine.getRequestType();
                        if (requestType != null ? requestType.equals(requestType2) : requestType2 == null) {
                            if (Arrays.deepEquals(getParameterAnnotations(), remoteClientMethodDefine.getParameterAnnotations())) {
                                Type responseType = getResponseType();
                                Type responseType2 = remoteClientMethodDefine.getResponseType();
                                return responseType != null ? responseType.equals(responseType2) : responseType2 == null;
                            }
                            return false;
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }

        public int hashCode() {
            int i = isResponseWrapper() ? 79 : 97;
            String childPath = getChildPath();
            int hashCode = ((i + 59) * 59) + (childPath == null ? 43 : childPath.hashCode());
            RequestType requestType = getRequestType();
            int hashCode2 = (((hashCode * 59) + (requestType == null ? 43 : requestType.hashCode())) * 59) + Arrays.deepHashCode(getParameterAnnotations());
            Type responseType = getResponseType();
            return (hashCode2 * 59) + (responseType != null ? responseType.hashCode() : 43);
        }

        public RemoteClientMethodDefine setChildPath(String str) {
            this.mChildPath = str;
            return this;
        }

        public RemoteClientMethodDefine setParameterAnnotations(Annotation[][] annotationArr) {
            this.mParameterAnnotations = annotationArr;
            return this;
        }

        public RemoteClientMethodDefine setRequestType(RequestType requestType) {
            this.mRequestType = requestType;
            return this;
        }

        public RemoteClientMethodDefine setResponseWrapper(boolean z) {
            this.mIsResponseWrapper = z;
            return this;
        }

        public String toString() {
            return "RemoteClientDefine.RemoteClientMethodDefine(mChildPath=" + getChildPath() + ", mRequestType=" + getRequestType() + ", mParameterAnnotations=" + Arrays.deepToString(getParameterAnnotations()) + ", mResponseType=" + getResponseType() + ", mIsResponseWrapper=" + isResponseWrapper() + ")";
        }

        public String getChildPath() {
            return this.mChildPath;
        }

        public RequestType getRequestType() {
            return this.mRequestType;
        }

        public Annotation[][] getParameterAnnotations() {
            return this.mParameterAnnotations;
        }

        public Type getResponseType() {
            return this.mResponseType;
        }

        public boolean isResponseWrapper() {
            return this.mIsResponseWrapper;
        }

        public RemoteClientMethodDefine setResponseType(Type type) {
            Type canonicalize = C$Gson$Types.canonicalize(type);
            if (ResponseWrapper.class.isAssignableFrom(C$Gson$Types.getRawType(canonicalize))) {
                this.mIsResponseWrapper = true;
                if (type instanceof Class) {
                    this.mResponseType = Object.class;
                } else if (type instanceof ParameterizedType) {
                    parseType(((ParameterizedType) canonicalize).getActualTypeArguments()[0]);
                }
            } else {
                parseType(canonicalize);
            }
            return this;
        }

        private void parseType(Type type) {
            Type canonicalize = C$Gson$Types.canonicalize(type);
            if (type instanceof Class) {
                this.mResponseType = type;
            } else if (type instanceof ParameterizedType) {
                this.mResponseType = new ParameterizedTypeImpl(C$Gson$Types.getRawType(canonicalize), new Class[]{C$Gson$Types.getRawType(((ParameterizedType) canonicalize).getActualTypeArguments()[0])});
            } else if (type instanceof GenericArrayType) {
                throw new RemoteClientException("RemoteClientDefine, Invalid return type");
            } else {
                this.mResponseType = new ParameterizedTypeImpl(C$Gson$Types.getRawType(canonicalize), null);
            }
        }
    }
}
