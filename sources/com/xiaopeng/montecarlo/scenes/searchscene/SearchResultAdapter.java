package com.xiaopeng.montecarlo.scenes.searchscene;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.RatingBar;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.navcore.bean.search.XPDeepCharging;
import com.xiaopeng.montecarlo.navcore.bean.search.XPDeepInfoPoi;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiCategory;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.util.NaviUtil;
import com.xiaopeng.montecarlo.util.ThemeWatcherUtil;
import com.xiaopeng.montecarlo.views.ChildPoiGridView;
import com.xiaopeng.montecarlo.views.GotoPoiView;
import com.xiaopeng.montecarlo.views.PageRecyclerAdapter;
import com.xiaopeng.montecarlo.views.ParkChargeStatusView;
import com.xiaopeng.montecarlo.views.SetHomeOfficeView;
import com.xiaopeng.montecarlo.views.SetWayPointView;
import com.xiaopeng.montecarlo.views.XPRecyclerView;
import com.xiaopeng.xui.widget.XImageView;
import com.xiaopeng.xui.widget.XLinearLayout;
import com.xiaopeng.xui.widget.XRelativeLayout;
import com.xiaopeng.xui.widget.XTextView;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.paho.client.mqttv3.MqttTopic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class SearchResultAdapter extends PageRecyclerAdapter<XPPoiInfo> {
    private static final int MSG_FRESH_VIEW = 100;
    private static final L.Tag TAG = new L.Tag("SearchResultAdapter");
    private final Context mContext;
    private List<Integer> mExpandIndexs;
    private final boolean mIsFoodOpen;
    private int mResultType;
    private int mSearchDest;
    private int mSearchMode;
    private int mSearchModeView;
    private SearchResultAdapterListener mSearchResultAdapterListener;
    private int mSelectedIndex;

    /* loaded from: classes3.dex */
    public interface SearchResultAdapterListener {
        void onAddNewNaviClick(int i);

        void onAddWayClick(int i);

        void onChildPoiClick(int i, int i2);

        void onGoToPoiClick(int i);

        void onItemClick(int i);

        void onRemoveWayClick(int i);

        void onSetCompanyClick(int i);

        void onSetHomeClick(int i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // com.xiaopeng.montecarlo.views.PageRecyclerAdapter
    public void onBindXpViewHolder(RecyclerView.ViewHolder viewHolder, int i, List list) {
    }

    /* loaded from: classes3.dex */
    public class AddWayResultViewHolder_ViewBinding extends CommonViewHolder_ViewBinding {
        private AddWayResultViewHolder target;

        @UiThread
        public AddWayResultViewHolder_ViewBinding(AddWayResultViewHolder addWayResultViewHolder, View view) {
            super(addWayResultViewHolder, view);
            this.target = addWayResultViewHolder;
            addWayResultViewHolder.mSetWayPointView = (SetWayPointView) Utils.findRequiredViewAsType(view, R.id.container_set_waypoint, "field 'mSetWayPointView'", SetWayPointView.class);
        }

        @Override // com.xiaopeng.montecarlo.scenes.searchscene.SearchResultAdapter.CommonViewHolder_ViewBinding, butterknife.Unbinder
        public void unbind() {
            AddWayResultViewHolder addWayResultViewHolder = this.target;
            if (addWayResultViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.target = null;
            addWayResultViewHolder.mSetWayPointView = null;
            super.unbind();
        }
    }

    /* loaded from: classes3.dex */
    public class GotoPoiResultViewHolder_ViewBinding extends CommonViewHolder_ViewBinding {
        private GotoPoiResultViewHolder target;

        @UiThread
        public GotoPoiResultViewHolder_ViewBinding(GotoPoiResultViewHolder gotoPoiResultViewHolder, View view) {
            super(gotoPoiResultViewHolder, view);
            this.target = gotoPoiResultViewHolder;
            gotoPoiResultViewHolder.mContainerGotoPoi = (GotoPoiView) Utils.findRequiredViewAsType(view, R.id.container_goto_poi_view, "field 'mContainerGotoPoi'", GotoPoiView.class);
        }

        @Override // com.xiaopeng.montecarlo.scenes.searchscene.SearchResultAdapter.CommonViewHolder_ViewBinding, butterknife.Unbinder
        public void unbind() {
            GotoPoiResultViewHolder gotoPoiResultViewHolder = this.target;
            if (gotoPoiResultViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.target = null;
            gotoPoiResultViewHolder.mContainerGotoPoi = null;
            super.unbind();
        }
    }

    /* loaded from: classes3.dex */
    public class SetResultViewHolder_ViewBinding extends CommonViewHolder_ViewBinding {
        private SetResultViewHolder target;

        @UiThread
        public SetResultViewHolder_ViewBinding(SetResultViewHolder setResultViewHolder, View view) {
            super(setResultViewHolder, view);
            this.target = setResultViewHolder;
            setResultViewHolder.mSetHomeOfficeView = (SetHomeOfficeView) Utils.findRequiredViewAsType(view, R.id.container_set_home_office, "field 'mSetHomeOfficeView'", SetHomeOfficeView.class);
        }

        @Override // com.xiaopeng.montecarlo.scenes.searchscene.SearchResultAdapter.CommonViewHolder_ViewBinding, butterknife.Unbinder
        public void unbind() {
            SetResultViewHolder setResultViewHolder = this.target;
            if (setResultViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.target = null;
            setResultViewHolder.mSetHomeOfficeView = null;
            super.unbind();
        }
    }

    /* loaded from: classes3.dex */
    public class CommonViewHolder_ViewBinding implements Unbinder {
        private CommonViewHolder target;

        @UiThread
        public CommonViewHolder_ViewBinding(CommonViewHolder commonViewHolder, View view) {
            this.target = commonViewHolder;
            commonViewHolder.mContainer = (XRelativeLayout) Utils.findRequiredViewAsType(view, R.id.search_result_item_container, "field 'mContainer'", XRelativeLayout.class);
            commonViewHolder.mItemDetail = (XLinearLayout) Utils.findRequiredViewAsType(view, R.id.search_result_item_detail, "field 'mItemDetail'", XLinearLayout.class);
            commonViewHolder.mTvName = (XTextView) Utils.findRequiredViewAsType(view, R.id.search_result_name, "field 'mTvName'", XTextView.class);
            commonViewHolder.mTvAddress = (XTextView) Utils.findRequiredViewAsType(view, R.id.search_result_address_name, "field 'mTvAddress'", XTextView.class);
            commonViewHolder.mTvAddressType = (XTextView) Utils.findRequiredViewAsType(view, R.id.search_result_address_type, "field 'mTvAddressType'", XTextView.class);
            commonViewHolder.mTvDistance = (XTextView) Utils.findRequiredViewAsType(view, R.id.search_result_distance, "field 'mTvDistance'", XTextView.class);
            commonViewHolder.mTvOrder = (XTextView) Utils.findRequiredViewAsType(view, R.id.search_result_order, "field 'mTvOrder'", XTextView.class);
            commonViewHolder.mTvOpenTime = (XTextView) Utils.findRequiredViewAsType(view, R.id.search_result_open_time, "field 'mTvOpenTime'", XTextView.class);
            commonViewHolder.mTvRoadInfo = (XTextView) Utils.findRequiredViewAsType(view, R.id.tv_road_info, "field 'mTvRoadInfo'", XTextView.class);
            commonViewHolder.mTvPriceInfo = (XTextView) Utils.findRequiredViewAsType(view, R.id.tv_price_info, "field 'mTvPriceInfo'", XTextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            CommonViewHolder commonViewHolder = this.target;
            if (commonViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.target = null;
            commonViewHolder.mContainer = null;
            commonViewHolder.mItemDetail = null;
            commonViewHolder.mTvName = null;
            commonViewHolder.mTvAddress = null;
            commonViewHolder.mTvAddressType = null;
            commonViewHolder.mTvDistance = null;
            commonViewHolder.mTvOrder = null;
            commonViewHolder.mTvOpenTime = null;
            commonViewHolder.mTvRoadInfo = null;
            commonViewHolder.mTvPriceInfo = null;
        }
    }

    public SearchResultAdapter(@NonNull Context context, XPRecyclerView<XPPoiInfo> xPRecyclerView, int i, int i2, int i3) {
        super(context, xPRecyclerView);
        this.mResultType = 3;
        this.mSelectedIndex = -1;
        this.mExpandIndexs = new ArrayList();
        this.mContext = context;
        this.mSearchDest = i;
        this.mSearchMode = i2;
        this.mSearchModeView = i3;
        this.mIsFoodOpen = com.xiaopeng.montecarlo.util.Utils.isFoodOpen();
        initResultType();
    }

    private void initResultType() {
        int i = this.mSearchDest;
        if (i == 1001 || i == 1002) {
            this.mResultType = 1;
            return;
        }
        switch (this.mSearchMode) {
            case 100:
            case 101:
                this.mResultType = 3;
                return;
            case 102:
                this.mResultType = 2;
                return;
            default:
                return;
        }
    }

    @Override // com.xiaopeng.montecarlo.views.PageRecyclerAdapter
    public RecyclerView.ViewHolder onCreateXpViewHolder(ViewGroup viewGroup, int i) {
        int i2 = this.mResultType;
        if (i2 == 2 || this.mSearchModeView == 102) {
            return new AddWayResultViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.layout_search_result_addway_item, viewGroup, false));
        }
        if (i2 == 1) {
            return new SetResultViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.layout_search_result_set_item, viewGroup, false));
        }
        return new GotoPoiResultViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.layout_search_result_gopoi_item, viewGroup, false));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getPositionFromViewHolder(RecyclerView.ViewHolder viewHolder) {
        int adapterPosition = viewHolder.getAdapterPosition();
        return (adapterPosition > 0 && adapterPosition == getItemCount() + (-1) && showMore()) ? getData().size() - 1 : adapterPosition;
    }

    @Override // com.xiaopeng.montecarlo.views.PageRecyclerAdapter
    public void onBindXpViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        XPPoiInfo xPPoiInfo;
        int positionFromViewHolder = getPositionFromViewHolder(viewHolder);
        List<XPPoiInfo> data = getData();
        if (data == null || positionFromViewHolder < 0 || positionFromViewHolder >= data.size() || (xPPoiInfo = data.get(positionFromViewHolder)) == null) {
            return;
        }
        if (viewHolder instanceof CommonViewHolder) {
            bindCommonViewHolder((CommonViewHolder) viewHolder, positionFromViewHolder, xPPoiInfo);
        }
        if (viewHolder instanceof AddWayResultViewHolder) {
            bindAddWayResultViewHolder((AddWayResultViewHolder) viewHolder, xPPoiInfo);
        } else if (viewHolder instanceof SetResultViewHolder) {
            bindSetResultViewHolder((SetResultViewHolder) viewHolder, xPPoiInfo);
        } else if (viewHolder instanceof GotoPoiResultViewHolder) {
            bindGotoPoiResultViewHolder((GotoPoiResultViewHolder) viewHolder, xPPoiInfo);
        }
    }

    private void bindCommonViewHolder(CommonViewHolder commonViewHolder, int i, XPPoiInfo xPPoiInfo) {
        int i2;
        if (xPPoiInfo == null) {
            return;
        }
        commonViewHolder.mTvOrder.setTextColor(ThemeWatcherUtil.getColor(R.color.search_order_text_color));
        commonViewHolder.mTvOrder.setText(String.valueOf(i + 1));
        commonViewHolder.mTvName.setText(xPPoiInfo.getName());
        StringBuilder sb = new StringBuilder();
        sb.append(NaviUtil.getDistanceNoSpaceString((long) xPPoiInfo.getDistance()));
        if (TextUtils.isEmpty(xPPoiInfo.getTag())) {
            sb.append(ContextUtils.getString(R.string.favorite_item_space_text));
            commonViewHolder.mTvAddressType.setVisibility(8);
        } else {
            sb.append(ContextUtils.getString(R.string.favorite_item_dot_text));
            commonViewHolder.mTvAddressType.setVisibility(0);
            commonViewHolder.mTvAddressType.setText(xPPoiInfo.getTag());
        }
        commonViewHolder.mTvDistance.setText(sb);
        commonViewHolder.mTvAddress.setText(xPPoiInfo.getAddress());
        if (TextUtils.isEmpty(xPPoiInfo.getRoadInfo())) {
            commonViewHolder.mTvRoadInfo.setVisibility(8);
        } else {
            commonViewHolder.mTvRoadInfo.setVisibility(0);
            commonViewHolder.mTvRoadInfo.setText(SearchSceneDataHelper.formatBLRoadInfo(xPPoiInfo));
        }
        bindPriceView(commonViewHolder, xPPoiInfo);
        bindOpenTimeView(commonViewHolder, xPPoiInfo);
        if (xPPoiInfo.getVisitCount() > 0 || xPPoiInfo.getEvaluationCount() > 0 || xPPoiInfo.isFreeParking()) {
            commonViewHolder.initVisitContainer();
            commonViewHolder.mVisitContainer.setVisibility(0);
            if (xPPoiInfo.getVisitCount() > 0) {
                commonViewHolder.mTvVisitCount.setVisibility(0);
                commonViewHolder.mTvVisitCount.setText(String.format(ContextUtils.getString(R.string.search_result_visit_count), Integer.valueOf(xPPoiInfo.getVisitCount())));
            } else {
                commonViewHolder.mTvVisitCount.setVisibility(8);
            }
            if (xPPoiInfo.getEvaluationCount() > 0) {
                commonViewHolder.mTvEvaluationCount.setVisibility(0);
                commonViewHolder.mTvEvaluationCount.setText(String.format(ContextUtils.getString(R.string.search_result_evaluation_count), Integer.valueOf(xPPoiInfo.getEvaluationCount())));
            } else {
                commonViewHolder.mTvEvaluationCount.setVisibility(8);
            }
            if (xPPoiInfo.isFreeParking()) {
                commonViewHolder.mTvStopFavourable.setVisibility(0);
            } else {
                commonViewHolder.mTvStopFavourable.setVisibility(8);
            }
        } else if (commonViewHolder.mVisitContainer != null) {
            commonViewHolder.mVisitContainer.setVisibility(8);
        }
        String blCategory = xPPoiInfo.getBlCategory();
        if (this.mIsFoodOpen && !TextUtils.isEmpty(blCategory) && blCategory.startsWith(XPPoiCategory.SEARCH_CATEGORY_FOOD)) {
            commonViewHolder.initStarContainer();
            if (xPPoiInfo.getRating() > 0.0f || !TextUtils.isEmpty(xPPoiInfo.getPrice())) {
                commonViewHolder.mStarInfoStub.setVisibility(0);
                commonViewHolder.mRatingBar.setVisibility(0);
                commonViewHolder.mRatingBar.setRating(xPPoiInfo.getRating());
                try {
                    i2 = (int) Float.parseFloat(xPPoiInfo.getPrice());
                } catch (Exception unused) {
                    i2 = 0;
                }
                if (i2 > 0) {
                    commonViewHolder.mCost.setVisibility(0);
                    commonViewHolder.mCost.setText(String.format(ContextUtils.getString(R.string.search_result_cost), String.valueOf(i2)));
                } else {
                    commonViewHolder.mCost.setVisibility(8);
                }
            } else {
                commonViewHolder.mStarInfoStub.setVisibility(8);
            }
        } else if (commonViewHolder.mStarInfoStub != null) {
            if (L.ENABLE) {
                L.d(TAG, "holder.mStarInfoStub set gone");
            }
            commonViewHolder.mStarInfoStub.setVisibility(8);
        }
        XPDeepInfoPoi xPDeepInfoPoi = xPPoiInfo.getXPDeepInfoPoi();
        XPDeepCharging xPDeepCharging = (xPDeepInfoPoi == null || xPDeepInfoPoi.getChargeData() == null || xPDeepInfoPoi.getChargeData().length <= 0) ? null : xPDeepInfoPoi.getChargeData()[0];
        if (xPDeepCharging != null) {
            commonViewHolder.initChargeContainer();
            if (XPPoiCategory.isXPSelfCharge(xPPoiInfo.getCategory())) {
                Drawable drawable = ThemeWatcherUtil.getDrawable(R.drawable.png_tag_texttag_midoperateid_ziying);
                if (drawable != null) {
                    drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                }
                commonViewHolder.mTvName.setCompoundDrawables(drawable, null, null, null);
            } else {
                commonViewHolder.mTvName.setCompoundDrawables(null, null, null, null);
            }
            if (xPDeepCharging.getNumFastFree() <= 0 && xPDeepCharging.getNumFast() <= 0) {
                commonViewHolder.mChargeFastIcon.setVisibility(8);
                commonViewHolder.mTvChargeFastFree.setVisibility(8);
                commonViewHolder.mTvChargeFastFreeNum.setVisibility(8);
                commonViewHolder.mTvChargeFastTotal.setVisibility(8);
            } else {
                commonViewHolder.mChargeFastIcon.setVisibility(0);
                commonViewHolder.mTvChargeFastFree.setVisibility(0);
                commonViewHolder.mTvChargeFastFreeNum.setVisibility(0);
                commonViewHolder.mTvChargeFastTotal.setVisibility(0);
                if (xPDeepCharging.getNumFastFree() >= 0) {
                    commonViewHolder.mTvChargeFastFree.setText(R.string.poi_charge_status_available_text);
                    commonViewHolder.mTvChargeFastFreeNum.setText(String.valueOf(xPDeepCharging.getNumFastFree()));
                    commonViewHolder.mTvChargeFastTotal.setText(MqttTopic.TOPIC_LEVEL_SEPARATOR + String.format(ContextUtils.getString(R.string.poi_charge_status_used), Integer.valueOf(xPDeepCharging.getNumFast())));
                } else {
                    commonViewHolder.mTvChargeFastFree.setText("");
                    commonViewHolder.mTvChargeFastFreeNum.setText("");
                    commonViewHolder.mTvChargeFastTotal.setText(String.format(ContextUtils.getString(R.string.poi_charge_status_total), Integer.valueOf(xPDeepCharging.getNumFast())));
                }
                commonViewHolder.mChargeFastIcon.setImageResource(getChargeImageRes(xPDeepCharging.getNumFastFree(), true));
                int chargeFreeTextColor = getChargeFreeTextColor(xPDeepCharging.getNumFastFree(), true);
                commonViewHolder.mTvChargeFastFree.setTextColor(chargeFreeTextColor);
                commonViewHolder.mTvChargeFastFreeNum.setTextColor(chargeFreeTextColor);
            }
            if (xPDeepCharging.getNumSlowFree() <= 0 && xPDeepCharging.getNumSlow() <= 0) {
                commonViewHolder.mChargeSlowIcon.setVisibility(8);
                commonViewHolder.mTvChargeSlowFree.setVisibility(8);
                commonViewHolder.mTvChargeSlowFreeNum.setVisibility(8);
                commonViewHolder.mTvChargeSlowTotal.setVisibility(8);
            } else {
                commonViewHolder.mChargeSlowIcon.setVisibility(0);
                commonViewHolder.mTvChargeSlowFree.setVisibility(0);
                commonViewHolder.mTvChargeSlowFreeNum.setVisibility(0);
                commonViewHolder.mTvChargeSlowTotal.setVisibility(0);
                if (xPDeepCharging.getNumSlowFree() >= 0) {
                    commonViewHolder.mTvChargeSlowFree.setText(R.string.poi_charge_status_available_text);
                    commonViewHolder.mTvChargeSlowFreeNum.setText(String.valueOf(xPDeepCharging.getNumSlowFree()));
                    commonViewHolder.mTvChargeSlowTotal.setText(MqttTopic.TOPIC_LEVEL_SEPARATOR + String.format(ContextUtils.getString(R.string.poi_charge_status_used), Integer.valueOf(xPDeepCharging.getNumSlow())));
                } else {
                    commonViewHolder.mTvChargeSlowFree.setText("");
                    commonViewHolder.mTvChargeSlowFreeNum.setText("");
                    commonViewHolder.mTvChargeSlowTotal.setText(String.format(ContextUtils.getString(R.string.poi_charge_status_total), Integer.valueOf(xPDeepCharging.getNumSlow())));
                }
                commonViewHolder.mChargeSlowIcon.setImageResource(getChargeImageRes(xPDeepCharging.getNumSlowFree(), false));
                int chargeFreeTextColor2 = getChargeFreeTextColor(xPDeepCharging.getNumSlowFree(), false);
                commonViewHolder.mTvChargeSlowFree.setTextColor(chargeFreeTextColor2);
                commonViewHolder.mTvChargeSlowFreeNum.setTextColor(chargeFreeTextColor2);
            }
            if (commonViewHolder.mChargeFastIcon.getVisibility() == 0 || commonViewHolder.mChargeSlowIcon.getVisibility() == 0) {
                commonViewHolder.mChargeInfoStub.setVisibility(0);
            } else {
                commonViewHolder.mChargeInfoStub.setVisibility(8);
            }
        }
        if (xPPoiInfo.getParkTotal() >= 0 || xPPoiInfo.getParkRemain() >= 0) {
            commonViewHolder.initParkInfoContainer();
            commonViewHolder.mParkInfoStub.setVisibility(0);
            commonViewHolder.mParkChargeStatusView.initParkSpaceData(xPPoiInfo);
        } else if (commonViewHolder.mParkInfoStub != null) {
            commonViewHolder.mParkInfoStub.setVisibility(8);
        }
        if (CollectionUtils.isNotEmpty(xPPoiInfo.getChild())) {
            commonViewHolder.initChildInfoContainer();
            commonViewHolder.mChildInfoStub.setVisibility(0);
            commonViewHolder.mContainerChild.removeAllViews();
            showChildViews(commonViewHolder, i, xPPoiInfo);
        } else if (commonViewHolder.mChildInfoStub != null) {
            commonViewHolder.mChildInfoStub.setVisibility(8);
        }
    }

    private int getChargeImageRes(int i, boolean z) {
        if (i == 0) {
            return ThemeWatcherUtil.getDrawableResId(z ? R.drawable.vector_tag_texttag_smallunavailable_quick : R.drawable.vector_tag_texttag_smallunavailable_slow);
        }
        return ThemeWatcherUtil.getDrawableResId(z ? R.drawable.vector_tag_texttag_smallquick : R.drawable.vector_tag_texttag_smallslow);
    }

    private int getChargeFreeTextColor(int i, boolean z) {
        if (i == 0) {
            return ThemeWatcherUtil.getColor(R.color.primary_text03);
        }
        return ThemeWatcherUtil.getColor(z ? R.color.vector_midquick_path1_fill_color : R.color.vector_midslow_path1_fill_color);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00e1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void bindPriceView(com.xiaopeng.montecarlo.scenes.searchscene.SearchResultAdapter.CommonViewHolder r12, com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo r13) {
        /*
            Method dump skipped, instructions count: 264
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.scenes.searchscene.SearchResultAdapter.bindPriceView(com.xiaopeng.montecarlo.scenes.searchscene.SearchResultAdapter$CommonViewHolder, com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00e4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void bindOpenTimeView(com.xiaopeng.montecarlo.scenes.searchscene.SearchResultAdapter.CommonViewHolder r7, com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo r8) {
        /*
            r6 = this;
            if (r7 == 0) goto Lf4
            if (r8 != 0) goto L6
            goto Lf4
        L6:
            java.lang.String r0 = r8.getOpenTime()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            r1 = 8
            r2 = 0
            r3 = 0
            if (r0 == 0) goto L1b
            com.xiaopeng.xui.widget.XTextView r8 = r7.mTvOpenTime
            r8.setVisibility(r1)
            goto L96
        L1b:
            int r0 = r8.getCategory()
            boolean r0 = com.xiaopeng.montecarlo.navcore.bean.search.XPPoiCategory.isXPSelfCharge(r0)
            if (r0 != 0) goto L98
            int r0 = r8.getCategory()
            boolean r0 = com.xiaopeng.montecarlo.navcore.bean.search.XPPoiCategory.isCommonCharge(r0)
            if (r0 != 0) goto L98
            int r0 = r8.getCategory()
            boolean r0 = com.xiaopeng.montecarlo.navcore.bean.search.XPPoiCategory.isXPJoinCharge(r0)
            if (r0 != 0) goto L98
            int r0 = r8.getCategory()
            boolean r0 = com.xiaopeng.montecarlo.navcore.bean.search.XPPoiCategory.isXPCooperateCharge(r0)
            if (r0 == 0) goto L44
            goto L98
        L44:
            com.xiaopeng.xui.widget.XTextView r0 = r7.mTvOpenTime
            r0.setVisibility(r2)
            java.lang.String r8 = r8.getOpenTime()
            java.lang.String r0 = "\n"
            boolean r1 = r8.contains(r0)
            if (r1 == 0) goto L91
            r1 = 2131690262(0x7f0f0316, float:1.9009563E38)
            java.lang.String r4 = com.xiaopeng.montecarlo.root.util.ContextUtils.getString(r1)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r1 = com.xiaopeng.montecarlo.root.util.ContextUtils.getString(r1)
            r5.append(r1)
            r5.append(r0)
            java.lang.String r1 = r5.toString()
            java.lang.String r8 = r8.replace(r4, r1)
            r1 = 2131690261(0x7f0f0315, float:1.900956E38)
            java.lang.String r4 = com.xiaopeng.montecarlo.root.util.ContextUtils.getString(r1)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r1 = com.xiaopeng.montecarlo.root.util.ContextUtils.getString(r1)
            r5.append(r1)
            r5.append(r0)
            java.lang.String r0 = r5.toString()
            java.lang.String r8 = r8.replace(r4, r0)
        L91:
            com.xiaopeng.xui.widget.XTextView r0 = r7.mTvOpenTime
            r0.setText(r8)
        L96:
            r8 = r3
            goto Le2
        L98:
            com.xiaopeng.xui.widget.XTextView r0 = r7.mTvOpenTime
            r0.setVisibility(r1)
            java.lang.String r0 = r8.getOpenTime()
            boolean r0 = com.xiaopeng.montecarlo.util.OpenTimeUtils.is24Hour(r0)
            if (r0 == 0) goto Laf
            r8 = 2131231903(0x7f08049f, float:1.80799E38)
            android.graphics.drawable.Drawable r8 = com.xiaopeng.montecarlo.util.ThemeWatcherUtil.getDrawable(r8)
            goto Le2
        Laf:
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat
            java.util.Locale r1 = java.util.Locale.getDefault()
            java.lang.String r4 = "EEEE HH:mm"
            r0.<init>(r4, r1)
            long r4 = java.lang.System.currentTimeMillis()
            java.lang.Long r1 = java.lang.Long.valueOf(r4)
            java.lang.String r0 = r0.format(r1)
            java.lang.String r1 = " "
            java.lang.String[] r0 = r0.split(r1)
            java.lang.String r8 = r8.getOpenTime()
            r1 = r0[r2]
            r4 = 1
            r0 = r0[r4]
            boolean r8 = com.xiaopeng.montecarlo.util.OpenTimeUtils.isOpenTime(r8, r1, r0)
            if (r8 == 0) goto L96
            r8 = 2131231905(0x7f0804a1, float:1.8079904E38)
            android.graphics.drawable.Drawable r8 = com.xiaopeng.montecarlo.util.ThemeWatcherUtil.getDrawable(r8)
        Le2:
            if (r8 == 0) goto Lef
            int r0 = r8.getIntrinsicWidth()
            int r1 = r8.getIntrinsicHeight()
            r8.setBounds(r2, r2, r0, r1)
        Lef:
            com.xiaopeng.xui.widget.XTextView r7 = r7.mTvPriceInfo
            r7.setCompoundDrawables(r8, r3, r3, r3)
        Lf4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.scenes.searchscene.SearchResultAdapter.bindOpenTimeView(com.xiaopeng.montecarlo.scenes.searchscene.SearchResultAdapter$CommonViewHolder, com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo):void");
    }

    private void bindAddWayResultViewHolder(AddWayResultViewHolder addWayResultViewHolder, XPPoiInfo xPPoiInfo) {
        if (NaviUtil.isExistedViaPoi(xPPoiInfo)) {
            addWayResultViewHolder.mSetWayPointView.getContainerAddWayPoint().setVisibility(8);
            addWayResultViewHolder.mSetWayPointView.getContainerDeleteWayPoint().setVisibility(0);
            return;
        }
        addWayResultViewHolder.mSetWayPointView.getContainerAddWayPoint().setVisibility(0);
        addWayResultViewHolder.mSetWayPointView.getContainerDeleteWayPoint().setVisibility(8);
    }

    private void bindSetResultViewHolder(SetResultViewHolder setResultViewHolder, XPPoiInfo xPPoiInfo) {
        int i = this.mSearchDest;
        if (i == 1001) {
            setResultViewHolder.mSetHomeOfficeView.setViewType(0);
        } else if (i == 1002) {
            setResultViewHolder.mSetHomeOfficeView.setViewType(1);
        }
    }

    private void bindGotoPoiResultViewHolder(GotoPoiResultViewHolder gotoPoiResultViewHolder, XPPoiInfo xPPoiInfo) {
        if (xPPoiInfo == null) {
            return;
        }
        if (xPPoiInfo.hasDisplayLatLonInfo()) {
            gotoPoiResultViewHolder.mContainerGotoPoi.setVisibility(0);
            gotoPoiResultViewHolder.mContainerGotoPoi.setText(NaviUtil.getDistanceString(xPPoiInfo.getDistance()));
            return;
        }
        gotoPoiResultViewHolder.mContainerGotoPoi.setVisibility(8);
    }

    private void showChildViews(final CommonViewHolder commonViewHolder, final int i, XPPoiInfo xPPoiInfo) {
        if (commonViewHolder == null || commonViewHolder.mContainerChild == null || xPPoiInfo == null || xPPoiInfo.getChild() == null) {
            return;
        }
        int size = xPPoiInfo.getChild().size();
        ArrayList<XPPoiInfo> child = xPPoiInfo.getChild();
        commonViewHolder.mContainerChild.setChildViewClickListener(new ChildPoiGridView.ChildViewClickListener() { // from class: com.xiaopeng.montecarlo.scenes.searchscene.SearchResultAdapter.1
            @Override // com.xiaopeng.montecarlo.views.ChildPoiGridView.ChildViewClickListener
            public void onChildClick(View view, XPPoiInfo xPPoiInfo2) {
                int adapterPosition = commonViewHolder.getAdapterPosition();
                if (SearchResultAdapter.this.mSearchResultAdapterListener == null || adapterPosition == -1) {
                    return;
                }
                Object tag = view.getTag(R.id.sup_poi_item);
                if (tag != null) {
                    SearchResultAdapter.this.mSearchResultAdapterListener.onChildPoiClick(adapterPosition, ((Integer) tag).intValue());
                }
                SearchResultAdapter.this.updateSelectItem(i);
            }

            @Override // com.xiaopeng.montecarlo.views.ChildPoiGridView.ChildViewClickListener
            public void onExpandViewClick(boolean z) {
                if (z) {
                    SearchResultAdapter.this.mExpandIndexs.add(Integer.valueOf(i));
                } else {
                    SearchResultAdapter.this.mExpandIndexs.remove(Integer.valueOf(i));
                }
            }
        });
        commonViewHolder.mContainerChild.addChildViews(size, child);
        commonViewHolder.mContainerChild.expand(this.mExpandIndexs.contains(Integer.valueOf(i)));
        for (int i2 = 0; i2 < size; i2++) {
            if (XPPoiCategory.isParking(child.get(i2).getCategory())) {
                xPPoiInfo.setHasPark(true);
            }
        }
    }

    public void setSearchResultAdapterListener(SearchResultAdapterListener searchResultAdapterListener) {
        this.mSearchResultAdapterListener = searchResultAdapterListener;
    }

    public void updateSelectItem(int i) {
        this.mSelectedIndex = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleItemClick(int i) {
        if (this.mSearchResultAdapterListener == null || i == -1) {
            return;
        }
        updateSelectItem(i);
        this.mSearchResultAdapterListener.onItemClick(i);
    }

    /* loaded from: classes3.dex */
    private static class ResultType {
        static final int RESULT_TYPE_ADDWAY = 2;
        static final int RESULT_TYPE_GOTO_POI = 3;
        static final int RESULT_TYPE_SET = 1;

        private ResultType() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class CommonViewHolder extends XpSearchViewHolder implements View.OnClickListener {
        XImageView mChargeFastIcon;
        View mChargeInfoStub;
        XImageView mChargeSlowIcon;
        View mChildInfoStub;
        @BindView(R.id.search_result_item_container)
        XRelativeLayout mContainer;
        ChildPoiGridView mContainerChild;
        XTextView mCost;
        @BindView(R.id.search_result_item_detail)
        XLinearLayout mItemDetail;
        ParkChargeStatusView mParkChargeStatusView;
        View mParkInfoStub;
        RatingBar mRatingBar;
        View mRootView;
        View mStarInfoStub;
        @BindView(R.id.search_result_address_name)
        XTextView mTvAddress;
        @BindView(R.id.search_result_address_type)
        XTextView mTvAddressType;
        XTextView mTvChargeFastFree;
        XTextView mTvChargeFastFreeNum;
        XTextView mTvChargeFastTotal;
        XTextView mTvChargeSlowFree;
        XTextView mTvChargeSlowFreeNum;
        XTextView mTvChargeSlowTotal;
        @BindView(R.id.search_result_distance)
        XTextView mTvDistance;
        XTextView mTvEvaluationCount;
        @BindView(R.id.search_result_name)
        XTextView mTvName;
        @BindView(R.id.search_result_open_time)
        XTextView mTvOpenTime;
        @BindView(R.id.search_result_order)
        XTextView mTvOrder;
        @BindView(R.id.tv_price_info)
        XTextView mTvPriceInfo;
        @BindView(R.id.tv_road_info)
        XTextView mTvRoadInfo;
        XTextView mTvStopFavourable;
        XTextView mTvVisitCount;
        View mVisitContainer;
        ViewStub mVisitContainerStub;

        public CommonViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            this.mRootView = view;
            this.mContainer.setOnClickListener(this);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.xiaopeng.montecarlo.scenes.searchscene.XpSearchViewHolder
        public XPPoiInfo getPoiInfo(int i) {
            List<XPPoiInfo> data = SearchResultAdapter.this.getData();
            if (!CollectionUtils.isNotEmpty(data) || i < 0 || i >= data.size()) {
                return null;
            }
            return data.get(i);
        }

        void initStarContainer() {
            if (this.mStarInfoStub == null) {
                this.mStarInfoStub = ((ViewStub) this.mRootView.findViewById(R.id.rating_star_stub)).inflate();
                this.mRatingBar = (RatingBar) this.mStarInfoStub.findViewById(R.id.search_result_rating_bar);
                this.mCost = (XTextView) this.mStarInfoStub.findViewById(R.id.search_result_cost);
            }
        }

        void initChargeContainer() {
            if (this.mChargeInfoStub == null) {
                this.mChargeInfoStub = ((ViewStub) this.mRootView.findViewById(R.id.container_charge_info_stub)).inflate();
                this.mChargeFastIcon = (XImageView) this.mChargeInfoStub.findViewById(R.id.charge_icon_quick);
                this.mTvChargeFastFree = (XTextView) this.mChargeInfoStub.findViewById(R.id.tv_fast_free);
                this.mTvChargeFastFreeNum = (XTextView) this.mChargeInfoStub.findViewById(R.id.tv_fast_free_num);
                this.mTvChargeFastTotal = (XTextView) this.mChargeInfoStub.findViewById(R.id.tv_fast_total);
                this.mChargeSlowIcon = (XImageView) this.mChargeInfoStub.findViewById(R.id.charge_icon_slow);
                this.mTvChargeSlowFree = (XTextView) this.mChargeInfoStub.findViewById(R.id.tv_slow_free);
                this.mTvChargeSlowFreeNum = (XTextView) this.mChargeInfoStub.findViewById(R.id.tv_slow_free_num);
                this.mTvChargeSlowTotal = (XTextView) this.mChargeInfoStub.findViewById(R.id.tv_slow_total);
            }
        }

        void initParkInfoContainer() {
            if (this.mParkInfoStub == null) {
                this.mParkInfoStub = ((ViewStub) this.mRootView.findViewById(R.id.container_park_info_stub)).inflate();
                this.mParkChargeStatusView = (ParkChargeStatusView) this.mParkInfoStub.findViewById(R.id.park_space_view);
            }
        }

        void initChildInfoContainer() {
            if (this.mChildInfoStub == null) {
                this.mChildInfoStub = ((ViewStub) this.mRootView.findViewById(R.id.container_child_info_stub)).inflate();
                this.mContainerChild = (ChildPoiGridView) this.mChildInfoStub.findViewById(R.id.container_child);
            }
        }

        void initVisitContainer() {
            if (this.mVisitContainerStub == null) {
                this.mVisitContainerStub = (ViewStub) this.mRootView.findViewById(R.id.container_evaluation_stub);
                View inflate = this.mVisitContainerStub.inflate();
                this.mVisitContainer = inflate.findViewById(R.id.container_evaluation);
                this.mTvVisitCount = (XTextView) inflate.findViewById(R.id.tv_visit_count);
                this.mTvStopFavourable = (XTextView) inflate.findViewById(R.id.tv_stop_favourable);
                this.mTvEvaluationCount = (XTextView) inflate.findViewById(R.id.tv_evaluation_count);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int positionFromViewHolder = SearchResultAdapter.this.getPositionFromViewHolder(this);
            if (view.getId() != R.id.search_result_item_container) {
                return;
            }
            SearchResultAdapter.this.handleItemClick(positionFromViewHolder);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class SetResultViewHolder extends CommonViewHolder implements SetHomeOfficeView.SetHomeOfficeClickListener {
        @BindView(R.id.container_set_home_office)
        SetHomeOfficeView mSetHomeOfficeView;

        public SetResultViewHolder(View view) {
            super(view);
            this.mSetHomeOfficeView.setListener(this);
        }

        @Override // com.xiaopeng.montecarlo.views.SetHomeOfficeView.SetHomeOfficeClickListener
        public void onClickSetHome(View view) {
            super.onClick(view);
            int positionFromViewHolder = SearchResultAdapter.this.getPositionFromViewHolder(this);
            if (SearchResultAdapter.this.mSearchResultAdapterListener == null || positionFromViewHolder == -1) {
                return;
            }
            SearchResultAdapter.this.mSearchResultAdapterListener.onSetHomeClick(positionFromViewHolder);
        }

        @Override // com.xiaopeng.montecarlo.views.SetHomeOfficeView.SetHomeOfficeClickListener
        public void onClickSetOffice(View view) {
            super.onClick(view);
            int positionFromViewHolder = SearchResultAdapter.this.getPositionFromViewHolder(this);
            if (SearchResultAdapter.this.mSearchResultAdapterListener == null || positionFromViewHolder == -1) {
                return;
            }
            SearchResultAdapter.this.mSearchResultAdapterListener.onSetCompanyClick(positionFromViewHolder);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class GotoPoiResultViewHolder extends CommonViewHolder implements GotoPoiView.GotoPoiClickListener {
        @BindView(R.id.container_goto_poi_view)
        GotoPoiView mContainerGotoPoi;

        public GotoPoiResultViewHolder(View view) {
            super(view);
            this.mContainerGotoPoi.setListener(this);
        }

        @Override // com.xiaopeng.montecarlo.views.GotoPoiView.GotoPoiClickListener
        public void onClickGotoPoi(View view) {
            super.onClick(view);
            int positionFromViewHolder = SearchResultAdapter.this.getPositionFromViewHolder(this);
            if (SearchResultAdapter.this.mSearchResultAdapterListener == null || positionFromViewHolder == -1) {
                return;
            }
            SearchResultAdapter.this.mSearchResultAdapterListener.onGoToPoiClick(positionFromViewHolder);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class AddWayResultViewHolder extends CommonViewHolder implements SetWayPointView.WayPointClickListener {
        @BindView(R.id.container_set_waypoint)
        SetWayPointView mSetWayPointView;

        public AddWayResultViewHolder(View view) {
            super(view);
            this.mSetWayPointView.setListener(this);
        }

        @Override // com.xiaopeng.montecarlo.views.SetWayPointView.WayPointClickListener
        public void onClickAddWayPoint(View view) {
            super.onClick(view);
            int positionFromViewHolder = SearchResultAdapter.this.getPositionFromViewHolder(this);
            if (SearchResultAdapter.this.mSearchResultAdapterListener == null || positionFromViewHolder == -1) {
                return;
            }
            SearchResultAdapter.this.mSearchResultAdapterListener.onAddWayClick(positionFromViewHolder);
        }

        @Override // com.xiaopeng.montecarlo.views.SetWayPointView.WayPointClickListener
        public void onClickDeleteWayPoint(View view) {
            super.onClick(view);
            int positionFromViewHolder = SearchResultAdapter.this.getPositionFromViewHolder(this);
            if (SearchResultAdapter.this.mSearchResultAdapterListener == null || positionFromViewHolder == -1) {
                return;
            }
            SearchResultAdapter.this.mSearchResultAdapterListener.onRemoveWayClick(positionFromViewHolder);
        }

        @Override // com.xiaopeng.montecarlo.views.SetWayPointView.WayPointClickListener
        public void onClickGotoWayPoint(View view) {
            super.onClick(view);
            int positionFromViewHolder = SearchResultAdapter.this.getPositionFromViewHolder(this);
            if (SearchResultAdapter.this.mSearchResultAdapterListener == null || positionFromViewHolder == -1) {
                return;
            }
            SearchResultAdapter.this.mSearchResultAdapterListener.onAddNewNaviClick(positionFromViewHolder);
        }
    }
}
