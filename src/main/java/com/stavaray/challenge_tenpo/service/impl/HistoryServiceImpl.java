package com.stavaray.challenge_tenpo.service.impl;

import com.stavaray.challenge_tenpo.dto.CallRecordDto;
import com.stavaray.challenge_tenpo.repository.CallRecordRepository;
import com.stavaray.challenge_tenpo.service.HistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HistoryServiceImpl implements HistoryService {
    private final CallRecordRepository recordRepo;

    @Override
    public Page<CallRecordDto> getHistory(Pageable pageable) {
        return recordRepo.findAll(pageable)
                .map(CallRecordDto::fromEntity);
    }
}
