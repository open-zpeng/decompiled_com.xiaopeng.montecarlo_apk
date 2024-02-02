package com.xiaopeng.montecarlo.scenes.debugscene.page;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.base.MainContext;
/* loaded from: classes2.dex */
public abstract class BasePage {
    protected MainContext mMainContext;
    private View mView;

    public abstract View onCreateView(LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup);

    public abstract void onViewCreated(View view);

    public final BasePage setMainContext(MainContext mainContext) {
        this.mMainContext = mainContext;
        return this;
    }

    public final View getView(LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (this.mView == null) {
            this.mView = onCreateView(layoutInflater, viewGroup);
            onViewCreated(this.mView);
            View view = this.mView;
            if (!(view instanceof ListView)) {
                view.setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.debugscene.page.BasePage.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                    }
                });
            }
        }
        return this.mView;
    }
}
