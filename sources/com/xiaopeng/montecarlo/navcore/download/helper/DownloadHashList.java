package com.xiaopeng.montecarlo.navcore.download.helper;

import com.xiaopeng.montecarlo.navcore.download.helper.DownloadHashList;
import com.xiaopeng.montecarlo.root.util.L;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;
/* loaded from: classes3.dex */
public class DownloadHashList {
    private static final L.Tag TAG = new L.Tag("DownloadHashList");
    private Map<Integer, DownloadInfoNode> mAdcodeNodeMap = new ConcurrentHashMap();
    private DownloadInfoList mDownloadInfoList = new DownloadInfoList();

    public synchronized Integer addToTail(Integer num) {
        DownloadInfoNode downloadInfoNode;
        downloadInfoNode = this.mAdcodeNodeMap.get(num);
        if (downloadInfoNode == null) {
            downloadInfoNode = new DownloadInfoNode();
            downloadInfoNode.mAdcode = num;
            downloadInfoNode.mRetryTimes = 0;
            this.mDownloadInfoList.addToTail(downloadInfoNode);
            this.mAdcodeNodeMap.put(num, downloadInfoNode);
        } else {
            Integer unused = downloadInfoNode.mRetryTimes;
            downloadInfoNode.mRetryTimes = Integer.valueOf(downloadInfoNode.mRetryTimes.intValue() + 1);
            this.mDownloadInfoList.swapToTail(downloadInfoNode);
        }
        return downloadInfoNode.mRetryTimes;
    }

    public synchronized void addToTailIfNotExist(Integer num) {
        if (this.mAdcodeNodeMap.get(num) == null) {
            DownloadInfoNode downloadInfoNode = new DownloadInfoNode();
            downloadInfoNode.mAdcode = num;
            downloadInfoNode.mRetryTimes = 0;
            this.mDownloadInfoList.addToTail(downloadInfoNode);
            this.mAdcodeNodeMap.put(num, downloadInfoNode);
        }
    }

    public synchronized Integer getHead() {
        return this.mDownloadInfoList.getHead();
    }

    public synchronized int size() {
        return this.mDownloadInfoList.getSize();
    }

    public synchronized void remove(Integer num) {
        DownloadInfoNode downloadInfoNode = this.mAdcodeNodeMap.get(num);
        if (downloadInfoNode == null) {
            return;
        }
        this.mDownloadInfoList.remove(downloadInfoNode);
        this.mAdcodeNodeMap.remove(num);
    }

