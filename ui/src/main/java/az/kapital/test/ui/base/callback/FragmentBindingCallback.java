package az.kapital.test.ui.base.callback;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.viewbinding.ViewBinding;

public interface FragmentBindingCallback<Binding extends ViewBinding> {

    Binding bind(LayoutInflater inflater, ViewGroup container, boolean flag);

}
