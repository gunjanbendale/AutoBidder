package in.equipshare.autobidder;


public class Equipments {
    String equipimage;
    String equipname;
    String equiplikes;
    String equipstatus;


    public Equipments(String equipimage, String equipname, String equiplikes, String equipstatus) {
        this.equipimage = equipimage;
        this.equipname = equipname;
        this.equiplikes = equiplikes;
        this.equipstatus = equipstatus;
    }

    public String getEquipimage() {
        return equipimage;
    }

    public void setEquipimage(String equipimage) {
        this.equipimage = equipimage;
    }

    public String getEquipname() {
        return equipname;
    }

    public void setEquipname(String equipname) {
        this.equipname = equipname;
    }

    public String getEquiplikes() {
        return equiplikes;
    }

    public void setEquiplikes(String equiplikes) {
        this.equiplikes = equiplikes;
    }

    public String getEquipstatus() {
        return equipstatus;
    }

    public void setEquipstatus(String equipstatus) {
        this.equipstatus = equipstatus;
    }
}
