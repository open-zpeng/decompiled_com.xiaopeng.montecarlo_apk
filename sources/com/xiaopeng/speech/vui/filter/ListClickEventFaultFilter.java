package com.xiaopeng.speech.vui.filter;

import android.text.TextUtils;
import com.xiaopeng.montecarlo.root.util.config.DebugConfiguration;
import com.xiaopeng.vui.commons.model.VuiElement;
import java.util.Arrays;
/* loaded from: classes3.dex */
public class ListClickEventFaultFilter extends BaseFaultFilter {
    @Override // com.xiaopeng.speech.vui.filter.IFilter
    public VuiElement doFilter(VuiElement vuiElement) {
        String[] split;
        if (vuiElement != null && !TextUtils.isEmpty(vuiElement.getId()) && vuiElement.getResultActions().contains("Click") && (split = vuiElement.getId().split(DebugConfiguration.DebugIntentActionExtra.POINT_SPLIT)) != null && split.length > 0) {
            for (String str : split) {
                if (str.length() <= 4) {
                    vuiElement.setResultActions(Arrays.asList("listItemClick"));
                }
            }
        }
        return vuiElement;
    }
}
