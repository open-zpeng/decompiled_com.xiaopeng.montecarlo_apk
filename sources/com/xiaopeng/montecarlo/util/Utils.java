package com.xiaopeng.montecarlo.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.base.scene.IBaseScene;
import com.xiaopeng.montecarlo.bridge.ExploreBridge;
import com.xiaopeng.montecarlo.bridge.NaviBridge;
import com.xiaopeng.montecarlo.bridge.RouteBridge;
import com.xiaopeng.montecarlo.bridge.StatusConst;
import com.xiaopeng.montecarlo.constants.SystemConst;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiCategory;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.database.bean.greendao.XPKeywordConfigInfo;
import com.xiaopeng.montecarlo.navcore.search.offlinedata.XPOfflineDataManager;
import com.xiaopeng.montecarlo.navcore.setting.SettingWrapper;
import com.xiaopeng.montecarlo.navcore.speech.aios.NaviModel;
import com.xiaopeng.montecarlo.navcore.speech.voicefusion.VoiceFusionUtil;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import com.xiaopeng.montecarlo.scenes.routescene.RouteRequest;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.NumberFormat;
import java.util.List;
/* loaded from: classes3.dex */
public class Utils {
    public static final int REQUEST_CODE_BIND_AMAP = 300;
    public static final int REQUEST_CODE_ROUTE_BY_SPEECH = 1000;
    public static final int REQUEST_CODE_SEARCH = 100;
    public static final int REQUEST_CODE_SETTINGS = 200;
    private static final L.Tag TAG = new L.Tag("Utils");

    public static boolean isSwipeMenuEnable(int i, int i2) {
        return (i != 100 || i2 == 1001 || i2 == 1002) ? false : true;
    }

    public static int dp2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static float px2dp(Context context, int i) {
        return (i / context.getResources().getDisplayMetrics().density) + 0.5f;
    }

