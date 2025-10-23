package ru.vasilkov.Service2.service;

import org.springframework.stereotype.Service;
import ru.vasilkov.Service2.model.Response;

@Service
public interface ModifyResponseService {
    void modify(Response response);
}
