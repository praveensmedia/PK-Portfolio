package com.praveensmedia.pk.styles

import com.praveensmedia.pk.models.Theme
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.hover
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.px

val SkillCardStyle by ComponentStyle {
    base {
        Modifier
            .border(
                width = 2.px,
                color = Theme.Gray.rgb,
                style = LineStyle.Solid
            )
            .transition(
                CSSTransition(property = "border", duration = 300.ms),
            )
    }
    hover {
        Modifier
            .border(
                width = 2.px,
                style = LineStyle.Solid,
                color = Theme.Primary.rgb
            )
    }
}