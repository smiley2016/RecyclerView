package com.example.fragmentrecyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.Objects;

import static android.content.ContentValues.TAG;

public class MainFragment extends Fragment {
    private Button next, recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment, container, false);

        next = (Button) view.findViewById(R.id.nextButton);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ViewGroup newLayout = (ViewGroup) getActivity().findViewById(R.id.constraintFragment);
                if(newLayout != null) {
                    NewFragment fragment = new NewFragment();
                    FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                    ft.replace(newLayout.getId(), fragment);
                    ft.addToBackStack("main_fragment");
                    ft.commit();
                }
            }
        });

        recyclerView = view.findViewById(R.id.recyclerViewButton);
        recyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), ContactListActivity.class));
            }
        });
        return view;
    }


}
