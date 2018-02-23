package in.equipshare.autobidder.model;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Data implements Parcelable
{

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("category")
    @Expose
    private Integer category;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("wallet")
    @Expose
    private Integer wallet;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("resetPasswordToken")
    @Expose
    private Object resetPasswordToken;
    @SerializedName("resetPasswordExpire")
    @Expose
    private String resetPasswordExpire;
    @SerializedName("mobile")
    @Expose
    private String mobile;
    @SerializedName("last_name")
    @Expose
    private String lastName;
    @SerializedName("first_name")
    @Expose
    private String firstName;
    @SerializedName("middle_name")
    @Expose
    private String middleName;
    @SerializedName("altmobile")
    @Expose
    private Object altmobile;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("zipcode")
    @Expose
    private String zipcode;
    @SerializedName("pan_number")
    @Expose
    private String panNumber;
    public final static Parcelable.Creator<Data> CREATOR = new Creator<Data>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Data createFromParcel(Parcel in) {
            return new Data(in);
        }

        public Data[] newArray(int size) {
            return (new Data[size]);
        }

    }
            ;

    protected Data(Parcel in) {
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.password = ((String) in.readValue((String.class.getClassLoader())));
        this.category = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.email = ((String) in.readValue((String.class.getClassLoader())));
        this.wallet = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.address = ((String) in.readValue((String.class.getClassLoader())));
        this.resetPasswordToken = ((Object) in.readValue((Object.class.getClassLoader())));
        this.resetPasswordExpire = ((String) in.readValue((String.class.getClassLoader())));
        this.mobile = ((String) in.readValue((String.class.getClassLoader())));
        this.lastName = ((String) in.readValue((String.class.getClassLoader())));
        this.firstName = ((String) in.readValue((String.class.getClassLoader())));
        this.middleName = ((String) in.readValue((String.class.getClassLoader())));
        this.altmobile = ((Object) in.readValue((Object.class.getClassLoader())));
        this.city = ((String) in.readValue((String.class.getClassLoader())));
        this.state = ((String) in.readValue((String.class.getClassLoader())));
        this.country = ((String) in.readValue((String.class.getClassLoader())));
        this.zipcode = ((String) in.readValue((String.class.getClassLoader())));
        this.panNumber = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public Data() {
    }

    /**
     *
     * @param middleName
     * @param lastName
     * @param zipcode
     * @param state
     * @param panNumber
     * @param password
     * @param wallet
     * @param country
     * @param city
     * @param id
     * @param resetPasswordExpire
     * @param category
     * @param resetPasswordToken
     * @param email
     * @param address
     * @param altmobile
     * @param firstName
     * @param mobile
     */
    public Data(Integer id, String password, Integer category, String email, Integer wallet, String address, Object resetPasswordToken, String resetPasswordExpire, String mobile, String lastName, String firstName, String middleName, Object altmobile, String city, String state, String country, String zipcode, String panNumber) {
        super();
        this.id = id;
        this.password = password;
        this.category = category;
        this.email = email;
        this.wallet = wallet;
        this.address = address;
        this.resetPasswordToken = resetPasswordToken;
        this.resetPasswordExpire = resetPasswordExpire;
        this.mobile = mobile;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.altmobile = altmobile;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zipcode = zipcode;
        this.panNumber = panNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getWallet() {
        return wallet;
    }

    public void setWallet(Integer wallet) {
        this.wallet = wallet;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Object getResetPasswordToken() {
        return resetPasswordToken;
    }

    public void setResetPasswordToken(Object resetPasswordToken) {
        this.resetPasswordToken = resetPasswordToken;
    }

    public String getResetPasswordExpire() {
        return resetPasswordExpire;
    }

    public void setResetPasswordExpire(String resetPasswordExpire) {
        this.resetPasswordExpire = resetPasswordExpire;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Object getAltmobile() {
        return altmobile;
    }

    public void setAltmobile(Object altmobile) {
        this.altmobile = altmobile;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getPanNumber() {
        return panNumber;
    }

    public void setPanNumber(String panNumber) {
        this.panNumber = panNumber;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(password);
        dest.writeValue(category);
        dest.writeValue(email);
        dest.writeValue(wallet);
        dest.writeValue(address);
        dest.writeValue(resetPasswordToken);
        dest.writeValue(resetPasswordExpire);
        dest.writeValue(mobile);
        dest.writeValue(lastName);
        dest.writeValue(firstName);
        dest.writeValue(middleName);
        dest.writeValue(altmobile);
        dest.writeValue(city);
        dest.writeValue(state);
        dest.writeValue(country);
        dest.writeValue(zipcode);
        dest.writeValue(panNumber);
    }

    public int describeContents() {
        return 0;
    }

}