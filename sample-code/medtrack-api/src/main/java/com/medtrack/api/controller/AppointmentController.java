package com.medtrack.api.controller;

import com.medtrack.api.model.Appointment;
import com.medtrack.api.model.AppointmentRequestDto;
import com.medtrack.api.service.AppointmentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** REST endpoints for booking appointments; delegates to AppointmentService. */
@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping
    public Appointment book(@RequestBody AppointmentRequestDto request) {
        return appointmentService.book(request);
    }
}
