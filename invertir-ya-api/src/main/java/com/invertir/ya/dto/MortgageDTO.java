package com.invertir.ya.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MortgageDTO
{
    @Max(value = 1000000, message = "El monto máximo es de 1,000,000")
    @Positive(message = "El monto debe ser positivo")
    private double principal;

    @Min(value = 10, message = "El interés mínimo es de 10")
    private double annualInterest;

    @Positive(message = "El periodo debe ser positivo")
    int period;
}
