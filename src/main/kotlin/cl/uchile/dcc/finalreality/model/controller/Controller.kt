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
import kotlin.random.Random.Default.nextInt

class Controller {

    val Party= mutableListOf<PlayerCharacter>(this.Newchar(),this.Newchar(), this.Newchar(), this.Newchar())
    val EnemyParty= mutableListOf<Enemy>()
    fun Newchar(): AbstractPlayerCharacter {
        print("Enter a class name, knight, thief, brute, engineer, blackmage or whitemage")
        val Cclass= readLine()
        if(Cclass=="knight"){
            val name= readLine()
            val char=Knight( name, nextInt(9, 15), nextInt(9, 15), queue)
            val basicWeapon=Sword("stick", 2,6)
            char.equip(basicWeapon)
            return char
        }
        if(Cclass=="thief"){
            val name= readLine()
            val char=Thief( name, nextInt(9, 15), nextInt(9, 15), queue)
            val basicWeapon=Knife("broken bottle", 1,5)
            char.equip(basicWeapon)
            return char
        }
        if(Cclass=="brute"){
            val name= readLine()
            val char=Brute( name, nextInt(9, 15), nextInt(9, 15), queue)
            val basicWeapon= Axe("big stick", 3, 8)
            char.equip(basicWeapon)
            return char
        }
        if(Cclass=="engineer"){
            val name= readLine()
            val char=Engineer( name, nextInt(9, 15), nextInt(9, 15), queue)
            val basicWeapon= Bow("stone", 1, 5)
            char.equip(basicWeapon)
            return char
        }
        if(Cclass=="blackmage"){
            val name= readLine()
            val char=BlackMage( name, nextInt(9, 15), nextInt(9, 15),queue, nextInt(9, 15))
            val basicWeapon= Staff("bone", 3, 7)
            char.equip(basicWeapon)
            return char
        }
        else{ //WhiteMage is default in case class name is mistaken
            val name= readLine()
            val char=WhiteMage( name, nextInt(9, 15), nextInt(9, 15), queue, nextInt(9, 15))
            val basicWeapon= Staff("book", 2, 6)
            char.equip(basicWeapon)
            return char
        }
    }
}