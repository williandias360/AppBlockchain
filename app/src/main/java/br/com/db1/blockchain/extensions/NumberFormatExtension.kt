package br.com.db1.blockchain.extensions

import java.math.BigDecimal
import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.*

fun BigDecimal.formatCurrencyNumber(): String {
    return NumberFormat.getCurrencyInstance(Locale("pt", "US")).format(this)
}