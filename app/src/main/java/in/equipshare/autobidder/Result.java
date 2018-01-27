package in.equipshare.autobidder;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class Result implements Parcelable{
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("msg")
    @Expose
    private String message;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(message);

    }
    public Result(){

    }
    protected Result(Parcel in){
        this.name=in.readString();
        this.message=in.readString();
    }

    public static final Parcelable.Creator<Result> CREATOR = new Parcelable.Creator<Result>(){
        @Override
        public Result createFromParcel(Parcel source){
            return new Result(source);
        }
        @Override
        public Result[] newArray(int size){
            return new Result[size];
        }
    };

}
