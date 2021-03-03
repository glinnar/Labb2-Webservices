package com.iths.labb2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class Labb2ApplicationTests {

    @LocalServerPort
    int port;

    @Autowired
    TestRestTemplate testClient;

    @Test
    void contextLoads() {
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Accept","application/xml");
//
//        var result = testClient.getForEntity("http://localhost:"+port+"/snakes"
//        , SnakeDto[]);
//
//        assertThat(result.get)

    }

}
