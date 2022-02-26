package com.example.cubicle_retrofit_api;

import com.example.cubicle_retrofit_api.model.Contacts;
import com.example.cubicle_retrofit_api.model.Root;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ContactsServiceApi {

    @GET("contacts/")
    Call<Root> getAllContacts();
}
