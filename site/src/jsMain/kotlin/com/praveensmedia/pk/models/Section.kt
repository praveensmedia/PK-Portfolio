package com.praveensmedia.pk.models

enum class Section(
    val id: String,
    val title: String,
    val subtitle: String,
    val path: String
) {
    Intro(
        id = "intro",
        title = "Intro",
        subtitle = "Praveen Kumar Boddupalli personal portfolio website",
        path = "#intro"
    ),
    Skills(
        id = "skills",
        title = "My Skills",
        subtitle = "What tools i use to build apps",
        path = "#skills"
    ),
    Projects(
        id = "projects",
        title = "Projects",
        subtitle = "Featured Projects",
        path = "#projects"
    ),
    Experience(
        id = "experience",
        title = "Experience",
        subtitle = "What I did",
        path = "#experience"
    ),
    Contact(
        id = "contact",
        title = "Contact",
        subtitle = "Lets Talk...",
        path = "#contact"
    ),
}


