package az.kapital.test.data.dto;

/*

    "CAD":{
        "currency_name":"Canadian dollar"
        "rate":"0.9333"
        "rate_for_amount":"0.9333"
    }

 */

import com.google.gson.annotations.SerializedName;

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
public class CurrencyInfoDTO {
    @SerializedName("currency_name")
    private String currencyName;
    @SerializedName("rate")
    private String rate;
    @SerializedName("rate_for_amount")
    private String rateForAmount;
}
