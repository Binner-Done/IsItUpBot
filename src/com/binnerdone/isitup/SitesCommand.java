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
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 * Created by Jack on 12/03/2017.
 */
public class SitesCommand implements Command {
    @Override
    public void onCommand(User user, TextChannel textChannel, Message message, String[] strings, Member member) {
        Boolean site1 = false;
        Boolean site2 = false;
        Boolean site3 = false;

        try {
            URL u = new URL("https://www.flarebot.stream");

            HttpsURLConnection huc = (HttpsURLConnection) u.openConnection();
            huc.setRequestMethod("GET");  //OR  huc.setRequestMethod ("HEAD");
            huc.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");
            huc.connect();
            int code = huc.getResponseCode();
            if(code == 200){
                site1 = true;
            }else{
                site1 = false;
            }
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            URL u = new URL("https://www.xenonhosting.co.uk");

            HttpsURLConnection huc = (HttpsURLConnection) u.openConnection();
            huc.setRequestMethod("GET");  //OR  huc.setRequestMethod ("HEAD");
            huc.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");
            huc.connect();
            int code = huc.getResponseCode();
            if(code == 200){
                site2 = true;
            }else{
                site2 = false;
            }
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            URL u = new URL("https://www.xpos.me");

            HttpsURLConnection huc = (HttpsURLConnection) u.openConnection();
            huc.setRequestMethod("GET");  //OR  huc.setRequestMethod ("HEAD");
            huc.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");
            huc.connect();
            int code = huc.getResponseCode();
            if(code == 200){
                site3 = true;
            }else{
                site3 = false;
            }
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String s1;
        String s2;
        String s3;
        if(site1==true){
            s1 = "Online!";
        }else{
            s1 = "Offline!";
        }
        if(site2==true){
            s2 = "Online!";
        }else{
            s2 = "Offline!";
        }
        if(site3==true){
            s3 = "Online!";
        }else{
            s3 = "Offline!";
        }
        textChannel.sendMessage(new EmbedBuilder()
                .setAuthor("Favourite Sites", null, user.getEffectiveAvatarUrl())
                .setDescription("FlareBot.stream - Popular Admin and Music discord bot. Status: " + s1 + "\nXenonHosting.co.uk - Web Hosting as cheap as $1/Mo! Status:  " + s2 + "\n xpos.me - Some kid I know's website. Status: " + s3)
                .setColor(Color.yellow)
                .build())
                .queue();
    }
        @Override
    public String getCommand() {
        return "sites";
    }

    @Override
    public String getDescription() {
        return "Gives you the status of my favourite sites <3";
    }
}
