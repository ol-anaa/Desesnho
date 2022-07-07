package com.example.aula14_06_not;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private FrameLayout main;
    private Button btnC;
    private Button btnQ;
    private Button btnL;
    private Button btnO;
    private Button btnDQ;
    private Button btnDC;
    private Button btnDL;
    private Button btnDO;
    private Button btnCor;
    private boolean clicked;
    private boolean clicked2;
    private boolean clicked3;
    private boolean clicked4;
    int mDefaultColor = 0xcF000000;
    private int qtd = 1 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnQ = (Button) findViewById(R.id.btn10); //limpa
        btnC = (Button) findViewById(R.id.btn20); //limpa circulo
        btnL = (Button) findViewById(R.id.btn30); //limpa Oval
        btnO = (Button) findViewById(R.id.btn40); //limpa Oval
        btnDQ = (Button) findViewById(R.id.btn2); //desenha
        btnDC = (Button) findViewById(R.id.btn); //desenha
        btnDL = (Button) findViewById(R.id.btn3); //desenha
        btnDO = (Button) findViewById(R.id.btn4); //desenha

        //obter o id da view
        main = (FrameLayout) findViewById(R.id.MainView);
        main.addView(new Bola(this,
                100,
                500,
                40, mDefaultColor));

        main.addView(new Quadrado(this,
                200, 200, 200, 200, mDefaultColor));

        main.addView(new Linha(this,
                200, 200, 200, 200, mDefaultColor));

        main.addView(new Oval(this,
                100, 10, 60, 100, mDefaultColor));


        btnQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = main.getChildCount(); i >= 0; i--) {
                    View vi = main.getChildAt(i);
                    if (vi instanceof Quadrado) {
                        main.removeViewAt(i);
                    }
                }
            }
        });

        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = main.getChildCount(); i >= 0; i--) {
                    View vi = main.getChildAt(i);
                    if (vi instanceof Bola) {
                        main.removeViewAt(i);
                    }
                }
            }
        });

        btnL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = main.getChildCount(); i >= 0; i--) {
                    View vi = main.getChildAt(i);
                    if (vi instanceof Linha) {
                        main.removeViewAt(i);
                    }
                }
            }
        });

        btnO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = main.getChildCount(); i >= 0; i--) {
                    View vi = main.getChildAt(i);
                    if (vi instanceof Oval) {
                        main.removeViewAt(i);
                    }
                }
            }
        });

        btnDC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicked = true;
                clicked2 = false;
            }
        });

        btnDQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicked2 = true;
                clicked = false;
            }
        });

        btnDL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicked3 = true;
                clicked2 = false;
                clicked = false;
            }
        });

        btnDO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicked4 = true;
                clicked3 = false;
                clicked2 = false;
                clicked = false;
            }
        });

        btnCor = (Button) findViewById(R.id.butCor);
        btnCor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qtd = qtd+1;
                if (qtd == 2) {
                    mDefaultColor = 0xFF00FFFF;
                }
                if (qtd == 3){
                    mDefaultColor = 0xFFFF7AAA;
                }
                if (qtd == 4){
                    mDefaultColor = 0xFF5bFAA0;
                }
                if (qtd == 5){
                    mDefaultColor = 0xffffd700;

                }
                if (qtd > 4){
                    qtd = 1;
                }
            }
        });


    }


    public boolean onTouchEvent(MotionEvent event) {
        if (clicked) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    main.addView(new Bola(this,
                            event.getX(),
                            event.getY(),
                            40, mDefaultColor));
                    return true;
                case MotionEvent.ACTION_MOVE:
                    return true;
            }
            return true;
        }


        if (clicked2) {
            Log.d("dd", String.format("%04f  %04f", event.getX(), event.getY()));
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    main.addView(new Quadrado(this,
                            (int) event.getX(), event.getY(), (int) event.getX() + 120, event.getY() + 120, mDefaultColor));
                    return true;
                case MotionEvent.ACTION_MOVE:
                    return true;
            }
            return true;
        }


        if (clicked3) {
            Log.d("dd", String.format("%04f  %04f", event.getX(), event.getY()));
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    main.addView(new Linha(this,
                            (int) event.getX(), event.getY() - 250, (int) event.getX() + 15, event.getY() + 60, mDefaultColor));
                    return true;
                case MotionEvent.ACTION_MOVE:
                    return true;
            }
            return true;
        }

        if (clicked4) {
            Log.d("dd", String.format("%04f  %04f", event.getX(), event.getY()));
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    main.addView(new Oval(this,
                            (int) event.getX() , event.getY() -250, (int) event.getX() + 350, event.getY() -350, mDefaultColor));
                    return true;
                case MotionEvent.ACTION_MOVE:
                    return true;
            }
            return true;
        }
        return false;
    }
}


