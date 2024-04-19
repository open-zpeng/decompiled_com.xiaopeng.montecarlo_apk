package com.xiaopeng.montecarlo.views.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.ViewPager;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.views.NetworkImagePageAdapter;
import com.xiaopeng.montecarlo.views.XPViewPager;
import com.xiaopeng.xui.widget.XImageButton;
import com.xiaopeng.xui.widget.pageindicator.XNumberPagerIndicator;
import java.util.List;
/* loaded from: classes3.dex */
public class PicPopDialog extends XBaseDialog implements View.OnClickListener {
    private Context mContext;
    NetworkImagePageAdapter mLargeIconAdapter;
    XImageButton mLargePoiCloseIv;
    XNumberPagerIndicator mLargePoiIconIndexTips;
    XPViewPager mLargePoiViewPager;

    public PicPopDialog(Context context, List<String> list) {
        super(context, R.style.pop_dialog_large, R.style.pop_dialog_style, true, true);
        this.mLargeIconAdapter = null;
        this.mContext = context;
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.layout_poi_pop_picture, (ViewGroup) null);
        setContentView(inflate, false);
        setTitleBarVisibility(false);
        initView(inflate, list);
    }

    private void initView(View view, List<String> list) {
        this.mLargePoiViewPager = (XPViewPager) view.findViewById(R.id.large_poi_icon_container);
        this.mLargePoiIconIndexTips = (XNumberPagerIndicator) view.findViewById(R.id.large_poi_pic_index);
        this.mLargePoiCloseIv = (XImageButton) view.findViewById(R.id.large_poi_pic_close);
        this.mLargePoiCloseIv.setOnClickListener(this);
        NetworkImagePageAdapter networkImagePageAdapter = this.mLargeIconAdapter;
        if (networkImagePageAdapter == null) {
            this.mLargeIconAdapter = new NetworkImagePageAdapter(this.mContext, list, ContextUtils.getDimensionPixelSize(R.dimen.poi_pop_pic_width), ContextUtils.getDimensionPixelSize(R.dimen.poi_pop_pic_height), true);
            this.mLargePoiViewPager.setAdapter(this.mLargeIconAdapter);
            this.mLargePoiViewPager.setOffscreenPageLimit(3);
            addPageChangeListenerForLargePoiIconContainer();
        } else {
            networkImagePageAdapter.setIconsUrls(list);
        }
        this.mLargePoiViewPager.setCurrentItem(0, false);
        initLargePictureIndexTips();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != R.id.large_poi_pic_close) {
            return;
        }
        dismiss();
    }

    private void addPageChangeListenerForLargePoiIconContainer() {
        XPViewPager xPViewPager = this.mLargePoiViewPager;
        if (xPViewPager == null) {
            return;
        }
        xPViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.xiaopeng.montecarlo.views.dialog.PicPopDialog.1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                PicPopDialog.this.mLargeIconAdapter.resetImage(i);
            }
        });
    }

    private void initLargePictureIndexTips() {
        NetworkImagePageAdapter networkImagePageAdapter;
        if (this.mLargePoiIconIndexTips == null || (networkImagePageAdapter = this.mLargeIconAdapter) == null || !CollectionUtils.isNotEmpty(networkImagePageAdapter.getIconsUrls())) {
            return;
        }
        this.mLargePoiIconIndexTips.setupWithViewPager(this.mLargePoiViewPager);
    }
}
