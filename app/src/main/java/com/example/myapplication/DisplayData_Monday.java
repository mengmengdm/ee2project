package com.example.myapplication;

import static android.content.Intent.getIntent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

public class DisplayData_Monday extends View {
    private String Weekday = " ";
    public DisplayData_Monday(Context con) {
        super(con);
    }

    public DisplayData_Monday(Context context, AttributeSet attrs)
    {
        super(context,attrs);
    }

    public DisplayData_Monday (Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
    }

    public float getMaxValue(ArrayList<Float> dataPoints)
    {
        float max_Value = 0;
        float curr_Value;
        Iterator<Float> it = dataPoints.iterator();
        while(it.hasNext())
        {
            curr_Value = it.next();
            if(curr_Value>=max_Value)
            {
                max_Value = curr_Value;
            }
        }
        return max_Value;
    }

    public void setWeek(String week)
    {
        this.Weekday = week;
    }


    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        ArrayList<Float> dataPoints = new ArrayList<>();

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.LTGRAY);
        paint.setStyle(Paint.Style.FILL);

        Data[] dataArray = Geturl.getContent(("https://studev.groept.be/api/a23ib2c03/SelectPeopleWeek/"+Weekday+"/"+Weekday));

        for(int i=0;i<dataArray.length;i++)
        {
            dataPoints.add(Float.valueOf(dataArray[i].getPeople()));
        }


        float startX = 125;
        float startY = getHeight()-50 ;
        Log.d("Height of view",String.valueOf(getHeight()));

        float maxY = getMaxValue(dataPoints);
        int labelCount = 5;
        int yStep = (int)(getHeight() - 100) / labelCount;

        Paint axisPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        axisPaint.setColor(Color.BLACK);
        axisPaint.setTextSize(37);
        axisPaint.setTextAlign(Paint.Align.RIGHT);


        paint.setStrokeWidth(20);
        canvas.drawLine(startX-25, startY, startX-25, 0, paint);
        canvas.drawLine(startX-25, startY, getWidth(), startY, paint);



        Paint textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        textPaint.setColor(Color.BLACK);
        textPaint.setTextSize(30);
        textPaint.setTextAlign(Paint.Align.CENTER);

        paint.setColor(Color.RED);
        float barWidth = (getWidth() - 200) / (dataPoints.size()+15);
        float maxValue = getMaxValue(dataPoints);
        for (int i = 0; i < dataPoints.size(); i++) {
            float barHeight = (float) dataPoints.get(i) / maxValue * (getHeight() - 100);
            canvas.drawRect(startX-0, startY - barHeight, startX + barWidth, startY-7, paint);
            if(i%4==0)
            {
                canvas.drawText(dataArray[i].getTime().substring(0,4) + (i+1), startX + barWidth / 2, startY + 30, textPaint);
            }
            startX += barWidth+15;
        }

        for (int i = 0; i <= labelCount; i++) {
            int yValue = (int)maxY / labelCount * i;
            float yPos = startY - (yStep * i);
            canvas.drawText(String.format("%d", yValue), 90, yPos + axisPaint.getTextSize()/3, axisPaint);
        }
    }
}