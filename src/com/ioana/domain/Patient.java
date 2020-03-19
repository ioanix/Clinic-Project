package com.ioana.domain;

public class Patient {

    private int patientId;
    private String patientFirstName;
    private String patientLastName;
    private int patientAge;
    private String consultationReason;


    public Patient(int patientId, String patientFirstName, String patientLastName, int patientAge, String consultationReason) {

        this.patientId = patientId;
        this.patientFirstName = patientFirstName;
        this.patientLastName = patientLastName;
        this.patientAge = patientAge;
        this.consultationReason = consultationReason;

    }

    public int getPatientId() {
        return patientId;
    }

    public String getPatientFirstName() {
        return patientFirstName;
    }

    public void setPatientFirstName(String patientFirstName) {
        this.patientFirstName = patientFirstName;
    }

    public String getPatientLastName() {
        return patientLastName;
    }

    public void setPatientLastName(String patientLastName) {
        this.patientLastName = patientLastName;
    }

    public int getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(int patientAge) {
        this.patientAge = patientAge;
    }

    public String getConsultationReason() {
        return consultationReason;
    }

    public void setConsultationReason(String consultationReason) {
        this.consultationReason = consultationReason;
    }


    @Override
    public String toString() {

        return "Patient{" +
                "patientFirstName='" + patientFirstName + '\'' +
                ", patientLastName='" + patientLastName + '\'' +
                ", patientAge=" + patientAge +
                ", consultationReason=" + consultationReason +
                '}';
    }
}
