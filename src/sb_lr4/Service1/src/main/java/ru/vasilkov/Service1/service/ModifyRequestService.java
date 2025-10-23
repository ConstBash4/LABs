package ru.vasilkov.Service1.service;

import org.springframework.stereotype.Service;
import ru.vasilkov.Service1.model.Request;

@Service
public interface ModifyRequestService {
    void modify(Request request);
}
