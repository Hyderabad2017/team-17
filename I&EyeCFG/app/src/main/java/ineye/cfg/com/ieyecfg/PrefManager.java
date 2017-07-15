package ineye.cfg.com.ieyecfg;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by swapna on 15-07-2017.
 */

public class PrefManager {
    // Shared Preferences
    SharedPreferences pref;

    // Editor for Shared preferences
    SharedPreferences.Editor editor;

    // Context
    Context _context;

    // Shared pref mode
    int PRIVATE_MODE = 0;

    // Shared preferences file name
    private static final String PREF_NAME = "Trigger";

    // All Shared Preferences Keys

    private static final String KEY_VNAME = "name";
    private static final String KEY_EMAIL = "email";
    private static final String IS_UPDATED = "updated";



    public PrefManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME,PRIVATE_MODE );
        editor = pref.edit();
    }

    public void setVolunteerName(String volunteerName) {
        editor.putString(KEY_VNAME, volunteerName);
        editor.commit();
    }

    public String getVolunteerName() {
        return pref.getString(KEY_VNAME, null);
    }



    public void updateProfile(String name,String mail,String phone)
    {
        editor.putString(KEY_VNAME,name);
        editor.putString(KEY_EMAIL,mail);
        editor.commit();
    }



    public void setDetailsUpdated(boolean isUpdated ) {
        editor.putBoolean(IS_UPDATED, isUpdated);
        editor.commit();
    }

    public boolean isUpdated() {
        return pref.getBoolean(IS_UPDATED, false);
    }


    public void clearSession() {
        editor.clear();
        editor.commit();
    }
}
