package com.praveensmedia.pk.components

import androidx.compose.runtime.Composable
import com.praveensmedia.pk.models.Project
import com.praveensmedia.pk.models.Theme
import com.praveensmedia.pk.styles.NavigationItemStyle
import com.praveensmedia.pk.styles.SocialLinkStyle
import com.praveensmedia.pk.styles.iconStyle
import com.praveensmedia.pk.utils.Constants
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.navigation.OpenLinkStrategy
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.icons.fa.*
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun ProjectCard(
    project: Project,
    onButtonsClicked: (isRight:Boolean)->Unit,
    breakpoint: Breakpoint,
) {
    Column (
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        if (breakpoint < Breakpoint.MD){
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .margin(topBottom = 10.px)
                    .objectFit(ObjectFit.Contain)
                    .height(300.px),
                src = project.image,
                desc = "project illustration image"
            )
        }
        Row  (
            modifier = Modifier
                .fillMaxWidth()
                .padding(topBottom = if (breakpoint > Breakpoint.SM) 25.px else 0.px),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ){
            if (breakpoint > Breakpoint.SM){
                Box (
                    modifier = Modifier
                        .fillMaxWidth(50.percent)
                        .height(350.px),
                    contentAlignment = Alignment.Center
                ){
                    Image(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(350.px)
                            .objectFit(ObjectFit.Contain)
                        ,
                        src = project.image,
                        desc = "project illustration image"
                    )
                }
            }

            Column (
                modifier = Modifier
                    .fillMaxWidth(50.percent)
                    .padding(leftRight = 20.px)
                    //.fillMaxWidth()
                    .thenIf(
                        breakpoint <= Breakpoint.SM,
                        Modifier
                            .fillMaxWidth(100.percent)
                            .padding(all = 0.px)
                            .height(200.px)
                    )

            ){
                Row (
                    modifier = Modifier
                        .fillMaxWidth(),
                    //horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    P (
                        attrs = Modifier
                            .margin(all = 0.px)
                            .fontSize(22.px)
                            .fontWeight(FontWeight.Bold)
                            .color(Theme.Primary.rgb)
                            .toAttrs()
                    ){
                        Text(project.title)
                    }
                    if (project.link.isNotEmpty()){
                        Link(
                            path = project.link,
                            openExternalLinksStrategy = OpenLinkStrategy.IN_NEW_TAB
                        ){
                            FaLink(
                                modifier = SocialLinkStyle
                                    .toModifier()
                                    .margin(
                                        leftRight = 20.px
                                    ),
                                size = IconSize.XL,
                            )
                        }
                    }
                }

                P (
                    attrs = Modifier
                        .margin(all = 0.px)
                        .fontSize(14.px)
                        .toAttrs()
                ){
                    Text(project.desc)
                }
            }
        }
        Row (
            modifier = Modifier
                .padding(all = 10.px)
                .margin(topBottom = 15.px)
                .minWidth(150.px),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            FaArrowLeft(
                modifier = iconStyle.toModifier()
                    .onClick {
                        onButtonsClicked(false)
                    },
                size = IconSize.XXL
            )
            FaArrowRight(
                modifier = iconStyle.toModifier()
                    .onClick {
                        onButtonsClicked(true)
                    },
                size = IconSize.XXL
            )
        }
    }
}