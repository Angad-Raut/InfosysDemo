
package com.infosysDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infosysDemo.service.CalculationService;
import com.infosysDemo.dto.DataRequestDto;
import com.infosysDemo.dto.DataResponseDto;
import com.infosysDemo.util.ErrorHandler;
import com.infosysDemo.dto.ResponseDto;

@RestController
@RequestMapping(value="/api")
public class CalculationController {

    @Autowired
    CalculationService calculationService;
    
    @Autowired
    ErrorHandler errorHandler;

    @RequestMapping(value="/numberoperations",method=RequestMethod.POST)
    public ResponseEntity<ResponseDto<DataResponseDto>> getcalculation(@Validated @RequestBody 
            DataRequestDto requestDto,BindingResult result){
            if(result.hasErrors()){
                return new ResponseEntity<ResponseDto<DataResponseDto>>(new  ResponseDto<DataResponseDto>(null,null,
                        errorHandler.getErrorMessageMap(result)),HttpStatus.NOT_ACCEPTABLE);
            }
            try{
                   DataResponseDto data=calculationService.getCalcutate(requestDto);
                   return new ResponseEntity<ResponseDto<DataResponseDto>>(new ResponseDto<DataResponseDto>(data,
                           null),HttpStatus.OK);
            }catch(Exception e){
                  return new ResponseEntity<ResponseDto<DataResponseDto>>(new ResponseDto<DataResponseDto>(null,
                          e.getMessage()),HttpStatus.OK);
            }
    }
}
