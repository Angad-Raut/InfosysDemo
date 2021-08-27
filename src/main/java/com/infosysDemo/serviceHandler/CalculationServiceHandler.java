package com.infosysDemo.serviceHandler;
import java.util.ArrayList;


import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.stereotype.Component;

import com.infosysDemo.service.CalculationService;
import com.infosysDemo.dto.DataRequestDto;
import com.infosysDemo.dto.DataResponseDto;
import com.infosysDemo.util.InvalidDataException;

@Component
public class CalculationServiceHandler implements CalculationService {

    @Override
    public DataResponseDto getCalcutate(DataRequestDto requestDto) throws InvalidDataException {
       List<Integer> greaterThanAvg=new ArrayList<Integer>();
       DataResponseDto response=new DataResponseDto();
       if(!requestDto.getNumberList().isEmpty()){
           Double average=0.0;
           int[] array =requestDto.getNumberList().stream().mapToInt(i->i).toArray();
           response.setSum(IntStream.of(array).sum());
           average=Arrays.stream(array).average().orElse(Double.NaN);
           response.setAgverage(Arrays.stream(array).average().orElse(Double.NaN));
           for(Integer inte:requestDto.getNumberList()){
                 if(inte>average){
                     greaterThanAvg.add(inte);
                 }
           }
           response.setGreaterThanAverage(greaterThanAvg);
       }
       return response;
    }
}
