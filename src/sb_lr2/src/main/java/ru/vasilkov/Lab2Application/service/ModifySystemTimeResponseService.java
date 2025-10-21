package ru.vasilkov.Lab2Application.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.vasilkov.Lab2Application.model.Response;
import ru.vasilkov.Lab2Application.util.DateTimeUtil;

import java.util.Date;

@Service
@Qualifier("ModifySystemTimeResponseService")
public class ModifySystemTimeResponseService implements ModifyResponseService {
    @Override
    public Response modify(Response response) {
        response.setSystemTime(DateTimeUtil.getCustomFormat().format(new Date()));
        return response;
    }
}
