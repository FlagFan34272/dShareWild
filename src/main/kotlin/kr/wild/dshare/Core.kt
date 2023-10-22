package kr.wild.dshare

import kr.wild.dshare.command.Commands
import kr.wild.dshare.listener.DamageEvent
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin

class Core: JavaPlugin() {
    override fun onEnable() {
        logger.info("source by Nyaneo - https://github.com/FlagFan34272")
        getCommand("game")!!.setExecutor(Commands())
        server.pluginManager.registerEvents(DamageEvent(), this)
    }
}