/*
 * Copyright 2024 New Vector Ltd.
 *
 * SPDX-License-Identifier: AGPL-3.0-only
 * Please see LICENSE in the repository root for full details.
 */

package io.element.android.libraries.matrix.impl.fixtures.factories

import org.matrix.rustcomponents.sdk.EventTimelineItemDebugInfo

fun anEventTimelineItemDebugInfo(
    model: String = "model",
    originalJson: String? = null,
    latestEditJson: String? = null,
) = EventTimelineItemDebugInfo(
    model = model,
    originalJson = originalJson,
    latestEditJson = latestEditJson
)