package com.praveensmedia.pk.sections

import androidx.compose.runtime.Composable
import com.praveensmedia.pk.components.SectionTitle
import com.praveensmedia.pk.components.SocialBar
import com.praveensmedia.pk.models.Section
import com.praveensmedia.pk.utils.Constants
import com.praveensmedia.pk.utils.MyMaxWidth
import com.praveensmedia.pk.utils.Res
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import org.jetbrains.compose.web.css.px

@Composable
fun ContactSection(breakpoint: Breakpoint) {
    Box (
        modifier = Modifier
            .id(Section.Contact.id)
            .fillMaxWidth()
            .maxWidth(Constants.SECTION_WIDTH.px)
            .padding(top = if (breakpoint >=Breakpoint.MD)50.px else 10.px),
        contentAlignment = Alignment.Center
    ){
        ContactContent(breakpoint = breakpoint)
    }
}

@Composable
private fun ContactContent(breakpoint: Breakpoint) {

    Column (
        modifier = Modifier
            .fillMaxWidth(MyMaxWidth(breakpoint))
            .padding(leftRight = if (breakpoint >=Breakpoint.MD)25.px else 10.px),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        SectionTitle(
            section = Section.Contact,
        )
        Column  (
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            if (breakpoint >Breakpoint.MD){
                Image(
                    src = Res.Images.profile_img,
                    modifier = Modifier
                        .size(200.px)
                        .margin(topBottom = 20.px)
                        .borderRadius(100.px)

                )
            }
            SocialBar(
                modifier = Modifier
                    .margin(
                        topBottom = 20.px
                    )
            )
        }
    }
}