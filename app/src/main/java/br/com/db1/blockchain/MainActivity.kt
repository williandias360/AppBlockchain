package br.com.db1.blockchain

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import br.com.db1.blockchain.databinding.FragmentBitcoinPriceBinding

import br.com.db1.blockchain.repositories.network.BlockChainNetworkRepository
import br.com.db1.blockchain.viewModels.StatsViewModel
import br.com.db1.blockchain.views.fragments.BitcoinChartFragment
import br.com.db1.blockchain.views.fragments.BitcoinPriceFragment
import java.math.BigDecimal
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    private var bitcoinPriceFragment: BitcoinPriceFragment? = null
    private var bitcoinChartFragment: BitcoinChartFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bitcoinPriceFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_bitcoin_price) as BitcoinPriceFragment
        if (bitcoinPriceFragment == null) {
            bitcoinPriceFragment = BitcoinPriceFragment.newInstance()
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_bitcoin_price, bitcoinPriceFragment!!)
                .commit()
        }

        bitcoinChartFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_bitcoin_chart) as BitcoinChartFragment
        if (bitcoinChartFragment == null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_bitcoin_chart, BitcoinChartFragment())
                .commit()
        }

        getStats()
    }

    //region Methods
    private fun getStats() {
        BlockChainNetworkRepository()
            .getStatsFromApi()
            .subscribe({
                bitcoinPriceFragment?.viewModel?.updateValue(it.market_price_usd ?: BigDecimal(0))
            }, {
                Toast.makeText(this, getString(R.string.txt_fail_get_stats), Toast.LENGTH_SHORT).show()
            })
    }
    //endregion
}