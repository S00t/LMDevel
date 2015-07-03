package com.example.letsmeet.letsmeet.Views.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.letsmeet.letsmeet.Models.Event;
import com.example.letsmeet.letsmeet.R;

import java.util.List;

/**
 * Created by fares on 7/2/15.
 */
public class AdapterEventList extends RecyclerView.Adapter<AdapterEventList.ViewHolder> {

    private static final int EVEN = 0;
    private static final int ODD  = 1;

    private List<Event> eventList;
    private Context context;
    private OnItemClickListener listener;

    public AdapterEventList(Context context, OnItemClickListener listener, List<Event> eventList) {
        this.eventList = eventList;
        this.context = context;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_event_card, parent, false);

        if (viewType == EVEN)
            itemView.setBackgroundColor(context.getResources().getColor(R.color.transparent));
        else
            itemView.setBackgroundColor(context.getResources().getColor(R.color.transparent));

        return new ViewHolder(itemView, listener);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (eventList.get(position).getName() != null)
            holder.tTitle.setText(eventList.get(position).getName());
        if (eventList.get(position).getDate() != null)
            holder.tDate.setText(eventList.get(position).getDate());
        if (eventList.get(position).getPlace() != null)
            holder.tAddress.setText(eventList.get(position).getPlace());

        // set number of free space
        // if there is anyone assign to this event, get subtract (Max - current)
        if (eventList.get(position).getParticipantsCurrent() != 0) {
            int numberOfFreePlace = eventList.get(position).getParticipantsMax() - eventList.get(position).getParticipantsCurrent();
            holder.tParticipantsNumber.setText(Integer.toString(numberOfFreePlace));
        }
        else
            holder.tParticipantsNumber.setText(Integer.toString(eventList.get(position).getParticipantsMax()));
    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position % 2;
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        // view's
        public TextView tTitle;
        public TextView tParticipantsNumber;
        public TextView  tDate;
        public TextView  tAddress;
        public ImageView iDate; // date icon. Currently is static import from res.
        public ImageView iAddress; // address icon. Currently is static import from res.
        // on click listener
        private OnItemClickListener listener;


        public ViewHolder(View itemView, OnItemClickListener listener) {
            super(itemView);
            tTitle = (TextView) itemView.findViewById(R.id.listEventTitle);
            tParticipantsNumber = (TextView) itemView.findViewById(R.id.listEventParticipants);
            tDate = (TextView) itemView.findViewById(R.id.listEventDate);
            tAddress = (TextView) itemView.findViewById(R.id.listEventAddress);
            // on click listener
            itemView.setOnClickListener(this);
            this.listener = listener; // listener to redirect OnClick
        }

        @Override
        public void onClick(View v) {
            listener.OnItemEventClicked(v);
        }

    }

    public interface OnItemClickListener{
        void OnItemEventClicked(View itemView);
    }
}
