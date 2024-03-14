package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Arrays;

public class DisplayData_Monday extends View {

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

    public float getMaxValue(float[] dataPoints)
    {
        float max_Value;
        Arrays.sort(dataPoints);
        max_Value = dataPoints[dataPoints.length-1];
        return max_Value;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 定义画笔
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.LTGRAY); // 设置画笔颜色为蓝色
        paint.setStyle(Paint.Style.FILL); // 设置绘制模式为填充

        // 数据点和柱状图的宽度
        float[] dataPoints = {100, 200, 150, 250,500}; // 假设的数据点

        paint.setStrokeWidth(20);
        canvas.drawLine(100, getHeight()-100, 100, 100, paint); // Y 轴
        canvas.drawLine(100, getHeight() - 100, getWidth(), getHeight() - 100, paint); // X 轴

        float startX = 150; // X 轴上的起始点
        float startY = getHeight() - 100; // Y 轴上的起始点


        paint.setColor(Color.RED);
        float barWidth = (getWidth() - 200) / (dataPoints.length+10);
        float maxValue = getMaxValue(dataPoints);
        for (int i = 0; i < dataPoints.length; i++) {
            float barHeight = (float) dataPoints[i] / maxValue * (getHeight() - 100);
            canvas.drawRect(startX, startY - barHeight, startX + barWidth, startY, paint);
            startX += barWidth+10; // 更新柱状图的起始点
        }
    }
}