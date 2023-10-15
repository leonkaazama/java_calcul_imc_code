package ci.leon.projetuvci3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView mIMCText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        setContentView(R.layout.activity_second);

        mIMCText = findViewById(R.id.activity_second_imc_text);


        Intent intent = getIntent();
        if (intent != null) {
            double imc = intent.getDoubleExtra("IMC",0.0);

            mIMCText.setText("Votre IMC est : "+imc);
        }
    }
}