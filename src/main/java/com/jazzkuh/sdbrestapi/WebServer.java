package com.jazzkuh.sdbrestapi;

import nl.minetopiasdb.api.playerdata.PlayerManager;
import nl.minetopiasdb.api.playerdata.objects.OfflineSDBPlayer;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.json.simple.JSONObject;
import spark.Spark;

@SuppressWarnings("deprecation")
public class WebServer {

    public WebServer(Integer port) {
        Spark.port(port);
    }

    public void init() {
        this.initPlayerAPI();
    }

    private void initPlayerAPI() {
        Spark.get("/api/player/:player", (request, response) -> {
            String playerName = request.params(":player");
            OfflinePlayer player = Bukkit.getOfflinePlayer(playerName);

            if (!player.hasPlayedBefore()) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("success", false);
                return jsonObject.toJSONString();
            }

            OfflineSDBPlayer offlineSDBPlayer = PlayerManager.getOfflinePlayer(player.getUniqueId());
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("success", true);
            jsonObject.put("uuid", player.getUniqueId().toString());
            jsonObject.put("level",  offlineSDBPlayer.getLevel());
            jsonObject.put("goldshards",  offlineSDBPlayer.getGoldShardsFormatted());
            jsonObject.put("luckyshards",  offlineSDBPlayer.getLuckyShardsFormatted());
            jsonObject.put("grayshards",  offlineSDBPlayer.getGrayShardsFormatted());
            jsonObject.put("graycoins",  offlineSDBPlayer.getGrayCoins());
            jsonObject.put("fitness",  offlineSDBPlayer.getFitness().getTotalFitness());
            jsonObject.put("prefix",  offlineSDBPlayer.getPrefix());
            jsonObject.put("timeDays",  offlineSDBPlayer.getTimeDays());
            jsonObject.put("timeHours",  offlineSDBPlayer.getTimeHours());
            jsonObject.put("timeMinutes",  offlineSDBPlayer.getTimeMinutes());
            jsonObject.put("timeSeconds",  offlineSDBPlayer.getTimeSeconds());
            jsonObject.put("money", Main.getEcon().getBalance(player));

            return jsonObject.toJSONString();
        });
    }
}
