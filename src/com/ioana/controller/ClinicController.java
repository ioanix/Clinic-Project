package com.ioana.controller;

import com.ioana.domain.*;
import com.ioana.service.DoctorService;
import com.ioana.service.PatientService;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.security.KeyException;
import java.util.*;

public class ClinicController {

    private DoctorService doctorService;
    private PatientService patientService;

    private Random random = new Random();
    private BufferedWriter writer = null;


    public ClinicController(DoctorService doctorService, PatientService patientService) {

        this.doctorService = doctorService;
        this.patientService = patientService;
    }


    public void generateListOfDoctors() throws KeyException {

        List<String> firstNames = Arrays.asList("Ioa", "Ale", "Adr", "Ali", "Rob", "Ama");
        List<String> lastNames = Arrays.asList("Mu", "Po", "Mo", "Cr", "St", "Ci");

        for (int i = 0; i < 10; i++) {

            int id = random.nextInt((9999 - 1000) + 1) + 1000;
            int age = random.nextInt((65 - 30) + 1) + 30;

            int randomFirstNameIndex = random.nextInt(firstNames.size());
            int randomLastNameIndex = random.nextInt(lastNames.size());

            String firstName = firstNames.get(randomFirstNameIndex);
            String lastName = lastNames.get(randomLastNameIndex);

            doctorService.addDoctorService(id, firstName, lastName, age);

        }
    }

    public void storeTheListOfDoctorsToFile() {


        try {

            writer = new BufferedWriter(new FileWriter("doctor.txt"));

            for (Doctor doc : doctorService.getAll()) {

                writer.write(doc.toString() + "\n");

            }


            System.out.println("Data is saved in doctor.txt");
            System.out.println("**************");
            writer.close();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }


    public void generateListOfPatients() throws KeyException {

        List<String> patientsFirstNames = Arrays.asList("Ioana", "Alexa", "Adria", "Alina", "Rober", "Crist");
        List<String> patientsLastNames = Arrays.asList("Mure", "Pope", "Mold", "Cris", "Stro", "Cire");
        List<String> visitReasons = Arrays.asList("consultation", "treatment", "prescriptions");

        for (int i = 0; i < 100; i++) {

            int age = random.nextInt((85 + 1));

            int randomFirstNameIndex = random.nextInt(patientsFirstNames.size());
            int randomLastNameIndex = random.nextInt(patientsLastNames.size());
            int randomVisitReasonIndex = random.nextInt(visitReasons.size());

            String firstName = patientsFirstNames.get(randomFirstNameIndex);
            String lastName = patientsLastNames.get(randomLastNameIndex);
            String visitReason = visitReasons.get(randomVisitReasonIndex);

            patientService.addPatientService(i, firstName, lastName, age, visitReason);

        }

    }


    public void printSummaryOfPatientsBasedOnAge() {

        int count = 0;
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;

        for (Patient patient : patientService.getAll()) {


            if (patient.getPatientAge() == 0) {

                count++;
            }

            if (patient.getPatientAge() >= 1 && patient.getPatientAge() < 7) {

                count1++;
            }

            if (patient.getPatientAge() >= 7 && patient.getPatientAge() < 18) {

                count2++;
            }

            if (patient.getPatientAge() >= 18) {

                count3++;
            }

        }

        System.out.println("Children(0-1): " + count + " patients" + "\n" +
                "Pupil(1-7): " + count1 + " patients" + "\n" +
                "Student(7-18): " + count2 + " patients" + "\n" +
                "Adults(>=18): " + count3 + " patients");

        System.out.println("*************");

    }


    public void storeTheListOfPatientsToFile() {

        try {

            writer = new BufferedWriter(new FileWriter("patient.txt"));

            for (Patient patient : patientService.getAll()) {

                writer.write(patient.toString() + "\n");
            }

            System.out.println("Saving data to patient.txt");
            writer.close();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }


    public void getPatientsForDoctor() {

        Map<Doctor, List<Patient>> patientsForDoctor = new HashMap<>();

        for (Patient patient : patientService.getAll()) {

            int index = random.nextInt(doctorService.getAll().size());
            Doctor doctor = doctorService.getAll().get(index);

            if (!patientsForDoctor.containsKey(doctor)) {

                List<Patient> patientsList = new ArrayList<>();
                patientsList.add(patient);

                patientsForDoctor.put(doctor, patientsList);

            } else {

                patientsForDoctor.get(doctor).add(patient);
            }

        }

        Reason reason;

        for (Doctor doctor : patientsForDoctor.keySet()) {

            int time = 0;
            int price = 0;

            List<Patient> list = patientsForDoctor.get(doctor);

            for (Patient patient : list) {

                String choice = patient.getConsultationReason();

                switch (choice) {

                    case "consultation":
                        reason = new Consultation();
                        time += reason.getVisitTime();
                        price += reason.getVisitPrice();
                        break;

                    case "prescriptions":
                        reason = new Prescriptions();
                        time += reason.getVisitTime();
                        price += reason.getVisitPrice();
                        break;

                    case "treatment":
                        reason = new Treatment();
                        time += reason.getVisitTime();
                        price += reason.getVisitPrice();
                        break;

                }

                //System.out.println(doctor.getDoctorId() +  " " + patient.getConsultationReason());
            }

            System.out.println(doctor.getFirstName() + ", " + doctor.getLastName() + ", " + " - " + doctor.getDoctorId() +
                    ": " + list.size() + " patients" + ", " + time + " minutes" + ", " + price + " RON");

        }
    }
}
