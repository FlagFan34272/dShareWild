package kr.wild.dshare.listener

import kr.wild.dshare.manager.Manager
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDamageEvent

class DamageEvent: Listener {
    @EventHandler
    fun EntityDamageEvent.onDamage() {
        if (Manager.isTurnedOn) {
            if (entity is Player) {
                Bukkit.getOnlinePlayers().forEach {
                    if (it == entity) return
                    it.damage(damage)
                    println("${entity.name} | damaged by ${cause.toString()}")
                }
            }
        }
    }
}