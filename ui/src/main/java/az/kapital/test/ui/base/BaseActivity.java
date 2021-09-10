package az.kapital.test.ui.base;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.viewbinding.ViewBinding;

import javax.inject.Inject;

import az.kapital.test.ui.base.callback.ActivityBindingCallback;
import dagger.android.support.DaggerAppCompatActivity;

public abstract class BaseActivity<Binding extends ViewBinding> extends DaggerAppCompatActivity implements LifecycleObserver {

    protected abstract ActivityBindingCallback<Binding> getBindingCallback();

    private Binding ui;

    @Inject
    protected Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLifecycle().addObserver(this);
        ui = getBindingCallback().bind(getLayoutInflater());
        setContentView(ui.getRoot());
        onReadyUI(ui);
    }

    protected abstract void onReadyUI(Binding ui);

    public Binding getUi() {
        return ui;
    }

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

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    protected void onDestroyState() {

    }

}
