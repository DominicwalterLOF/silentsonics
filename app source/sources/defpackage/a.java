package defpackage;

import android.view.MotionEvent;
import android.view.View;
import com.KIO4_Move.KIO4_Move;

/* renamed from: a  reason: default package */
public final class a implements View.OnTouchListener {
    private /* synthetic */ KIO4_Move a;

    public a(KIO4_Move kIO4_Move) {
        this.a = kIO4_Move;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        View view2 = view;
        MotionEvent motionEvent2 = motionEvent;
        switch (motionEvent2.getAction()) {
            case 2:
                this.a.f333a = ((int) motionEvent2.getRawX()) - (this.a.disposicion.getWidth() / 2);
                this.a.b = ((((int) motionEvent2.getRawY()) - (this.a.disposicion.getHeight() / 2)) - this.a.c) - this.a.d;
                this.a.disposicion.setX((float) this.a.f333a);
                this.a.disposicion.setY((float) this.a.b);
                this.a.Position((int) motionEvent2.getRawX(), (int) motionEvent2.getRawY(), this.a.f333a, this.a.b);
                break;
        }
        return true;
    }
}
