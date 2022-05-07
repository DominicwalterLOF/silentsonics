package com.kofigyan.stateprogressbar.components;

import com.kofigyan.stateprogressbar.components.BaseItem;

public class StateItemNumber extends BaseItem {
    private int number;

    public static abstract class Builder<T extends Builder<T>> extends BaseItem.Builder<T> {
        /* access modifiers changed from: private */
        public int number;

        public Builder() {
        }

        public T number(int number2) {
            this.number = number2;
            return (Builder) self();
        }

        public StateItemNumber build() {
            StateItemNumber stateItemNumber;
            new StateItemNumber(this);
            return stateItemNumber;
        }
    }

    private static class Builder2 extends Builder<Builder2> {
        private Builder2() {
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        /* synthetic */ Builder2(AnonymousClass1 r4) {
            this();
            AnonymousClass1 r1 = r4;
        }

        /* access modifiers changed from: protected */
        public Builder2 self() {
            return this;
        }
    }

    public static Builder<?> builder() {
        Builder<?> builder;
        Builder<?> builder2 = builder;
        new Builder2((AnonymousClass1) null);
        return builder2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected StateItemNumber(com.kofigyan.stateprogressbar.components.StateItemNumber.Builder<?> r5) {
        /*
            r4 = this;
            r0 = r4
            r1 = r5
            r2 = r0
            r3 = r1
            r2.<init>(r3)
            r2 = r0
            r3 = r1
            int r3 = r3.number
            r2.number = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kofigyan.stateprogressbar.components.StateItemNumber.<init>(com.kofigyan.stateprogressbar.components.StateItemNumber$Builder):void");
    }

    public int getNumber() {
        return this.number;
    }
}
