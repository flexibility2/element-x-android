package io.element.android.x.features.messages.components

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import io.element.android.x.features.messages.html.HtmlDocument
import io.element.android.x.features.messages.model.content.MessagesTimelineItemTextBasedContent

@Composable
fun MessagesTimelineItemTextView(
    content: MessagesTimelineItemTextBasedContent,
    modifier: Modifier = Modifier
) {
    Box(modifier) {
        if (content.htmlDocument != null) {
            HtmlDocument(document = content.htmlDocument!!)
        } else {
            Text(text = content.body)
        }
    }
}