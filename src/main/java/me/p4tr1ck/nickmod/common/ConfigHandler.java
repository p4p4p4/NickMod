package me.p4tr1ck.nickmod.common;

import java.io.File;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

public class ConfigHandler {

	/* NickMod by p4tr1ck */
	
    public static File saveFile;
	
    public static void saveSettings() {
        Configuration config = new Configuration(saveFile);
        updateSettings(config, true);
        config.save();
    }

    public static void loadSettings() {
        Configuration config = new Configuration(saveFile);
        config.load();
        updateSettings(config, false);
    }
    
    private static void updateSettings(Configuration config, boolean save) {
        Property prop = config.get("NickMod", "nickname", "ConfigNickname");
        
        if (save) {
            prop.set(NameChanger.nickname);
        }else {
            NameChanger.nickname = prop.getString();
        }

        prop = config.get("NickMod", "set", false);
        
        if (save) {
            prop.set(NameChanger.set);
        }else {
            NameChanger.set = prop.getBoolean();
        }
    }
}
