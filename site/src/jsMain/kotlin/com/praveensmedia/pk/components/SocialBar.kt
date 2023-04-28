package com.praveensmedia.pk.components

import androidx.compose.runtime.Composable
import com.praveensmedia.pk.models.Theme
import com.praveensmedia.pk.styles.SocialLinkStyle
import com.praveensmedia.pk.utils.Res
import com.praveensmedia.pk.utils.Socials
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.navigation.OpenLinkStrategy
import com.varabyte.kobweb.silk.components.icons.fa.*
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.style.toModifier
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.px

@Composable
fun SocialBar(
    modifier: Modifier = Modifier
) {
    Row (
        modifier = modifier
            .height(60.px)
            .border(
                width = 2.px,
                style = LineStyle.Dotted,
                color = Theme.Gray.rgb
            )
            .borderRadius(r = 20.px)
            .backgroundColor(Colors.White),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ){
        SocialLinks()
    }
}

@Composable
private fun SocialLinks() {
    Socials.socialNames.forEach {
        Link(
            path = it.url,
            openExternalLinksStrategy = OpenLinkStrategy.IN_NEW_TAB
        ){
            FaIcon(
                modifier = SocialLinkStyle
                    .toModifier()
                    .margin(
                    leftRight = 20.px
                ),
                size = IconSize.XXL,
                style = IconCategory.BRAND,
                name = it.iconName
            )
        }
    }
}