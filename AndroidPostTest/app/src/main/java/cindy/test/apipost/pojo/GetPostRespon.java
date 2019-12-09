package cindy.test.apipost.pojo;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetPostRespon {

    @SerializedName("data")
    @Expose
    private List<Datum> data = null;
    @SerializedName("page")
    @Expose
    private Double page;

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    public Double getPage() {
        return page;
    }

    public void setPage(Double page) {
        this.page = page;
    }

}
