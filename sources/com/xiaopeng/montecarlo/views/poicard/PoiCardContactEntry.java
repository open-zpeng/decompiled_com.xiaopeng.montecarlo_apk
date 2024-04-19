package com.xiaopeng.montecarlo.views.poicard;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.base.MainContext;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.stat.PoiPopStatUtil;
import com.xiaopeng.montecarlo.views.dialog.NumPopDialog;
import com.xiaopeng.montecarlo.views.poicard.PoiCardEntryContainer;
import com.xiaopeng.xui.widget.XLinearLayout;
import com.xiaopeng.xui.widget.XTextView;
import java.util.Map;
/* loaded from: classes3.dex */
public class PoiCardContactEntry extends XLinearLayout implements BasePoiCardViewContract {
    private static final int MIN_CLICK_DELAY_TIME = 1000;
    private static final L.Tag TAG = new L.Tag("PoiCardContactEntry");
    private static long lastClickTime = 0;
    private XTextView mBtnContact;
    private LinearLayout mBtnContactContainer;
    private int mCardType;
    private PoiCardEntryContainer.OnPoiCardEntryContainerClickListener mClickListener;
    private Context mContext;
    private LayoutInflater mInflater;
    private OnChildLayoutCompletedListener mLayoutListener;
    private MainContext mMainContext;
    private onPopDialogShow mNumPopDialogListener;
    private XPPoiInfo mPoiInfo;
    private ViewGroup mRootView;

    @Override // com.xiaopeng.montecarlo.views.poicard.BasePoiCardViewContract
    public void onInitOrThemeSwitch() {
    }

    @Override // com.xiaopeng.montecarlo.views.poicard.BasePoiCardViewContract
    public void refresh(Context context, Map<String, Object> map, OnChildLayoutCompletedListener onChildLayoutCompletedListener) {
    }

    @Override // com.xiaopeng.montecarlo.views.poicard.BasePoiCardViewContract
    public void setViewListener() {
    }

    public PoiCardContactEntry(Context context, Map<String, Object> map, OnChildLayoutCompletedListener onChildLayoutCompletedListener) {
        super(context);
        this.mLayoutListener = onChildLayoutCompletedListener;
        init(context, map);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.xui.widget.XLinearLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.xui.widget.XLinearLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mLayoutListener = null;
    }

    @Override // com.xiaopeng.montecarlo.views.poicard.BasePoiCardViewContract
    public void init(Context context, Map<String, Object> map) {
        formatParams(context, map);
        initView();
    }

    private void initView() {
        this.mInflater = LayoutInflater.from(this.mContext);
        this.mRootView = (ViewGroup) this.mInflater.inflate(R.layout.layout_poi_entry_item_contact, (ViewGroup) this, true);
        setOrientation(1);
        setMinimumHeight(ContextUtils.getDimensionPixelSize(R.dimen.poi_item_height));
        executeAfterViewInflated(this.mRootView);
    }

    @Override // com.xiaopeng.montecarlo.views.poicard.BasePoiCardViewContract
    public void executeAfterViewInflated(View view) {
        if (view == null) {
            L.e(TAG, "execute after view inflated view is null");
            return;
        }
        this.mBtnContactContainer = (LinearLayout) view.findViewById(R.id.poi_btn_contact_container);
        this.mBtnContact = (XTextView) view.findViewById(R.id.poi_btn_contact);
        executeViewOperation();
        OnChildLayoutCompletedListener onChildLayoutCompletedListener = this.mLayoutListener;
        if (onChildLayoutCompletedListener != null) {
            onChildLayoutCompletedListener.onChildLayoutCompleted(this.mRootView);
        }
    }

    @Override // com.xiaopeng.montecarlo.views.poicard.BasePoiCardViewContract
    public void executeViewOperation() {
        setViewListener();
        renderContactInfo();
    }

    public void renderContactInfo() {
        XPPoiInfo xPPoiInfo = this.mPoiInfo;
        if (xPPoiInfo == null) {
            return;
        }
        if (this.mCardType == 5) {
            if (L.ENABLE) {
                L.d(TAG, "renderContactInfo mCardType: PoiCardType.CARD_TYPE_RGC");
            }
            hideContact();
            return;
        }
        String tel = xPPoiInfo.getTel();
        if (!(!TextUtils.isEmpty(tel))) {
            hideContact();
            return;
        }
        showContactInfo(tel);
        showContact();
    }

    public void showContactInfo(final String str) {
        XTextView xTextView = this.mBtnContact;
        if (xTextView != null) {
            xTextView.setOnClickListener(new View.OnClickListener() { // from class: com.xiaopeng.montecarlo.views.poicard.PoiCardContactEntry.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - PoiCardContactEntry.lastClickTime < 1000) {
                        return;
                    }
                    PoiPopStatUtil.sendStatDataWhenDialWithBT(PoiCardContactEntry.this.mMainContext);
                    PoiCardContactEntry.this.showDialView(str);
                    long unused = PoiCardContactEntry.lastClickTime = currentTimeMillis;
                }
            });
        }
    }

    public void setOnNumPopDialogShowListener(onPopDialogShow onpopdialogshow) {
        this.mNumPopDialogListener = onpopdialogshow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialView(String str) {
        if (this.mMainContext == null) {
            return;
        }
        final NumPopDialog numPopDialog = new NumPopDialog(getContext(), str);
        numPopDialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.xiaopeng.montecarlo.views.poicard.PoiCardContactEntry.2
            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                if (PoiCardContactEntry.this.mNumPopDialogListener != null) {
                    PoiCardContactEntry.this.mNumPopDialogListener.onPopDialogShow(numPopDialog);
                }
            }
        });
        numPopDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.xiaopeng.montecarlo.views.poicard.PoiCardContactEntry.3
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (PoiCardContactEntry.this.mNumPopDialogListener != null) {
                    PoiCardContactEntry.this.mNumPopDialogListener.onPopDialogDismiss(numPopDialog);
                }
            }
        });
        numPopDialog.show();
    }

    public void hideContact() {
        hideBtnContactContainer();
    }

    public void showContact() {
        showBtnContactContainer();
        setVisibility(0);
    }

    public void hideBtnContactContainer() {
        LinearLayout linearLayout = this.mBtnContactContainer;
        if (linearLayout == null || linearLayout.getVisibility() == 8) {
            return;
        }
        this.mBtnContactContainer.setVisibility(8);
    }

    public void showBtnContactContainer() {
        LinearLayout linearLayout = this.mBtnContactContainer;
        if (linearLayout == null || linearLayout.getVisibility() == 0) {
            return;
        }
        this.mBtnContactContainer.setVisibility(0);
    }

    @Override // com.xiaopeng.montecarlo.views.poicard.BasePoiCardViewContract
    public void formatParams(Context context, Map<String, Object> map) {
        this.mContext = context;
        if (map.get("poiInfo") != null) {
            this.mPoiInfo = (XPPoiInfo) map.get("poiInfo");
        }
        if (map.get("cardType") != null) {
            this.mCardType = ((Integer) map.get("cardType")).intValue();
        }
        if (map.get("mainContext") != null) {
            this.mMainContext = (MainContext) map.get("mainContext");
        }
    }
}
