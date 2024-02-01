package com.xiaopeng.montecarlo.views.keyboard;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.xiaopeng.montecarlo.root.util.L;
import java.util.Stack;
/* loaded from: classes3.dex */
public class KeyViewCacheHelper {
    private static final int MARGIN = 20;
    private static final L.Tag TAG = new L.Tag("KeyViewCacheHelper");
    private final Stack<KeyView> mKeyViews = new Stack<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public void recyclerKeyRows(KeyboardView keyboardView, int i) {
        if (L.ENABLE) {
            L.d(TAG, "recyclerKeyRows row=" + i);
        }
        int childCount = keyboardView.getChildCount();
        if (childCount > i) {
            int i2 = childCount - i;
            for (int i3 = 0; i3 < i2; i3++) {
                trimKeyRowLayout(keyboardView, 0);
            }
        } else if (childCount < i) {
            while (childCount < i) {
                fixKeyRowLayout(keyboardView, 20, 20, false);
                childCount++;
            }
        }
    }

    private void trimKeyRowLayout(KeyboardView keyboardView, int i) {
        if (L.ENABLE) {
            L.d(TAG, "trimKeyRowLayout row=" + i);
        }
        KeyRowLayout keyRowLayout = (KeyRowLayout) keyboardView.getChildAt(i);
        int childCount = keyRowLayout.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            pushKeyView((KeyView) keyRowLayout.getChildAt(0));
            keyRowLayout.removeViewAt(0);
        }
        keyboardView.removeView(keyRowLayout);
    }

    private void fixKeyRowLayout(KeyboardView keyboardView, int i, int i2, boolean z) {
        if (L.ENABLE) {
            L.d(TAG, "fixKeyRowLayout");
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.leftMargin = i;
        layoutParams.rightMargin = i2;
        KeyRowLayout keyRowLayout = new KeyRowLayout(keyboardView.getContext(), z);
        keyRowLayout.setLayoutParams(layoutParams);
        keyboardView.addView(keyRowLayout, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void recyclerKeyViewsInRow(KeyRowLayout keyRowLayout, int i, boolean z, View.OnClickListener onClickListener) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "recyclerKeyViewsInRow targetCount=" + i);
        }
        int childCount = keyRowLayout.getChildCount();
        if (childCount >= i) {
            if (childCount > i) {
                trimKeyViews(keyRowLayout, i, childCount);
                return;
            }
            return;
        }
        while (childCount < i) {
            float f = 1.0f;
            if (childCount == i - 1 && z) {
                f = 1.5f;
            }
            keyRowLayout.addView(pullKeyView(keyRowLayout.getContext(), f, onClickListener));
            childCount++;
        }
    }

    private void trimKeyViews(KeyRowLayout keyRowLayout, int i, int i2) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "keyRow = [" + keyRowLayout + "], targetCount = [" + i + "], childCount = [" + i2 + "]");
        }
        for (int i3 = i; i3 < i2; i3++) {
            keyRowLayout.removeViewAt(i);
            pushKeyView((KeyView) keyRowLayout.getChildAt(i));
        }
    }

    private KeyView pullKeyView(Context context, float f, View.OnClickListener onClickListener) {
        if (this.mKeyViews.empty()) {
            KeyView keyView = new KeyView(context);
            keyView.setOnClickListener(onClickListener);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
            layoutParams.weight = f;
            keyView.setLayoutParams(layoutParams);
            return keyView;
        }
        return this.mKeyViews.pop();
    }

    private void pushKeyView(KeyView keyView) {
        this.mKeyViews.push(keyView);
    }
}
