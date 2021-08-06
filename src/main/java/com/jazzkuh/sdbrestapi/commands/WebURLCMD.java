package com.jazzkuh.sdbrestapi.commands;

import com.jazzkuh.sdbrestapi.Main;
import com.jazzkuh.sdbrestapi.utils.Utils;
import com.jazzkuh.sdbrestapi.utils.command.AbstractCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.List;

public class WebURLCMD extends AbstractCommand {

    public WebURLCMD() {
        super("weburl");
    }

    @Override
    public void execute(CommandSender sender, Command command, String label, String[] args) {
        if (!senderIsPlayer()) return;
        if (!hasPermission(getBasePermission(), false)) return;

        Utils.sendMessage(sender, "&3Klik op deze link om de &bMinetopiaSDB-RestAPI&3 van jou te bezoeken: &bhttp://"
                + Utils.getServerIP() + ":" + Main.getInstance().getConfig().getInt("webserver.port")
                + "/api/player/" + sender.getName() + "&3.");
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        return null;
    }
}
