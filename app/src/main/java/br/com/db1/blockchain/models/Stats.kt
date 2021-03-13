package br.com.db1.blockchain.models

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import br.com.db1.blockchain.BR
import java.math.BigDecimal

class Stats : BaseObservable() {
    var market_price_usd: BigDecimal? = null
        @Bindable get
        set(value) {
            field =  value
            notifyPropertyChanged(BR.market_price_usd)
        }
}