package piw.rmutsv.ac.th.rmutsvmytimes.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import piw.rmutsv.ac.th.rmutsvmytimes.R;

/**
 * Created by macbookpro on 1/25/2018 AD.
 */

public class ControllerFragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_controller, container, false);

        return view;
    }
}//Main Class
