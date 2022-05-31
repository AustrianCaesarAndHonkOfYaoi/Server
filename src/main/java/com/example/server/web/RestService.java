package com.example.server.web;

import com.example.server.UserNation;
import com.vaadin.flow.server.VaadinService;
import com.vaadin.flow.server.VaadinServletRequest;
import java.util.List;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class RestService {

  private final RestTemplate restTemplate;

  public RestService(RestTemplateBuilder restTemplateBuilder) {
    this.restTemplate = restTemplateBuilder.build();
  }

  public List<UserNation> getAllInfos() throws RestClientException {
    VaadinServletRequest request = (VaadinServletRequest) VaadinService.getCurrentRequest();
    String host = request.getHttpServletRequest().getRequestURL().toString();
    String url = host + "/getAllInfos";

    return exchangeAsList(url, new ParameterizedTypeReference<>() {
    });

  }

  public <T> List<T> exchangeAsList(String uri, ParameterizedTypeReference<List<T>> responseType) {
    return restTemplate.exchange(uri, HttpMethod.GET, null, responseType).getBody();
  }
}