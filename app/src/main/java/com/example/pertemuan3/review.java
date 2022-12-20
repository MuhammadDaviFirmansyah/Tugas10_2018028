package com.example.pertemuan3;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class review extends Fragment {

    RecyclerView recylerView;

    String s1[], s2[];
    int images[] = {
            R.drawable.arceus,
            R.drawable.elden_ring,
            R.drawable.hi3,
            R.drawable.mikuh,
            R.drawable.ow,
            R.drawable.monopoli,
            R.drawable.ssbu
    };

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public review() {
        // Required empty public constructor
    }

    public static review newInstance(String param1, String param2) {
        review fragment = new review();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_review, container, false);
        recylerView = view.findViewById(R.id.recyclerView);
        s1 = getResources().getStringArray(R.array.game);
        s2 = getResources().getStringArray(R.array.harga);
        GameAdapter appAdapter = new GameAdapter(this,s1,s2,images);
        recylerView.setAdapter(appAdapter);
        LinearLayoutManager layoutManager= new LinearLayoutManager
                (view.getContext(),LinearLayoutManager.HORIZONTAL, false);
        recylerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recylerView.setLayoutManager(layoutManager);

        return view;
    }
}