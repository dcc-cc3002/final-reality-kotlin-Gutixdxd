package cl.uchile.dcc.finalreality.model.character.player

import cl.uchile.dcc.finalreality.model.character.GameCharacter
import cl.uchile.dcc.finalreality.model.items.Axe
import cl.uchile.dcc.finalreality.model.items.Bow
import cl.uchile.dcc.finalreality.model.items.Knife
import cl.uchile.dcc.finalreality.model.items.Staff
import cl.uchile.dcc.finalreality.model.items.Sword
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import io.kotest.matchers.types.shouldNotBeSameInstanceAs
import java.util.concurrent.LinkedBlockingQueue


val queueWM = LinkedBlockingQueue<GameCharacter>()

private const val JULIUS_NAME= "julius"
private const val JULIUS_MAXHP= 12
private const val JULIUS_MAXMP= 10
private const val JULIUS_DEFENSE= 10

private const val RUDEUS_NAME= "rudeus"
private const val RUDEUS_MAXHP= 10
private const val RUDEUS_MAXMP= 10
private const val RUDEUS_DEFENSE= 10


class WhiteMageTest : FunSpec ({
    lateinit var julius : WhiteMage
    lateinit var rudeus : WhiteMage
    beforeEach{
        julius= WhiteMage(
            JULIUS_NAME,
            JULIUS_MAXHP,
            JULIUS_MAXMP,
            queueWM,
            JULIUS_DEFENSE
        )
        rudeus= WhiteMage(
            RUDEUS_NAME,
            RUDEUS_MAXHP,
            RUDEUS_MAXMP,
            queueWM,
            RUDEUS_DEFENSE
        )
    }
    test(
        "Two enemies with the same parameters should be equal"
    ){
        val juliusXiquito= WhiteMage(
            JULIUS_NAME,
            JULIUS_MAXHP,
            JULIUS_MAXMP,
            queueWM,
            JULIUS_DEFENSE
        )
        julius shouldNotBeSameInstanceAs juliusXiquito
        julius shouldBe juliusXiquito
        val Orsted= WhiteMage(
            RUDEUS_NAME,
            RUDEUS_MAXHP,
            RUDEUS_MAXMP,
            queueWM,
            RUDEUS_DEFENSE
        )
        rudeus shouldNotBeSameInstanceAs Orsted
        rudeus shouldBe Orsted
    }
    test(
        "Two enemies with different parameters should not be equal"
    ){
        julius shouldNotBeSameInstanceAs rudeus
        julius shouldNotBe rudeus
    }
    test(
        "Mp should be the same as the val that is in the beginning"
    ){
        julius.maxMp shouldBe JULIUS_MAXMP
    }
    test(
        "weapon equipped should be the same"
    ){
        val staff= Staff("Grimorio", 40, 20)
        julius.equip(staff)
        julius.equippedWeapon shouldBe staff
    }
    test(
        "weapon no allowed for this class, should be the last valid weapon equiped"
    ){
        val staff=Staff("Gema del tiempo", 30, 12)
        val axe= Axe("Ntofos", 15, 40)
        val sword= Sword("AllOut", 30, 20)
        val bow= Bow("Cience", 50, 30)
        val knife= Knife("Chunchunmaru", 15, 3)
        julius.equip(staff)
        julius.equippedWeapon shouldBe staff
        julius.equip(sword)
        julius.equippedWeapon shouldNotBe sword
        julius.equip(axe)
        julius.equippedWeapon shouldNotBe axe
        julius.equip(bow)
        julius.equippedWeapon shouldNotBe bow
        julius.equip(knife)
        julius.equippedWeapon shouldNotBe knife
        julius.equippedWeapon shouldBe staff
    }
})