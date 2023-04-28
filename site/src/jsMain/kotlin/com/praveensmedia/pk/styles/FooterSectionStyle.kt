package com.praveensmedia.pk.styles

import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.silk.components.style.addVariantBase
import com.varabyte.kobweb.silk.components.text.SpanTextStyle
import com.varabyte.kobweb.silk.theme.toSilkPalette

val MutedSpanTextVariant by SpanTextStyle.addVariantBase {
    Modifier.color(colorMode.toSilkPalette().color.toRgb().copyf(alpha = 0.7f))
}