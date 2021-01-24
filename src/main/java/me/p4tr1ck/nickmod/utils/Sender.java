package me.p4tr1ck.nickmod.utils;

import me.p4tr1ck.nickmod.NickMod;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

public class Sender {
	
	/* NickMod by p4tr1ck */

    public static String cmdPrefix = EnumChatFormatting.GOLD + "[" + NickMod.NAME + "] " + EnumChatFormatting.GRAY;
	public static String modDesc = EnumChatFormatting.GOLD + NickMod.NAME + EnumChatFormatting.GRAY + " is a simple mod that allows you to change your name in the chat.";
	public static String modUsage =  "Usage: /nickmod set [nickname] | /nickmod color [color] | /nickmod reset";
	
    public static void sendMessage(String message) {
    	Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(cmdPrefix + message));
    }
	
    public static void sendModInfo() {
    	Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(cmdPrefix + modDesc));
    	Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(cmdPrefix + modUsage));
    }
    
}
