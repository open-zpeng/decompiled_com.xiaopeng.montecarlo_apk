package lombok.patcher.scripts;
/* loaded from: xp_Montecarlo-benchEdward.apk:lombok/patcher/scripts/WrapperMethodDescriptor.SCL.lombok */
public class WrapperMethodDescriptor {
    private final int count;
    private final int opcode;
    private final String owner;
    private final String name;
    private final String wrapperDescriptor;
    private final String targetDescriptor;
    private final boolean itf;

    public WrapperMethodDescriptor(int count, int opcode, String owner, String name, String wrapperDescriptor, String targetDescriptor, boolean itf) {
        this.count = count;
        this.opcode = opcode;
        this.owner = owner;
        this.name = name;
        this.wrapperDescriptor = wrapperDescriptor;
        this.targetDescriptor = targetDescriptor;
        this.itf = itf;
    }

    public int getCount() {
        return this.count;
    }

    public int getOpcode() {
        return this.opcode;
    }

    public String getOwner() {
        return this.owner;
    }

    public String getName() {
        return this.name;
    }

    public String getWrapperDescriptor() {
        return this.wrapperDescriptor;
    }

    public String getTargetDescriptor() {
        return this.targetDescriptor;
    }

    public boolean isItf() {
        return this.itf;
    }

    public String getWrapperName() {
        return "$lombok$$wrapper$" + this.count + "$" + this.name;
    }

    public int hashCode() {
        int result = (31 * 1) + this.count;
        return (31 * ((31 * ((31 * ((31 * ((31 * ((31 * result) + (this.itf ? 1231 : 1237))) + (this.name == null ? 0 : this.name.hashCode()))) + this.opcode)) + (this.owner == null ? 0 : this.owner.hashCode()))) + (this.targetDescriptor == null ? 0 : this.targetDescriptor.hashCode()))) + (this.wrapperDescriptor == null ? 0 : this.wrapperDescriptor.hashCode());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            WrapperMethodDescriptor other = (WrapperMethodDescriptor) obj;
            if (this.count == other.count && this.itf == other.itf) {
                if (this.name == null) {
                    if (other.name != null) {
                        return false;
                    }
                } else if (!this.name.equals(other.name)) {
                    return false;
                }
                if (this.opcode != other.opcode) {
                    return false;
                }
                if (this.owner == null) {
                    if (other.owner != null) {
                        return false;
                    }
                } else if (!this.owner.equals(other.owner)) {
                    return false;
                }
                if (this.targetDescriptor == null) {
                    if (other.targetDescriptor != null) {
                        return false;
                    }
                } else if (!this.targetDescriptor.equals(other.targetDescriptor)) {
                    return false;
                }
                return this.wrapperDescriptor == null ? other.wrapperDescriptor == null : this.wrapperDescriptor.equals(other.wrapperDescriptor);
            }
            return false;
        }
        return false;
    }

    public String toString() {
        return "WrapperMethodDescriptor[count=" + this.count + ", opcode=" + this.opcode + ", owner=" + this.owner + ", name=" + this.name + ", wrapperDescriptor=" + this.wrapperDescriptor + ", targetDescriptor=" + this.targetDescriptor + ", itf=" + this.itf + "]";
    }
}
