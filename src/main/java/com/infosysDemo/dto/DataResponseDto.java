package com.infosysDemo.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DataResponseDto {

        private Integer sum;
        private Double agverage;
        private List<Integer> greaterThanAverage=new ArrayList<>();
}
