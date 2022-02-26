package com.example.cubicle_retrofit_api;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.cubicle_retrofit_api.adapter.ContactsAdapter;
import com.example.cubicle_retrofit_api.model.Contacts;
import com.example.cubicle_retrofit_api.model.Root;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    String TAG = "TAGER";
    ContactsAdapter contactsAdapter;
    List<Contacts> contactsList;
    ContactsServiceApi contactsServiceApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        contactsList = new ArrayList<>();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.androidhive.info/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        contactsServiceApi = retrofit.create(ContactsServiceApi.class);

        getAllContacts();

    }

    private void getAllContacts() {
        Call<Root> call=contactsServiceApi.getAllContacts();


        call.enqueue(new Callback<Root>() {
            @Override
            public void onResponse(Call<Root> call, Response<Root> response) {
                Root root=response.body();

                List<Contacts> contacts=root.getContacts();

                contactsAdapter=new ContactsAdapter(contacts, MainActivity.this);
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                recyclerView.setAdapter(contactsAdapter);

            }

            @Override
            public void onFailure(Call<Root> call, Throwable t) {

            }
        });



//        Call<Root> call=contactsServiceApi.getAllContacts();

//        call.enqueue(new Callback<Root>() {
//            @Override
//            public void onResponse(Call<Root> call, Response<Root> response) {
//
//                if (response.isSuccessful())
//                {
//                    Root root=response.body();
//
//                    contactsList.add(root);
//                     contactsAdapter=new ContactsAdapter(contactsList, MainActivity.this);
//                    recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false));
//                    recyclerView.setAdapter(contactsAdapter);
//                }
//                }
//
//
//            @Override
//            public void onFailure(Call<Root> call, Throwable t) {
//
//                Log.d(TAG, "onFailure: "+t.getMessage());
//            }
//        });

    }
}

/*

API
Kotlin
RecyclerView
Retrofit
Room
Firebase Firestore
Coroutine
MVVM



 */