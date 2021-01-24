package me.p4tr1ck.nickmod.common;

import me.p4tr1ck.nickmod.NickMod;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.client.event.ClientChatReceivedEvent;

public class NameChanger {

	/* NickMod by p4tr1ck */
	
    public static Boolean set = false;
    public static String nickname;
    
	public static void changeNames(ClientChatReceivedEvent event) {
		
    	String message = event.message.getFormattedText(); 
    	
    	if(set) {
    		message = message.replaceAll("(?i)" + Minecraft.getMinecraft().thePlayer.getName(), nickname);
    		Minecraft.getMinecraft().thePlayer.addChatComponentMessage(new ChatComponentText(message));
    		event.setCanceled(true);
    	}
	}
}
