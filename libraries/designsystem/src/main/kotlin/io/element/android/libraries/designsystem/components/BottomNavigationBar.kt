/*
 * Copyright 2024 New Vector Ltd.
 *
 * SPDX-License-Identifier: AGPL-3.0-only
 * Please see LICENSE in the repository root for full details.
 */

package io.element.android.libraries.designsystem.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import io.element.android.compound.tokens.generated.CompoundIcons
import androidx.compose.ui.unit.dp
import io.element.android.libraries.designsystem.preview.PreviewWithLargeHeight
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Alignment

@Composable
fun BottomNavigationBar(
    onHomeClick: () -> Unit,
    onCreateRoomClick: () -> Unit,
    onSettingsClick: () -> Unit,
    modifier: Modifier = Modifier,
    height: Dp = 72.dp,
    selectedItem: Int = 0
) {
    BottomAppBar(
        modifier = modifier.height(height),
        content = {
            Box(
                modifier = Modifier.fillMaxSize(),
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.TopCenter)
                        .padding(top = 1.dp), // 增加顶部内边距,使图标更靠近顶部
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    IconButton(
                        onClick = onHomeClick,
                        modifier = Modifier.padding(top = 0.dp) // 移除图标按钮的顶部内边距
                    ) {
                        Icon(
                            imageVector = CompoundIcons.Chat(),
                            contentDescription = "Home",
                            tint = if (selectedItem == 0) Color(0xFF23EA22) else LocalContentColor.current
                        )
                    }
                    IconButton(
                        onClick = onCreateRoomClick,
                        modifier = Modifier.padding(top = 0.dp) // 移除图标按钮的顶部内边距
                    ) {
                        Icon(
                            imageVector = CompoundIcons.UserAdd(),
                            contentDescription = "Create Room",
                            tint = if (selectedItem == 1) Color(0xFF23EA22) else LocalContentColor.current
                        )
                    }
                    IconButton(
                        onClick = onSettingsClick,
                        modifier = Modifier.padding(top = 0.dp) // 移除图标按钮的顶部内边距
                    ) {
                        Icon(
                            imageVector = CompoundIcons.Settings(),
                            contentDescription = "Settings",
                            tint = if (selectedItem == 2) Color(0xFF23EA22) else LocalContentColor.current
                        )
                    }
                }
            }
        }
    )
}

@Composable
@Preview(showBackground = true)
fun BottomNavigationBarPreview() {
    BottomNavigationBar(
        onHomeClick = {},
        onCreateRoomClick = {},
        onSettingsClick = {},
    )
}
