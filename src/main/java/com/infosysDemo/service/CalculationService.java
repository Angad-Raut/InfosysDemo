package com.infosysDemo.service;

import org.springframework.stereotype.Service;

import com.infosysDemo.dto.DataRequestDto;
import com.infosysDemo.dto.DataResponseDto;
import com.infosysDemo.util.InvalidDataException;

@Service
public interface CalculationService {

         DataResponseDto getCalcutate(DataRequestDto requestDto)throws InvalidDataException;
}
