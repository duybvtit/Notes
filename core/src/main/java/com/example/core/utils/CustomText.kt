package com.example.core.utils

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import com.example.core.theme.White
import com.example.core.theme.spaceGrotesk

@Composable
fun RegularText(
    modifier: Modifier = Modifier,
    content: String,
    fontSize: TextUnit,
    color: Color = White,
    fontWeight: FontWeight = FontWeight.Normal,
    textAlign: TextAlign = TextAlign.Start,
    textDecoration: TextDecoration = TextDecoration.None,
    maxLines: Int = 10,
    isAllowScale: Boolean = true
) {
    var textSize by remember { mutableStateOf(fontSize) }

    Text(
        text = content,
        modifier = modifier,
        style = TextStyle(
            fontFamily = spaceGrotesk,
            fontWeight = fontWeight,
            fontSize = textSize,
            color = color,
            textAlign = textAlign,
            textDecoration = textDecoration,
        ),
        maxLines = maxLines,
        overflow = TextOverflow.Ellipsis,
        onTextLayout = { textLayoutResult ->
            if (isAllowScale) {
                val maxCurrentLineIndex: Int = textLayoutResult.lineCount - 1

                if (textLayoutResult.isLineEllipsized(maxCurrentLineIndex)) {
                    textSize = textSize.times(TEXT_SCALE_REDUCTION_INTERVAL)
                }
            }
        },
    )
}

@Composable
fun RegularTextHTML(
    modifier: Modifier = Modifier,
    content: AnnotatedString,
    fontSize: TextUnit,
    color: Color = White,
    fontWeight: FontWeight = FontWeight.Normal,
    textAlign: TextAlign = TextAlign.Start,
    textDecoration: TextDecoration = TextDecoration.None,
    maxLines: Int = 10,
    isAllowScale: Boolean = true
) {
    var textSize by remember { mutableStateOf(fontSize) }

    Text(
        text = content,
        modifier = modifier,
        style = TextStyle(
            fontFamily = spaceGrotesk,
            fontWeight = fontWeight,
            fontSize = textSize,
            color = color,
            textAlign = textAlign,
            textDecoration = textDecoration,
        ),
        maxLines = maxLines,
        overflow = TextOverflow.Ellipsis,
        onTextLayout = { textLayoutResult ->
            if (isAllowScale) {
                val maxCurrentLineIndex: Int = textLayoutResult.lineCount - 1

                if (textLayoutResult.isLineEllipsized(maxCurrentLineIndex)) {
                    textSize = textSize.times(TEXT_SCALE_REDUCTION_INTERVAL)
                }
            }
        },
    )
}

@Composable
fun DialogText(
    modifier: Modifier = Modifier,
    content: String,
    fontSize: TextUnit,
    color: Color = White,
    lineHeight: TextUnit = TextUnit.Unspecified,
    fontWeight: FontWeight = FontWeight.Normal,
    textAlign: TextAlign = TextAlign.Start,
    textDecoration: TextDecoration = TextDecoration.None,
) {
    Text(
        text = content,
        modifier = modifier,
        style = TextStyle(
            fontFamily = spaceGrotesk,
            fontWeight = fontWeight,
            fontSize = fontSize,
            color = color,
            textAlign = textAlign,
            textDecoration = textDecoration,
        ),
        lineHeight = lineHeight,
        overflow = TextOverflow.Ellipsis,
    )
}

@Composable
fun CustomText(
    modifier: Modifier = Modifier,
    content: String,
    style: TextStyle,
    color: Color = White,
    textAlign: TextAlign = TextAlign.Start
) {
    Text(
        text = content,
        modifier = modifier,
        style = style,
        color = color,
        textAlign = textAlign
    )
}

@Composable
fun SemiBoldText(
    modifier: Modifier = Modifier,
    content: String,
    fontSize: TextUnit,
    color: Color = White,
    maxLines: Int = 100,
    fontWeight: FontWeight = FontWeight.SemiBold,
    textAlign: TextAlign = TextAlign.Start,
    fontFamily: FontFamily = spaceGrotesk,
    shadow: Shadow? = null
) {
    Text(
        text = content,
        modifier = modifier,
        style = TextStyle(
            fontFamily = fontFamily,
            fontWeight = fontWeight,
            fontSize = fontSize,
            color = color,
            textAlign = textAlign,
            shadow = shadow
        ),
        maxLines = maxLines
    )
}

@Composable
fun BoldText(
    modifier: Modifier = Modifier,
    content: String,
    fontSize: TextUnit,
    color: Color = White,
    textAlign: TextAlign = TextAlign.Start,
    maxLines: Int = 2,
    shadow: Shadow? = null,
    allowScale: Boolean = true,
) {
    var textSize by remember { mutableStateOf(fontSize) }

    Text(
        text = content,
        modifier = modifier,
        style = TextStyle(
            fontFamily = spaceGrotesk,
            fontWeight = FontWeight.Bold,
            fontSize = textSize,
            color = color,
            shadow = shadow
        ),
        textAlign = textAlign,
        maxLines = maxLines,
        overflow = TextOverflow.Ellipsis,
        onTextLayout = { textLayoutResult ->
            if (allowScale) {
                val maxCurrentLineIndex: Int = textLayoutResult.lineCount - 1

                if (textLayoutResult.isLineEllipsized(maxCurrentLineIndex)) {
                    textSize = textSize.times(TEXT_SCALE_REDUCTION_INTERVAL)
                }
            }
        },
    )
}

private const val TEXT_SCALE_REDUCTION_INTERVAL = 0.9f
