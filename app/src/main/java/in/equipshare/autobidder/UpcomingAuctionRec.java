package in.equipshare.autobidder;

public class UpcomingAuctionRec {
    String auction_image;
    String auction_id;
    String auction_equip;
    String auction_basebid;
    String auction_currentbid;

    public UpcomingAuctionRec(String auction_image, String auction_id, String auction_equip, String auction_basebid,String auction_currentbid) {
        this.auction_image = auction_image;
        this.auction_id = auction_id;

        this.auction_equip = auction_equip;
        this.auction_basebid = auction_basebid;
        this.auction_currentbid = auction_currentbid;
    }

    public String getAuction_currentbid() {
        return auction_currentbid;
    }

    public void setAuction_currentbid(String auction_currentbid) {
        this.auction_currentbid = auction_currentbid;
    }

    public String getAuction_image() {
        return auction_image;
    }

    public void setAuction_image(String auction_image) {
        this.auction_image = auction_image;
    }

    public String getAuction_id() {
        return auction_id;
    }

    public void setAuction_id(String auction_id) {
        this.auction_id = auction_id;
    }

    public String getAuction_equip() {
        return auction_equip;
    }

    public void setAuction_equip(String auction_equip) {
        this.auction_equip = auction_equip;
    }

    public String getAuction_basebid() {
        return auction_basebid;
    }

    public void setAuction_basebid(String auction_basebid) {
        this.auction_basebid = auction_basebid;
    }
}
