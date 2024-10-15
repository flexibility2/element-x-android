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
    modifier: Modifier = Modifier
) {
    BottomAppBar(
        modifier = modifier,
        contentPadding = PaddingValues(top = 4.dp, bottom = 0.dp),
        content = {
            Spacer(modifier = Modifier.weight(0.5f))
            IconButton(onClick = onHomeClick) {
                Icon(imageVector = CompoundIcons.Chat(), contentDescription = "Home")
            }
            Spacer(modifier = Modifier.weight(0.8f))
            IconButton(onClick = onCreateRoomClick) {
                Icon(imageVector = CompoundIcons.UserAdd(), contentDescription = "Create Room")
            }
            Spacer(modifier = Modifier.weight(0.8f))
            IconButton(onClick = onSettingsClick) {
                Icon(imageVector = CompoundIcons.Settings(), contentDescription = "Settings")
            }
            Spacer(modifier = Modifier.weight(0.5f))
        }
    )
}

