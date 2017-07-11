package com.inno.ilyadmt.asynctask;

import android.app.Activity;
import android.app.LoaderManager;
import android.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements LoaderManager.LoaderCallbacks<String> {

    MyAsyncTask task;
    EditText ed1, ed2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1 = (EditText)findViewById(R.id.ed1);
        ed2 = (EditText)findViewById(R.id.ed2);


        getLoaderManager().initLoader(0, savedInstanceState, this);


    }

    @Override
    public Object onRetainNonConfigurationInstance() {
        return task;
    }

    public void start(View view) {
        task = (MyAsyncTask) getLastNonConfigurationInstance();
        if(task == null) {
            task = new MyAsyncTask(this);
        }
        else task.setContext(this);
        task.execute(ed1.getText().toString(), ed2.getText().toString());
    }

    public void loaderStart(View view) {
        Loader<String> loader = getLoaderManager().getLoader(0);
        loader.forceLoad();
    }

    @Override
    public Loader<String> onCreateLoader(int i, Bundle bundle) {
        MyCustomLoader myCustomLoader = new MyCustomLoader(this, bundle);
        return myCustomLoader;
    }

    @Override
    public void onLoadFinished(Loader<String> loader, String s) {
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onLoaderReset(Loader<String> loader) {

    }
}
