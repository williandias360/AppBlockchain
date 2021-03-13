package br.com.db1.blockchain.repositories.network

import br.com.db1.blockchain.extensions.applySingleableAsync

class BlockChainNetworkRepository {

    fun getStatsFromApi() =
        RetrofitConfiguration()
            .blockChainServices
            .getStatsFromApi()
            .compose(applySingleableAsync())
}