package az.kapital.test.data.dto;

/*

    {
        "base_currency_code":"AUD"
        "base_currency_name":"Australian dollar"
        "amount":"1.0000"
        "rates":{
            "CAD":{
                "currency_name":"Canadian dollar"
                "rate":"0.9333"
                "rate_for_amount":"0.9333"
            }
        }
    }

*/

import com.google.gson.annotations.SerializedName;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@RequiredArgsConstructor
@AllArgsConstructor
@Accessors(fluent = true)
@Getter
@Setter
public class CurrencyConversionDTO {
    @SerializedName("base_currency_code")
    private String baseCurrencyCode;
    @SerializedName("base_currency_name")
    private String baseCurrencyName;
    @SerializedName("amount")
    private String amount;
    @SerializedName("rates")
    private Map<String, CurrencyInfoDTO> rates;
}
