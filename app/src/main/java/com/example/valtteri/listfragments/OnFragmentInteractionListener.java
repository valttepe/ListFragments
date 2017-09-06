package com.example.valtteri.listfragments;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by Valtteri on 29.8.2017.
 */

public interface OnFragmentInteractionListener {
    void onFragmentInteraction(Uri uri);
    void sendPosition(Bundle bundle);
}
