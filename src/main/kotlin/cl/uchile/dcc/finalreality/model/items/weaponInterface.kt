package cl.uchile.dcc.finalreality.model.items

import cl.uchile.dcc.finalreality.model.character.player.AbstractPlayerCharacter
import cl.uchile.dcc.finalreality.model.character.player.BlackMage
import cl.uchile.dcc.finalreality.model.character.player.Brute
import cl.uchile.dcc.finalreality.model.character.player.Engineer
import cl.uchile.dcc.finalreality.model.character.player.Knight
import cl.uchile.dcc.finalreality.model.character.player.Thief
import cl.uchile.dcc.finalreality.model.character.player.WhiteMage

interface weaponInterface {
    val equippedTo : AbstractPlayerCharacter
    fun equipToEnginner(engineer: Engineer){println("cannot equip this weapon")}
    fun equipToKnight(knight: Knight){println("cannot equip this weapon")}
    fun equipToThief(thief: Thief){println("cannot equip this weapon")}
    fun equipToBrute(brute: Brute){println("cannot equip this weapon")}
    fun equipToWhiteMage(whiteMage: WhiteMage){println("cannot equip this weapon")}
    fun equipToBlackMage(blackMage: BlackMage){println("cannot equip this weapon")}
}