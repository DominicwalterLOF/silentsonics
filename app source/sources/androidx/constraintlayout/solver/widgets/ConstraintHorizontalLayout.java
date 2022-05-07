package androidx.constraintlayout.solver.widgets;

public class ConstraintHorizontalLayout extends ConstraintWidgetContainer {
    private ContentAlignment mAlignment = ContentAlignment.MIDDLE;

    public enum ContentAlignment {
    }

    public ConstraintHorizontalLayout() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ConstraintHorizontalLayout(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ConstraintHorizontalLayout(int width, int height) {
        super(width, height);
    }

    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void addToSolver(androidx.constraintlayout.solver.LinearSystem r14) {
        /*
            r13 = this;
            r0 = r13
            r1 = r14
            r7 = r0
            java.util.ArrayList r7 = r7.mChildren
            int r7 = r7.size()
            if (r7 == 0) goto L_0x0088
            r7 = r0
            r2 = r7
            r7 = 0
            r3 = r7
            r7 = r0
            java.util.ArrayList r7 = r7.mChildren
            int r7 = r7.size()
            r4 = r7
        L_0x0017:
            r7 = r3
            r8 = r4
            if (r7 >= r8) goto L_0x006c
            r7 = r0
            java.util.ArrayList r7 = r7.mChildren
            r8 = r3
            java.lang.Object r7 = r7.get(r8)
            androidx.constraintlayout.solver.widgets.ConstraintWidget r7 = (androidx.constraintlayout.solver.widgets.ConstraintWidget) r7
            r5 = r7
            r7 = r2
            r8 = r0
            if (r7 == r8) goto L_0x0053
            r7 = r5
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r8 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.LEFT
            r9 = r2
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r10 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.RIGHT
            r7.connect((androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type) r8, (androidx.constraintlayout.solver.widgets.ConstraintWidget) r9, (androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type) r10)
            r7 = r2
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r8 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.RIGHT
            r9 = r5
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r10 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.LEFT
            r7.connect((androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type) r8, (androidx.constraintlayout.solver.widgets.ConstraintWidget) r9, (androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type) r10)
        L_0x003c:
            r7 = r5
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r8 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.TOP
            r9 = r0
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r10 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.TOP
            r7.connect((androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type) r8, (androidx.constraintlayout.solver.widgets.ConstraintWidget) r9, (androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type) r10)
            r7 = r5
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r8 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BOTTOM
            r9 = r0
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r10 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BOTTOM
            r7.connect((androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type) r8, (androidx.constraintlayout.solver.widgets.ConstraintWidget) r9, (androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type) r10)
            r7 = r5
            r2 = r7
            int r3 = r3 + 1
            goto L_0x0017
        L_0x0053:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Strength r7 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Strength.STRONG
            r6 = r7
            r7 = r0
            androidx.constraintlayout.solver.widgets.ConstraintHorizontalLayout$ContentAlignment r7 = r7.mAlignment
            androidx.constraintlayout.solver.widgets.ConstraintHorizontalLayout$ContentAlignment r8 = androidx.constraintlayout.solver.widgets.ConstraintHorizontalLayout.ContentAlignment.END
            if (r7 != r8) goto L_0x0060
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Strength r7 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Strength.WEAK
            r6 = r7
        L_0x0060:
            r7 = r5
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r8 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.LEFT
            r9 = r2
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r10 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.LEFT
            r11 = 0
            r12 = r6
            r7.connect((androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type) r8, (androidx.constraintlayout.solver.widgets.ConstraintWidget) r9, (androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type) r10, (int) r11, (androidx.constraintlayout.solver.widgets.ConstraintAnchor.Strength) r12)
            goto L_0x003c
        L_0x006c:
            r7 = r2
            r8 = r0
            if (r7 == r8) goto L_0x0088
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Strength r7 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Strength.STRONG
            r3 = r7
            r7 = r0
            androidx.constraintlayout.solver.widgets.ConstraintHorizontalLayout$ContentAlignment r7 = r7.mAlignment
            androidx.constraintlayout.solver.widgets.ConstraintHorizontalLayout$ContentAlignment r8 = androidx.constraintlayout.solver.widgets.ConstraintHorizontalLayout.ContentAlignment.BEGIN
            if (r7 != r8) goto L_0x007d
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Strength r7 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Strength.WEAK
            r3 = r7
        L_0x007d:
            r7 = r2
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r8 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.RIGHT
            r9 = r0
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r10 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.RIGHT
            r11 = 0
            r12 = r3
            r7.connect((androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type) r8, (androidx.constraintlayout.solver.widgets.ConstraintWidget) r9, (androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type) r10, (int) r11, (androidx.constraintlayout.solver.widgets.ConstraintAnchor.Strength) r12)
        L_0x0088:
            r7 = r0
            r8 = r1
            super.addToSolver(r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.ConstraintHorizontalLayout.addToSolver(androidx.constraintlayout.solver.LinearSystem):void");
    }
}
