package cl.uchile.dcc.finalreality.model.character.player

import cl.uchile.dcc.finalreality.model.character.Enemy

interface EnemyState {
    val character: Enemy
    fun RetBase(){
        character.BaseState()
    }
    fun DoSomething()
    fun CheckState(): String
}