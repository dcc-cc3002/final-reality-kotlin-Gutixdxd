package cl.uchile.dcc

import cl.uchile.dcc.finalreality.model.character.Enemy
import cl.uchile.dcc.finalreality.model.character.GameCharacter
import cl.uchile.dcc.finalreality.model.character.player.BlackMage
import cl.uchile.dcc.finalreality.model.character.player.Brute
import cl.uchile.dcc.finalreality.model.character.player.Engineer
import cl.uchile.dcc.finalreality.model.character.player.Knight
import cl.uchile.dcc.finalreality.model.character.player.Thief
import cl.uchile.dcc.finalreality.model.character.player.WhiteMage
import cl.uchile.dcc.finalreality.model.items.Knife
import cl.uchile.dcc.finalreality.model.items.Sword
import cl.uchile.dcc.finalreality.model.items.Staff
import cl.uchile.dcc.finalreality.model.items.Axe
import cl.uchile.dcc.finalreality.model.items.Bow
import java.util.concurrent.LinkedBlockingQueue
import kotlin.random.Random

fun main() {
    val queue = LinkedBlockingQueue<GameCharacter>()
    for (i in 0 until 10) {
        // Gives a random speed to each character to generate different waiting times
        val weapon = Knife("", 0, Random.nextInt(1, 50))
        val character = Thief("$i", 10, 10, queue)
        character.equip(weapon)
        character.waitTurn()
    }
    for (i in 0 until 10) {
        // Gives a random speed to each character to generate different waiting times
        val weapon = Bow("", 0, Random.nextInt(1, 50))
        val character = Engineer("$i", 10, 10, queue)
        character.equip(weapon)
        character.waitTurn()
    }
    for (i in 0 until 10) {
        // Gives a random speed to each character to generate different waiting times
        val weapon = Sword("", 0, Random.nextInt(1, 50))
        val character = Knight("$i", 10, 10, queue)
        character.equip(weapon)
        character.waitTurn()
    }
    for (i in 0 until 10) {
        // Gives a random speed to each character to generate different waiting times
        val weapon = Staff("", 0, Random.nextInt(1, 50))
        val character = WhiteMage("$i", 10, 10, 10, queue)
        character.equip(weapon)
        character.waitTurn()
    }
    for (i in 0 until 10) {
        // Gives a random speed to each character to generate different waiting times
        val weapon = Staff("", 0, Random.nextInt(1, 50))
        val character = BlackMage("$i", 10, 10, 10, queue)
        character.equip(weapon)
        character.waitTurn()
    }
    for (i in 0 until 10) {
        // Gives a random speed to each character to generate different waiting times
        val weapon = Axe("", 0, Random.nextInt(1, 50))
        val character = Knight("$i", 10, 10, queue)
        character.equip(weapon)
        character.waitTurn()
    }
    for (i in 0 until 10) {
        // Gives a random speed to each character to generate different waiting times
        val weapon = Axe("", 0, Random.nextInt(1, 50))
        val character = Brute("$i", 10, 10, queue)
        character.equip(weapon)
        character.waitTurn()
    }
    for (i in 0 until 10) {
        // Gives a random speed to each character to generate different waiting times
        val character = Enemy("$i", 10, 10, 10, 0, queue)
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
