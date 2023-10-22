package kr.wild.dshare.command

import kr.wild.dshare.exception.InvalidArgumentException
import kr.wild.dshare.manager.Manager.isTurnedOn
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender

class Commands: CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        when (command.name) {
            "game" -> {
                isTurnedOn = when (args[0]) {
                    "start" -> {
                        if (isTurnedOn) sender.sendMessage("이미 켜져있습니다!")
                        true
                    }

                    "end" -> {
                        if (!isTurnedOn) sender.sendMessage("이미 꺼져있습니다!")
                        false

                    }

                    else -> {
                        throw InvalidArgumentException("${args[0]} is invalid argument!")
                    }
                }
            }
        }
        return false
    }
}