package com.ioana.domain;

public class PatientValidator {


    public void validatePatient(Patient patient) {

        String errorMessage = "";

        if (patient.getPatientFirstName().length() != 5) {

            errorMessage += "The first name of the patient must contain 5 characters!\n";
        }

        if (patient.getPatientLastName().length() != 4) {

            errorMessage += "The last name of the patient must contain 4 characters!\n";
        }

        if (patient.getPatientAge() < 0 || patient.getPatientAge() > 85) {

            errorMessage += "The age of the patient must be between 0 and 85!\n";
        }

        if (!errorMessage.equals("")) {

            throw new IllegalArgumentException(errorMessage);
        }
    }
}
