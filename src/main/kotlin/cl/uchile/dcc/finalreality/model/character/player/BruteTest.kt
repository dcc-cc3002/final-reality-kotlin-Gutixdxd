package cl.uchile.dcc.finalreality.model.character.player

import cl.uchile.dcc.finalreality.model.character.GameCharacter
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
})