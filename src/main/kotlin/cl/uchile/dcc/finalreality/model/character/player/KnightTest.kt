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

val queueK = LinkedBlockingQueue<GameCharacter>()

private const val DARKNESS_NAME = "darkness"
private const val DARKNESS_MAXHP = 30
private const val DARKNESS_DEFENSE = 40

private const val ERZA_NAME = "erza"
private const val ERZA_MAXHP = 40
private const val ERZA_DEFENSE = 60

class KnightTest : FunSpec({
    lateinit var darkness: Knight
    lateinit var erza: Knight
    beforeEach {
        darkness = Knight(
            DARKNESS_NAME,
            DARKNESS_MAXHP,
            DARKNESS_DEFENSE,
            queueK
        )
        erza = Knight(
            ERZA_NAME,
            ERZA_MAXHP,
            ERZA_DEFENSE,
            queueK
        )
    }
    test(
        "Two enemies with the same parameters should be equal"
    ) {
        val darknessMask = Knight(
            DARKNESS_NAME,
            DARKNESS_MAXHP,
            DARKNESS_DEFENSE,
            queueK
        )
        darkness shouldNotBeSameInstanceAs darknessMask
        darkness shouldBe darknessMask
        val erzaCat = Knight(
            ERZA_NAME,
            ERZA_MAXHP,
            ERZA_DEFENSE,
            queueK
        )
        erza shouldNotBeSameInstanceAs erzaCat
        erza shouldBe erzaCat
    }
    test(
        "Two enemies with different parameters should not be equal"
    ) {
        darkness shouldNotBeSameInstanceAs erza
        darkness shouldNotBe erza
    }
    test(
        "weapon equipped should be the same"
    ) {
        val sword = Sword("VeryExpensiveSword", 100, 100)
        darkness.equip(sword)
        darkness.equippedWeapon shouldBe sword
        val axe = Axe("VeryExpensiveAxe", 50, 100)
        darkness.equip(axe)
        darkness.equippedWeapon shouldBe axe
        val knife = Knife("VeryExpensiveKnife", 1, 12)
        darkness.equip(knife)
        darkness.equippedWeapon shouldBe knife
    }
    test(
        "weapon no allowed for this class, should be the last valid weapon equiped"
    ) {
        val staff = Staff("Gema del tiempo", 30, 12)
        val axe = Axe("Ntofos", 15, 40)
        val sword = Sword("AllOut", 30, 20)
        val bow = Bow("Cience", 50, 30)
        val knife = Knife("Chunchunmaru", 15, 3)
        darkness.equip(sword)
        darkness.equippedWeapon shouldBe sword
        darkness.equip(staff)
        darkness.equippedWeapon shouldNotBe staff
        darkness.equip(axe)
        darkness.equippedWeapon shouldBe axe
        darkness.equip(bow)
        darkness.equippedWeapon shouldNotBe bow
        darkness.equip(knife)
        darkness.equippedWeapon shouldBe knife
    }
})
