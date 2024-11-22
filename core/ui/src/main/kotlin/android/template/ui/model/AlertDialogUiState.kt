package android.template.ui.model

data class AlertDialogUiState(
    val key: String,
    val title: String?,
    val message: String?,
    val positiveButton: String?,
    val negativeButton: String?,
    val dismissOnBackPress: Boolean = true,
    val dismissOnClickOutside: Boolean = true,
    val isFullScreen: Boolean = false,
    val detailList: List<String>? = null,
)
