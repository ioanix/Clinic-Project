package com.ioana.domain;

public class DoctorValidator {


    public void validate(Doctor doctor) {

        String errorMessage = "";

        if (doctor.getAge() < 30 || doctor.getAge() > 65) {

            errorMessage += "The age must be a number between 30 and 65!\n";
        }

        if (doctor.getFirstName().length() != 3) {

            errorMessage += "First name must contain 3 characters\n";
        }

        if (doctor.getLastName().length() != 2) {

            errorMessage += "Last name must contain 2 characters\n";
        }

        if (doctor.getDoctorId() < 1000 || doctor.getDoctorId() > 9999) {

            errorMessage += "The id must have 4 digits\n";
        }

        if (!errorMessage.equals("")) {

            throw new IllegalArgumentException(errorMessage);
        }
    }


}
