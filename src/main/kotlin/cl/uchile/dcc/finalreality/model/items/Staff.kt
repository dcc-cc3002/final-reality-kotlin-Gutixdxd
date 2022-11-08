package cl.uchile.dcc.finalreality.model.items

import cl.uchile.dcc.finalreality.model.character.player.AbstractPlayerCharacter
import cl.uchile.dcc.finalreality.model.character.player.BlackMage
import cl.uchile.dcc.finalreality.model.character.player.Thief
import cl.uchile.dcc.finalreality.model.character.player.WhiteMage
import java.util.Objects
/**
 * A class that holds all the information of a Staff.
 *
 * @property name String
 *     The name of the Staff.
 * @property damage Int
 *     The base damage done by the Staff.
 * @property weight Int
 *     The weight of the Staff.
 *
 * @constructor Creates a Staff with a name, a base damage,and its weight.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author <a href="https://github.com/Gutixdxd">Guti</a>
 */
class Staff(
    name: String,
    damage: Int,
    weight: Int
) : AbstractWeapon(name, damage, weight) {

    override fun equals(other: Any?) = when {
        this === other -> true
        other !is Staff -> false
        hashCode() != other.hashCode() -> false
        name != other.name -> false
        damage != other.damage -> false
        weight != other.weight -> false
        else -> true
    }

    override fun hashCode() = Objects.hash(Staff::class, name, damage, weight)

    override fun toString() = "Thief(" +
        "name='$name' " +
        "maxHp=$damage, " +
        "defense=$weight)"


    private lateinit var _equippedTo: AbstractPlayerCharacter

    override val equippedTo: AbstractPlayerCharacter
        get() = _equippedTo

    override fun equipToBlackMage(blackMage: BlackMage) {
        blackMage.equipStaff(this)
        _equippedTo=blackMage
    }
    override fun equipToWhiteMage(whiteMage: WhiteMage) {
        whiteMage.equipStaff(this)
        _equippedTo=whiteMage
    }
}
