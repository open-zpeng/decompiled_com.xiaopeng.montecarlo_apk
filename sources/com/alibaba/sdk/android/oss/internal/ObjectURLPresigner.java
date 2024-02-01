package com.alibaba.sdk.android.oss.internal;

import android.text.TextUtils;
import com.alibaba.sdk.android.oss.ClientConfiguration;
import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.common.HttpMethod;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.alibaba.sdk.android.oss.common.auth.OSSCredentialProvider;
import com.alibaba.sdk.android.oss.common.auth.OSSCustomSignerCredentialProvider;
import com.alibaba.sdk.android.oss.common.auth.OSSFederationCredentialProvider;
import com.alibaba.sdk.android.oss.common.auth.OSSFederationToken;
import com.alibaba.sdk.android.oss.common.auth.OSSPlainTextAKSKCredentialProvider;
import com.alibaba.sdk.android.oss.common.auth.OSSStsTokenCredentialProvider;
import com.alibaba.sdk.android.oss.common.utils.DateUtil;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.alibaba.sdk.android.oss.common.utils.HttpUtil;
import com.alibaba.sdk.android.oss.common.utils.OSSUtils;
import com.alibaba.sdk.android.oss.model.GeneratePresignedUrlRequest;
import com.xiaopeng.montecarlo.navcore.location.LocationUtils;
import java.net.URI;
import java.util.LinkedHashMap;
import java.util.Map;
import org.eclipse.paho.client.mqttv3.MqttTopic;
/* loaded from: classes.dex */
public class ObjectURLPresigner {
    private ClientConfiguration conf;
    private OSSCredentialProvider credentialProvider;
    private URI endpoint;

    public ObjectURLPresigner(URI uri, OSSCredentialProvider oSSCredentialProvider, ClientConfiguration clientConfiguration) {
        this.endpoint = uri;
        this.credentialProvider = oSSCredentialProvider;
        this.conf = clientConfiguration;
    }

    public String presignConstrainedURL(GeneratePresignedUrlRequest generatePresignedUrlRequest) throws ClientException {
        String sign;
        String bucketName = generatePresignedUrlRequest.getBucketName();
        String key = generatePresignedUrlRequest.getKey();
        String valueOf = String.valueOf((DateUtil.getFixedSkewedTimeMillis() / 1000) + generatePresignedUrlRequest.getExpiration());
        HttpMethod method = generatePresignedUrlRequest.getMethod() != null ? generatePresignedUrlRequest.getMethod() : HttpMethod.GET;
        RequestMessage requestMessage = new RequestMessage();
        requestMessage.setEndpoint(this.endpoint);
        requestMessage.setMethod(method);
        requestMessage.setBucketName(bucketName);
        requestMessage.setObjectKey(key);
        requestMessage.getHeaders().put("Date", valueOf);
        if (generatePresignedUrlRequest.getContentType() != null && !generatePresignedUrlRequest.getContentType().trim().equals("")) {
            requestMessage.getHeaders().put("Content-Type", generatePresignedUrlRequest.getContentType());
        }
        if (generatePresignedUrlRequest.getContentMD5() != null && !generatePresignedUrlRequest.getContentMD5().trim().equals("")) {
            requestMessage.getHeaders().put(HttpHeaders.CONTENT_MD5, generatePresignedUrlRequest.getContentMD5());
        }
        if (generatePresignedUrlRequest.getQueryParameter() != null && generatePresignedUrlRequest.getQueryParameter().size() > 0) {
            for (Map.Entry<String, String> entry : generatePresignedUrlRequest.getQueryParameter().entrySet()) {
                requestMessage.getParameters().put(entry.getKey(), entry.getValue());
            }
        }
        if (generatePresignedUrlRequest.getProcess() != null && !generatePresignedUrlRequest.getProcess().trim().equals("")) {
            requestMessage.getParameters().put(RequestParameters.X_OSS_PROCESS, generatePresignedUrlRequest.getProcess());
        }
        OSSFederationToken oSSFederationToken = null;
        OSSCredentialProvider oSSCredentialProvider = this.credentialProvider;
        if (oSSCredentialProvider instanceof OSSFederationCredentialProvider) {
            oSSFederationToken = ((OSSFederationCredentialProvider) oSSCredentialProvider).getValidFederationToken();
            requestMessage.getParameters().put(RequestParameters.SECURITY_TOKEN, oSSFederationToken.getSecurityToken());
            if (oSSFederationToken == null) {
                throw new ClientException("Can not get a federation token!");
            }
        } else if (oSSCredentialProvider instanceof OSSStsTokenCredentialProvider) {
            oSSFederationToken = ((OSSStsTokenCredentialProvider) oSSCredentialProvider).getFederationToken();
            requestMessage.getParameters().put(RequestParameters.SECURITY_TOKEN, oSSFederationToken.getSecurityToken());
        }
        String buildCanonicalString = OSSUtils.buildCanonicalString(requestMessage);
        OSSCredentialProvider oSSCredentialProvider2 = this.credentialProvider;
        if ((oSSCredentialProvider2 instanceof OSSFederationCredentialProvider) || (oSSCredentialProvider2 instanceof OSSStsTokenCredentialProvider)) {
            sign = OSSUtils.sign(oSSFederationToken.getTempAK(), oSSFederationToken.getTempSK(), buildCanonicalString);
        } else if (oSSCredentialProvider2 instanceof OSSPlainTextAKSKCredentialProvider) {
            sign = OSSUtils.sign(((OSSPlainTextAKSKCredentialProvider) oSSCredentialProvider2).getAccessKeyId(), ((OSSPlainTextAKSKCredentialProvider) this.credentialProvider).getAccessKeySecret(), buildCanonicalString);
        } else if (oSSCredentialProvider2 instanceof OSSCustomSignerCredentialProvider) {
            sign = ((OSSCustomSignerCredentialProvider) oSSCredentialProvider2).signContent(buildCanonicalString);
        } else {
            throw new ClientException("Unknown credentialProvider!");
        }
        String substring = sign.split(LocationUtils.DR_RECORD_VALUE_SPLIT_CHAR)[0].substring(4);
        String str = sign.split(LocationUtils.DR_RECORD_VALUE_SPLIT_CHAR)[1];
        String buildCanonicalHost = buildCanonicalHost(this.endpoint, bucketName, this.conf);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("Expires", valueOf);
        linkedHashMap.put(RequestParameters.OSS_ACCESS_KEY_ID, substring);
        linkedHashMap.put(RequestParameters.SIGNATURE, str);
        linkedHashMap.putAll(requestMessage.getParameters());
        String paramToQueryString = HttpUtil.paramToQueryString(linkedHashMap, "utf-8");
        return this.endpoint.getScheme() + "://" + buildCanonicalHost + MqttTopic.TOPIC_LEVEL_SEPARATOR + HttpUtil.urlEncode(key, "utf-8") + "?" + paramToQueryString;
    }

