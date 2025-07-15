package behavioral.state.template

internal sealed class AuthorizationSate {
    data class Authorized(val username: String): AuthorizationSate()
    data object Unauthorized: AuthorizationSate()
}

internal class AuthorizationPresenter {

    private var state: AuthorizationSate = AuthorizationSate.Unauthorized

    private val isAuthorized: Boolean
        get() = when(state) {
            is AuthorizationSate.Authorized -> true
            is AuthorizationSate.Unauthorized -> false
        }

    val username: String
        get() {
            return when(val state = this.state) {
                is AuthorizationSate.Authorized -> state.username
                is AuthorizationSate.Unauthorized -> "Unknown"
            }
        }

    fun loginUser(username: String) {
        state = AuthorizationSate.Authorized(username)
    }

    fun logoutUser() {
        state = AuthorizationSate.Unauthorized
    }

    override fun toString() = "User $username is logged in: $isAuthorized"

}

fun main() {
    val authorizationPresenter = AuthorizationPresenter()
    authorizationPresenter.loginUser("admin")
    println(authorizationPresenter)
    authorizationPresenter.logoutUser()
    println(authorizationPresenter)
}