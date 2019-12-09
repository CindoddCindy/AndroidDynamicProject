package cindy.test.apipost;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.Objects;

import cindy.test.apipost.adapter.AdapterGetData;
import cindy.test.apipost.pojo.Datum;
import cindy.test.apipost.pojo.GetPostRespon;
import cindy.test.apipost.retro.RetrofitInter;
import cindy.test.apipost.retro.RetrofitUrl;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetData extends AppCompatActivity {

    RecyclerView recyclerView;
    AdapterGetData adapterGetData;
    //String datumList  = new String();
    ArrayList<Datum> datumList = new ArrayList<>();

    RetrofitUrl retrofitUrl ;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_data);
        //
        recyclerView = findViewById(R.id.get_data_rv);
       LinearLayoutManager layoutManager = new LinearLayoutManager(GetData.this);
        recyclerView.setLayoutManager(layoutManager);



        getDataInsert();
    }

    public void getDataInsert(){

        RetrofitInter retrofitInter  = RetrofitUrl.getRetrofit().create(RetrofitInter.class);
        Call<GetPostRespon> detailResponseCalls = retrofitInter.getDataInsert();//.getNearbyFacilities(portid);
        detailResponseCalls.enqueue(new Callback<GetPostRespon>() {
            @Override
            public void onResponse(Call<GetPostRespon> call, Response<GetPostRespon> response) {
                GetPostRespon getPostRespon = response.body();

                if (response.isSuccessful()){

                    adapterGetData = new AdapterGetData(datumList);
                    recyclerView.setAdapter(adapterGetData);
                   // adapterGetData.notifyDataSetChanged();


                }
            }

            @Override
            public void onFailure(Call<GetPostRespon> call,@Nullable Throwable t) {
                assert t != null;
                Log.e(GetData.class.getSimpleName(), Objects.requireNonNull(t.getLocalizedMessage()));
                t.printStackTrace();
            }
        });

    }

}
