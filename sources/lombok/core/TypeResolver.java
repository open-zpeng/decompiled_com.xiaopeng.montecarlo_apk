package lombok.core;
/* loaded from: 地图_V1.10.0_20240112105442_Release.apk:lombok/core/TypeResolver.SCL.lombok */
public class TypeResolver {
    private ImportList imports;

    public TypeResolver(ImportList importList) {
        this.imports = importList;
    }

    public boolean typeMatches(LombokNode<?, ?, ?> context, String fqn, String typeRef) {
        return typeRefToFullyQualifiedName(context, TypeLibrary.createLibraryForSingleType(fqn), typeRef) != null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:77:0x01da, code lost:
        return lombok.core.LombokInternalAliasing.processAliases(r0);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String typeRefToFullyQualifiedName(lombok.core.LombokNode<?, ?, ?> r6, lombok.core.TypeLibrary r7, java.lang.String r8) {
        /*
            Method dump skipped, instructions count: 487
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: lombok.core.TypeResolver.typeRefToFullyQualifiedName(lombok.core.LombokNode, lombok.core.TypeLibrary, java.lang.String):java.lang.String");
    }
}
