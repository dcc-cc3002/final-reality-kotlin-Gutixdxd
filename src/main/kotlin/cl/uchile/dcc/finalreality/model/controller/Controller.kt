package cl.uchile.dcc.finalreality.model.controller

import cl.uchile.dcc.finalreality.model.character.Enemy
import cl.uchile.dcc.finalreality.model.character.player.AbstractPlayerCharacter
import cl.uchile.dcc.finalreality.model.character.player.BlackMage
import cl.uchile.dcc.finalreality.model.character.player.Brute
import cl.uchile.dcc.finalreality.model.character.player.Engineer
import cl.uchile.dcc.finalreality.model.character.player.Knight
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter
import cl.uchile.dcc.finalreality.model.character.player.Thief
import cl.uchile.dcc.finalreality.model.character.player.WhiteMage
import cl.uchile.dcc.finalreality.model.character.queue
import cl.uchile.dcc.finalreality.model.items.Axe
import cl.uchile.dcc.finalreality.model.items.Bow
import cl.uchile.dcc.finalreality.model.items.Knife
import cl.uchile.dcc.finalreality.model.items.Staff
import cl.uchile.dcc.finalreality.model.items.Sword
import java.util.Scanner
import kotlin.random.Random.Default.nextInt

/**
 * Class that manages a game, asking the player to input information to
 * choose their character and the level of challenge desired
 * The player has to choose 4 characters and in case of a miss input
 * the system will choose white mage
 *
 * @param Party Is the player characters in a list
 * @param EnemyParty Is the enemy team in a list
 *
 * Constructor creates a new game instance
 *
 * @author <a href="https://github.com/Gutixdxd">Guti</a>
 */
class Controller {

    val Party= mutableListOf<PlayerCharacter>()
    val EnemyParty= mutableListOf<Enemy>()
    fun Newchar(Cclass: String, name: String): AbstractPlayerCharacter {

        if(Cclass=="knight"){
            val char=Knight( name,
                             nextInt(9, 15),
                             nextInt(9, 15),
                             queue
            )
            val basicWeapon=Sword(
                "stick",
                2,
                6
            )
            char.equip(basicWeapon)
            return char
        }
        if(Cclass=="thief"){
            val char=Thief(
                name,
                nextInt(9, 15),
                nextInt(9, 15),
                queue
            )
            val basicWeapon=Knife(
                "broken bottle",
                1,
                5
            )
            char.equip(basicWeapon)
            return char
        }
        if(Cclass=="brute"){
            val char=Brute(
                name,
                nextInt(9, 15),
                nextInt(9, 15),
                queue
            )
            val basicWeapon= Axe(
                "big stick",
                3,
                8
            )
            char.equip(basicWeapon)
            return char
        }
        if(Cclass=="engineer"){
            val char=Engineer(
                name,
                nextInt(9, 15),
                nextInt(9, 15),
                queue
            )
            val basicWeapon= Bow(
                "stone",
                1,
                5
            )
            char.equip(basicWeapon)
            return char
        }
        if(Cclass=="blackmage"){
            val char=BlackMage(
                name,
                nextInt(9, 15),
                nextInt(9, 15),
                queue,
                nextInt(9, 15)
            )
            val basicWeapon= Staff(
                "bone",
                3,
                7
            )
            char.equip(basicWeapon)
            return char
        }
        else{ //WhiteMage is default in case class name is mistaken
            val char=WhiteMage(
                name,
                nextInt(9, 15),
                nextInt(9, 15),
                queue,
                nextInt(9, 15)
            )
            val basicWeapon= Staff(
                "book",
                2,
                6)
            char.equip(basicWeapon)
            char.waitTurn()
            return char
        }
    }
    fun NewEnemy(Challenge: Int){
        val enemy=Enemy(
            "Mountain Bandit",
            nextInt(5*Challenge, 15*Challenge),
            nextInt(5*Challenge,15*Challenge),
            nextInt(1*Challenge,3*Challenge),
            nextInt(5*Challenge,15*Challenge),
            queue
        )
        EnemyParty.add(element = enemy)
    }

    fun StartGame(challenge: Int){
        var numberEnemy= nextInt(1, 5)
        while(numberEnemy>=0){
            NewEnemy(challenge)
            numberEnemy-=1
        }
        Newchar("knight", "Escanor")
        Newchar("whitemage", "Gandalf")
        Newchar("thief", "Kazuma")
        Newchar("engineer", "Tesla")
    }
}