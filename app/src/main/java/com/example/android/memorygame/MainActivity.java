package com.example.android.memorygame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    public  Integer[] imgsArray;
    public  Integer[] imageViewsArray;
    public  CardResultsManager cRM;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cRM= new CardResultsManager(MainActivity.this);

        imgsArray= InitializeImagesArray(imgsArray);
        imageViewsArray= InitializeImageViewsArray(imageViewsArray);
        Collections.shuffle(Arrays.asList(imgsArray));
        Collections.shuffle(Arrays.asList(imageViewsArray));
        ArrayList<Card> cards= new ArrayList<Card>();
        for (int i=0; i<12; i++)
        {
            Card c= new Card(imgsArray[i], imageViewsArray[i]);
            final ImageView imgView= (ImageView) findViewById(imageViewsArray[i]);
            final int img= imgsArray[i];
            imgView.setOnClickListener( new CardClick(cRM, c, imgView));
            cards.add(c);
        }
    }

    private Integer [] InitializeImagesArray(Integer[] arr)
    {
        arr= new Integer[12];
        arr[0]= R.drawable.ball_1;
        arr[1]= R.drawable.bird_1;
        arr[2]= R.drawable.cup_1;
        arr[3]= R.drawable.car_1;
        arr[4]= R.drawable.star_1;
        arr[5]= R.drawable.flower_1;
        arr[6]= R.drawable.ball_1;
        arr[7]= R.drawable.bird_1;
        arr[8]= R.drawable.cup_1;
        arr[9]= R.drawable.car_1;
        arr[10]= R.drawable.star_1;
        arr[11]= R.drawable.flower_1;
        return  arr;
    }


    private Integer [] InitializeImageViewsArray(Integer[] arr)
    {
        arr= new Integer[12];
        arr[0]= R.id.img1_1;
        arr[1]= R.id.img1_2;
        arr[2]= R.id.img1_3;
        arr[3]= R.id.img1_4;
        arr[4]= R.id.img2_1;
        arr[5]= R.id.img2_2;
        arr[6]= R.id.img2_3;
        arr[7]= R.id.img2_4;
        arr[8]=R.id.img3_1;;
        arr[9]= R.id.img3_2;
        arr[10]= R.id.img3_3;
        arr[11]= R.id.img3_4;
        return  arr;
    }

    public void OnReset(View view )
    {
        for (CardClick c: cRM.ClickableCardsToObserve) {
            c.CardInstance.IsFinished=false;
            c.CardInstance.IsOpen= false;
            c.EnableClick();
            c.ChangeCardToCloseImage();
        }
        Collections.shuffle(Arrays.asList(imgsArray));
        for (int i=0; i< 12; i++)
        {
            cRM.ClickableCardsToObserve.get(i).CardInstance.SetOpenImageResourceId(imgsArray[i]);
        }
    }
}
