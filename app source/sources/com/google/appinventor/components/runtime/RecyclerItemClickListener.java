package com.google.appinventor.components.runtime;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerItemClickListener implements RecyclerView.OnItemTouchListener {
    private GestureDetector hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;
    /* access modifiers changed from: private */

    /* renamed from: hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME  reason: collision with other field name */
    public OnItemClickListener f234hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;

    public interface OnItemClickListener {
        void onItemClick(View view, int i);

        void onLongItemClick(View view, int i);
    }

    public RecyclerItemClickListener(Context context, RecyclerView recyclerView, OnItemClickListener onItemClickListener) {
        GestureDetector gestureDetector;
        GestureDetector.OnGestureListener onGestureListener;
        this.f234hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = onItemClickListener;
        final RecyclerView recyclerView2 = recyclerView;
        new GestureDetector.SimpleOnGestureListener(this) {

            /* renamed from: hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME  reason: collision with other field name */
            private /* synthetic */ RecyclerItemClickListener f235hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;

            {
                this.f235hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = r6;
            }

            public final boolean onSingleTapUp(MotionEvent motionEvent) {
                MotionEvent motionEvent2 = motionEvent;
                return true;
            }

            public final void onLongPress(MotionEvent motionEvent) {
                MotionEvent motionEvent2 = motionEvent;
                View findChildViewUnder = recyclerView2.findChildViewUnder(motionEvent2.getX(), motionEvent2.getY());
                View view = findChildViewUnder;
                if (findChildViewUnder != null && this.f235hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.f234hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME != null) {
                    this.f235hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.f234hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.onLongItemClick(view, recyclerView2.getChildAdapterPosition(view));
                }
            }
        };
        new GestureDetector(context, onGestureListener);
        this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = gestureDetector;
    }

    public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        RecyclerView recyclerView2 = recyclerView;
        MotionEvent motionEvent2 = motionEvent;
        View findChildViewUnder = recyclerView2.findChildViewUnder(motionEvent2.getX(), motionEvent2.getY());
        View view = findChildViewUnder;
        if (findChildViewUnder == null || this.f234hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME == null || !this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.onTouchEvent(motionEvent2)) {
            return false;
        }
        this.f234hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.onItemClick(view, recyclerView2.getChildAdapterPosition(view));
        return true;
    }

    public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
    }

    public void onRequestDisallowInterceptTouchEvent(boolean z) {
    }
}