    public synchronized void clear() {
        this.mAdcodeNodeMap.values().forEach(new Consumer() { // from class: com.xiaopeng.montecarlo.navcore.download.helper.-$$Lambda$DownloadHashList$EZ1fsVhbonMrp9fjrvN_3BMPv5Q
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                DownloadHashList.lambda$clear$0((DownloadHashList.DownloadInfoNode) obj);
            }
        });
        this.mDownloadInfoList.clear();
        this.mAdcodeNodeMap.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$clear$0(DownloadInfoNode downloadInfoNode) {
        downloadInfoNode.mLeft = null;
        downloadInfoNode.mRight = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class DownloadInfoNode {
        private Integer mAdcode;
        private DownloadInfoNode mLeft;
        private Integer mRetryTimes;
        private DownloadInfoNode mRight;

        public DownloadInfoNode() {
        }

        protected boolean canEqual(Object obj) {
            return obj instanceof DownloadInfoNode;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof DownloadInfoNode) {
                DownloadInfoNode downloadInfoNode = (DownloadInfoNode) obj;
                if (downloadInfoNode.canEqual(this)) {
                    Integer adcode = getAdcode();
                    Integer adcode2 = downloadInfoNode.getAdcode();
                    if (adcode != null ? adcode.equals(adcode2) : adcode2 == null) {
                        Integer retryTimes = getRetryTimes();
                        Integer retryTimes2 = downloadInfoNode.getRetryTimes();
                        if (retryTimes != null ? retryTimes.equals(retryTimes2) : retryTimes2 == null) {
                            DownloadInfoNode left = getLeft();
                            DownloadInfoNode left2 = downloadInfoNode.getLeft();
                            if (left != null ? left.equals(left2) : left2 == null) {
                                DownloadInfoNode right = getRight();
                                DownloadInfoNode right2 = downloadInfoNode.getRight();
                                return right != null ? right.equals(right2) : right2 == null;
                            }
                            return false;
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }

        public int hashCode() {
            Integer adcode = getAdcode();
            int hashCode = adcode == null ? 43 : adcode.hashCode();
            Integer retryTimes = getRetryTimes();
            int hashCode2 = ((hashCode + 59) * 59) + (retryTimes == null ? 43 : retryTimes.hashCode());
            DownloadInfoNode left = getLeft();
            int hashCode3 = (hashCode2 * 59) + (left == null ? 43 : left.hashCode());
            DownloadInfoNode right = getRight();
            return (hashCode3 * 59) + (right != null ? right.hashCode() : 43);
        }

        public DownloadInfoNode setAdcode(Integer num) {
            this.mAdcode = num;
            return this;
        }

        public DownloadInfoNode setLeft(DownloadInfoNode downloadInfoNode) {
            this.mLeft = downloadInfoNode;
            return this;
        }

        public DownloadInfoNode setRetryTimes(Integer num) {
            this.mRetryTimes = num;
            return this;
        }

        public DownloadInfoNode setRight(DownloadInfoNode downloadInfoNode) {
            this.mRight = downloadInfoNode;
            return this;
        }

        public String toString() {
            return "DownloadHashList.DownloadInfoNode(mAdcode=" + getAdcode() + ", mRetryTimes=" + getRetryTimes() + ", mLeft=" + getLeft() + ", mRight=" + getRight() + ")";
        }

        public Integer getAdcode() {
            return this.mAdcode;
        }

        public Integer getRetryTimes() {
            return this.mRetryTimes;
        }

        public DownloadInfoNode getLeft() {
            return this.mLeft;
        }

        public DownloadInfoNode getRight() {
            return this.mRight;
        }
    }

    /* loaded from: classes3.dex */
    private class DownloadInfoList {
        private DownloadInfoNode mHead;
        private int mSize;
        private DownloadInfoNode mTail;

        public int getSize() {
            return this.mSize;
        }

        private void print() {
            for (DownloadInfoNode downloadInfoNode = this.mHead; downloadInfoNode.mRight != null; downloadInfoNode = downloadInfoNode.mRight) {
                L.Tag tag = DownloadHashList.TAG;
                L.i(tag, downloadInfoNode.mAdcode + " " + downloadInfoNode.mRetryTimes);
            }
            L.Tag tag2 = DownloadHashList.TAG;
            L.i(tag2, "tail, size=" + this.mSize);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized void clear() {
            this.mSize = 0;
            this.mHead.mRight = this.mTail;
            this.mTail.mLeft = this.mHead;
            this.mHead.mLeft = null;
            this.mTail.mRight = null;
        }

        private DownloadInfoList() {
            this.mSize = 0;
            this.mHead = null;
            this.mTail = null;
            this.mHead = new DownloadInfoNode();
            this.mTail = new DownloadInfoNode();
            this.mHead.mRight = this.mTail;
            this.mTail.mLeft = this.mHead;
            this.mHead.mLeft = null;
            this.mTail.mRight = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized void swapToTail(DownloadInfoNode downloadInfoNode) {
            if (downloadInfoNode == null) {
                return;
            }
            if (downloadInfoNode.mRight == this.mTail) {
                return;
            }
            if (downloadInfoNode.mLeft != null && downloadInfoNode.mRight != null) {
                downloadInfoNode.mLeft.mRight = downloadInfoNode.mRight;
                downloadInfoNode.mRight.mLeft = downloadInfoNode.mLeft;
                this.mSize--;
            }
            addToTail(downloadInfoNode);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized void addToTail(DownloadInfoNode downloadInfoNode) {
            if (downloadInfoNode == null) {
                return;
            }
            downloadInfoNode.mLeft = this.mTail.mLeft;
            downloadInfoNode.mRight = this.mTail;
            this.mTail.mLeft.mRight = downloadInfoNode;
            this.mTail.mLeft = downloadInfoNode;
            this.mSize++;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized void remove(DownloadInfoNode downloadInfoNode) {
            if (downloadInfoNode == null) {
                return;
            }
            if (downloadInfoNode == this.mHead) {
                return;
            }
            if (downloadInfoNode == this.mTail) {
                return;
            }
            downloadInfoNode.mLeft.mRight = downloadInfoNode.mRight;
            downloadInfoNode.mRight.mLeft = downloadInfoNode.mLeft;
            downloadInfoNode.mLeft = null;
            downloadInfoNode.mRight = null;
            this.mSize--;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized Integer getHead() {
            if (this.mHead.mRight == null) {
                return null;
            }
            if (this.mHead.mRight == this.mTail) {
                return null;
            }
            Integer num = this.mHead.mRight.mAdcode;
            swapToTail(this.mHead.mRight);
            return num;
        }
    }
}
