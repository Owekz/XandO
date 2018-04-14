package com.example.owekz.xando;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.owekz.xando.game;

public class NameDialog extends Dialog {

    String name;
    game parent;

    String get_name() {
        return name;
    }

    public NameDialog(Context context, final game.Outcome out, final int player_number, final String prev_name, int np) {
        super(context);
        this.setContentView(R.layout.name_dialog);
        final NameDialog me = this;
        parent = (game) context;

		/* can't get around it */
        setCancelable(false);

		/* get our controls */
        final EditText entry = findViewById(R.id.EditText01);
        final Button button = findViewById(R.id.Button01);
        final TextView heading = findViewById(R.id.TextView01);

		/* clear the text */
        entry.setText("");

		/* set up name we're looking for */
        String h = new String();

        if (player_number == 1) {
            if (out == game.Outcome.P1_WON) h = "Player 1 (Winner)";
            else if (out == game.Outcome.CAT) h = "Player 1";
            else h = "Player 1 (Loser)";
        } else {
            if (out == game.Outcome.P1_WON) h = "Player 2 (Loser)";
            else if (out == game.Outcome.CAT) h = "Player 2";
            else h = "Player 2 (Winner)";
        }


        if (np == 1) h = "Player";

        heading.setText(h + " Please Enter Your Name:");

        button.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                name = entry.getText().toString();

            	/* do the callback */
                if (player_number == 1) {
                    parent.finishGame(out, player_number + 1, name, "");
                } else {
                    parent.finishGame(out, player_number + 1, prev_name, name);
                }
                me.dismiss();
            }
        });

    }
}

