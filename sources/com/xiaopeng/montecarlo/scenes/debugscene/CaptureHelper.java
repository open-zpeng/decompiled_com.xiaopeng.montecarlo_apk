package com.xiaopeng.montecarlo.scenes.debugscene;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.NinePatchDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.autonavi.gbl.map.model.ScreenShotDataInfo;
import com.autonavi.gbl.map.observer.IEGLScreenshotObserver;
import com.xiaopeng.libtheme.ThemeManager;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.navcore.mapdisplay.MapViewWrapper;
import com.xiaopeng.montecarlo.root.provider.dataset.DataSetHelper;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.DebugCacheConsts;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import com.xiaopeng.montecarlo.root.util.UiHandlerUtil;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
import com.xiaopeng.montecarlo.root.util.ioutil.FileIOUtil;
import com.xiaopeng.montecarlo.util.ThemeWatcherUtil;
import com.xiaopeng.montecarlo.views.BatteryView;
import com.xiaopeng.montecarlo.views.TrafficBar;
import com.xiaopeng.montecarlo.views.mapmode.MapModeIconView;
import com.xiaopeng.speech.jarvisproto.DMEnd;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
/* loaded from: classes3.dex */
public class CaptureHelper {
    private static final L.Tag TAG = new L.Tag("CaptureHelper");
    private Activity mActivity;
    private Button mCaptureBtn = null;
    private IEGLScreenshotObserver mIEGLScreenshotObserver = new IEGLScreenshotObserver() { // from class: com.xiaopeng.montecarlo.scenes.debugscene.CaptureHelper.1
        @Override // com.autonavi.gbl.map.observer.IEGLScreenshotObserver
        public void onEGLScreenshot(int i, byte[] bArr, ScreenShotDataInfo screenShotDataInfo, int i2, long j) {
            View findViewById = CaptureHelper.this.mActivity.findViewById(R.id.map_view);
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            Bitmap createBitmap = Bitmap.createBitmap(findViewById.getWidth(), findViewById.getHeight(), Bitmap.Config.RGB_565);
            createBitmap.copyPixelsFromBuffer(wrap);
            CaptureHelper captureHelper = CaptureHelper.this;
            captureHelper.captureSceen(captureHelper.convertEGLBuffer(createBitmap));
        }
    };
    private Bitmap mInvalidBitmap;
    private MapViewWrapper mMapViewWrapper;

