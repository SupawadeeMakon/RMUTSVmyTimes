package piw.rmutsv.ac.th.rmutsvmytimes.utility;

import android.content.Context;
import android.os.AsyncTask;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

/**
 * Created by macbookpro on 1/26/2018 AD.
 */

public class PostData extends AsyncTask<String,Void,String>{
    private Context context;

    public PostData(Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(String... strings) {


        try {

            OkHttpClient okHttpClient = new OkHttpClient();
            RequestBody requestBody = new FormEncodingBuilder()
                    .add("isAdd", "true")
                    .add("x", strings[0])
                    .add("y", strings[1])
                    .build();
            Request.Builder builder = new Request.Builder();//จ่าหน้าซอง
            Request request = builder.url(strings[2]).post(requestBody).build();
            Response response = okHttpClient.newCall(request).execute();
            return response.body().string();




        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }


    }
}//Main Class
