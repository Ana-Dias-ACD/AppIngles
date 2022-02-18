package com.example.appingles.Framents;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.appingles.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link VogaisFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class VogaisFragment extends Fragment implements View.OnClickListener {
    private ImageButton buttonA, buttonE, buttonI, buttonO, buttonU;
    private MediaPlayer mediaPlayer;

    public VogaisFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment VogaisFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static VogaisFragment newInstance(String param1, String param2) {

        return null;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_vogais, container, false);

        buttonA = view.findViewById(R.id.buttonA);
        buttonE = view.findViewById(R.id.buttonE);
        buttonI = view.findViewById(R.id.buttonI);
        buttonO = view.findViewById(R.id.buttonO);
        buttonU = view.findViewById(R.id.buttonU);


        buttonA.setOnClickListener(this);
        buttonE.setOnClickListener(this);
        buttonI.setOnClickListener(this);
        buttonO.setOnClickListener(this);
        buttonU.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.buttonA:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.a);
                tocarSom();
                break;

            case R.id.buttonE:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.e);
                tocarSom();
                break;

            case R.id.buttonI:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.i);
                tocarSom();
                break;

            case R.id.buttonO:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.o);
                tocarSom();
                break;

            case R.id.buttonU:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.u);
                tocarSom();
                break;
        }
    }

    private void tocarSom() {
        if (mediaPlayer != null){
            mediaPlayer.start();

            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.release();
                }
            });
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        if (mediaPlayer != null){
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}