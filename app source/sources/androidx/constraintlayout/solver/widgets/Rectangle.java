package androidx.constraintlayout.solver.widgets;

public class Rectangle {
    public int height;
    public int width;
    public int x;
    public int y;

    public Rectangle() {
    }

    public void setBounds(int x2, int y2, int width2, int height2) {
        this.x = x2;
        this.y = y2;
        this.width = width2;
        this.height = height2;
    }

    /* access modifiers changed from: package-private */
    public void grow(int i, int i2) {
        int w = i;
        int h = i2;
        this.x -= w;
        this.y -= h;
        this.width += 2 * w;
        this.height += 2 * h;
    }

    /* access modifiers changed from: package-private */
    public boolean intersects(Rectangle rectangle) {
        Rectangle bounds = rectangle;
        return this.x >= bounds.x && this.x < bounds.x + bounds.width && this.y >= bounds.y && this.y < bounds.y + bounds.height;
    }

    public boolean contains(int i, int i2) {
        int x2 = i;
        int y2 = i2;
        return x2 >= this.x && x2 < this.x + this.width && y2 >= this.y && y2 < this.y + this.height;
    }

    public int getCenterX() {
        return (this.x + this.width) / 2;
    }

    public int getCenterY() {
        return (this.y + this.height) / 2;
    }
}
