package com.example.letsmeet.letsmeet.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.letsmeet.letsmeet.Models.Event;
import com.example.letsmeet.letsmeet.Models.Organizer;
import com.example.letsmeet.letsmeet.R;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

public class FragmentEventDetails extends Fragment implements OnMapReadyCallback, View.OnClickListener {

    // ------ data
    private Event event;
    private Organizer organizer;
    // ------ view's
    // event
    private TextView tDescription;
    private TextView tParticipantsNumber;
    private TextView  tDate;
    private TextView  tAddress;
    private Button bJoin;
//    public ImageView iDate; // date icon. Currently is static import from res.
//    public ImageView iAddress; // address icon. Currently is static import from res.
    // organizer
    private TextView tOrganizerName;
    private TextView tOrganizerMail;
    private TextView tOrganizerPhone;
    private Button bMakeCall;
    private Button bWriteMail;
    // map
    private SupportMapFragment mapFragment;

    public static FragmentEventDetails newInstance(Event event, Organizer organizer) {
        FragmentEventDetails f = new FragmentEventDetails();
        f.event = event;
        f.organizer = organizer;
        return f;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_event_details, container, false);

        setUpViews(layout);
        fillViewsWithData();
        setUpClickListeners();
        
        return layout;
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.eventDetailsJoin){

        }
        else if (v.getId() == R.id.eventDetailsOrganizerMakeCall){

        }
        else if(v.getId() == R.id.eventDetailsOrganizerWriteMail){

        }
    }


    private void setUpClickListeners() {
        bJoin.setOnClickListener(this);
        bMakeCall.setOnClickListener(this);
        bWriteMail.setOnClickListener(this);
    }

    private void fillViewsWithData() {
        fillViewsOrganizer();
        fillViewsEvent();
    }

    private void fillViewsOrganizer(){
        if (organizer!= null){
            if (organizer.getName()!=null)
                tOrganizerName.setText(organizer.getName());
            if (organizer.getMail()!=null)
                tOrganizerMail.setText(organizer.getMail());
            if (organizer.getPhone()!=null)
                tOrganizerPhone.setText(organizer.getPhone());
        }
    }

    private void fillViewsEvent(){
        if (event != null) {
            if (event.getDescription() != null)
                tDescription.setText(event.getDescription());

            // set number of free space
            // if there is anyone assign to this event, get subtract (Max - current)
            if (event.getParticipantsCurrent() != 0) {
                int numberOfFreePlace = event.getParticipantsMax() - event.getParticipantsCurrent();
                tParticipantsNumber.setText(Integer.toString(numberOfFreePlace));
            } else
                tParticipantsNumber.setText(Integer.toString(event.getParticipantsMax()));

            if (event.getDate() != null)
                tDate.setText(event.getDate());
            if (event.getPlace() != null)
                tAddress.setText(event.getPlace());
        }
    }

    private void setUpViews(View layout) {
        // event
        tDescription = (TextView) layout.findViewById(R.id.fragmentEventDetailsDescription);
        tParticipantsNumber = (TextView) layout.findViewById(R.id.fragmentEventDetailsParticipantsNumber);
        tDate = (TextView) layout.findViewById(R.id.eventDetailsDate);
        tAddress = (TextView) layout.findViewById(R.id.eventDetailsAddress);
        bJoin = (Button) layout.findViewById(R.id.eventDetailsJoin);
        // organizer
        tOrganizerName = (TextView) layout.findViewById(R.id.eventDetailsOrganizerName);
        tOrganizerMail = (TextView) layout.findViewById(R.id.eventDetailsOrganizerMail);
        tOrganizerPhone = (TextView) layout.findViewById(R.id.eventDetailsOrganizerPhone);
        bMakeCall = (Button) layout.findViewById(R.id.eventDetailsOrganizerMakeCall);
        bWriteMail = (Button) layout.findViewById(R.id.eventDetailsOrganizerWriteMail);
        // map
        setUpMap();
    }

    private void setUpMap() {
        mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.eventDetailMap);
        mapFragment.getMapAsync(this);
    }
}
