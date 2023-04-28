package com.praveensmedia.pk.sections

import androidx.compose.runtime.Composable
import com.praveensmedia.pk.models.Section
import com.praveensmedia.pk.models.Theme
import com.praveensmedia.pk.utils.Constants.FONT_FAMILY
import com.praveensmedia.pk.utils.Constants.SECTION_WIDTH
import com.praveensmedia.pk.utils.MyMaxWidth
import com.praveensmedia.pk.utils.ProfileConst
import com.praveensmedia.pk.utils.Res
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import org.jetbrains.compose.web.css.background
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun IntroSection(
    breakpoint: Breakpoint,
){
    Box (
        modifier = Modifier
            .id(Section.Intro.id)
            .fillMaxWidth()
            .styleModifier {
                background("linear-gradient(to right, ${Colors.AliceBlue}, ${Colors.White}, ${Colors.AliceBlue})")
            },
        contentAlignment = Alignment.TopCenter
    ){
        Box (
            modifier = Modifier
                .fillMaxWidth()
                .maxWidth(SECTION_WIDTH.px)
                .padding(top = if (breakpoint >=Breakpoint.MD)60.px else 50.px, bottom = if (breakpoint >=Breakpoint.MD)25.px else 5.px),
            contentAlignment = Alignment.Center
        ){
            IntroContent(breakpoint = breakpoint)
        }
    }
}


@Composable
private fun IntroContent(breakpoint: Breakpoint) {
    Column (
        modifier = Modifier
            .fillMaxWidth(MyMaxWidth(breakpoint))
            .padding(
                top = if (breakpoint >=Breakpoint.MD)35.px else 0.px,
                leftRight = if (breakpoint >Breakpoint.MD)0.px else 10.px
            ),
        horizontalAlignment = if (breakpoint >=Breakpoint.MD)Alignment.CenterHorizontally else Alignment.Start
    ){
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(leftRight = if (breakpoint >=Breakpoint.MD)25.px else 10.px),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Column (
                modifier = Modifier.fillMaxWidth(60.percent),
                verticalArrangement = Arrangement.SpaceAround
            ){

                P (
                    attrs = Modifier
                        .fontFamily(FONT_FAMILY)
                        .fontWeight(FontWeight.Bold)
                        .color(Theme.Primary.rgb)
                        .fontSize(if (breakpoint >=Breakpoint.MD)26.px else 18.px)
                        //.lineHeight(if (breakpoint >=Breakpoint.MD)1 else 0.6)
                        .toAttrs()
                ){
                    Text("Hello, I'm")
                }
                P (
                    attrs = Modifier
                        .fontFamily(FONT_FAMILY)
                        .fontWeight(FontWeight.Bold)
                        .fontSize(if (breakpoint >=Breakpoint.MD)28.px else 20.px)
                        .styleModifier {
                            background("linear-gradient(to right,${Colors.BlueViolet}, ${Theme.Primary.rgb})")
                            property("-webkit-background-clip", "text")
                            property("-webkit-text-fill-color", "transparent")
                        }
                        .toAttrs()
                ){
                    Text(if (breakpoint>Breakpoint.MD)ProfileConst.pkFullName else ProfileConst.pkNormalName)
                }
                if (breakpoint >=Breakpoint.MD){
                    P (
                        attrs = Modifier
                            .fontFamily(FONT_FAMILY)
                            .fontWeight(FontWeight.Normal)
                            .fontSize(if (breakpoint >=Breakpoint.MD)18.px else 16.px)
                            .toAttrs()
                    ){
                        Text(ProfileConst.introDesc)
                    }
                }

            }
            Image(
                modifier = Modifier
                    //.size(if (breakpoint >=Breakpoint.MD)350.px else 200.px)
                    .fillMaxWidth(40.percent),
                src = Res.Images.phone_ui_ux
            )
        }
        if (breakpoint <=Breakpoint.SM){
            P (
                attrs = Modifier
                    .fillMaxWidth()
                    .padding(leftRight = if (breakpoint >=Breakpoint.MD)25.px else 10.px)
                    .fontFamily(FONT_FAMILY)
                    .fontWeight(FontWeight.Normal)
                    .fontSize(16.px)
                    .toAttrs()
            ){
                Text(ProfileConst.introDesc)
            }
        }
    }
}