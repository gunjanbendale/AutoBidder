package in.equipshare.autobidder;

import net.steamcrafted.materialiconlib.MaterialDrawableBuilder;

/**
 * Created by Gunjan Bendale on 16-01-2018.
 */

public class MenuItems {
    String menuname;
    MaterialDrawableBuilder.IconValue menulgo;


    public MenuItems(String menuname, MaterialDrawableBuilder.IconValue menulgo) {
        this.menuname = menuname;
        this.menulgo = menulgo;
    }

    public String getMenuname() {
        return menuname;
    }

    public void setMenuname(String menuname) {
        this.menuname = menuname;
    }

    public MaterialDrawableBuilder.IconValue getMenulgo() {
        return menulgo;
    }

    public void setMenulgo(MaterialDrawableBuilder.IconValue menulgo) {
        this.menulgo = menulgo;
    }
}
