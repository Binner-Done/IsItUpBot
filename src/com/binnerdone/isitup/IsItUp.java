package com.binnerdone.isitup;

import com.walshydev.jba.JBA;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.entities.Game;

/**
 * Created by Jack on 12/03/2017.
 */
public class IsItUp extends JBA {

    public static void main(String[] args){
        new IsItUp().init(AccountType.BOT, "Secret Token", "*");
    }


    @Override
    public void run() {
        registerCommand(new PingCommand());
        registerCommand(new StatusCommand());
        registerCommand(new HelpCommand());
        registerCommand(new InfoCommand());
        registerCommand(new SitesCommand());
        LOGGER.info("Bot Launched!");
    }
}
