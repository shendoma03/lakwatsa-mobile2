package com.example.rhendel03.nav1;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class GetInput extends Fragment {
    private EditText ULocation;
    private EditText UDestination;

    GetInputListener gIgo;
    public interface GetInputListener{
        public void sendInput(String location , String destination);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            gIgo = (GetInputListener) context;
        }catch(ClassCastException e){
            throw new ClassCastException(context.toString());
        }

        }


    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.get_input, container, false);
        ULocation = (EditText) view.findViewById(R.id.iLocation);
        UDestination = (EditText) view.findViewById(R.id.iDestination);
        final FloatingActionButton fabGo = (FloatingActionButton) view.findViewById(R.id.fabGo);

        fabGo.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    fabGoClick(v);
                }
            }
            );



        return view;
    }
    public void fabGoClick(View view ){
        gIgo.sendInput(ULocation.getText().toString(),UDestination.getText().toString());
    }

}
