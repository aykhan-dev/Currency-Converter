package az.kapital.test.data.api;

import az.kapital.test.data.dto.CurrenciesDTO;
import az.kapital.test.data.dto.CurrencyConversionDTO;
import io.reactivex.rxjava3.core.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CurrencyApi {

    @GET("list")
    Flowable<CurrenciesDTO> getAllCurrencies();

    @GET("convert")
    Flowable<CurrencyConversionDTO> getConversionResult(
            @Query("format") String format,
            @Query("from") String baseCurrencyCode,
            @Query("to") String targetCurrencyCode,
            @Query("amount") String amount
    );

}
