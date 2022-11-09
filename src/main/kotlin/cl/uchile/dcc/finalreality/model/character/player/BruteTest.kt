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


val queueB = LinkedBlockingQueue<GameCharacter>()

private const val KSANTE_NAME= "ksante"
private const val KSANTE_MAXHP= 30
private const val KSANTE_DEFENSE= 40

private const val CRAIG_NAME= "craig"
private const val CRAIG_MAXHP= 40
private const val CRAIG_DEFENSE= 60


class BruteTest : FunSpec ({
    lateinit var ksante : Brute
    lateinit var craig : Brute
    beforeEach{
        ksante= Brute(
            KSANTE_NAME,
            KSANTE_MAXHP,
            KSANTE_DEFENSE,
            queueB
        )

        craig= Brute(
            CRAIG_NAME,
            CRAIG_MAXHP,
            CRAIG_DEFENSE,
            queueB
        )
    }
    test(
        "Two enemies with the same parameters should be equal"
    ){
        val ksanteRedTeam= Brute(
            KSANTE_NAME,
            KSANTE_MAXHP,
            KSANTE_DEFENSE,
            queueB
        )
        ksante shouldNotBeSameInstanceAs ksanteRedTeam
        ksante shouldBe ksanteRedTeam

        val craigCringe= Brute(
            CRAIG_NAME,
            CRAIG_MAXHP,
            CRAIG_DEFENSE,
            queueB
        )
        craig shouldNotBeSameInstanceAs craigCringe
        craig shouldBe craigCringe
    }
    test(
        "Two enemies with different parameters should not be equal"
    ){
        ksante shouldNotBeSameInstanceAs craig
        ksante shouldNotBe craig
    }
    test(
        "weapon equipped should be the same"
    ){
        val axe= Axe("Ntofos", 15, 40)
        ksante.equip(axe)
        ksante.equippedWeapon shouldBe axe
        val sword= Sword("AllOut", 30, 20)
        ksante.equip(sword)
        ksante.equippedWeapon shouldBe sword
    }
    test(
        "weapon no allowed for this class, should be the last valid weapon equiped"
    ){
        val staff=Staff("Gema del tiempo", 30, 12)
        val axe= Axe("Ntofos", 15, 40)
        val sword= Sword("AllOut", 30, 20)
        val bow= Bow("Cience", 50, 30)
        val knife= Knife("Chunchunmaru", 15, 3)
        ksante.equip(axe)
        ksante.equippedWeapon shouldBe axe
        ksante.equip(sword)
        ksante.equippedWeapon shouldBe sword
        ksante.equip(staff)
        ksante.equippedWeapon shouldNotBe staff
        ksante.equip(bow)
        ksante.equippedWeapon shouldNotBe bow
        ksante.equip(knife)
        ksante.equippedWeapon shouldNotBe knife
        ksante.equippedWeapon shouldBe sword
    }
})