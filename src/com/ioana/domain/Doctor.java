package com.ioana.domain;


public class Doctor {

    private int doctorId;
    private String firstName;
    private String lastName;
    private int age;

    private Patient patient;


    public Doctor(int doctorId, String firstName, String lastName, int age) {

        this.doctorId = doctorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;

    }


    public int getDoctorId() {
        return doctorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }



    @Override
    public String toString() {
        return "Doctor{" +
                "doctorId='" + doctorId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
