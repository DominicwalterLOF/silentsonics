package com.airbnb.lottie.utils;

public class MeanCalculator {
    private int n;
    private float sum;

    public MeanCalculator() {
    }

    public void add(float number) {
        this.sum += number;
        this.n++;
        if (this.n == Integer.MAX_VALUE) {
            this.sum /= 2.0f;
            this.n /= 2;
        }
    }

    public float getMean() {
        if (this.n == 0) {
            return 0.0f;
        }
        return this.sum / ((float) this.n);
    }
}
