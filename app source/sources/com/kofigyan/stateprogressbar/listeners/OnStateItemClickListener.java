package com.kofigyan.stateprogressbar.listeners;

import com.kofigyan.stateprogressbar.StateProgressBar;
import com.kofigyan.stateprogressbar.components.StateItem;

public interface OnStateItemClickListener {
    void onStateItemClick(StateProgressBar stateProgressBar, StateItem stateItem, int i, boolean z);
}
