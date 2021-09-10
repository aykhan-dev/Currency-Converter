package az.kapital.test.ui.base;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.viewbinding.ViewBinding;

import javax.inject.Inject;

import az.kapital.test.ui.base.callback.FragmentBindingCallback;
import az.kapital.test.ui.view.dialogs.LoadingDialog;
import dagger.android.support.DaggerFragment;

public abstract class BaseFragment<
        Presenter extends BasePresenterInterface,
        Binding extends ViewBinding
        > extends DaggerFragment implements LifecycleObserver {

    protected abstract FragmentBindingCallback<Binding> getBindingCallback();

    private Binding ui;

    @Inject
    protected Context context;

    @Inject
    protected LoadingDialog loadingDialog;

    @Inject
    protected Presenter presenter;

    protected NavController navController;

    private boolean loadingState;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        getViewLifecycleOwner().getLifecycle().addObserver(this);

        ui = getBindingCallback().bind(inflater, container, false);
        View view = ui.getRoot();

        navController = NavHostFragment.findNavController(this);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        onReadyUI(ui);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    protected abstract void onReadyUI(Binding ui);

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    protected void onCreateState() {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    protected void onStartState() {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    protected void onResumeState() {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    protected void onAnyState() {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    protected void onPauseState() {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    protected void onStopState() {
        presenter.onDestroy();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    protected void onDestroyState() {

    }

    protected void loading(boolean isLoading) {
        if (isLoading == loadingState) return;
        else loadingState = isLoading;

        if (loadingState) loadingDialog.show(getChildFragmentManager(), LoadingDialog.TAG);
        else loadingDialog.dismiss();
    }

    protected void error(Throwable error) {
        String message = error.getMessage();
        Log.e("FRAGMENT", message);
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    // GETTER & SETTERS

    protected Binding getUi() {
        return ui;
    }

    protected NavController getNavController() {
        return navController;
    }

}
