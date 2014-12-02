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
package net.visualillusionsent.canaryfaqplugin;

import net.visualillusionsent.canaryfaqplugin.commands.FAQCommand;
import net.visualillusionsent.vibotx.VIBotX;
import net.visualillusionsent.vibotx.api.command.CommandCreationException;
import net.visualillusionsent.vibotx.api.plugin.JavaPlugin;

/**
 * Created by Aaron on 12/1/2014.
 */
public class CanaryFAQPlugin extends JavaPlugin {
    public static CanaryFAQPlugin instance;

    @Override
    public boolean enable() {
        instance = this;
        try {
            new FAQCommand(this);
        } catch (CommandCreationException e) {
            VIBotX.log.error("Error Registering Commands in Canary FAQ Plugin.", e);
        }
        return true;
    }

    @Override
    public void disable() {

    }

    public CanaryFAQPlugin instance() {
        return instance;
    }
}
