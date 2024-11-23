package com.thanakorn.todo.feature.main.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.thanakorn.todo.resource.theme.AppTheme
import com.thanakorn.todo.resource.theme.Typography
import com.thanakorn.todo.resource.theme.availableTask
import com.thanakorn.todo.resource.theme.closeTask
import com.thanakorn.todo.resource.theme.primaryText
import com.thanakorn.todo.resource.theme.secondaryText
import com.thanakorn.todo.resource.theme.space16Dp
import com.thanakorn.todo.resource.theme.space1Dp
import com.thanakorn.todo.resource.theme.space4Dp
import com.thanakorn.todo.resource.theme.space8Dp
import com.thanakorn.todo.resource.theme.white
import com.thanakorns.todo.resource.R.drawable
import com.thanakorns.todo.resource.R.string

@Composable
fun TaskItem(title: String, isCompleted: Boolean) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = white)
    ) {
        Spacer(Modifier.height(space16Dp))
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = space16Dp),
            text = title,
            style = Typography.bodyMedium,
            color = primaryText
        )
        Spacer(Modifier.height(space4Dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = space16Dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(drawable.ic_circle),
                tint = if (isCompleted) {
                    availableTask
                } else {
                    closeTask
                },
                contentDescription = null
            )
            Spacer(Modifier.width(space8Dp))
            Text(
                text = if (isCompleted) {
                    stringResource(string.completed_task)
                } else {
                    stringResource(
                        string.not_completed_task
                    )
                },
                style = Typography.bodySmall,
                color = primaryText
            )
        }
        Spacer(Modifier.height(space16Dp))
        HorizontalDivider(
            Modifier
                .fillMaxWidth()
                .height(space1Dp)
                .background(color = secondaryText)
        )
    }
}

@Preview
@Composable
private fun DefaultTaskItemPreview() {
    AppTheme {
        TaskItem(title = "Task1", isCompleted = false)
    }
}