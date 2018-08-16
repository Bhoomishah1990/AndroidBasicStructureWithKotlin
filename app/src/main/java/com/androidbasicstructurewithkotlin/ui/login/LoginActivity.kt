package com.androidbasicstructurewithkotlin.ui.login

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.View
import com.androidbasicstructurewithkotlin.R
import com.androidbasicstructurewithkotlin.base.BaseActivity
import com.androidbasicstructurewithkotlin.base.BaseValidationView
import com.androidbasicstructurewithkotlin.databinding.ActivityLoginBinding
import com.androidbasicstructurewithkotlin.enums.ApiParamEnum
import com.androidbasicstructurewithkotlin.ui.post.PostActivity
import com.androidbasicstructurewithkotlin.utils.Constants
import com.androidbasicstructurewithkotlin.utils.Utility
import com.androidbasicstructurewithkotlin.validator.ValidationErrorModel
import kotlinx.android.synthetic.main.activity_login.*

/**
 * Created by Darshna Desai on 27/3/18.
 */

class LoginActivity : BaseActivity<LoginPresenter>(), BaseValidationView<String> {

    /**
     * DataBinding instance
     */
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
    }

    override fun instantiatePresenter(): LoginPresenter {
        return LoginPresenter(this)
    }

    fun onLoginClick(view: View) {
        val params = HashMap<String, String>()
        params[ApiParamEnum.EMAIL.value] = Utility.getText(etEmail)
        params[ApiParamEnum.PASSWORD.value] = Utility.getText(etPassword)
        params[ApiParamEnum.DEVICE_TYPE.value] = Constants.DEVICE_TYPE.toString()
        presenter.isValidData(params)
    }

    override fun onValidationError(validationErrorModel: ValidationErrorModel) {
        Utility.showSnackBar(tvLogin, getString(validationErrorModel.msg))
    }

    override fun onSuccess(response: String) {
        val intent = Intent(this, PostActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun onFailure(message: String) {

    }

}
