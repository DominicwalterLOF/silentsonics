package com.kofigyan.stateprogressbar.components;

public class BaseItem {
    private final int color;
    private final float size;

    public static abstract class Builder<T extends Builder<T>> {
        /* access modifiers changed from: private */
        public int color;
        /* access modifiers changed from: private */
        public float size;

        /* access modifiers changed from: protected */
        public abstract T self();

        public Builder() {
        }

        public T color(int color2) {
            this.color = color2;
            return self();
        }

        public T size(float size2) {
            this.size = size2;
            return self();
        }

        public BaseItem build() {
            BaseItem baseItem;
            new BaseItem(this);
            return baseItem;
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

    protected BaseItem(Builder<?> builder) {
        Builder<?> builder2 = builder;
        this.color = builder2.color;
        this.size = builder2.size;
    }

    public int getColor() {
        return this.color;
    }

    public float getSize() {
        return this.size;
    }
}
