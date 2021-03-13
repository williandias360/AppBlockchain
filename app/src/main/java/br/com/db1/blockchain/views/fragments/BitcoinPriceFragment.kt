package br.com.db1.blockchain.views.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import br.com.db1.blockchain.R
import br.com.db1.blockchain.databinding.FragmentBitcoinPriceBinding
import br.com.db1.blockchain.viewModels.StatsViewModel
import java.math.BigDecimal

class BitcoinPriceFragment : Fragment() {
    val viewModel: StatsViewModel by lazy {
        ViewModelProvider(this).get(StatsViewModel::class.java)
    }
    var _binding: FragmentBitcoinPriceBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentBitcoinPriceBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_bitcoin_price, container, false)

        _binding = binding
        _binding?.stats = viewModel.states
        return binding.viewRoot
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            BitcoinPriceFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}