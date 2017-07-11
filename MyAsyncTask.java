package com.inno.ilyadmt.asynctask;

import android.content.Context;
import android.content.Intent;

import android.os.AsyncTask;
import android.renderscript.Double2;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

/**
 * Created by mjazz on 10.07.2017.
 */

public class MyAsyncTask extends AsyncTask<String, Integer, Double> {

    Context context;

    public MyAsyncTask(Context context) {
        this.context = context;
    }

    @Override
    protected Double doInBackground(String... strings) {
        Double sum = 0D;
        Integer from = Integer.parseInt(strings[0]);
        Integer to = Integer.parseInt(strings[1]);
        for(int i = from; i < to; i++){
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            publishProgress(i);
            sum+=i;
        }
        return sum;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Toast.makeText(context, "Progress Started", Toast.LENGTH_LONG).show();

    }

    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    protected void onPostExecute(Double aDouble) {
        super.onPostExecute(aDouble);

    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        if(context != null) {
            Toast.makeText(context, "Progress is " + values[0], Toast.LENGTH_LONG).show();
        }
    }
}
