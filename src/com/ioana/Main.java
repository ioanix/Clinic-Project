package com.ioana;

import com.ioana.controller.ClinicController;
import com.ioana.domain.*;
import com.ioana.repository.DoctorRepository;
import com.ioana.repository.PatientRepository;
import com.ioana.service.DoctorService;
import com.ioana.service.PatientService;
import com.ioana.userinterface.Console;

import java.security.KeyException;


public class Main {

    public static void main(String[] args) throws KeyException {


        DoctorRepository doctorRepository = new DoctorRepository();
        DoctorValidator doctorValidator = new DoctorValidator();
        DoctorService doctorService = new DoctorService(doctorRepository, doctorValidator);

        PatientRepository patientRepository = new PatientRepository();
        PatientValidator patientValidator = new PatientValidator();
        PatientService patientService = new PatientService(patientRepository, patientValidator);

        ClinicController clinicController = new ClinicController(doctorService, patientService);

        clinicController.generateListOfDoctors();
        clinicController.storeTheListOfDoctorsToFile();

        clinicController.generateListOfPatients();
        clinicController.printSummaryOfPatientsBasedOnAge();
        clinicController.storeTheListOfPatientsToFile();

        clinicController.getPatientsForDoctor();

        Console console = new Console(doctorService, patientService);
        console.runUserInterface();

    }

}




























