package com.xiaopeng.montecarlo.navcore.util;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.drawable.DrawableCompat;
import com.autonavi.gbl.map.layer.model.LayerTexture;
import com.xiaopeng.montecarlo.navcore.R;
import com.xiaopeng.montecarlo.navcore.mapdisplay.MapViewWrapper;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.bitmapfactory.BitmapFactoryResult;
import com.xiaopeng.montecarlo.root.util.bitmapfactory.BitmapFactoryXP;
import com.xiaopeng.montecarlo.root.util.bitmapfactory.DecodeResourceParam;
/* loaded from: classes2.dex */
public class MarkUtils {
    public static final int MARKER_ID_3D_ARROWTEXID = 75;
    public static final int MARKER_ID_3D_BG = 76;
    public static final int MARKER_ID_3D_BG_IMMERSION = 77;
    public static final int MARKER_ID_3D_FILLTEXID = 74;
    public static final int MARKER_ID_ARROW = 66;
    public static final int MARKER_ID_ARROW_IN = 3;
    public static final int MARKER_ID_ARROW_OUT = 2;
    public static final int MARKER_ID_BLOCK_EVENT = 480;
    public static final int MARKER_ID_BUBBLE_AMAPFLASH = 72;
    public static final int MARKER_ID_BUBBLE_CAR = 70;
    public static final int MARKER_ID_BUBBLE_DIR = 71;
    public static final int MARKER_ID_BUBBLE_END = 19;
    public static final int MARKER_ID_BUBBLE_FOCUSED_VIA = 333;
    public static final int MARKER_ID_BUBBLE_FOCUS_VIA_CHARGE = 361;
    public static final int MARKER_ID_BUBBLE_PASSED_FOCUSED_VIA = 357;
    public static final int MARKER_ID_BUBBLE_PASSED_FOCUS_VIA_CHARGE = 359;
    public static final int MARKER_ID_BUBBLE_PASSED_VIA = 345;
    public static final int MARKER_ID_BUBBLE_PASSED_VIA_CHARGE = 358;
    public static final int MARKER_ID_BUBBLE_START = 18;
    public static final int MARKER_ID_BUBBLE_VIA = 321;
    public static final int MARKER_ID_BUBBLE_VIA_CHARGE = 360;
    public static final int MARKER_ID_CAMERA = 21;
    public static final int MARKER_ID_CAR = 81;
    public static final int MARKER_ID_CAR_DIRECTION = 1;
    public static final int MARKER_ID_CAR_DIRECTION_LIGHT = 284;
    public static final int MARKER_ID_CAR_EAGLEYE_END = 490;
    public static final int MARKER_ID_CAR_END = 285;
    public static final int MARKER_ID_CAR_FLASH = 286;
    public static final int MARKER_ID_CAR_LINE = 67;
    public static final int MARKER_ID_CAR_NAVIGATION = 293;
    public static final int MARKER_ID_CAR_NAVIGATION_3D = 294;
    public static final int MARKER_ID_CAR_NAVIGATION_EAGLEYE = 489;
    public static final int MARKER_ID_CAR_NAVIGATION_IN_CROSS = 295;
    public static final int MARKER_ID_CAR_TEAM = 48;
    public static final int MARKER_ID_COMPANY = 364;
    public static final int MARKER_ID_COMPANY_NIGHT = 365;
    public static final int MARKER_ID_CRUISE_EDOG = 60;
    public static final int MARKER_ID_CRUISE_FAC = 50;
    public static final int MARKER_ID_CRUISE_LANE = 36;
    public static final int MARKER_ID_CRUISE_TRAFFIC = 469;
    public static final int MARKER_ID_DEBUG_DR = 449;
    public static final int MARKER_ID_DEBUG_DR_TRACE = 451;
    public static final int MARKER_ID_DEBUG_GPS = 448;
    public static final int MARKER_ID_DEBUG_GPS_TRACE = 450;
    public static final int MARKER_ID_DOT_CAR = 69;
    public static final int MARKER_ID_EDOG = 309;
    public static final int MARKER_ID_EDOG_TRAFFIC = 22;
    public static final int MARKER_ID_END = 79;
    public static final int MARKER_ID_ETA_EVENT = 474;
    public static final int MARKER_ID_FAVOURITE = 366;
    public static final int MARKER_ID_FAVOURITE_FOCUS = 368;
    public static final int MARKER_ID_FAVOURITE_FOCUS_NIGHT = 369;
    public static final int MARKER_ID_FAVOURITE_NIGHT = 367;
    public static final int MARKER_ID_GPS_TRACKER = 73;
    public static final int MARKER_ID_GUIDE_EVENT = 484;
    public static final int MARKER_ID_HOME = 362;
    public static final int MARKER_ID_HOME_NIGHT = 363;
    public static final int MARKER_ID_INTERVAL_CAMERA_BEGIN = 298;
    public static final int MARKER_ID_INTERVAL_CAMERA_END = 299;
    public static final int MARKER_ID_JAM_EVENT = 27;
    public static final int MARKER_ID_LR_BAD = 62;
    public static final int MARKER_ID_MAP_AOLR = 68;
    public static final int MARKER_ID_MAP_BAD = 65;
    public static final int MARKER_ID_MAP_DARK = 63;
    public static final int MARKER_ID_MAP_LR = 64;
    public static final int MARKER_ID_MAP_SLOW = 61;
    public static final int MARKER_ID_MAP_STOP_EXIT_LINE = 42;
    public static final int MARKER_ID_MARK_POINT_DJI_FOCUS = 12;
    public static final int MARKER_ID_MARK_POINT_DJI_USUAL = 11;
    public static final int MARKER_ID_MARK_POINT_NORMAL = 402;
    public static final int MARKER_ID_MIX_ROAD = 17;
    public static final int MARKER_ID_MIX_ROAD_MAX = 405;
    public static final int MARKER_ID_NAVI_ALONG = 34;
    public static final int MARKER_ID_NAVI_END = 80;
    public static final int MARKER_ID_NEW_ROAD = 24;
    public static final int MARKER_ID_NORMAL_ROAD = 37;
    public static final int MARKER_ID_OLD_ROAD = 23;
    public static final int MARKER_ID_PARKING = 28;
    public static final int MARKER_ID_POI_10_USUAL = 47;
    public static final int MARKER_ID_POI_11_FOCUS = 41;
    public static final int MARKER_ID_POI_11_USUAL = 40;
    public static final int MARKER_ID_POI_9_FOCUS = 46;
    public static final int MARKER_ID_POI_9_USUAL = 45;
    public static final int MARKER_ID_POP_EVENT = 35;
    public static final int MARKER_ID_QUICK_ROAD = 38;
    public static final int MARKER_ID_RECOMMEND_CHARGE_AROUND_FAST = 487;
    public static final int MARKER_ID_RECOMMEND_CHARGE_AROUND_SLOW = 488;
    public static final int MARKER_ID_RECOMMEND_CHARGE_AROUND_XP = 486;
    public static final int MARKER_ID_RECOMMEND_CHARGE_FREQUENT = 485;
    public static final int MARKER_ID_RECOMMEND_PARK_1 = 287;
    public static final int MARKER_ID_RECOMMEND_PARK_2 = 288;
    public static final int MARKER_ID_RECOMMEND_PARK_3 = 289;
    public static final int MARKER_ID_RECOMMEND_PARK_FOCUS_1 = 290;
    public static final int MARKER_ID_RECOMMEND_PARK_FOCUS_2 = 291;
    public static final int MARKER_ID_RECOMMEND_PARK_FOCUS_3 = 292;
    public static final int MARKER_ID_ROADNAME_LEFT_DAY = 16;
    public static final int MARKER_ID_ROUTE_BOARDER_LINE_TEXTURE = 437;
    public static final int MARKER_ID_ROUTE_CHARGE_FOCUS_LAST_REACHABLE = 496;
    public static final int MARKER_ID_ROUTE_CHARGE_FOCUS_REACHABLE = 498;
    public static final int MARKER_ID_ROUTE_CHARGE_FOCUS_SELECT_LAST_REACHABLE = 497;
    public static final int MARKER_ID_ROUTE_CHARGE_FOCUS_SELECT_REACHABLE = 499;
    public static final int MARKER_ID_ROUTE_CHARGE_FOCUS_UN_REACHABLE = 500;
    public static final int MARKER_ID_ROUTE_CHARGE_LAST_REACHABLE = 491;
    public static final int MARKER_ID_ROUTE_CHARGE_REACHABLE = 492;
    public static final int MARKER_ID_ROUTE_CHARGE_SELECT_LAST_REACHABLE = 494;
    public static final int MARKER_ID_ROUTE_CHARGE_SELECT_REACHABLE = 495;
    public static final int MARKER_ID_ROUTE_CHARGE_UN_REACHABLE = 493;
    public static final int MARKER_ID_ROUTE_FILL_LINE_TEXTURE = 421;
    public static final int MARKER_ID_ROUTE_TRAFFIC_EVENT = 445;
    public static final int MARKER_ID_SEARCH_AROUNT_POI_CENTER = 446;
    public static final int MARKER_ID_SEARCH_AROUNT_POI_CENTER_NIGHT = 447;
    public static final int MARKER_ID_SEARCH_CHARGE_FOCUS = 283;
    public static final int MARKER_ID_SEARCH_CHARGE_USUAL = 233;
    public static final int MARKER_ID_SEARCH_POI_1_FOCUS = 6;
    public static final int MARKER_ID_SEARCH_POI_1_USUAL = 5;
    public static final int MARKER_ID_SEARCH_POI_2_FOCUS = 8;
    public static final int MARKER_ID_SEARCH_POI_2_USUAL = 7;
    public static final int MARKER_ID_SEARCH_POI_3_FOCUS = 10;
    public static final int MARKER_ID_SEARCH_POI_3_USUAL = 9;
    public static final int MARKER_ID_SEARCH_POI_5_FOCUS = 14;
    public static final int MARKER_ID_SEARCH_POI_5_USUAL = 13;
    public static final int MARKER_ID_SEARCH_POI_FOCUS = 183;
    public static final int MARKER_ID_SEARCH_POI_SINGLE_FOCUS = 83;
    public static final int MARKER_ID_SEARCH_POI_SINGLE_USUAL = 82;
    public static final int MARKER_ID_SEARCH_POI_USUAL = 133;
    public static final int MARKER_ID_START = 78;
    public static final int MARKER_ID_TIE_1 = 296;
    public static final int MARKER_ID_TIE_2 = 297;
    public static final int MARKER_ID_TRAFFIC_EVENT = 25;
    public static final int MARKER_ID_TRAFFIC_FACILITY = 401;
    public static final int MARKER_ID_VIA = 20;
    public static final int MARKER_ID_VPA_POINT_FOCUS = 44;
    public static final int MARKER_ID_VPA_POINT_USUAL = 43;
    public static final int MARKER_ID_YONG_DU = 33;
    public static final int MARKER_ID_ZOOM_COR = 4;
    public static final int MARKER_POINT_ODD_END = 30;
    public static final int MARKER_POINT_ODD_START = 29;
    public static final int MAX_CHARGER_COUNT = 50;
    public static final int MAX_SEARCH_RESULT_COUNT = 50;
    private static final L.Tag TAG = new L.Tag("MarkUtils");

