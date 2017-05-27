package com.github.andrejnazarov.helloworld;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/**
 * @author Nazarov on 13.05.17.
 */

public class Utils {

    private static final String IS_LOGGED_IN = "logged_in";

    public static void hideKeyboard(@NonNull View view, Context context) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static void writeIsAlreadyLoggedIn(Activity activity, boolean loggedIn) {
        SharedPreferences sharedPref = activity.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean(IS_LOGGED_IN, loggedIn);
        editor.apply();
    }

    public static boolean readIsAlreadyLoggedIn(Activity activity) {
        SharedPreferences sharedPref = activity.getPreferences(Context.MODE_PRIVATE);
        boolean defaultValue = false;
        return sharedPref.getBoolean(IS_LOGGED_IN, defaultValue);
    }
}