    public String presignConstrainedURL(String str, String str2, long j) throws ClientException {
        GeneratePresignedUrlRequest generatePresignedUrlRequest = new GeneratePresignedUrlRequest(str, str2);
        generatePresignedUrlRequest.setExpiration(j);
        return presignConstrainedURL(generatePresignedUrlRequest);
    }

    public String presignPublicURL(String str, String str2) {
        String buildCanonicalHost = buildCanonicalHost(this.endpoint, str, this.conf);
        return this.endpoint.getScheme() + "://" + buildCanonicalHost + MqttTopic.TOPIC_LEVEL_SEPARATOR + HttpUtil.urlEncode(str2, "utf-8");
    }

    private String buildCanonicalHost(URI uri, String str, ClientConfiguration clientConfiguration) {
        String str2;
        String host = uri.getHost();
        String path = uri.getPath();
        int port = uri.getPort();
        String valueOf = port != -1 ? String.valueOf(port) : null;
        boolean z = false;
        if (TextUtils.isEmpty(valueOf)) {
            str2 = host;
        } else {
            str2 = host + LocationUtils.DR_RECORD_VALUE_SPLIT_CHAR + valueOf;
        }
        if (!TextUtils.isEmpty(str)) {
            if (OSSUtils.isOssOriginHost(host)) {
                str2 = str + "." + host;
            } else if (OSSUtils.isInCustomCnameExcludeList(host, clientConfiguration.getCustomCnameExcludeList())) {
                if (clientConfiguration.isPathStyleAccessEnable()) {
                    z = true;
                } else {
                    str2 = str + "." + host;
                }
            } else {
                try {
                    z = OSSUtils.isValidateIP(host);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        if (clientConfiguration.isCustomPathPrefixEnable() && path != null) {
            str2 = str2 + path;
        }
        if (z) {
            return str2 + MqttTopic.TOPIC_LEVEL_SEPARATOR + str;
        }
        return str2;
    }
}
