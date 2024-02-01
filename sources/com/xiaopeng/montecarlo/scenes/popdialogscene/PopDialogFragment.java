package com.xiaopeng.montecarlo.scenes.popdialogscene;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.XpThemeSwitchReceiver;
import com.xiaopeng.montecarlo.aimessage.AiMsgManager;
import com.xiaopeng.montecarlo.base.BaseScene;
import com.xiaopeng.montecarlo.navcore.location.LocationUtils;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.scenes.popdialogscene.IPopDialogContract;
import com.xiaopeng.montecarlo.util.ThemeWatcherUtil;
import com.xiaopeng.montecarlo.views.NetworkImagePageAdapter;
import com.xiaopeng.montecarlo.views.XPViewPager;
import com.xiaopeng.xui.widget.XImageButton;
import com.xiaopeng.xui.widget.pageindicator.XNumberPagerIndicator;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes3.dex */
public class PopDialogFragment extends BaseScene implements IPopDialogContract.LogicView, View.OnClickListener {
    private static final L.Tag TAG = new L.Tag("PopDialogFragment");
    ViewGroup mContent;
    ViewGroup mDialContent;
    ViewGroup mDialRoot;
    XImageButton mLargePoiCloseIv;
    XNumberPagerIndicator mLargePoiIconIndexTips;
    XPViewPager mLargePoiViewPager;
    ViewGroup mPicContainer;
    private PopDialogPresenter mPresenter;
    NetworkImagePageAdapter mLargeIconAdapter = null;
    private int mType = -1;
    private Object mData = null;
    private XpThemeSwitchReceiver.ThemeSwitchListener mThemeSwitchListener = new XpThemeSwitchReceiver.ThemeSwitchListener() { // from class: com.xiaopeng.montecarlo.scenes.popdialogscene.PopDialogFragment.1
        @Override // com.xiaopeng.montecarlo.XpThemeSwitchReceiver.ThemeSwitchListener
        public void onThemeSwitch(int i) {
            PopDialogFragment.this.onThemeControl();
        }
    };

    @Override // com.xiaopeng.montecarlo.base.BaseScene
    public boolean onSceneSaveInstanceState(Bundle bundle) {
        return true;
    }

