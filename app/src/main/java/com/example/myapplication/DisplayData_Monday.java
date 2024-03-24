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

        // 定义画笔
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.LTGRAY);
        paint.setStyle(Paint.Style.FILL);

        Data[] dataArray = Geturl.getContent(("https://studev.groept.be/api/a23ib2c03/SelectPeopleWeek/"+Weekday+"/"+Weekday));

        for(int i=0;i<dataArray.length;i++)
        {
            dataPoints.add(Float.valueOf(dataArray[i].getPeople()));
        }
        // 数据点和柱状图的宽度


        float startX = 125; // X 轴上的起始点
        float startY = getHeight()-50 ; // Y 轴上的起始点
        Log.d("Height of view",String.valueOf(getHeight()));

        float maxY = getMaxValue(dataPoints); // 假设这是你已经定义好的获取最大值的方法
        int labelCount = 5; // 你希望在Y轴上显示的标签数量
        int yStep = (int)(getHeight() - 100) / labelCount; // 每个标签在Y轴上的间距（像素）

        Paint axisPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        axisPaint.setColor(Color.BLACK); // 设置轴和文本的颜色
        axisPaint.setTextSize(37); // 设置文本的大小
        axisPaint.setTextAlign(Paint.Align.RIGHT); // 设置文本的对齐方式，确保文本在Y轴的左侧正确对齐


        paint.setStrokeWidth(20);
        canvas.drawLine(startX-25, startY, startX-25, 0, paint); // Y 轴
        canvas.drawLine(startX-25, startY, getWidth(), startY, paint); // X 轴



        Paint textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        textPaint.setColor(Color.BLACK); // 文本颜色
        textPaint.setTextSize(30); // 文本大小
        textPaint.setTextAlign(Paint.Align.CENTER); // 文本对齐方式

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
            startX += barWidth+15; // 更新柱状图的起始点
        }

        for (int i = 0; i <= labelCount; i++) {
            int yValue = (int)maxY / labelCount * i; // 计算每个标签对应的数据值
            float yPos = startY - (yStep * i); // 计算每个标签在画布上的位置
            canvas.drawText(String.format("%d", yValue), 90, yPos + axisPaint.getTextSize()/3, axisPaint); // 绘制文本
            // 注意: 文本的Y坐标需要根据文本的大小进行适当调整，这里加上 textSize/3 是为了让文本更加居中显示
        }
    }
}