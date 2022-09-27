package cl.uchile.dcc
import cl.uchile.dcc.finalreality.model.Weapon
import cl.uchile.dcc.finalreality.model.WeaponType
import cl.uchile.dcc.finalreality.model.character.Enemy
import cl.uchile.dcc.finalreality.model.character.GameCharacter
import cl.uchile.dcc.finalreality.model.character.player.BlackMage
import cl.uchile.dcc.finalreality.model.character.player.Engineer
import cl.uchile.dcc.finalreality.model.character.player.Knight
import cl.uchile.dcc.finalreality.model.character.player.Thief
import cl.uchile.dcc.finalreality.model.character.player.WhiteMage
import java.util.concurrent.LinkedBlockingQueue
import kotlin.random.Random

fun main() {
    val queue = LinkedBlockingQueue<GameCharacter>()
    for (i in 0 until 10) {
        // Gives a random speed to each character to generate different waiting times
        val weapon = Weapon("", 0, Random.nextInt(1, 50), WeaponType.KNIFE)
        val character = Thief("$i", 10, 10, queue)
        character.equip(weapon)
        character.waitTurn()
    }
    for (i in 0 until 10) {
        // Gives a random speed to each character to generate different waiting times
        val weapon = Weapon("", 0, Random.nextInt(1, 50), WeaponType.BOW)
        val character = Engineer("$i", 10, 10, queue)
        character.equip(weapon)
        character.waitTurn()
    }
    for (i in 0 until 10) {
        // Gives a random speed to each character to generate different waiting times
        val weapon = Weapon("", 0, Random.nextInt(1, 50), WeaponType.SWORD)
        val character = Knight("$i", 10, 10, queue)
        character.equip(weapon)
        character.waitTurn()
    }
    for (i in 0 until 10) {
        // Gives a random speed to each character to generate different waiting times
        val weapon = Weapon("", 0, Random.nextInt(1, 50), WeaponType.STAFF)
        val character = WhiteMage("$i", 10, 10,10, queue)
        character.equip(weapon)
        character.waitTurn()
    }
    for (i in 0 until 10) {
        // Gives a random speed to each character to generate different waiting times
        val weapon = Weapon("", 0, Random.nextInt(1, 50), WeaponType.STAFF)
        val character = BlackMage("$i", 10, 10, 10,queue)
        character.equip(weapon)
        character.waitTurn()
    }
    for (i in 0 until 10) {
        // Gives a random speed to each character to generate different waiting times
        val weapon = Weapon("", 0, Random.nextInt(1, 50), WeaponType.AXE)
        val character = Knight("$i", 10, 10, queue)
        character.equip(weapon)
        character.waitTurn()
    }
    for (i in 0 until 10) {
        // Gives a random speed to each character to generate different waiting times
        val character = Enemy("$i", 10, 10, 10,queue)
        character.waitTurn()
    }
    // Waits for 6 seconds to ensure that all characters have finished waiting
    Thread.sleep(6000)
    while (!queue.isEmpty()) {
        // Pops and prints the names of the characters of the queue to illustrate the turns
        // order
        println(queue.poll())
    }
}