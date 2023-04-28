package com.praveensmedia.pk.components

import androidx.compose.runtime.Composable
import com.praveensmedia.pk.styles.SocialLinkStyle
import com.praveensmedia.pk.utils.Res
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import org.jetbrains.compose.web.css.px

@Composable
fun TechStack(breakpoint: Breakpoint) {
    Row (
        modifier = Modifier
            .padding(leftRight = if(breakpoint>Breakpoint.SM)25.px else 10.px)
            .height(50.px)
            .borderRadius(r = if(breakpoint>Breakpoint.SM) 20.px else 15.px)
            .backgroundColor(Colors.AliceBlue),
        verticalAlignment = Alignment.CenterVertically,
    ){
        TechImages(breakpoint)
    }
}
@Composable
private fun TechImages(breakpoint: Breakpoint) {
    Res.TechIcons.techIconList.forEach {
        Image(
            modifier = SocialLinkStyle
                .toModifier()
                .size(if(breakpoint>Breakpoint.MD) 40.px else 30.px)
                .margin(
                    right = if (it !=Res.TechIcons.techIconList[(Res.TechIcons.techIconList.size-1)]){
                        if(breakpoint>Breakpoint.MD)40.px else 20.px
                    } else 0.px
                ),
            src = it
        )
    }
}