package com.kofigyan.stateprogressbar.components;

import com.kofigyan.stateprogressbar.components.BaseItem;

public class StateItem extends BaseItem {
    private final boolean isCurrentState;
    private final boolean isStateChecked;
    private final StateItemDescription stateItemDescription;
    private final StateItemNumber stateItemNumber;

    public static abstract class Builder<T extends Builder<T>> extends BaseItem.Builder<T> {
        /* access modifiers changed from: private */
        public boolean isCurrentState;
        /* access modifiers changed from: private */
        public boolean isStateChecked;
        /* access modifiers changed from: private */
        public StateItemDescription stateItemDescription;
        /* access modifiers changed from: private */
        public StateItemNumber stateItemNumber;

        public Builder() {
        }

        public T stateItemNumber(StateItemNumber stateItemNumber2) {
            this.stateItemNumber = stateItemNumber2;
            return (Builder) self();
        }

        public T stateItemDescription(StateItemDescription stateItemDescription2) {
            this.stateItemDescription = stateItemDescription2;
            return (Builder) self();
        }

        public T isCurrentState(boolean isCurrentState2) {
            this.isCurrentState = isCurrentState2;
            return (Builder) self();
        }

        public T isStateChecked(boolean isStateChecked2) {
            this.isStateChecked = isStateChecked2;
            return (Builder) self();
        }

        public StateItem build() {
            StateItem stateItem;
            new StateItem(this);
            return stateItem;
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
    protected StateItem(com.kofigyan.stateprogressbar.components.StateItem.Builder<?> r5) {
        /*
            r4 = this;
            r0 = r4
            r1 = r5
            r2 = r0
            r3 = r1
            r2.<init>(r3)
            r2 = r0
            r3 = r1
            com.kofigyan.stateprogressbar.components.StateItemNumber r3 = r3.stateItemNumber
            r2.stateItemNumber = r3
            r2 = r0
            r3 = r1
            com.kofigyan.stateprogressbar.components.StateItemDescription r3 = r3.stateItemDescription
            r2.stateItemDescription = r3
            r2 = r0
            r3 = r1
            boolean r3 = r3.isCurrentState
            r2.isCurrentState = r3
            r2 = r0
            r3 = r1
            boolean r3 = r3.isStateChecked
            r2.isStateChecked = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kofigyan.stateprogressbar.components.StateItem.<init>(com.kofigyan.stateprogressbar.components.StateItem$Builder):void");
    }

    public StateItemNumber getStateItemNumber() {
        return this.stateItemNumber;
    }

    public StateItemDescription getStateItemDescription() {
        return this.stateItemDescription;
    }

    public boolean isCurrentState() {
        return this.isCurrentState;
    }

    public boolean isStateChecked() {
        return this.isStateChecked;
    }
}
