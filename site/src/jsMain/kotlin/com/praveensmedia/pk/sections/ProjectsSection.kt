package com.praveensmedia.pk.sections

import androidx.compose.runtime.*
import com.praveensmedia.pk.components.ProjectCard
import com.praveensmedia.pk.components.SectionTitle
import com.praveensmedia.pk.models.Project
import com.praveensmedia.pk.models.Section
import com.praveensmedia.pk.utils.Constants
import com.praveensmedia.pk.utils.MyMaxWidth
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import org.jetbrains.compose.web.css.background
import org.jetbrains.compose.web.css.px

@Composable
fun ProjectsSection(
    breakpoint: Breakpoint
) {
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
                .id(Section.Projects.id)
                .fillMaxWidth()
                .maxWidth(Constants.SECTION_WIDTH.px)
                .margin(top = if (breakpoint> Breakpoint.MD)0.px else 20.px)
                .padding(
                    top = if (breakpoint >= Breakpoint.MD)60.px else 50.px,
                    bottom = if (breakpoint >= Breakpoint.MD)25.px else 5.px
                ),
            contentAlignment = Alignment.Center
        ){
            ProjectsContent(breakpoint)
        }
    }

}

@Composable
fun ProjectsContent(breakpoint: Breakpoint) {
    var projectNum by remember { mutableStateOf(0) }
    var projectFea by remember { mutableStateOf(Project.SEPAL) }
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxWidth(MyMaxWidth(breakpoint))
            .padding(leftRight = if (breakpoint >=Breakpoint.MD)25.px else 10.px),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        SectionTitle(
            section = Section.Projects,
        )

        ProjectCard(
            project = projectFea,
            onButtonsClicked = {isRight->
                if (isRight){
                    projectNum++
                }else{
                    projectNum--
                }

                if (projectNum >= Project.values().size){
                    projectNum = 0
                }
                if (projectNum<0){
                    projectNum = Project.values().size-1
                }
                projectFea = Project.values()[projectNum]

            },
            breakpoint = breakpoint,
        )
    }
}
