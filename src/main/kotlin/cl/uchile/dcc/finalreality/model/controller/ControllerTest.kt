package cl.uchile.dcc.finalreality.model.controller

import cl.uchile.dcc.finalreality.model.character.player.Thief
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.ints.shouldBeLessThan
import io.kotest.matchers.ints.shouldBeLessThanOrEqual
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class ControllerTest: FunSpec({
    lateinit var game: Controller
    beforeEach{
        game=Controller()
        game.StartGame(1)
    }
    test(
        "game.Party should be size 4"
    ){
        game.Party.size shouldBe 4
    }
    test(
        "game.EnemyParty should be size less than 4 and more than 0"
    ){
        game.EnemyParty.size shouldBeLessThanOrEqual 4
        1 shouldBeLessThanOrEqual game.EnemyParty.size
    }
})