    public static int sp2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public static boolean isVisible(View view) {
        if (view != null && view.getVisibility() == 0) {
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = viewGroup.getChildAt(i);
                    if (childAt != null && childAt.getVisibility() == 0) {
                        return true;
                    }
                }
                return false;
            }
            return true;
        }
        return false;
    }

    public static String getVersionCode(Context context) {
        return context == null ? "" : RootUtil.getVersionCode();
    }

    public static String getPackageName(Context context) {
        return context == null ? "" : RootUtil.getPackageName();
    }

    public static String getAddress(XPPoiInfo xPPoiInfo) {
        if (xPPoiInfo == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder("");
        if (!TextUtils.isEmpty(xPPoiInfo.getDistrictName())) {
            sb.append(xPPoiInfo.getDistrictName());
            if (!TextUtils.isEmpty(xPPoiInfo.getAddress())) {
                sb.append(xPPoiInfo.getAddress());
            }
        } else if (!TextUtils.isEmpty(xPPoiInfo.getAddress())) {
            sb.append(xPPoiInfo.getAddress());
        }
        return sb.toString();
    }

    public static String getTimeOutText(int i, String str) {
        String format = i != 0 ? String.format("(%ds)", Integer.valueOf(i)) : "";
        return str + format;
    }

    public static void changeScrollBarStyle(Context context, View view) {
        try {
            Field declaredField = View.class.getDeclaredField("mScrollCache");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(view);
            Field declaredField2 = obj.getClass().getDeclaredField("scrollBar");
            declaredField2.setAccessible(true);
            Object obj2 = declaredField2.get(obj);
            Method declaredMethod = obj2.getClass().getDeclaredMethod("setVerticalThumbDrawable", Drawable.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(obj2, context.getResources().getDrawable(R.drawable.layer_scrollbar_indicator));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getNameOrAddress(XPPoiInfo xPPoiInfo) {
        if (xPPoiInfo == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder("");
        if (!TextUtils.isEmpty(xPPoiInfo.getName())) {
            sb.append(xPPoiInfo.getName());
        } else if (!TextUtils.isEmpty(xPPoiInfo.getAddress())) {
            sb.append(xPPoiInfo.getAddress());
        } else if (!TextUtils.isEmpty(xPPoiInfo.getDistrictName())) {
            sb.append(xPPoiInfo.getDistrictName());
        }
        return sb.toString().replaceAll("-", "");
    }

    public static int getViewBottomInWindow(@NonNull View view) {
        if (view == null) {
            throw new NullPointerException("getViewBottomInWindow view can not be null");
        }
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int bottom = iArr[1] + (view.getBottom() - view.getTop()) + view.getPaddingTop() + view.getPaddingBottom();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            try {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                bottom += marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "getViewBottomInWindow bottom:" + bottom + ",view:" + view);
        }
        return bottom;
    }

    public static int getViewTopInWindow(@NonNull View view) {
        if (view == null) {
            throw new NullPointerException("getViewTopInWindow view can not be null");
        }
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int paddingTop = iArr[1] + view.getPaddingTop();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            try {
                paddingTop += ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "getViewTopInWindow top:" + paddingTop + ",view:" + view);
        }
        return paddingTop;
    }

    public static int getViewRightInWindow(@NonNull View view) {
        if (view == null) {
            throw new NullPointerException("getViewRightInWindow view can not be null");
        }
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int right = iArr[0] + (view.getRight() - view.getLeft()) + view.getPaddingLeft() + view.getPaddingRight();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            try {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                right += marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "getViewRightInWindow right:" + right + ",view:" + view);
        }
        return right;
    }

    public static boolean isPortrait() {
        return ContextUtils.isPortrait();
    }

    public static boolean isLandscape() {
        return ContextUtils.isLandscape();
    }

    public static boolean isMapLightColumn() {
        return isLandscape() || SettingWrapper.isMapLightColumn();
    }

    public static boolean isEmptyScene(IBaseScene iBaseScene) {
        return iBaseScene.getMode() == StatusConst.Mode.EMPTY;
    }

    public static boolean isCruiseScene(IBaseScene iBaseScene) {
        return iBaseScene.getMode() == StatusConst.Mode.CRUISE;
    }

    public static boolean isDebugScene(IBaseScene iBaseScene) {
        return iBaseScene.getMode() == StatusConst.Mode.DEBUG;
    }

    public static boolean isSearchScene(IBaseScene iBaseScene) {
        return iBaseScene.getMode() == StatusConst.Mode.SEARCH || iBaseScene.getMode() == StatusConst.Mode.SET_HOME_OFFICE;
    }

    public static boolean isSearchResultScene(IBaseScene iBaseScene) {
        return iBaseScene.getMode() == StatusConst.Mode.SEARCH_RESULT;
    }

    public static boolean isContainerSearchResultScene(IBaseScene iBaseScene) {
        return iBaseScene.getMode() == StatusConst.Mode.CONTAINER_SEARCH_RESULT;
    }

    public static boolean isRouteScene(IBaseScene iBaseScene) {
        return iBaseScene.getMode() == StatusConst.Mode.ROUTE;
    }

    public static boolean isNaviScene(IBaseScene iBaseScene) {
        return iBaseScene.getMode() == StatusConst.Mode.NAVI;
    }

    public static boolean isSettingScene(IBaseScene iBaseScene) {
        return iBaseScene.getMode() == StatusConst.Mode.SETTING;
    }

    public static boolean isSettingLicensePlateScene(IBaseScene iBaseScene) {
        return iBaseScene.getMode() == StatusConst.Mode.SETTING_LICENCE_PLATE;
    }

    public static boolean isMapDownloadScene(IBaseScene iBaseScene) {
        return iBaseScene.getMode() == StatusConst.Mode.SETTING_MAP_DOWNLOAD;
    }

    public static boolean isScanSearchScene(IBaseScene iBaseScene) {
        return iBaseScene.getMode() == StatusConst.Mode.SCAN_SEARCH;
    }

    public static boolean isExploreScene(IBaseScene iBaseScene) {
        return iBaseScene.getMode() == StatusConst.Mode.EXPLORE;
    }

    public static boolean isRestrictScene(IBaseScene iBaseScene) {
        return iBaseScene.getMode() == StatusConst.Mode.RESTRICT;
    }

    public static boolean isLinkSeamlessNaviScene(IBaseScene iBaseScene) {
        return iBaseScene.getMode() == StatusConst.Mode.LINK_SEAMLESS_NAVI;
    }

    public static boolean isPopDialogScene(IBaseScene iBaseScene) {
        return iBaseScene.getMode() == StatusConst.Mode.POPDIALOG;
    }

    public static void setAppTheme() {
        try {
            ThemeWatcherUtil.init(ContextUtils.getContext());
        } catch (Exception e) {
            e.printStackTrace();
            L.Tag tag = TAG;
            L.e(tag, "setAppTheme:" + e.getMessage());
        }
    }

    public static boolean isFoodOpen() {
        List<XPKeywordConfigInfo> xPKeywordData = XPOfflineDataManager.getInstance().getXPKeywordData();
        if (xPKeywordData == null || xPKeywordData.size() <= 0) {
            return false;
        }
        for (XPKeywordConfigInfo xPKeywordConfigInfo : xPKeywordData) {
            if (xPKeywordConfigInfo != null && !TextUtils.isEmpty(xPKeywordConfigInfo.getCategory()) && xPKeywordConfigInfo.getCategory().startsWith(XPPoiCategory.SEARCH_CATEGORY_FOOD)) {
                return true;
            }
        }
        return false;
    }

    public static int getVisibleViewsBottom(View... viewArr) {
        if (viewArr == null) {
            return 0;
        }
        int i = 0;
        for (View view : viewArr) {
            if (view != null && view.getVisibility() == 0 && i < view.getBottom()) {
                i = view.getBottom();
            }
        }
        return i;
    }

    public static void dialNum(Activity activity, String str) {
        if (TextUtils.isEmpty(str)) {
            L.w(TAG, "dialNum failure num is null");
            return;
        }
        activity.startActivity(new Intent("android.intent.action.CALL", Uri.parse("tel:" + str)));
    }

    public static void startSceneForRoute(IBaseScene iBaseScene, RouteRequest routeRequest) {
        if (iBaseScene == null || routeRequest == null) {
            L.Tag tag = TAG;
            L.e(tag, "startSceneForRoute failure scene or request is null,scene:" + iBaseScene + ",request:" + routeRequest);
            return;
        }
        Bundle bundle = routeRequest.toBundle();
        if (bundle == null) {
            L.e(TAG, "startSceneForRoute failure bundle is null");
            return;
        }
        boolean z = routeRequest.getRequestFrom() == 1;
        if (z) {
            bundle.putString(SystemConst.ROUTE_TYPE_KEY, SystemConst.ROUTE_TYPE_FROM_SPEECH);
        }
        int currentStatus = TBTManager.getInstance().getCurrentStatus();
        if ((currentStatus == 1 || currentStatus == 2) && z && VoiceFusionUtil.getInstance().isVoiceFusionSupported()) {
            NaviModel.getInstance().startSpeechDialog();
        }
        if (currentStatus == 1) {
            L.Tag tag2 = TAG;
            L.i(tag2, "startSceneForRoute go to navi page isFromSpeech:" + z);
            bundle.putBoolean(SystemConst.ROUTE_MANUAL, true);
            iBaseScene.startScene(new NaviBridge().setBundle(bundle));
        } else if (currentStatus == 2) {
            L.Tag tag3 = TAG;
            L.i(tag3, "startSceneForRoute go to explore page isFromSpeech:" + z);
            iBaseScene.startScene(new ExploreBridge().setBundle(bundle));
        } else {
            L.Tag tag4 = TAG;
            L.i(tag4, "startSceneForRoute go to route page isFromSpeech:" + z);
            if (z) {
                iBaseScene.startScene(new RouteBridge().setBundle(bundle), 1000);
            } else {
                iBaseScene.startScene(new RouteBridge().setBundle(bundle));
            }
        }
    }

    public static boolean isClearFontStyle(TextView textView) {
        return textView != null && Float.compare(textView.getResources().getConfiguration().fontScale, 1.0f) == 0;
    }

    public static String floatToString(float f) {
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setMaximumFractionDigits(1);
        return numberFormat.format(f);
    }
}
