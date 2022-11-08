package cl.uchile.dcc.finalreality.model.character.player

import cl.uchile.dcc.finalreality.model.character.GameCharacter
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import io.kotest.matchers.types.shouldNotBeSameInstanceAs
import java.util.concurrent.LinkedBlockingQueue


val queueE = LinkedBlockingQueue<GameCharacter>()

private const val SENKU_NAME= "senku"
private const val SENKU_MAXHP= 30
private const val SENKU_DEFENSE= 40

private const val SHIKIZAKIKIKI_NAME= "shikizakiKiki"
private const val SHIKIZAKIKIKI_MAXHP= 40
private const val SHIKIZAKIKIKI_DEFENSE= 60


class EngineerTest : FunSpec ({
    lateinit var senku : Engineer
    lateinit var shikizakiKiki : Engineer
    beforeEach{
        senku= Engineer(
            SENKU_NAME,
            SENKU_MAXHP,
            SENKU_DEFENSE,
            queueE
        )
        shikizakiKiki= Engineer(
            SHIKIZAKIKIKI_NAME,
            SHIKIZAKIKIKI_MAXHP,
            SHIKIZAKIKIKI_DEFENSE,
            queueE
        )
    }
    test(
        "Two enemies with the same parameters should be equal"
    ){
        val senkuCosplayer= Engineer(
            SENKU_NAME,
            SENKU_MAXHP,
            SENKU_DEFENSE,
            queueE
        )
        senku shouldNotBeSameInstanceAs senkuCosplayer
        senku shouldBe senkuCosplayer
        val hooManiwa= Engineer(
            SHIKIZAKIKIKI_NAME,
            SHIKIZAKIKIKI_MAXHP,
            SHIKIZAKIKIKI_DEFENSE,
            queueE
        )
        shikizakiKiki shouldNotBeSameInstanceAs hooManiwa
        shikizakiKiki shouldBe hooManiwa
    }
    test(
        "Two enemies with different parameters should not be equal"
    ){
        senku shouldNotBeSameInstanceAs shikizakiKiki
        senku shouldNotBe shikizakiKiki
    }
})