    public static void createMakerByText(@NonNull MapViewWrapper mapViewWrapper, String str, int i, int i2, boolean z, boolean z2) {
        if ((z2 || z || !mapViewWrapper.mapTextureCacheContains(i2)) && mapViewWrapper.getGLMapView() != null) {
            Bitmap bitmap = null;
            View inflate = View.inflate(ContextUtils.getContext(), R.layout.layout_texture_text, null);
            TextView textView = (TextView) inflate.findViewById(R.id.tx_texture_id);
            textView.setText(str);
            textView.setBackgroundColor(ContextUtils.getColor(R.color.auto_color_f36472));
            if (i != 0) {
                Drawable drawable = ContextUtils.getDrawable(i);
                drawable.setBounds(0, 0, 32, 32);
                textView.setCompoundDrawables(drawable, null, null, null);
            }
            inflate.setDrawingCacheEnabled(true);
            inflate.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            inflate.layout(0, 0, inflate.getMeasuredWidth(), inflate.getMeasuredHeight());
            LayerTexture layerTexture = new LayerTexture();
            layerTexture.isPreMulAlpha = true;
            layerTexture.resID = i2;
            layerTexture.anchorType = 9;
            try {
                try {
                    bitmap = Bitmap.createBitmap(inflate.getDrawingCache(true));
                    layerTexture.width = bitmap.getWidth();
                    layerTexture.height = bitmap.getHeight();
                    layerTexture.dataBuff = CommonUtil.bitmap2BinaryStream(bitmap);
                } catch (Exception e) {
                    L.Tag tag = TAG;
                    L.w(tag, "createMakerByText" + str + ": " + e);
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inDensity = 1;
                    options.inTargetDensity = 1;
                    Bitmap bitmapFromResId = getBitmapFromResId(R.drawable.bubble_sticker_danger_big, options);
                    if (bitmapFromResId != null) {
                        layerTexture.width = bitmapFromResId.getWidth();
                        layerTexture.height = bitmapFromResId.getHeight();
                        layerTexture.dataBuff = CommonUtil.bitmap2BinaryStream(bitmapFromResId);
                    }
                }
                layerTexture.xRatio = 0.5f;
                layerTexture.yRatio = 0.5f;
                if (z2) {
                    mapViewWrapper.updateOverlayTexture(layerTexture, z);
                } else {
                    mapViewWrapper.addOverlayTexture(layerTexture, z);
                }
                if (bitmap == null || bitmap.isRecycled()) {
                    return;
                }
                bitmap.recycle();
            } finally {
                inflate.destroyDrawingCache();
            }
        }
    }

