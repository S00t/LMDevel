package com.example.letsmeet.letsmeet.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.letsmeet.letsmeet.Models.Event;
import com.example.letsmeet.letsmeet.R;
import com.example.letsmeet.letsmeet.Views.Adapters.AdapterEventList;

import java.util.List;

/**
 * Created by Soot_Win on 2015-03-21.
 */
public class FragmentEventList extends Fragment implements AdapterEventList.OnItemClickListener{

    private RecyclerView rEventList;
    private List<Event> eventList;

    public static Fragment newInstance (List<Event> eventList){
        FragmentEventList f = new FragmentEventList();
        f.eventList = eventList;
        return f;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_event_list, container, false);

        setUpList(layout);

        return layout;
    }

    private void setUpList(View layout) {
        rEventList = (RecyclerView) layout.findViewById(R.id.FragmentEventList);
        rEventList.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        rEventList.setAdapter(new AdapterEventList(getActivity(), this, eventList));

    }


    @Override
    public void OnItemEventClicked(View itemView) {
        Toast.makeText(getActivity(), "Kliknięty item:  " + rEventList.getChildPosition(itemView), Toast.LENGTH_SHORT).show();
    }
}
