package com.xiaopeng.speech.protocol.node.message.bean;

import com.xiaopeng.montecarlo.navcore.search.param.CPSearchParam;
import com.xiaopeng.speech.common.bean.BaseBean;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class IndexBean extends BaseBean {
    private int index;

    public static final IndexBean fromJson(String str) {
        IndexBean indexBean = new IndexBean();
        try {
            indexBean.index = new JSONObject(str).optInt(CPSearchParam.PARAM_KEY_INDEX);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return indexBean;
    }

    public int getIndex() {
        return this.index;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public String toString() {
        return "IndexBean{index='" + this.index + "'}";
    }
}
