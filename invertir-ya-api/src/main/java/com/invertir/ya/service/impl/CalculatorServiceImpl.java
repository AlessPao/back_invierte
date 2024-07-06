package com.invertir.ya.service.impl;

import com.invertir.ya.dto.MortgageDTO;
import com.invertir.ya.service.ICalculatorService;
import com.invertir.ya.util.Helper;
import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements ICalculatorService
{

    @Override
    public double calculateMortgage(MortgageDTO dto) {
        return Helper.calculateMortgage(dto.getPrincipal(), dto.getAnnualInterest(), dto.getPeriod());
    }
}
