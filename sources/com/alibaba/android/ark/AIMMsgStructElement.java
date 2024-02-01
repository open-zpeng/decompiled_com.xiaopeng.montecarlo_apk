package com.alibaba.android.ark;

import java.io.Serializable;
/* loaded from: classes.dex */
public final class AIMMsgStructElement implements Serializable {
    private static final long serialVersionUID = -6570040995195133857L;
    public AIMMsgStructElementAt atElement;
    public AIMMsgStructElementType elementType;
    public AIMMsgTextContent textContent;
    public AIMMsgStructElementUid uidElement;

    public AIMMsgStructElement(AIMMsgStructElementType aIMMsgStructElementType, AIMMsgTextContent aIMMsgTextContent, AIMMsgStructElementUid aIMMsgStructElementUid, AIMMsgStructElementAt aIMMsgStructElementAt) {
        this.elementType = AIMMsgStructElementType.ELEMENT_TYPE_UNKNOWN;
        if (aIMMsgStructElementType != null) {
            this.elementType = aIMMsgStructElementType;
        }
        this.textContent = aIMMsgTextContent;
        this.uidElement = aIMMsgStructElementUid;
        this.atElement = aIMMsgStructElementAt;
    }

    public AIMMsgStructElement() {
        this.elementType = AIMMsgStructElementType.ELEMENT_TYPE_UNKNOWN;
    }

    public AIMMsgStructElementType getElementType() {
        return this.elementType;
    }

    public AIMMsgTextContent getTextContent() {
        return this.textContent;
    }

    public AIMMsgStructElementUid getUidElement() {
        return this.uidElement;
    }

    public AIMMsgStructElementAt getAtElement() {
        return this.atElement;
    }

    public String toString() {
        return "AIMMsgStructElement{elementType=" + this.elementType + ",textContent=" + this.textContent + ",uidElement=" + this.uidElement + ",atElement=" + this.atElement + "}";
    }
}
