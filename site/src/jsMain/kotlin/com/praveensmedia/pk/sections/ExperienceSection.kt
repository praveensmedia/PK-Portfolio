package com.praveensmedia.pk.sections

import androidx.compose.runtime.*
import com.praveensmedia.pk.components.ExperienceCard
import com.praveensmedia.pk.components.SectionTitle
import com.praveensmedia.pk.models.Experience
import com.praveensmedia.pk.models.Section
import com.praveensmedia.pk.utils.Constants.SECTION_WIDTH
import com.praveensmedia.pk.utils.MyMaxWidth
import com.praveensmedia.pk.utils.ObserveViewportEntered
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import org.jetbrains.compose.web.css.px

@Composable
fun ExperienceSection(
    breakpoint:Breakpoint
) {
    Box (
        modifier = Modifier
            .id(Section.Experience.id)
            .fillMaxWidth()
            .maxWidth(SECTION_WIDTH.px)
            .margin(top = if (breakpoint>Breakpoint.MD)0.px else 20.px)
            .padding(top = if (breakpoint >=Breakpoint.MD)60.px else 50.px),
        contentAlignment = Alignment.Center
    ){
        ExperienceContent(breakpoint)
    }
}

@Composable
private fun ExperienceContent(breakpoint: Breakpoint) {

    var animatedMargin by remember { mutableStateOf(200.px) }
    ObserveViewportEntered(
        selectionId = Section.Experience.id,
        distanceFromTop = 500.0,
        onViewPortEntered = {
            animatedMargin = 50.px
        }
    )
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxWidth(MyMaxWidth(breakpoint))
            .padding(leftRight = if (breakpoint >=Breakpoint.MD)25.px else 10.px),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        SectionTitle(
            section = Section.Experience,
        )
        Experience.values().forEach {experience ->
            ExperienceCard(
                breakpoint = breakpoint,
                active = experience == Experience.First,
                experience = experience,
                animatedMargin = animatedMargin
            )
        }
    }
}