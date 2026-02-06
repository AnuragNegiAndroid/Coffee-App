package com.newsapp.mycoffeeapp.presentation.ui_components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun AppMessageDialog(
    show: Boolean,
    title: String,
    msg: String,
    onDismiss: () -> Unit
) {
    if (show) {
        AlertDialog(
            onDismissRequest = { onDismiss() },
            title = {
                Text(title, fontSize = 15.sp,
                    fontWeight = FontWeight.SemiBold)
            },
            text = { Text(msg) },
            confirmButton = {
                TextButton(onClick = { onDismiss() }) {
                    Text("Ok")
                }
            }
        )
    }

}