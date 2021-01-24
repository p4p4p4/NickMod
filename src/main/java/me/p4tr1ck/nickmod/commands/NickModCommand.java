package me.p4tr1ck.nickmod.commands;

import java.util.Collections;
import java.util.List;

import com.google.common.collect.ImmutableList;

import me.p4tr1ck.nickmod.handlers.ChatHandler;
import me.p4tr1ck.nickmod.handlers.ConfigHandler;
import me.p4tr1ck.nickmod.utils.NameAndColorUtils;
import me.p4tr1ck.nickmod.utils.Sender;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumChatFormatting;

public class NickModCommand extends CommandBase{

	/* NickMod by p4tr1ck */

	@Override
	public String getCommandName() {
		return "nickmod";
	}

	@Override
	public String getCommandUsage(ICommandSender sender) {
		return "/nickmod set [nickname] | /nickmod color [color] | /nickmod reset";
	}
	
    @Override
    public List<String> getCommandAliases() {
        return ImmutableList.of("nm");
    }
	
	@Override
	public int getRequiredPermissionLevel() {
		return -1;
	}

	@Override
	public List<String> addTabCompletionOptions(final ICommandSender sender, final String[] args, final BlockPos pos) {
		switch (args.length) {
		case 1:
			return getListOfStringsMatchingLastWord(args, "set", "color", "reset");
		case 2:
			switch(args[0]){
				case "color":
					return getListOfStringsMatchingLastWord(args, "BLACK", "DARK_BLUE", "DARK_GREEN", "DARK_AQUA",
							"DARK_RED", "DARK_PURPLE", "GOLD", "GRAY", "DARK_GRAY", "BLUE", "GREEN", "AQUA", "RED",
							"LIGHT_PURPLE", "YELLOW", "WHITE");
			}
		default:
		    return Collections.emptyList();
        	}
	}

	@Override
	public void processCommand(ICommandSender sender, String[] args) throws CommandException {
		int count = args.length;
		
		switch(args.length) {
			case 0:
				Sender.sendModInfo();
				break;
				
			case 1:
				switch(args[0]) {
					case "reset":
						NameAndColorUtils.setNickname = false;
						NameAndColorUtils.setColor = false;
						NameAndColorUtils.color = "";
						NameAndColorUtils.nickname = Minecraft.getMinecraft().thePlayer.getName();
						Sender.sendMessage("Your settings have been reset.");
						ConfigHandler.saveSettings();
						break;
				}
				break;
				
			case 2:
				switch(args[0]) {
				case "set":
					if(args[1].length() > 16) {
						Sender.sendMessage("Your nickname must be 16 characters or less.");
					}else {
						if(!args[1].equals(NameAndColorUtils.nickname)) {
							NameAndColorUtils.setNickname = true;
							NameAndColorUtils.nickname = args[1];
							Sender.sendMessage("Your nickname has been set to " + EnumChatFormatting.YELLOW + NameAndColorUtils.nickname + EnumChatFormatting.GRAY + ".");
							ConfigHandler.saveSettings();
						}else {
							Sender.sendMessage("That is already your nickname!");
						}
					}
					break;
					
				case "color":
					if(args[1].equalsIgnoreCase("BLACK") || args[1].equalsIgnoreCase("DARK_BLUE") || args[1].equalsIgnoreCase("DARK_GREEN") || args[1].equalsIgnoreCase("DARK_AQUA")
						|| args[1].equalsIgnoreCase("DARK_RED") || args[1].equalsIgnoreCase("DARK_PURPLE") || args[1].equalsIgnoreCase("GOLD") || args[1].equalsIgnoreCase("GRAY")
						|| args[1].equalsIgnoreCase("DARK_GRAY") || args[1].equalsIgnoreCase("BLUE") || args[1].equalsIgnoreCase("GREEN") || args[1].equalsIgnoreCase("AQUA")
						|| args[1].equalsIgnoreCase("RED") || args[1].equalsIgnoreCase("LIGHT_PURPLE") || args[1].equalsIgnoreCase("YELLOW") || args[1].equalsIgnoreCase("WHITE")) {
						NameAndColorUtils.setColor = true;
						NameAndColorUtils.color = args[1].toUpperCase();
						Sender.sendMessage("Your name's color has been set to " + EnumChatFormatting.YELLOW + NameAndColorUtils.color + EnumChatFormatting.GRAY + ".");
						ConfigHandler.saveSettings();
					}else {
						Sender.sendMessage("Color not found!");
					}
					break;
				}
				break;
		}
	}
}
