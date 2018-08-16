package com.androidbasicstructurewithkotlin.ui.post

import com.androidbasicstructurewithkotlin.R
import com.androidbasicstructurewithkotlin.base.BasePresenter
import com.androidbasicstructurewithkotlin.enums.ApiRequestUrlEnum
import com.androidbasicstructurewithkotlin.model.Post
import com.androidbasicstructurewithkotlin.network.RestApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * The Presenter that will present the Post view.
 * @param postView the Post view to be presented by the presenter
 * @property restApi the API interface implementation
 * @property subscription the subscription to the API call
 */
class PostPresenter(postView: PostView<List<Post>>) : BasePresenter<PostView<List<Post>>>(postView) {
    @Inject
    lateinit var restApi: RestApi

    private var subscription: Disposable? = null

    override fun onViewCreated() {
        loadPosts()
    }

    /**
     * Loads the posts from the API and presents them in the view when retrieved, or shows error if
     * any.
     */
    private fun loadPosts() {
        if (view.hasInternet()) {
            view.showLoading()
            subscription = restApi
                    .getPosts(ApiRequestUrlEnum.GET_POSTS.getValue())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .doOnTerminate { view.hideLoading() }
                    .subscribe(
                            { postList -> view.onSuccess(postList) },
                            { view.showError(R.string.unknown_error) }
                    )
        } else {
            view.showError(R.string.unknown_error)
        }
    }

    override fun onViewDestroyed() {
        subscription?.dispose()
    }
}