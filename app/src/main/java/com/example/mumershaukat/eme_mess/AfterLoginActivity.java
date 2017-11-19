package com.example.mumershaukat.eme_mess;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class AfterLoginActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    int s1,s2,s3,m1,m2,m3,h1,h2,h3;
    TextView tax1;
    final String TAG= this.getClass().getName();

    boolean twice;
    @Override
    public void onBackPressed() {

        // super.onBackPressed();
        Log.d(TAG,"click");

        if(twice==true){

            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
            System.exit(0);

        }
        twice=true;
        Log.d(TAG,"twice: " + twice);

        Toast.makeText(this,"Please press BACK again to exit", Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                twice=false;
                Log.d(TAG,"twice: " + twice);
            }
        },3000);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Home");
        show_remaining();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.after_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

           String type="logout";
            BackgroundWorker backgroundWorker = new BackgroundWorker(this);

            backgroundWorker.execute(type,null,null);
            Intent j = new Intent(AfterLoginActivity.this,MyLoginActivity.class);
           j.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(j);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.Mess_Out) {
            Intent i = new Intent(AfterLoginActivity.this, messin_out.class);
            startActivity(i);
            item.setChecked(true);
        } else if (id == R.id.Mess_In) {

            Intent i = new Intent(AfterLoginActivity.this, Mess_Out.class);
            startActivity(i);
            item.setChecked(true);
        } else if (id == R.id.Previous_Record) {
            Intent i = new Intent(AfterLoginActivity.this,Previous_rec_button.class);
            startActivity(i);
            item.setChecked(true);

        } else if (id == R.id.Home) {
            //booked
        } else if (id == R.id.per_day) {

            String type="bill";

            BackgroundWorker backgroundWorker = new BackgroundWorker(this);

            backgroundWorker.execute(type,null,null);

        } else if (id == R.id.total) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void breakfast()
    {
        CountDownTimer newtimer=new CountDownTimer(10000000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                Calendar cal = Calendar.getInstance();
                int ss = cal.get(Calendar.SECOND);
                int mm = cal.get(Calendar.MINUTE);
                //24 hour format
                // int hh= cal.get(Calendar.HOUR);
                int hh = cal.get(Calendar.HOUR_OF_DAY);
                int c_h=9;
                int c_m=60;
                int c_s=60;
                s1=c_s-ss;
                m1=c_m-mm;
                h1=c_h-hh-1;
                if(mm==0)
                {
                    m1=59;
                }
                if(h1<0)

                {

                    h1 = (c_h+23)-hh;
                }
                if(s1<0)
                {
                    s1=-1*ss;
                }
                if(ss==0)
                {
                    s1=59;
                }

                int textView;
                textView = R.id.textView;
                tax1=(TextView)

                        findViewById(textView);
                tax1.setText(String.format("%d:%d:%d",h1,m1,s1));
            }
            public void onFinish () {

            }
        };
        newtimer.start();



    }

    public void lunch()
    {
        CountDownTimer newtimer=new CountDownTimer(10000000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                Calendar cal = Calendar.getInstance();
                int ss = cal.get(Calendar.SECOND);
                int mm = cal.get(Calendar.MINUTE);
                //24 hour format
                // int hh= cal.get(Calendar.HOUR);
                int hh = cal.get(Calendar.HOUR_OF_DAY);
                int c_h=14;
                int c_m=30;
                int c_s=60;
                s2=c_s-ss;
                m2=30-mm;
                h2=c_h-hh;
                if(m2<0)
                {
                    m2=60+m2;
                }
                if(mm==0)
                {
                    m2=59;
                }
                if(s2<0)
                {
                    s2=-1*s2;
                }
                if(s2>=59)
                {
                    s2=59;
                }

                int textView;
                textView = R.id.textView;
                tax1=(TextView)

                        findViewById(textView);
                tax1.setText(String.format("%d:%d:%d",h2,m2,s2));
            }
            public void onFinish () {

            }
        };
        newtimer.start();

    }

    public void dinner()
    {
        CountDownTimer newtimer=new CountDownTimer(10000000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                Calendar cal = Calendar.getInstance();
                int ss = cal.get(Calendar.SECOND);
                int mm = cal.get(Calendar.MINUTE);
                //24 hour format
                //  int hh= cal.get(Calendar.HOUR);
                int hh = cal.get(Calendar.HOUR_OF_DAY);
                int c_h=21;
                int c_m=0;
                int c_s=0;
                s3=60-ss;
                m3=60-mm;
                h3=c_h-hh;
                if(mm==0) {
                    m3 = 59;
                }
                if(ss>=59)
                {
                    s3=59;
                }

                if(s3<0)
                {
                    s3=-1*s3;
                }

                tax1=(TextView)

                        findViewById(R.id.textView);
                tax1.setText(String.format("%d:%d:%d",h3,m3,s3));
            }
            public void onFinish () {

            }
        };
        newtimer.start();

    }
    public void show_remaining()
    {
        TextView tax= (TextView)findViewById(R.id.textView2);
        Calendar cal = Calendar.getInstance();
        int ss = cal.get(Calendar.SECOND);
        int mm = cal.get(Calendar.MINUTE);
        int hh = cal.get(Calendar.HOUR_OF_DAY);
        if(hh>=9&&hh<=14)
        {

            tax.setText("Remaining Lunch Time.");
            lunch();

        }
        else if(hh>=14&&hh<=21)

        {
            tax.setText("Remaining Dinner Time.");

            dinner();

        }
        else
        {

            tax.setText("Remaining BreakFast Time.");
            breakfast();

        }

    }
}
