package com.xiaopeng.montecarlo.views.poicard;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.base.MainContext;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.util.ThemeWatcherUtil;
import com.xiaopeng.montecarlo.views.NaviImageView;
import com.xiaopeng.montecarlo.views.XpNetworkImageViewTarget;
import com.xiaopeng.montecarlo.views.dialog.PicPopDialog;
import com.xiaopeng.montecarlo.xpglide.IXpImageLoadListener;
import com.xiaopeng.xui.widget.XLoading;
import com.xiaopeng.xui.widget.XRelativeLayout;
import com.xiaopeng.xui.widget.XTextView;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class PoiCardPicContainer extends XRelativeLayout implements BasePoiCardViewContract, View.OnClickListener, IXpImageLoadListener {
    private static final int DELAY_TIME_FOR_MULTI_CLICK = 500;
    public static final String KEY_MAIN_CONTEXT = "mainContext";
    public static final String KEY_POI_INFO = "poiInfo";
    private static final L.Tag TAG = new L.Tag("Card_PCPC");
    private String mCardShowImgUrl;
    private Context mContext;
    private NaviImageView mIconPic;
    XpNetworkImageViewTarget mImageViewTarget;
    private LayoutInflater mInflater;
    private OnChildLayoutCompletedListener mLayoutListener;
    private MainContext mMainContext;
    private onPopDialogShow mOnPopDialogShowListener;
    private XTextView mPicNum;
    private XLoading mPicProgress;
    private XPPoiInfo mPoiInfo;
    private long mPreviousClickTime;
    private ViewGroup mRootView;

    @Override // com.xiaopeng.montecarlo.views.poicard.BasePoiCardViewContract
    public void onInitOrThemeSwitch() {
    }

    public PoiCardPicContainer(Context context, Map<String, Object> map, OnChildLayoutCompletedListener onChildLayoutCompletedListener) {
        super(context);
        this.mPreviousClickTime = 0L;
        this.mCardShowImgUrl = null;
        this.mLayoutListener = onChildLayoutCompletedListener;
        init(context, map);
    }

    private void initView() {
        this.mInflater = LayoutInflater.from(this.mContext);
        this.mRootView = (ViewGroup) this.mInflater.inflate(R.layout.layout_poi_card_pic_container, (ViewGroup) this, true);
        executeAfterViewInflated(this.mRootView);
    }

    public void hideIconPic() {
        NaviImageView naviImageView = this.mIconPic;
        if (naviImageView != null) {
            naviImageView.setVisibility(8);
        }
    }

    public void hidePicNum() {
        XTextView xTextView = this.mPicNum;
        if (xTextView != null) {
            xTextView.setVisibility(8);
        }
    }

    public void hidePicProgress() {
        XLoading xLoading = this.mPicProgress;
        if (xLoading != null) {
            xLoading.setVisibility(8);
        }
    }

    public void showIconPic() {
        NaviImageView naviImageView = this.mIconPic;
        if (naviImageView != null) {
            naviImageView.setVisibility(0);
        }
    }

    public void showPicNum() {
        XTextView xTextView = this.mPicNum;
        if (xTextView != null) {
            xTextView.setVisibility(0);
        }
    }

    public void showPicProgress() {
        XLoading xLoading = this.mPicProgress;
        if (xLoading != null) {
            xLoading.setVisibility(0);
        }
    }

    public void setPicNumText(String str) {
        XTextView xTextView = this.mPicNum;
        if (xTextView != null) {
            xTextView.setText(str);
        }
    }

    public void setIconPicImageDrawable(Drawable drawable) {
        NaviImageView naviImageView = this.mIconPic;
        if (naviImageView != null) {
            naviImageView.setImageDrawable(drawable);
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
        this.mIconPic = (NaviImageView) view.findViewById(R.id.poi_icon_pic);
        this.mPicProgress = (XLoading) view.findViewById(R.id.poi_icon_pic_progress);
        this.mPicNum = (XTextView) view.findViewById(R.id.poi_pic_num);
        executeViewOperation();
        OnChildLayoutCompletedListener onChildLayoutCompletedListener = this.mLayoutListener;
        if (onChildLayoutCompletedListener != null) {
            onChildLayoutCompletedListener.onChildLayoutCompleted(this.mRootView);
        }
    }

    @Override // com.xiaopeng.montecarlo.views.poicard.BasePoiCardViewContract
    public void executeViewOperation() {
        setViewListener();
        renderPics();
    }

    @Override // com.xiaopeng.montecarlo.views.poicard.BasePoiCardViewContract
    public void setViewListener() {
        NaviImageView naviImageView = this.mIconPic;
        if (naviImageView != null) {
            naviImageView.setOnClickListener(this);
        }
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
        if (map.get("mainContext") != null) {
            this.mMainContext = (MainContext) map.get("mainContext");
        }
    }

    private void renderPics() {
        XPPoiInfo xPPoiInfo;
        if (this.mIconPic == null || (xPPoiInfo = this.mPoiInfo) == null || CollectionUtils.isEmpty(xPPoiInfo.getImageUrlList())) {
            L.w(TAG, "renderPics poi info error or image list is null!");
            this.mCardShowImgUrl = null;
            hidePictures();
            return;
        }
        setVisibility(0);
        showIconPic();
        showPicNum();
        setPicNumText(String.valueOf(this.mPoiInfo.getImageUrlList().size()));
        String str = this.mPoiInfo.getImageUrlList().get(0);
        if (TextUtils.isEmpty(str)) {
            showFailPic();
        } else if (TextUtils.equals(this.mCardShowImgUrl, str)) {
        } else {
            this.mCardShowImgUrl = str;
            int dimensionPixelSize = ContextUtils.getDimensionPixelSize(R.dimen.poi_icon_pic_preview_width);
            int dimensionPixelSize2 = ContextUtils.getDimensionPixelSize(R.dimen.poi_icon_pic_preview_height);
            RequestOptions override = RequestOptions.bitmapTransform(new RoundedCorners(ContextUtils.getDimensionPixelSize(R.dimen.com_pic_round_corner__radius))).override(dimensionPixelSize, dimensionPixelSize2);
            XpNetworkImageViewTarget xpNetworkImageViewTarget = this.mImageViewTarget;
            if (xpNetworkImageViewTarget != null) {
                xpNetworkImageViewTarget.reset();
                this.mIconPic.setImageBitmap(null);
            } else {
                this.mImageViewTarget = new XpNetworkImageViewTarget(getContext(), this.mIconPic, dimensionPixelSize, dimensionPixelSize2, this);
            }
            showPicProgress();
            this.mImageViewTarget.loadImageWithRetry(override, this.mCardShowImgUrl);
        }
    }

    private void showFailPic() {
        this.mCardShowImgUrl = null;
        hidePicProgress();
        hidePicNum();
        showIconPic();
        setIconPicImageDrawable(ThemeWatcherUtil.getDrawable(R.drawable.icon_64_normal_ic_failedtoload));
    }

    public void setOnPopDialogShowListener(onPopDialogShow onpopdialogshow) {
        this.mOnPopDialogShowListener = onpopdialogshow;
    }

    private void showLargePic(List<String> list) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.mPreviousClickTime < 500) {
            if (L.ENABLE) {
                L.d(TAG, "showLargePic failure:click frequently");
                return;
            }
            return;
        }
        this.mPreviousClickTime = currentTimeMillis;
        if (this.mMainContext != null) {
            final PicPopDialog picPopDialog = new PicPopDialog(getContext(), list);
            picPopDialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.xiaopeng.montecarlo.views.poicard.PoiCardPicContainer.1
                @Override // android.content.DialogInterface.OnShowListener
                public void onShow(DialogInterface dialogInterface) {
                    if (PoiCardPicContainer.this.mOnPopDialogShowListener != null) {
                        PoiCardPicContainer.this.mOnPopDialogShowListener.onPopDialogShow(picPopDialog);
                    }
                }
            });
            picPopDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.xiaopeng.montecarlo.views.poicard.PoiCardPicContainer.2
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (PoiCardPicContainer.this.mOnPopDialogShowListener != null) {
                        PoiCardPicContainer.this.mOnPopDialogShowListener.onPopDialogDismiss(picPopDialog);
                    }
                }
            });
            picPopDialog.show();
        }
    }

    public void hidePictures() {
        setVisibility(8);
        hideIconPic();
        hidePicNum();
        hidePicProgress();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != R.id.poi_icon_pic) {
            return;
        }
        showLargePic(this.mPoiInfo.getImageUrlList());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaopeng.xui.widget.XRelativeLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mLayoutListener = null;
        this.mPreviousClickTime = 0L;
    }

    @Override // com.xiaopeng.montecarlo.xpglide.IXpImageLoadListener
    public void onLoadStarted() {
        showPicProgress();
    }

    @Override // com.xiaopeng.montecarlo.xpglide.IXpImageLoadListener
    public void onLoadSuccess(@NonNull Bitmap bitmap) {
        hidePicProgress();
    }

    @Override // com.xiaopeng.montecarlo.xpglide.IXpImageLoadListener
    public void onLoadFailed() {
        showFailPic();
    }
}
