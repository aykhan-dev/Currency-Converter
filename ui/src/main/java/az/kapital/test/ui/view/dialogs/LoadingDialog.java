package az.kapital.test.ui.view.dialogs;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;

public class LoadingDialog extends DialogFragment {

    public static String TAG = "Loading Dialog" ;

    @Inject
    public LoadingDialog() {

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        AndroidSupportInjection.inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setCancelable(false);
        getDialog().getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        return new ProgressBar(getContext());
    }

}
