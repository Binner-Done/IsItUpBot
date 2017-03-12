package com.binnerdone.isitup;

import com.walshydev.jba.commands.Command;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.entities.User;

import java.awt.*;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Jack on 12/03/2017.
 */
public class PingCommand implements Command {

    @Override
    public void onCommand(User user, TextChannel textChannel, Message message, String[] strings, Member member) {
        textChannel.sendMessage(new EmbedBuilder()
                .setAuthor(user.getName(), null, user.getEffectiveAvatarUrl())
                .setDescription("Pong! \uD83C\uDFD3")
                .setColor(new Color(0,143,255))
                .build())
                .queue();
    }

    @Override
    public String getCommand() {
        return "ping";
    }

    @Override
    public String getDescription() {
        return "Pong!";
    }
}
