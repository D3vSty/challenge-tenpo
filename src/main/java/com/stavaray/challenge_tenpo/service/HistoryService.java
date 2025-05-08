package com.stavaray.challenge_tenpo.service;

import com.stavaray.challenge_tenpo.dto.CallRecordDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface HistoryService {
    Page<CallRecordDto> getHistory(Pageable pageable);
}
