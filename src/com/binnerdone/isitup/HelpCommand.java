package com.binnerdone.isitup;

import com.walshydev.jba.commands.Command;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.entities.User;

import java.awt.*;

/**
 * Created by Jack on 12/03/2017.
 */
public class HelpCommand implements Command {
    @Override
    public void onCommand(User user, TextChannel textChannel, Message message, String[] strings, Member member) {
        textChannel.sendMessage(new EmbedBuilder()
                .setAuthor(user.getName(), null, user.getEffectiveAvatarUrl())
                .setDescription("❔ Help \n *ping - Pings your connection to the bot \n *status {url} - Check the status of a website")
                .setColor(new Color(30,30,100))
                .build())
                .queue();
    }

    @Override
    public String getCommand() {
        return "help";
    }

    @Override
    public String getDescription() {
        return "Shows a list of commands";
    }
}
