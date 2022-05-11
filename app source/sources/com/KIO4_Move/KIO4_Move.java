package com.KIO4_Move;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import com.google.appinventor.components.runtime.AndroidNonvisibleComponent;
import com.google.appinventor.components.runtime.AndroidViewComponent;
import com.google.appinventor.components.runtime.Component;
import com.google.appinventor.components.runtime.ComponentContainer;
import com.google.appinventor.components.runtime.EventDispatcher;
import com.google.appinventor.components.runtime.HVArrangement;

public class KIO4_Move extends AndroidNonvisibleComponent implements Component {
    private float a;

    /* renamed from: a  reason: collision with other field name */
    public int f333a;

    /* renamed from: a  reason: collision with other field name */
    private Context f334a;

    /* renamed from: a  reason: collision with other field name */
    private ComponentContainer f335a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f336a = true;
    public int b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f337b = true;
    public int c;
    public View componente;
    public int d;
    public FrameLayout disposicion;
    public int e;
    public int f;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public KIO4_Move(com.google.appinventor.components.runtime.ComponentContainer r8) {
        /*
            r7 = this;
            r0 = r7
            r1 = r8
            r3 = r0
            r4 = r1
            com.google.appinventor.components.runtime.Form r4 = r4.$form()
            r3.<init>(r4)
            r3 = r0
            r4 = 1
            r3.f336a = r4
            r3 = r0
            r4 = 1
            r3.f337b = r4
            r3 = r0
            r4 = r1
            r3.f335a = r4
            r3 = r0
            r4 = r1
            android.app.Activity r4 = r4.$context()
            r3.f334a = r4
            r3 = r0
            r4 = r1
            com.google.appinventor.components.runtime.Form r4 = r4.$form()
            android.content.res.Resources r4 = r4.getResources()
            android.util.DisplayMetrics r4 = r4.getDisplayMetrics()
            float r4 = r4.density
            r3.a = r4
            r3 = r0
            com.google.appinventor.components.runtime.Form r3 = r3.form
            boolean r3 = r3 instanceof com.google.appinventor.components.runtime.ReplForm
            if (r3 == 0) goto L_0x003c
            r3 = r0
            r4 = 1
            r3.f336a = r4
        L_0x003c:
            r3 = r0
            boolean r3 = r3.f336a
            if (r3 != 0) goto L_0x0049
            r3 = r1
            android.app.Activity r3 = r3.$context()
            r3.finish()
        L_0x0049:
            r3 = r0
            android.content.Context r3 = r3.f334a
            android.app.Activity r3 = (android.app.Activity) r3
            android.view.Window r3 = r3.getWindow()
            android.view.View r3 = r3.getDecorView()
            android.view.ViewGroup r3 = (android.view.ViewGroup) r3
            r1 = r3
            android.graphics.Rect r3 = new android.graphics.Rect
            r6 = r3
            r3 = r6
            r4 = r6
            r4.<init>()
            r2 = r3
            r3 = r1
            r4 = r2
            r3.getWindowVisibleDisplayFrame(r4)
            r3 = r0
            r4 = r2
            int r4 = r4.top
            r3.c = r4
            r3 = r0
            android.content.Context r3 = r3.f334a
            android.app.Activity r3 = (android.app.Activity) r3
            android.view.Window r3 = r3.getWindow()
            r4 = 16908290(0x1020002, float:2.3877235E-38)
            android.view.View r3 = r3.findViewById(r4)
            android.view.ViewGroup r3 = (android.view.ViewGroup) r3
            r1 = r3
            r3 = 2
            int[] r3 = new int[r3]
            r2 = r3
            r3 = r1
            r4 = r2
            r3.getLocationInWindow(r4)
            r3 = r0
            r4 = r2
            r5 = 1
            r4 = r4[r5]
            r3.d = r4
            r3 = r0
            java.lang.String r3 = r3.HeightStatusTitle()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.KIO4_Move.KIO4_Move.<init>(com.google.appinventor.components.runtime.ComponentContainer):void");
    }

    public float GetDensity() {
        return this.a;
    }

    public void GetParamsComponent(AndroidViewComponent androidViewComponent) {
        Rect rect;
        this.componente = androidViewComponent.getView();
        int width = this.componente.getWidth();
        int height = this.componente.getHeight();
        new Rect();
        Rect rect2 = rect;
        boolean globalVisibleRect = this.componente.getGlobalVisibleRect(rect2);
        GotParams(rect2.width(), rect2.height(), rect2.left, rect2.right, rect2.top, rect2.bottom, rect2.exactCenterX(), rect2.exactCenterY());
    }

    public void GetParamsLayout(HVArrangement hVArrangement) {
        Rect rect;
        this.disposicion = (FrameLayout) hVArrangement.getView();
        int width = this.disposicion.getWidth();
        int height = this.disposicion.getHeight();
        this.disposicion.getLocationOnScreen(new int[2]);
        new Rect();
        Rect rect2 = rect;
        boolean localVisibleRect = this.disposicion.getLocalVisibleRect(rect2);
        boolean globalVisibleRect = this.disposicion.getGlobalVisibleRect(rect2);
        GotParams(rect2.width(), rect2.height(), rect2.left, rect2.right, rect2.top, rect2.bottom, rect2.exactCenterX(), rect2.exactCenterY());
    }

    public void GotParams(int i, int i2, int i3, int i4, int i5, int i6, float f2, float f3) {
        Object[] objArr = new Object[8];
        objArr[0] = Integer.valueOf(i);
        Object[] objArr2 = objArr;
        objArr2[1] = Integer.valueOf(i2);
        Object[] objArr3 = objArr2;
        objArr3[2] = Integer.valueOf(i3);
        Object[] objArr4 = objArr3;
        objArr4[3] = Integer.valueOf(i4);
        Object[] objArr5 = objArr4;
        objArr5[4] = Integer.valueOf(i5);
        Object[] objArr6 = objArr5;
        objArr6[5] = Integer.valueOf(i6);
        Object[] objArr7 = objArr6;
        objArr7[6] = Float.valueOf(f2);
        Object[] objArr8 = objArr7;
        objArr8[7] = Float.valueOf(f3);
        boolean dispatchEvent = EventDispatcher.dispatchEvent(this, "GotParams", objArr8);
    }

    public String HeightStatusTitle() {
        Rect rect;
        StringBuilder sb;
        new Rect();
        Rect rect2 = rect;
        Window window = this.f335a.$form().getWindow();
        window.getDecorView().getWindowVisibleDisplayFrame(rect2);
        this.e = rect2.top;
        this.f = window.findViewById(16908290).getTop() - this.e;
        if (this.f < 0) {
            this.f = this.e + this.f;
            this.e = 0;
        }
        new StringBuilder();
        return sb.append(this.e).append(",").append(this.f).toString();
    }

    public void MoveComponent(AndroidViewComponent androidViewComponent, boolean z) {
        View.OnTouchListener onTouchListener;
        this.componente = androidViewComponent.getView();
        int width = this.componente.getWidth();
        int height = this.componente.getHeight();
        new b(this, z);
        this.componente.setOnTouchListener(onTouchListener);
        this.f337b = true;
    }

    public void MoveLayout(HVArrangement hVArrangement) {
        View.OnTouchListener onTouchListener;
        this.disposicion = (FrameLayout) hVArrangement.getView();
        int width = this.disposicion.getWidth();
        int height = this.disposicion.getHeight();
        new a(this);
        this.disposicion.setOnTouchListener(onTouchListener);
    }

    public void Position(int i, int i2, int i3, int i4) {
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(i);
        Object[] objArr2 = objArr;
        objArr2[1] = Integer.valueOf(i2);
        Object[] objArr3 = objArr2;
        objArr3[2] = Integer.valueOf(i3);
        Object[] objArr4 = objArr3;
        objArr4[3] = Integer.valueOf(i4);
        boolean dispatchEvent = EventDispatcher.dispatchEvent(this, "Position", objArr4);
    }

    public void Rotate(HVArrangement hVArrangement, int i) {
        this.disposicion = (FrameLayout) hVArrangement.getView();
        int width = (int) ((float) this.disposicion.getWidth());
        int height = (int) ((float) this.disposicion.getHeight());
        this.disposicion.setPivotX((float) (width / 2));
        this.disposicion.setPivotY((float) (height / 2));
        this.disposicion.setRotation((float) i);
    }

    public void SetComponent(AndroidViewComponent androidViewComponent, int i, int i2) {
        this.componente = androidViewComponent.getView();
        this.componente.setX((float) i);
        this.componente.setY((float) i2);
    }

    public void SetLayout(HVArrangement hVArrangement, int i, int i2) {
        this.disposicion = (FrameLayout) hVArrangement.getView();
        int width = this.disposicion.getWidth();
        int height = this.disposicion.getHeight();
        this.disposicion.setX((float) i);
        this.disposicion.setY((float) i2);
    }

    public void StopMoveComponent() {
        this.f337b = false;
    }
}
