package az.kapital.test.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@RequiredArgsConstructor
@AllArgsConstructor
@Accessors
@Getter
@Setter
public class ConversionResult {
    private String rate;
    private String rateForAmount;
}
