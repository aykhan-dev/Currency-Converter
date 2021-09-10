package az.kapital.test.ui.base;

import az.kapital.test.ui.base.callback.PresenterAsyncCall;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public abstract class BasePresenter<View extends BaseViewInterface> {

    private boolean isLoading;

    private View view;

    private final CompositeDisposable disposable = new CompositeDisposable();

    protected <T> void request(PresenterAsyncCall<T> call) {
        setLoading(true);
        call.async()
                .toObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<T>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        call.onSubscribe(d);
                        disposable.add(d);
                    }

                    @Override
                    public void onNext(@NonNull T t) {
                        call.onNext(t);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        call.onError(e);
                        notifyUIErrorState(e);
                    }

                    @Override
                    public void onComplete() {
                        setLoading(false);
                        call.onComplete();
                    }
                });
    }

    protected void destroyAll() {
        disposable.clear();
    }

    private void notifyUILoadingState(boolean isLoading) {
        view.handleLoading(isLoading);
    }

    private void notifyUIErrorState(Throwable error) {
        view.handleError(error);
    }

    // GETTERS & SETTERS

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }

    public boolean isLoading() {
        return isLoading;
    }

    public void setLoading(boolean value) {
        isLoading = value;
        notifyUILoadingState(this.isLoading);
    }

}
