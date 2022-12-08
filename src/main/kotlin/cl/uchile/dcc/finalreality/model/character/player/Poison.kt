package cl.uchile.dcc.finalreality.model.character.player

import cl.uchile.dcc.finalreality.model.character.Enemy

class Poison (override val character: Enemy, val magicDamage: Int):EnemyState{
        override fun DoSomething() {
            character.DoDamage(magicDamage/3)
        }
    override fun CheckState(): String {
        return "Poison"
        }
    }