package lombok.eclipse.agent;
/* loaded from: 地图_V1.10.0_20240112105442_Release.apk:lombok/eclipse/agent/PatchDiagnostics.SCL.lombok */
public class PatchDiagnostics {
    public static boolean setSourceRangeCheck(Object astNode, int startPosition, int length) {
        if (startPosition >= 0 && length < 0) {
            String nodeTxt = astNode == null ? "(NULL NODE)" : astNode.getClass() + ": " + astNode.toString();
            throw new IllegalArgumentException("startPos = " + startPosition + " and length is " + length + ".\nThis breaks the rule that lengths are not allowed to be negative. Affected Node:\n" + nodeTxt);
        } else if (startPosition < 0 && length != 0) {
            String nodeTxt2 = astNode == null ? "(NULL NODE)" : astNode.getClass() + ": " + astNode.toString();
            throw new IllegalArgumentException("startPos = " + startPosition + " and length is " + length + ".\nThis breaks the rule that length must be 0 if startPosition is negative. Affected Node:\n" + nodeTxt2);
        } else {
            return false;
        }
    }
}
