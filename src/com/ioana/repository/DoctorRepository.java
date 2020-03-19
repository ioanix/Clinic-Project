package com.ioana.repository;

import com.ioana.domain.Doctor;
import com.ioana.domain.Patient;
import java.security.KeyException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DoctorRepository {


    private Map<Integer, Doctor> storage = new HashMap<>();


    public void addDoctor(Doctor doctor) throws KeyException {

        if (storage.containsKey(doctor.getDoctorId())) {

            throw new KeyException("The id already exists!");

        }

        storage.put(doctor.getDoctorId(), doctor);
    }


    public Doctor read(int doctorId) {

        return storage.get(doctorId);
    }


    public List<Doctor> readAll() {

        return new ArrayList<>(storage.values());

    }


    public void update(Doctor doctor) throws KeyException {

        if (!storage.containsKey(doctor.getDoctorId())) {

            throw new KeyException("The id does not exist!");

        }

        storage.put(doctor.getDoctorId(), doctor);
    }


    public void delete(int id) throws KeyException {

        if (!storage.containsKey(id)) {

            throw new KeyException("The id does not exist!");

        }

        storage.remove(id);

    }


    public Patient returnPatient(int doctorId) {

        return storage.get(doctorId).getPatient();
    }





}




















