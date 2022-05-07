package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.util.Function;

public class Transformations {
    private Transformations() {
    }

    @MainThread
    public static <X, Y> LiveData<Y> map(@NonNull LiveData<X> source, @NonNull Function<X, Y> mapFunction) {
        LiveData<X> liveData;
        Observer observer;
        new MediatorLiveData<>();
        LiveData<X> source2 = liveData;
        final MediatorLiveData mediatorLiveData = source2;
        final Function<X, Y> function = mapFunction;
        new Observer<X>() {
            public void onChanged(@Nullable X x) {
                mediatorLiveData.setValue(function.apply(x));
            }
        };
        source2.addSource(source, observer);
        return source2;
    }

    @MainThread
    public static <X, Y> LiveData<Y> switchMap(@NonNull LiveData<X> source, @NonNull Function<X, LiveData<Y>> switchMapFunction) {
        LiveData<X> liveData;
        Observer observer;
        new MediatorLiveData<>();
        LiveData<X> source2 = liveData;
        final Function<X, LiveData<Y>> function = switchMapFunction;
        final MediatorLiveData mediatorLiveData = source2;
        new Observer<X>() {
            LiveData<Y> mSource;

            public void onChanged(@Nullable X x) {
                Observer observer;
                LiveData<Y> newLiveData = (LiveData) function.apply(x);
                if (this.mSource != newLiveData) {
                    if (this.mSource != null) {
                        mediatorLiveData.removeSource(this.mSource);
                    }
                    this.mSource = newLiveData;
                    if (this.mSource != null) {
                        new Observer<Y>(this) {
                            final /* synthetic */ AnonymousClass2 this$0;

                            {
                                this.this$0 = this$0;
                            }

                            public void onChanged(@Nullable Y y) {
                                mediatorLiveData.setValue(y);
                            }
                        };
                        mediatorLiveData.addSource(this.mSource, observer);
                    }
                }
            }
        };
        source2.addSource(source, observer);
        return source2;
    }
}
