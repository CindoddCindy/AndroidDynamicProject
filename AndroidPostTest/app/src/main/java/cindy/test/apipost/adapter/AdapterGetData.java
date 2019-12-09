package cindy.test.apipost.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import cindy.test.apipost.R;
import cindy.test.apipost.pojo.Datum;

public class AdapterGetData extends RecyclerView.Adapter<AdapterGetData.GetDataChild> {

    private List<Datum> insertList;
    //private List<PortDetailData> listportDetailData;


    public AdapterGetData(List<Datum> insertList){
        this.insertList = insertList;
        // this.listportDetailData=listportDetailData;
        // layoutInflater=LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public GetDataChild onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.getdataadapter, parent, false);

        return new GetDataChild(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull GetDataChild holder, int position) {
        final  Datum datum = insertList.get(position);

        holder.textView_getData.setText(datum.getData());//.getPortName());
        // holder.textView_ambil_port_id.setText(listPortData.getIdPort());


    }

    @Override
    public int getItemCount() {
        return insertList.size();
        //return 0;
    }

    class GetDataChild extends RecyclerView.ViewHolder{

        TextView textView_getData;

        GetDataChild(@NonNull View itemView) {
            super(itemView);
            textView_getData=itemView.findViewById(R.id.tv_get_data);
        }
    }
}
