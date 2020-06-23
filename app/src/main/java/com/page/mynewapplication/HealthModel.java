package com.page.mynewapplication;

public class HealthModel {
   private String healthtitle,healthdescription;
   //private int healthimage;

    public HealthModel(String healthtitle, String healthdescription) {
        this.healthtitle = healthtitle;
        this.healthdescription = healthdescription;
        //this.healthimage = healthimage;
    }

    public String getHealthtitle() {
        return healthtitle;
    }

    public void setHealthtitle(String healthtitle) {
        this.healthtitle = healthtitle;
    }

    public String getHealthdescription() {
        return healthdescription;
    }

    public void setHealthdescription(String healthdescription) {
        this.healthdescription = healthdescription;
    }

//    public int getHealthimage() {
//        return healthimage;
//    }

//    public void setHealthimage(int healthimage) {
//        this.healthimage = healthimage;
//    }

}