package sample.example.com.sample.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import sample.example.com.sample.R;
import sample.example.com.sample.adapter.VideosAdapter;
import sample.example.com.sample.apputils.DividerItem;

public class MIlestones extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";

    View view;
    RecyclerView rv_milestones;


    public MIlestones() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static MIlestones newInstance(String param1) {
        MIlestones fragment = new MIlestones();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if(view==null) {
            view = inflater.inflate(R.layout.fragment_milestones, container, false);
            Intialzewidgets(view);
        }
        return view;    }

    private void Intialzewidgets(View view) {
        rv_milestones=(RecyclerView)view.findViewById(R.id.rv_milestones);
        VideosAdapter adapter = new VideosAdapter(getActivity());
        rv_milestones.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        rv_milestones.setLayoutManager(mLayoutManager);
        rv_milestones.setItemAnimator(new DefaultItemAnimator());
        rv_milestones.addItemDecoration(new DividerItem(getActivity(), LinearLayoutManager.VERTICAL));
        rv_milestones.setAdapter(adapter);
    }



}
