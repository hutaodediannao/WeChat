package com.hutao.chunchun.ext;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hutao.chunchun.R;

/**
 * Created by hutao on 2018-11-17.
 */

public class UserFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.ease_row_ding_ack_user, container, false);
    }








}
