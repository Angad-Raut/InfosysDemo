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
public class DataRequestDto {
     
        private List<Integer> numberList=new  ArrayList<Integer>();
}
