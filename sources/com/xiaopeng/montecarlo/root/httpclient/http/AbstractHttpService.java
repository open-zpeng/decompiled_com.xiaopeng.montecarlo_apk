package com.xiaopeng.montecarlo.root.httpclient.http;

import com.google.gson.internal.C$Gson$Types;
import com.xiaopeng.montecarlo.root.httpclient.IHttpDependency;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Set;
/* loaded from: classes2.dex */
public abstract class AbstractHttpService implements IHttpService {
    private static final String CHARSET = "utf-8";
    IHttpDependency mDependency;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractHttpService(IHttpDependency iHttpDependency) {
        this.mDependency = iHttpDependency;
    }

    public String formatParams(Map<String, Object> map) {
        StringBuilder sb = new StringBuilder();
        if (map != null) {
            Set<Map.Entry<String, Object>> entrySet = map.entrySet();
            if (CollectionUtils.isNotEmpty(entrySet)) {
                sb.append("?");
                for (Map.Entry<String, Object> entry : entrySet) {
                    try {
                        sb.append(entry.getKey());
                        sb.append("=");
                        sb.append(URLEncoder.encode(String.valueOf(entry.getValue()), "utf-8"));
                        sb.append("&");
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }
                sb.setLength(sb.length() - 1);
            }
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isStringType(Type type) {
        return String.class.isAssignableFrom(C$Gson$Types.getRawType(C$Gson$Types.canonicalize(type)));
    }
}
