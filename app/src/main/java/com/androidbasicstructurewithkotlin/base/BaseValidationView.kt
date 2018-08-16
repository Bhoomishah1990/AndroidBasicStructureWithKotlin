package com.androidbasicstructurewithkotlin.base

import com.androidbasicstructurewithkotlin.validator.ValidationErrorModel

/**
 * Created by Darshna Desai on 27/3/18.
 */
interface BaseValidationView<in T> : BaseResponseView<T> {
    fun onValidationError(validationErrorModel: ValidationErrorModel)
}