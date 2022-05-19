package sg.edu.rp.c346.id21000243.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etName;
    EditText etNumber;
    EditText etPax;
    DatePicker dp;
    TimePicker tp;
    RadioGroup rgSmoke;
    RadioButton rbSmoke;
    RadioButton rbNoSmoke;
    Button btnConfirm;
    Button btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.editTextName);
        etNumber = findViewById(R.id.editTextNumber);
        etPax = findViewById(R.id.editTextPax);
        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        rgSmoke = findViewById(R.id.radioGroupPosition);
        rbSmoke = findViewById(R.id.radioButtonSmoke);
        rbNoSmoke = findViewById(R.id.radioButtonNonSmoke);
        btnConfirm = findViewById(R.id.buttonConfirm);
        btnReset = findViewById(R.id.buttonReset);

        tp.setCurrentHour(19);
        tp.setCurrentMinute(30);
        dp.updateDate(2020,5,1);

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("MyActivity", "Inside onClick()");
                String stringSentence = "Full Name: "+ etName;
                stringSentence += "Phone Number: " + etNumber;
                stringSentence += "Pax: " +etPax;
                stringSentence += "Reservation for " + "Date is " + dp.getDayOfMonth() + "/" + dp.getMonth() + "/" + dp.getYear();
                stringSentence += "@" + tp.getCurrentHour().toString() +tp.getCurrentMinute().toString();
                Toast.makeText(getApplicationContext(),stringSentence,Toast.LENGTH_LONG).show();
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tp.setCurrentHour(19);
                tp.setCurrentMinute(30);
                dp.updateDate(2020, 5, 1);
                etName.setText("");
                etNumber.setText("");
                etPax.setText("");
                rbNoSmoke.setChecked(false);
                rbSmoke.setChecked(false);
            }
        });

    }
}