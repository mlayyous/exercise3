package com.example.exercise.api;

import com.example.exercise.api.model.ServiceSpending;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.*;
import org.apache.http.util.EntityUtils;
import org.junit.ClassRule;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.wait.strategy.Wait;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import java.io.IOException;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@Testcontainers
class ApplicationTests {

    private static final int appPort = 8080;

    @ClassRule
    public static GenericContainer<?> appContainer = new GenericContainer<>(DockerImageName.parse("recruitment/panaseer-exercise"))
            .withExposedPorts(appPort)
            .withStartupTimeout(Duration.of(30, ChronoUnit.SECONDS))
            .waitingFor(Wait.forListeningPort());
    static String address;
    @BeforeAll
    public static void beforeAll() {
        appContainer.start();
        address = "http://"
                + appContainer.getContainerIpAddress()
                + ":" + appContainer.getMappedPort(appPort);
    }



    @AfterAll
    public static void afterAll() {
        appContainer.stop();
    }

    @Test
    void contextLoads() {
    }

    @Test
    void spendingControllerTest_OK() throws IOException {

        HttpGet request = new HttpGet(address + "/spending/service");
        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(request)) {
            assertEquals(HttpStatus.SC_OK, response.getStatusLine().getStatusCode());
        }
    }

    @Test
    void userControllerTest_OK() throws IOException {

        HttpGet request = new HttpGet(address + "/users/service");
        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(request)) {
            assertEquals(HttpStatus.SC_OK, response.getStatusLine().getStatusCode());
        }
    }

    @Test
    void userControllerTestById_OK() throws IOException {

        HttpGet request = new HttpGet(address + "/users/service/1");
        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(request)) {
            assertEquals(HttpStatus.SC_OK, response.getStatusLine().getStatusCode());
        }
    }

    @Test
    void userControllerTestById_Error() throws IOException {

        HttpGet request = new HttpGet(address + "/users/service/100");
        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(request)) {
            assertEquals(HttpStatus.SC_INTERNAL_SERVER_ERROR, response.getStatusLine().getStatusCode());
        }
    }
    @Test
    void spendingControllerTest_size() throws IOException {

        HttpGet request = new HttpGet(address + "/spending/service");
        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(request)) {
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                String result = EntityUtils.toString(entity);
                ObjectMapper mapper = new ObjectMapper();
                List<ServiceSpending> serviceSpendingList = mapper.readValue(result, mapper.getTypeFactory().constructCollectionType(List.class, ServiceSpending.class));
                assertEquals(11, serviceSpendingList.size());
            }
        }
    }
    @Test
    void applicationActuator_Up() throws IOException {

        HttpGet request = new HttpGet(address + "/actuator/health");
        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(request)) {
            assertEquals(HttpStatus.SC_OK, response.getStatusLine().getStatusCode());
        }
    }
}