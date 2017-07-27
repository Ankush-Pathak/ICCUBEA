package iccubea.iccubea2017.com.iccubea;

import java.io.Serializable;

/**
 * Created by Aditya Rao on 7/25/2017.
 */

public class Feedback implements Serializable
{
    float ratingOverall, ratingFood, ratingAccomodation, ratingVolunteer,
            ratingOrganisation, ratingRecommend, ratingApp;

    String textExtra;


    public Feedback()
    {
        ratingAccomodation = ratingOverall = ratingVolunteer = ratingOrganisation = ratingRecommend = ratingFood = ratingApp =0;
        textExtra = "NA";
    }

    public Feedback(float ratingOverall, float ratingFood, float ratingAccomodation,
                    float ratingApp, float ratingOrganisation, float ratingVolunteer,
                    float ratingRecommend, String textExtra)
    {
        this.textExtra = textExtra;
        this.ratingAccomodation = ratingAccomodation;
        this.ratingApp = ratingApp;
        this.ratingFood = ratingFood;
        this.ratingOrganisation = ratingOrganisation;
        this.ratingOverall = ratingOverall;
        this.ratingRecommend = ratingRecommend;
        this.ratingVolunteer = ratingVolunteer;
    }

    public float getRatingOverall() {
        return ratingOverall;
    }

    public void setRatingOverall(float ratingOverall) {
        this.ratingOverall = ratingOverall;
    }

    public float getRatingAccomodation() {
        return ratingAccomodation;
    }

    public void setRatingAccomodation(float ratingAccomodation) {
        this.ratingAccomodation = ratingAccomodation;
    }

    public float getRatingFood() {
        return ratingFood;
    }

    public void setRatingFood(float ratingFood) {
        this.ratingFood = ratingFood;
    }

    public float getRatingVolunteer() {
        return ratingVolunteer;
    }

    public void setRatingVolunteer(float ratingVolunteer) {
        this.ratingVolunteer = ratingVolunteer;
    }

    public float getRatingOrganisation() {
        return ratingOrganisation;
    }

    public void setRatingOrganisation(float ratingOrganisation) {
        this.ratingOrganisation = ratingOrganisation;
    }

    public float getRatingRecommend() {
        return ratingRecommend;
    }

    public void setRatingRecommend(float ratingRecommend) {
        this.ratingRecommend = ratingRecommend;
    }

    public float getRatingApp() {
        return ratingApp;
    }

    public void setRatingApp(float ratingApp) {
        this.ratingApp = ratingApp;
    }

    public String getTextExtra() {
        return textExtra;
    }

    public void setTextExtra(String textExtra) {
        this.textExtra = textExtra;
    }
}
