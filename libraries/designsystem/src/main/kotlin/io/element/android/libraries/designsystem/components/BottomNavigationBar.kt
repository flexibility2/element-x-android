/*
 * Copyright 2024 New Vector Ltd.
 *
 * SPDX-License-Identifier: AGPL-3.0-only
 * Please see LICENSE in the repository root for full details.
 */

package io.element.android.libraries.designsystem.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import io.element.android.compound.tokens.generated.CompoundIcons
import androidx.compose.ui.unit.dp
@Composable
fun BottomNavigationBar(
    onHomeClick: () -> Unit,
    onCreateRoomClick: () -> Unit,
    onSettingsClick: () -> Unit,
    modifier: Modifier = Modifier // 添加 modifier 参数
) {
    BottomAppBar(
        modifier = modifier, // 将 modifier 传递给 BottomAppBar
        contentPadding = PaddingValues(top = 8.dp, bottom = 0.dp),
        content = {
            IconButton(onClick = onHomeClick) {
                Icon(imageVector = CompoundIcons.Home(), contentDescription = "Home")
            }
            Spacer(modifier = Modifier.weight(1f, true))
            IconButton(onClick = onCreateRoomClick) {
                Icon(imageVector = CompoundIcons.UserAdd(), contentDescription = "Create Room")
            }
            Spacer(modifier = Modifier.weight(1f, true))
            IconButton(onClick = onSettingsClick) {
                Icon(imageVector = CompoundIcons.Settings(), contentDescription = "Settings")
            }
        }
    )
}

