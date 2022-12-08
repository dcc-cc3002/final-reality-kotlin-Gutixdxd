/*
 * "Final Reality" (c) by R8V and ~Your name~
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */
package cl.uchile.dcc.finalreality.model.character.player

import cl.uchile.dcc.finalreality.model.character.Enemy
import cl.uchile.dcc.finalreality.model.character.GameCharacter
import cl.uchile.dcc.finalreality.model.items.AbstractWeapon
import cl.uchile.dcc.finalreality.model.items.Knife
import cl.uchile.dcc.finalreality.model.items.Staff
import java.util.Objects
import java.util.concurrent.BlockingQueue
import kotlin.random.Random.Default.nextInt

/**
 * A Black Mage is a type of player character that can cast black magic.
 *
 * @param name        the character's name
 * @param maxHp       the character's maximum health points
 * @param maxMp       the character's maximum magic points
 * @param defense     the character's defense
 * @param turnsQueue  the queue with the characters waiting for their turn
 * @constructor Creates a new Black Mage.
 *
 * @property currentMp The current MP of the character.
 * @property currentHp The current HP of the character.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author <a href="https://github.com/Gutixdxd">Guti</a>
 */
class BlackMage(
    name: String,
    maxHp: Int,
    defense: Int,
    turnsQueue: BlockingQueue<GameCharacter>,
    maxMp: Int
) : AbstractMage(name, maxHp, defense, turnsQueue, maxMp) {

    override fun equals(other: Any?) = when {
        this === other -> true
        other !is BlackMage -> false
        hashCode() != other.hashCode() -> false
        name != other.name -> false
        maxHp != other.maxHp -> false
        maxMp != other.maxMp -> false
        defense != other.defense -> false
        currentMp != other.currentMp -> false
        currentHp != other.currentHp -> false
        else -> true
    }

    override fun hashCode() =
        Objects.hash(BlackMage::class, name, maxHp, maxMp, defense)

    override fun toString() = "BlackMage(" +
        "name='$name' " +
        "maxHp=$maxHp, " +
        "currentHp=$currentHp, " +
        "defense=$defense, " +
        "maxMp=$maxMp, " +
        "currentMp=$currentMp)"

    override fun equip(weapon: AbstractWeapon) {
        weapon.equipToBlackMage(this)
    }

    private lateinit var _equippedWeapon: AbstractWeapon
    override val equippedWeapon: AbstractWeapon
        get() = _equippedWeapon
    fun equipStaff(staff: Staff) {
        _equippedWeapon = staff
    }
    fun equipKnife(knife: Knife) {
        _equippedWeapon = knife
    }

    fun Thunder(target: Enemy){
        if(this.currentMp>=15){
            target.DoDamage(this.equippedWeapon.damage)
            val ParChance=nextInt(9)
            if(ParChance<=3) target.Paralysis()
            currentMp-=15
            }
    }
    fun Fire(target: Enemy){
        if(this.currentMp>=15){
            target.DoDamage(this.equippedWeapon.damage)
            val BurnChance=nextInt(6)
            if(BurnChance<=1) target.Burn(this.equippedWeapon.damage)
        }
    }
}
