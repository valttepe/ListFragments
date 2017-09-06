package com.example.valtteri.listfragments;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements OnFragmentInteractionListener {
    DetailsFragment detail = new DetailsFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (findViewById(R.id.fragment_container) != null) {

            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.
            if (savedInstanceState != null) {
                return;
            }

            // Create a new Fragment to be placed in the activity layout
            PresidentsFragment presFrag = new PresidentsFragment();

            // Add the fragment to the 'fragment_container' FrameLayout
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, presFrag).commit();
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri){

    }

    @Override
    public void sendPosition(Bundle bundle) {
        Log.i("TEST", "Toimiii ehkä");
        DetailsFragment newFrag = new DetailsFragment();
        newFrag.setArguments(bundle);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_container, newFrag);
        ft.addToBackStack(null);
        ft.commit();
    }

}
