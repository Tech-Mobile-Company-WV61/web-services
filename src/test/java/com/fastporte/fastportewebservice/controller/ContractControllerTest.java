/*
package com.fastporte.fastportewebservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fastporte.fastportewebservice.entities.*;
import com.fastporte.fastportewebservice.service.impl.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = ContractController.class)
@ActiveProfiles("test")
public class ContractControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ContractServiceImpl contractService;
    @MockBean
    private ClientServiceImpl clientService;
    @MockBean
    private DriverServiceImpl driverService;
    @MockBean
    private StatusContractServiceImpl statusContractService;
    @MockBean
    private NotificationServiceImpl notificationService;

    private List<Contract> contractList;



    public static Date ParseDate(String date) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date result = null;
        try {
            result = format.parse(date);
        } catch (Exception ex) {
        }
        return result;
    }

    public static Time ParseTime(String time) {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        Time result = null;
        try {
            result = (Time) format.parse(time);
        } catch (Exception ex) {
        }
        return result;
    }

    @Test
    void findAllContracts() throws Exception {
        given(contractService.getAll()).willReturn(contractList);
        mockMvc.perform(get("/api/contracts"))
                .andExpect(status().isOk());
    }

    @Test
    void findContractById() throws Exception {
        given(contractService.getById(1L)).willReturn(Optional.ofNullable(contractList.get(0)));
        mockMvc.perform(get("/api/contracts/1"))
                .andExpect(status().isOk());
    }


//    @Test
//    void insertContract() throws Exception {
//        Contract contract = new Contract(4L, "moving", "Lima", "Arequipa", ParseDate("2021-07-21"), ParseTime("05:50:00"),
//                ParseTime("17:50:00"), "500", "20", "Looking for a moving driver", true,
//                new Client(1L, "Antonio", "Martinez", "Antonio Martinez", "photo",
//                        "a@gmail.com", "983654313", "Amazonas", ParseDate("1998/05/01"), "pass321", "I want to have the best service"),
//                new Driver(1L, "Roger", "Juarez", "Roger Juarez", "photo", "q@gmail.com", "983654313",
//                        "Amazonas", ParseDate("1995/08/23"), "pass321", "Hi, I'm Roger Juarez and I'm a driver"),
//                new StatusContract(1L, "OFFER"),
//                new Notification(0L, false));
//        //given(contractService.save(contract)).willReturn(contract);
//        mockMvc.perform(post("/api/contracts/add/client=1/driver=1")
//                        .content(asJsonString(contract))
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isCreated());
//    }



    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}*/
