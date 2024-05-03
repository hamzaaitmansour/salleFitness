package com.example.gym;

public class CoachData {
    private int id;
    private String coach_Id;
    private String coach_name;
    private String coach_adresse;
    private String coach_gendre;
    private int coach_phone;
    private String coach_status;

    public CoachData(int id,String coach_Id, String coach_name, String coach_adresse, String coach_gendre, int coach_phone, String coach_status) {
        this.id=id;
        this.coach_Id = coach_Id;
        this.coach_name = coach_name;
        this.coach_adresse = coach_adresse;
        this.coach_gendre = coach_gendre;
        this.coach_phone = coach_phone;
        this.coach_status = coach_status;
    }
    public int getId() {
        return id;
    }
    public String getCoach_Id() {
        return coach_Id;
    }

    public String getCoach_name() {
        return coach_name;
    }

    public String getCoach_adresse() {
        return coach_adresse;
    }

    public String getCoach_gendre() {
        return coach_gendre;
    }

    public int getCoach_phone() {
        return coach_phone;
    }

    public String getCoach_status() {
        return coach_status;
    }
}
