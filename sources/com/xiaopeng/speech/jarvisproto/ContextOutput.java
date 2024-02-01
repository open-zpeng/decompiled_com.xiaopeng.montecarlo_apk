package com.xiaopeng.speech.jarvisproto;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ContextOutput extends JarvisProto {
    public static final String EVENT = "jarvis.context.output";
    public String msgId;
    public String outputText;
    public String text;

    @Override // com.xiaopeng.speech.jarvisproto.JarvisProto
    public String getEvent() {
        return EVENT;
    }

    @Override // com.xiaopeng.speech.jarvisproto.JarvisProto
    public String getJsonData() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("text", this.text);
            jSONObject.put("outputText", this.outputText);
            jSONObject.put("msgId", this.msgId);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
