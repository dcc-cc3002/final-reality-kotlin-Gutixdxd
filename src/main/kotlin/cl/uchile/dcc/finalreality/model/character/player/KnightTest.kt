package cl.uchile.dcc.finalreality.model.character.player

import cl.uchile.dcc.finalreality.model.character.GameCharacter
import cl.uchile.dcc.finalreality.model.items.Sword
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import io.kotest.matchers.types.shouldNotBeSameInstanceAs
import java.util.concurrent.LinkedBlockingQueue


val queueK = LinkedBlockingQueue<GameCharacter>()

private const val DARKNESS_NAME= "darkness"
private const val DARKNESS_MAXHP= 30
private const val DARKNESS_DEFENSE= 40

private const val ERZA_NAME= "erza"
private const val ERZA_MAXHP= 40
private const val ERZA_DEFENSE= 60


class KnightTest : FunSpec ({
    lateinit var darkness : Knight
    lateinit var erza : Knight
    beforeEach{
        darkness= Knight(DARKNESS_NAME,
                         DARKNESS_MAXHP,
                         DARKNESS_DEFENSE,
                         queueK
        )
        erza= Knight(
            ERZA_NAME,
            ERZA_MAXHP,
            ERZA_DEFENSE,
            queueK
        )
    }
    test(
        "Two enemies with the same parameters should be equal"
    ){
        val darknessMask= Knight(
            DARKNESS_NAME,
            DARKNESS_MAXHP,
            DARKNESS_DEFENSE,
            queueK
        )
        darkness shouldNotBeSameInstanceAs darknessMask
        darkness shouldBe darknessMask
        val erzaCat= Knight(
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
    ){
        darkness shouldNotBeSameInstanceAs erza
        darkness shouldNotBe erza
    }
    test(
        "Equip sword"
    ){
        val sword=Sword("lol", 10, 10)
        darkness.equip(sword)
    }
})