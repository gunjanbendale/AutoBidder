package in.equipshare.autobidder;

import net.steamcrafted.materialiconlib.MaterialDrawableBuilder;

/**
 * Created by Gunjan Bendale on 27-01-2018.
 */

public class CarProfileItems {
    String id;
    String value;
    MaterialDrawableBuilder.IconValue icon;

    public CarProfileItems(String id, String value, MaterialDrawableBuilder.IconValue icon) {
        this.id = id;
        this.value = value;
        this.icon = icon;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public MaterialDrawableBuilder.IconValue getIcon() {
        return icon;
    }

    public void setIcon(MaterialDrawableBuilder.IconValue icon) {
        this.icon = icon;
    }
}
