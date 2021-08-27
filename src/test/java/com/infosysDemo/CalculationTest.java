package com.infosysDemo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.infosysDemo.service.CalculationService;
import com.infosysDemo.dto.DataRequestDto;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=InfosysDemoApplication.class)
@WebAppConfiguration
@ActiveProfiles("Test")
public class CalculationTest {

    MockMvc mvc;
    
    @Autowired
    WebApplicationContext webApplicationContext;
    
    @Autowired
    private CalculationService calculationService;
    
    Gson gson=new Gson();
    
    @Before
    public void setUp() {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
     }
    
    @Test
    public void calculationTest() throws Exception {
           List<Integer> arrayList=new ArrayList<Integer>();
           arrayList.add(10);
           arrayList.add(40);
           arrayList.add(30);
           arrayList.add(30);
           DataRequestDto request=new DataRequestDto(arrayList);
            mvc.perform(post("/api/numberoperations")
                    .content(gson.toJson(request))
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON))
                   .andDo(print())
                   .andExpect(status().isOk());
    }
}
