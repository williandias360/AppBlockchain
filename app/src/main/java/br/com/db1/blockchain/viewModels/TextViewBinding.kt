package br.com.db1.blockchain.viewModels

import android.widget.TextView
import androidx.annotation.NonNull
import androidx.databinding.BindingAdapter
import br.com.db1.blockchain.extensions.formatCurrencyNumber
import org.jetbrains.annotations.NotNull
import java.math.BigDecimal

class TextViewBinding {
    companion object {
        @BindingAdapter("android:text")
        @JvmStatic
        fun setIntoToText(@NonNull textView: TextView, @NotNull anBigDecimal: BigDecimal?) {
            textView.text = (anBigDecimal ?: BigDecimal(0)).formatCurrencyNumber()
        }
    }
}