package ci.leon.projetuvci3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText mNameInput;
    private EditText mPoidsInput;
    private EditText mTailleInput;
    private EditText mAgeInput;
    private Button mCalculerButton;
    private TextView mResultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNameInput = findViewById(R.id.activity_main_name_input);
        mPoidsInput = findViewById(R.id.activity_main_poids_input);
        mTailleInput = findViewById(R.id.activity_main_taille_input);
        mAgeInput = findViewById(R.id.activity_main_age_input);
        mCalculerButton = findViewById(R.id.activity_main_calculer_button);
        mResultText = findViewById(R.id.activity_main_result_text);

        mCalculerButton.setEnabled(false);

        mPoidsInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                enableCalculerButton();
            }
        });

        mTailleInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                enableCalculerButton();
            }
        });

        mAgeInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }



            @Override
            public void afterTextChanged(Editable s) {
                enableCalculerButton();
            }
        });

        mCalculerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateIMC();
            }
        });
    }

    private void enableCalculerButton() {
        boolean isNotEmpty = !mPoidsInput.getText().toString().isEmpty() &&
                !mTailleInput.getText().toString().isEmpty() &&
                !mAgeInput.getText().toString().isEmpty();
        mCalculerButton.setEnabled(isNotEmpty);
    }

    private void calculateIMC() {
        // Récupérez les valeurs entrées par l'utilisateur
        double poids = Double.parseDouble(mPoidsInput.getText().toString());
        double taille = Double.parseDouble(mTailleInput.getText().toString());
        int age = Integer.parseInt(mAgeInput.getText().toString());

        // Calculez l'IMC (utilisez la formule appropriée)
        double imc = poids / (taille * taille);

        // Affichez le résultat dans le TextView
        mResultText.setText("Votre IMC est : " + imc);

        // Créez un Intent pour passer les données à SecondActivity
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        intent.putExtra("IMC", imc);

        // Lancer la nouvelle activité
        startActivity(intent);
    }


}
