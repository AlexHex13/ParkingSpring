package com.test.demo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.demo.domain.Car;
import com.test.demo.repository.CarCountRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;



@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class MainControllerTest {


    private MockMvc mockMvc;

    @Autowired
    WebApplicationContext webApplicationContext;

    @MockBean
    private CarCountRepository countRepository;


    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        JacksonTester.initFields(this, new ObjectMapper());
        mockMvc = webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void getFreePlace() throws Exception {
        List<Car> list = new ArrayList<>(2);
        list.add(new Car());
        list.add(new Car());
        when(countRepository.findAll()).thenReturn(list);

        mockMvc.perform(get("/api/v1/barrier/get-free-place").accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].nameCar").value("Toyota"))
                .andExpect(jsonPath("$[1].nameCar").value("BMW"))
                .andReturn();
    }
}