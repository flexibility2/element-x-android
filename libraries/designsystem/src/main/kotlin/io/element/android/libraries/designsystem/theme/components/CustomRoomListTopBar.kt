/*
 * Copyright 2024 New Vector Ltd.
 *
 * SPDX-License-Identifier: AGPL-3.0-only
 * Please see LICENSE in the repository root for full details.
 */

package io.element.android.libraries.designsystem.theme.components

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.element.android.compound.tokens.generated.CompoundIcons

//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun CustomRoomListTopBar(
//    title: @Composable () -> Unit,
////    navigationIcon: @Composable () -> Unit,
//    actions: @Composable () -> Unit,
//    modifier: Modifier = Modifier,
//    windowInsets: WindowInsets = TopAppBarDefaults.windowInsets,
//    colors: TopAppBarColors = TopAppBarDefaults.mediumTopAppBarColors(),
//    scrollBehavior: TopAppBarScrollBehavior? = null
//) {
//    Surface(
//        modifier = modifier,
//        color = colors.containerColor,
//        tonalElevation = 0.dp // 使用适合的提升值
//    ) {
//        Column(modifier = Modifier.fillMaxWidth()) {
//            // 标题部分
//            Box(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(16.dp),
//                contentAlignment = Alignment.Center
//            ) {
//                title()
//            }
//
//            // 导航图标和操作按钮部分
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(horizontal = 4.dp, vertical = 8.dp),
//                verticalAlignment = Alignment.CenterVertically
//            ) {
////                navigationIcon()
//                Spacer(modifier = Modifier.weight(1f))
//                actions()
//            }
//        }
//    }
//}

//// ... 其他必要的导入和实现 ...
//@Preview(showBackground = true)
//@Composable
//fun CustomRoomListTopBarPreview() {
//    CustomRoomListTopBar(
//        title = { Text(text = "Title") },
//        navigationIcon = {
//            Icon(
//                imageVector = Icons.Default.Menu,
//                contentDescription = "Menu Icon",
//                modifier = Modifier.padding(8.dp)
//            )
//        },
//        actions = {
//            Icon(
//                imageVector = Icons.Default.MoreVert,
//                contentDescription = "More Icon",
//                modifier = Modifier.padding(8.dp)
//            )
//        },
//        modifier = Modifier.fillMaxSize()
//    )
//}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomRoomListTopBar(
    onSearchClick: () -> Unit,
    modifier: Modifier = Modifier,
    windowInsets: WindowInsets = TopAppBarDefaults.windowInsets,
    colors: TopAppBarColors = TopAppBarDefaults.mediumTopAppBarColors(),
    scrollBehavior: TopAppBarScrollBehavior? = null
) {
    val topAppBarState = scrollBehavior?.state
    val scrollFraction = topAppBarState?.collapsedFraction ?: 0f
    Surface(
        modifier = modifier.then(
            if (scrollBehavior != null) {
                Modifier.nestedScroll(scrollBehavior.nestedScrollConnection)
            } else {
                Modifier
            }
        ),
        color = colors.containerColor,
        tonalElevation = 0.dp
    ) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .windowInsetsPadding(windowInsets)

        ) {


            // 搜索栏部分
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
//                contentAlignment = Alignment.Center // 使搜索框水平居中
            ) {
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(40.dp)
                        .clickable(onClick = onSearchClick), // 添加点击事件到整个Surface,
                    shape = RoundedCornerShape(8.dp), // 调整圆角，使其更加方正
                    color = Color.White // 设置背景色为白色
                ) {
                    Row(
                        modifier = Modifier.fillMaxSize(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                            Icon(
                                imageVector = CompoundIcons.Search(),
                                contentDescription = "Search",
                                tint = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f),
                                modifier = Modifier.padding(end = 8.dp)
                            )
                        Text(
                            text = "Search",
                            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f),
//                            modifier = Modifier.weight(1f)
                        )
                    }
                }
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun CustomRoomListTopBarPreview() {
//    MaterialTheme {
//        CustomRoomListTopBar(
//            title = { Text("聊天室列表") },
//            navigationIcon = {
//                IconButton(onClick = {}) {
//                    Icon(CompoundIcons.User(), contentDescription = "用户")
//                }
//            },
//            onSearchClick = {}
//        )
//    }
//}

//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun CustomRoomListTopBar(
//    @SuppressLint("ComposableLambdaParameterPosition") title: @Composable () -> Unit,
//    onSearchClick: () -> Unit,
//    modifier: Modifier = Modifier,
//    windowInsets: WindowInsets = TopAppBarDefaults.windowInsets,
//    colors: TopAppBarColors = TopAppBarDefaults.mediumTopAppBarColors(),
//    scrollBehavior: TopAppBarScrollBehavior? = null
//) {
//    val topAppBarState = scrollBehavior?.state
//    val scrollFraction = topAppBarState?.collapsedFraction ?: 0f
//    Surface(
//        modifier = modifier.then(
//            if (scrollBehavior != null) {
//                Modifier.nestedScroll(scrollBehavior.nestedScrollConnection)
//            } else {
//                Modifier
//            }
//        ),
//        color = colors.containerColor,
//        tonalElevation = 0.dp
//    ) {
//        Column(
//            modifier = Modifier
//                .fillMaxWidth()
//                .windowInsetsPadding(windowInsets)
//        ) {
//            // 标题部分
//            Box(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(32.dp), // 设置一个固定高度，类似于 BottomNavigationBar
//                contentAlignment = Alignment.Center
//            ) {
//                Box(
//                    modifier = Modifier
//                        .fillMaxSize()
//                ) {
//                    title()
//                }
//            }
//
//            // 导航图标和操作按钮部分
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(horizontal = 16.dp),
//                verticalAlignment = Alignment.CenterVertically,
//                horizontalArrangement = Arrangement.SpaceBetween
//            ) {
//                // 这里可以添加导航图标和操作按钮
//                IconButton(onClick = onSearchClick) {
//                    Icon(
//                        imageVector = CompoundIcons.Search(),
//                        contentDescription = null
//                    )
//                }
//            }
//        }
//    }
//}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun CustomRoomListTopBarPreview() {
    CustomRoomListTopBar(
        onSearchClick = {},
        scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior(rememberTopAppBarState())
    )
}
