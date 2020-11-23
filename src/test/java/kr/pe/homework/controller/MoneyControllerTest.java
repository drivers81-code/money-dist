package kr.pe.homework.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.AutoConfigureMybatis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;


@RunWith(SpringRunner.class)
@WebMvcTest(controllers = MoneyController.class)
@AutoConfigureMockMvc
@AutoConfigureMybatis 	
public class MoneyControllerTest {

	@Autowired
	private MockMvc mvc;

	public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));


	@Test
    public void distTest() throws Exception {

        Map<String, Object> anObject = new HashMap<String, Object>();
        anObject.put("distAmount", 100000);
        
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(anObject);
        
        
        String url = "/requestDistMoney";
        
        mvc.perform(post(url)
        				.header("X-USER-ID", 1)
        				.header("X-ROOM-ID", 3)
        				.contentType(APPLICATION_JSON_UTF8)
        				.content(requestJson))
            .andExpect(status().isOk())
            ;
    }
	
	@Test
    public void requestTest() throws Exception {

        Map<String, Object> anObject = new HashMap<String, Object>();
        anObject.put("token", 733);
        
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(anObject);
        
        
        String url = "/getMoney";
        
        mvc.perform(get(url)
        				.header("X-USER-ID", 2)
        				.header("X-ROOM-ID", 3)
        				.contentType(APPLICATION_JSON_UTF8)
        				.content(requestJson))
            .andExpect(status().isOk())
            ;
    }
	
	
	@Test
    public void searchTest() throws Exception {

        Map<String, Object> anObject = new HashMap<String, Object>();
        anObject.put("token", 733);
        
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(anObject);
        
        
        String url = "/searchRequest";
        
        mvc.perform(get(url)
        				.header("X-USER-ID", 1)
        				.contentType(APPLICATION_JSON_UTF8)
        				.content(requestJson))
            .andExpect(status().isOk())
            ;
    }
}