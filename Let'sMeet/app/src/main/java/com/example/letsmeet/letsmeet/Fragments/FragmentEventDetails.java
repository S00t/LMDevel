package com.example.letsmeet.letsmeet.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.letsmeet.letsmeet.Models.Event;
import com.example.letsmeet.letsmeet.R;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

public class FragmentEventDetails extends Fragment implements OnMapReadyCallback {

    private Event event;
    // view's
    private TextView tDescription;
    private TextView tParticipantsNumber;
    private TextView  tDate;
    private TextView  tAddress;
    private SupportMapFragment mapFragment;
//    public ImageView iDate; // date icon. Currently is static import from res.
//    public ImageView iAddress; // address icon. Currently is static import from res.

    public static FragmentEventDetails newInstance(Event event) {
        FragmentEventDetails f = new FragmentEventDetails();
        f.event = event;
        return f;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_event_details, container, false);

        setUpViews(layout);
        setUpMap();
        fillViewsWithData();
        
        return layout;
    }

    private void setUpMap() {
        mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.EventDetailMap);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

    }


    private void fillViewsWithData() {
        if (event.getDescription() != null)
            tDescription.setText(event.getDescription());

        // set number of free space
        // if there is anyone assign to this event, get subtract (Max - current)
        if (event.getParticipantsCurrent() != 0) {
            int numberOfFreePlace = event.getParticipantsMax() - event.getParticipantsCurrent();
            tParticipantsNumber.setText(Integer.toString(numberOfFreePlace));
        }
        else
            tParticipantsNumber.setText(Integer.toString(event.getParticipantsMax()));

        if (event.getDate() != null)
            tDate.setText(event.getDate());
        if (event.getPlace() != null)
            tAddress.setText(event.getPlace());
    }

    private void setUpViews(View layout) {
        tDescription = (TextView) layout.findViewById(R.id.fragmentEventDetailsDescription);
        tParticipantsNumber = (TextView) layout.findViewById(R.id.fragmentEventDetailsParticipantsNumber);
        tDate = (TextView) layout.findViewById(R.id.eventDetailsDate);
        tAddress = (TextView) layout.findViewById(R.id.eventDetailsAddress);
    }


}
