package com.xiaopeng.speech.protocol.bean;

import android.text.TextUtils;
import com.xiaopeng.montecarlo.navcore.search.param.CPSearchParam;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class FeedListUIValue {
    public static final String TYPE_ROUTE = "route";
    public int index;
    public String source;
    public String type = null;

    public static FeedListUIValue fromJson(JSONObject jSONObject) {
        FeedListUIValue feedListUIValue = new FeedListUIValue();
        if (jSONObject != null) {
            feedListUIValue.source = jSONObject.optString("source");
            feedListUIValue.index = jSONObject.optInt(CPSearchParam.PARAM_KEY_INDEX);
            if (jSONObject.has("type")) {
                feedListUIValue.type = jSONObject.optString("type");
            } else {
                feedListUIValue.type = null;
            }
        }
        return feedListUIValue;
    }

    public static String toJson(FeedListUIValue feedListUIValue) {
        if (feedListUIValue == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("source", feedListUIValue.source);
            jSONObject.put(CPSearchParam.PARAM_KEY_INDEX, feedListUIValue.index);
            if (!TextUtils.isEmpty(feedListUIValue.type)) {
                jSONObject.put("type", feedListUIValue.type);
            }
            return jSONObject.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
