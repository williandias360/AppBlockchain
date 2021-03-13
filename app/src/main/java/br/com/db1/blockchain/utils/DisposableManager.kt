package br.com.db1.blockchain.utils

import io.reactivex.disposables.CompositeDisposable


class DisposableManager {

    companion object {
        private val compositeDisposable by lazy {
            CompositeDisposable()
        }

        fun add(disposable: io.reactivex.disposables.Disposable) {
            compositeDisposable.add(disposable)
        }

        fun dispose() {
            compositeDisposable.dispose()
        }
    }
}