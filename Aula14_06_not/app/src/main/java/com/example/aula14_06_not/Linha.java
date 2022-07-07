package com.example.aula14_06_not;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public class Linha extends View {

        private final float left;
        private final float right;
        private final float top;
        private final float bottom;
        private final Paint mPaint;

        public Linha(Context context, float left, float top, float bottom, float right, int color) {
            super(context);
            this.left = left;
            this.right = right;
            this.top = top;
            this.bottom = bottom;
            mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

            //define a cor base
            mPaint.setColor(color); //cor
            mPaint.setStrokeWidth(25f);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            canvas.drawLine(left, top, bottom, right, mPaint);
        }

    }

