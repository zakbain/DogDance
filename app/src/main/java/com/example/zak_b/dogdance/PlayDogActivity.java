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

    private void petDog() {
        andy.process(new Thought("Pet " + petCount));

//        happiness += 0.1 * (1.0 - happiness);
//        certainty += 0.1 * (1.0 - certainty);

//        int currProg = happyProgress.getProgress();
//        currProg += 20;
        happyProgress.setProgress(currProg);
    }

    private void scoldDog() {
        andy.process(new Thought("Pet " + scoldCount));

//        happiness -= 0.1 * (happiness);
//        certainty -= 0.1 * (certainty);


        int currProg = certainProgress.getProgress();
        currProg += 20;
        this.certainProgress.setProgress(currProg);
    }
}
