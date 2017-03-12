package com.binnerdone.isitup;

import com.walshydev.jba.commands.Command;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.entities.User;

import javax.net.ssl.HttpsURLConnection;
import java.awt.*;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 * Created by Jack on 12/03/2017.
 */
public class StatusCommand implements Command {
    @Override
    public void onCommand(User user, TextChannel textChannel, Message message, String[] args, Member member) {
        message.delete();
        final String WEBSITE = new String (args[0]);
        if(WEBSITE.contains("http://") || WEBSITE.contains("https://")){
            textChannel.sendMessage(new EmbedBuilder()
                    // A good thing to use for this is  ".setAuthor(sender.getName(), null, sender.getEffectiveAvatarUrl())", as that adds the username of the user, and their avatar.
                    .setAuthor(user.getName(), null, user.getEffectiveAvatarUrl())
                    // In this case, you'll wanna say "Pong!", so you add the user.getAsMention() + " Pong!"
                    .setDescription("Please input an address without http:// or https://")
                    // You can also add a colour, e.g., Color.red to make the embed red. You should be asked to import java.awt.* if you use Color.(colour name), which is fine.
                    .setColor(Color.YELLOW)
                    // Another thing you can do is .addField, which I don't suggest doing for this. It would be useful for e.g. a profile command if you have a bot that uses mysql, but not for this purpose. I'll show a message with it later.
                    // And finally, you end the EmbedBuilder() off with .build() to build it, with an extra ) on the end to finalize the message.
                    .build())
                    // As always, add your .queue() to your message.
                    .queue();
            return;

        }
        try {
            URL u = new URL("https://" + args[0]);

            HttpsURLConnection huc = (HttpsURLConnection) u.openConnection();
            huc.setRequestMethod("GET");  //OR  huc.setRequestMethod ("HEAD");
            huc.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");
            huc.connect();
            int code = huc.getResponseCode();
            System.out.println(code);
            if(code != 200){
                textChannel.sendMessage(new EmbedBuilder()
                        // A good thing to use for this is  ".setAuthor(sender.getName(), null, sender.getEffectiveAvatarUrl())", as that adds the username of the user, and their avatar.
                        .setAuthor(user.getName(), null, user.getEffectiveAvatarUrl())
                        // In this case, you'll wanna say "Pong!", so you add the user.getAsMention() + " Pong!"
                        .setDescription("Error Pinging " + args[0] + "! Error Code: " + code)
                        // You can also add a colour, e.g., Color.red to make the embed red. You should be asked to import java.awt.* if you use Color.(colour name), which is fine.
                        .setColor(Color.RED)
                        // Another thing you can do is .addField, which I don't suggest doing for this. It would be useful for e.g. a profile command if you have a bot that uses mysql, but not for this purpose. I'll show a message with it later.
                        // And finally, you end the EmbedBuilder() off with .build() to build it, with an extra ) on the end to finalize the message.
                        .build())
                        // As always, add your .queue() to your message.
                        .queue();
            }
            if(code == 200) {

                textChannel.sendMessage(new EmbedBuilder()
                        // A good thing to use for this is  ".setAuthor(sender.getName(), null, sender.getEffectiveAvatarUrl())", as that adds the username of the user, and their avatar.
                        .setAuthor(user.getName(), null, user.getEffectiveAvatarUrl())
                        // In this case, you'll wanna say "Pong!", so you add the user.getAsMention() + " Pong!"
                        .setDescription("Succesfully pinged " + args[0])
                        // You can also add a colour, e.g., Color.red to make the embed red. You should be asked to import java.awt.* if you use Color.(colour name), which is fine.
                        .setColor(Color.GREEN)
                        // Another thing you can do is .addField, which I don't suggest doing for this. It would be useful for e.g. a profile command if you have a bot that uses mysql, but not for this purpose. I'll show a message with it later.
                        // And finally, you end the EmbedBuilder() off with .build() to build it, with an extra ) on the end to finalize the message.
                        .build())
                        // As always, add your .queue() to your message.
                        .queue();
                return;
            }
        } catch (ProtocolException e) {
            textChannel.sendMessage(new EmbedBuilder()
                    // A good thing to use for this is  ".setAuthor(sender.getName(), null, sender.getEffectiveAvatarUrl())", as that adds the username of the user, and their avatar.
                    .setAuthor(user.getName(), null, user.getEffectiveAvatarUrl())
                    // In this case, you'll wanna say "Pong!", so you add the user.getAsMention() + " Pong!"
                    .setDescription("Error Pinging " + args[0])
                    // You can also add a colour, e.g., Color.red to make the embed red. You should be asked to import java.awt.* if you use Color.(colour name), which is fine.
                    .setColor(Color.RED)
                    // Another thing you can do is .addField, which I don't suggest doing for this. It would be useful for e.g. a profile command if you have a bot that uses mysql, but not for this purpose. I'll show a message with it later.
                    // And finally, you end the EmbedBuilder() off with .build() to build it, with an extra ) on the end to finalize the message.
                    .build())
                    // As always, add your .queue() to your message.
                    .queue();
            e.printStackTrace();
        } catch (MalformedURLException e) {
            textChannel.sendMessage(new EmbedBuilder()
                    // A good thing to use for this is  ".setAuthor(sender.getName(), null, sender.getEffectiveAvatarUrl())", as that adds the username of the user, and their avatar.
                    .setAuthor(user.getName(), null, user.getEffectiveAvatarUrl())
                    // In this case, you'll wanna say "Pong!", so you add the user.getAsMention() + " Pong!"
                    .setDescription("Error Pinging " + args[0])
                    // You can also add a colour, e.g., Color.red to make the embed red. You should be asked to import java.awt.* if you use Color.(colour name), which is fine.
                    .setColor(Color.RED)
                    // Another thing you can do is .addField, which I don't suggest doing for this. It would be useful for e.g. a profile command if you have a bot that uses mysql, but not for this purpose. I'll show a message with it later.
                    // And finally, you end the EmbedBuilder() off with .build() to build it, with an extra ) on the end to finalize the message.
                    .build())
                    // As always, add your .queue() to your message.
                    .queue();
        } catch (IOException e) {
            textChannel.sendMessage(new EmbedBuilder()
                    // A good thing to use for this is  ".setAuthor(sender.getName(), null, sender.getEffectiveAvatarUrl())", as that adds the username of the user, and their avatar.
                    .setAuthor(user.getName(), null, user.getEffectiveAvatarUrl())
                    // In this case, you'll wanna say "Pong!", so you add the user.getAsMention() + " Pong!"
                    .setDescription("Error Pinging " + args[0])
                    // You can also add a colour, e.g., Color.red to make the embed red. You should be asked to import java.awt.* if you use Color.(colour name), which is fine.
                    .setColor(Color.RED)
                    // Another thing you can do is .addField, which I don't suggest doing for this. It would be useful for e.g. a profile command if you have a bot that uses mysql, but not for this purpose. I'll show a message with it later.
                    // And finally, you end the EmbedBuilder() off with .build() to build it, with an extra ) on the end to finalize the message.
                    .build())
                    // As always, add your .queue() to your message.
                    .queue();
        }
    }



    @Override
    public String getCommand() {
        return "Status";
    }

    @Override
    public String getDescription() {
        return "Checks A URL of your choice";
    }
}
