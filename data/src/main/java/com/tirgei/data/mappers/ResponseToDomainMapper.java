package com.tirgei.data.mappers;

import com.tirgei.data.repositories.responses.Applicable;
import com.tirgei.domain.models.PaymentMethod;

/**
 * This maps api response data to the respective domain model class
 */
public class ResponseToDomainMapper {

    /**
     * Transform {@link Applicable} to {@link PaymentMethod} object
     * @param applicable - Applicable object
     * @return - returns transformed PaymentMethod object
     */
    public static PaymentMethod applicableToDomain(Applicable applicable) {
        if (applicable == null) throw new NullPointerException();

        return new PaymentMethod(
                applicable.getCode(),
                applicable.getLabel(),
                applicable.getLinks().getLogo()
        );
    }

}
