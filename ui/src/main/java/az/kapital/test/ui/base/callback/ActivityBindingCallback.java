package az.kapital.test.ui.base.callback;

import android.view.LayoutInflater;

import androidx.viewbinding.ViewBinding;

public interface ActivityBindingCallback<Binding extends ViewBinding> {

    Binding bind(LayoutInflater inflater);

}
