package cl.uchile.dcc.finalreality.model.items
/**
 * A class that holds all the information of any player weapon in the game.
 *
 * @param name String
 *     The name of the weapon.
 * @param damage Int
 *     The base damage done by the weapon.
 * @param weight Int
 *     The weight of the weapon.
 *
 * @constructor Creates a new weapon.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author <a href="https://github.com/Gutixdxd">Guti</a>
 */
abstract class AbstractWeapon(
    val name: String,
    val damage: Int,
    val weight: Int,
) : weaponInterface
