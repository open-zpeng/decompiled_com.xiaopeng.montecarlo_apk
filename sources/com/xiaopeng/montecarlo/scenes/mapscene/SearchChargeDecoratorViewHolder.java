package com.xiaopeng.montecarlo.scenes.mapscene;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.navcore.bean.search.XPDeepCharging;
import com.xiaopeng.montecarlo.navcore.bean.search.XPDeepInfoPoi;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiCategory;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.GsonUtil;
import com.xiaopeng.montecarlo.root.util.L;
/* loaded from: classes3.dex */
public class SearchChargeDecoratorViewHolder {
    private static final L.Tag TAG = new L.Tag("ChargeDecoratorViewHolder");
    int[][] mChargePicList = {new int[]{R.drawable.png_poi_large_charge_pc_chargingpile_xpeng_slow, R.drawable.png_poi_large_charge_pc_chargingpile_xpeng_slow_pressed}, new int[]{R.drawable.png_poi_large_charge_chargingpile_xpeng, R.drawable.png_poi_large_charge_chargingpile_xpeng_pressed}, new int[]{R.drawable.png_poi_large_charge_pc_chargingpile_xpeng_ultra, R.drawable.png_poi_large_charge_pc_chargingpile_xpeng_ultra_pressed}, new int[]{R.drawable.png_poi_large_charge_pc_chargingpile_slow, R.drawable.png_poi_large_charge_pc_chargingpile_slow_press}, new int[]{R.drawable.png_poi_point_xp, R.drawable.png_poi_point_xp_press}, new int[]{R.drawable.png_poi_point_others, R.drawable.png_poi_point_others_press}, new int[]{R.drawable.png_tag_small_exclusive_free, R.drawable.png_tag_small_exclusive_free_pressed}, new int[]{R.drawable.png_tag_small_exclusive, R.drawable.png_tag_small_exclusive_pressed}, new int[]{R.drawable.png_tag_small_free, R.drawable.png_tag_small_free_pressed}};
    Boolean mCurrentIsDay = null;
    ImageView mIvChargeType;
    ImageView mIvCooperate;
    ImageView mIvGunTypeFirst;
    ImageView mIvGunTypeSecond;
    RelativeLayout mLlBubbleParent;
    LinearLayout mLlGunContainer;
    View mRootView;
    TextView mTvChargeType;
    TextView mTvGunSizeAvailableFirst;
    TextView mTvGunSizeAvailableSecond;
    TextView mTvGunSizeFirst;
    TextView mTvGunSizeSecond;
    TextView mTvSearchIndex;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public enum ChargePicEnum {
        slow,
        fast,
        ultra,
        other,
        xp,
        others,
        exclusive_free,
        exclusive,
        free
    }

    private void buildDecoratorView() {
        this.mRootView = View.inflate(ContextUtils.getContext(), R.layout.map_layout_search_charge_point, null);
        this.mTvSearchIndex = (TextView) this.mRootView.findViewById(R.id.tv_index);
        this.mIvCooperate = (ImageView) this.mRootView.findViewById(R.id.iv_charge_cooperate);
        this.mLlBubbleParent = (RelativeLayout) this.mRootView.findViewById(R.id.top);
        this.mTvChargeType = (TextView) this.mRootView.findViewById(R.id.tv_charge_gun_type);
        this.mIvChargeType = (ImageView) this.mRootView.findViewById(R.id.iv_charge_station);
        this.mIvGunTypeFirst = (ImageView) this.mRootView.findViewById(R.id.iv_charge_gun_type_first);
        this.mTvGunSizeAvailableFirst = (TextView) this.mRootView.findViewById(R.id.tv_charge_gun_ava_size_first);
        this.mTvGunSizeFirst = (TextView) this.mRootView.findViewById(R.id.tv_charge_gun_size_first);
        this.mLlGunContainer = (LinearLayout) this.mRootView.findViewById(R.id.rl_gun_num_container);
        this.mIvGunTypeSecond = (ImageView) this.mRootView.findViewById(R.id.iv_charge_gun_type_Second);
        this.mTvGunSizeAvailableSecond = (TextView) this.mRootView.findViewById(R.id.tv_charge_gun_ava_size_Second);
        this.mTvGunSizeSecond = (TextView) this.mRootView.findViewById(R.id.tv_charge_gun_size_Second);
    }

    private void setSecondGunType(int i) {
        this.mIvGunTypeSecond.setVisibility(i);
        this.mTvGunSizeAvailableSecond.setVisibility(i);
        this.mTvGunSizeSecond.setVisibility(i);
    }

    private void setTvChargeType(boolean z, boolean z2, boolean z3) {
        this.mTvChargeType.setVisibility(0);
        if (z && z2 && z3) {
            TextView textView = this.mTvChargeType;
            textView.setText(ContextUtils.getString(R.string.filter_AllXpPile) + " " + ContextUtils.getString(R.string.filter_free));
        } else if (z && z3) {
            this.mTvChargeType.setText(ContextUtils.getString(R.string.filter_AllXpPile));
        } else if (z2) {
            this.mTvChargeType.setText(ContextUtils.getString(R.string.filter_free));
        } else {
            this.mTvChargeType.setVisibility(8);
        }
    }