    public static void createMakerByView(@NonNull MapViewWrapper mapViewWrapper, @NonNull View view, int i, float f, float f2, boolean z, boolean z2, boolean z3) {
        Bitmap createBitmapByView;
        Bitmap createScaledBitmap;
        if ((!z2 && !z && mapViewWrapper.mapTextureCacheContains(i)) || mapViewWrapper.getGLMapView() == null || (createBitmapByView = createBitmapByView(view)) == null) {
            return;
        }
        if (z3 && (createScaledBitmap = Bitmap.createScaledBitmap(createBitmapByView, (createBitmapByView.getWidth() * 70) / 100, (createBitmapByView.getHeight() * 70) / 100, true)) != null) {
            createBitmapByView.recycle();
            createBitmapByView = createScaledBitmap;
        }
        LayerTexture layerTexture = new LayerTexture();
        layerTexture.isPreMulAlpha = true;
        layerTexture.resID = i;
        layerTexture.anchorType = 9;
        layerTexture.width = createBitmapByView.getWidth();
        layerTexture.height = createBitmapByView.getHeight();
        layerTexture.dataBuff = CommonUtil.bitmap2BinaryStream(createBitmapByView);
        layerTexture.iconType = 2;
        layerTexture.xRatio = f;
        layerTexture.yRatio = f2;
        if (z2) {
            mapViewWrapper.updateOverlayTexture(layerTexture, z);
        } else {
            mapViewWrapper.addOverlayTexture(layerTexture, z);
        }
        createBitmapByView.recycle();
        mapViewWrapper.resetTickCount(1);
    }

