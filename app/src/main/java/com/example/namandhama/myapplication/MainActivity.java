package com.example.namandhama.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.stmt.DeleteBuilder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity  {
    databasehelper dbhelper;
    RecyclerView rv;
    private vivvzadapter adapter;
    List<Note> notes;
    private ApiInterface api;
    public List<jsonclass> calo=new ArrayList<>();
    RecyclerView.LayoutManager lm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv = (RecyclerView) findViewById(R.id.rv);
        lm=new LinearLayoutManager(this);
        rv.setLayoutManager(lm);
        rv.setHasFixedSize(true);
        fetchinformation(this);
        Toast.makeText(this,"size of heroes "+calo.size(),Toast.LENGTH_SHORT).show();



    }

    private void datastuff()
    {
        dbhelper= OpenHelperManager.getHelper(this,databasehelper.class);
        RuntimeExceptionDao<Note, Integer> notedao=dbhelper.getRunTimeDao();





        notes=notedao.queryForAll();
        Toast.makeText(this,notes.toString(),Toast.LENGTH_SHORT).show();
        OpenHelperManager.releaseHelper();




    }

    public void fetchinformation(final Context context)
    {

        api=ApiClient.getApiClient().create(ApiInterface.class);
        Call<List<jsonclass>> call=api.getheroes();
        call.enqueue(new Callback<List<jsonclass>>() {
            @Override
            public void onResponse(Call<List<jsonclass>> call, Response<List<jsonclass>> response) {

                calo=response.body();


                dbhelper= OpenHelperManager.getHelper(context,databasehelper.class);
                RuntimeExceptionDao<Note, Integer> notedao=dbhelper.getRunTimeDao();




                for(int i=0;i<calo.size();i++) {
                    notedao.create(new Note(calo.get(i).getName(), calo.get(i).getRealname()));
                    notes = notedao.queryForAll();

                }









                adapter=new vivvzadapter(notes);
                rv.setAdapter(adapter);




                }

            @Override
            public void onFailure(Call<List<jsonclass>> call, Throwable t) {

            }
        });









    }


}
