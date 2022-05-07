package com.google.android.material.bottomsheet;

import android.app.Dialog;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatDialogFragment;

public class BottomSheetDialogFragment extends AppCompatDialogFragment {
    public BottomSheetDialogFragment() {
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Dialog dialog;
        Bundle bundle2 = bundle;
        new BottomSheetDialog(getContext(), getTheme());
        return dialog;
    }
}
