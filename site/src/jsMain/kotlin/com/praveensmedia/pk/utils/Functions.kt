package com.praveensmedia.pk.utils

import androidx.compose.runtime.*
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import kotlinx.browser.document
import kotlinx.browser.window
import org.jetbrains.compose.web.css.CSSSizeValue
import org.jetbrains.compose.web.css.CSSUnit
import org.jetbrains.compose.web.css.percent
import org.w3c.dom.events.EventListener

@Composable
fun ObserveViewportEntered(
    selectionId : String,
    distanceFromTop: Double,
    onViewPortEntered : () -> Unit
) {
    var viewportEntered by remember { mutableStateOf(false) }

    val listener = remember {
        EventListener {
            val top = document.getElementById(selectionId)?.getBoundingClientRect()?.top
            if (top != null && top < distanceFromTop){
                viewportEntered = true
            }
        }
    }

    LaunchedEffect(viewportEntered){
        if (viewportEntered){
            onViewPortEntered()
            window.removeEventListener(type = "scroll", callback = listener)
        }else{
            window.addEventListener(type = "scroll", callback = listener)
        }
    }

}
@Composable
fun MyMaxWidth(breakpoint: Breakpoint): CSSSizeValue<CSSUnit.percent> {
    return if (breakpoint>= Breakpoint.MD)85.percent else 100.percent
}