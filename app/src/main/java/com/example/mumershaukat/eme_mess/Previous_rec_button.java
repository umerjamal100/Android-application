package com.example.mumershaukat.eme_mess;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;

public class Previous_rec_button extends AppCompatActivity {

    Button btn, btn1;
    int year_x, month_x, day_x, year_x1, month_x1, day_x1,button_flag;
    String From="";
            String To="";
    int a;
    static final int DIALOG_ID = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_previous_rec_button);
        getSupportActionBar().hide();
        final Calendar cal = Calendar.getInstance();
        year_x = cal.get(Calendar.YEAR);
        month_x = cal.get(Calendar.MONTH);
        day_x = cal.get(Calendar.DAY_OF_MONTH);

        year_x1 = cal.get(Calendar.YEAR);
        month_x1 = cal.get(Calendar.MONTH);
        day_x1 = cal.get(Calendar.DAY_OF_MONTH);
        showDialogonbutton();
        showDialogonbutton1();
    }

    public void showDialogonbutton() {
        btn = (Button) findViewById(R.id.To1);

        button_flag=0;
        btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        a=0;
                        showDialog(DIALOG_ID);
                    }
                }
        );
    }


    public void showDialogonbutton1() {
        btn1 = (Button) findViewById(R.id.From1);
        button_flag=1;

        btn1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        a=1;
                        showDialog(DIALOG_ID);
                    }
                }
        );
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        if (id == DIALOG_ID) {
            return new DatePickerDialog(this, dpickerListner, year_x, month_x, day_x);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener dpickerListner = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            year_x = year;
            month_x = month + 1;
            day_x = dayOfMonth;
            String y = Integer.toString(year_x);
            String m = Integer.toString(month_x);
            String d = Integer.toString(day_x);
            // int id=V.getId();

            if(a==0) {
                From = y + "-0" + m + "-" + d;
            }
            else if(a==1)
            {
                To = y + "-0" + m + "-" + d;
            }
            Toast.makeText(Previous_rec_button.this, year_x + "/" + month_x + "/" + day_x, Toast.LENGTH_LONG).show();

        }


    };

    public void OnLogin(View view) {


        String type = "previous_record";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);

        backgroundWorker.execute(type, From, To);
    }

}