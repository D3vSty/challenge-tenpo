package com.stavaray.challenge_tenpo.controller;

import com.stavaray.challenge_tenpo.dto.CallRecordDto;
import com.stavaray.challenge_tenpo.service.HistoryService;
import com.stavaray.challenge_tenpo.util.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Constants.HISTORY_ROUTE)
@RequiredArgsConstructor
public class HistoryController {

    private final HistoryService historyService;

    @GetMapping
    public ResponseEntity<Page<CallRecordDto>> history(Pageable pageable) {
        return ResponseEntity.ok(historyService.getHistory(pageable));
    }
}