    public static BaseScene newInstance() {
        return new PopDialogFragment();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onThemeControl() {
        if (!isSceneLegal() || this.mContent == null) {
            return;
        }
        int i = this.mType;
        if (i == 0) {
            showDialView(String.valueOf(this.mData));
        } else if (i != 1) {
        } else {
            executeThemeSwitchForPic();
        }
    }

    private void executeThemeSwitchForPic() {
        ViewGroup viewGroup = this.mPicContainer;
        if (viewGroup != null) {
            viewGroup.setBackground(ThemeWatcherUtil.getDrawable(R.drawable.layer_bg_pop_dialog_container));
        }
    }

    @Override // com.xiaopeng.montecarlo.base.IBaseLogicView
    /* renamed from: getPresenter */
    public PopDialogPresenter mo116getPresenter() {
        return this.mPresenter;
    }

    @Override // com.xiaopeng.montecarlo.base.IBaseLogicView
    public void setPresenter(PopDialogPresenter popDialogPresenter) {
        this.mPresenter = popDialogPresenter;
    }

    @Override // com.xiaopeng.montecarlo.base.BaseScene
    protected View onSceneCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.layout_pop_dialog, (ViewGroup) null);
        this.mContent = (ViewGroup) inflate.findViewById(R.id.pop_dialog_layout);
        this.mContent.setOnClickListener(this);
        return inflate;
    }

    @Override // com.xiaopeng.montecarlo.base.BaseScene
    public void onSceneViewCreated(View view, Bundle bundle) {
        super.onSceneViewCreated(view, bundle);
        parseBundle();
    }

    private void parseBundle() {
        this.mType = getBridge().getBundle().getInt(PopDialogUtils.KEY_POP_TYPE, -1);
        int i = this.mType;
        if (i == 0) {
            this.mData = getBridge().getBundle().getString(PopDialogUtils.KEY_POP_TYPE_VALUE);
        } else if (i == 1) {
            this.mData = getBridge().getBundle().getStringArray(PopDialogUtils.KEY_POP_TYPE_VALUE);
        }
        if (-1 == this.mType || this.mData == null) {
            stopSelf();
        }
        this.mPresenter.onInitView(this.mType, this.mData);
    }

    @Override // com.xiaopeng.montecarlo.scenes.popdialogscene.IPopDialogContract.LogicView
    public void fillContent() {
        try {
            int i = this.mType;
            if (i == 0) {
                showDialView(String.valueOf(this.mData));
            } else if (i == 1) {
                initPoiPicView((String[]) this.mData);
            }
        } catch (Exception e) {
            L.Tag tag = TAG;
            L.e(tag, " fillContent error: " + e);
            stopSelf();
        }
    }

    private void initPoiPicView(String[] strArr) {
        List<String> asList = Arrays.asList(strArr);
        this.mContent.removeAllViews();
        LayoutInflater.from(getActivity()).inflate(R.layout.layout_poi_pop_picture, this.mContent);
        this.mPicContainer = (ViewGroup) this.mContent.findViewById(R.id.poi_pop_picture_top);
        this.mPicContainer.setBackground(ThemeWatcherUtil.getDrawable(R.drawable.layer_bg_pop_dialog_container));
        this.mLargePoiViewPager = (XPViewPager) this.mContent.findViewById(R.id.large_poi_icon_container);
        this.mLargePoiIconIndexTips = (XNumberPagerIndicator) this.mContent.findViewById(R.id.large_poi_pic_index);
        this.mLargePoiCloseIv = (XImageButton) this.mContent.findViewById(R.id.large_poi_pic_close);
        this.mLargePoiCloseIv.setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.popdialogscene.PopDialogFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PopDialogFragment.this.stopSelf();
            }
        });
        this.mContent.setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.popdialogscene.PopDialogFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PopDialogFragment.this.stopSelf();
            }
        });
        NetworkImagePageAdapter networkImagePageAdapter = this.mLargeIconAdapter;
        if (networkImagePageAdapter == null) {
            this.mLargeIconAdapter = new NetworkImagePageAdapter(getActivity(), asList, ContextUtils.getDimensionPixelSize(R.dimen.poi_pop_pic_width), ContextUtils.getDimensionPixelSize(R.dimen.poi_pop_pic_height), true);
            this.mLargePoiViewPager.setAdapter(this.mLargeIconAdapter);
            this.mLargePoiViewPager.setOffscreenPageLimit(3);
            addPageChangeListenerForLargePoiIconContainer();
        } else {
            networkImagePageAdapter.setIconsUrls(asList);
        }
        this.mLargePoiViewPager.setCurrentItem(0, false);
        initLargePictureIndexTips();
    }

    private void initLargePictureIndexTips() {
        NetworkImagePageAdapter networkImagePageAdapter;
        if (this.mLargePoiIconIndexTips == null || (networkImagePageAdapter = this.mLargeIconAdapter) == null || !CollectionUtils.isNotEmpty(networkImagePageAdapter.getIconsUrls())) {
            return;
        }
        this.mLargePoiIconIndexTips.setupWithViewPager(this.mLargePoiViewPager);
    }

    private void addPageChangeListenerForLargePoiIconContainer() {
        XPViewPager xPViewPager = this.mLargePoiViewPager;
        if (xPViewPager == null) {
            return;
        }
        xPViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.xiaopeng.montecarlo.scenes.popdialogscene.PopDialogFragment.4
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                PopDialogFragment.this.mLargeIconAdapter.resetImage(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.base.BaseScene
    public void onSceneAttach(Context context) {
        super.onSceneAttach(context);
        ThemeWatcherUtil.addXpThemeSwitchListener(this.mThemeSwitchListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.montecarlo.base.BaseScene
    public void onSceneDetach() {
        super.onSceneDetach();
        ThemeWatcherUtil.removeXpThemeListener(this.mThemeSwitchListener);
    }

    private void showDialView(String str) {
        if (L.ENABLE) {
            L.d(TAG, "showDialView num:" + str);
        }
        String[] split = str.split(LocationUtils.DR_RECORD_DATA_SPLIT_CHAR);
        int length = split.length <= 2 ? split.length : 2;
        if (length <= 0) {
            return;
        }
        this.mContent.removeAllViews();
        LayoutInflater.from(getActivity()).inflate(R.layout.layout_poi_dial_list, this.mContent);
        this.mDialRoot = (ViewGroup) this.mContent.findViewById(R.id.poi_pop_dial_top);
        this.mDialContent = (ViewGroup) this.mContent.findViewById(R.id.poi_dial_container);
        this.mDialContent.setBackground(ContextUtils.getDrawable(ThemeWatcherUtil.getDrawableResId(R.drawable.shape_bg_poi_dial_container)));
        for (int i = 0; i < length; i++) {
            TextView textView = new TextView(getActivity());
            textView.setText(split[i]);
            int dimensionPixelSize = ContextUtils.getDimensionPixelSize(R.dimen.poi_dial_list_height);
            int i2 = length - 1;
            if (i == i2) {
                dimensionPixelSize = ContextUtils.getDimensionPixelSize(R.dimen.poi_dial_list_last_height);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, dimensionPixelSize);
            layoutParams.gravity = 17;
            textView.setLayoutParams(layoutParams);
            textView.setPadding(ContextUtils.getDimensionPixelSize(R.dimen.poi_dial_phone_horizontal_padding), 0, ContextUtils.getDimensionPixelSize(R.dimen.poi_dial_phone_horizontal_padding), 0);
            textView.setGravity(17);
            textView.setCompoundDrawablesWithIntrinsicBounds(ThemeWatcherUtil.getDrawable(R.drawable.vector_ic_mid_phone), (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setTextAppearance(getActivity(), ThemeWatcherUtil.isDayMode() ? R.style.poi_body_contact_style : R.style.poi_body_contact_style_night);
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.popdialogscene.PopDialogFragment.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PopDialogFragment.this.mPresenter.dialWithBT(((TextView) view).getText().toString());
                    PopDialogFragment.this.exit();
                }
            });
            this.mDialContent.addView(textView);
            if (i < i2) {
                addHorizontalLineView(this.mDialContent);
            }
        }
        this.mDialRoot.setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.popdialogscene.PopDialogFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PopDialogFragment.this.exit();
            }
        });
        this.mContent.setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.montecarlo.scenes.popdialogscene.PopDialogFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PopDialogFragment.this.exit();
            }
        });
    }

    private void addHorizontalLineView(ViewGroup viewGroup) {
        View view = new View(getActivity());
        view.setLayoutParams(new LinearLayout.LayoutParams(ContextUtils.getDimensionPixelSize(R.dimen.dimen_poi_card_view_poi_dial_list_line_width), ContextUtils.getDimensionPixelSize(R.dimen.dimen_poi_card_view_poi_dial_list_line_divider_height)));
        view.setBackgroundColor(ContextUtils.getColor(ThemeWatcherUtil.getColorResId(R.color.color_poi_card_view_dial_view_divider)));
        viewGroup.addView(view);
    }

    @Override // com.xiaopeng.montecarlo.base.BaseScene
    public void onSceneResume() {
        super.onSceneResume();
        this.mPresenter.onResume();
    }

    @Override // com.xiaopeng.montecarlo.base.BaseScene
    public void onScenePause() {
        super.onScenePause();
        this.mPresenter.onPause();
    }

    @Override // com.xiaopeng.montecarlo.base.BaseScene
    public void onSceneDestroyView() {
        super.onSceneDestroyView();
        this.mPresenter.onDestroy();
    }

    @Override // com.xiaopeng.montecarlo.scenes.popdialogscene.IPopDialogContract.LogicView
    public void exit() {
        stopSelf();
    }

    @Override // com.xiaopeng.montecarlo.base.IBaseLogicView
    public void show() {
        this.mPresenter.show();
    }

    @Override // com.xiaopeng.montecarlo.base.IBaseLogicView
    public void hide() {
        this.mPresenter.hide();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != R.id.pop_dialog_layout) {
            return;
        }
        stopSelf();
    }

    @Override // com.xiaopeng.montecarlo.scenes.popdialogscene.IPopDialogContract.LogicView
    public void dialWithBT(AiMsgManager aiMsgManager, String str) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "dialWithBT num:" + str);
        }
        startActivity(new Intent("android.intent.action.CALL", Uri.parse("tel:" + str)));
    }
}
