package com.praveensmedia.pk.pages

import androidx.compose.runtime.*
import com.praveensmedia.pk.components.Header
import com.praveensmedia.pk.components.OverFlowMenu
import com.praveensmedia.pk.sections.*
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.position
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.Position

@Page
@Composable
fun HomePage() {
    IndexContent()
}

@Composable
fun IndexContent() {
    var menuOpened by remember { mutableStateOf(false) }
    val breakpoint by rememberBreakpoint()
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        Header(
            modifier = Modifier
                .position(Position.Fixed),
            onMenuClicked = {
                menuOpened = true
            },
            breakpoint = breakpoint,
        )
        IntroSection(breakpoint = breakpoint)
        SkillsSection(breakpoint = breakpoint)
        ProjectsSection(breakpoint = breakpoint)
        ExperienceSection(breakpoint = breakpoint)
        ContactSection(breakpoint = breakpoint)
        FooterSection(breakpoint = breakpoint)
    }

    if (menuOpened){
        OverFlowMenu(
            onMenuClosed = {
                menuOpened = false
            }
        )
    }
}
