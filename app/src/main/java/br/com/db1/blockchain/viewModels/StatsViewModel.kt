package br.com.db1.blockchain.viewModels

import androidx.lifecycle.ViewModel
import br.com.db1.blockchain.models.Stats
import java.math.BigDecimal

class StatsViewModel : ViewModel() {

    var states = Stats()

    fun updateValue(aValue: BigDecimal) {
        states.market_price_usd = aValue
    }

}