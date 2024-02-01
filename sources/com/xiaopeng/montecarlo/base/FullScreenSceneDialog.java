package com.xiaopeng.montecarlo.base;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.base.scene.IBaseScene;
import com.xiaopeng.montecarlo.base.scene.SceneDialog;
/* loaded from: classes.dex */
public final class FullScreenSceneDialog extends SceneDialog {
    private View mContentView;
    private String mTitle;

    @Override // com.xiaopeng.montecarlo.base.scene.SceneDialog
    protected void onStart() {
    }

    @Override // com.xiaopeng.montecarlo.base.scene.SceneDialog
    protected void onStop() {
    }

    public FullScreenSceneDialog(Context context, IBaseScene iBaseScene) {
        super(context, iBaseScene, R.layout.scene_dialog_full_screen);
        this.mContentView = null;
    }

    public void setContentView(View view) {
        this.mContentView = view;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    @Override // com.xiaopeng.montecarlo.base.scene.SceneDialog
    protected void onCreate(Bundle bundle) {
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.content);
        View view = this.mContentView;
        if (view != null && viewGroup != null) {
            viewGroup.addView(view);
        }
        View findViewById = findViewById(R.id.btn_back);
        if (findViewById != null) {
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.montecarlo.base.FullScreenSceneDialog.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    FullScreenSceneDialog.this.dismiss();
                }
            });
        }
        TextView textView = (TextView) findViewById(R.id.title);
        if (textView != null) {
            textView.setText(this.mTitle);
        }
    }
}
