package android.template.ui.base

import android.app.Activity
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext

@ExperimentalMaterial3Api
@Composable
fun <T> BaseViewModelCommonActionCompose(
    viewModel: BaseViewModelCompose<T>,
    snackState: SnackbarHostState = remember { SnackbarHostState() },
) {
    val uiState by viewModel.uiState.collectAsState()

    if (uiState.isLoading) {

    }
    uiState.openIntent?.let {
        LocalContext.current.startActivity(it)
        viewModel.clearOpenIntent()
    }

    val activity = (LocalContext.current) as Activity

    uiState.alertDialogMessages.firstOrNull()?.let {

    }

    val scope = rememberCoroutineScope()

    uiState.openBottomSheet.let {

    }

    LaunchedEffect(key1 = uiState.snackbarTitle) {
        uiState.snackbarTitle?.let {
            snackState
                .showSnackbar(
                    message = it,
                    duration = SnackbarDuration.Short,
                )
            viewModel.clearSnackbarMessage()
        }
    }
}
