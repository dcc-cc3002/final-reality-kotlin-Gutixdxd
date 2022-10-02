package cl.uchile.dcc.finalreality.model.items

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
class Bow (
    name: String,
    damage: Int,
    weight: Int
): AbstractWeapon(name,damage, weight){

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

    override fun toString() = "Bow { name: $name, damage: $damage, weight: $weight)"
}