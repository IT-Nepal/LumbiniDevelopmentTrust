package com.example.ubuntu.lumbinidevelopmenttrust;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class FragmentActivity extends Fragment {
    int id;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        id = getArguments().getInt("id");
        Log.d("TAG", "oncreatefragmentactivity");
    }


    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup viewGroup,  Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.imageview, null);

        ImageView imageView = view.findViewById(R.id.iv);
        imageView.setImageResource(id);
        Log.d("TAG", "oncreateviewfragmentactivity");
        return view;
    }
}
