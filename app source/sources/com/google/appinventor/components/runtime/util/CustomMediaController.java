package com.google.appinventor.components.runtime.util;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.MediaController;

public class CustomMediaController extends MediaController implements View.OnTouchListener {
    private int ZFwQoaMsdRwNqOTkWG5sFNIKnTcrKyb4dIRsDmVa68cFIA9m1jUiaqOHngvgXrvD = 3000;
    private View wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomMediaController(Context context) {
        super(context);
    }

    public void show(int i) {
        setVisibility(0);
        super.show(i);
    }

    public void show() {
        setVisibility(0);
        super.show();
    }

    public boolean addTo(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        ViewGroup viewGroup2 = viewGroup;
        ViewGroup.LayoutParams layoutParams2 = layoutParams;
        ViewParent parent = getParent();
        ViewParent viewParent = parent;
        if (parent == null || !(viewParent instanceof ViewGroup)) {
            int e = Log.e("CustomMediaController.addTo", "MediaController not available in fullscreen.");
            return false;
        }
        ((ViewGroup) viewParent).removeView(this);
        viewGroup2.addView(this, layoutParams2);
        return true;
    }

    public void setAnchorView(View view) {
        View view2 = view;
        this.wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou = view2;
        this.wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou.setOnTouchListener(this);
        super.setAnchorView(view2);
    }

    public void hide() {
        super.hide();
        setVisibility(4);
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        MotionEvent motionEvent2 = motionEvent;
        if (view == this.wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou) {
            show(this.ZFwQoaMsdRwNqOTkWG5sFNIKnTcrKyb4dIRsDmVa68cFIA9m1jUiaqOHngvgXrvD);
        }
        return false;
    }
}
