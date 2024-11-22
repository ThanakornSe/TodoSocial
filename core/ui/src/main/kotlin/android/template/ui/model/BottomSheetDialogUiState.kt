package android.template.ui.model

data class BottomSheetDialogUiState(
    val key: String? = null,
    val title: String? = null,
    val message: String? = null,
    val positiveButton: String? = null,
    val negativeButton: String? = null,
    val dismissOnBackPress: Boolean = true,
    val dismissOnClickOutside: Boolean = true,
    val isFullScreen: Boolean = false,
    val detailList: List<String>? = null,
)
