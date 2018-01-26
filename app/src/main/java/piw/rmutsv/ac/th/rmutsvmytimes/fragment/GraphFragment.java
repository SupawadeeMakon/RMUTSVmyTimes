package piw.rmutsv.ac.th.rmutsvmytimes.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import org.json.JSONArray;
import org.json.JSONObject;

import piw.rmutsv.ac.th.rmutsvmytimes.R;
import piw.rmutsv.ac.th.rmutsvmytimes.utility.GetAllData;

/**
 * Created by macbookpro on 1/26/2018 AD.
 */

public class GraphFragment extends Fragment {
//Explicit

    private GraphView graphView;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        Create GraphView
        try {


            //Get All เอาข้อมูลมาจาก Server database แสดงในกราฟ
            String strURL = "http://androidthai.in.th/piw/getAllFirebasePiw.php";

            GetAllData getAllData = new GetAllData(getActivity());
            getAllData.execute(strURL);

            String strJSON = getAllData.get();

            Log.d("26JAN", "JSON==>" + strJSON);

            //ตัดคำเปลี่ยนตัว x y
            JSONArray jsonArray = new JSONArray(strJSON);
            //จองหน่วยความจำ
            int[] xInts = new int[jsonArray.length()];
            int[] yInts = new int[jsonArray.length()];
            DataPoint[] dataPoints = new DataPoint[jsonArray.length()];

            for (int i=0; i<jsonArray.length();i++) {

                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String strX = jsonObject.getString("x");
                String strY = jsonObject.getString("y");
                xInts[i] = Integer.parseInt(strX);
                yInts[i] = Integer.parseInt(strY);

                dataPoints[i] = new DataPoint(xInts[i], yInts[i]);




            }//for

                graphView = getView().findViewById(R.id.graphViewMyData);
            LineGraphSeries<DataPoint> dataPointLineGraphSeries = new LineGraphSeries<>(dataPoints);
            graphView.addSeries(dataPointLineGraphSeries);



        } catch (Exception e) {
            e.printStackTrace();

        }


    }//Main Method



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_graph, container, false);
        return view;
    }
}//Main Class
