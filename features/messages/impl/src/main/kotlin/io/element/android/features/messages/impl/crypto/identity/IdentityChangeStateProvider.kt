/*
 * Copyright 2024 New Vector Ltd.
 *
 * SPDX-License-Identifier: AGPL-3.0-only
 * Please see LICENSE in the repository root for full details.
 */

package io.element.android.features.messages.impl.crypto.identity

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import io.element.android.libraries.designsystem.components.avatar.AvatarData
import io.element.android.libraries.designsystem.components.avatar.AvatarSize
import io.element.android.libraries.matrix.api.core.UserId
import io.element.android.libraries.matrix.api.encryption.identity.IdentityState
import kotlinx.collections.immutable.toImmutableList

class IdentityChangeStateProvider : PreviewParameterProvider<IdentityChangeState> {
    override val values: Sequence<IdentityChangeState>
        get() = sequenceOf(
            anIdentityChangeState(),
            anIdentityChangeState(
                roomMemberIdentityStateChanges = listOf(
                    RoomMemberIdentityStateChange(
                        identityRoomMember = anIdentityRoomMember(disambiguatedDisplayName = "Alice"),
                        identityState = IdentityState.PinViolation,
                    ),
                ),
            ),
        )
}

internal fun anIdentityChangeState(
    roomMemberIdentityStateChanges: List<RoomMemberIdentityStateChange> = emptyList(),
) = IdentityChangeState(
    roomMemberIdentityStateChanges = roomMemberIdentityStateChanges.toImmutableList(),
    eventSink = {},
)

internal fun anIdentityRoomMember(
    userId: UserId = UserId("@alice:example.com"),
    disambiguatedDisplayName: String = userId.value,
    avatarData: AvatarData = AvatarData(
        id = userId.value,
        name = null,
        url = null,
        size = AvatarSize.ComposerAlert,
    ),
) = IdentityRoomMember(
    userId = userId,
    disambiguatedDisplayName = disambiguatedDisplayName,
    avatarData = avatarData,
)