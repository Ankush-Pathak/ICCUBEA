package iccubea.iccubea2017.com.iccubea;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

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


        feedback = new Feedback();
        editTextFeedbackExtra = (EditText) findViewById(R.id.editTextFeedbackExtra);

        buttonFeedbackSubmit = (Button) findViewById(R.id.buttonFeedbackSubmit);




        SharedPreferences sharedPre = FeedbackActivity.this.getSharedPreferences("sharedPref",Context.MODE_PRIVATE);
        boolean submittedFeedback = sharedPre.getBoolean("hasSubmittedFeedback",false);

        if(submittedFeedback)
        {
            Toast.makeText(FeedbackActivity.this,"You have already submitted the feedback.",Toast.LENGTH_LONG).show();
            Intent intent = new Intent(FeedbackActivity.this, MainActivity.class);
            startActivity(intent);
            finish();


        }


       /* ratingFeedbackApp = ratingBarFeedbackApp.getNumStars();
        ratingFeedbackAccomodation = ratingBarFeedbackAccomodation.getNumStars();
        ratingFeedbackFood = ratingBarFeedbackFood.getNumStars();
        ratingFeedbackOrganisation = ratingBarFeedbackOrganisation.getNumStars();
        ratingFeedbackOverall = ratingBarFeedbackOverall.getNumStars();
        ratingFeedbackRecommend = ratingBarFeedbackRecommend.getNumStars();
        ratingFeedbackVolunteer = ratingBarFeedbackVolunteer.getNumStars();

           textFeedbackExtra = editTextFeedbackExtra.getText().toString(); */

        buttonFeedbackSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {


                feedback.setRatingAccomodation(ratingBarFeedbackAccomodation.getRating());
                feedback.setRatingApp(ratingBarFeedbackApp.getRating());
                feedback.setRatingFood(ratingBarFeedbackFood.getRating());
                feedback.setRatingOrganisation(ratingBarFeedbackOrganisation.getRating());
                feedback.setRatingOverall(ratingBarFeedbackOverall.getRating());
                feedback.setRatingRecommend(ratingBarFeedbackRecommend.getRating());
                feedback.setRatingVolunteer(ratingBarFeedbackVolunteer.getRating());
                feedback.setTextExtra(editTextFeedbackExtra.getText().toString());




                    databaseReference.push().setValue(feedback);



                hasSubmittedFeedback = true;

                SharedPreferences sharedPreferences = FeedbackActivity.this.getSharedPreferences("sharedPref", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("hasSubmittedFeedback",hasSubmittedFeedback);
                editor.commit();
                Intent intent = new Intent(FeedbackActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });




    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(FeedbackActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }

}
