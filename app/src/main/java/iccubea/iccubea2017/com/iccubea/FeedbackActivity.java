package iccubea.iccubea2017.com.iccubea;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class FeedbackActivity extends AppCompatActivity {

    RatingBar ratingBarFeedbackOverall, ratingBarFeedbackFood, ratingBarFeedbackAccomodation,
              ratingBarFeedbackVolunteer, ratingBarFeedbackOrganisation, ratingBarFeedbackRecommend, ratingBarFeedbackApp;

    EditText editTextFeedbackExtra;
    Button buttonFeedbackSubmit;

    int ratingFeedbackOverall, ratingFeedbackFood, ratingFeedbackAccomodation, ratingFeedbackVolunteer,
        ratingFeedbackOrganisation, ratingFeedbackRecommend, ratingFeedbackApp;

    String textFeedbackExtra;

    FirebaseDatabase firebaseDatabase;// = FirebaseDatabase.getInstance();
    DatabaseReference databaseReference;// = firebaseDatabase.getReference().child("feedback");





    Feedback feedback;
    boolean hasSubmittedFeedback;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference().child("feedback");

        ratingBarFeedbackAccomodation = (RatingBar) findViewById(R.id.ratingBarFeedbackAccomodation);
        ratingBarFeedbackApp = (RatingBar) findViewById(R.id.ratingBarFeedbackApp);
        ratingBarFeedbackFood = (RatingBar) findViewById(R.id.ratingBarFeedbackFood);
        ratingBarFeedbackOrganisation = (RatingBar) findViewById(R.id.ratingBarFeedbackOrganisation);
        ratingBarFeedbackOverall = (RatingBar) findViewById(R.id.ratingBarFeedbackOverall);
        ratingBarFeedbackRecommend = (RatingBar) findViewById(R.id.ratingBarFeedbackRecommend);
        ratingBarFeedbackVolunteer = (RatingBar) findViewById(R.id.ratingBarFeedbackVolunteer);


        editTextFeedbackExtra = (EditText) findViewById(R.id.editTextFeedbackExtra);

        buttonFeedbackSubmit = (Button) findViewById(R.id.buttonFeedbackSubmit);

        feedback.setRatingAccomodation(ratingBarFeedbackAccomodation.getNumStars());
        feedback.setRatingApp(ratingBarFeedbackApp.getNumStars());
        feedback.setRatingFood(ratingBarFeedbackFood.getNumStars());
        feedback.setRatingOrganisation(ratingBarFeedbackOrganisation.getNumStars());
        feedback.setRatingOverall(ratingBarFeedbackOverall.getNumStars());
        feedback.setRatingRecommend(ratingBarFeedbackRecommend.getNumStars());
        feedback.setRatingVolunteer(ratingBarFeedbackVolunteer.getNumStars());
        feedback.setTextExtra(editTextFeedbackExtra.getText().toString());


       /* ratingFeedbackApp = ratingBarFeedbackApp.getNumStars();
        ratingFeedbackAccomodation = ratingBarFeedbackAccomodation.getNumStars();
        ratingFeedbackFood = ratingBarFeedbackFood.getNumStars();
        ratingFeedbackOrganisation = ratingBarFeedbackOrganisation.getNumStars();
        ratingFeedbackOverall = ratingBarFeedbackOverall.getNumStars();
        ratingFeedbackRecommend = ratingBarFeedbackRecommend.getNumStars();
        ratingFeedbackVolunteer = ratingBarFeedbackVolunteer.getNumStars();

           textFeedbackExtra = editTextFeedbackExtra.getText().toString(); */
        databaseReference.push().setValue(feedback);
        buttonFeedbackSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                    databaseReference.push().setValue(feedback);
            }
        });


    }
}
