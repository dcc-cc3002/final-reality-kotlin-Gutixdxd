package cl.uchile.dcc.finalreality.model.character.player

import cl.uchile.dcc.finalreality.model.character.GameCharacter
import java.util.Objects
import java.util.concurrent.BlockingQueue

/**
 * A `Brute` is a type of [PlayerCharacter] that can equip `Axe`s and
 * `Sword's.
 *
 * @param name        the character's name
 * @param maxHp       the character's maximum health points
 * @param defense     the character's defense
 * @param turnsQueue  the queue with the characters waiting for their turn
 * @constructor Creates a new Brute.
 *
 * @property currentHp The current HP of the character.
 *
 * @author <a href="https://github.com/Gutixdxd">Guti</a>
 */
class Brute(
    name: String, maxHp: Int, defense: Int,
    turnsQueue: BlockingQueue<GameCharacter>
) : AbstractPlayerCharacter(name, maxHp, defense, turnsQueue) {
    override fun equals(other: Any?) = when {
        this === other                 -> true
        other !is Brute               -> false
        hashCode() != other.hashCode() -> false
        name != other.name             -> false
        maxHp != other.maxHp           -> false
        defense != other.defense       -> false
        else                           -> true
    }

    override fun hashCode() = Objects.hash(Knight::class, name, maxHp, defense)

    override fun toString() = "Brute(" +
        "name='$name' " +
        "maxHp=$maxHp, " +
        "currentHp=$currentHp, " +
        "defense=$defense)"
}