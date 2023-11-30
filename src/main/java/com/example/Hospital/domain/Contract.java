package com.example.Hospital.domain;

public class Contract {
    private PatientCard patientCard;/*Карточка пациента*/
    private Service service;/*Оказываемая услуга*/
    private LegalRepresentative legalRepresentative;/*Законный представитель*/

    public Contract(PatientCard patientCard, Service service, LegalRepresentative legalRepresentative) {
        this.patientCard = patientCard;
        this.service = service;
        this.legalRepresentative = legalRepresentative;
    }

    public PatientCard getPatientCard() {
        return patientCard;
    }

    public void setPatientCard(PatientCard patientCard) {
        this.patientCard = patientCard;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public LegalRepresentative getLegalRepresentative() {
        return legalRepresentative;
    }

    public void setLegalRepresentative(LegalRepresentative legalRepresentative) {
        this.legalRepresentative = legalRepresentative;
    }
}
