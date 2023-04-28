package com.praveensmedia.pk.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.praveensmedia.pk.models.Section
import com.praveensmedia.pk.models.Theme
import com.praveensmedia.pk.utils.Constants
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.background
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun SectionTitle(section: Section) {
    val breakpoint by rememberBreakpoint()
    Column (
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.Start
    ){
        P (
            attrs = Modifier
                .fillMaxWidth()
                .margin(
                    top = 5.px,
                    leftRight = 0.px,
                    bottom = 0.px
                )
                .fontFamily(Constants.FONT_FAMILY)
                .fontSize(if (breakpoint >= Breakpoint.MD)20.px else 14.px)
                .fontWeight(FontWeight.Normal)
                .color(Theme.MyBlack.rgb)
                .toAttrs()
        ){ Text(section.title) }
        P (
            attrs = Modifier
                .margin(all = 0.px)
                .fontFamily(Constants.FONT_FAMILY)
                .fontWeight(FontWeight.Bold)
                .fontSize(if (breakpoint >=Breakpoint.MD)28.px else 24.px)
                .styleModifier {
                    background("linear-gradient(to right,${Colors.BlueViolet}, ${Theme.Primary.rgb})")
                    property("-webkit-background-clip", "text")
                    property("-webkit-text-fill-color", "transparent")
                }
                .toAttrs()
        ){ Text(section.subtitle) }

        Box (
            modifier = Modifier
                .height(2.px)
                .width(60.px)
                .styleModifier { background("linear-gradient(to right,${Theme.Primary.rgb}, ${Theme.MyBlack.rgb})") }
        ){

        }
    }
}