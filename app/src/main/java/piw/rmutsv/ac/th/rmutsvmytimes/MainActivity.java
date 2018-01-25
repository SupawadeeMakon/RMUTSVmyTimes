package piw.rmutsv.ac.th.rmutsvmytimes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import piw.rmutsv.ac.th.rmutsvmytimes.fragment.Mainfragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        Add Fragment of Activity
        if (savedInstanceState==null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentMainFragment, new Mainfragment())
                    .commit();

        }


    }//Main Method
}
