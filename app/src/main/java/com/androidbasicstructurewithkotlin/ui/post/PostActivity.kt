package com.androidbasicstructurewithkotlin.ui.post

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.androidbasicstructurewithkotlin.R
import com.androidbasicstructurewithkotlin.base.BaseActivity
import com.androidbasicstructurewithkotlin.databinding.ActivityPostBinding
import com.androidbasicstructurewithkotlin.model.Post
import com.androidbasicstructurewithkotlin.utils.Utility
import kotlinx.android.synthetic.main.activity_post.*

/**
 * Activity displaying the list of posts
 */
class PostActivity : BaseActivity<PostPresenter>(), PostView<List<Post>> {

    /**
     * DataBinding instance
     */
    private lateinit var binding: ActivityPostBinding

    /**
     * The adapter for the list of posts
     */
    private val postsAdapter = PostAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_post)
        binding.adapter = postsAdapter
        binding.layoutManager = LinearLayoutManager(this)
        binding.dividerItemDecoration = DividerItemDecoration(this, LinearLayoutManager.VERTICAL)

        presenter.onViewCreated()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onViewDestroyed()
    }

    override fun showError(error: String) {
        Utility.showSnackBar(posts, error)
    }

    override fun showLoading() {
        binding.progressVisibility = View.VISIBLE
    }

    override fun hideLoading() {
        binding.progressVisibility = View.GONE
    }

    override fun instantiatePresenter(): PostPresenter {
        return PostPresenter(this)
    }

    override fun onSuccess(response: List<Post>) {
        postsAdapter.updatePosts(response)
    }

    override fun onFailure(message: String) {
    }

    fun onToolbarLeftClick(view: View) {
        finish()
    }
}