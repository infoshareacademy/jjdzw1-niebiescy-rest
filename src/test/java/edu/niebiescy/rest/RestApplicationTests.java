package edu.niebiescy.rest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest

public class RestApplicationTests {


    @Autowired
    WebApplicationContext webCtx;

    MockMvc mocMvc;

    @Before
    public void setUp() throws Exception {

        mocMvc = MockMvcBuilders.webAppContextSetup(webCtx).build();

    }


    @Test
    public void contextLoads() throws Exception {

        mocMvc.perform(get("/events")).andExpect(status().is(200));

    }

}
