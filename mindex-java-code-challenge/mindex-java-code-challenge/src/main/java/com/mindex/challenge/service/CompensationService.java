package com.mindex.challenge.service;

import com.mindex.challenge.data.Compensation;

public interface CompensationService {
    String create(Compensation compensation) throws Exception;
    Compensation read(String id) throws Exception;

}
