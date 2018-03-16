package com.example.android.memorygame;

import android.content.Context;
import android.os.CountDownTimer;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

import static java.security.AccessController.getContext;

/**
 * Created by Mostafa on 3/10/2018.
 */

public class CardResultsManager {
    private ArrayList<CardClick> mCurrentlyOpenCards;
    private int mCurrentlyOpenCardsCounter;
    private CountDownTimer mTimer;
    private Context mContext;
    public ArrayList<CardClick> ClickableCardsToObserve;
    public  CardResultsManager(Context context)
    {
        mContext= context;
        ClickableCardsToObserve= new ArrayList<CardClick>();
        mCurrentlyOpenCards= new ArrayList<CardClick>();
        mCurrentlyOpenCardsCounter =0;
        mTimer= new CountDownTimer(4000, 1000) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                for (CardClick c:ClickableCardsToObserve) {
                    c.DisableClick();
                }
            }
        };
    }

    public void AddToCard(CardClick c)
    {
        ClickableCardsToObserve.add(c);
    }

    public void Update(CardClick c)
    {
        mCurrentlyOpenCards.add(c);
        mCurrentlyOpenCardsCounter++;
        if (mCurrentlyOpenCardsCounter == 2)
        {
            //DisableAllCards();
            if (EvaluateCurrentlyOpenCards() )
            {
                SetOpenCardsFinishedState();
                mCurrentlyOpenCards.clear();
                mCurrentlyOpenCardsCounter=0;
                Toast.makeText(mContext, "Good Job !", Toast.LENGTH_SHORT).show();
            }
            else
            {
                for (CardClick clickableCard: mCurrentlyOpenCards) {
                    clickableCard.SetImageViewToClosedCard();
                }
                mCurrentlyOpenCards.clear();
                mCurrentlyOpenCardsCounter=0;
                Toast.makeText(mContext, "Memorize More !", Toast.LENGTH_SHORT).show();
            }
           // EnableCardsForNonFinished();
        }
    }
    
    private  boolean EvaluateCurrentlyOpenCards()
    {
        return  mCurrentlyOpenCards.get(0).CardInstance.OpenImageResourceId == mCurrentlyOpenCards.get(1).CardInstance.OpenImageResourceId;
    }
    private  void SetOpenCardsFinishedState()
    {
        for (CardClick c: mCurrentlyOpenCards) {
            c.CardInstance.IsFinished= true;
            c.DisableClick();
        }
    }

    public   void DisableAllCards()
    {
        for (CardClick c:ClickableCardsToObserve) {
            c.DisableClick();
        }
    }
    public void EnableCardsForNonFinished()
    {
      //  ClickableCardsToObserve.stream()
        //        .filter(c -> !c.CardInstance.IsFinished)
          //      .forEach(c -> c.EnableClick());
        for (CardClick c:ClickableCardsToObserve) {
            if (c.CardInstance.IsFinished == false)
            {
                c.EnableClick();
            }

        }
    }

}
