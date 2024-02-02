package com.xiaopeng.montecarlo.scenes.debugscene.page;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.scenes.debugscene.AutoListView;
import com.xiaopeng.montecarlo.scenes.debugscene.DebugItemTag;
/* loaded from: classes2.dex */
public class DebugMenu extends BasePage {
    private ViewGroup mContainer;
    private LayoutInflater mLayoutInflater;

    @Override // com.xiaopeng.montecarlo.scenes.debugscene.page.BasePage
    public void onViewCreated(View view) {
    }

    @Override // com.xiaopeng.montecarlo.scenes.debugscene.page.BasePage
    @NonNull
    public View onCreateView(LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        this.mLayoutInflater = layoutInflater;
        this.mContainer = viewGroup;
        AutoListView autoListView = new AutoListView(viewGroup.getContext(), null, 16842868);
        autoListView.setItemObj(this);
        viewGroup.setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener() { // from class: com.xiaopeng.montecarlo.scenes.debugscene.page.DebugMenu.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
                ViewGroup viewGroup2 = (ViewGroup) view;
                int childCount = viewGroup2.getChildCount();
                if (childCount > 1) {
                    viewGroup2.getChildAt(childCount - 2).setVisibility(4);
                }
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                ViewGroup viewGroup2 = (ViewGroup) view;
                int childCount = viewGroup2.getChildCount();
                if (childCount > 0) {
                    viewGroup2.getChildAt(childCount - 1).setVisibility(0);
                }
            }
        });
        return autoListView;
    }

    @DebugItemTag(stringValue = "高德SDK信息", value = 0)
    public void menu0_GaodeSdk() {
        this.mContainer.addView(new GaoDeInfoPage().setMainContext(this.mMainContext).getView(this.mLayoutInflater, this.mContainer), -1, -1);
    }

    @DebugItemTag(stringValue = "接口环境配置", value = 0)
    public void menu1_EnvSet() {
        this.mContainer.addView(new EnvSetPage().setMainContext(this.mMainContext).getView(this.mLayoutInflater, this.mContainer), -1, -1);
    }

    @DebugItemTag(stringValue = "位置相关设置", value = 0)
    public void menu2_LogSet() {
        this.mContainer.addView(new LocationSetPage().setMainContext(this.mMainContext).getView(this.mLayoutInflater, this.mContainer), -1, -1);
    }

    @DebugItemTag(stringValue = "导航相关设置", value = 0)
    public void menu3_NaviSet() {
        this.mContainer.addView(new NaviSetPage().setMainContext(this.mMainContext).getView(this.mLayoutInflater, this.mContainer), -1, -1);
    }

    @DebugItemTag(stringValue = "DR相关设置", value = 0)
    public void menu4_DrSet() {
        this.mContainer.addView(new DrSetPage().setMainContext(this.mMainContext).getView(this.mLayoutInflater, this.mContainer), -1, -1);
    }

    @DebugItemTag(enableInUserVersion = true, stringValue = "Log相关设置", value = 0)
    public void menu5_LogSet() {
        this.mContainer.addView(new LogSetPage().setMainContext(this.mMainContext).getView(this.mLayoutInflater, this.mContainer), -1, -1);
    }

    @DebugItemTag(stringValue = "推荐相关设置", value = 0)
    public void menu6_Recommend() {
        this.mContainer.addView(new RecommendPage().setMainContext(this.mMainContext).getView(this.mLayoutInflater, this.mContainer), -1, -1);
    }

    @DebugItemTag(stringValue = "白天黑夜设置", value = 0)
    public void menu8_DayNight() {
        this.mContainer.addView(new DayNightPage().setMainContext(this.mMainContext).getView(this.mLayoutInflater, this.mContainer), -1, -1);
    }

    @DebugItemTag(stringValue = "BL性能配置", value = 0)
    public void menu9_BLProperty() {
        this.mContainer.addView(new BLPropertyPage().setMainContext(this.mMainContext).getView(this.mLayoutInflater, this.mContainer), -1, -1);
    }

    @DebugItemTag(stringValue = "搜索POIID", value = 0)
    public void menuA_SearchPOI() {
        this.mContainer.addView(new SearchPoiIdPage().setMainContext(this.mMainContext).getView(this.mLayoutInflater, this.mContainer), -1, -1);
    }

    @DebugItemTag(stringValue = "定位debug设置", value = 0)
    public void menu11_Loc_Debug() {
        this.mContainer.addView(new LocDebugPage().setMainContext(this.mMainContext).getView(this.mLayoutInflater, this.mContainer), -1, -1);
    }

    @DebugItemTag(stringValue = "其它设置", value = 0)
    public void menuZ_Other() {
        this.mContainer.addView(new OtherPage().setMainContext(this.mMainContext).getView(this.mLayoutInflater, this.mContainer), -1, -1);
    }
}
