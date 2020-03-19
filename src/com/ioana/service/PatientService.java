package com.ioana.service;

import com.ioana.domain.Patient;
import com.ioana.domain.PatientValidator;
import com.ioana.repository.PatientRepository;

import java.security.KeyException;
import java.util.List;

public class PatientService {


    private PatientRepository patientRepository;
    private PatientValidator patientValidator;


    public PatientService(PatientRepository patientRepository, PatientValidator patientValidator) {

        this.patientRepository = patientRepository;
        this.patientValidator = patientValidator;
    }


    public void addPatientService(int patientId, String patientFirstName, String patientLastName, int patientAge, String consultationReason) throws KeyException {

        Patient patient = new Patient(patientId, patientFirstName, patientLastName, patientAge, consultationReason);
        this.patientValidator.validatePatient(patient);

        this.patientRepository.addPatient(patient);
    }


    public List<Patient> getAll() {

        return patientRepository.readAll();
    }
}
