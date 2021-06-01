package com.tirgei.data.mappers;


import com.google.common.truth.Truth;
import com.tirgei.data.repositories.responses.Applicable;
import com.tirgei.data.repositories.responses.InputElements;
import com.tirgei.data.repositories.responses.Links;
import com.tirgei.domain.models.PaymentMethod;

import org.junit.Test;

import java.util.Collections;

public class ResponseToDomainMapperTest {

    @Test(expected = NullPointerException.class)
    public void givenNullApplicable_shouldThrowNullPointerException() {
        ResponseToDomainMapper.applicableToDomain(null);
    }

    @Test
    public void givenApplicable_shouldReturnPaymentMethod() {
        Applicable applicable = new Applicable(
                "code",
                "label",
                "method",
                "grouping",
                "registration",
                "recurrence",
                false,
                "operationType",
                new Links("logo", "", "", "", ""),
                Collections.singletonList(new InputElements("name", "type"))
        );

        PaymentMethod method = ResponseToDomainMapper.applicableToDomain(applicable);

        Truth.assertThat(applicable.getCode()).isEqualTo(method.getCode());
        Truth.assertThat(applicable.getLabel()).isEqualTo(method.getLabel());
        Truth.assertThat(applicable.getLinks().getLogo()).isEqualTo(method.getLogo());
    }

}