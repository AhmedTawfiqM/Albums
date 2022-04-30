package com.app.presentation.requester

class RequestOptionsHandler(
    private val presenter: Presenter,
) {
    private lateinit var options: RequestOption

    fun setOptions(options: RequestOption) {
        this.options = options
    }

    fun showExceptionError(ex: Throwable) {
        if (options.inlineErrorHandling != null) {
            options.inlineErrorHandling!!(ex)
            return
        }

        presenter.showError(ex)
    }

    fun showExceptionError(msg: String?) {
        if (msg == null) return

        if (options.inlineErrorHandling != null) {
            options.inlineErrorHandling!!(Throwable(msg))
            return
        }

        presenter.showError(msg)
    }

    fun showLoading() = toggleLoading(true)
    fun hideLoading() = toggleLoading(false)

    private fun toggleLoading(toggleLoading: Boolean) {
        if (!options.showLoading)
            return

        when (toggleLoading) {
            true -> presenter.showLoading()
            false -> presenter.hideLoading()
        }
    }
}