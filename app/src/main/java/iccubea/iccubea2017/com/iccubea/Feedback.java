package iccubea.iccubea2017.com.iccubea;package

import java.io.Serializable;

/**
 * Created by Aditya Rao on 7/25/2017.
 */

public class Feedback implements Serializable
{
    int ratingOverall, ratingFood, ratingAccomodation, ratingVolunteer,
            ratingOrganisation, ratingRecommend, ratingApp;

    String textExtra;


    public Feedback()
    {
        ratingAccomodation = ratingOverall = ratingVolunteer = ratingOrganisation = ratingRecommend = ratingFood = ratingApp =0;
        textExtra = "NA";
    }

    public Feedback(int ratingOverall, int ratingFood, int ratingAccomodation,
                    int ratingApp, int ratingOrganisation, int ratingVolunteer,
                    int ratingRecommend, String textExtra)
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

    public int getRatingOverall() {
        return ratingOverall;
    }

    public void setRatingOverall(int ratingOverall) {
        this.ratingOverall = ratingOverall;
    }

    public int getRatingAccomodation() {
        return ratingAccomodation;
    }

    public void setRatingAccomodation(int ratingAccomodation) {
        this.ratingAccomodation = ratingAccomodation;
    }

    public int getRatingFood() {
        return ratingFood;
    }

    public void setRatingFood(int ratingFood) {
        this.ratingFood = ratingFood;
    }

    public int getRatingVolunteer() {
        return ratingVolunteer;
    }

    public void setRatingVolunteer(int ratingVolunteer) {
        this.ratingVolunteer = ratingVolunteer;
    }

    public int getRatingOrganisation() {
        return ratingOrganisation;
    }

    public void setRatingOrganisation(int ratingOrganisation) {
        this.ratingOrganisation = ratingOrganisation;
    }

    public int getRatingRecommend() {
        return ratingRecommend;
    }

    public void setRatingRecommend(int ratingRecommend) {
        this.ratingRecommend = ratingRecommend;
    }

    public int getRatingApp() {
        return ratingApp;
    }

    public void setRatingApp(int ratingApp) {
        this.ratingApp = ratingApp;
    }

    public String getTextExtra() {
        return textExtra;
    }

    public void setTextExtra(String textExtra) {
        this.textExtra = textExtra;
    }
}
