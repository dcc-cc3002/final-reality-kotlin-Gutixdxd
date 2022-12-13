package cl.uchile.dcc.finalreality.model.items

import cl.uchile.dcc.finalreality.model.character.player.AbstractPlayerCharacter
import cl.uchile.dcc.finalreality.model.character.player.BlackMage
import cl.uchile.dcc.finalreality.model.character.player.Knight
import cl.uchile.dcc.finalreality.model.character.player.Thief
import java.util.Objects
/**
 * A class that holds all the information of a Knife.
 *
 * @property name String
 *     The name of the Knife.
 * @property damage Int
 *     The base damage done by the Knife.
 * @property weight Int
 *     The weight of the Knife.
 *
 * @constructor Creates a Knife with a name, a base damage,and its weight.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author <a href="https://github.com/Gutixdxd">Guti</a>
 */
class Knife(
    name: String,
    damage: Int,
    weight: Int
) : AbstractWeapon(name, damage, weight) {

    override fun equals(other: Any?) = when {
        this === other -> true
        other !is Knife -> false
        hashCode() != other.hashCode() -> false
        name != other.name -> false
        damage != other.damage -> false
        weight != other.weight -> false
        else -> true
    }

    override fun hashCode() = Objects.hash(Knife::class, name, damage, weight)

    override fun toString() = "Thief(" +
        "name='$name' " +
        "maxHp=$damage, " +
        "defense=$weight)"

    private lateinit var _equippedTo: AbstractPlayerCharacter

    override val equippedTo: AbstractPlayerCharacter
        get() = _equippedTo

    override fun equipToKnight(knight: Knight) {
        knight.equipKnife(this)
        _equippedTo = knight
    }
    override fun equipToThief(thief: Thief) {
        thief.equipKnife(this)
        _equippedTo = thief
    }
    override fun equipToBlackMage(blackMage: BlackMage) {
        blackMage.equipKnife(this)
        _equippedTo = blackMage
    }
}
