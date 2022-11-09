package cl.uchile.dcc.finalreality.model.items

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import io.kotest.matchers.types.shouldNotBeSameInstanceAs

private const val AXE_NAME = "Rita"
private const val AXE_DAMAGE = 40
private const val AXE_WEIGHT = 100

private const val SWORD_NAME = "Matadragones"
private const val SWORD_DAMAGE = 20
private const val SWORD_WEIGHT = 80

private const val BOW_NAME = "Aqua Simulacra"
private const val BOW_DAMAGE = 35
private const val BOW_WEIGHT = 20

private const val KNIFE_NAME = "Kunai"
private const val KNIFE_DAMAGE = 5
private const val KNIFE_WEIGHT = 1

private const val STAFF_NAME = "Baston del sello"
private const val STAFF_DAMAGE = 5
private const val STAFF_WEIGHT = 1

class WeaponTest : FunSpec({
    lateinit var rita: Axe
    lateinit var matadragones: Sword
    lateinit var aquaSimulacra: Bow
    lateinit var kunai: Knife
    lateinit var bastonDelSello: Staff
    beforeEach {
        rita = Axe(
            AXE_NAME,
            AXE_DAMAGE,
            AXE_WEIGHT
        )
        matadragones = Sword(
            SWORD_NAME,
            SWORD_DAMAGE,
            SWORD_WEIGHT
        )
        aquaSimulacra = Bow(
            BOW_NAME,
            BOW_DAMAGE,
            BOW_WEIGHT
        )
        kunai = Knife(
            KNIFE_NAME,
            KNIFE_DAMAGE,
            KNIFE_WEIGHT
        )
        bastonDelSello = Staff(
            STAFF_NAME,
            STAFF_DAMAGE,
            STAFF_WEIGHT
        )
    }
    test(
        "Two weapons with the same parameters should be equal"
    ) {
        val rita2 = Axe(
            AXE_NAME,
            AXE_DAMAGE,
            AXE_WEIGHT
        )
        val matadragones2 = Sword(
            SWORD_NAME,
            SWORD_DAMAGE,
            SWORD_WEIGHT
        )
        val aquaSimulacra2 = Bow(
            BOW_NAME,
            BOW_DAMAGE,
            BOW_WEIGHT
        )
        val kunai2 = Knife(
            KNIFE_NAME,
            KNIFE_DAMAGE,
            KNIFE_WEIGHT
        )
        val bastonEstrella = Staff(
            STAFF_NAME,
            STAFF_DAMAGE,
            STAFF_WEIGHT
        )
        rita shouldNotBeSameInstanceAs rita2
        rita shouldBe rita2
        matadragones shouldNotBeSameInstanceAs matadragones2
        matadragones shouldBe matadragones2
        aquaSimulacra shouldNotBeSameInstanceAs aquaSimulacra2
        aquaSimulacra shouldBe aquaSimulacra2
        kunai shouldNotBeSameInstanceAs kunai2
        kunai shouldBe kunai2
        bastonDelSello shouldNotBeSameInstanceAs bastonEstrella
        bastonDelSello shouldBe bastonEstrella
    }
    test(
        "Two weapons with different parameters should not be equal"
    ) {
        rita shouldNotBeSameInstanceAs matadragones
        rita shouldNotBe matadragones
        aquaSimulacra shouldNotBeSameInstanceAs kunai
        aquaSimulacra shouldNotBe kunai
        bastonDelSello shouldNotBeSameInstanceAs rita
        bastonDelSello shouldNotBe rita
    }
})
