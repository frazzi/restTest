package com.example.demo;

import com.example.demo.model.Account;
import org.json.JSONException;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AccountControllerIntegrationTest {

    TestRestTemplate restTemplate = new TestRestTemplate();

    HttpHeaders headers = new HttpHeaders();

    @LocalServerPort
    private int port;

    @Test
    public void findAllAccountsFromRepositoryTest() throws JSONException {
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/account-project/rest/account/json"),
                HttpMethod.GET, entity, String.class);

        String expected = "[{\"id\":1,\"firstName\":\"John\",\"secondName\":\"Doe\",\"accountNumber\":\"1234\"},{\"id\":2,\"firstName\":\"Jane\",\"secondName\":\"Doe\",\"accountNumber\":\"1235\"},{\"id\":3,\"firstName\":\"Jim\",\"secondName\":\"Taylor\",\"accountNumber\":\"1236\"}]";

        JSONAssert.assertEquals(expected, response.getBody(), false);
    }

    @Test
    public void saveAccountToRepositoryTest() throws JSONException {
        Account account = new Account(null, "Steven", "Doe", "123458");

        HttpEntity<Account> entity = new HttpEntity<Account>(account, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/account-project/rest/account/json"),
                HttpMethod.POST, entity, String.class);

        String expected = "{\"message\": \"account has been successfully added\"}";

        JSONAssert.assertEquals(expected, response.getBody(), false);

    }

    @Test
    public void removeAnAccountFromRepositoryTest() throws JSONException {
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/account-project/rest/account/json/1"),
                HttpMethod.DELETE, null, String.class);

        String expected = "{\"message\": \"account successfully deleted\"}";

        JSONAssert.assertEquals(expected, response.getBody(), false);

    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }

}
