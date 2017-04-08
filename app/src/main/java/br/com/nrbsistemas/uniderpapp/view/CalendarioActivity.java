package br.com.nrbsistemas.uniderpapp.view;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;

import br.com.nrbsistemas.uniderpapp.R;

public class CalendarioActivity extends AppCompatActivity {

    private int dia, mes, ano,horas,minutos;
    private CalendarView calendario;
    private Button btnHorario, btnCalendario;
    private TextView txtCal;
    private ListView listaCalendario;
    Calendar dataTime = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendario);

        calendario = (CalendarView) findViewById(R.id.calendar_calendario);
        btnHorario = (Button) findViewById(R.id.btn_horario);
        btnCalendario = (Button) findViewById(R.id.btn_calendario);
        txtCal = (TextView) findViewById(R.id.txt_calendario);
        listaCalendario = (ListView) findViewById(R.id.lista_calendario);

        btnCalendario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                criarEvento();
                Toast.makeText(getApplicationContext(),"Enveto criado para "+dia+"/+"+mes,Toast.LENGTH_SHORT).show();
            }
        });

        btnHorario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                criarHorario();
                Toast.makeText(getApplicationContext(),"Enveto criado para "+hora+"min "+minutos,Toast.LENGTH_SHORT).show();

            }
        });


    }

    private void criarHorario() {
        new TimePickerDialog(this,hora,dataTime.get(Calendar.HOUR_OF_DAY),dataTime.get(Calendar.MINUTE),true).show();
    }


    private void criarEvento() {
        new DatePickerDialog(this, data, dataTime.get(Calendar.YEAR),
                dataTime.get(Calendar.MONTH),
                dataTime.get(Calendar.DAY_OF_MONTH))
                .show();
    }

    TimePickerDialog.OnTimeSetListener hora = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            dataTime.set(Calendar.HOUR_OF_DAY,horas);
            dataTime.set(Calendar.MINUTE,minutos);

            hora.onTimeSet(view,horas,minutos);
        }
    };


    DatePickerDialog.OnDateSetListener data = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            dataTime.set(Calendar.YEAR, ano);
            dataTime.set(Calendar.MONTH,mes);
            dataTime.set(Calendar.DAY_OF_MONTH,dia);
        }
    };



}
