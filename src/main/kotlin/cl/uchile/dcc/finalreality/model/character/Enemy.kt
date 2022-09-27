package cl.uchile.dcc.finalreality.model.character

import cl.uchile.dcc.finalreality.exceptions.Require
import java.util.*
import java.util.concurrent.BlockingQueue

/**
 * A class that holds all the information of a single enemy of the game.
 *
 * @param name The name of this enemy.
 * @property weight The weight of this enemy.
 * @property attack The attack of this enemy.
 * @param turnsQueue The queue with the characters waiting for their turn.
 * @param maxHp The maximum health points of this enemy.
 * @param defense The defense of this enemy.
 *
 * @constructor Creates a new enemy with a name, a weight and the queue with the characters ready to
 *  play.
 *
 * @author <a href="https://github.com/r8vnhill">R8V</a>
 * @author <a href="https://github.com/Gutixdxd">Guti</a>
 */
class Enemy(
    name: String,
    weight: Int,
    maxHp: Int,
    defense: Int,
    attack: Int,
    turnsQueue: BlockingQueue<GameCharacter>
) : AbstractCharacter(name, maxHp, defense, turnsQueue) {
    val weight = Require.Stat(weight, "Weight") atLeast 1
    val attack = Require.Stat(attack, "Attack") atLeast 0
    override fun equals(other: Any?) = when {
        this === other                 -> true
        other !is Enemy                -> false
        hashCode() != other.hashCode() -> false
        name != other.name             -> false
        weight != other.weight         -> false
        maxHp != other.maxHp           -> false
        defense != other.defense       -> false
        currentHp != other.currentHp   -> false
        attack != other.attack         -> false
        else                           -> true
    }

    override fun hashCode() = Objects.hash(Enemy::class, name, weight, maxHp, defense)

    override fun toString() = "Enemy(" +
        "name='$name' " +
        "maxHp=$maxHp, " +
        "currentHp=$currentHp, " +
        "weight=$weight, " +
        "defense=$defense, " +
        "attack=$attack)"
}
