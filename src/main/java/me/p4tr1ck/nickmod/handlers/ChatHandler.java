package me.p4tr1ck.nickmod.handlers;

import me.p4tr1ck.nickmod.utils.NameAndColorUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.client.event.ClientChatReceivedEvent;

public class ChatHandler {

	/* NickMod by p4tr1ck */
	
	public static void editChat(ClientChatReceivedEvent event) {
    	String message = event.message.getFormattedText(); 
    	
		if(NameAndColorUtils.setColor && NameAndColorUtils.setNickname) {
    		if(NameAndColorUtils.color.equalsIgnoreCase("BLACK")) {
	    		message = message.replaceAll("(?i)" + Minecraft.getMinecraft().thePlayer.getName(), EnumChatFormatting.BLACK + NameAndColorUtils.nickname);
    		}else if(NameAndColorUtils.color.equalsIgnoreCase("DARK_BLUE")) {
        		message = message.replaceAll("(?i)" + Minecraft.getMinecraft().thePlayer.getName(), EnumChatFormatting.DARK_BLUE + NameAndColorUtils.nickname);
    		}else if(NameAndColorUtils.color.equalsIgnoreCase("DARK_GREEN")) {
        		message = message.replaceAll("(?i)" + Minecraft.getMinecraft().thePlayer.getName(), EnumChatFormatting.DARK_GREEN + NameAndColorUtils.nickname);
    		}else if(NameAndColorUtils.color.equalsIgnoreCase("DARK_AQUA")) {
        		message = message.replaceAll("(?i)" + Minecraft.getMinecraft().thePlayer.getName(), EnumChatFormatting.DARK_AQUA + NameAndColorUtils.nickname);
    		}else if(NameAndColorUtils.color.equalsIgnoreCase("DARK_RED")) {
        		message = message.replaceAll("(?i)" + Minecraft.getMinecraft().thePlayer.getName(), EnumChatFormatting.DARK_RED + NameAndColorUtils.nickname);
    		}else if(NameAndColorUtils.color.equalsIgnoreCase("DARK_PURPLE")) {
        		message = message.replaceAll("(?i)" + Minecraft.getMinecraft().thePlayer.getName(), EnumChatFormatting.DARK_PURPLE + NameAndColorUtils.nickname);
    		}else if(NameAndColorUtils.color.equalsIgnoreCase("GOLD")) {
        		message = message.replaceAll("(?i)" + Minecraft.getMinecraft().thePlayer.getName(), EnumChatFormatting.GOLD + NameAndColorUtils.nickname);
    		}else if(NameAndColorUtils.color.equalsIgnoreCase("GRAY")) {
        		message = message.replaceAll("(?i)" + Minecraft.getMinecraft().thePlayer.getName(), EnumChatFormatting.GRAY + NameAndColorUtils.nickname);
    		}else if(NameAndColorUtils.color.equalsIgnoreCase("DARK_GRAY")) {
        		message = message.replaceAll("(?i)" + Minecraft.getMinecraft().thePlayer.getName(), EnumChatFormatting.DARK_GRAY + NameAndColorUtils.nickname);
    		}else if(NameAndColorUtils.color.equalsIgnoreCase("BLUE")) {
        		message = message.replaceAll("(?i)" + Minecraft.getMinecraft().thePlayer.getName(), EnumChatFormatting.BLUE + NameAndColorUtils.nickname);
    		}else if(NameAndColorUtils.color.equalsIgnoreCase("GREEN")) {
        		message = message.replaceAll("(?i)" + Minecraft.getMinecraft().thePlayer.getName(), EnumChatFormatting.GREEN + NameAndColorUtils.nickname);
    		}else if(NameAndColorUtils.color.equalsIgnoreCase("AQUA")) {
        		message = message.replaceAll("(?i)" + Minecraft.getMinecraft().thePlayer.getName(), EnumChatFormatting.AQUA + NameAndColorUtils.nickname);
    		}else if(NameAndColorUtils.color.equalsIgnoreCase("RED")) {
        		message = message.replaceAll("(?i)" + Minecraft.getMinecraft().thePlayer.getName(), EnumChatFormatting.RED + NameAndColorUtils.nickname);
    		}else if(NameAndColorUtils.color.equalsIgnoreCase("LIGHT_PURPLE")) {
        		message = message.replaceAll("(?i)" + Minecraft.getMinecraft().thePlayer.getName(), EnumChatFormatting.LIGHT_PURPLE + NameAndColorUtils.nickname);
    		}else if(NameAndColorUtils.color.equalsIgnoreCase("YELLOW")) {
        		message = message.replaceAll("(?i)" + Minecraft.getMinecraft().thePlayer.getName(), EnumChatFormatting.YELLOW + NameAndColorUtils.nickname);
    		}
		}else if(NameAndColorUtils.setColor && !NameAndColorUtils.setNickname) {
    		if(NameAndColorUtils.color.equalsIgnoreCase("BLACK")) {
	    		message = message.replaceAll("(?i)" + Minecraft.getMinecraft().thePlayer.getName(), EnumChatFormatting.BLACK + Minecraft.getMinecraft().thePlayer.getName());
    		}else if(NameAndColorUtils.color.equalsIgnoreCase("DARK_BLUE")) {
        		message = message.replaceAll("(?i)" + Minecraft.getMinecraft().thePlayer.getName(), EnumChatFormatting.DARK_BLUE + Minecraft.getMinecraft().thePlayer.getName());
    		}else if(NameAndColorUtils.color.equalsIgnoreCase("DARK_GREEN")) {
        		message = message.replaceAll("(?i)" + Minecraft.getMinecraft().thePlayer.getName(), EnumChatFormatting.DARK_GREEN + Minecraft.getMinecraft().thePlayer.getName());
    		}else if(NameAndColorUtils.color.equalsIgnoreCase("DARK_AQUA")) {
        		message = message.replaceAll("(?i)" + Minecraft.getMinecraft().thePlayer.getName(), EnumChatFormatting.DARK_AQUA + Minecraft.getMinecraft().thePlayer.getName());
    		}else if(NameAndColorUtils.color.equalsIgnoreCase("DARK_RED")) {
        		message = message.replaceAll("(?i)" + Minecraft.getMinecraft().thePlayer.getName(), EnumChatFormatting.DARK_RED + Minecraft.getMinecraft().thePlayer.getName());
    		}else if(NameAndColorUtils.color.equalsIgnoreCase("DARK_PURPLE")) {
        		message = message.replaceAll("(?i)" + Minecraft.getMinecraft().thePlayer.getName(), EnumChatFormatting.DARK_PURPLE + Minecraft.getMinecraft().thePlayer.getName());
    		}else if(NameAndColorUtils.color.equalsIgnoreCase("GOLD")) {
        		message = message.replaceAll("(?i)" + Minecraft.getMinecraft().thePlayer.getName(), EnumChatFormatting.GOLD + Minecraft.getMinecraft().thePlayer.getName());
    		}else if(NameAndColorUtils.color.equalsIgnoreCase("GRAY")) {
        		message = message.replaceAll("(?i)" + Minecraft.getMinecraft().thePlayer.getName(), EnumChatFormatting.GRAY + Minecraft.getMinecraft().thePlayer.getName());
    		}else if(NameAndColorUtils.color.equalsIgnoreCase("DARK_GRAY")) {
        		message = message.replaceAll("(?i)" + Minecraft.getMinecraft().thePlayer.getName(), EnumChatFormatting.DARK_GRAY + Minecraft.getMinecraft().thePlayer.getName());
    		}else if(NameAndColorUtils.color.equalsIgnoreCase("BLUE")) {
        		message = message.replaceAll("(?i)" + Minecraft.getMinecraft().thePlayer.getName(), EnumChatFormatting.BLUE + Minecraft.getMinecraft().thePlayer.getName());
    		}else if(NameAndColorUtils.color.equalsIgnoreCase("GREEN")) {
        		message = message.replaceAll("(?i)" + Minecraft.getMinecraft().thePlayer.getName(), EnumChatFormatting.GREEN + Minecraft.getMinecraft().thePlayer.getName());
    		}else if(NameAndColorUtils.color.equalsIgnoreCase("AQUA")) {
        		message = message.replaceAll("(?i)" + Minecraft.getMinecraft().thePlayer.getName(), EnumChatFormatting.AQUA + Minecraft.getMinecraft().thePlayer.getName());
    		}else if(NameAndColorUtils.color.equalsIgnoreCase("RED")) {
        		message = message.replaceAll("(?i)" + Minecraft.getMinecraft().thePlayer.getName(), EnumChatFormatting.RED + Minecraft.getMinecraft().thePlayer.getName());
    		}else if(NameAndColorUtils.color.equalsIgnoreCase("LIGHT_PURPLE")) {
        		message = message.replaceAll("(?i)" + Minecraft.getMinecraft().thePlayer.getName(), EnumChatFormatting.LIGHT_PURPLE + Minecraft.getMinecraft().thePlayer.getName());
    		}else if(NameAndColorUtils.color.equalsIgnoreCase("YELLOW")) {
        		message = message.replaceAll("(?i)" + Minecraft.getMinecraft().thePlayer.getName(), EnumChatFormatting.YELLOW + Minecraft.getMinecraft().thePlayer.getName());
    		}
		}else if(!NameAndColorUtils.setColor && NameAndColorUtils.setNickname) {
    		message = message.replaceAll("(?i)" + Minecraft.getMinecraft().thePlayer.getName(), NameAndColorUtils.nickname);
    	}
		
		Minecraft.getMinecraft().thePlayer.addChatComponentMessage(new ChatComponentText(message));
		event.setCanceled(true);
	}
	
}
