package android.template.ui.base

import android.content.Intent
import android.template.ui.model.AlertDialogUiState
import android.template.ui.model.BottomSheetDialogUiState
import android.template.ui.model.SnackbarType

data class BaseUiState<T>(
    val message: String? = null,
    val errorMessage: String? = null,
    val mainUiState: T? = null,
    val popBackStackTo: String? = null,
    val alertDialogMessages: List<AlertDialogUiState> = listOf(),
    val bottomSheetDialogMessages: List<BottomSheetDialogUiState> = listOf(),
    val openBottomSheet: Boolean = false,
    val openIntent: Intent? = null,
    val snackbarTitle: String? = null,
    val snackbarSubtitle: String? = null,
    val isSnackbarError: Boolean = false,
    val isCloseApp: Boolean = false,
    val isApiError: Boolean = false,
    val isCloseBottomSheet: Boolean = false,
    val isConnectedInternet: Boolean = true,
    val initialMethod: Boolean = false,
    val snackbarType: SnackbarType = SnackbarType.SUCCESS,
    val isLoading: Boolean = false,
)
