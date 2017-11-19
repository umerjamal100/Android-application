package com.example.mumershaukat.eme_mess;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;


public class BackgroundWorker extends AsyncTask<String, Void, String> {
    Context context;
    AlertDialog alertDialog;
    String type;

   Data user=Data.getInstance();
    String name=user.name;

    BackgroundWorker(Context ctx) {
        context = ctx;
    }


    @Override
    protected String doInBackground(String... params) {
        type = params[0];
        String logout_url = "http://192.168.43.98/logout.php";
        String in_url = "http://192.168.43.98/messin.php";
        String prev_url = "http://192.168.43.98/previousrecords.php";
        String reg_url = "http://192.168.43.98/messoutMysql.php";
        String login_url = "http://192.168.43.98/logindb.php";
        String bill_url = "http://192.168.43.98/messbills.php";
if(type.equals("login")){

    if(params[1].matches("")&&params[2].matches("")){

        String msg="Enter your Credentials";
        return msg;
    }
       else if (params[1].matches("") ) {
            // Toast.makeText(context, "Enter UserName", Toast.LENGTH_LONG).show();
            String msg="Enter username";
            return msg;
        } else if (params[2].matches("")) {
            //Toast.makeText(context, "Enter Password", Toast.LENGTH_LONG).show();
            String msg="Enter password";
            return msg;
        }}
        else if(type.equals("messin_out")){
if(params[1].matches("")&&params[2].matches("")){

    String msg="Select the DATE";
    return msg;
}
   else if (params[1].matches("") ) {
        // Toast.makeText(context, "Enter UserName", Toast.LENGTH_LONG).show();
        String msg="Select From DATE";
        return msg;
    } else if (params[2].matches("")) {
        //Toast.makeText(context, "Enter Password", Toast.LENGTH_LONG).show();

        String msg="Select To DATE";
        return msg;
    }
}
else if(type.equals("previous_record")){
    if(params[1].matches("")&&params[2].matches("")){

        String msg="Select the DATE";
        return msg;
    }
    else if (params[1].matches("") ) {
        // Toast.makeText(context, "Enter UserName", Toast.LENGTH_LONG).show();
        String msg="Select From DATE";
        return msg;
    } else if (params[2].matches("")) {
        //Toast.makeText(context, "Enter Password", Toast.LENGTH_LONG).show();

        String msg="Select To DATE";
        return msg;
    }
}
else if(type.equals("Mess_Out")){
    if (params[1].matches("")) {
        //Toast.makeText(context, "Enter Password", Toast.LENGTH_LONG).show();

        String msg="Select To DATE";
        return msg;
    }

}


        if (type.equals("login")) {

                try {

                    String user_name = params[1];//
                    String password = params[2];
                    URL url = new URL(login_url);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                    String post_data = URLEncoder.encode("user_name", "UTF-8") + "=" + URLEncoder.encode(user_name, "UTF-8") + "&"
                            + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8");
                    bufferedWriter.write(post_data);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    outputStream.close();
                    InputStream inputStream = httpURLConnection.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                    String result="";
                    String line = "";
                    while ((line = bufferedReader.readLine()) != null) {
                        result += line;
                    }
                    bufferedReader.close();
                    inputStream.close();
                    httpURLConnection.disconnect(); //why did we  disconnect it
                    return result;
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                catch(NullPointerException e){
                    e.printStackTrace();
                }
            }


         else if (type.equals("messin_out")) {
            try {
                String from_date = params[1];
                String to_date= params[2];
              //  String user=name;

                URL url = new URL(reg_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("from_date", "UTF-8") + "=" + URLEncoder.encode(from_date, "UTF-8") + "&"
                        + URLEncoder.encode("user", "UTF-8") + "=" + URLEncoder.encode(name, "UTF-8")
                        + "&"+ URLEncoder.encode("to_date", "UTF-8") + "=" + URLEncoder.encode(to_date, "UTF-8");

                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect(); //why did we  disconnect it
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (type.equals("previous_record")) {
            try {
                String from_date = params[1];
                String to_date= params[2];
                //  String user=name;

                URL url = new URL(prev_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("from_date", "UTF-8") + "=" + URLEncoder.encode(from_date, "UTF-8") + "&"
                        + URLEncoder.encode("user", "UTF-8") + "=" + URLEncoder.encode(name, "UTF-8")
                        + "&"+ URLEncoder.encode("to_date", "UTF-8") + "=" + URLEncoder.encode(to_date, "UTF-8");

                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect(); //why did we  disconnect it
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
                Toast.makeText(context, "Enter Password", Toast.LENGTH_LONG).show();
            }
        }
        else if (type.equals("Mess_Out")) {
            try {
                String from_date = params[1];
                String to_date= params[2];
                //  String user=name;

                URL url = new URL(in_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("from_date", "UTF-8") + "=" + URLEncoder.encode(from_date, "UTF-8") + "&"
                        + URLEncoder.encode("user", "UTF-8") + "=" + URLEncoder.encode(name, "UTF-8");

                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect(); //why did we  disconnect it
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if(type.equals("bill"))
        {
            try {


                URL url = new URL(bill_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("user", "UTF-8") + "=" + URLEncoder.encode(name, "UTF-8") ;
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect(); //why did we  disconnect it
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(type.equals("logout"))
        {
            try {


                URL url = new URL(logout_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("user", "UTF-8") + "=" + URLEncoder.encode(name, "UTF-8") ;
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect(); //why did we  disconnect it
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



        return null;

    }

    @Override
    protected void onPreExecute() {
        alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Bill");
    }

    @Override
    protected void onPostExecute(String result) {

        char b='[';

if(result!=null){
        if (result.matches("LOGED IN")) {

            Toast.makeText(context, result, Toast.LENGTH_LONG).show();
          Intent intent = new Intent(context, AfterLoginActivity.class);
            context.startActivity(intent);
        }
        else if(result.charAt(0)==b)
        {
            user.dat(result);
            Intent intent = new Intent(context, Recycler_View.class);
            context.startActivity(intent);

        }
        else if(type.equals("bill")){

            alertDialog.setMessage(result);
            alertDialog.show();
        }
        else
        {
            Toast.makeText(context, result, Toast.LENGTH_LONG).show();

        }
}
 else {
    Toast.makeText(context, "Network Connection Failed", Toast.LENGTH_LONG).show();
}
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }


}