    private int getChargeTypeCategoryIndex(boolean z, boolean z2, boolean z3) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mIvCooperate.getLayoutParams();
        layoutParams.removeRule(14);
        if (z && z3) {
            return ChargePicEnum.exclusive.ordinal();
        }
        if (z2) {
            return ChargePicEnum.free.ordinal();
        }
        if (z && z2 && z3) {
            int ordinal = ChargePicEnum.exclusive_free.ordinal();
            layoutParams.addRule(14);
            return ordinal;
        }
        return -1;
    }

    private int getChargePicCategoryIndexAndSetSearchIndex(boolean z, boolean z2, ChargePicEnum chargePicEnum, String str) {
        this.mTvSearchIndex.setVisibility(z ? 8 : 0);
        this.mTvSearchIndex.setText(str);
        if (!z) {
            return z2 ? 4 : 5;
        } else if (z2) {
            return chargePicEnum.ordinal();
        } else {
            return 3;
        }
    }

    private void SetImgFocusType(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mLlBubbleParent.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mTvSearchIndex.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.mIvCooperate.getLayoutParams();
        if (!z) {
            layoutParams.bottomMargin = ContextUtils.getDimensionPixelSize(R.dimen.search_decorator_charge_top_bg_margin_bottom);
            layoutParams2.width = ContextUtils.getDimensionPixelSize(R.dimen.search_decorator_charge_tv_index_width_height);
            layoutParams2.height = ContextUtils.getDimensionPixelSize(R.dimen.search_decorator_charge_tv_index_width_height);
            layoutParams2.topMargin = ContextUtils.getDimensionPixelSize(R.dimen.search_decorator_charge_tv_index_margin_top);
            this.mTvSearchIndex.setTextSize(ContextUtils.getDimensionPixelSize(R.dimen.search_decorator_charge_tv_index_font_size));
            layoutParams3.bottomMargin = ContextUtils.getDimensionPixelSize(R.dimen.search_decorator_charge_decorate_margin_bottom);
        } else {
            layoutParams.bottomMargin = ContextUtils.getDimensionPixelSize(R.dimen.search_decorator_charge_top_bg_margin_bottom_pressed);
            layoutParams2.width = ContextUtils.getDimensionPixelSize(R.dimen.search_decorator_charge_tv_index_focus_width_height);
            layoutParams2.height = ContextUtils.getDimensionPixelSize(R.dimen.search_decorator_charge_tv_index_focus_width_height);
            layoutParams2.topMargin = ContextUtils.getDimensionPixelSize(R.dimen.search_decorator_charge_tv_index_margin_top_pressed);
            this.mTvSearchIndex.setTextSize(ContextUtils.getDimensionPixelSize(R.dimen.search_decorator_charge_tv_index_font_size_pressed));
            layoutParams3.bottomMargin = ContextUtils.getDimensionPixelSize(R.dimen.search_decorator_charge_decorate_margin_bottom_pressed);
        }
        this.mLlBubbleParent.setLayoutParams(layoutParams);
        this.mTvSearchIndex.setLayoutParams(layoutParams2);
        this.mIvCooperate.setLayoutParams(layoutParams3);
    }

    public void setData(boolean z, boolean z2, String str, XPPoiInfo xPPoiInfo, boolean z3) {
        int chargePicCategoryIndexAndSetSearchIndex;
        String str2;
        Boolean bool = this.mCurrentIsDay;
        if (bool == null || bool.booleanValue() != z) {
            L.Tag tag = TAG;
            L.i(tag, "setData mCurrentIsDay:" + this.mCurrentIsDay + ",isDayMode:" + z);
            buildDecoratorView();
            this.mCurrentIsDay = Boolean.valueOf(z);
        }
        if (xPPoiInfo == null) {
            L.Tag tag2 = TAG;
            L.e(tag2, "error，searchIndex:" + str + " poi info is null!");
            return;
        }
        XPDeepInfoPoi xPDeepInfoPoi = xPPoiInfo.getXPDeepInfoPoi();
        XPDeepCharging xPDeepCharging = null;
        if (xPDeepInfoPoi != null && xPDeepInfoPoi.getChargeData() != null && xPDeepInfoPoi.getChargeData().length > 0) {
            xPDeepCharging = xPDeepInfoPoi.getChargeData()[0];
        }
        if (xPDeepCharging == null) {
            L.Tag tag3 = TAG;
            L.e(tag3, "error，searchIndex:" + str + " charging info is null!");
            return;
        }
        boolean isXPSelfCharge = XPPoiCategory.isXPSelfCharge(xPPoiInfo.getCategory());
        boolean isAllXpPile = xPDeepCharging.isAllXpPile();
        boolean isFreeStation = xPDeepCharging.isFreeStation();
        if (L.ENABLE) {
            L.Tag tag4 = TAG;
            L.d(tag4, "setData :" + str + " charging:" + GsonUtil.toJson(xPDeepCharging));
            L.Tag tag5 = TAG;
            L.d(tag5, "isDesSearch:" + z3 + ";numUltra:" + xPDeepCharging.getNumUltra() + ";ultrafree:" + xPDeepCharging.getNumUltraFree() + ";numFast:" + xPDeepCharging.getNumFast() + ";fastfree:" + xPDeepCharging.getNumFastFree() + ";numSlow:" + xPDeepCharging.getNumSlow() + ";slowfree:" + xPDeepCharging.getNumSlowFree() + ";isFocus" + z2);
        }
        setSecondGunType(8);
        SetImgFocusType(z2);
        if (xPDeepCharging.getNumFastFree() < 0) {
            xPDeepCharging.setNumFastFree(0);
        }
        if (xPDeepCharging.getNumSlowFree() < 0) {
            xPDeepCharging.setNumSlowFree(0);
        }
        String str3 = "";
        if (xPDeepCharging.getNumUltra() > 0) {
            chargePicCategoryIndexAndSetSearchIndex = getChargePicCategoryIndexAndSetSearchIndex(z3, isXPSelfCharge, ChargePicEnum.ultra, str);
            if (xPDeepCharging.getNumUltraFree() < 0) {
                xPDeepCharging.setNumUltraFree(0);
            }
            str3 = String.valueOf(xPDeepCharging.getNumUltra());
            str2 = String.valueOf(xPDeepCharging.getNumUltraFree());
            this.mIvGunTypeFirst.setImageResource(R.drawable.png_charging_ultra);
            if (xPDeepCharging.getNumFast() > 0) {
                setSecondGunType(0);
                this.mIvGunTypeSecond.setImageResource(R.drawable.png_charging_fast);
                this.mTvGunSizeAvailableSecond.setText(String.valueOf(xPDeepCharging.getNumFastFree()));
                TextView textView = this.mTvGunSizeSecond;
                textView.setText("/" + String.valueOf(xPDeepCharging.getNumFast()));
            }
        } else if (xPDeepCharging.getNumFast() > 0) {
            chargePicCategoryIndexAndSetSearchIndex = getChargePicCategoryIndexAndSetSearchIndex(z3, isXPSelfCharge, ChargePicEnum.fast, str);
            if (xPDeepCharging.getNumFastFree() > 0 || xPDeepCharging.getNumSlowFree() == 0) {
                str3 = String.valueOf(xPDeepCharging.getNumFast());
                str2 = String.valueOf(xPDeepCharging.getNumFastFree());
                this.mIvGunTypeFirst.setImageResource(R.drawable.png_charging_fast);
            } else {
                str3 = String.valueOf(xPDeepCharging.getNumSlow());
                str2 = String.valueOf(xPDeepCharging.getNumSlowFree());
                this.mIvGunTypeFirst.setImageResource(R.drawable.png_charging_slow);
            }
        } else if (xPDeepCharging.getNumSlow() > 0) {
            chargePicCategoryIndexAndSetSearchIndex = getChargePicCategoryIndexAndSetSearchIndex(z3, isXPSelfCharge, ChargePicEnum.slow, str);
            str3 = String.valueOf(xPDeepCharging.getNumSlow());
            str2 = String.valueOf(xPDeepCharging.getNumSlowFree());
            this.mIvGunTypeFirst.setImageResource(R.drawable.png_charging_slow);
        } else {
            chargePicCategoryIndexAndSetSearchIndex = getChargePicCategoryIndexAndSetSearchIndex(z3, isXPSelfCharge, ChargePicEnum.fast, str);
            L.e(TAG, "no gun info!! || no free available");
            str2 = "";
        }
        this.mIvChargeType.setImageResource(this.mChargePicList[chargePicCategoryIndexAndSetSearchIndex][z2 ? 1 : 0]);
        if (str3.isEmpty() && str2.isEmpty()) {
            this.mLlBubbleParent.setVisibility(8);
            int chargeTypeCategoryIndex = getChargeTypeCategoryIndex(isAllXpPile, isFreeStation, isXPSelfCharge);
            if (chargeTypeCategoryIndex != -1) {
                this.mIvCooperate.setVisibility(0);
                this.mIvCooperate.setImageResource(this.mChargePicList[chargeTypeCategoryIndex][z2 ? 1 : 0]);
                return;
            }
            this.mIvCooperate.setVisibility(8);
            return;
        }
        this.mIvCooperate.setVisibility(8);
        this.mLlBubbleParent.setVisibility(0);
        this.mTvGunSizeAvailableFirst.setText(str2);
        TextView textView2 = this.mTvGunSizeFirst;
        textView2.setText("/" + str3);
        setTvChargeType(isAllXpPile, isFreeStation, isXPSelfCharge);
    }

    public View getRootView() {
        return this.mRootView;
    }
}
