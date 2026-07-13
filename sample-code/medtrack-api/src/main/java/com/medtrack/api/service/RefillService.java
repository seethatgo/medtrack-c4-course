package com.medtrack.api.service;

import com.medtrack.api.client.PharmacyClient;
import com.medtrack.api.model.RefillRequest;
import com.medtrack.api.model.RefillRequestDto;
import com.medtrack.api.repository.RefillRepository;
import org.springframework.stereotype.Service;

/** Orchestrates the refill flow: eligibility, then pharmacy, then notification. */
@Service
public class RefillService {

    private final RefillRepository refillRepository;
    private final EligibilityService eligibilityService;
    private final PharmacyClient pharmacyClient;
    private final NotificationService notificationService;

    public RefillService(RefillRepository refillRepository,
                         EligibilityService eligibilityService,
                         PharmacyClient pharmacyClient,
                         NotificationService notificationService) {
        this.refillRepository = refillRepository;
        this.eligibilityService = eligibilityService;
        this.pharmacyClient = pharmacyClient;
        this.notificationService = notificationService;
    }

    public RefillRequest requestRefill(RefillRequestDto dto) {
        RefillRequest refill = new RefillRequest();
        refill.setPatientId(dto.getPatientId());
        refill.setMedicationName(dto.getMedicationName());

        // 1. Check coverage before doing anything else.
        boolean covered = eligibilityService.isCovered(dto.getPatientId(), dto.getMedicationName());
        if (!covered) {
            refill.setStatus("DENIED_NO_COVERAGE");
            RefillRequest saved = refillRepository.save(refill);
            notificationService.notifyRefillStatus(dto.getPatientId(), saved.getStatus());
            return saved;
        }

        // 2. Submit the approved refill to the pharmacy network.
        pharmacyClient.submitRefill(dto.getPatientId(), dto.getMedicationName());
        refill.setStatus("SUBMITTED");
        RefillRequest saved = refillRepository.save(refill);

        // 3. Tell the patient where things stand.
        notificationService.notifyRefillStatus(dto.getPatientId(), saved.getStatus());
        return saved;
    }
}
