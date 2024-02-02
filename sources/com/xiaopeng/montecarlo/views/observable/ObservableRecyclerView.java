package com.xiaopeng.montecarlo.views.observable;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.xui.widget.XRecyclerView;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class ObservableRecyclerView extends XRecyclerView implements Scrollable {
    public static final int SCROLL_DOWN = 3;
    public static final int SCROLL_STOP = 1;
    public static final int SCROLL_UP = 2;
    private static int sRecyclerViewLibraryVersion = 22;
    private List<ObservableScrollViewCallbacks> mCallbackCollection;
    private ObservableScrollViewCallbacks mCallbacks;
    private SparseIntArray mChildrenHeights;
    private boolean mDragging;
    private boolean mFirstScroll;
    private boolean mIntercepted;
    private int mPrevFirstVisibleChildHeight;
    private int mPrevFirstVisiblePosition;
    private MotionEvent mPrevMoveEvent;
    private int mPrevScrollY;
    private int mPrevScrolledChildrenHeight;
    private int mScrollState;
    private int mScrollY;
    private ViewGroup mTouchInterceptionViewGroup;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface ScrollState {
    }

    public ObservableRecyclerView(Context context) {
        super(context);
        this.mPrevFirstVisibleChildHeight = -1;
        init();
    }

    public ObservableRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPrevFirstVisibleChildHeight = -1;
        init();
    }

    public ObservableRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mPrevFirstVisibleChildHeight = -1;
        init();
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        this.mPrevFirstVisiblePosition = savedState.mPrevFirstVisiblePosition;
        this.mPrevFirstVisibleChildHeight = savedState.mPrevFirstVisibleChildHeight;
        this.mPrevScrolledChildrenHeight = savedState.mPrevScrolledChildrenHeight;
        this.mPrevScrollY = savedState.mPrevScrollY;
        this.mScrollY = savedState.mScrollY;
        this.mChildrenHeights = savedState.mChildrenHeights;
        super.onRestoreInstanceState(savedState.getSuperState());
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.mPrevFirstVisiblePosition = this.mPrevFirstVisiblePosition;
        savedState.mPrevFirstVisibleChildHeight = this.mPrevFirstVisibleChildHeight;
        savedState.mPrevScrolledChildrenHeight = this.mPrevScrolledChildrenHeight;
        savedState.mPrevScrollY = this.mPrevScrollY;
        savedState.mScrollY = this.mScrollY;
        savedState.mChildrenHeights = this.mChildrenHeights;
        return savedState;
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        int i5;
        int height;
        int i6;
        int height2;
        super.onScrollChanged(i, i2, i3, i4);
        if (!hasNoCallbacks() && getChildCount() > 0) {
            int childAdapterPosition = getChildAdapterPosition(getChildAt(0));
            int childAdapterPosition2 = getChildAdapterPosition(getChildAt(getChildCount() - 1));
            int i7 = 0;
            int i8 = childAdapterPosition;
            while (i8 <= childAdapterPosition2) {
                View childAt = getChildAt(i7);
                if (childAt != null && (this.mChildrenHeights.indexOfKey(i8) < 0 || childAt.getHeight() != this.mChildrenHeights.get(i8))) {
                    this.mChildrenHeights.put(i8, childAt.getHeight());
                }
                i8++;
                i7++;
            }
            View childAt2 = getChildAt(0);
            if (childAt2 != null) {
                int i9 = this.mPrevFirstVisiblePosition;
                if (i9 < childAdapterPosition) {
                    if (childAdapterPosition - i9 != 1) {
                        i6 = 0;
                        for (int i10 = childAdapterPosition - 1; i10 > this.mPrevFirstVisiblePosition; i10--) {
                            if (this.mChildrenHeights.indexOfKey(i10) > 0) {
                                height2 = this.mChildrenHeights.get(i10);
                            } else {
                                height2 = childAt2.getHeight();
                            }
                            i6 += height2;
                        }
                    } else {
                        i6 = 0;
                    }
                    this.mPrevScrolledChildrenHeight += this.mPrevFirstVisibleChildHeight + i6;
                    this.mPrevFirstVisibleChildHeight = childAt2.getHeight();
                } else if (childAdapterPosition < i9) {
                    if (i9 - childAdapterPosition != 1) {
                        i5 = 0;
                        for (int i11 = i9 - 1; i11 > childAdapterPosition; i11--) {
                            if (this.mChildrenHeights.indexOfKey(i11) > 0) {
                                height = this.mChildrenHeights.get(i11);
                            } else {
                                height = childAt2.getHeight();
                            }
                            i5 += height;
                        }
                    } else {
                        i5 = 0;
                    }
                    this.mPrevScrolledChildrenHeight -= childAt2.getHeight() + i5;
                    this.mPrevFirstVisibleChildHeight = childAt2.getHeight();
                } else if (childAdapterPosition == 0) {
                    this.mPrevFirstVisibleChildHeight = childAt2.getHeight();
                    this.mPrevScrolledChildrenHeight = 0;
                }
                if (this.mPrevFirstVisibleChildHeight < 0) {
                    this.mPrevFirstVisibleChildHeight = 0;
                }
                this.mScrollY = (this.mPrevScrolledChildrenHeight - childAt2.getTop()) + getPaddingTop();
                this.mPrevFirstVisiblePosition = childAdapterPosition;
                if (childAdapterPosition == 0 && childAt2.getTop() == 0) {
                    this.mScrollY = 0;
                }
                dispatchOnScrollChanged(this.mScrollY, this.mFirstScroll, this.mDragging);
                if (this.mFirstScroll) {
                    this.mFirstScroll = false;
                }
                int i12 = this.mPrevScrollY;
                int i13 = this.mScrollY;
                if (i12 < i13) {
                    this.mScrollState = 2;
                } else if (i13 < i12) {
                    this.mScrollState = 3;
                } else {
                    this.mScrollState = 1;
                }
                this.mPrevScrollY = this.mScrollY;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (hasNoCallbacks()) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (motionEvent.getActionMasked() == 0) {
            this.mDragging = true;
            this.mFirstScroll = true;
            dispatchOnDownMotionEvent();
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0017, code lost:
        if (r0 != 3) goto L12;
     */
    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r9) {
        /*
            r8 = this;
            boolean r0 = r8.hasNoCallbacks()
            if (r0 == 0) goto Lb
            boolean r9 = super.onTouchEvent(r9)
            return r9
        Lb:
            int r0 = r9.getActionMasked()
            r1 = 1
            r2 = 0
            if (r0 == r1) goto L90
            r3 = 2
            if (r0 == r3) goto L1b
            r1 = 3
            if (r0 == r1) goto L90
            goto L99
        L1b:
            android.view.MotionEvent r0 = r8.mPrevMoveEvent
            if (r0 != 0) goto L21
            r8.mPrevMoveEvent = r9
        L21:
            float r0 = r9.getY()
            android.view.MotionEvent r3 = r8.mPrevMoveEvent
            float r3 = r3.getY()
            float r0 = r0 - r3
            android.view.MotionEvent r3 = android.view.MotionEvent.obtainNoHistory(r9)
            r8.mPrevMoveEvent = r3
            int r3 = r8.getScrollY()
            float r3 = (float) r3
            float r3 = r3 - r0
            r0 = 0
            int r3 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r3 > 0) goto L99
            boolean r3 = r8.mIntercepted
            if (r3 == 0) goto L42
            return r2
        L42:
            android.view.ViewGroup r3 = r8.mTouchInterceptionViewGroup
            if (r3 != 0) goto L4c
            android.view.ViewParent r3 = r8.getParent()
            android.view.ViewGroup r3 = (android.view.ViewGroup) r3
        L4c:
            r4 = r0
            r5 = r4
            r0 = r8
        L4f:
            if (r0 == 0) goto L70
            if (r0 == r3) goto L70
            int r6 = r0.getLeft()
            int r7 = r0.getScrollX()
            int r6 = r6 - r7
            float r6 = (float) r6
            float r4 = r4 + r6
            int r6 = r0.getTop()
            int r7 = r0.getScrollY()
            int r6 = r6 - r7
            float r6 = (float) r6
            float r5 = r5 + r6
            android.view.ViewParent r0 = r0.getParent()
            android.view.View r0 = (android.view.View) r0
            goto L4f
        L70:
            android.view.MotionEvent r0 = android.view.MotionEvent.obtainNoHistory(r9)
            r0.offsetLocation(r4, r5)
            boolean r4 = r3.onInterceptTouchEvent(r0)
            if (r4 == 0) goto L8b
            r8.mIntercepted = r1
            r0.setAction(r2)
            com.xiaopeng.montecarlo.views.observable.ObservableRecyclerView$1 r9 = new com.xiaopeng.montecarlo.views.observable.ObservableRecyclerView$1
            r9.<init>()
            r8.post(r9)
            return r2
        L8b:
            boolean r9 = super.onTouchEvent(r9)
            return r9
        L90:
            r8.mIntercepted = r2
            r8.mDragging = r2
            int r0 = r8.mScrollState
            r8.dispatchOnUpOrCancelMotionEvent(r0)
        L99:
            boolean r9 = super.onTouchEvent(r9)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.montecarlo.views.observable.ObservableRecyclerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // com.xiaopeng.montecarlo.views.observable.Scrollable
    public void setScrollViewCallbacks(ObservableScrollViewCallbacks observableScrollViewCallbacks) {
        this.mCallbacks = observableScrollViewCallbacks;
    }

    @Override // com.xiaopeng.montecarlo.views.observable.Scrollable
    public void addScrollViewCallbacks(ObservableScrollViewCallbacks observableScrollViewCallbacks) {
        if (this.mCallbackCollection == null) {
            this.mCallbackCollection = new ArrayList();
        }
        CollectionUtils.listAdd(this.mCallbackCollection, observableScrollViewCallbacks);
    }

    @Override // com.xiaopeng.montecarlo.views.observable.Scrollable
    public void removeScrollViewCallbacks(ObservableScrollViewCallbacks observableScrollViewCallbacks) {
        List<ObservableScrollViewCallbacks> list = this.mCallbackCollection;
        if (list != null) {
            list.remove(observableScrollViewCallbacks);
        }
    }

    @Override // com.xiaopeng.montecarlo.views.observable.Scrollable
    public void clearScrollViewCallbacks() {
        List<ObservableScrollViewCallbacks> list = this.mCallbackCollection;
        if (list != null) {
            list.clear();
        }
    }

    @Override // com.xiaopeng.montecarlo.views.observable.Scrollable
    public void setTouchInterceptionViewGroup(ViewGroup viewGroup) {
        this.mTouchInterceptionViewGroup = viewGroup;
    }

    private int[] getLastestVisiblePosition() {
        RecyclerView.LayoutManager layoutManager = getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            return new int[]{((LinearLayoutManager) layoutManager).findLastVisibleItemPosition()};
        }
        if (layoutManager instanceof GridLayoutManager) {
            return new int[]{((GridLayoutManager) layoutManager).findLastVisibleItemPosition()};
        }
        if (layoutManager instanceof StaggeredGridLayoutManager) {
            StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
            int[] iArr = new int[staggeredGridLayoutManager.getSpanCount()];
            staggeredGridLayoutManager.findLastVisibleItemPositions(iArr);
            return iArr;
        }
        return null;
    }

    @Override // com.xiaopeng.montecarlo.views.observable.Scrollable
    public void scrollVerticallyTo(int i) {
        View childAt = getChildAt(0);
        if (childAt != null) {
            scrollVerticallyToPosition(i / childAt.getHeight());
        }
    }

    public void scrollVerticallyToPosition(int i) {
        RecyclerView.LayoutManager layoutManager = getLayoutManager();
        if (layoutManager != null && (layoutManager instanceof LinearLayoutManager)) {
            ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i, 0);
        } else {
            scrollToPosition(i);
        }
    }

    @Override // com.xiaopeng.montecarlo.views.observable.Scrollable
    public int getCurrentScrollY() {
        return this.mScrollY;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public int getChildAdapterPosition(View view) {
        if (22 <= sRecyclerViewLibraryVersion) {
            return super.getChildAdapterPosition(view);
        }
        return getChildPosition(view);
    }

    private void init() {
        this.mChildrenHeights = new SparseIntArray();
        checkLibraryVersion();
    }

    private void checkLibraryVersion() {
        try {
            super.getChildAdapterPosition(null);
        } catch (NoSuchMethodError unused) {
            sRecyclerViewLibraryVersion = 21;
        }
    }

    private void dispatchOnDownMotionEvent() {
        ObservableScrollViewCallbacks observableScrollViewCallbacks = this.mCallbacks;
        if (observableScrollViewCallbacks != null) {
            observableScrollViewCallbacks.onDownMotionEvent();
        }
        if (this.mCallbackCollection != null) {
            for (int i = 0; i < this.mCallbackCollection.size(); i++) {
                this.mCallbackCollection.get(i).onDownMotionEvent();
            }
        }
    }

    private void dispatchOnScrollChanged(int i, boolean z, boolean z2) {
        ObservableScrollViewCallbacks observableScrollViewCallbacks = this.mCallbacks;
        if (observableScrollViewCallbacks != null) {
            observableScrollViewCallbacks.onScrollChanged(i, z, z2);
        }
        if (this.mCallbackCollection != null) {
            for (int i2 = 0; i2 < this.mCallbackCollection.size(); i2++) {
                this.mCallbackCollection.get(i2).onScrollChanged(i, z, z2);
            }
        }
    }

    private void dispatchOnUpOrCancelMotionEvent(int i) {
        ObservableScrollViewCallbacks observableScrollViewCallbacks = this.mCallbacks;
        if (observableScrollViewCallbacks != null) {
            observableScrollViewCallbacks.onUpOrCancelMotionEvent(i);
        }
        if (this.mCallbackCollection != null) {
            for (int i2 = 0; i2 < this.mCallbackCollection.size(); i2++) {
                this.mCallbackCollection.get(i2).onUpOrCancelMotionEvent(i);
            }
        }
    }

    private boolean hasNoCallbacks() {
        return this.mCallbacks == null && this.mCallbackCollection == null;
    }

    public void setSelectionFromTop(int i, int i2) {
        RecyclerView.LayoutManager layoutManager = getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i, i2);
        } else if (layoutManager instanceof GridLayoutManager) {
            ((GridLayoutManager) layoutManager).scrollToPositionWithOffset(i, i2);
        } else if (layoutManager instanceof StaggeredGridLayoutManager) {
            ((StaggeredGridLayoutManager) layoutManager).scrollToPositionWithOffset(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class SavedState implements Parcelable {
        SparseIntArray mChildrenHeights;
        int mPrevFirstVisibleChildHeight;
        int mPrevFirstVisiblePosition;
        int mPrevScrollY;
        int mPrevScrolledChildrenHeight;
        int mScrollY;
        Parcelable mSuperState;
        public static final SavedState EMPTY_STATE = new SavedState() { // from class: com.xiaopeng.montecarlo.views.observable.ObservableRecyclerView.SavedState.1
        };
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.xiaopeng.montecarlo.views.observable.ObservableRecyclerView.SavedState.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        private SavedState() {
            this.mPrevFirstVisibleChildHeight = -1;
            this.mSuperState = null;
        }

        SavedState(Parcelable parcelable) {
            this.mPrevFirstVisibleChildHeight = -1;
            this.mSuperState = parcelable == EMPTY_STATE ? null : parcelable;
        }

        private SavedState(Parcel parcel) {
            this.mPrevFirstVisibleChildHeight = -1;
            Parcelable readParcelable = parcel.readParcelable(RecyclerView.class.getClassLoader());
            this.mSuperState = readParcelable == null ? EMPTY_STATE : readParcelable;
            this.mPrevFirstVisiblePosition = parcel.readInt();
            this.mPrevFirstVisibleChildHeight = parcel.readInt();
            this.mPrevScrolledChildrenHeight = parcel.readInt();
            this.mPrevScrollY = parcel.readInt();
            this.mScrollY = parcel.readInt();
            this.mChildrenHeights = new SparseIntArray();
            int readInt = parcel.readInt();
            if (readInt > 0) {
                for (int i = 0; i < readInt; i++) {
                    this.mChildrenHeights.put(parcel.readInt(), parcel.readInt());
                }
            }
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.mSuperState, i);
            parcel.writeInt(this.mPrevFirstVisiblePosition);
            parcel.writeInt(this.mPrevFirstVisibleChildHeight);
            parcel.writeInt(this.mPrevScrolledChildrenHeight);
            parcel.writeInt(this.mPrevScrollY);
            parcel.writeInt(this.mScrollY);
            SparseIntArray sparseIntArray = this.mChildrenHeights;
            int size = sparseIntArray == null ? 0 : sparseIntArray.size();
            parcel.writeInt(size);
            if (size > 0) {
                for (int i2 = 0; i2 < size; i2++) {
                    parcel.writeInt(this.mChildrenHeights.keyAt(i2));
                    parcel.writeInt(this.mChildrenHeights.valueAt(i2));
                }
            }
        }

        public Parcelable getSuperState() {
            return this.mSuperState;
        }
    }
}
