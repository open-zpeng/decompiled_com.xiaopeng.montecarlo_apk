package com.xiaopeng.speech.protocol.query.aiassistant;

import com.xiaopeng.speech.SpeechQuery;
import com.xiaopeng.speech.annotation.QueryAnnotation;
import com.xiaopeng.speech.protocol.event.query.speech.QueryAiAssistantEvent;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AiAssistantQuery extends SpeechQuery<IAiAssistantCaller> {
    /* JADX INFO: Access modifiers changed from: protected */
    @QueryAnnotation(event = QueryAiAssistantEvent.GUI_AI_VIDEO_OPEN)
    public int getAiVideoOpenStatus(String str, String str2) {
        if (str2 != null) {
            try {
                JSONObject jSONObject = new JSONObject(str2);
                return ((IAiAssistantCaller) this.mQueryCaller).getAiVideoOpenStatus(jSONObject.optString("video_name"), jSONObject.optString("video_tag"), jSONObject.optString("video_category"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }
}
