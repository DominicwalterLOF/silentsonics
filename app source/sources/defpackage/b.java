package defpackage;

import android.view.MotionEvent;
import android.view.View;
import com.KIO4_Move.KIO4_Move;

/* renamed from: b  reason: default package */
public final class b implements View.OnTouchListener {
    private /* synthetic */ KIO4_Move a;
    private /* synthetic */ boolean c;

    public b(KIO4_Move kIO4_Move, boolean z) {
        this.a = kIO4_Move;
        this.c = z;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        View view2 = view;
        MotionEvent motionEvent2 = motionEvent;
        switch (motionEvent2.getAction()) {
            case 0:
                if (!this.a.f337b) {
                    this.a.componente.setOnTouchListener((View.OnTouchListener) null);
                    this.a.f337b = true;
                    break;
                }
                break;
            case 1:
                if (!this.c) {
                    this.a.componente.setOnTouchListener((View.OnTouchListener) null);
                    break;
                }
                break;
            case 2:
                this.a.f333a = ((int) motionEvent2.getRawX()) - (this.a.componente.getWidth() / 2);
                this.a.b = ((((int) motionEvent2.getRawY()) - (this.a.componente.getHeight() / 2)) - this.a.e) - this.a.f;
                this.a.componente.setX((float) this.a.f333a);
                this.a.componente.setY((float) this.a.b);
                this.a.Position((int) motionEvent2.getRawX(), (int) motionEvent2.getRawY(), this.a.f333a, this.a.b);
                break;
        }
        return true;
    }
}
