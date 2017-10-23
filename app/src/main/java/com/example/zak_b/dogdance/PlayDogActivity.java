package com.example.zak_b.dogdance;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.blackprince.agents.Agent;
import com.blackprince.agents.PetAgent;

import consciousness.Thought;

public class PlayDogActivity extends AppCompatActivity {

    private PetAgent andy;
    private double happiness = 0;
    private double certainty = 0;

    private int petCount;
    private int scoldCount;

    private ProgressBar happyProgress;
    private ProgressBar certainProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_dog);

        buildADog();
        getHappyBar();
        getCertainBar();
        coordinatePetBtn();
        coordinateScoldBtn();
    }

    private void buildADog() {
        String brainLog = "brainLog.log";
        String heartLog = "heartLog.log";

        this.andy = new PetAgent(0, heartLog, brainLog);
    }

    private void getHappyBar() {
        happyProgress = (ProgressBar) findViewById(R.id.happyProgressBar);
    }

    private void getCertainBar() {
        certainProgress = (ProgressBar) findViewById(R.id.certainProgressBar);
    }

    private void coordinateScoldBtn() {
        Button scold = (Button) findViewById(R.id.scoldButton);

        scold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scoldDog();
            }
        });
    }

    private void coordinatePetBtn() {
        Button pet = (Button) findViewById(R.id.petButton);
        pet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                petDog();
            }
        });
    }

    private void updateProgressBars() {
        int happyProg = happyProgress.getProgress();
        int certProg = certainProgress.getProgress();

        happyProg = (int) (andy.getHeart().getEmotions().get(0).getDegree() * 100);
        certProg = (int) (andy.getHeart().getEmotions().get(1).getDegree() * 100);
        happyProgress.setProgress(happyProg);
        certainProgress.setProgress(certProg);
    }

    private void petDog() {
        andy.process(new Thought("Pet " + petCount));
        petCount++;

        updateProgressBars();

//        happiness += 0.1 * (1.0 - happiness);
//        certainty += 0.1 * (1.0 - certainty);

    }

    private void scoldDog() {
        andy.process(new Thought("Scold " + scoldCount));
        scoldCount++;

        updateProgressBars();
//        happiness -= 0.1 * (happiness);
//        certainty -= 0.1 * (certainty);
    }
}
