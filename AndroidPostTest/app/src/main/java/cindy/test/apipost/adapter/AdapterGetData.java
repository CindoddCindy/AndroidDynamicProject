package cindy.test.apipost.adapter;

import android.content.Context;
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

    private Context context;
    private List<Datum> insertlist;
    //private List<PortDetailData> listportDetailData;


    public AdapterGetData(Context context, List<Datum> insertlist){
        this.context=context;
        this.insertlist=insertlist;
        // this.listportDetailData=listportDetailData;
        // layoutInflater=LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public GetDataChild onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.getdataadapter, parent, false);
        GetDataChild mViewHolder = new GetDataChild(mView);

        // KucingChildAdapter viewHolder = new KucingChildAdapter(layoutInflater.inflate(R.layout.meow_adapter, viewGroup, false));
        return mViewHolder;

        //return null;
    }

    @Override
    public void onBindViewHolder(@NonNull GetDataChild holder, int position) {
        final  Datum datum = insertlist.get(position);

        holder.textView_getData.setText(datum.getData());//.getPortName());
        // holder.textView_ambil_port_id.setText(listPortData.getIdPort());


    }

    @Override
    public int getItemCount() {
        return insertlist.size();
        //return 0;
    }

    public class GetDataChild extends RecyclerView.ViewHolder{

        TextView textView_getData;

        public GetDataChild(@NonNull View itemView) {
            super(itemView);
            textView_getData=itemView.findViewById(R.id.tv_get_data);
        }
    }
}