    public static synchronized Bitmap createBitmapByView(@NonNull View view) {
        Bitmap bitmap;
        synchronized (MarkUtils.class) {
            view.setDrawingCacheEnabled(true);
            view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
            bitmap = null;
            try {
                bitmap = Bitmap.createBitmap(view.getDrawingCache(true));
            } catch (Exception e) {
                e.printStackTrace();
                L.Tag tag = TAG;
                L.w(tag, "createMakerByViewSync:" + e);
            }
            view.destroyDrawingCache();
        }
        return bitmap;
    }

    public static void createMakerByViewSync(@NonNull final MapViewWrapper mapViewWrapper, @NonNull View view, final int i, final float f, final float f2, final boolean z, final boolean z2, boolean z3) {
        final Bitmap createBitmapByView;
        if ((!z2 && !z && mapViewWrapper.mapTextureCacheContains(i)) || mapViewWrapper.getGLMapView() == null || (createBitmapByView = createBitmapByView(view)) == null || createBitmapByView.isRecycled()) {
            return;
        }
        if (z3) {
            BitmapFactoryXP.createScaledBitmapAsync(createBitmapByView, (createBitmapByView.getWidth() * 70) / 100, (createBitmapByView.getHeight() * 70) / 100, true, new BitmapFactoryXP.IDecodeResultListener() { // from class: com.xiaopeng.montecarlo.navcore.util.MarkUtils.1
                @Override // com.xiaopeng.montecarlo.root.util.bitmapfactory.BitmapFactoryXP.IDecodeResultListener
                public void onDecodeSuccess(BitmapFactoryResult bitmapFactoryResult) {
                    if (bitmapFactoryResult.mBitmap == null || bitmapFactoryResult.mBitmap.isRecycled()) {
                        L.w(MarkUtils.TAG, "result.mBitmap error");
                    } else {
                        LayerTexture layerTexture = new LayerTexture();
                        layerTexture.isPreMulAlpha = true;
                        layerTexture.resID = i;
                        layerTexture.anchorType = 9;
                        layerTexture.width = bitmapFactoryResult.mBitmap.getWidth();
                        layerTexture.height = bitmapFactoryResult.mBitmap.getHeight();
                        layerTexture.dataBuff = CommonUtil.bitmap2BinaryStream(bitmapFactoryResult.mBitmap);
                        layerTexture.iconType = 2;
                        layerTexture.xRatio = f;
                        layerTexture.yRatio = f2;
                        if (z2) {
                            mapViewWrapper.updateOverlayTexture(layerTexture, z);
                        } else {
                            mapViewWrapper.addOverlayTexture(layerTexture, z);
                        }
                        bitmapFactoryResult.mBitmap.recycle();
                        bitmapFactoryResult.mBitmap = null;
                    }
                    Bitmap bitmap = createBitmapByView;
                    if (bitmap == null || bitmap.isRecycled()) {
                        return;
                    }
                    createBitmapByView.recycle();
                }

                @Override // com.xiaopeng.montecarlo.root.util.bitmapfactory.BitmapFactoryXP.IDecodeResultListener
                public void onComplete() {
                    mapViewWrapper.resetTickCount(1);
                }
            });
            return;
        }
        LayerTexture layerTexture = new LayerTexture();
        layerTexture.isPreMulAlpha = true;
        layerTexture.resID = i;
        layerTexture.anchorType = 9;
        layerTexture.width = createBitmapByView.getWidth();
        layerTexture.height = createBitmapByView.getHeight();
        layerTexture.dataBuff = CommonUtil.bitmap2BinaryStream(createBitmapByView);
        layerTexture.iconType = 2;
        layerTexture.xRatio = f;
        layerTexture.yRatio = f2;
        if (z2) {
            mapViewWrapper.updateOverlayTexture(layerTexture, z);
        } else {
            mapViewWrapper.addOverlayTexture(layerTexture, z);
        }
        createBitmapByView.recycle();
    }

