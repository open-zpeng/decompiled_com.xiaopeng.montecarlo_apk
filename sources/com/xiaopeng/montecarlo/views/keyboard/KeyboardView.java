package com.xiaopeng.montecarlo.views.keyboard;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.XpThemeSwitchReceiver;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.util.ThemeWatcherUtil;
import com.xiaopeng.xui.widget.XLinearLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes3.dex */
public class KeyboardView extends XLinearLayout {
    private static final L.Tag TAG = new L.Tag("KeyboardView");
    private float mCNTextSize;
    private int mDefaultKeyHeight;
    private final KeyViewCacheHelper mKeyCacheHelper;
    private String mKeyValues;
    private final View.OnClickListener mKeyViewListener;
    private final List<KeyboardCallback> mKeyboardCallbacks;
    private MotionEvent mLastEvent;
    private View mOldClickedTextView;
    private int mRowSpace;
    private XpThemeSwitchReceiver.ThemeSwitchListener mThemeSwitchListener;

    public KeyboardView(Context context) {
        this(context, null);
    }

    public KeyboardView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mKeyboardCallbacks = new CopyOnWriteArrayList();
        this.mKeyCacheHelper = new KeyViewCacheHelper();
        this.mKeyViewListener = new View.OnClickListener() { // from class: com.xiaopeng.montecarlo.views.keyboard.KeyboardView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view instanceof KeyView) {
                    if (KeyboardView.this.mOldClickedTextView != null) {
                        KeyboardView.this.mOldClickedTextView.setSelected(false);
                        ((KeyView) KeyboardView.this.mOldClickedTextView).setTextColor(ThemeWatcherUtil.getColor(R.color.keyboard_text_color_default));
                    }
                    KeyboardView.this.mOldClickedTextView = view;
                    view.setSelected(true);
                    KeyView keyView = (KeyView) view;
                    keyView.setTextColor(ThemeWatcherUtil.getColor(R.color.keyboard_text_color_selected));
                    KeyEntry boundKey = keyView.getBoundKey();
                    if (KeyboardView.this.mKeyboardCallbacks != null) {
                        int size = KeyboardView.this.mKeyboardCallbacks.size();
                        for (int i = 0; i < size; i++) {
                            KeyboardCallback keyboardCallback = (KeyboardCallback) KeyboardView.this.mKeyboardCallbacks.get(i);
                            if (keyboardCallback != null) {
                                keyboardCallback.onTextKey(boundKey.key);
                            }
                        }
                    }
                }
            }
        };
        this.mThemeSwitchListener = new XpThemeSwitchReceiver.ThemeSwitchListener() { // from class: com.xiaopeng.montecarlo.views.keyboard.KeyboardView.2
            @Override // com.xiaopeng.montecarlo.XpThemeSwitchReceiver.ThemeSwitchListener
            public void onThemeSwitch(int i) {
                KeyboardView.this.initKeyboardLayout(null);
            }
        };
        this.mDefaultKeyHeight = getResources().getDimensionPixelSize(R.dimen.keyboard_key_height);
        this.mKeyValues = context.getString(R.string.keyboard_licence_plate_provinces);
        setOrientation(1);
        setClipChildren(false);
        setClipToPadding(false);
        this.mCNTextSize = getResources().getDimensionPixelSize(R.dimen.keyboard_key_cn_text_size);
        initKeyboardLayout(null);
    }

    public void initLicencePlate(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        int indexOf = this.mKeyValues.indexOf(str);
        ViewGroup viewGroup = (ViewGroup) getChildAt(indexOf / 8);
        if (viewGroup != null) {
            KeyView keyView = (KeyView) viewGroup.getChildAt(indexOf % 8);
            this.mOldClickedTextView = keyView;
            if (keyView != null) {
                keyView.setSelected(true);
                keyView.setTextColor(ThemeWatcherUtil.getColor(R.color.keyboard_text_color_selected));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initKeyboardLayout(List<List<KeyEntry>> list) {
        String substring;
        if (L.ENABLE) {
            L.d(TAG, "initKeyboardLayout");
        }
        if (list == null) {
            list = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                ArrayList<KeyEntry> arrayList = new ArrayList<>();
                if (i == 0) {
                    substring = this.mKeyValues.substring(0, 8);
                } else if (i == 1) {
                    substring = this.mKeyValues.substring(8, 16);
                } else if (i == 2) {
                    substring = this.mKeyValues.substring(16, 24);
                } else {
                    substring = this.mKeyValues.substring(24, 31);
                }
                addKeyEntries(arrayList, substring);
                list.add(arrayList);
            }
        }
        int size = list.get(0).size();
        int size2 = list.size();
        this.mKeyCacheHelper.recyclerKeyRows(this, size2);
        for (int i2 = 0; i2 < size2; i2++) {
            List<KeyEntry> list2 = list.get(i2);
            KeyRowLayout keyRowLayout = (KeyRowLayout) getChildAt(i2);
            keyRowLayout.setMaxColumn(size);
            int size3 = list2.size();
            keyRowLayout.setFunKeyCount(0);
            int i3 = size2 - 1;
            if (i2 == i3) {
                this.mKeyCacheHelper.recyclerKeyViewsInRow(keyRowLayout, size3 + 1, false, this.mKeyViewListener);
            } else {
                this.mKeyCacheHelper.recyclerKeyViewsInRow(keyRowLayout, size3, false, this.mKeyViewListener);
            }
            int size4 = list2.size();
            for (int i4 = 0; i4 < size4; i4++) {
                KeyEntry keyEntry = list2.get(i4);
                KeyView keyView = (KeyView) keyRowLayout.getChildAt(i4);
                keyView.bindKey(keyEntry);
                keyView.setText(keyEntry.key);
                keyView.setTextSize(0, this.mCNTextSize);
                keyView.setTextAppearance(R.style.font_xp_medium);
                keyView.setBackground(ThemeWatcherUtil.getDrawable(R.drawable.selector_bg_keyborad_btn));
            }
            if (i2 == i3) {
                KeyView keyView2 = (KeyView) keyRowLayout.getChildAt(list2.size());
                keyView2.setText(R.string.download_dialog_ok);
                keyView2.setTextSize(0, this.mCNTextSize);
                keyView2.setTextColor(ThemeWatcherUtil.getColor(R.color.keyboard_text_color_selected));
                keyView2.setBackground(ThemeWatcherUtil.getDrawable(R.drawable.layer_bg_keyborad_province_selected_btn));
                keyView2.setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.montecarlo.views.keyboard.KeyboardView.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        View view2 = (View) KeyboardView.this.getParent();
                        if (view2 != null) {
                            view2.setVisibility(8);
                        }
                    }
                });
            }
        }
    }

    private void addKeyEntries(ArrayList<KeyEntry> arrayList, String str) {
        for (int i = 0; i < str.length(); i++) {
            arrayList.add(new KeyEntry(String.valueOf(str.charAt(i))));
        }
    }

    public void addKeyboardCallback(@NonNull KeyboardCallback keyboardCallback) {
        this.mKeyboardCallbacks.add(keyboardCallback);
    }

    public void removeKeyboardCallback() {
        this.mKeyboardCallbacks.clear();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int childCount = getChildCount();
        int i3 = 0;
        if (mode == Integer.MIN_VALUE) {
            size = (this.mDefaultKeyHeight * childCount) + ((childCount - 1) * this.mRowSpace) + getPaddingTop() + getPaddingBottom();
            while (i3 < childCount) {
                getChildAt(i3).getLayoutParams().height = this.mDefaultKeyHeight;
                i3++;
            }
        } else if (mode == 1073741824 && childCount > 0) {
            int paddingTop = (((size - getPaddingTop()) - getPaddingBottom()) - ((childCount - 1) * this.mRowSpace)) / childCount;
            while (i3 < childCount) {
                getChildAt(i3).getLayoutParams().height = paddingTop;
                i3++;
            }
        }
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(size, 1073741824));
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() > 1 && motionEvent.getActionMasked() == 5) {
            float x = motionEvent.getX(motionEvent.getActionIndex());
            float y = motionEvent.getY(motionEvent.getActionIndex());
            if (this.mLastEvent != null && x >= 0.0f && x < getWidth() && y >= 0.0f && y <= getHeight()) {
                MotionEvent obtain = MotionEvent.obtain(this.mLastEvent.getDownTime(), this.mLastEvent.getEventTime(), 1, this.mLastEvent.getX(), this.mLastEvent.getY(), this.mLastEvent.getMetaState());
                super.dispatchTouchEvent(obtain);
                if (obtain != null) {
                    obtain.recycle();
                }
                return true;
            }
        }
        this.mLastEvent = motionEvent;
        return super.dispatchTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.xui.widget.XLinearLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ThemeWatcherUtil.addXpThemeSwitchListener(this.mThemeSwitchListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.xui.widget.XLinearLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ThemeWatcherUtil.removeXpThemeListener(this.mThemeSwitchListener);
    }
}
