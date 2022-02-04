package com.example.ejemploasynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
 static TextView txtView;
 private ProgressBar progressBar;

 TareaContador task;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtView = (TextView) findViewById(R.id.textView1);
        contador(txtView);
        progressBar = findViewById(R.id.progressBar);
        progressBar.setMax(100);
        progressBar.setProgress(0);
     //   Toast t = new Toast("");


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
            progressBar.setProgress(progress[0].intValue()*10);
            int cont = progress[0].intValue()*10;
            Toast.makeText(MainActivity.this,cont,Toast.LENGTH_SHORT).show();
            Log.d("Threading", "actualizando...");
        }
    }
    public void contador(View view){
        task=(TareaContador) new TareaContador().execute();
    }
}