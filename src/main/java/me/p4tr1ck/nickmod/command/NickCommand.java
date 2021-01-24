package me.p4tr1ck.nickmod.command;

import java.util.Collections;
import java.util.List;

import com.google.common.collect.ImmutableList;

import me.p4tr1ck.nickmod.common.ConfigHandler;
import me.p4tr1ck.nickmod.common.NameChanger;
import me.p4tr1ck.nickmod.common.Sender;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.BlockPos;
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
			return getListOfStringsMatchingLastWord(args, "set", "reset");
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
						NameChanger.set = false;
						NameChanger.nickname = Minecraft.getMinecraft().thePlayer.getName();
						Sender.sendMessage("Your nickname was reset.");
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
						if(!args[1].equals(NameChanger.nickname)) {
							NameChanger.set = true;
							NameChanger.nickname = args[1];
							Sender.sendMessage("Your nickname has been set to " + EnumChatFormatting.YELLOW + NameChanger.nickname + EnumChatFormatting.GRAY + ".");
							ConfigHandler.saveSettings();
						}else {
							Sender.sendMessage("That is already your nickname!");
						}
					}
				}
				break;
		}
	}
}
