package com.example.ejemploasynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
 static TextView txtView;
 TareaContador task;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtView = (TextView) findViewById(R.id.textView1);
        contador(txtView);
    }
    private class TareaContador extends AsyncTask<Void, Integer, Void> {
        protected Void doInBackground(Void... params){
            for(int i=1; i<=10; i++){
                publishProgress(i);
                try{
                    Thread.sleep(1000);

                } catch (InterruptedException e) {
                    Log.d("Threading", e.getLocalizedMessage());
                }
            }
            return null;
        }



        protected  void onProgressUpdate(Integer... progress){
            txtView.setText(progress[0].toString());
            Log.d("Threading", "actualizando...");
        }
    }
    public void contador(View view){
        task=(TareaContador) new TareaContador().execute();
    }
}