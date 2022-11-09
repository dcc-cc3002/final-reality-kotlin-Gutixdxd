package cl.uchile.dcc.finalreality.model.character

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import io.kotest.matchers.types.shouldNotBeSameInstanceAs
import java.util.concurrent.LinkedBlockingQueue

val queue = LinkedBlockingQueue<GameCharacter>()
private const val ARLONG_NAME = "arlong"
private const val ARLONG_WEIGHT = 10
private const val ARLONG_MAXHP = 10
private const val ARLONG_DEFENSE = 10
private const val ARLONG_ATTACK = 10

private const val MIHAWK_NAME = "mihawk"
private const val MIHAWK_WEIGHT = 5
private const val MIHAWK_MAXHP = 20
private const val MIHAWK_DEFENSE = 12
private const val MIHAWK_ATTACK = 30

class EnemyTest : FunSpec({
    lateinit var arlong: Enemy
    lateinit var mihawk: Enemy

    beforeEach {
        arlong = Enemy(
            ARLONG_NAME,
            ARLONG_WEIGHT,
            ARLONG_MAXHP,
            ARLONG_DEFENSE,
            ARLONG_ATTACK,
            queue
        )
        mihawk = Enemy(
            MIHAWK_NAME,
            MIHAWK_WEIGHT,
            MIHAWK_MAXHP,
            MIHAWK_DEFENSE,
            MIHAWK_ATTACK,
            queue
        )
    }
    test(
        "Two enemies with the same parameters should be equal"
    ) {
        val arlongEnCana = Enemy(
            ARLONG_NAME,
            ARLONG_WEIGHT,
            ARLONG_MAXHP,
            ARLONG_DEFENSE,
            ARLONG_ATTACK,
            queue
        )

        arlong shouldNotBeSameInstanceAs arlongEnCana
        arlong shouldBe arlongEnCana

        val SeraphimMihawk = Enemy(
            MIHAWK_NAME,
            MIHAWK_WEIGHT,
            MIHAWK_MAXHP,
            MIHAWK_DEFENSE,
            MIHAWK_ATTACK,
            queue
        )
        mihawk shouldNotBeSameInstanceAs SeraphimMihawk
        mihawk shouldBe SeraphimMihawk
    }

    test(
        "Two enemies with different parameters should not be equal"
    ) {
        arlong shouldNotBeSameInstanceAs mihawk
        arlong shouldNotBe mihawk
    }
})
