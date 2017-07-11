package com.inno.ilyadmt.asynctask;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.content.Loader;
import android.os.AsyncTask;
import android.os.Bundle;

import java.util.concurrent.TimeUnit;

/**
 * Created by mjazz on 11.07.2017.
 */

public class MyCustomLoader extends Loader<String> {

    class LoaderAsyncTask extends AsyncTask<String, Void, String>{

        @Override
        protected String doInBackground(String... strings) {
            Double sum = 0D;
            Integer from = 1;
            Integer to = 3;
            for(int i = from; i < to; i++){
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                sum+=i;
            }
            return sum.toString();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            getResults(s);
        }
    }

    public MyCustomLoader(Context context, Bundle bundle) {
        super(context);
    }

    @Override
    protected void onStopLoading() {
        super.onStopLoading();
    }

    @Override
    public void forceLoad() {
        super.forceLoad();
        LoaderAsyncTask loaderAsyncTask = new LoaderAsyncTask();
        loaderAsyncTask.execute();
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }

    public void getResults(String s){
        deliverResult(s);
    }
}
