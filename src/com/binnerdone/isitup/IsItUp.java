package com.binnerdone.isitup;

import com.walshydev.jba.JBA;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.entities.Game;

/**
 * Created by Jack on 12/03/2017.
 */
public class IsItUp extends JBA {

    public static void main(String[] args){
        new IsItUp().init(AccountType.BOT, "secret token", "*");
    }


    @Override
    public void run() {
        getClient().getPresence().setGame(Game.of("Is It Up? Version 0.0.0.1 *help for help!", null));
        registerCommand(new PingCommand());
        registerCommand(new StatusCommand());
        registerCommand(new HelpCommand());
        registerCommand(new InfoCommand());
        LOGGER.info("Bot Launched!");
    }
}
