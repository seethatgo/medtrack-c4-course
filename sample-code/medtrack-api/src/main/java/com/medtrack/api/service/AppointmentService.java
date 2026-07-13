package com.medtrack.api.service;

import com.medtrack.api.client.EhrClient;
import com.medtrack.api.model.Appointment;
import com.medtrack.api.model.AppointmentRequestDto;
import com.medtrack.api.repository.AppointmentRepository;
import org.springframework.stereotype.Service;

/** Books appointments, persisting them and reconciling against the EHR. */
@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final EhrClient ehrClient;

    public AppointmentService(AppointmentRepository appointmentRepository, EhrClient ehrClient) {
        this.appointmentRepository = appointmentRepository;
        this.ehrClient = ehrClient;
    }

    public Appointment book(AppointmentRequestDto request) {
        // Pull the patient's record of appointments from the EHR before booking.
        ehrClient.fetchPatientRecord(request.getPatientId());

        Appointment appointment = new Appointment();
        appointment.setPatientId(request.getPatientId());
        appointment.setProviderId(request.getProviderId());
        appointment.setScheduledFor(request.getScheduledFor());
        appointment.setStatus("BOOKED");
        return appointmentRepository.save(appointment);
    }
}
