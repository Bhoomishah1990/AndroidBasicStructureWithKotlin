package com.androidbasicstructurewithkotlin.injection.component

import com.androidbasicstructurewithkotlin.base.BaseView
import com.androidbasicstructurewithkotlin.injection.module.ContextModule
import com.androidbasicstructurewithkotlin.injection.module.NetworkModule
import com.androidbasicstructurewithkotlin.ui.login.LoginPresenter
import com.androidbasicstructurewithkotlin.ui.post.PostPresenter
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton


/**
 * Component providing inject() methods for presenters.
 */
@Singleton
//@Component(modules = [(ContextModule::class), (NetworkModule::class)])
@Component(modules = arrayOf((ContextModule::class), (NetworkModule::class)))
interface PresenterInjector {
    /**
     * Injects required dependencies into the specified PostPresenter.
     * @param postPresenter PostPresenter in which to inject the dependencies
     */
    fun inject(postPresenter: PostPresenter)
    fun inject(loginPresenter: LoginPresenter)

    @Component.Builder
    interface Builder {
        fun build(): PresenterInjector

        fun networkModule(networkModule: NetworkModule): Builder
        fun contextModule(contextModule: ContextModule): Builder

        @BindsInstance
        fun baseView(baseView: BaseView): Builder
    }
}