package cindy.test.apipost.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import cindy.test.apipost.GetData;
import cindy.test.apipost.R;
import cindy.test.apipost.pojo.Datum;

public class AdapterGetData extends RecyclerView.Adapter<AdapterGetData.GetDataChild> {

    private List<Datum> insertList;
    //private List<PortDetailData> listportDetailData;

    private String context;


    public AdapterGetData(GetData getData, List<Datum> insertList){
        this.insertList = insertList;
        //this.context=context;
        // this.listportDetailData=listportDetailData;
        // layoutInflater=LayoutInflater.from(context);
    }



    @NonNull
    @Override
    public GetDataChild onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.getdataadapter, parent, false);
        return new GetDataChild(view);


        }

    @Override
    public void onBindViewHolder(@NonNull GetDataChild holder, int position) {
        final Datum datum = insertList.get(position);

        holder.textView_nama.setText(datum.getName());
        holder.textView_email.setText(datum.getEmail());
        holder.textView_password.setText(datum.getPassword());
        holder.textView_data.setText(datum.getData());
        holder.textView_created.setText(datum.getCreatedAt());
        holder.textView_updated.setText(datum.getUpdatedAt());
        //.getPortName());
        // holder.textView_ambil_port_id.setText(listPortData.getIdPort());


    }

    @Override
    public int getItemCount() {
        return insertList.size();
        //return 0;
    }

    class GetDataChild extends RecyclerView.ViewHolder{

        TextView textView_nama, textView_email, textView_password, textView_data,textView_created, textView_updated;

        GetDataChild(@NonNull View itemView) {
            super(itemView);
            textView_nama=itemView.findViewById(R.id.tv_get_nama);
            textView_email=itemView.findViewById(R.id.tv_get_email);
            textView_password=itemView.findViewById(R.id.tv_get_password);
            textView_data=itemView.findViewById(R.id.tv_get_dataa);
            textView_created=itemView.findViewById(R.id.tv_get_create);
            textView_updated=itemView.findViewById(R.id.tv_get_update);
        }
    }
}
