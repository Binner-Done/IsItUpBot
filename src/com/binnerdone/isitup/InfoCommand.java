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
public class InfoCommand implements Command {
    @Override
    public void onCommand(User user, TextChannel textChannel, Message message, String[] strings, Member member) {
        textChannel.sendMessage(new EmbedBuilder()
                .setAuthor("Is it Up?", null, user.getEffectiveAvatarUrl())
                .setDescription("\uD83D\uDCAC Created By: Binner_Done#7696 \n \uD83D\uDCBB Version: 0.0.0.1 \n \uD83D\uDCD5 Currently using JBA created by bwfcwalshy#1284")
                .setColor(new Color(30,30,100))
                .build())
                .queue();
    }

    @Override
    public String getCommand() {
        return "info";
    }

    @Override
    public String getDescription() {
        return "Information about the bot";
    }

}
