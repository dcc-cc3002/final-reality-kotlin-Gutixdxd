package cl.uchile.dcc.finalreality.model.character.player


import cl.uchile.dcc.finalreality.model.character.GameCharacter
import cl.uchile.dcc.finalreality.model.items.Staff
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import io.kotest.matchers.types.shouldNotBeSameInstanceAs
import java.util.concurrent.LinkedBlockingQueue


val queueBM = LinkedBlockingQueue<GameCharacter>()

private const val STRANGE_NAME= "drStrange"
private const val STRANGE_MAXHP= 12
private const val STRANGE_MAXMP= 10
private const val STRANGE_DEFENSE= 10

private const val KARTHUS_NAME= "karthus"
private const val KARTHUS_MAXHP= 10
private const val KARTHUS_MAXMP= 10
private const val KARTHUS_DEFENSE= 10


class BlackMageTest : FunSpec ({

    lateinit var drStrange : BlackMage
    lateinit var karthus : BlackMage
    beforeEach{
        drStrange= BlackMage(
            STRANGE_NAME,
            STRANGE_MAXHP,
            STRANGE_MAXMP,
            queueBM,
            STRANGE_DEFENSE
        )
        karthus= BlackMage(
            KARTHUS_NAME,
            KARTHUS_MAXHP,
            KARTHUS_MAXMP,
            queueBM,
            KARTHUS_DEFENSE
        )
    }
    test(

        "Two enemies with the same parameters should be equal"
    ){
        val drStrangeMultiverso= BlackMage(
            STRANGE_NAME,
            STRANGE_MAXHP,
            STRANGE_MAXMP,
            queueBM,
            STRANGE_DEFENSE,
            )
        drStrange shouldNotBeSameInstanceAs drStrangeMultiverso
        drStrange shouldBe drStrangeMultiverso

        val LaParcaKarthus= BlackMage(
            KARTHUS_NAME,
            KARTHUS_MAXHP,
            KARTHUS_MAXMP,
            queueBM,
            KARTHUS_DEFENSE
        )
        karthus shouldNotBeSameInstanceAs LaParcaKarthus
        karthus shouldBe LaParcaKarthus
    }
    test(
        "Two enemies with different parameters should not be equal"
    ){
        drStrange shouldNotBeSameInstanceAs karthus
        drStrange shouldNotBe karthus
    }
    test(
        "Mp should be the same as the val that is in the beginning"
    ){
        drStrange.maxMp shouldBe STRANGE_MAXMP
    }
    test(
        "weapon equipped should be the same"
    ){
        val staff=Staff("Gema del tiempo", 30, 12)
        drStrange.equip(staff)
        drStrange.equippedWeapon shouldBe staff
    }
})