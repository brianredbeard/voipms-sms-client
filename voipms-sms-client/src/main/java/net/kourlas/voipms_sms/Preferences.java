/*
 * VoIP.ms SMS
 * Copyright (C) 2015 Michael Kourlas
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation the
 * rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the
 * Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
 * OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package net.kourlas.voipms_sms;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Preferences {
    private static Preferences instance;
    private final Context applicationContext;
    private final SharedPreferences sharedPreferences;

    private Preferences(Context applicationContext) {
        this.applicationContext = applicationContext;
        this.sharedPreferences = PreferenceManager.getDefaultSharedPreferences(applicationContext);
    }

    public static Preferences getInstance(Context applicationContext) {
        if (instance == null) {
            instance = new Preferences(applicationContext);
        }
        return instance;
    }

    public String getEmail() {
        return sharedPreferences.getString("api_email", "");
    }

    public String getPassword() {
        return sharedPreferences.getString("api_password", "");
    }

    public int getDaysToSync() {
        return Integer.parseInt(sharedPreferences.getString("sms_days_to_sync",
                applicationContext.getResources().getString(R.string.preferences_sms_days_to_sync_default_value)));
    }

    public String getDid() {
        return sharedPreferences.getString("did", "");
    }

    public void setDid(String did) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("did", did);
        editor.apply();
    }

    public boolean getNotificationsEnabled() {
        return sharedPreferences.getBoolean("sms_notification", false);
    }

    public void setNotificationsEnabled(boolean gcmEnabled) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("sms_notification", gcmEnabled);
        editor.apply();
    }

    public String getRegistrationId() {
        return sharedPreferences.getString("registration_id", "");
    }

    public void setRegistrationId(String registrationId) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("registration_id", registrationId);
        editor.apply();
    }

    public int getRegistrationIdVersion() {
        return sharedPreferences.getInt("registration_id_ver", Integer.MIN_VALUE);
    }

    public void setRegistrationIdVersion(int registrationId) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("registration_id_ver", registrationId);
        editor.apply();
    }

    public boolean getFirstRun() {
        return sharedPreferences.getBoolean("first_run", true);
    }

    public void setFirstRun(boolean firstRun) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("first_run", firstRun);
        editor.apply();
    }
}