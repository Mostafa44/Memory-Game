package com.example.android.memorygame;

import android.view.View;
import android.widget.ImageView;

/**
 * Created by Mostafa on 3/10/2018.
 */

public class Card {

    public View.OnClickListener  ClickListener;
    public int ImageViewId;
    public int OpenImageResourceId;
    public  boolean IsOpen;
    public  boolean IsFinished;
    public  Card(int imgResourceId, int imageViewResourceId)
    {
        OpenImageResourceId= imgResourceId;
        ImageViewId= imageViewResourceId;
        IsOpen= false;
        IsFinished= false;
    }

    public  void SetIsOpen(boolean isOpen)
    {
        IsOpen= isOpen;
    }
    public  void SetImageViewResourceId(int id)
    {
        ImageViewId = id;
    }
    public  void SetOpenImageResourceId(int id)
    {
        OpenImageResourceId = id;
    }
}
