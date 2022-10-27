package com.example.core.utils

import android.os.Build
import android.text.Html
import android.text.method.LinkMovementMethod
import android.util.TypedValue
import android.view.Gravity
import android.widget.TextView
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.core.text.HtmlCompat
import com.example.core.R

const val DEFAULT_MINIMUM_TEXT_LINE = 5
const val DEFAULT_MINIMUM_LENGTH = 60

@Composable
fun HtmlTextWithoutExpanding(
    html: String,
    modifier: Modifier = Modifier,
    lineSpacing: Float = 1.5f,
    fontFamily: Int = R.font.space_grotesk_regular_400,
    textSize: Int = 12,
    textColor: Int = R.color.white,
    textAlign: Int = Gravity.CENTER
) {
    if (html.isEmpty()) {
        return
    }


    ConstraintLayout(modifier = modifier.fillMaxWidth()) {
        val (contentText) = createRefs()

        AndroidView(
            modifier = modifier
                .fillMaxWidth()
                .constrainAs(contentText) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            factory = { context ->
                val customTypeFace = ResourcesCompat.getFont(context, fontFamily)
                val size = context.resources.getDimension(textSize)

                TextView(context).apply {
                    setTextColor(ContextCompat.getColor(context, textColor))
                    typeface = customTypeFace
                    setLineSpacing(lineSpacing, lineSpacing)
                    setTextSize(TypedValue.COMPLEX_UNIT_PX, size)
                    movementMethod = LinkMovementMethod.getInstance()
                    gravity = textAlign
                }
            },
            update = {
                it.text =
                    Html.fromHtml(
                        html,
                        Html.FROM_HTML_MODE_LEGACY
                    )
            }
        )
    }
}

enum class ExpandedState(val state: String) {
    COLLAPSE("collapse"), EXPAND("expand")
}


@Composable
fun HtmlText(
    html: String,
    modifier: Modifier = Modifier,
    lineSpacing: Float = 1.5f,
    fontFamily: Int = R.font.space_grotesk_regular_400,
    textSize: Int = 12,
    textColor: Int = R.color.white,
    showMoreText: String = " See more",
    showLessText: String = " See less",
    collapsedMaxLine: Int = DEFAULT_MINIMUM_TEXT_LINE,
    expandedState: MutableState<ExpandedState>
) {
    var isEnableShowMore by remember { mutableStateOf(true) }

    if (html.isEmpty()) {
        return
    }


    ConstraintLayout(modifier = modifier.fillMaxWidth()) {
        val (contentText, seeMore) = createRefs()

        AndroidView(
            modifier = modifier
                .fillMaxWidth()
                .constrainAs(contentText) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            factory = { context ->
                val customTypeFace = ResourcesCompat.getFont(context, fontFamily)
                val size = context.resources.getDimension(textSize)

                TextView(context).apply {
                    setTextColor(ContextCompat.getColor(context, textColor))
                    typeface = customTypeFace
                    setLineSpacing(lineSpacing, lineSpacing)
                    setTextSize(TypedValue.COMPLEX_UNIT_PX, size)
                    maxLines =
                        if (expandedState.value == ExpandedState.EXPAND) Int.MAX_VALUE else collapsedMaxLine
                    setOnClickListener {
                        if (expandedState.value == ExpandedState.EXPAND) {
                            expandedState.value = ExpandedState.COLLAPSE
                        } else {
                            expandedState.value = ExpandedState.EXPAND
                        }
                    }
                    movementMethod = LinkMovementMethod.getInstance()
                }
            },
            update = {
                it.text = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    Html.fromHtml(
                        html,
                        Html.FROM_HTML_MODE_LEGACY
                    )
                } else {
                    HtmlCompat.fromHtml(
                        html,
                        HtmlCompat.FROM_HTML_MODE_LEGACY
                    )
                }
                it.maxLines =
                    if (expandedState.value == ExpandedState.EXPAND) Int.MAX_VALUE else collapsedMaxLine

                isEnableShowMore = html.length > DEFAULT_MINIMUM_LENGTH
            }
        )

        if (isEnableShowMore) {
//            BoldText(
//                content = if (expandedState.value == ExpandedState.EXPAND) showLessText else showMoreText,
//                fontSize = getFontSize12sp(),
//                modifier = Modifier
//                    .constrainAs(seeMore) {
//                        top.linkTo(contentText.bottom)
//                        end.linkTo(parent.end)
//                        height = Dimension.fillToConstraints
//                    }
//                    .clickable {
//                        if (expandedState.value == ExpandedState.EXPAND) {
//                            expandedState.value = ExpandedState.COLLAPSE
//                        } else {
//                            expandedState.value = ExpandedState.EXPAND
//                        }
//                    })
        }

    }


}