package ru.vasilkov.Service2.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.vasilkov.Service2.model.Response;
import ru.vasilkov.Service2.util.DateTimeUtil;

import java.util.Date;

@Service
@Qualifier("ModifySystemTimeResponseService")
public class ModifySystemTimeResponseService implements ModifyResponseService {
    @Override
    public void modify(Response response) {
        response.setSystemTime(DateTimeUtil.getCustomFormat().format(new Date()));
    }
}
