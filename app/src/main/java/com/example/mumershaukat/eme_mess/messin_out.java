package com.example.mumershaukat.eme_mess;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;


import com.example.mumershaukat.eme_mess.BackgroundWorker;
import com.example.mumershaukat.eme_mess.R;

import java.util.Calendar;

public class messin_out extends AppCompatActivity {
    Button btn, btn1;
    int year_x, month_x, day_x, year_x1, month_x1, day_x1;
    int button_flag=-1;
    AlertDialog alertDialogm;
    String From="";
    String To="";
    static final int DIALOG_ID = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("MESS OUT");
        setContentView(R.layout.activity_messin_out);
        final Calendar cal = Calendar.getInstance();
        final Calendar cal1 = Calendar.getInstance();
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
        btn = (Button) findViewById(R.id.button);


        btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        button_flag=0;
                        showDialog(DIALOG_ID);
                    }
                }
        );
    }


    public void showDialogonbutton1() {
        btn1 = (Button) findViewById(R.id.button2);

        btn1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        button_flag=1;
                        showDialog(DIALOG_ID);
                    }
                }
        );
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        if (id == DIALOG_ID) {
            DatePickerDialog datepk;
            datepk = new DatePickerDialog(this, dpickerListner, year_x, month_x, day_x);
            datepk.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
            return datepk;
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
            if( button_flag!=-1) {
                if (button_flag == 0) {
                    From = y + "-0" + m + "-" + d;
                } else if (button_flag == 1) {
                    To = y + "-0" + m + "-" + d;
                }
            }
            else {
                alertDialogm.setMessage("Enter Your Date");
                alertDialogm.show();
            }

            Toast.makeText(messin_out.this, year_x + "/" + month_x + "/" + day_x, Toast.LENGTH_LONG).show();

        }


    };



    public void OnLogin(View view) {


        String type = "messin_out";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);

        backgroundWorker.execute(type, From, To);
    }

}

//2nd BUtton
