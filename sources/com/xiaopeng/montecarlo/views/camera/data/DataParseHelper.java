package com.xiaopeng.montecarlo.views.camera.data;

import androidx.annotation.ColorInt;
import androidx.annotation.StringRes;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.FacilityInfoProvider;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPCameraInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPFacilityInfo;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.GsonUtil;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.views.camera.CameraDataHolder;
import com.xiaopeng.montecarlo.views.camera.ICameraData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class DataParseHelper {
    private static L.Tag sTAG = new L.Tag("DataParseHelper");
    public static int SHOW_RESTRICT_SPEED_TEXT_SIZE = ContextUtils.getDimensionPixelSize(R.dimen.camera_restrict_text_size);
    public static int SHOW_RESTRICT_SPEED_NUMBER_SIZE = ContextUtils.getDimensionPixelSize(R.dimen.camera_restrict_num_size);
    public static String SHOW_RESTRICT_SPEED_TEXT_UNKOWN = "测速";
    @ColorInt
    public static int SHOW_RESTRICT_SPEED_COLOR = ContextUtils.getColor(R.color.nav_camera_content_text_color);
    @StringRes
    public static int SHOW_RESTRIC_SPEED_NUM_FONT_NAME = R.string.xp_font_number_bold;
    @StringRes
    public static int SHOW_RESTRIC_SPEED_TEXT_FONT_NAME = R.string.xp_font_medium;

    private static <T extends FacilityInfoProvider> List<ICameraData> parseCameraInfoToICameraData(List<T> list) {
        if (L.ENABLE) {
            L.Tag tag = sTAG;
            L.d(tag, "_____parseCameraInfoToICameraData" + GsonUtil.toJson(list));
        }
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            T t = list.get(i);
            if (t != null) {
                arrayList.add(new CameraDataHolder(t));
            }
        }
        return arrayList;
    }

    public static List<ICameraData> parseCruisedataList(List<XPFacilityInfo> list) {
        return parseCameraInfoToICameraData(list);
    }

    public static List<ICameraData> parseNavidataList(List<XPCameraInfo> list) {
        return parseCameraInfoToICameraData(list);
    }
}
