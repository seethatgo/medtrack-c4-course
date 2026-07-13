package com.medtrack.api.controller;

import com.medtrack.api.model.RefillRequest;
import com.medtrack.api.model.RefillRequestDto;
import com.medtrack.api.service.RefillService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** REST endpoints for prescription refills; delegates to RefillService. */
@RestController
@RequestMapping("/refill-requests")
public class RefillController {

    private final RefillService refillService;

    public RefillController(RefillService refillService) {
        this.refillService = refillService;
    }

    @PostMapping
    public RefillRequest request(@RequestBody RefillRequestDto request) {
        return refillService.requestRefill(request);
    }
}
