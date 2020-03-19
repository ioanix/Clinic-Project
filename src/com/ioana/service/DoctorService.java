package com.ioana.service;

import com.ioana.domain.Doctor;
import com.ioana.domain.DoctorValidator;
import com.ioana.repository.DoctorRepository;

import java.security.KeyException;
import java.util.List;


public class DoctorService {


    private DoctorRepository doctorRepository;
    private DoctorValidator doctorValidator;

    public DoctorService(DoctorRepository doctorRepository, DoctorValidator doctorValidator) {

        this.doctorRepository = doctorRepository;
        this.doctorValidator = doctorValidator;
    }


    public void addDoctorService(int doctorId, String firstName, String lastName, int age) throws KeyException {

        Doctor doctor = new Doctor(doctorId, firstName, lastName, age);
        doctorValidator.validate(doctor);

        doctorRepository.addDoctor(doctor);
    }


    public List<Doctor> getAll() {

        return this.doctorRepository.readAll();

    }


}
