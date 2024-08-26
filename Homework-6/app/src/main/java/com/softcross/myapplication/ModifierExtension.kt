package com.softcross.myapplication

import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.graphicsLayer
import kotlin.math.absoluteValue


fun Modifier.scaleOnCenter(state: LazyListState, itemIndex: Int, scaleFactor: Float = 1.1f): Modifier {
    val centerOffset = state.layoutInfo.viewportEndOffset / 2
    val itemInfo = state.layoutInfo.visibleItemsInfo.find { it.index == itemIndex }
    val itemOffset = itemInfo?.offset ?: 0
    val itemSize = itemInfo?.size ?: 0
    val itemCenter = itemOffset + itemSize / 2
    val distanceFromCenter = (centerOffset - itemCenter).absoluteValue
    val scale = 0.9f + (scaleFactor - 1f) * (1f - (distanceFromCenter / centerOffset.toFloat()).coerceIn(0f, 1f))
    return this.graphicsLayer {
        scaleY = scale
        scaleX = scale
    }
}