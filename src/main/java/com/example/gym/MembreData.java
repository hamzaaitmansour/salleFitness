package com.example.gym;

import java.util.Date;

public class MembreData {
        private int id;
        private String Membre_Id;
        private String Membre_name;
        private String Membre_adresse;
        private String Membre_gendre;
        private int Membre_phone;
        private double price ;
        private String Membre_status;
        private String Membre_schedule;
        private Date dateDebut;
        private Date dateFin;

    public MembreData(int id, String membre_Id, String membre_name, String membre_adresse, String membre_gendre, int membre_phone, double price, String membre_status, String membre_schedule, Date dateDebut, Date dateFin) {
        this.id = id;
        Membre_Id = membre_Id;
        Membre_name = membre_name;
        Membre_adresse = membre_adresse;
        Membre_gendre = membre_gendre;
        Membre_phone = membre_phone;
        this.price = price;
        Membre_status = membre_status;
        Membre_schedule = membre_schedule;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    public int getId() {
        return id;
    }

    public String getMembre_Id() {
        return Membre_Id;
    }

    public String getMembre_name() {
        return Membre_name;
    }

    public String getMembre_adresse() {
        return Membre_adresse;
    }

    public String getMembre_gendre() {
        return Membre_gendre;
    }

    public int getMembre_phone() {
        return Membre_phone;
    }

    public double getPrice() {
        return price;
    }

    public String getMembre_status() {
        return Membre_status;
    }

    public String getMembre_schedule() {
        return Membre_schedule;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

}
