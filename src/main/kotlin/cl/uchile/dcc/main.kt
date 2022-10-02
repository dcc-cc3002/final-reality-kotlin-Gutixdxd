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
    //Test all weapon and character types creation and queue function
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
    //Test characters for the upcoming tests
    val magna = BlackMage("Magna", 10, 10, 10, queue)
    val yuno = WhiteMage("Yuno", 10, 10, 10, queue)
    val olaf = Brute("Olaf", 10, 10, queue)
    val senku = Engineer("Senku", 10, 10, queue)
    val guts = Knight("Guts", 10, 10, queue)
    val nami = Thief("Nami", 10, 10, queue)
    //Test weapons for the characters
    val grimoire = Staff("Grimoire", 10, 10)
    val bell = Staff("Bell", 0, 10)
    val axe = Axe("Axe", 0, 10)
    val primalBow = Bow("PrimalBow", 0, 10)
    val matadragones = Sword("Matadragones", 0, 10)
    val climaTakt = Knife("ClimaTakt", 0, 10)
    //Equipping weapons to their respective character
    magna.equip(grimoire)
    yuno.equip(bell)
    olaf.equip(axe)
    senku.equip(primalBow)
    guts.equip(matadragones)
    nami.equip(climaTakt)
    //Test if weapons are equipped
    println(magna.equippedWeapon)
    println(yuno.equippedWeapon)
    println(olaf.equippedWeapon)
    println(senku.equippedWeapon)
    println(guts.equippedWeapon)
    println(nami.equippedWeapon)
    //Test Equals fun in character classes
    if(
    magna.equals(nami) or
    magna.equals(climaTakt) or
    yuno.equals(guts) or
    yuno.equals(matadragones) or
    olaf.equals(senku) or
    olaf.equals(primalBow) or
    senku.equals(olaf) or
    senku.equals(axe) or
    guts.equals(yuno) or
    guts.equals(bell) or
    nami.equals(magna) or
    nami.equals(grimoire)
    ){
        println("character equals not working well")
    }
    if(
        grimoire.equals(nami) or
        grimoire.equals(climaTakt) or
        bell.equals(guts) or
        bell.equals(matadragones) or
        axe.equals(senku) or
        axe.equals(primalBow) or
        primalBow.equals(olaf) or
        primalBow.equals(axe) or
        matadragones.equals(yuno) or
        matadragones.equals(bell) or
        climaTakt.equals(magna) or
        climaTakt.equals(grimoire)
    ){
        println("weapon equals not working well")
    }

}
