package com.example.android.memorygame;

import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by Mostafa on 3/10/2018.
 */

public class CardClick implements View.OnClickListener {

    public Card CardInstance;
    private ImageView mImageView;
    private  CountDownTimer mTimer;
    private  CardResultsManager mCardsResultManager;
    public  CardClick(CardResultsManager cardsResultManager, Card c, ImageView imgview)
    {
        CardInstance= c;
        //imgView = findViewById()
        mImageView= imgview;
        mTimer= new CountDownTimer(5000, 1000) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                mImageView.setImageResource(R.drawable.icons8_square_96);
                mCardsResultManager.EnableCardsForNonFinished();
            }
        };
        cardsResultManager.AddToCard(this);
        mCardsResultManager= cardsResultManager;
    }

    @Override
    public void onClick(View view) {
        mImageView.setImageResource(CardInstance.OpenImageResourceId);
        CardInstance.IsOpen= true;
       // Toast.makeText(view.getContext(),"The state of open is " + CardInstance.IsOpen , Toast.LENGTH_SHORT ).show();
      //  mTimer.start();
        mCardsResultManager.Update(this);
    }

    public  void DisableClick()
    {
      //  mImageView.setClickable(false);
        mImageView.setEnabled(false);
    }
    public  void EnableClick()
    {
       // mImageView.setClickable(true);
        mImageView.setEnabled(true);
    }
    public void SetImageViewToClosedCard()
    {
        //mImageView.setImageResource(R.drawable.icons8_square_96);
        mCardsResultManager.DisableAllCards();
        mTimer.start();
    }

    public  void ChangeCardToCloseImage()
    {
        mImageView.setImageResource(R.drawable.icons8_square_96);
    }

}
