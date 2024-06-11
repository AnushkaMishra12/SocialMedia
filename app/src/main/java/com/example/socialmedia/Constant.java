package com.example.socialmedia;

import java.util.ArrayList;

public class Constant {


    public static ArrayList<CategoryData> getData() {
        ArrayList<CategoryData> list = new ArrayList<>();
        CategoryData data = new CategoryData(R.drawable.img_2);
        list.add(data);
        CategoryData data1 = new CategoryData(R.drawable.img_3);
        list.add(data1);
        CategoryData data2 = new CategoryData(R.drawable.img_4);
        list.add(data2);
        CategoryData data3 = new CategoryData(R.drawable.img_5);
        list.add(data3);
        CategoryData data4 = new CategoryData(R.drawable.img_6);
        list.add(data4);
        CategoryData data5 = new CategoryData(R.drawable.img);
        list.add(data5);
        CategoryData data6 = new CategoryData(R.drawable.img_7);
        list.add(data6);
        return list;
    }
    public static ArrayList<SearchData> getSearchData() {
        ArrayList<SearchData> list = new ArrayList<>();
        SearchData data = new SearchData(R.drawable.img_2);
        list.add(data);
        SearchData data1 = new SearchData(R.drawable.img_3);
        list.add(data1);
        SearchData data2 = new SearchData(R.drawable.img_4);
        list.add(data2);
        SearchData data3 = new SearchData(R.drawable.img_5);
        list.add(data3);
        SearchData data4 = new SearchData(R.drawable.img_6);
        list.add(data4);
        SearchData data5 = new SearchData(R.drawable.img);
        list.add(data5);
        SearchData data6 = new SearchData(R.drawable.img_7);
        list.add(data6);
        return list;
    }
    public static ArrayList<ProfileData> getProfileData() {
        ArrayList<ProfileData> list = new ArrayList<>();
        ProfileData data = new ProfileData(R.drawable.img_2);
        list.add(data);
        ProfileData data1 = new ProfileData(R.drawable.img_3);
        list.add(data1);
        ProfileData data2 = new ProfileData(R.drawable.img_4);
        list.add(data2);
        ProfileData data3 = new ProfileData(R.drawable.img_5);
        list.add(data3);
        ProfileData data4 = new ProfileData(R.drawable.img_6);
        list.add(data4);
        ProfileData data5 = new ProfileData(R.drawable.img);
        list.add(data5);
        ProfileData data6 = new ProfileData(R.drawable.img_7);
        list.add(data6);
        return list;
    }
    public static ArrayList<ContactData> getContactData() {
        ArrayList<ContactData> list = new ArrayList<>();
        ContactData data = new ContactData(R.drawable.img_2,"jane");
        list.add(data);
        ContactData data1 = new ContactData(R.drawable.img_3,"William");
        list.add(data1);
        ContactData data2 = new ContactData(R.drawable.img_4,"ken");
        list.add(data2);
        ContactData data3 = new ContactData(R.drawable.img_5,"leo");
        list.add(data3);
        ContactData data4 = new ContactData(R.drawable.img_6,"rosy");
        list.add(data4);
        return list;
    }

}
