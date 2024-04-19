package com.xiaopeng.montecarlo.views.poicard;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
import com.xiaopeng.montecarlo.scenes.searchscene.SearchSceneDataHelper;
import com.xiaopeng.montecarlo.views.NaviImageView;
import com.xiaopeng.xui.widget.XRelativeLayout;
import com.xiaopeng.xui.widget.XTextView;
import java.util.Map;
/* loaded from: classes3.dex */
public class PoiCardRoadInfoContainer extends XRelativeLayout implements BasePoiCardViewContract {
    public static final String KEY_POI_INFO = "poiInfo";
    private static final int MESSAGE_BL_ROAD_INFO_FORMAT_COMPLETED = 0;
    private static final L.Tag TAG = new L.Tag("Card_PCRIC");
    private Context mContext;
    private Handler mHandler;
    private LayoutInflater mInflater;
    private OnChildLayoutCompletedListener mLayoutListener;
    private XPPoiInfo mPoiInfo;
    private XTextView mRoadInfo;
    private NaviImageView mRoadInfoDivider;
    private ViewGroup mRootView;

    @Override // com.xiaopeng.montecarlo.views.poicard.BasePoiCardViewContract
    public void onInitOrThemeSwitch() {
    }

    @Override // com.xiaopeng.montecarlo.views.poicard.BasePoiCardViewContract
    public void setViewListener() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleBlRoadInfoFormatCompleted(Message message) {
        setRoadInfo((SpannableString) message.obj);
    }

    public PoiCardRoadInfoContainer(Context context, Map<String, Object> map, OnChildLayoutCompletedListener onChildLayoutCompletedListener) {
        super(context);
        this.mHandler = new Handler() { // from class: com.xiaopeng.montecarlo.views.poicard.PoiCardRoadInfoContainer.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what != 0) {
                    return;
                }
                PoiCardRoadInfoContainer.this.handleBlRoadInfoFormatCompleted(message);
            }
        };
        this.mLayoutListener = onChildLayoutCompletedListener;
        init(context, map);
    }

    private void initView() {
        this.mInflater = LayoutInflater.from(this.mContext);
        this.mRootView = (ViewGroup) this.mInflater.inflate(R.layout.layout_poi_road_info, (ViewGroup) this, true);
        this.mRootView.setMinimumHeight(ContextUtils.getDimensionPixelSize(R.dimen.poi_item_height));
        executeAfterViewInflated(this.mRootView);
    }

    public void setRoadInfoDividerImageResource(int i) {
        NaviImageView naviImageView = this.mRoadInfoDivider;
        if (naviImageView != null) {
            naviImageView.setImageResource(i);
        }
    }

    public void setRoadInfo(SpannableString spannableString) {
        XTextView xTextView = this.mRoadInfo;
        if (xTextView != null) {
            xTextView.setText(spannableString);
        }
    }

    @Override // com.xiaopeng.montecarlo.views.poicard.BasePoiCardViewContract
    public void init(Context context, Map<String, Object> map) {
        formatParams(context, map);
        initView();
    }

    @Override // com.xiaopeng.montecarlo.views.poicard.BasePoiCardViewContract
    public void executeAfterViewInflated(View view) {
        if (view == null) {
            L.e(TAG, "execute after view inflated view is null");
            return;
        }
        this.mRoadInfo = (XTextView) view.findViewById(R.id.tv_road_info);
        this.mRoadInfoDivider = (NaviImageView) view.findViewById(R.id.road_info_divider);
        executeViewOperation();
        OnChildLayoutCompletedListener onChildLayoutCompletedListener = this.mLayoutListener;
        if (onChildLayoutCompletedListener != null) {
            onChildLayoutCompletedListener.onChildLayoutCompleted(this.mRootView);
        }
    }

    @Override // com.xiaopeng.montecarlo.views.poicard.BasePoiCardViewContract
    public void executeViewOperation() {
        setViewListener();
        renderRoadInfo();
    }

    @Override // com.xiaopeng.montecarlo.views.poicard.BasePoiCardViewContract
    public void refresh(Context context, Map<String, Object> map, OnChildLayoutCompletedListener onChildLayoutCompletedListener) {
        this.mLayoutListener = onChildLayoutCompletedListener;
        formatParams(context, map);
        executeViewOperation();
    }

    @Override // com.xiaopeng.montecarlo.views.poicard.BasePoiCardViewContract
    public void formatParams(Context context, Map<String, Object> map) {
        if (context == null) {
            throw new IllegalArgumentException("context can not be null");
        }
        if (map == null) {
            throw new IllegalArgumentException("params can not be null");
        }
        this.mContext = context;
        if (map.get("poiInfo") != null) {
            this.mPoiInfo = (XPPoiInfo) map.get("poiInfo");
        }
    }

    private void renderRoadInfo() {
        hideRoadInfo();
        XPPoiInfo xPPoiInfo = this.mPoiInfo;
        if (xPPoiInfo == null || TextUtils.isEmpty(xPPoiInfo.getRoadInfo())) {
            return;
        }
        showRoadInfo();
    }

    private void showRoadInfo() {
        setVisibility(0);
        WorkThreadUtil.getInstance().executeCachedTask(new Runnable() { // from class: com.xiaopeng.montecarlo.views.poicard.PoiCardRoadInfoContainer.2
            @Override // java.lang.Runnable
            public void run() {
                SpannableString formatBLRoadInfo = SearchSceneDataHelper.formatBLRoadInfo(PoiCardRoadInfoContainer.this.mPoiInfo);
                Message obtainMessage = PoiCardRoadInfoContainer.this.mHandler.obtainMessage(0);
                obtainMessage.obj = formatBLRoadInfo;
                PoiCardRoadInfoContainer.this.mHandler.sendMessage(obtainMessage);
            }
        });
    }

    private void hideRoadInfo() {
        setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.xui.widget.XRelativeLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mLayoutListener = null;
    }
}
