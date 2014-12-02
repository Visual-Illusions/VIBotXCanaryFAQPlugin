/*
 * This file is part of WeatherBot.
 *
 * Copyright © 2014 Visual Illusions Entertainment
 *
 * WeatherBot is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License,
 * or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with this program.
 * If not, see http://www.gnu.org/licenses/gpl.html.
 */
package net.visualillusionsent.canaryfaqplugin.commands;

/**
 * Created by Aaron on 9/24/2014.
 */

import net.visualillusionsent.canaryfaqplugin.HttpHelper;
import net.visualillusionsent.vibotx.VIBotX;
import net.visualillusionsent.vibotx.api.command.BaseCommand;
import net.visualillusionsent.vibotx.api.command.BotCommand;
import net.visualillusionsent.vibotx.api.command.CommandCreationException;
import net.visualillusionsent.vibotx.api.command.CommandEvent;
import net.visualillusionsent.vibotx.api.plugin.Plugin;
import org.pircbotx.Colors;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Shut The Fuck Up Command<br>
 * Quiets the {@link net.visualillusionsent.vibotx.VIBotX} in a {@link org.pircbotx.Channel}<br>
 * <b>Usage:</b>!tell <username> <message><br>
 * <b>Minimum Params:</b> 0<br>
 * <b>Maximum Params:</b> 2<br>
 * <b>Requires:</b> <br>
 *
 * @author Aaron (somners)
 */
@BotCommand(
        main = "canaryfaq",
        prefix = '!',
        usage = "!canaryfaq",
        desc = "Returns a short url pointing to the canary frequently asked questions page.",
        minParam = 0,
        maxParam = 0,
        op = false,
        privateAllowed = false
)
public final class FAQCommand extends BaseCommand {

    /**
     * Constructs a new {@code ShutTheFuckUpCommand}
     */
    public FAQCommand(Plugin plugin) throws CommandCreationException {
        super(plugin);
    }

    @Override
    public final synchronized boolean execute(CommandEvent event) {
            event.getChannel().send().message(event.getUser(), Colors.NORMAL + 
                    "You have asked a question that can be found in the CanaryMod FAQ pages.  Here is a link: " + Colors.DARK_GREEN + 
                    HttpHelper.getShortUrl("http://canarymod.net/forum/canarymod-board/discussions/frequently-asked-questions-3277"));
        return true;
    }

}
