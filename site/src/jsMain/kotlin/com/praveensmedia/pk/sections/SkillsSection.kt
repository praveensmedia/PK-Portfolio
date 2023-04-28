package com.praveensmedia.pk.sections

import androidx.compose.runtime.Composable
import com.praveensmedia.pk.components.TechStack
import com.praveensmedia.pk.models.Section
import com.praveensmedia.pk.models.Theme
import com.praveensmedia.pk.styles.SkillCardStyle
import com.praveensmedia.pk.utils.Constants
import com.praveensmedia.pk.utils.Data
import com.praveensmedia.pk.utils.MyMaxWidth
import com.praveensmedia.pk.utils.ProfileConst.techStackDesc
import com.praveensmedia.pk.utils.Res
import com.varabyte.kobweb.compose.css.FontWeight
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
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import org.jetbrains.compose.web.css.background
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun SkillsSection(
    breakpoint: Breakpoint,
) {
    Box (
        modifier = Modifier
            .id(Section.Skills.id)
            .fillMaxWidth()
            .maxWidth(Constants.SECTION_WIDTH.px)
            .margin(top = if (breakpoint>Breakpoint.MD)0.px else 20.px)
            .padding(top = if (breakpoint >=Breakpoint.MD)60.px else 50.px,bottom = if (breakpoint >= Breakpoint.MD)25.px else 5.px),
        contentAlignment = Alignment.Center
    ){
        SkillContent(breakpoint = breakpoint)
    }
}

@Composable
private fun SkillContent(breakpoint: Breakpoint) {
    Column (
        modifier = Modifier
            .fillMaxWidth(MyMaxWidth(breakpoint))
            .padding(leftRight = if (breakpoint >=Breakpoint.MD)25.px else 10.px),
    ){
        Row (
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ){
            Column (
                modifier = SkillCardStyle.toModifier()
                    .id("skillsCard")
                    .fillMaxWidth(if (breakpoint >Breakpoint.MD)70.percent else 100.percent)
                    .borderRadius(r= if(breakpoint >Breakpoint.MD)20.px else 10.px)
                    .padding(leftRight = 20.px, topBottom = 20.px),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                P (
                    attrs = Modifier
                        .fontFamily(Constants.FONT_FAMILY)
                        .fontWeight(FontWeight.Bold)
                        .fontSize(if (breakpoint >=Breakpoint.MD)28.px else 20.px)
                        .styleModifier {
                            background("linear-gradient(to right,${Theme.MyBlack.rgb}, ${Theme.Primary.rgb})")
                            property("-webkit-background-clip", "text")
                            property("-webkit-text-fill-color", "transparent")
                        }
                        .toAttrs()
                ){
                    Text("My Tech Stack")
                }
                P (
                    attrs = Modifier
                        .fontFamily(Constants.FONT_FAMILY)
                        .fontWeight(FontWeight.Normal)
                        .fontSize(if (breakpoint >=Breakpoint.MD)18.px else 16.px)
                        .toAttrs()
                ){
                    Text(techStackDesc)
                }
                TechStack(breakpoint)
            }
            if (breakpoint >Breakpoint.MD){
                Image(
                    modifier = Modifier
                        .fillMaxWidth(30.percent),
                    src = Res.Images.programing_lan
                )
            }
        }

        Column (
            modifier = SkillCardStyle.toModifier()
                .fillMaxWidth()
                .margin(top = if(breakpoint <=Breakpoint.MD)15.px else 20.px)
                .borderRadius(r= if(breakpoint >Breakpoint.MD)20.px else 10.px)
                .padding(
                    leftRight = if(breakpoint >Breakpoint.MD)15.px else 5.px,
                    top = 20.px,
                    bottom = if(breakpoint >Breakpoint.MD)30.px else 20.px
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            P (
                attrs = Modifier
                    .fontFamily(Constants.FONT_FAMILY)
                    .fontWeight(FontWeight.Bold)
                    .fontSize(if (breakpoint >=Breakpoint.MD)28.px else 20.px)
                    .styleModifier {
                        background("linear-gradient(to right,${Theme.MyBlack.rgb}, ${Theme.Primary.rgb})")
                        property("-webkit-background-clip", "text")
                        property("-webkit-text-fill-color", "transparent")
                    }
                    .toAttrs()
            ){
                Text("Technologies I'm fluent in")
            }
            importantLibs(
                breakpoint = breakpoint,
                libData = Data.libListAndroid
            )
        }
    }
}

@Composable
private fun importantLibs(
    breakpoint: Breakpoint,
    libData:Array<String>
) {
    SimpleGrid(
        modifier = Modifier.fillMaxWidth(),
        numColumns = numColumns(base = 2, md=3),
    ){
        libData.forEach {
            Box (
                modifier = Modifier
                    .minHeight(50.px)
                    .margin(all = 5.px)
                    .padding(all=10.px)
                    .borderRadius(r = if(breakpoint>Breakpoint.SM) 20.px else 15.px)
                    .backgroundColor(Colors.AliceBlue),
                contentAlignment = Alignment.Center
            ){
                P(
                    attrs = Modifier
                        .fontSize(if (breakpoint>=Breakpoint.MD)18.px else 14.px)
                        .margin(all=0.px)
                        .styleModifier {
                            property("text-align","center")
                            property("vertical-align","middle")
                        }
                        .toAttrs()
                ){
                    Text(it)
                }
            }
        }
    }
}