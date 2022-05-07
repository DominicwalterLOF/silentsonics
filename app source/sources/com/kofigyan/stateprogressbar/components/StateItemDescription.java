package com.kofigyan.stateprogressbar.components;

import com.kofigyan.stateprogressbar.components.BaseItem;

public class StateItemDescription extends BaseItem {
    private final String text;

    public static abstract class Builder<T extends Builder<T>> extends BaseItem.Builder<T> {
        /* access modifiers changed from: private */
        public String text;

        public Builder() {
        }

        public T text(String text2) {
            this.text = text2;
            return (Builder) self();
        }

        public StateItemDescription build() {
            StateItemDescription stateItemDescription;
            new StateItemDescription(this);
            return stateItemDescription;
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
    protected StateItemDescription(com.kofigyan.stateprogressbar.components.StateItemDescription.Builder<?> r5) {
        /*
            r4 = this;
            r0 = r4
            r1 = r5
            r2 = r0
            r3 = r1
            r2.<init>(r3)
            r2 = r0
            r3 = r1
            java.lang.String r3 = r3.text
            r2.text = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kofigyan.stateprogressbar.components.StateItemDescription.<init>(com.kofigyan.stateprogressbar.components.StateItemDescription$Builder):void");
    }

    public String getText() {
        return this.text;
    }
}
