package cl.uchile.dcc.finalreality.model.character.player

import cl.uchile.dcc.finalreality.model.character.GameCharacter
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
            JULIUS_DEFENSE,
            queueWM
        )
        rudeus= WhiteMage(
            RUDEUS_NAME,
            RUDEUS_MAXHP,
            RUDEUS_MAXMP,
            RUDEUS_DEFENSE,
            queueWM
        )
    }
    test(
        "Two enemies with the same parameters should be equal"
    ){
        val juliusXiquito= WhiteMage(
            JULIUS_NAME,
            JULIUS_MAXHP,
            JULIUS_MAXMP,
            JULIUS_DEFENSE,
            queueWM
        )
        julius shouldNotBeSameInstanceAs juliusXiquito
        julius shouldBe juliusXiquito
        val Orsted= WhiteMage(
            RUDEUS_NAME,
            RUDEUS_MAXHP,
            RUDEUS_MAXMP,
            RUDEUS_DEFENSE,
            queueWM
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
})