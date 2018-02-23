package in.equipshare.autobidder.model;


import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import in.equipshare.autobidder.model.Data;

public class DealerProfile implements Parcelable
{

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("data")
    @Expose
    private Data data;
    public final static Parcelable.Creator<DealerProfile> CREATOR = new Creator<DealerProfile>() {


        @SuppressWarnings({
                "unchecked"
        })
        public DealerProfile createFromParcel(Parcel in) {
            return new DealerProfile(in);
        }

        public DealerProfile[] newArray(int size) {
            return (new DealerProfile[size]);
        }

    }
            ;

    protected DealerProfile(Parcel in) {
        this.status = ((String) in.readValue((String.class.getClassLoader())));
        this.data = ((Data) in.readValue((Data.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public DealerProfile() {
    }

    /**
     *
     * @param status
     * @param data
     */
    public DealerProfile(String status, Data data) {
        super();
        this.status = status;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }



    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(status);
        dest.writeValue(data);
    }

    public int describeContents() {
        return 0;
    }

}