package cl.uchile.dcc.finalreality.model.items

import cl.uchile.dcc.finalreality.model.character.player.AbstractPlayerCharacter
import cl.uchile.dcc.finalreality.model.character.player.Engineer
import cl.uchile.dcc.finalreality.model.character.player.Thief
import java.util.Objects
/**
 * A class that holds all the information of a Bow.
 *
 * @property name String
 *     The name of the Bow.
 * @property damage Int
 *     The base damage done by the Bow.
 * @property weight Int
 *     The weight of the Bow.
 *
 * @constructor Creates an Axe with a name, a base damage,and its weight.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author <a href="https://github.com/Gutixdxd">Guti</a>
 */
class Bow(
    name: String,
    damage: Int,
    weight: Int
) : AbstractWeapon(name, damage, weight) {

    override fun equals(other: Any?) = when {
        this === other -> true
        other !is Bow -> false
        hashCode() != other.hashCode() -> false
        name != other.name -> false
        damage != other.damage -> false
        weight != other.weight -> false
        else -> true
    }

    override fun hashCode() = Objects.hash(Bow::class, name, damage, weight)

    override fun toString() = "Thief(" +
        "name='$name' " +
        "maxHp=$damage, " +
        "defense=$weight)"

    private lateinit var _equippedTo: AbstractPlayerCharacter

    override val equippedTo: AbstractPlayerCharacter
        get() = _equippedTo

    override fun equipToEnginner(engineer: Engineer) {
        engineer.equipBow(this)
        _equippedTo=engineer
    }
    override fun equipToThief(thief: Thief) {
        thief.equipBow(this)
        _equippedTo=thief
    }
}
