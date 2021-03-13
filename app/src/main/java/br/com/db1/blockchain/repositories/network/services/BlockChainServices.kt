package br.com.db1.blockchain.repositories.network.services

import br.com.db1.blockchain.models.Stats
import io.reactivex.Single
import retrofit2.http.GET

interface BlockChainServices {

    @GET("stats")
    fun getStatsFromApi():Single<Stats>
}