    public static void createMakerWithTextAndBg(@NonNull MapViewWrapper mapViewWrapper, @NonNull String str, int i, int i2, boolean z, int i3, int i4, int i5, int i6, boolean z2, boolean z3, boolean z4) {
        Bitmap decodeResource;
        Bitmap createScaledBitmap;
        if ((z3 || z2 || !mapViewWrapper.mapTextureCacheContains(i6)) && mapViewWrapper.getGLMapView() != null) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inDensity = 1;
            options.inTargetDensity = 1;
            Drawable drawable = ContextUtils.getContext().getResources().getDrawable(i5, null);
            if (drawable != null && (drawable instanceof VectorDrawable)) {
                if (Build.VERSION.SDK_INT < 21) {
                    drawable = DrawableCompat.wrap(drawable).mutate();
                }
                decodeResource = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(decodeResource);
                drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                drawable.draw(canvas);
            } else {
                decodeResource = BitmapFactory.decodeResource(ContextUtils.getContext().getResources(), i5, options);
            }
            if (decodeResource != null) {
                Bitmap.Config config = decodeResource.getConfig();
                if (config == null) {
                    config = Bitmap.Config.ARGB_8888;
                }
                Bitmap copy = decodeResource.copy(config, true);
                Paint paint = new Paint((z ? 32 : 0) | 1);
                paint.setColor(ContextUtils.getColor(i));
                paint.setTextSize(i2);
                Rect rect = new Rect();
                paint.getTextBounds(str, 0, str.length(), rect);
                paint.setDither(true);
                paint.setFilterBitmap(true);
                new Canvas(copy).drawText(str, ((copy.getWidth() - rect.width()) / 2) + i3, ((copy.getHeight() + rect.height()) / 2) + i4, paint);
                decodeResource.recycle();
                if (z4 && (createScaledBitmap = Bitmap.createScaledBitmap(copy, (copy.getWidth() * 70) / 100, (copy.getHeight() * 70) / 100, true)) != null) {
                    copy.recycle();
                    copy = createScaledBitmap;
                }
                LayerTexture layerTexture = new LayerTexture();
                layerTexture.isPreMulAlpha = true;
                layerTexture.resID = i6;
                layerTexture.anchorType = 9;
                layerTexture.isGenMipmaps = false;
                layerTexture.isRepeat = false;
                layerTexture.xRatio = 0.5f;
                layerTexture.yRatio = 0.814f;
                layerTexture.width = copy.getWidth();
                layerTexture.height = copy.getHeight();
                layerTexture.dataBuff = CommonUtil.bitmap2BinaryStream(copy);
                layerTexture.iconType = 2;
                if (z3) {
                    mapViewWrapper.updateOverlayTexture(layerTexture, z2);
                } else {
                    mapViewWrapper.addOverlayTexture(layerTexture, z2);
                }
                copy.recycle();
                mapViewWrapper.resetTickCount(1);
            }
        }
    }

    public static void createMakerWithBg(@NonNull MapViewWrapper mapViewWrapper, int i, int i2, boolean z, boolean z2) {
        createMakerWithBg(mapViewWrapper, i, i2, z, false, z2);
    }

    public static void createMakerWithBg(@NonNull MapViewWrapper mapViewWrapper, int i, int i2, boolean z, boolean z2, boolean z3) {
        Bitmap decodeResource;
        Bitmap createScaledBitmap;
        if ((z2 || z || !mapViewWrapper.mapTextureCacheContains(i2)) && mapViewWrapper.getGLMapView() != null) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inDensity = 1;
            options.inTargetDensity = 1;
            Drawable drawable = ContextUtils.getContext().getResources().getDrawable(i, null);
            if (drawable != null && (drawable instanceof VectorDrawable)) {
                if (Build.VERSION.SDK_INT < 21) {
                    drawable = DrawableCompat.wrap(drawable).mutate();
                }
                decodeResource = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(decodeResource);
                drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                drawable.draw(canvas);
            } else {
                decodeResource = BitmapFactory.decodeResource(ContextUtils.getContext().getResources(), i, options);
            }
            if (decodeResource != null) {
                if (z3 && (createScaledBitmap = Bitmap.createScaledBitmap(decodeResource, (decodeResource.getWidth() * 70) / 100, (decodeResource.getHeight() * 70) / 100, true)) != null) {
                    decodeResource.recycle();
                    decodeResource = createScaledBitmap;
                }
                LayerTexture layerTexture = new LayerTexture();
                layerTexture.isPreMulAlpha = true;
                layerTexture.resID = i2;
                layerTexture.anchorType = 9;
                layerTexture.isGenMipmaps = false;
                layerTexture.isRepeat = false;
                layerTexture.xRatio = 0.5f;
                layerTexture.yRatio = 0.7f;
                layerTexture.width = decodeResource.getWidth();
                layerTexture.height = decodeResource.getHeight();
                layerTexture.dataBuff = CommonUtil.bitmap2BinaryStream(decodeResource);
                layerTexture.iconType = 2;
                if (z2) {
                    mapViewWrapper.updateOverlayTexture(layerTexture, z);
                } else {
                    mapViewWrapper.addOverlayTexture(layerTexture, z);
                }
                decodeResource.recycle();
                mapViewWrapper.resetTickCount(1);
            }
        }
    }

    private static void setProperTextureProperty(int i, @Nullable LayerTexture layerTexture) {
        if (layerTexture == null) {
            return;
        }
        switch (i) {
            case 1:
                layerTexture.isGenMipmaps = true;
                layerTexture.isRepeat = false;
                return;
            case 2:
            case 3:
            case 4:
            case 7:
                layerTexture.isGenMipmaps = true;
                layerTexture.isRepeat = true;
                return;
            case 5:
            case 6:
                layerTexture.isGenMipmaps = false;
                layerTexture.isRepeat = true;
                return;
            default:
                return;
        }
    }

    public static void addOverlayTexture(@NonNull MapViewWrapper mapViewWrapper, int i, int i2, int i3, float f, float f2, boolean z, boolean z2, boolean z3) {
        if ((z3 || !mapViewWrapper.mapTextureCacheContains(i)) && mapViewWrapper.getGLMapView() != null) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inDensity = 1;
            options.inTargetDensity = 1;
            Bitmap bitmapFromResId = getBitmapFromResId(i2, options);
            if (bitmapFromResId == null || bitmapFromResId.isRecycled()) {
                return;
            }
            LayerTexture layerTexture = new LayerTexture();
            layerTexture.isPreMulAlpha = true;
            layerTexture.anchorType = i3;
            layerTexture.isGenMipmaps = z;
            layerTexture.isRepeat = z2;
            layerTexture.xRatio = f;
            layerTexture.yRatio = f2;
            layerTexture.resID = i;
            layerTexture.width = bitmapFromResId.getWidth();
            layerTexture.height = bitmapFromResId.getHeight();
            layerTexture.dataBuff = CommonUtil.bitmap2BinaryStream(bitmapFromResId);
            layerTexture.iconType = 2;
            mapViewWrapper.addOverlayTexture(layerTexture, z3);
            bitmapFromResId.recycle();
        }
    }

    public static void addOverlayTextureAsync(@NonNull MapViewWrapper mapViewWrapper, int i, int i2, int i3, float f, float f2, boolean z, boolean z2, boolean z3, boolean z4) {
        Bitmap decodeResource;
        Bitmap createScaledBitmap;
        if ((z3 || !mapViewWrapper.mapTextureCacheContains(i)) && mapViewWrapper.getGLMapView() != null) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inDensity = 1;
            options.inTargetDensity = 1;
            Drawable drawable = ContextUtils.getContext().getResources().getDrawable(i2, null);
            if (drawable != null && (drawable instanceof VectorDrawable)) {
                if (Build.VERSION.SDK_INT < 21) {
                    drawable = DrawableCompat.wrap(drawable).mutate();
                }
                decodeResource = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(decodeResource);
                drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                drawable.draw(canvas);
            } else {
                decodeResource = BitmapFactory.decodeResource(ContextUtils.getContext().getResources(), i2, options);
            }
            if (decodeResource != null) {
                if (z4 && (createScaledBitmap = Bitmap.createScaledBitmap(decodeResource, (decodeResource.getWidth() * 70) / 100, (decodeResource.getHeight() * 70) / 100, true)) != null) {
                    decodeResource.recycle();
                    decodeResource = createScaledBitmap;
                }
                LayerTexture layerTexture = new LayerTexture();
                layerTexture.isPreMulAlpha = true;
                layerTexture.anchorType = i3;
                layerTexture.isGenMipmaps = z;
                layerTexture.isRepeat = z2;
                layerTexture.xRatio = f;
                layerTexture.yRatio = f2;
                layerTexture.resID = i;
                layerTexture.width = decodeResource.getWidth();
                layerTexture.height = decodeResource.getHeight();
                layerTexture.dataBuff = CommonUtil.bitmap2BinaryStream(decodeResource);
                layerTexture.iconType = 2;
                mapViewWrapper.addOverlayTexture(layerTexture, z3);
                decodeResource.recycle();
                mapViewWrapper.resetTickCount(1);
            }
        }
    }

    public static void addOverlayTexturesAsync(@NonNull final MapViewWrapper mapViewWrapper, int i, @NonNull final SparseArray<MapTextureResource> sparseArray) {
        if (mapViewWrapper.getGLMapView() == null) {
            return;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inDensity = 1;
        options.inTargetDensity = 1;
        DecodeResourceParam.Builder builder = new DecodeResourceParam.Builder(ContextUtils.getContext().getResources());
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            int keyAt = sparseArray.keyAt(i2);
            MapTextureResource mapTextureResource = sparseArray.get(keyAt);
            if (mapTextureResource == null || mapTextureResource.getResId() == -1 || mapViewWrapper.mapTextureCacheContains(keyAt)) {
                L.w(TAG, "Try to add marker texture :" + keyAt + ", but resource id is null");
            } else {
                builder.putParam(keyAt, options);
                builder.putTextureId(keyAt, mapTextureResource.getResId());
            }
        }
        builder.setIsNeedScale(false);
        builder.setScalePercent(100);
        builder.setType(4);
        BitmapFactoryXP.decodeResourceAsync(builder.build(), new BitmapFactoryXP.IDecodeResultListener() { // from class: com.xiaopeng.montecarlo.navcore.util.MarkUtils.2
            @Override // com.xiaopeng.montecarlo.root.util.bitmapfactory.BitmapFactoryXP.IDecodeResultListener
            public void onDecodeSuccess(BitmapFactoryResult bitmapFactoryResult) {
                if (bitmapFactoryResult.mResid <= 0 || bitmapFactoryResult.mTextureId <= 0) {
                    L.Tag tag = MarkUtils.TAG;
                    L.w(tag, "addOverlayTexturesAsync decodeResource but resId :" + bitmapFactoryResult.mResid + ", mTextureId: " + bitmapFactoryResult.mTextureId);
                    return;
                }
                MapTextureResource mapTextureResource2 = (MapTextureResource) sparseArray.get(bitmapFactoryResult.mTextureId);
                if (mapTextureResource2 == null || bitmapFactoryResult.mBitmap == null || bitmapFactoryResult.mBitmap.isRecycled()) {
                    L.w(MarkUtils.TAG, "addOverlayTexturesAsync decodeResource but mapTextureResource is null");
                    return;
                }
                LayerTexture layerTexture = new LayerTexture();
                layerTexture.isPreMulAlpha = true;
                layerTexture.anchorType = mapTextureResource2.getAnchor();
                layerTexture.isGenMipmaps = mapTextureResource2.isGenMimps();
                layerTexture.isRepeat = mapTextureResource2.mIsRepeat;
                layerTexture.xRatio = mapTextureResource2.getXRatio();
                layerTexture.yRatio = mapTextureResource2.getYRatio();
                layerTexture.resID = bitmapFactoryResult.mTextureId;
                layerTexture.width = bitmapFactoryResult.mBitmap.getWidth();
                layerTexture.height = bitmapFactoryResult.mBitmap.getHeight();
                layerTexture.dataBuff = CommonUtil.bitmap2BinaryStream(bitmapFactoryResult.mBitmap);
                layerTexture.iconType = 2;
                mapViewWrapper.addOverlayTexture(layerTexture, true);
                bitmapFactoryResult.mBitmap.recycle();
                bitmapFactoryResult.mBitmap = null;
            }

            @Override // com.xiaopeng.montecarlo.root.util.bitmapfactory.BitmapFactoryXP.IDecodeResultListener
            public void onComplete() {
                mapViewWrapper.resetTickCount(1);
            }
        });
    }

    public static float getCameraBgRatioX(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 5) {
                        if (i != 6) {
                            if (i != 7) {
                                if (i != 8) {
                                    return 0.0f;
                                }
                                return ContextUtils.getFloat(R.dimen.camera_ratio_x_right_down);
                            }
                            return ContextUtils.getFloat(R.dimen.camera_ratio_x_left_down);
                        }
                        return ContextUtils.getFloat(R.dimen.camera_ratio_x_left_up);
                    }
                    return ContextUtils.getFloat(R.dimen.camera_ratio_x_right_up);
                }
                return ContextUtils.getFloat(R.dimen.camera_ratio_x_right);
            }
            return ContextUtils.getFloat(R.dimen.camera_ratio_x_left);
        }
        return ContextUtils.getFloat(R.dimen.camera_ratio_x_none);
    }

    public static float getCameraBgRatioY(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 5) {
                        if (i != 6) {
                            if (i != 7) {
                                if (i != 8) {
                                    return 0.0f;
                                }
                                return ContextUtils.getFloat(R.dimen.camera_ratio_y_right_down);
                            }
                            return ContextUtils.getFloat(R.dimen.camera_ratio_y_left_down);
                        }
                        return ContextUtils.getFloat(R.dimen.camera_ratio_y_left_up);
                    }
                    return ContextUtils.getFloat(R.dimen.camera_ratio_y_right_up);
                }
                return ContextUtils.getFloat(R.dimen.camear_ratio_y_right);
            }
            return ContextUtils.getFloat(R.dimen.camear_ratio_y_left);
        }
        return ContextUtils.getFloat(R.dimen.camera_ratio_y_none);
    }

    public static float getCommonBgRatioX(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 5) {
                    if (i != 6) {
                        if (i != 7) {
                            if (i == 8) {
                                return ContextUtils.getFloat(R.dimen.comon_ratio_x_right_down);
                            }
                            return ContextUtils.getFloat(R.dimen.comon_ratio_x_left);
                        }
                        return ContextUtils.getFloat(R.dimen.comon_ratio_x_left_down);
                    }
                    return ContextUtils.getFloat(R.dimen.comon_ratio_x_left_up);
                }
                return ContextUtils.getFloat(R.dimen.comon_ratio_x_right_up);
            }
            return ContextUtils.getFloat(R.dimen.comon_ratio_x_right);
        }
        return ContextUtils.getFloat(R.dimen.comon_ratio_x_left);
    }

    public static float getCommonBgRatioY(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 5) {
                    if (i != 6) {
                        if (i != 7) {
                            if (i != 8) {
                                return 0.5f;
                            }
                            return ContextUtils.getFloat(R.dimen.comon_ratio_y_right_down);
                        }
                        return ContextUtils.getFloat(R.dimen.comon_ratio_y_left_down);
                    }
                    return ContextUtils.getFloat(R.dimen.comon_ratio_y_left_up);
                }
                return ContextUtils.getFloat(R.dimen.comon_ratio_y_right_up);
            }
            return ContextUtils.getFloat(R.dimen.comon_ratio_y_right);
        }
        return ContextUtils.getFloat(R.dimen.comon_ratio_y_left);
    }

    public static float[] getRouteLabelRatioForDirection(int i) {
        float[] fArr = new float[2];
        if (i == 1) {
            fArr[0] = ContextUtils.getFloat(R.dimen.multi_road_label_left_x);
            fArr[1] = ContextUtils.getFloat(R.dimen.multi_road_label_left_y);
        } else if (i == 2) {
            fArr[0] = ContextUtils.getFloat(R.dimen.multi_road_label_right_x);
            fArr[1] = ContextUtils.getFloat(R.dimen.multi_road_label_right_y);
        } else if (i == 5) {
            fArr[0] = ContextUtils.getFloat(R.dimen.multi_road_label_right_up_x);
            fArr[1] = ContextUtils.getFloat(R.dimen.multi_road_label_right_up_y);
        } else if (i == 6) {
            fArr[0] = ContextUtils.getFloat(R.dimen.multi_road_label_left_up_x);
            fArr[1] = ContextUtils.getFloat(R.dimen.multi_road_label_left_up_y);
        } else if (i == 7) {
            fArr[0] = ContextUtils.getFloat(R.dimen.multi_road_label_left_down_x);
            fArr[1] = ContextUtils.getFloat(R.dimen.multi_road_label_left_down_y);
        } else if (i == 8) {
            fArr[0] = ContextUtils.getFloat(R.dimen.multi_road_label_right_down_x);
            fArr[1] = ContextUtils.getFloat(R.dimen.multi_road_label_right_down_y);
        } else {
            fArr[0] = ContextUtils.getFloat(R.dimen.multi_road_label_left_x);
            fArr[1] = ContextUtils.getFloat(R.dimen.multi_road_label_left_y);
        }
        return fArr;
    }

    public static Bitmap getBitmapFromResId(int i) {
        return getBitmapFromResId(i, null);
    }

    @Nullable
    public static Bitmap getBitmapFromResId(int i, BitmapFactory.Options options) {
        Resources resources;
        Drawable drawable;
        if (i <= 0 || (resources = ContextUtils.getContext().getResources()) == null || (drawable = resources.getDrawable(i)) == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 21 && (drawable instanceof VectorDrawable)) {
            return getBitmapFromVectorDrawable(drawable);
        }
        return BitmapFactory.decodeResource(resources, i, options);
    }

    @Nullable
    public static Bitmap getBitmapFromDrawable(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            if (drawable instanceof VectorDrawable) {
                return getBitmapFromVectorDrawable(drawable);
            }
            if (drawable instanceof BitmapDrawable) {
                return ((BitmapDrawable) drawable).getBitmap();
            }
            return null;
        } else if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        } else {
            return null;
        }
    }

    private static Bitmap getBitmapFromVectorDrawable(Drawable drawable) {
        if (Build.VERSION.SDK_INT < 21) {
            drawable = DrawableCompat.wrap(drawable).mutate();
        }
        Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    /* loaded from: classes2.dex */
    public static class MapTextureResource {
        private int mAnchor;
        private boolean mIsGenMimps;
        private boolean mIsRepeat;
        private int mResId;
        private float mXRatio;
        private float mYRatio;

        public MapTextureResource(int i, float f, float f2, boolean z, boolean z2, int i2) {
            this.mResId = i2;
            this.mAnchor = i;
            this.mXRatio = f;
            this.mYRatio = f2;
            this.mIsRepeat = z;
            this.mIsGenMimps = z2;
        }

        public int getResId() {
            return this.mResId;
        }

        public void setResId(int i) {
            this.mResId = i;
        }

        public int getAnchor() {
            return this.mAnchor;
        }

        public void setAnchor(int i) {
            this.mAnchor = i;
        }

        public float getXRatio() {
            return this.mXRatio;
        }

        public void setXRatio(float f) {
            this.mXRatio = f;
        }

        public float getYRatio() {
            return this.mYRatio;
        }

        public void setYRatio(float f) {
            this.mYRatio = f;
        }

        public boolean isRepeat() {
            return this.mIsRepeat;
        }

        public void setRepeat(boolean z) {
            this.mIsRepeat = z;
        }

        public boolean isGenMimps() {
            return this.mIsGenMimps;
        }

        public void setGenMimps(boolean z) {
            this.mIsGenMimps = z;
        }
    }
}
