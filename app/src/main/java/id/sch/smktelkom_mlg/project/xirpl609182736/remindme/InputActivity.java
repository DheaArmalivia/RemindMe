package id.sch.smktelkom_mlg.project.xirpl609182736.remindme;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import id.sch.smktelkom_mlg.project.xirpl609182736.remindme.model.Alarm;

public class InputActivity extends AppCompatActivity {


    EditText etJudul;
    EditText etDesk;
    Button bSave;
    TimePicker tpWaktu;
    DatePicker dpHari;
    Alarm alarm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        etJudul = (EditText) findViewById(R.id.editTextJudul);
        etDesk = (EditText) findViewById(R.id.editTextDes);
        tpWaktu = (TimePicker) findViewById(R.id.timePicker1);
        bSave = (Button) findViewById(R.id.buttonSave);
        dpHari = (DatePicker) findViewById(R.id.datePicker1);

        bSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doSave();
            }
        });

    }

    private void doSave() {
        String judul = etJudul.getText().toString();
        String desk = etDesk.getText().toString();
        String hari = dpHari.getContext().toString();
        String waktu = tpWaktu.getContext().toString();

        if (siValid(judul, desk)) {
            alarm = new Alarm(judul, desk, hari, waktu);
            Intent intent = new Intent();
            intent.putExtra(ALARM_SERVICE, alarm);
            setResult(RESULT_OK, intent);
            finish();
        }

    }

    private boolean siValid(String judul, String desk) {
        boolean valid = true;


        if (judul.isEmpty()) {
            etJudul.setError("Belum diisi");
            valid = false;
        }
        if (desk.isEmpty()) {
            etDesk.setError("Belum diisi");
            valid = false;
        }
        return valid;
    }

}
