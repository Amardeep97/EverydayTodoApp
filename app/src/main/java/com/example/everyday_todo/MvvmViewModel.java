package com.example.everyday_todo;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class MvvmViewModel extends ViewModel {

    MutableLiveData<ArrayList<User>> userLiveData;
    ArrayList<User> userArrayList;

    public MvvmViewModel() {
        userLiveData = new MutableLiveData<>();

        // call your Rest API in init method
        init();
    }

    public MutableLiveData<ArrayList<User>> getUserMutableLiveData() {
        return userLiveData;
    }

    public void init(){
        populateList();
        userLiveData.setValue(userArrayList);
    }

    public void populateList(){

        User user = new User();
        user.setTitle(" Contact and Details");
        user.setDescription(" To do app your daily todo \n Created By: Amardeep \n Crud operation with list view, recycle view and many more \n user has to register inorder to add todo. \n Contact: moktanamardeep@tbc.edu.np");
        user.setDescription2("© 2020 Amardeep M. SimpleTODO. All Rights Reserved. ");
        userArrayList = new ArrayList<>();
        userArrayList.add(user);

    }
}