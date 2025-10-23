package ru.vasilkov.Service1.service;

import org.springframework.stereotype.Service;
import ru.vasilkov.Service1.model.Response;

@Service
public interface ModifyResponseService {
    void modify(Response response);
}
