package cl.uchile.dcc.finalreality.model.character.player

import cl.uchile.dcc.finalreality.model.character.GameCharacter
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import io.kotest.matchers.types.shouldNotBeSameInstanceAs
import java.util.concurrent.LinkedBlockingQueue


val queueT = LinkedBlockingQueue<GameCharacter>()

private const val KAZUMA_NAME= "kazuma"
private const val KAZUMA_MAXHP= 30
private const val KAZUMA_DEFENSE= 40

private const val FELT_NAME= "felt"
private const val FELT_MAXHP= 40
private const val FELT_DEFENSE= 60


class ThiefTest : FunSpec ({
    lateinit var kazuma : Thief
    lateinit var felt : Thief
    beforeEach{
        kazuma= Thief(
            KAZUMA_NAME,
            KAZUMA_MAXHP,
            KAZUMA_DEFENSE,
            queueT
        )
        felt= Thief(
            FELT_NAME,
            FELT_MAXHP,
            FELT_DEFENSE,
            queueT
        )
    }
    test(
        "Two enemies with the same parameters should be equal"
    ){
        val kazumaNecklace= Thief(
            KAZUMA_NAME,
            KAZUMA_MAXHP,
            KAZUMA_DEFENSE,
            queueT
        )
        kazuma shouldNotBeSameInstanceAs kazumaNecklace
        kazuma shouldBe kazumaNecklace
        val feltQueen= Thief(
            FELT_NAME,
            FELT_MAXHP,
            FELT_DEFENSE,
            queueT
        )
        felt shouldNotBeSameInstanceAs feltQueen
        felt shouldBe feltQueen
    }
    test(
        "Two enemies with different parameters should not be equal"
    ){
        kazuma shouldNotBeSameInstanceAs felt
        kazuma shouldNotBe felt
    }
})