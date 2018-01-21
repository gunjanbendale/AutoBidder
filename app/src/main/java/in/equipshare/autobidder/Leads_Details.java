package in.equipshare.autobidder;

/**
 * Created by Gunjan Bendale on 21-01-2018.
 */
public class Leads_Details {
    String Name;
    String Buy;
    String Contact;
    String NextTime;

    public Leads_Details(String name, String buy, String contact, String nextTime) {
        Name = name;
        Buy = buy;
        Contact = contact;
        NextTime = nextTime;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getBuy() {
        return Buy;
    }

    public void setBuy(String buy) {
        Buy = buy;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String contact) {
        Contact = contact;
    }

    public String getNextTime() {
        return NextTime;
    }

    public void setNextTime(String nextTime) {
        NextTime = nextTime;
    }
}
