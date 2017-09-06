package com.example.valtteri.listfragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PresidentsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PresidentsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PresidentsFragment extends ListFragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    President[] press = {
            new President("Stahlberg, Kaarlo Juho", "1919-1925", "First one"),
            new President("Relander, Lauri Kristian", "1925-1931", "Second one"),
            new President("Svinhufvud, Pehr Evind", "1931-1937", "Third one"),
            new President("Kallio, Kyosti", "1937-1940", "Fourth one"),
            new President("Ryti, Risto Heikki", "1940-1944", "Fifth one"),
            new President("Mannerheim, Carl Gustav Emil", "1944-1946", "Sixth one"),
            new President("Paasikivi, Juho Kusti", "1946-1956", "Seventh one"),
            new President("Kekkonen, Urho Kaleva", "1956-1982", "Eighth one"),
            new President("Koivisto, Mauno Henrik", "1982-1994", "Ninth one"),
            new President("Ahtisaari, Martti Oiva Kalevi", "1994-2000", "Tenth one"),
            new President("Halonen, Tarja Kaarina", "2000-2012", "Eleventh one")

    };

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public PresidentsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PresidentsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PresidentsFragment newInstance(String param1, String param2) {
        PresidentsFragment fragment = new PresidentsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayAdapter<President> adapter = new ArrayAdapter<President>(getActivity(), android.R.layout.simple_list_item_1, press);
        setListAdapter(adapter);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_presidents, container, false);
    }



    // TODO: Rename method, update argument and hook method into UI event
    /*
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }
    */
    public void onListItemClick(ListView l, View v, int position, long id){
        if (mListener != null) {
            Bundle args = new Bundle();
            args.putString(ARG_PARAM1, press[position].toString());
            args.putString(ARG_PARAM2, press[position].getDescription());
            mListener.sendPosition(args);
        }
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */

}
