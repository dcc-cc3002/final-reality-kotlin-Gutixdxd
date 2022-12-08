package cl.uchile.dcc.finalreality.model.character.player

import cl.uchile.dcc.finalreality.model.character.Enemy

class BaseState(override val character: Enemy): EnemyState {
    override fun RetBase() {
        return
    }

    override fun DoSomething() {
        return
    }

    override fun CheckState(): String {
        return "BaseState"
    }
}