package az.kapital.test.data.di;

import javax.inject.Singleton;

import az.kapital.test.data.api.CurrencyApi;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {

    @Provides
    @Singleton
    OkHttpClient provideHttpClient() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient().newBuilder()
                .addInterceptor(loggingInterceptor)
                .addInterceptor(chain -> {
                    Request request = chain.request();
                    Request call = request.newBuilder()
                            .addHeader("x-rapidapi-host", "currency-converter5.p.rapidapi.com")
                            .addHeader("x-rapidapi-key", "ed9d765578msh5c0528742a35dcep1a6878jsn155a69841cf5")
                            .build();
                    return chain.proceed(call);
                })
                .build();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(OkHttpClient client) {
        return new Retrofit.Builder()
                .baseUrl("https://currency-converter5.p.rapidapi.com/currency/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .client(client)
                .build();
    }

    @Provides
    @Singleton
    CurrencyApi provideCurrencyApi(Retrofit retrofit) {
        return retrofit.create(CurrencyApi.class);
    }

}
