package de.comroid.tempvoicer.commands;

import de.kaleidox.javacord.util.commands.Command;
import de.kaleidox.javacord.util.commands.CommandGroup;
import de.kaleidox.javacord.util.ui.embed.DefaultEmbedFactory;

import org.javacord.api.entity.message.Message;
import org.javacord.api.entity.user.User;

import static org.javacord.api.util.logging.ExceptionLogger.get;

@CommandGroup(name = "Basic Commands", description = "All commands for basic interaction with the bot")
public enum BasicCommands {
    INSTANCE;

    public static final String INVITE_LINK = "https://discordapp.com/oauth2/authorize/?permissions=17918032&scope=bot&client_id=581758105000607767";

    @Command(usage = "invite", description = "Sends an invite link for the bot to you via DM")
    public void invite(Message msg, User usr) {
        usr.sendMessage(DefaultEmbedFactory.create().addField("Invite Link", INVITE_LINK))
                .thenCompose(ign -> msg.delete())
                .exceptionally(get())
                .join();
    }
}
