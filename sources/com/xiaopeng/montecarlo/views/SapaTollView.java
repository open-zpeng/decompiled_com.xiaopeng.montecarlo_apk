package com.xiaopeng.montecarlo.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.navcore.powerdistance.OnUpdateRemainDisListener;
import com.xiaopeng.montecarlo.navcore.powerdistance.route.RoutePowerDisHelper;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IPathResult;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IVariantPath;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPFacilityInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPNaviInfo;
import com.xiaopeng.montecarlo.root.carservice.CarServiceManager;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.UiHandlerUtil;
import com.xiaopeng.montecarlo.scenes.navi.guidescene.sapa.SapaData;
import com.xiaopeng.montecarlo.util.NaviUtil;
import com.xiaopeng.montecarlo.util.ThemeWatcherUtil;
import com.xiaopeng.xui.widget.XRelativeLayout;
import com.xiaopeng.xui.widget.XTextView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class SapaTollView extends XRelativeLayout {
    private static final float ALPHA_0 = 1.0f;
    private static final float ALPHA_1 = 0.8f;
    private static final float ALPHA_2 = 0.8f;
    private static final int CHARGE_INDEX = 8;
    private static final int GAS_STATION = 2;
    private static final int MAX_BATTERY_DISPLAY_AMOUNT = 2;
    private static final int MAX_COLUMNS = 3;
    private static final int MAX_DISPLAY_AMOUNT = 6;
    public static final int MAX_SAPA = 3;
    public static final int MAX_TOLL = 2;
    public static final float SAPA_SHOW_BATTERY = 60000.0f;
    private static final int SERVICEAREA_INDEX = 1;
    private static final int SHOPPING_INDEX = 6;
    private static final long TIME_INTERNAL = 60000;
    private static final int TOLL_INDEX = 0;
    private Context mContext;
    private SapaData mData;
    private int mLastBatteryStatusDrawableId;
    private long mLastUpdateTime;
    private final OnUpdateRemainDisListener mOnRemainDisListener;
    private RoutePowerDisHelper mRoutePowerDisHelper;
    private int mSaWithChargeIndex;
    private XRelativeLayout mSapaChargeContainer;
    private XTextView mSapaChargeFast;
    private XTextView mSapaChargeSlow;
    private XRelativeLayout mSapaContainer;
    private GridLayout mSapaDetailLayout;
    private XTextView mTvBatteryStatus;
    private XTextView mTvDistance;
    private XTextView mTvDistanceUnit;
    private XTextView mTvName;
    public static final int[] SAPA_DETAIL_ICON_ARRAY = {R.drawable.vector_ic_small_toll, R.drawable.vector_ic_small_p, R.drawable.vector_ic_small_chargingstation, R.drawable.vector_ic_small_food, R.drawable.vector_ic_small_toilet, R.drawable.vector_ic_small_repair, R.drawable.vector_ic_small_shoping, R.drawable.vector_ic_small_rest, R.drawable.vector_ic_small_chargingstation};
    private static final L.Tag TAG = new L.Tag("SapaTollView");

    private float getAlpha(int i) {
        if (i != 0) {
            return (i == 1 || i == 2) ? 0.8f : 1.0f;
        }
        return 1.0f;
    }

    private long getServiceAreaSapaDetail(long j) {
        return (j << 2) | 2;
    }

    private long getTollSapaDetail(long j) {
        return 1L;
    }

    private boolean isShowBattery(int i) {
        return ((float) i) < 60000.0f;
    }

    public SapaTollView(Context context) {
        super(context, null);
        this.mLastUpdateTime = 0L;
        this.mOnRemainDisListener = new OnUpdateRemainDisListener() { // from class: com.xiaopeng.montecarlo.views.SapaTollView.1
            @Override // com.xiaopeng.montecarlo.navcore.powerdistance.OnUpdateRemainDisListener
            public void onUpdateRemainDis(long j, int i, final int i2) {
                UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.views.SapaTollView.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        L.Tag tag = SapaTollView.TAG;
                        StringBuilder sb = new StringBuilder();
                        sb.append(SapaTollView.this.hashCode());
                        sb.append(" sapa remain distance: ");
                        sb.append(SapaTollView.this.mData != null ? SapaTollView.this.mData.mXPFacilityInfo.mName : "");
                        sb.append(", ");
                        sb.append(i2);
                        L.i(tag, sb.toString());
                        if (SapaTollView.this.isAttachedToWindow() && SapaTollView.this.getVisibility() == 0) {
                            SapaTollView.this.updateNameAndBattery(i2);
                            SapaTollView.this.mLastUpdateTime = System.currentTimeMillis();
                        }
                    }
                });
            }
        };
        this.mSaWithChargeIndex = -1;
        this.mRoutePowerDisHelper = new RoutePowerDisHelper(this.mOnRemainDisListener);
        initView(context);
    }

    public SapaTollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SapaTollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mLastUpdateTime = 0L;
        this.mOnRemainDisListener = new OnUpdateRemainDisListener() { // from class: com.xiaopeng.montecarlo.views.SapaTollView.1
            @Override // com.xiaopeng.montecarlo.navcore.powerdistance.OnUpdateRemainDisListener
            public void onUpdateRemainDis(long j, int i2, final int i22) {
                UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.views.SapaTollView.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        L.Tag tag = SapaTollView.TAG;
                        StringBuilder sb = new StringBuilder();
                        sb.append(SapaTollView.this.hashCode());
                        sb.append(" sapa remain distance: ");
                        sb.append(SapaTollView.this.mData != null ? SapaTollView.this.mData.mXPFacilityInfo.mName : "");
                        sb.append(", ");
                        sb.append(i22);
                        L.i(tag, sb.toString());
                        if (SapaTollView.this.isAttachedToWindow() && SapaTollView.this.getVisibility() == 0) {
                            SapaTollView.this.updateNameAndBattery(i22);
                            SapaTollView.this.mLastUpdateTime = System.currentTimeMillis();
                        }
                    }
                });
            }
        };
        this.mSaWithChargeIndex = -1;
        this.mRoutePowerDisHelper = new RoutePowerDisHelper(this.mOnRemainDisListener);
        initView(context);
    }

    private void initView(@NonNull Context context) {
        if (context == null) {
            throw new IllegalArgumentException("Context is null");
        }
        this.mContext = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_guide_sapa_tollstation, (ViewGroup) this, true);
        this.mSapaContainer = (XRelativeLayout) findViewById(R.id.sapa_detail_container);
        this.mTvDistance = (XTextView) inflate.findViewById(R.id.tv_distance);
        this.mTvDistanceUnit = (XTextView) inflate.findViewById(R.id.tv_distance_unit);
        this.mTvName = (XTextView) inflate.findViewById(R.id.tv_name);
        this.mSapaDetailLayout = (GridLayout) inflate.findViewById(R.id.sapa_detail_layout);
        this.mTvBatteryStatus = (XTextView) inflate.findViewById(R.id.battery_status);
        this.mSapaChargeContainer = (XRelativeLayout) findViewById(R.id.sapa_charge_detail);
        this.mSapaChargeFast = (XTextView) inflate.findViewById(R.id.sapa_charge_fast);
        this.mSapaChargeSlow = (XTextView) inflate.findViewById(R.id.sapa_charge_slow);
    }

    private void updateBatteryDrawable(int i) {
        Drawable drawable;
        if (i > 0 && (drawable = ThemeWatcherUtil.getDrawable(i)) != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            this.mTvBatteryStatus.setCompoundDrawables(drawable, null, null, null);
            this.mTvBatteryStatus.setCompoundDrawablePadding(this.mContext.getResources().getDimensionPixelSize(R.dimen.guide_sapa_battery_drawable_padding));
            return;
        }
        this.mTvBatteryStatus.setCompoundDrawables(null, null, null, null);
        this.mTvBatteryStatus.setCompoundDrawablePadding(0);
    }

    public void updateBatteryStatus(int i, int i2) {
        int i3;
        if (i == 0) {
            this.mTvBatteryStatus.setText(R.string.sapatoll_unable_reach_des);
            i3 = R.drawable.icon_32_ele_nihility;
        } else if (i != 1) {
            if (i == 2) {
                this.mTvBatteryStatus.setText(R.string.navi_lower_power_des);
            }
            i3 = -1;
        } else {
            String[] remainDistanceArray = NaviUtil.getRemainDistanceArray(i2);
            StringBuilder sb = new StringBuilder();
            if (remainDistanceArray != null && remainDistanceArray.length > 1) {
                sb.append(remainDistanceArray[0]);
                sb.append(remainDistanceArray[1]);
            }
            this.mTvBatteryStatus.setText(sb.toString());
            i3 = R.drawable.icon_32_ele_normal;
        }
        this.mLastBatteryStatusDrawableId = i3;
        updateBatteryDrawable(i3);
    }

    public void updateData(SapaData sapaData) {
        updateChargeInfo(sapaData);
        if (!isSameData(sapaData, this.mData)) {
            this.mSaWithChargeIndex = sapaData.mSaWithChargeIndex;
            updateData(sapaData.mXPFacilityInfo, sapaData.mIndex);
        } else {
            updateDistance(sapaData.mXPFacilityInfo.mRemainDist);
            updateNameAndBatteryByPre(sapaData.mXPFacilityInfo.mSapaDetail, sapaData.mXPFacilityInfo.mType, sapaData.mXPFacilityInfo.mRemainDist, sapaData.mXPFacilityInfo.mName);
        }
        this.mData = sapaData;
    }

    private void updateChargeInfo(SapaData sapaData) {
        if (sapaData != null && sapaData.mCharegeInfo != null) {
            if (sapaData.mCharegeInfo.mFastFreeNums > 0 || sapaData.mCharegeInfo.mSlowFreeNums > 0) {
                this.mSapaChargeContainer.setVisibility(0);
                this.mSapaChargeFast.setVisibility(sapaData.mCharegeInfo.mFastFreeNums > 0 ? 0 : 8);
                this.mSapaChargeFast.setText(String.format(ContextUtils.getString(R.string.sapa_charge_free), Integer.valueOf(sapaData.mCharegeInfo.mFastFreeNums)));
                this.mSapaChargeSlow.setVisibility(sapaData.mCharegeInfo.mSlowFreeNums > 0 ? 0 : 8);
                this.mSapaChargeSlow.setText(String.format(ContextUtils.getString(R.string.sapa_charge_free), Integer.valueOf(sapaData.mCharegeInfo.mSlowFreeNums)));
                return;
            }
            this.mSapaChargeContainer.setVisibility(8);
            return;
        }
        this.mSapaChargeContainer.setVisibility(8);
    }

    private void updateData(XPFacilityInfo xPFacilityInfo, int i) {
        long tollSapaDetail;
        this.mLastUpdateTime = 0L;
        updateDistance(xPFacilityInfo.mRemainDist);
        SapaData sapaData = this.mData;
        if (!isSameNaviFacility(xPFacilityInfo, sapaData == null ? null : sapaData.mXPFacilityInfo)) {
            if (xPFacilityInfo.mType == 0) {
                tollSapaDetail = getServiceAreaSapaDetail(xPFacilityInfo.mSapaDetail);
            } else {
                tollSapaDetail = 1 == xPFacilityInfo.mType ? getTollSapaDetail(xPFacilityInfo.mSapaDetail) : -1L;
            }
            if (tollSapaDetail != -1) {
                initSapaDetail(tollSapaDetail);
            }
            updateLayoutParam(1 == xPFacilityInfo.mType);
        }
        updateNameAndBatteryByPre(xPFacilityInfo.mSapaDetail, xPFacilityInfo.mType, xPFacilityInfo.mRemainDist, xPFacilityInfo.mName);
        this.mSapaContainer.setBackground(ThemeWatcherUtil.getDrawable(1 == xPFacilityInfo.mType ? R.drawable.layer_bg_sapa_deep_blue : R.drawable.layer_bg_sapa_deep_green));
        SapaData sapaData2 = this.mData;
        if (sapaData2 == null || sapaData2.mIndex != i) {
            setAlpha(getAlpha(i));
        }
    }

    private void updateDistance(int i) {
        if (i > 10000) {
            i = (i / 1000) * 1000;
        }
        String[] distanceArray = NaviUtil.getDistanceArray(i, false);
        this.mTvDistance.setText(distanceArray[0]);
        this.mTvDistanceUnit.setText(distanceArray[1]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateNameAndBattery(int i) {
        if (isShowBattery(i)) {
            this.mTvBatteryStatus.setVisibility(0);
            this.mTvName.setVisibility(8);
            int i2 = 2;
            int carRemainDistance = CarServiceManager.getInstance().getCarRemainDistance();
            try {
                i2 = NaviUtil.checkDistanceReachableStatus(carRemainDistance, i);
            } catch (NaviUtil.DistanceStatusIllegalArgumentException unused) {
                if (L.ENABLE) {
                    L.Tag tag = TAG;
                    L.d(tag, hashCode() + " INVALID remain dis and leftDistance remain dis: " + carRemainDistance + " leftDis: " + i);
                }
            }
            updateBatteryStatus(i2, i);
            return;
        }
        this.mTvBatteryStatus.setVisibility(8);
        this.mTvName.setVisibility(0);
        SapaData sapaData = this.mData;
        if (sapaData != null) {
            this.mTvName.setText(sapaData.mXPFacilityInfo.mName);
        }
    }

    private boolean isShowBatteryPre(long j, int i) {
        return NaviUtil.isSapaHasCharge(j) && i == 0 && this.mSaWithChargeIndex < 2;
    }

    private void updateNameAndBatteryByPre(long j, int i, int i2, String str) {
        if (isShowBatteryPre(j, i)) {
            updateLeftDistance(i2);
            return;
        }
        this.mTvBatteryStatus.setVisibility(8);
        if (i == 1) {
            this.mTvName.setVisibility(8);
            return;
        }
        this.mTvName.setVisibility(0);
        this.mTvName.setText(str);
    }

    private void updateLeftDistance(int i) {
        if (System.currentTimeMillis() - this.mLastUpdateTime > 60000) {
            requestLeftDis(i);
            this.mLastUpdateTime = System.currentTimeMillis();
        }
    }

    private void requestLeftDis(int i) {
        int i2;
        int i3;
        XPNaviInfo naviInfo = TBTManager.getInstance().getNaviInfo();
        if (naviInfo != null) {
            int i4 = naviInfo.mCurSegIdx;
            i3 = naviInfo.mCurLinkIdx;
            i2 = i4;
        } else {
            i2 = 0;
            i3 = 0;
        }
        L.Tag tag = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append(hashCode());
        sb.append(" sapa request online distance: ");
        SapaData sapaData = this.mData;
        sb.append(sapaData != null ? sapaData.mXPFacilityInfo.mName : "");
        sb.append(", startSeq:");
        sb.append(i2);
        sb.append(", startLink:");
        sb.append(i3);
        sb.append(", dis:");
        sb.append(i);
        L.i(tag, sb.toString());
        IVariantPath currentNaviVariantPath = TBTManager.getInstance().getCurrentNaviVariantPath();
        IPathResult currentNaviPathResult = TBTManager.getInstance().getCurrentNaviPathResult();
        if (currentNaviVariantPath == null || currentNaviPathResult == null) {
            L.i(TAG, "requestPathPointRemainDis return (path null)");
            this.mOnRemainDisListener.onUpdateRemainDis(0L, i, 0);
            return;
        }
        this.mRoutePowerDisHelper.updateRemainDis(i2, i3, i, currentNaviVariantPath, currentNaviPathResult);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.xui.widget.XRelativeLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        RoutePowerDisHelper routePowerDisHelper = this.mRoutePowerDisHelper;
        if (routePowerDisHelper == null || routePowerDisHelper.isClosed()) {
            this.mRoutePowerDisHelper = new RoutePowerDisHelper(this.mOnRemainDisListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.xui.widget.XRelativeLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        RoutePowerDisHelper routePowerDisHelper = this.mRoutePowerDisHelper;
        if (routePowerDisHelper != null) {
            routePowerDisHelper.close();
        }
    }

    public void updateTheme() {
        SapaData sapaData = this.mData;
        if (sapaData == null) {
            return;
        }
        this.mSapaContainer.setBackground(ThemeWatcherUtil.getDrawable(1 == sapaData.mXPFacilityInfo.mType ? R.drawable.layer_bg_sapa_deep_blue : R.drawable.layer_bg_sapa_deep_green));
        updateBatteryDrawable(this.mLastBatteryStatusDrawableId);
        if (this.mData.mXPFacilityInfo.mType == 0) {
            initSapaDetail(getServiceAreaSapaDetail(this.mData.mXPFacilityInfo.mSapaDetail));
        } else if (this.mData.mXPFacilityInfo.mType == 1) {
            initSapaDetail(getTollSapaDetail(this.mData.mXPFacilityInfo.mSapaDetail));
        }
        updateLayoutParam(this.mData.mXPFacilityInfo.mType == 1);
        Drawable drawable = ThemeWatcherUtil.getDrawable(R.drawable.vector_small_servicearea_fast);
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.mSapaChargeFast.setCompoundDrawables(drawable, null, null, null);
        }
        Drawable drawable2 = ThemeWatcherUtil.getDrawable(R.drawable.vector_small_servicearea_slow);
        if (drawable2 != null) {
            drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
            this.mSapaChargeSlow.setCompoundDrawables(drawable2, null, null, null);
        }
    }

    private boolean isSameData(SapaData sapaData, SapaData sapaData2) {
        return sapaData2 != null && isSameNaviFacility(sapaData.mXPFacilityInfo, sapaData2.mXPFacilityInfo) && sapaData.mIndex == sapaData2.mIndex && sapaData.mSaIndex == sapaData2.mSaIndex && sapaData.mSaWithChargeIndex == sapaData2.mSaWithChargeIndex;
    }

    private boolean isSameNaviFacility(@NonNull XPFacilityInfo xPFacilityInfo, XPFacilityInfo xPFacilityInfo2) {
        return xPFacilityInfo2 != null && xPFacilityInfo.mType == xPFacilityInfo2.mType && xPFacilityInfo.mSapaDetail == xPFacilityInfo2.mSapaDetail && TextUtils.equals(xPFacilityInfo.mName, xPFacilityInfo2.mName);
    }

    private void initSapaDetail(long j) {
        if (j <= 0) {
            this.mSapaDetailLayout.setVisibility(8);
            return;
        }
        if (L.ENABLE) {
            L.Tag tag = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("name: ");
            SapaData sapaData = this.mData;
            sb.append(sapaData != null ? sapaData.mXPFacilityInfo.mName : "");
            sb.append(", detail: ");
            sb.append(Long.toBinaryString(j));
            L.d(tag, sb.toString());
        }
        List<Integer> iconList = getIconList(j);
        Context context = getContext();
        if (iconList.size() > 0) {
            for (int i = 0; i < iconList.size(); i++) {
                ImageView imageView = (ImageView) this.mSapaDetailLayout.getChildAt(i);
                if (imageView == null) {
                    int i2 = i / 3;
                    int i3 = i % 3;
                    GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams(GridLayout.spec(i2, 1), GridLayout.spec(i3, 1));
                    layoutParams.width = context.getResources().getDimensionPixelSize(R.dimen.guide_sapa_icon_item_size);
                    layoutParams.height = context.getResources().getDimensionPixelSize(R.dimen.guide_sapa_icon_item_size);
                    if (i2 > 0) {
                        layoutParams.topMargin = context.getResources().getDimensionPixelSize(R.dimen.guide_sapa_icon_item_top);
                    }
                    if (i3 > 0) {
                        layoutParams.leftMargin = context.getResources().getDimensionPixelSize(R.dimen.guide_sapa_icon_item_gap);
                    }
                    imageView = new ImageView(getContext());
                    imageView.setImageResource(iconList.get(i).intValue());
                    this.mSapaDetailLayout.addView(imageView, layoutParams);
                } else {
                    imageView.setImageResource(iconList.get(i).intValue());
                }
                imageView.setVisibility(0);
            }
            for (int size = iconList.size(); size < this.mSapaDetailLayout.getChildCount(); size++) {
                ((ImageView) this.mSapaDetailLayout.getChildAt(size)).setVisibility(8);
            }
            this.mSapaDetailLayout.setVisibility(0);
            return;
        }
        this.mSapaDetailLayout.setVisibility(8);
    }

    private void updateLayoutParam(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mSapaDetailLayout.getLayoutParams();
        if (this.mSapaDetailLayout.getVisibility() == 0) {
            if (z) {
                layoutParams.addRule(15);
            } else {
                layoutParams.removeRule(15);
            }
            this.mSapaDetailLayout.setLayoutParams(layoutParams);
        }
    }

    private List<Integer> getIconList(long j) {
        ArrayList arrayList = new ArrayList();
        int i = -1;
        for (int i2 = 0; i2 < SAPA_DETAIL_ICON_ARRAY.length; i2++) {
            if (2 != i2 && ((1 << i2) & j) != 0) {
                if (i2 == 8 || i2 == 1) {
                    arrayList.add(0, Integer.valueOf(getSAPAIcon(i2)));
                    if (i != -1) {
                        i++;
                    }
                } else {
                    arrayList.add(Integer.valueOf(getSAPAIcon(i2)));
                }
                if (i2 == 6) {
                    i = arrayList.size() - 1;
                }
            }
        }
        if (arrayList.size() > 6 && i != -1) {
            arrayList.remove(i);
        }
        return arrayList;
    }

    private int getSAPAIcon(int i) {
        return SAPA_DETAIL_ICON_ARRAY[i];
    }
}
