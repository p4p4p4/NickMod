package me.p4tr1ck.nickmod.handlers;

import java.io.File;

import me.p4tr1ck.nickmod.utils.NameAndColorUtils;
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
            prop.set(NameAndColorUtils.nickname);
        }else {
        	NameAndColorUtils.nickname = prop.getString();
        }
        
        prop = config.get("NickMod", "color", "ConfigColor");
        
        if (save) {
            prop.set(NameAndColorUtils.color);
        }else {
        	NameAndColorUtils.color = prop.getString();
        }

        prop = config.get("NickMod", "setNickname", false);
        
        if (save) {
            prop.set(NameAndColorUtils.setNickname);
        }else {
        	NameAndColorUtils.setNickname = prop.getBoolean();
        }
        
        prop = config.get("NickMod", "setColor", false);
        
        if (save) {
            prop.set(NameAndColorUtils.setColor);
        }else {
        	NameAndColorUtils.setColor = prop.getBoolean();
        }
    }
}
