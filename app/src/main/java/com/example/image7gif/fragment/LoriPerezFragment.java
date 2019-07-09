package com.example.image7gif.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.image7gif.R;
import com.example.image7gif.adapter.UserAdapter;
import com.example.image7gif.generator.LorenTurnerGenerator;
import com.example.image7gif.generator.LoriPerezGenerator;
import com.example.image7gif.model.UserBO;

import java.util.List;

public class LoriPerezFragment extends Fragment {

    List<UserBO> userBOList;
    UserAdapter userAdapter;
    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_user, null);
        recyclerView = rootView.findViewById(R.id.recyclerview);
        setUserAdapter();
        return rootView;
    }

    private void setUserAdapter() {

        userBOList = LoriPerezGenerator.userBOList();

        userAdapter = new UserAdapter(getActivity(), userBOList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL,false);
        linearLayoutManager.scrollToPosition(0);

        recyclerView.setAdapter(userAdapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(linearLayoutManager);
    }
}
