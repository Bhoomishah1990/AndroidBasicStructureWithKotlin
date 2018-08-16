package com.androidbasicstructurewithkotlin.ui.post

import android.support.annotation.StringRes
import com.androidbasicstructurewithkotlin.base.BaseResponseView

/**
 * Interface providing required method for a view displaying posts
 */
interface PostView<in T> : BaseResponseView<T> {
    /**
     * Updates the previous posts by the specified ones
     * @param posts the list of posts that will replace existing ones
     */
    //fun updatePosts(posts: List<Post>)

    /**
     * Displays an error in the view
     * @param error the error to display in the view
     */
    fun showError(error: String)

    /**
     * Displays an error in the view
     * @param errorResId the resource id of the error to display in the view
     */
    fun showError(@StringRes errorResId: Int) {
        this.showError(getContext().getString(errorResId))
    }
}