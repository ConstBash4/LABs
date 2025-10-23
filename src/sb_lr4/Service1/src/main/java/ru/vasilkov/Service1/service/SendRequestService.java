package ru.vasilkov.Service1.service;

import org.springframework.stereotype.Service;
import ru.vasilkov.Service1.model.Request;

@Service
public interface SendRequestService {
    void send(Request request);
}