    public CaptureHelper(Activity activity, MapViewWrapper mapViewWrapper) {
        this.mActivity = null;
        this.mMapViewWrapper = null;
        this.mActivity = activity;
        this.mMapViewWrapper = mapViewWrapper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap convertEGLBuffer(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.setScale(-1.0f, 1.0f);
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        Matrix matrix2 = new Matrix();
        matrix2.setRotate(-180.0f);
        return Bitmap.createBitmap(createBitmap, 0, 0, width, height, matrix2, true);
    }

    public void showCaptureBtn() {
        Button button = this.mCaptureBtn;
        if (button == null) {
            this.mCaptureBtn = new Button(this.mActivity);
            this.mCaptureBtn.setTextSize(25.0f);
            this.mCaptureBtn.setText(ContextUtils.getString(R.string.capture_btn_text));
            this.mCaptureBtn.setTextColor(ContextUtils.getColor(R.color.red_800));
            this.mCaptureBtn.setBackground(ThemeWatcherUtil.getDrawable(R.drawable.drawable_common_common_button_background_selector));
            this.mCaptureBtn.setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.debugscene.CaptureHelper.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    CaptureHelper.this.mCaptureBtn.setEnabled(false);
                    CaptureHelper.this.mCaptureBtn.getHandler().postDelayed(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.debugscene.CaptureHelper.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            CaptureHelper.this.outPutImageSrc();
                            ScreenShotHelper.tryToScreenShot(CaptureHelper.this.mActivity);
                        }
                    }, 50L);
                    CaptureHelper.this.mMapViewWrapper.createBitmapFromGLSurface(CaptureHelper.this.mIEGLScreenshotObserver, CaptureHelper.this.mActivity.findViewById(R.id.map_view));
                }
            });
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-2, -2, 0, 0, -2);
            layoutParams.type = 99;
            layoutParams.flags = 524328;
            layoutParams.gravity = 85;
            layoutParams.x = 150;
            layoutParams.y = 120;
            ((WindowManager) this.mActivity.getSystemService("window")).addView(this.mCaptureBtn, layoutParams);
            return;
        }
        button.setEnabled(true);
        this.mCaptureBtn.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void outPutImageSrc() {
        dumpImageViewDrawable((ViewGroup) this.mActivity.findViewById(R.id.main_frame));
    }

    private Bitmap findBitmapInDrawable(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        if (drawable instanceof StateListDrawable) {
            StateListDrawable stateListDrawable = (StateListDrawable) drawable;
            if (stateListDrawable.getCurrent() instanceof BitmapDrawable) {
                return ((BitmapDrawable) stateListDrawable.getCurrent()).getBitmap();
            }
            if (stateListDrawable.getCurrent() instanceof LayerDrawable) {
                LayerDrawable layerDrawable = (LayerDrawable) stateListDrawable.getCurrent();
                for (int i = 0; i < layerDrawable.getNumberOfLayers(); i++) {
                    if (layerDrawable.getDrawable(i) instanceof BitmapDrawable) {
                        return ((BitmapDrawable) layerDrawable.getDrawable(i)).getBitmap();
                    }
                }
                return null;
            }
            return null;
        } else if (drawable instanceof NinePatchDrawable) {
            return findBitmapInNinePatchDrawable(drawable);
        } else {
            return null;
        }
    }

    private Bitmap findBitmapInNinePatchDrawable(Drawable drawable) {
        Field[] declaredFields;
        NinePatchDrawable ninePatchDrawable = (NinePatchDrawable) drawable;
        for (Field field : ninePatchDrawable.getClass().getDeclaredFields()) {
            if (field.getType().getName().equals(NinePatch.class.getName())) {
                try {
                    field.setAccessible(true);
                    return ((NinePatch) field.get(ninePatchDrawable)).getBitmap();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    private Bitmap getBackgroundImageToWriteToFile(View view) {
        if (view.getBackground() != null) {
            return findBitmapInDrawable(view.getBackground());
        }
        return null;
    }

    private Bitmap getSrcImageToWriteToFile(View view) {
        if (view instanceof ImageView) {
            ImageView imageView = (ImageView) view;
            if (imageView.getDrawable() != null) {
                return findBitmapInDrawable(imageView.getDrawable());
            }
            return null;
        } else if (view instanceof ProgressBar) {
            ProgressBar progressBar = (ProgressBar) view;
            if (progressBar.getBackground() != null) {
                return findBitmapInDrawable(progressBar.getProgressDrawable());
            }
            return null;
        } else if (view instanceof ImageButton) {
            ImageButton imageButton = (ImageButton) view;
            if (imageButton.getDrawable() != null) {
                return findBitmapInDrawable(imageButton.getDrawable());
            }
            return null;
        } else {
            return null;
        }
    }

    private ArrayList<Bitmap> findTrafficBarBitmap(TrafficBar trafficBar) {
        ArrayList<Bitmap> arrayList = new ArrayList<>();
        if (trafficBar.getCarIcon() != null) {
            arrayList.add(trafficBar.getCarIcon());
        }
        if (trafficBar.getEndIcon() != null) {
            arrayList.add(trafficBar.getEndIcon());
        }
        if (trafficBar.getLineBitmap() != null) {
            arrayList.add(trafficBar.getLineBitmap());
        }
        if (trafficBar.getViaPassingIcon() != null) {
            arrayList.add(trafficBar.getViaPassingIcon());
        }
        if (trafficBar.getViaPassedIcon() != null) {
            arrayList.add(trafficBar.getViaPassedIcon());
        }
        return arrayList;
    }

    private Bitmap getEmptyBitmap() {
        Bitmap bitmap = this.mInvalidBitmap;
        if (bitmap == null || bitmap.isRecycled()) {
            this.mInvalidBitmap = Bitmap.createBitmap(20, 20, Bitmap.Config.ARGB_8888);
            new Canvas(this.mInvalidBitmap).drawRGB(255, 0, 0);
        }
        return this.mInvalidBitmap;
    }

    private Bitmap getFreshDrawBitmap(View view) {
        if (view.getHeight() <= 0 || view.getWidth() <= 0) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        view.draw(new Canvas(createBitmap));
        return createBitmap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void writeBitmapToFile(Bitmap bitmap, String str) {
        L.Tag tag;
        StringBuilder sb;
        FileOutputStream fileOutputStream = null;
        try {
            if (bitmap != null) {
                try {
                    if (!bitmap.isRecycled()) {
                        FileOutputStream fileOutputStream2 = new FileOutputStream(str);
                        try {
                            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream2);
                            try {
                                fileOutputStream2.flush();
                                fileOutputStream2.close();
                                return;
                            } catch (IOException e) {
                                e = e;
                                tag = TAG;
                                sb = new StringBuilder();
                                sb.append("inputStream close IOException:");
                                sb.append(e.getMessage());
                                L.e(tag, sb.toString());
                                return;
                            }
                        } catch (Exception e2) {
                            e = e2;
                            fileOutputStream = fileOutputStream2;
                            e.printStackTrace();
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.flush();
                                    fileOutputStream.close();
                                    return;
                                } catch (IOException e3) {
                                    e = e3;
                                    tag = TAG;
                                    sb = new StringBuilder();
                                    sb.append("inputStream close IOException:");
                                    sb.append(e.getMessage());
                                    L.e(tag, sb.toString());
                                    return;
                                }
                            }
                            return;
                        } catch (Throwable th) {
                            th = th;
                            fileOutputStream = fileOutputStream2;
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.flush();
                                    fileOutputStream.close();
                                } catch (IOException e4) {
                                    L.Tag tag2 = TAG;
                                    L.e(tag2, "inputStream close IOException:" + e4.getMessage());
                                }
                            }
                            throw th;
                        }
                    }
                } catch (Exception e5) {
                    e = e5;
                }
            }
            L.e(TAG, "bitmap isRecycled cause write bitmap to file failed");
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void writeDrawableToFile(final View view, final boolean z) {
        Bitmap freshDrawBitmap = z ? getFreshDrawBitmap(view) : null;
        if (freshDrawBitmap == null || freshDrawBitmap.isRecycled()) {
            freshDrawBitmap = getEmptyBitmap();
        }
        final Bitmap bitmap = freshDrawBitmap;
        Bitmap backgroundImageToWriteToFile = z ? null : getBackgroundImageToWriteToFile(view);
        if (backgroundImageToWriteToFile == null || backgroundImageToWriteToFile.isRecycled()) {
            backgroundImageToWriteToFile = getEmptyBitmap();
        }
        final Bitmap bitmap2 = backgroundImageToWriteToFile;
        Bitmap srcImageToWriteToFile = z ? null : getSrcImageToWriteToFile(view);
        if (srcImageToWriteToFile == null || srcImageToWriteToFile.isRecycled()) {
            srcImageToWriteToFile = getEmptyBitmap();
        }
        final Bitmap bitmap3 = srcImageToWriteToFile;
        WorkThreadUtil.getInstance().executeIOTask(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.debugscene.CaptureHelper.3
            @Override // java.lang.Runnable
            public void run() {
                String str;
                String capturePath = RootUtil.getCapturePath();
                if (TextUtils.isEmpty(view.getContentDescription())) {
                    str = capturePath + File.separator + DMEnd.REASON_OTHER;
                } else {
                    str = capturePath + File.separator + ((Object) view.getContentDescription());
                }
                if (!FileIOUtil.makeDirs(str)) {
                    L.e(CaptureHelper.TAG, "create capture dir fail");
                    return;
                }
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss", Locale.US);
                if (z) {
                    CaptureHelper.this.writeBitmapToFile(bitmap, str + File.separator + "fresh-draw" + simpleDateFormat.format(new Date()) + ".png");
                    bitmap.recycle();
                    UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.debugscene.CaptureHelper.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (CaptureHelper.this.mCaptureBtn != null) {
                                CaptureHelper.this.mCaptureBtn.setEnabled(true);
                            }
                        }
                    });
                    return;
                }
                String str2 = str + File.separator + ThemeManager.AttributeSet.BACKGROUND + simpleDateFormat.format(new Date()) + ".png";
                CaptureHelper.this.writeBitmapToFile(bitmap2, str2);
                CaptureHelper.this.writeBitmapToFile(bitmap3, str + File.separator + ThemeManager.AttributeSet.SRC + simpleDateFormat.format(new Date()) + ".png");
                UiHandlerUtil.getInstance().postDelayed(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.debugscene.CaptureHelper.3.2
                    @Override // java.lang.Runnable
                    public void run() {
                        CaptureHelper.this.writeDrawableToFile(view, true);
                    }
                }, 2000L);
            }
        });
    }

    private void dumpImageViewDrawable(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt.getVisibility() == 0) {
                if (checkView(childAt)) {
                    writeDrawableToFile(childAt, false);
                } else if (childAt instanceof ViewGroup) {
                    dumpViewGroupDrawable(childAt);
                } else if (childAt instanceof TrafficBar) {
                    writeTrafficBar((TrafficBar) childAt);
                }
            }
        }
    }

    private void dumpViewGroupDrawable(View view) {
        ViewGroup viewGroup = (ViewGroup) view;
        if (viewGroup.getBackground() != null) {
            writeDrawableToFile(view, false);
        }
        dumpImageViewDrawable(viewGroup);
    }

    private boolean checkView(View view) {
        return (view instanceof ImageView) || (view instanceof Button) || (view instanceof ImageButton) || (view instanceof ProgressBar) || (view instanceof MapModeIconView) || (view instanceof BatteryView);
    }

    private void writeTrafficBar(TrafficBar trafficBar) {
        ArrayList<Bitmap> findTrafficBarBitmap = findTrafficBarBitmap(trafficBar);
        String str = RootUtil.getCapturePath() + File.separator + "trafficBar";
        if (!FileIOUtil.makeDirs(str)) {
            L.e(TAG, "create trafficBar dir fail");
            return;
        }
        for (int i = 0; i < findTrafficBarBitmap.size(); i++) {
            writeBitmapToFile(findTrafficBarBitmap.get(i), str + File.separator + i + ".png");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void captureSceen(final Bitmap bitmap) {
        if (bitmap == null) {
            return;
        }
        WorkThreadUtil.getInstance().executeIOTask(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.debugscene.CaptureHelper.4
            @Override // java.lang.Runnable
            public void run() {
                UiHandlerUtil uiHandlerUtil;
                Runnable runnable;
                String capturePath;
                FileOutputStream fileOutputStream = null;
                try {
                    try {
                        capturePath = RootUtil.getCapturePath();
                    } catch (IOException e) {
                        e = e;
                    }
                    if (!FileIOUtil.makeDirs(capturePath)) {
                        L.e(CaptureHelper.TAG, "create capture dir fail");
                        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.debugscene.CaptureHelper.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                CaptureHelper.this.mMapViewWrapper.unCreateBitmapFromGLSurface();
                            }
                        });
                        return;
                    }
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss", Locale.US);
                    FileOutputStream fileOutputStream2 = new FileOutputStream(capturePath + File.separator + simpleDateFormat.format(new Date()) + ".png");
                    try {
                        bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream2);
                        try {
                            fileOutputStream2.flush();
                            fileOutputStream2.close();
                        } catch (IOException e2) {
                            L.Tag tag = CaptureHelper.TAG;
                            L.e(tag, "inputStream close IOException:" + e2.getMessage());
                        }
                        uiHandlerUtil = UiHandlerUtil.getInstance();
                        runnable = new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.debugscene.CaptureHelper.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                CaptureHelper.this.mMapViewWrapper.unCreateBitmapFromGLSurface();
                            }
                        };
                    } catch (IOException e3) {
                        e = e3;
                        fileOutputStream = fileOutputStream2;
                        L.Tag tag2 = CaptureHelper.TAG;
                        L.e(tag2, " capture error " + e.getMessage());
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.flush();
                                fileOutputStream.close();
                            } catch (IOException e4) {
                                L.Tag tag3 = CaptureHelper.TAG;
                                L.e(tag3, "inputStream close IOException:" + e4.getMessage());
                            }
                        }
                        uiHandlerUtil = UiHandlerUtil.getInstance();
                        runnable = new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.debugscene.CaptureHelper.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                CaptureHelper.this.mMapViewWrapper.unCreateBitmapFromGLSurface();
                            }
                        };
                        uiHandlerUtil.post(runnable);
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.flush();
                                fileOutputStream.close();
                            } catch (IOException e5) {
                                L.Tag tag4 = CaptureHelper.TAG;
                                L.e(tag4, "inputStream close IOException:" + e5.getMessage());
                            }
                        }
                        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.debugscene.CaptureHelper.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                CaptureHelper.this.mMapViewWrapper.unCreateBitmapFromGLSurface();
                            }
                        });
                        throw th;
                    }
                    uiHandlerUtil.post(runnable);
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        });
    }

    private int getStatusBarHeight() {
        Rect rect = new Rect();
        this.mActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        return rect.top;
    }

    public void hideCaptureBtn() {
        if (L.ENABLE) {
            L.d(TAG, "hideCaptureBtn");
        }
        Button button = this.mCaptureBtn;
        if (button != null) {
            button.setVisibility(8);
        }
    }

    public void destroyCapturnBtn() {
        if (L.ENABLE) {
            L.d(TAG, "destroyCapturnBtn");
        }
        if (this.mCaptureBtn != null) {
            ((WindowManager) this.mActivity.getSystemService("window")).removeView(this.mCaptureBtn);
            this.mCaptureBtn = null;
        }
    }

    public void initCaptureView() {
        if (this.mActivity == null || this.mMapViewWrapper == null) {
            return;
        }
        boolean z = DataSetHelper.GlobalSet.getBoolean(DataSetHelper.GlobalSet.CACHE_IS_OPEN_CAPTURE, DebugCacheConsts.DEFAULT_VALUE_CACHE_IS_OPEN_CAPTURE);
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "initCaptureView:" + z);
        }
        if (z) {
            showCaptureBtn();
        } else {
            hideCaptureBtn();
        }
    }
}
