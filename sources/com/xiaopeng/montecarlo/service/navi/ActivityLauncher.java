package com.xiaopeng.montecarlo.service.navi;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.xiaopeng.montecarlo.IntentActions;
import com.xiaopeng.montecarlo.MainActivity;
import com.xiaopeng.montecarlo.navcore.search.param.CPSearchParam;
import com.xiaopeng.montecarlo.navcore.speech.voicefusion.VoiceFusionUtil;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.service.navi.type.Request;
/* loaded from: classes3.dex */
public class ActivityLauncher implements IActivityLauncher {
    public static L.Tag TAG = new L.Tag("ActivityLauncher");
    private final Context mContext;

    public ActivityLauncher(Context context) {
        this.mContext = context;
    }

    @Override // com.xiaopeng.montecarlo.service.navi.IActivityLauncher
    public void startMainActivity(Bundle bundle, Request request) {
        Intent intent = new Intent(this.mContext, MainActivity.class);
        Bundle bundle2 = new Bundle();
        int what = request.getWhat();
        if (what == 2) {
            double d = bundle.getDouble(CPSearchParam.PARAM_KEY_LAT);
            double d2 = bundle.getDouble(CPSearchParam.PARAM_KEY_LON);
            bundle2.putString(IntentActions.ActionsKey.KEY_URI, "xpengmap://map/navi?data={\"dest\":{\"lat\":" + d + ",\"lon\":" + d2 + "}}&src=" + request.getApp_id());
            L.Tag tag = NaviService.TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("ActivityLauncher startMainActivity Uri:");
            sb.append(bundle2.getString(IntentActions.ActionsKey.KEY_URI));
            L.i(tag, sb.toString());
            bundle2.putString(IntentActions.ActionsKey.KEY_ACTION, IntentActions.ACTION_CRUISE_CARD_DISPATCH);
            intent.putExtras(bundle2);
            ContextUtils.startActivityWithNewTask(intent);
        } else if (what == 5) {
            bundle2.putString(IntentActions.ActionsKey.KEY_URI, "xpengmap://map/search/main");
            L.Tag tag2 = NaviService.TAG;
            L.i(tag2, "ActivityLauncher startMainActivity PARSER_TYPE_SEARCH_START Uri:" + bundle2.getString(IntentActions.ActionsKey.KEY_URI));
            bundle2.putString(IntentActions.ActionsKey.KEY_ACTION, IntentActions.ACTION_CRUISE_CARD_DISPATCH);
            intent.putExtras(bundle2);
            ContextUtils.startActivityWithNewTask(intent);
        } else if (what != 6) {
            if (what != 7) {
                return;
            }
            ContextUtils.startActivityWithNewTask(intent);
        } else if (bundle == null) {
        } else {
            String string = bundle.getString(VoiceFusionUtil.KEY_KEYWORD);
            String string2 = bundle.getString("category");
            bundle2.putString(IntentActions.ActionsKey.KEY_URI, "xpengmap://map/search/category?data={\"keyword\":" + string + ",\"category\":" + string2 + "}");
            L.Tag tag3 = NaviService.TAG;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("ActivityLauncher startMainActivity PARSER_TYPE_CATEGORY_SEARCH Uri:");
            sb2.append(bundle2.getString(IntentActions.ActionsKey.KEY_URI));
            L.i(tag3, sb2.toString());
            bundle2.putString(IntentActions.ActionsKey.KEY_ACTION, IntentActions.ACTION_CRUISE_CARD_DISPATCH);
            intent.putExtras(bundle2);
            ContextUtils.startActivityWithNewTask(intent);
        }
    }
}
