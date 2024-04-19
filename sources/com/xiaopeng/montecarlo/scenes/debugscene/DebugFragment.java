package com.xiaopeng.montecarlo.scenes.debugscene;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.Nullable;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.base.BaseScene;
import com.xiaopeng.montecarlo.base.scene.AbstractBasePresenter;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.UiHandlerUtil;
import com.xiaopeng.montecarlo.scenes.debugscene.page.DebugMenu;
/* loaded from: classes3.dex */
public class DebugFragment extends BaseScene implements View.OnClickListener {
    private static final L.Tag TAG = new L.Tag("DebugFragment");
    private ViewGroup mFragment;
    private DebugMenu mMenuPage = new DebugMenu();
    private View mRootView;

    @Override // com.xiaopeng.montecarlo.base.scene.IBaseScene
    public <T extends AbstractBasePresenter> T getPresenter() {
        return null;
    }

    @Override // com.xiaopeng.montecarlo.base.BaseScene, com.xiaopeng.montecarlo.base.scene.IBaseScene
    public boolean onBackPressed() {
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.xiaopeng.montecarlo.base.BaseScene
    public boolean onSceneSaveInstanceState(Bundle bundle) {
        return false;
    }

    public static DebugFragment newInstance() {
        return new DebugFragment();
    }

    @Override // com.xiaopeng.montecarlo.base.BaseScene
    protected View onSceneCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(R.layout.fragment_debug, (ViewGroup) null);
        this.mRootView.setOnClickListener(this);
        this.mFragment = (ViewGroup) this.mRootView.findViewById(R.id.fragment);
        this.mMenuPage.setMainContext(getMainContext());
        ViewGroup viewGroup2 = this.mFragment;
        viewGroup2.addView(this.mMenuPage.getView(layoutInflater, viewGroup2));
        return this.mRootView;
    }

    @Override // com.xiaopeng.montecarlo.base.BaseScene
    public void onSceneViewCreated(View view, @Nullable Bundle bundle) {
        super.onSceneViewCreated(view, bundle);
        onInitView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.base.BaseScene
    public void onSceneDestroyView() {
        super.onSceneDestroyView();
        this.mFragment.removeAllViews();
    }

    protected void onInitView() {
        this.mRootView.setEnabled(false);
        UiHandlerUtil.getInstance().postDelayed(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.debugscene.DebugFragment.1
            @Override // java.lang.Runnable
            public void run() {
                DebugFragment.this.mRootView.setEnabled(true);
            }
        }, 1000L);
        ((Button) this.mRootView.findViewById(R.id.btn_close)).setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.debugscene.DebugFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DebugFragment.this.goBack();
            }
        });
        ((Button) this.mRootView.findViewById(R.id.btn_back)).setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.debugscene.DebugFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int childCount = DebugFragment.this.mFragment.getChildCount();
                if (childCount > 1) {
                    DebugFragment.this.mFragment.removeViewAt(childCount - 1);
                }
            }
        });
    }
}
