package com.xiaopeng.montecarlo.util;

import android.os.Build;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
/* loaded from: classes3.dex */
public class MenuUtils {
    public static final int ID_SHARE = 16908341;

    public static void removeEditTextMenuItem(EditText editText, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            editText.setCustomSelectionActionModeCallback(new ResetMenuCallback(i));
        }
    }

    /* loaded from: classes3.dex */
    static class ResetMenuCallback implements ActionMode.Callback {
        private int mIgnoreId;

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return false;
        }

        @Override // android.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode actionMode) {
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return false;
        }

        ResetMenuCallback(int i) {
            this.mIgnoreId = i;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            if (menu.findItem(this.mIgnoreId) != null) {
                menu.removeItem(this.mIgnoreId);
                return true;
            }
            return true;
        }
    }
}
