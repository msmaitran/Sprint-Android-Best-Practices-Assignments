package com.lambdaschool.mortgagecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jakewharton.rxbinding3.widget.textChanges
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.Observables
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    private lateinit var secondDisposable: Disposable
    private lateinit var disposable: Disposable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val obsPurchasePrice = et_purchase_price.textChanges()
        val obsDownPayment = et_downpayment.textChanges()
        val obsInterestRate = et_interest_rate.textChanges()
        val obsLoanLength = et_loan_length.textChanges()

        val obsCombined = Observables.combineLatest(obsPurchasePrice, obsDownPayment, obsInterestRate, obsLoanLength){_,_,_,_ -> calculateMortgagePayment()}

        disposable = obsCombined.observeOn(AndroidSchedulers.mainThread()).subscribe{result -> tv_answer.text = result.toString()}

        secondDisposable = Retro.create().getNumbers(2, "uint8")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .onErrorReturn { Numbers(arrayOf(1)) }
            .subscribe { numbers -> numbers.data[0].toString()}
    }

    override fun onDestroy() {
        disposable.dispose()
        secondDisposable.dispose()
        super.onDestroy()
    }

    fun calculateMortgagePayment(): Double{
        val purchasePrice = et_purchase_price.text.toString()
        val downpayment = et_downpayment.text.toString()
        val interestRate = et_interest_rate.text.toString()
        val loanLength = et_loan_length.text.toString()

        return if (purchasePrice.isEmpty() ||
            downpayment.isEmpty() ||
            interestRate.isEmpty() ||
            loanLength.isEmpty()) {
            0.00
        } else {
            val interestPerMonth = interestRate.toDouble() / 100 / 12
            val payPeriods = loanLength.toInt()
            val loanAmount = purchasePrice.toDouble() - downpayment.toDouble()

            // A = Pr(1+r)^n/((1+r)^n - 1)
            val dividend: Double = (1+interestPerMonth).pow(payPeriods)*interestPerMonth*loanAmount
            val divisor: Double = (1+interestPerMonth).pow(payPeriods)-1
            dividend/divisor
        }
    }
}
