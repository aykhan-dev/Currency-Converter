package az.kapital.test.ui.base.callback;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.disposables.Disposable;

public interface PresenterAsyncCall<T> {

    Flowable<T> async();

    default void onSubscribe(Disposable disposable) {

    }

    default void onNext(T item) {

    }

    default void onError(Throwable error) {

    }

    default void onComplete() {

    }

}
