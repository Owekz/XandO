package com.example.owekz.xando;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class TicTacToe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

         /* get controls */
        final Button pvp = findViewById(R.id.pvp);
        final Button pvc = findViewById(R.id.pvc);
        final Button vs = findViewById(R.id.vs);
        final Button quit = findViewById(R.id.quit);

        /* so the listeners can access me */
        final TicTacToe me = this;

        /* quit control */
        quit.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                me.finish();
            }
        });

        /* player versus player control */
        pvp.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(me, game.class);
                i.setType("2");
                me.startActivity(i);
            }
        });

        /* player versus computer control */
        pvc.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(me, game.class);
                i.setType("1");
                me.startActivity(i);
            }
        });

        /* view high score control */
        vs.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(me, StatsView.class);
                i.setType("1");
                me.startActivity(i);
            }
        });
    }
}
