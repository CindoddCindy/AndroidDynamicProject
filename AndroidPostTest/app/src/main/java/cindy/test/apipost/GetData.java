package cindy.test.apipost;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

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
    AdapterGetData adapterGetData;// nearbyFacilitiesAdapter ;
    //String datumList  = new String();
    List<Datum> datumList = new ArrayList<>();

    RetrofitUrl retrofitUrl ;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_data);

        recyclerView = findViewById(R.id.get_data_rv);
        // nearbyFacilitiesAdapter = new NearbyFacilitiesAdapter(NearbyFacilitiesActivity.this,dataNearbies);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(GetData.this);
        recyclerView.setLayoutManager(linearLayoutManager);
        //

        getDataInsert();
    }

    public void getDataInsert(){

        RetrofitInter retrofitInter  = RetrofitUrl.getRetrofit().create(RetrofitInter.class);
        Call<GetPostRespon> detailResponseCalls = retrofitInter.getDataInsert();//.getNearbyFacilities(portid);
        detailResponseCalls.enqueue(new Callback<GetPostRespon>() {
            @Override
            public void onResponse(Call<GetPostRespon> call, Response<GetPostRespon> response) {
                //PortDetailResponse portDetailResponse = response.body();
                GetPostRespon getPostRespon = response.body();
                //PortDetailData portDetailData=portDetailResponse.getData();

              //  Datum datum = (Datum) getPostRespon.getData();


                if (response.isSuccessful()){
                    //dataNearbies= portDetailData.getDataNearby();
                    //datumList=datum.getData();
                    adapterGetData = new AdapterGetData(GetData.this, datumList);
                    recyclerView.setAdapter(adapterGetData);


                }


            }

            @Override
            public void onFailure(Call<GetPostRespon> call, Throwable t) {

            }
        });






    }

}
