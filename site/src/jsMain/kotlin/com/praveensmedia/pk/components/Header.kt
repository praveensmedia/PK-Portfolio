package com.praveensmedia.pk.components

import androidx.compose.runtime.Composable
import com.praveensmedia.pk.models.Section
import com.praveensmedia.pk.models.Theme
import com.praveensmedia.pk.styles.NavigationItemStyle
import com.praveensmedia.pk.utils.Constants.FONT_FAMILY
import com.praveensmedia.pk.utils.Constants.SECTION_WIDTH
import com.praveensmedia.pk.utils.MyMaxWidth
import com.praveensmedia.pk.utils.ProfileConst
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.components.icons.fa.FaBars
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.background
import org.jetbrains.compose.web.css.px

@Composable
fun Header(
    onMenuClicked : () -> Unit,
    breakpoint:Breakpoint,
    modifier: Modifier = Modifier,
) {
    Box (
        modifier = modifier
            .fillMaxWidth()
            .maxWidth(SECTION_WIDTH.px)
            .padding(topBottom = if(breakpoint <= Breakpoint.SM)0.px else 10.px),
        contentAlignment = Alignment.Center
    ){
        Row (
            modifier = Modifier
                .fillMaxWidth(MyMaxWidth(breakpoint))
                .border(
                    width = if(breakpoint <= Breakpoint.SM)0.px else 2.px,
                    style = LineStyle.Solid,
                    color = Theme.LightGray.rgb
                )
                .borderRadius(if(breakpoint <= Breakpoint.SM)0.px else 10.px)
                .padding(leftRight = 15.px)
                .styleModifier {
                    background("linear-gradient(to right, ${Colors.AliceBlue}, ${Colors.AliceBlue})")
                }
                .height(50.px)
            ,
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically

        ){
            LeftSide(
                breakpoint = breakpoint,
                onMenuClicked = onMenuClicked,
            )
            if (breakpoint > Breakpoint.MD){
                RightSide()
            }
        }
    }
}

@Composable
private fun LeftSide(
    breakpoint: Breakpoint,
    onMenuClicked : () -> Unit,
) {
    Row(
        modifier = Modifier
            .height(50.px)
            .margin(right = 20.px),
        verticalAlignment = Alignment.CenterVertically,
    ){
        if (breakpoint<=Breakpoint.MD){
            FaBars(
                modifier = Modifier
                    .margin(right = 15.px)
                    .onClick {
                        onMenuClicked()
                    },
                size = IconSize.XL,
            )
        }

        Link(
            modifier = Modifier
                .fontFamily(FONT_FAMILY)
                .fontSize(26.px)
                .styleModifier {
                    background("linear-gradient(to right,${Theme.MyBlack.rgb}, ${Theme.Primary.rgb})")
                    property("-webkit-background-clip", "text")
                    property("-webkit-text-fill-color", "transparent")
                }
                .fontWeight(FontWeight.Bold)
                .textDecorationLine(TextDecorationLine.None),
            path = "",
            text = ProfileConst.pkHeaderName
        )
    }
}

@Composable
private fun RightSide() {
    Row (
        modifier = Modifier
            .fillMaxHeight(),
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically
    ){
        Section.values().take(6).forEach { section->
            Link(
                modifier = NavigationItemStyle.toModifier()
                    .margin(right = if(section.ordinal != 5)25.px else 0.px)
                    .padding(all = 5.px)
                    .fontFamily(FONT_FAMILY)
                    .fontWeight(FontWeight.Bold)
                    .textDecorationLine(TextDecorationLine.None),
                path = section.path,
                text = section.title
            )
        }
    }
}