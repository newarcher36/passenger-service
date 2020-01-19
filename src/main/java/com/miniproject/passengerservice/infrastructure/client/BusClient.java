package com.miniproject.passengerservice.infrastructure.client;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;

import javax.inject.Named;
import java.io.IOException;

@Named
public class BusClient {

    private CloseableHttpClient httpClient = HttpClients.createDefault();
    private final Logger logger = LoggerFactory.getLogger(ErrorController.class);

    public boolean existsById(Long busId) {

        HttpGet request = new HttpGet("http://bus-service/buses/" + busId);

        try {
            String jsonResponse = sendRequest(request);
            return jsonResponse.isEmpty();

        } catch (IOException ioe) {
            logger.info("error querying bus service " + ioe);
            return false;
        }
    }

    private String sendRequest(HttpGet request) throws IOException {

        try (CloseableHttpResponse response = httpClient.execute(request)) {
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                return EntityUtils.toString(entity);
            }
        }

        return "";
    }
}
