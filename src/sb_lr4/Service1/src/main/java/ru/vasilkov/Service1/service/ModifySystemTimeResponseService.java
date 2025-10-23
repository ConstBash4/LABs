package ru.vasilkov.Service1.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.vasilkov.Service1.model.Response;
import ru.vasilkov.Service1.util.DateTimeUtil;

import java.util.Date;

@Service
public class ModifySystemTimeResponseService implements ModifyResponseService {
    @Override
    public void modify(Response response) {
        response.setSystemTime(DateTimeUtil.getCustomFormat().format(new Date()));
    }
}
