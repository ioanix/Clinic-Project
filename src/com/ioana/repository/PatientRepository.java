package com.ioana.repository;


import com.ioana.domain.Patient;

import java.security.KeyException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PatientRepository {


    private Map<Integer, Patient> storage = new HashMap<>();


    public void addPatient(Patient patient) throws KeyException {

        if (storage.containsKey(patient.getPatientId())) {

            throw new KeyException("The id already exists!");

        }

        storage.put(patient.getPatientId(), patient);
    }


    public Patient read(int patientId) {

        return storage.get(patientId);
    }


    public List<Patient> readAll() {

        return new ArrayList<>(storage.values());

    }


    public void update(Patient patient) throws KeyException {

        if (!storage.containsKey(patient.getPatientId())) {

            throw new KeyException("The id does not exist!");

        }

        storage.put(patient.getPatientId(), patient);
    }


    public void delete(int id) throws KeyException {

        if (!storage.containsKey(id)) {

            throw new KeyException("The id does not exist!");

        }

        storage.remove(id);

    }
}
