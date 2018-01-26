package piw.rmutsv.ac.th.rmutsvmytimes.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;
import java.util.Random;

import piw.rmutsv.ac.th.rmutsvmytimes.GraphActivity;
import piw.rmutsv.ac.th.rmutsvmytimes.R;
import piw.rmutsv.ac.th.rmutsvmytimes.utility.PostData;

/**
 * Created by macbookpro on 1/25/2018 AD.
 */

public class Mainfragment extends Fragment {

    //Explicit
    private TextView textView;
    private DatabaseReference databaseReference;
    private FirebaseDatabase firebaseDatabase;
    private String myTimesString;
    private Button button;

    @Override

    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//    Initial View ผูกความสัมพันธ์id
        textView = getView().findViewById(R.id.txtShowMyTimes);

//        Get Data From Firebase
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();//ดึงค่าจากfirebase

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Map map = (Map) dataSnapshot.getValue();
                myTimesString = String.valueOf(map.get("myTimes"));//เปลี่ยนค่าที่รับมาเป็น String
                textView.setText(myTimesString);

//                Get and Post Data Form Firebase to MySQL
                try {

                    String strURL = "http://androidthai.in.th/piw/addGraphPiw.php";
                    Random random = new Random();
                    int intX = Integer.parseInt(myTimesString);//เปลี่ยนอักษรให้เป็นจำนวน
                    int intY = random.nextInt(10) + intX;

                    PostData postData = new PostData(getActivity());
                    postData.execute(
                            Integer.toString(intX),
                            Integer.toString(intY),
                            strURL);
                    String strResult = postData.get();
                    Log.d("26Jan", "Result ==>" + strResult);



                } catch (Exception e) {
                    e.printStackTrace();

                }





            }//onDataChange

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

//        Graph Controller

        button = getView().findViewById(R.id.btnShowGraph);//ผูกกับตัวแปร
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"Show Graph",Toast.LENGTH_LONG).show();

                Intent intent = new Intent(getActivity(), GraphActivity.class);//เคลื่อนย้ายไปยังอีกหน้า หน้า GraphActivity
                startActivity(intent);
            }
        });


    }//Main Method

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.franment_main, container, false);
        return view;
    }

}//Main Class
