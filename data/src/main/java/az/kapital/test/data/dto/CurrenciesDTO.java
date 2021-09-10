package az.kapital.test.data.dto;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CurrenciesDTO {
    @SerializedName("currencies")
    private Map<String, String> currencies;
}
