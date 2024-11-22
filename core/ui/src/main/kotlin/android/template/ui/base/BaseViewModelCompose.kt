package android.template.ui.base

import android.app.Activity
import android.content.Intent
import android.template.ui.model.AlertDialogUiState
import android.template.ui.model.BottomSheetDialogUiState
import android.template.ui.model.SnackbarType
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

open class BaseViewModelCompose<T> : ViewModel() {
    // Alert Message List
    protected var alertDialogMessages: List<AlertDialogUiState> = listOf()
    protected var bottomSheetDialogMessges: List<BottomSheetDialogUiState> = listOf()

    @Suppress("ktlint:standard:property-naming")
    // Expose screen UI state
    protected val _uiState = MutableStateFlow(BaseUiState<T>())
    open val uiState: StateFlow<BaseUiState<T>> get() = _uiState.asStateFlow()

    fun clearMessage() {
        _uiState.update { currentState ->
            currentState.copy(
                message = null,
            )
        }
    }

    fun clearErrorMessage() {
        _uiState.update { currentState ->
            currentState.copy(
                errorMessage = null,
            )
        }
    }

    fun setLoading(isLoading: Boolean) {
        _uiState.update { currentState ->
            currentState.copy(
                isLoading = isLoading,
            )
        }
    }

    fun setApiError(isApiError: Boolean) {
        _uiState.update { currentState ->
            currentState.copy(
                isApiError = isApiError,
            )
        }
    }

    fun setUpBottomSheetDialog(
        key: String,
        title: String? = null,
        message: String? = null,
        detailList: List<String>? = null,
        isFullScreen: Boolean = false,
        positiveButton: String? = null,
        negativeButton: String? = null,
        dismissOnBackPress: Boolean = true,
        dismissOnClickOutside: Boolean = true,
    ) {
        bottomSheetDialogMessges =
            mutableListOf<BottomSheetDialogUiState>().apply {
                addAll(bottomSheetDialogMessges)
                add(
                    BottomSheetDialogUiState(
                        key = key,
                        title = title,
                        message = message,
                        positiveButton = positiveButton,
                        negativeButton = negativeButton,
                        dismissOnBackPress = dismissOnBackPress,
                        dismissOnClickOutside = dismissOnClickOutside,
                        detailList = detailList,
                        isFullScreen = isFullScreen,
                    ),
                )
            }

        _uiState.update { currentState ->
            currentState.copy(
                openBottomSheet = true,
                bottomSheetDialogMessages = bottomSheetDialogMessges.map { it.copy() },
            )
        }
    }

    open fun onBottomSheetDialogClick(
        key: String,
        isPositive: Boolean,
        activity: Activity? = null,
        value: String? = null,
    ) {
        clearBottomSheetDialog(key)
    }

    open fun clearBottomSheetDialog(key: String) {
        bottomSheetDialogMessges =
            try {
                bottomSheetDialogMessges.filter { it.key != key }
            } catch (_: Exception) {
                listOf()
            }
        _uiState.update { currentState ->
            currentState.copy(
                bottomSheetDialogMessages = bottomSheetDialogMessges.map { it.copy() },
            )
        }
    }

    fun openAlertDialog(
        key: String,
        title: String? = null,
        message: String? = null,
        detailList: List<String>? = null,
        isFullScreen: Boolean = false,
        positiveButton: String? = null,
        negativeButton: String? = null,
        dismissOnBackPress: Boolean = true,
        dismissOnClickOutside: Boolean = true,
    ) {
        alertDialogMessages =
            mutableListOf<AlertDialogUiState>().apply {
                addAll(alertDialogMessages)
                add(
                    AlertDialogUiState(
                        key = key,
                        title = title,
                        message = message,
                        positiveButton = positiveButton,
                        negativeButton = negativeButton,
                        dismissOnBackPress = dismissOnBackPress,
                        dismissOnClickOutside = dismissOnClickOutside,
                        detailList = detailList,
                        isFullScreen = isFullScreen,
                    ),
                )
            }

        _uiState.update { currentState ->
            currentState.copy(
                alertDialogMessages = alertDialogMessages.map { it.copy() },
            )
        }
    }

    fun setSnackbarMessage(
        title: String,
        snackbarType: SnackbarType,
    ) {
        _uiState.update { currentState ->
            currentState.copy(
                snackbarTitle = title,
                snackbarType = snackbarType,
            )
        }
    }

    open fun onAlertDialogClick(
        key: String,
        isPositive: Boolean,
        activity: Activity? = null,
    ) {
        clearAlertDialog(key)
    }

    open fun clearAlertDialog(key: String) {
        alertDialogMessages =
            try {
                alertDialogMessages.filter { it.key != key }
            } catch (_: Exception) {
                listOf()
            }
        _uiState.update { currentState ->
            currentState.copy(
                alertDialogMessages = alertDialogMessages.map { it.copy() },
            )
        }
    }

    fun clearAllAlertDialog() {
        _uiState.update { currentState ->
            currentState.copy(
                alertDialogMessages = listOf(),
            )
        }
    }

    fun openIntent(intent: Intent) {
        _uiState.update { currentState ->
            currentState.copy(
                openIntent = intent,
            )
        }
    }

    fun clearOpenIntent() {
        _uiState.update { currentState ->
            currentState.copy(
                openIntent = null,
            )
        }
    }

    fun clearSnackbarMessage() {
        _uiState.update { currentState ->
            currentState.copy(
                snackbarTitle = null,
            )
        }
    }
}
