package com.androidbasicstructurewithkotlin.ui.login

import com.androidbasicstructurewithkotlin.base.BasePresenter
import com.androidbasicstructurewithkotlin.base.BaseValidationView
import com.androidbasicstructurewithkotlin.enums.ApiParamEnum
import com.androidbasicstructurewithkotlin.network.RestApi
import com.androidbasicstructurewithkotlin.validator.Validator
import io.reactivex.disposables.Disposable
import java.util.*
import javax.inject.Inject

/**
 * Created by Darshna Desai on 27/3/18.
 */

class LoginPresenter(validationView: BaseValidationView<String>)
    : BasePresenter<BaseValidationView<String>>(validationView) {

    @Inject
    lateinit var restApi: RestApi

    private var subscription: Disposable? = null

    override fun onViewCreated() {
    }


    fun isValidData(params: HashMap<String, String>) {

        Validator.validateEmail(params[ApiParamEnum.EMAIL.value])?.let {
            view.onValidationError(it)
            return
        }

        Validator.validatePassword(params[ApiParamEnum.PASSWORD.value])?.let {
            view.onValidationError(it)
            return
        }

        view.onSuccess("")
    }

    override fun onViewDestroyed() {
        subscription?.dispose()
    }

    fun abc(){
        var a: String? = null
        a?.let{
            it
        }
    }
}