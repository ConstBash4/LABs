package ru.vasilkov.Service1.service;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.vasilkov.Service1.model.Request;
import ru.vasilkov.Service1.model.Systems;

@Service
public class ModifySystemNameRequestService implements ModifyRequestService {
    @Override
    public void modify(Request request) {
        request.setSystemName(Systems.SERVICEONE);
    }
}
