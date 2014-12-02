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

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Aaron on 12/1/2014.
 */
public class HttpHelper {

    public static String getShortUrl(String httplink) {
        String shortUrl = null;
        try {
            URL url = new URL("https://www.googleapis.com/urlshortener/v1/url/");
            HttpURLConnection uc = (HttpURLConnection) url.openConnection();
            uc.setRequestMethod("POST");
            uc.setRequestProperty("Content-Type", "application/json");
            uc.setDoOutput(true);
            DataOutputStream dos = new DataOutputStream(uc.getOutputStream());
            JSONObject jsonO = new JSONObject();
            jsonO.put("longUrl", httplink);
            System.out.println(jsonO.toJSONString());
            dos.writeBytes(jsonO.toString());
            dos.flush();
            dos.close();
            // Parse it
            JSONParser parser = new JSONParser();
            BufferedReader reader = new BufferedReader(new InputStreamReader(uc.getInputStream()));
            Object obj = parser.parse(reader);
            shortUrl = (String) ((JSONObject) obj).get("id");
        }
        catch (Exception ex) {
            System.out.println("Failed to translate long URL into short URL");
            ex.printStackTrace();
        }
        return shortUrl;
    }
}
