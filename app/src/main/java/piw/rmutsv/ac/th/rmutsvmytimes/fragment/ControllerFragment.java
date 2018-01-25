package piw.rmutsv.ac.th.rmutsvmytimes.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

import piw.rmutsv.ac.th.rmutsvmytimes.R;

/**
 * Created by macbookpro on 1/25/2018 AD.
 */

public class ControllerFragment extends Fragment {
    //    Explicit
    private Button zeroButton, onButton, offButton;
    private FirebaseDatabase firebaseDatabase; //for connected for firebase
    private DatabaseReference databaseReference; //for connected for firebase


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        Initial View
        zeroButton = getView().findViewById(R.id.btnZero);
        onButton = getView().findViewById(R.id.btnON);
        offButton = getView().findViewById(R.id.btnOFF);

//        Setup Firebase
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();


//        Zero Controller
        zeroButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Map<String, Object> stringObjectMap = new HashMap<>();
                stringObjectMap.put("myTimes", "0");
                databaseReference.updateChildren(stringObjectMap);

            }//onClick
            
        });

//        On Controller
        onButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Map<String, Object> stringObjectMap = new HashMap<>();
                stringObjectMap.put("Switch", 1);
                databaseReference.updateChildren(stringObjectMap);



            }
        });



//        OFF Controller
        offButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Map<String, Object> stringObjectMap = new HashMap<>();
                stringObjectMap.put("Switch", 0);
                databaseReference.updateChildren(stringObjectMap);

            }
        });




    }//Main Method

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_controller, container, false);

        return view;
    }
}//Main Class
