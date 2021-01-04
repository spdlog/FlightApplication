package com.example.flight;

import com.example.flight.controller.TicketController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(TicketController.class)
class ControllerTests {
    @Autowired
    private MockMvc mvc;
    public AppData data = new AppData();

    @Test
    void checkTicketIdIfAvailable() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/checkIfTicketAvailable?ID=1");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("true", result.getResponse().getContentAsString());

    }

    @Test
    void checkTickeIdIfNotAvailable() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/checkIfTicketAvailable?ID=1231");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("false", result.getResponse().getContentAsString());

    }

    @Test
    void checkIfCheckedIn() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/checkIfCheckedIn?DestinationID=192&BaggageID=11");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("true", result.getResponse().getContentAsString());

    }

    @Test
    void checkIfNotCheckedIn() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/checkIfCheckedIn?DestinationID=1&BaggageID=11");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("false", result.getResponse().getContentAsString());
    }
}