package com.praveensmedia.pk.models

import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.rgb

enum class Theme (
    val rgb: CSSColorValue
) {
    Primary(rgb = rgb(r = 0, g = 167, b = 142)),
    Secondary(rgb = rgb(r = 18, g = 29, b = 52)),
    Gray(rgb = rgb(r = 207, g = 207, b = 207)),
    LightGray(rgb = rgb(r = 237, g = 237, b = 237)),
    LighterGray(rgb = rgb(r = 249, g = 249, b = 249)),
    //Extra
    MyBlack(rgb = rgb(r = 52, g = 66, b = 87)),
}