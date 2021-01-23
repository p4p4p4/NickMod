package me.p4tr1ck.nickmod.command;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import me.p4tr1ck.nickmod.NickMod;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

public class NickCommand extends CommandBase{

	/* NickMod by p4tr1ck */

	@Override
	public String getCommandName() {
		return "nickmod";
	}

	@Override
	public String getCommandUsage(ICommandSender sender) {
		return "/nickmod set [nickname] | /nickmod reset";
	}
	

	@Override
	public int getRequiredPermissionLevel() {
		return -1;
	}

	
	@Override
	public List<String> addTabCompletionOptions(final ICommandSender sender, final String[] args, final BlockPos pos) {
		switch (args.length) {
		case 1:
			return getListOfStringsMatchingLastWord(args, "set", "reset");
		default:
		    return Collections.emptyList();
        	}
	}

	@Override
	public void processCommand(ICommandSender sender, String[] args) throws CommandException {
		int count = args.length;
		
		if(count == 0) {
			sender.addChatMessage(new ChatComponentText(NickMod.cmdPrefix + "NickMod is a simple mod that allows you to change your nickname in the chat. Usage: /nickmod set [nickname] | /nickmod reset."));
			
		}else if(count > 2){
			sender.addChatMessage(new ChatComponentText(NickMod.cmdPrefix + "Too many arguments."));
		
		}else {
			
			/* Set */
			
			if(args[0].equalsIgnoreCase("set") && count == 2) {
				if(args[1].length() > 16) {
					sender.addChatMessage(new ChatComponentText(NickMod.cmdPrefix + "Your nickname must be 16 characters or less."));
				}else {
					NickMod.set = true;
					NickMod.nickname = args[1];
					sender.addChatMessage(new ChatComponentText(NickMod.cmdPrefix + "Your nickname has been set to " + NickMod.nickname + "."));
				}
			}else if(args[0].equalsIgnoreCase("set") && count < 2){
				sender.addChatMessage(new ChatComponentText(NickMod.cmdPrefix + "Not enough arguments."));
			}
			
			/* Reset */
			
			if(args[0].equalsIgnoreCase("reset")){
				NickMod.set = false;
				sender.addChatMessage(new ChatComponentText(NickMod.cmdPrefix + "Your nickname was reset."));
			}
		}
	}
}
