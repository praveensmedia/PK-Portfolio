package com.praveensmedia.pk.components

import androidx.compose.runtime.*
import com.praveensmedia.pk.models.Section
import com.praveensmedia.pk.models.Theme
import com.praveensmedia.pk.styles.NavigationItemStyle
import com.praveensmedia.pk.styles.SkillCardStyle
import com.praveensmedia.pk.utils.Constants.FONT_FAMILY
import com.praveensmedia.pk.utils.ProfileConst
import com.praveensmedia.pk.utils.Res.Images.profile_img
import com.varabyte.kobweb.compose.css.*
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color.Companion.argb
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.navigation.OpenLinkStrategy
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.icons.fa.FaXmark
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jetbrains.compose.web.css.*

@Composable
fun OverFlowMenu(
    onMenuClosed: () -> Unit
) {
    val scope = rememberCoroutineScope()
    val breakpoint by rememberBreakpoint()
    var translateX by remember { mutableStateOf((-100).percent) }
    var opacity by remember { mutableStateOf(0.percent) }

    LaunchedEffect(breakpoint) {
        translateX = 0.percent
        opacity = 100.percent
        if (breakpoint > Breakpoint.MD) {
            scope.launch {
                translateX = (-100).percent
                opacity = 0.percent
                delay(500)
                onMenuClosed()
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.vh)
            .position(Position.Fixed)
            .zIndex(2)
            .opacity(opacity)
            .onClick {
                scope.launch {
                    translateX = (-100).percent
                    opacity = 0.percent
                    delay(500)
                    onMenuClosed()
                }
            }
            .backgroundColor(argb(a = 0.5f, r = 0.0f, g = 0.0f, b = 0.0f))
            .transition(CSSTransition(property = "opacity", duration = 500.ms))
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(leftRight = 15.px, topBottom = 0.px)
                .width(if (breakpoint > Breakpoint.SM) 320.px else 220.px)
                .overflow(Overflow.Auto)
                .scrollBehavior(ScrollBehavior.Smooth)
                .backgroundColor(Colors.White)
                .translateX(tx = translateX)
                .transition(CSSTransition(property = "translation", duration = 500.ms)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.px)
                    .margin(bottom = 25.px),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Link(
                    modifier = Modifier
                        //.padding(right = 30.px)
                        .fontFamily(FONT_FAMILY)
                        //.color(Theme.MyBlack.rgb)
                        .fontSize(if (breakpoint > Breakpoint.SM) 26.px else 20.px)
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
                FaXmark(
                    modifier = Modifier
                        .cursor(Cursor.Pointer)
                        .margin(all = 5.px)
                        .onClick {
                            scope.launch {
                                translateX = (-100).percent
                                opacity = 0.percent
                                delay(500)
                                onMenuClosed()
                            }
                        },
                    size = if (breakpoint > Breakpoint.SM) IconSize.XXL else IconSize.XL
                )
            }
            Image(
                src = profile_img,
                modifier = Modifier
                    .size(150.px)
                    .margin(bottom = 25.px)
                    .borderRadius(75.px)

            )

            Section.values().forEach { section ->
                Box(
                    modifier = SkillCardStyle.toModifier()
                        .backgroundColor(Colors.AliceBlue)
                        .borderRadius(25.px)
                        .margin(bottom = 10.px)
                        .width(150.px)
                        .height(40.px),
                    contentAlignment = Alignment.Center,

                    ) {
                    Link(
                        modifier = NavigationItemStyle.toModifier()
                            .fontFamily(FONT_FAMILY)
                            .fontSize(16.px)
                            .margin(all = 0.px)
                            .fontWeight(FontWeight.Normal)
                            .textDecorationLine(TextDecorationLine.None)
                            .onClick {
                                scope.launch {
                                    translateX = (-100).percent
                                    opacity = 0.percent
                                    delay(500)
                                    onMenuClosed()
                                }
                            },
                        path = section.path,
                        text = section.title,
                        openInternalLinksStrategy = OpenLinkStrategy.IN_PLACE
                    )
                }
            }
        }
    }
}