package com.example.careconnect.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.careconnect.model.Medicine;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.*;

public class CartManager {

    private static final String PREF = "cart_pref";
    private static final String KEY = "cart_items";

    // 🔥 ADD ITEM
    public static void addToCart(Context context, Medicine m) {

        try {
            List<Medicine> list = getCart(context);

            list.add(m);

            JSONArray arr = new JSONArray();

            for (Medicine med : list) {
                JSONObject obj = new JSONObject();
                obj.put("name", med.name);
                obj.put("desc", med.description);
                obj.put("price", med.price);
                arr.put(obj);
            }

            SharedPreferences sp = context.getSharedPreferences(PREF, Context.MODE_PRIVATE);
            sp.edit().putString(KEY, arr.toString()).apply();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 🔥 GET CART
    public static List<Medicine> getCart(Context context) {

        List<Medicine> list = new ArrayList<>();

        try {
            SharedPreferences sp = context.getSharedPreferences(PREF, Context.MODE_PRIVATE);
            String data = sp.getString(KEY, "[]");

            JSONArray arr = new JSONArray(data);

            for (int i = 0; i < arr.length(); i++) {
                JSONObject obj = arr.getJSONObject(i);

                list.add(new Medicine(
                        obj.getString("name"),
                        obj.getString("desc"),
                        obj.getString("price")
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // 🔥 CLEAR CART
    public static void clearCart(Context context) {
        SharedPreferences sp = context.getSharedPreferences(PREF, Context.MODE_PRIVATE);
        sp.edit().clear().apply();
    }
}