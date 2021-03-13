package br.com.db1.blockchain.extensions

import io.reactivex.*
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.schedulers.Schedulers

fun <T> applyObservableAsync(): ObservableTransformer<T, T> {
    return ObservableTransformer {
        it
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.single())
    }
}

fun <T> applySingleableAsync(): SingleTransformer<T, T> {
    return SingleTransformer {
        it
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.single())
    }
}

fun <T> applyMaybeAsync(): MaybeTransformer<T, T> {
    return MaybeTransformer {
        it
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.single())
    }
}

fun applyCompletableAsync(): CompletableTransformer {
    return CompletableTransformer {
        it
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.single())
    }
}