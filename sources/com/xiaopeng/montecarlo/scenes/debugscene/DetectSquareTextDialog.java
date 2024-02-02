package com.xiaopeng.montecarlo.scenes.debugscene;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.xiaopeng.libtheme.ThemeManager;
import com.xiaopeng.montecarlo.MainActivity;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import com.xiaopeng.montecarlo.root.util.UiHandlerUtil;
import com.xiaopeng.montecarlo.views.dialog.XBaseDialog;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class DetectSquareTextDialog extends XBaseDialog {
    private final Context mContext;
    private final EditText mEditTextView;
    private String mLogPath;

    public DetectSquareTextDialog(Context context) {
        super(context);
        this.mContext = context;
        this.mLogPath = RootUtil.getLogcatLogPath();
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.debug_square_text_input_layout, (ViewGroup) null);
        this.mEditTextView = (EditText) inflate.findViewById(R.id.debug_square_text_input_edit_query);
        setContentView(inflate, true);
        showTitle(false);
    }

    @Override // com.xiaopeng.xui.app.XDialog
    public void dismiss() {
        hideImm();
        UiHandlerUtil.getInstance().postDelayed(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.debugscene.DetectSquareTextDialog.1
            @Override // java.lang.Runnable
            public void run() {
                DetectSquareTextDialog.super.dismiss();
            }
        }, 100L);
    }

    private void hideImm() {
        InputMethodManager inputMethodManager = (InputMethodManager) this.mContext.getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(this.mEditTextView.getWindowToken(), 0);
        }
    }

    public void findTextViewAttribute() {
        View rootView;
        boolean z;
        Editable text = this.mEditTextView.getText();
        if (text == null) {
            return;
        }
        String obj = text.toString();
        if (TextUtils.isEmpty(obj) || (rootView = getRootView()) == null) {
            return;
        }
        if (rootView instanceof ViewGroup) {
            LinkedList linkedList = new LinkedList();
            linkedList.add((ViewGroup) rootView);
            z = false;
            while (!linkedList.isEmpty()) {
                ViewGroup viewGroup = (ViewGroup) linkedList.remove();
                boolean z2 = z;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    View childAt = viewGroup.getChildAt(i);
                    if (childAt instanceof ViewGroup) {
                        linkedList.add((ViewGroup) childAt);
                    } else {
                        z2 = z2 || obtainTextView(childAt, obj);
                    }
                }
                z = z2;
            }
        } else {
            z = obtainTextView(rootView, obj);
        }
        if (z) {
            return;
        }
        Toast.makeText(this.mContext, "Result message: can not find the View content with " + obj, 1).show();
    }

    @Nullable
    private View getRootView() {
        ViewGroup viewGroup;
        Context context = this.mContext;
        if (context instanceof MainActivity) {
            viewGroup = (ViewGroup) ((MainActivity) context).getWindow().getDecorView().findViewById(16908290);
            if (viewGroup == null) {
                viewGroup = (ViewGroup) getDialog().getWindow().getDecorView().findViewById(16908290);
            }
        } else {
            viewGroup = null;
        }
        if (viewGroup == null) {
            return null;
        }
        return viewGroup.getChildAt(0);
    }

    private boolean obtainTextView(View view, String str) {
        if (view != null && (view instanceof TextView)) {
            TextView textView = (TextView) view;
            CharSequence text = textView.getText();
            String charSequence = text != null ? text.toString() : null;
            if (!TextUtils.isEmpty(charSequence) && charSequence.contains(str)) {
                logToFile(textView);
                return true;
            }
        }
        return false;
    }

    private void logToFile(TextView textView) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("content", textView.getText());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        TextPaint paint = textView.getPaint();
        if (paint != null) {
            Class<?> cls = paint.getClass();
            JSONObject jSONObject2 = new JSONObject();
            try {
                Field declaredField = cls.getDeclaredField("underlineColor");
                declaredField.setAccessible(true);
                Field declaredField2 = cls.getDeclaredField("underlineThickness");
                declaredField2.setAccessible(true);
                jSONObject2.put("baselineShift", String.valueOf(paint.baselineShift)).put("bgColor", String.valueOf(paint.bgColor)).put("linkColor", String.valueOf(paint.linkColor)).put("drawableState", String.valueOf(paint.drawableState)).put("density", String.valueOf(paint.density)).put("underlineColor", String.valueOf(declaredField.get(paint))).put("underlineThickness", String.valueOf(declaredField2.get(paint)));
                jSONObject.put("TextPaint", jSONObject2);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("alpha", paint.getAlpha()).put(TypedValues.Custom.S_COLOR, paint.getColor()).put("flags", paint.getFlags()).put("fontSpacing", paint.getFontSpacing()).put("strokeMiter", paint.getStrokeMiter()).put("strokeWidth", paint.getStrokeWidth()).put("textScaleX", paint.getTextScaleX()).put("textSize", paint.getTextSize()).put("textSkewX", paint.getTextSkewX()).put("colorFilter", paint.getColorFilter()).put("maskFilter", paint.getMaskFilter()).put("pathEffect", paint.getPathEffect()).put("shader", paint.getShader()).put("strokeCap", paint.getStrokeCap()).put("strokeJoin", paint.getStrokeJoin()).put("textAlign", paint.getTextAlign()).put("textLocale", paint.getTextLocale()).put("xfermode", paint.getXfermode());
                fillFontMetricsX(jSONObject3, paint.getFontMetricsInt());
                JSONObject jSONObject4 = new JSONObject();
                Paint.FontMetrics fontMetrics = paint.getFontMetrics();
                jSONObject4.put("top", fontMetrics.top).put("ascent", fontMetrics.ascent).put("descent", fontMetrics.descent).put("bottom", fontMetrics.bottom).put("leading", fontMetrics.leading);
                jSONObject3.put("fontMetrics", jSONObject4);
                JSONObject jSONObject5 = new JSONObject();
                Typeface typeface = paint.getTypeface();
                if (typeface != null) {
                    jSONObject5.put(ThemeManager.AttributeSet.STYLE, typeface.getStyle());
                    jSONObject3.put("typeface", jSONObject5);
                }
                jSONObject2.put("paint", jSONObject3);
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (NoSuchFieldException e3) {
                e3.printStackTrace();
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
        }
        toFile(jSONObject.toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v7, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v8, types: [java.io.OutputStream, java.io.Closeable, java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.xiaopeng.montecarlo.scenes.debugscene.DetectSquareTextDialog] */
    private void toFile(String str) {
        BufferedWriter bufferedWriter;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        File file = new File(this.mLogPath);
        if (!file.exists()) {
            file.mkdirs();
        }
        ?? r4 = "yyyy-MM-dd_HH-mm-ss-SSS";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss-SSS", Locale.US);
        BufferedWriter bufferedWriter2 = null;
        try {
            try {
                r4 = new FileOutputStream(file.getAbsolutePath() + File.separator + simpleDateFormat.format(new Date()) + ".log", true);
                try {
                    bufferedWriter = new BufferedWriter(new OutputStreamWriter(r4));
                } catch (FileNotFoundException e) {
                    e = e;
                } catch (IOException e2) {
                    e = e2;
                    bufferedWriter = null;
                }
            } catch (Throwable th) {
                th = th;
                closeQuietly(bufferedWriter2);
                closeQuietly(r4);
                throw th;
            }
            try {
                bufferedWriter.write(str);
                closeQuietly(bufferedWriter);
                closeQuietly(r4);
                Toast.makeText(this.mContext, "Success message Log location is: " + this.mLogPath, 0).show();
            } catch (FileNotFoundException e3) {
                e = e3;
                bufferedWriter2 = bufferedWriter;
                e.printStackTrace();
                Toast.makeText(this.mContext, "Error message: " + e.getMessage(), 1).show();
                closeQuietly(bufferedWriter2);
                closeQuietly(r4);
            } catch (IOException e4) {
                e = e4;
                bufferedWriter2 = r4;
                try {
                    e.printStackTrace();
                    Toast.makeText(this.mContext, "Error message: " + e.getMessage(), 1).show();
                    closeQuietly(bufferedWriter);
                    closeQuietly(bufferedWriter2);
                } catch (Throwable th2) {
                    th = th2;
                    r4 = bufferedWriter2;
                    bufferedWriter2 = bufferedWriter;
                    closeQuietly(bufferedWriter2);
                    closeQuietly(r4);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedWriter2 = bufferedWriter;
                closeQuietly(bufferedWriter2);
                closeQuietly(r4);
                throw th;
            }
        } catch (FileNotFoundException e5) {
            e = e5;
            r4 = 0;
        } catch (IOException e6) {
            e = e6;
            bufferedWriter = null;
        } catch (Throwable th4) {
            th = th4;
            r4 = 0;
            closeQuietly(bufferedWriter2);
            closeQuietly(r4);
            throw th;
        }
    }

    private void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void fillFontMetricsX(JSONObject jSONObject, Object obj) {
        Paint.FontMetricsInt fontMetricsInt;
        String valueOf;
        String valueOf2;
        String valueOf3;
        String valueOf4;
        Paint.FontMetrics fontMetrics = null;
        if (obj instanceof Paint.FontMetricsInt) {
            fontMetricsInt = (Paint.FontMetricsInt) obj;
        } else if (obj instanceof Paint.FontMetrics) {
            fontMetrics = (Paint.FontMetrics) obj;
            fontMetricsInt = null;
        } else {
            fontMetricsInt = null;
        }
        JSONObject jSONObject2 = new JSONObject();
        Object obj2 = "null";
        try {
            if (fontMetrics == null) {
                valueOf = fontMetricsInt == null ? "null" : Integer.valueOf(fontMetricsInt.top);
            } else {
                valueOf = Float.valueOf(fontMetrics.top);
            }
            JSONObject put = jSONObject2.put("top", valueOf);
            if (fontMetrics == null) {
                valueOf2 = fontMetricsInt == null ? "null" : Integer.valueOf(fontMetricsInt.ascent);
            } else {
                valueOf2 = Float.valueOf(fontMetrics.ascent);
            }
            JSONObject put2 = put.put("ascent", valueOf2);
            if (fontMetrics == null) {
                valueOf3 = fontMetricsInt == null ? "null" : Integer.valueOf(fontMetricsInt.descent);
            } else {
                valueOf3 = Float.valueOf(fontMetrics.descent);
            }
            JSONObject put3 = put2.put("descent", valueOf3);
            if (fontMetrics == null) {
                valueOf4 = fontMetricsInt == null ? "null" : Integer.valueOf(fontMetricsInt.bottom);
            } else {
                valueOf4 = Float.valueOf(fontMetrics.bottom);
            }
            JSONObject put4 = put3.put("bottom", valueOf4);
            if (fontMetrics != null) {
                obj2 = Float.valueOf(fontMetrics.leading);
            } else if (fontMetricsInt != null) {
                obj2 = Integer.valueOf(fontMetricsInt.leading);
            }
            put4.put("leading", obj2);
            jSONObject.put(fontMetrics == null ? "fontMetricsInt" : "fontMetrics", jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
