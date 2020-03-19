package com.ioana.userinterface;

import com.ioana.domain.Doctor;
import com.ioana.domain.Patient;
import com.ioana.service.DoctorService;
import com.ioana.service.PatientService;

import java.security.KeyException;
import java.util.Scanner;

public class Console {


    private DoctorService doctorService;
    private PatientService patientService;
    private Scanner scanner = new Scanner(System.in);


    public Console(DoctorService doctorService, PatientService patientService) {

        this.doctorService = doctorService;
        this.patientService = patientService;
    }


    public void runUserInterface() {

        while (true) {

            showMenu();
            String option = scanner.nextLine();

            if ("1".equals(option)) {

                this.handleAddDoctorService();

            } else if ("2".equals(option)) {

                this.handleAddPatientService();

            } else if ("d".equals(option)) {

                this.showAllDoctors();

            } else if ("p".equals(option)) {

                this.showAllPatients();

            } else if ("x".equals(option)) {

                break;

            } else {

                System.out.println("Invalid option!");
            }
        }
    }


    private void showMenu() {

        System.out.println("1. Add a doctor to the list");
        System.out.println("2. Add a patient to the list");
        System.out.println("d. Print a list with all the doctors");
        System.out.println("p. Print a list with all the patients");
        System.out.println("x. Exit");
        System.out.print("Option: ");
    }


    private void handleAddDoctorService() {

        try {

            System.out.println("Enter doctor id: ");
            int id = scanner.nextInt();

            System.out.println("Enter first name of the doctor: ");
            scanner.nextLine();
            String firstName = scanner.nextLine();

            System.out.println("Enter last name of the doctor: ");
            String lastName = scanner.nextLine();

            System.out.println("Age: ");
            int age = scanner.nextInt();
            scanner.nextLine();

            this.doctorService.addDoctorService(id, firstName, lastName, age);


        } catch (IllegalArgumentException e) {

            System.out.println(e.getMessage());

        } catch (KeyException e) {

            System.out.println(e.getMessage());
        }

    }


    private void showAllDoctors() {

        for (Doctor doctor : this.doctorService.getAll()) {

            System.out.println(doctor.toString());
        }
    }


    private void handleAddPatientService() {

        try {

            System.out.println("Enter patient id: ");
            int id = scanner.nextInt();

            System.out.println("Enter first name of the patient: ");
            scanner.nextLine();
            String firstName = scanner.nextLine();

            System.out.println("Enter last name of the patient: ");
            String lastName = scanner.nextLine();

            System.out.println("Age: ");
            int age = scanner.nextInt();

            System.out.println("Enter the reason for the visit at the doctor: consultation, treatment or prescriptions");
            scanner.nextLine();
            String reason = scanner.nextLine();


            this.patientService.addPatientService(id, firstName, lastName, age, reason);


        } catch (IllegalArgumentException e) {

            System.out.println(e.getMessage());

        } catch (KeyException e) {

            System.out.println(e.getMessage());
        }

    }


    private void showAllPatients() {

        for (Patient patient : this.patientService.getAll()) {

            System.out.println(patient.toString());
        }
    }


}

























