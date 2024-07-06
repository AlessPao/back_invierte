package com.invertir.ya.controller;

import com.invertir.ya.dto.MortgageDTO;
import com.invertir.ya.service.ICalculatorService;
import com.invertir.ya.util.Constant;
import com.invertir.ya.util.WrapperResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculators")
@RequiredArgsConstructor
public class CalculatorController
{
    private final ICalculatorService service;

    @PostMapping("/mortgage")
    public ResponseEntity<WrapperResponse<Double>> calculateMortgage(@RequestBody @Valid MortgageDTO dto)
    {
        return new WrapperResponse<>(true, Constant.SUCCESS, service.calculateMortgage(dto)).createResponse();
    }
}
