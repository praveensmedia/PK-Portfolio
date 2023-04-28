package com.praveensmedia.pk.sections

import androidx.compose.runtime.Composable
import com.praveensmedia.pk.models.Section
import com.praveensmedia.pk.models.Theme
import com.praveensmedia.pk.styles.MutedSpanTextVariant
import com.praveensmedia.pk.styles.NavigationItemStyle
import com.praveensmedia.pk.utils.Constants.FONT_FAMILY
import com.praveensmedia.pk.utils.Constants.SECTION_WIDTH
import com.praveensmedia.pk.utils.Socials.ossLink
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.icons.fa.FaGithub
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.components.text.SpanText
import org.jetbrains.compose.web.css.FlexWrap
import org.jetbrains.compose.web.css.em
import org.jetbrains.compose.web.css.px

@Composable
fun FooterSection(
    breakpoint: Breakpoint
) {
    Box (
        modifier = Modifier
            .fillMaxWidth()
            .margin(top = 25.px)
            .padding(bottom = 25.px)
            .backgroundColor(Theme.LighterGray.rgb),
        contentAlignment = Alignment.Center
    ){
        FooterContent(
            breakpoint = breakpoint
        )
    }
}

@Composable
private fun FooterContent(
    breakpoint: Breakpoint,
) {
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .maxWidth(SECTION_WIDTH.px),
        horizontalAlignment = Alignment.CenterHorizontally
    ){


        if (breakpoint > Breakpoint.SM){
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .margin(top = 15.px),
                horizontalArrangement = Arrangement.Center
            ){
                FooterMenu(isRow = true)
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .margin(top = 15.px),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .margin(topBottom = 5.px)
                    .flexWrap(FlexWrap.Wrap),
                verticalAlignment = Alignment.CenterVertically
            ) {
                FaGithub(Modifier.margin(right = 8.px))
                SpanText("This site is ")
                Link (ossLink, "open source")
            }
            SpanText(
                "Copyright © Praveensmedia Labs 2023. All rights reserved.",
                Modifier
                    .fontSize(0.75.em)
                    .textAlign(TextAlign.Center),
                MutedSpanTextVariant
            )
        }
    }
}

@Composable
private fun FooterMenu(isRow : Boolean) {
    Section.values().forEach { section ->
        Link(
            modifier = NavigationItemStyle
                .toModifier()
                .fontFamily(FONT_FAMILY)
                .padding(
                    right = if (isRow)20.px else 0.px,
                    bottom = if (isRow)0.px else 20.px
                )
                .color(Theme.MyBlack.rgb)
                .fontWeight(FontWeight.Normal)
                .textDecorationLine(TextDecorationLine.None),
            path = section.path,
            text = section.title
        )
    }
}
