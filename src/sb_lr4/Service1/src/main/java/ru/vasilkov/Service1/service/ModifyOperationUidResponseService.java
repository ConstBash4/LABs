package ru.vasilkov.Service1.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.vasilkov.Service1.model.Response;

import java.util.UUID;

@Service
public class ModifyOperationUidResponseService implements ModifyResponseService {
    @Override
    public void modify(Response response) {
        UUID uuid = UUID.randomUUID();
        response.setOperationUid(uuid.toString());
    }
}
