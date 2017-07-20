package onelance.com.loginandregister;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by root on 6/15/2017.
 */

    public class BackgroundTask  extends AsyncTask<String, Void, String>
    {
            String login_url = "https://droidtoor.000webhostapp.com/login1.php";
            //String register_url = "http://192.168.1.3/android/register2.php";
        String register_url = "https://droidtoor.000webhostapp.com/register2.php";


        Context ctx;
            Activity activity;
            ProgressDialog progressDialog;
            AlertDialog builder;

            public BackgroundTask(Context ctx)
            {
                this.ctx = ctx;
                activity = (Activity)ctx;
            }

            @Override
            protected void onPreExecute() {
                /*builder = new AlertDialog.Builder(activity);
                    progressDialog = new ProgressDialog(ctx);
                    progressDialog.setTitle("Please wait");
                    progressDialog.setMessage("Connecting to server....");
                    progressDialog.setIndeterminate(true);
                    progressDialog.setCancelable(false);
                    progressDialog.show();*/
                builder = new AlertDialog.Builder(ctx).create();
                builder.setTitle("Login Status");
            }

            @Override
            protected String doInBackground(String... params) {
                String method = params[0];

                //This loop is check for whether Login or Register..
                if(method.equals("register"))
                {
                    try
                    {
                        URL url = new URL(register_url);
                        //What's use of HttpURLConnection/BufferWriter/URLEncode/InputStream or does this line should be use every time need to connect to database
                        HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                        httpURLConnection.setRequestMethod("POST");
                        httpURLConnection.setDoInput(true);
                        httpURLConnection.setDoOutput(true);
                        OutputStream outputStream = httpURLConnection.getOutputStream();
                        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                        String name = params[1];
                        String email = params[2];
                        String password = params[3];
                        String phone = params[4];
                        String data = URLEncoder.encode("name","UTF-8")+"="+URLEncoder.encode(name,"UTF-8")+"&"+
                                      URLEncoder.encode("email","UTF-8")+"="+URLEncoder.encode(email,"UTF-8")+"&"+
                                      URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(password,"UTF-8")+"&"+
                                      URLEncoder.encode("phone","UTF-8")+"="+URLEncoder.encode(phone,"UTF-8");

                        bufferedWriter.write(data);
                        bufferedWriter.flush();
                        bufferedWriter.close();
                        outputStream.close();

                        //Get Respond From Server whether the Insertion is Sucess or Not
                        InputStream inputStream = httpURLConnection.getInputStream();
                        BufferedReader bufferedReader = new BufferedReader((new InputStreamReader(inputStream)));
                        StringBuilder stringBuilder = new StringBuilder();
                        String line = "";
                        while ((line=bufferedReader.readLine())!=null)
                        {
                            stringBuilder.append(line+"\n");
                        }
                        httpURLConnection.disconnect();
                        Thread.sleep(5000);
                        return stringBuilder.toString().trim();
                    }

                    catch (MalformedURLException e)
                    {
                        e.printStackTrace();
                    }

                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }

                    catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
                else if (method.equals("login")) {
                    try {
                        URL url = new URL(login_url);
                        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                        httpURLConnection.setRequestMethod("POST");
                        httpURLConnection.setDoInput(true);
                        httpURLConnection.setDoOutput(true);
                        OutputStream outputStream = httpURLConnection.getOutputStream();
                        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));

                        String email = params[1];
                        String password = params[2];
                        String data = URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(email, "UTF-8") + "&" +
                                URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8");

                        bufferedWriter.write(data);
                        bufferedWriter.flush();
                        bufferedWriter.close();
                        outputStream.close();

                        //Get Respond From Server whether the Insertion is Sucess or Not
                        InputStream inputStream = httpURLConnection.getInputStream();
                        BufferedReader bufferedReader = new BufferedReader((new InputStreamReader(inputStream)));
                        StringBuilder stringBuilder = new StringBuilder();
                        String line = "";
                        while ((line=bufferedReader.readLine())!=null)
                        {
                            stringBuilder.append(line+"\n");
                        }
                        httpURLConnection.disconnect();
                        Thread.sleep(5000);
                        return stringBuilder.toString().trim();


                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    } catch (ProtocolException e) {
                        e.printStackTrace();
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
                    return null;
            }

            @Override
            protected void onProgressUpdate(Void... values) {
                super.onProgressUpdate(values);
            }

            @Override
            protected void onPostExecute(String result) {
                builder.setMessage(result);
                builder.show();
               /* try {
                    progressDialog.dismiss();
                    JSONObject jsonObject = new JSONObject(json);
                    JSONArray jsonArray = jsonObject.getJSONArray("server_response");
                    JSONObject  JO = jsonArray.getJSONObject(0);
                    String code = JO.getString("code");
                    String message = JO.getString("message");
                    if(code.equals("reg_true"))
                    {
                        showDialog("Registration Sucess", message,code);
                    }
                    else if(code.equals("reg_false"))
                    {
                        showDialog("Registration Failed", message,code);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }*/
            }
            /*public void showDialog(String title, String message, String code)
            {
                builder.setTitle(title);
                if(code.equals("reg_true")||code.equals("reg_false"))
                {
                    builder.setMessage(message);
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            activity.finish();
                        }
                    });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }
            }*/
    }
