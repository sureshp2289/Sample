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


public class Images extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    View view;
    RecyclerView rv_images;



    public Images() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static Images newInstance(String param1) {
        Images fragment = new Images();
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
            view = inflater.inflate(R.layout.fragment_images, container, false);
            Intialzewidgets(view);
        }
        return view;        }

    // TODO: Rename method, update argument and hook method into UI event

    private void Intialzewidgets(View view) {
        rv_images=(RecyclerView)view.findViewById(R.id.rv_images);
        VideosAdapter adapter = new VideosAdapter(getActivity());
        rv_images.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        rv_images.setLayoutManager(mLayoutManager);
        rv_images.setItemAnimator(new DefaultItemAnimator());
        rv_images.addItemDecoration(new DividerItem(getActivity(), LinearLayoutManager.VERTICAL));
        rv_images.setAdapter(adapter);
    }




}
