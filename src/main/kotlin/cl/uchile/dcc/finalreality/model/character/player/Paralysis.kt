package cl.uchile.dcc.finalreality.model.character.player

import cl.uchile.dcc.finalreality.model.character.Enemy

class Paralysis(override val character: Enemy): EnemyState {
    var turns_left=1

    override fun DoSomething() {
        if(turns_left<=0) this.RetBase()
        else turns_left-=1
    }
    override fun CheckState(): String {
        return "Paralysis"
    }
}