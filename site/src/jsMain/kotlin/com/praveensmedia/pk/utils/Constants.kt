package com.praveensmedia.pk.utils

import com.praveensmedia.pk.models.SocialIconData

object ProfileConst{
    const val pkHeaderName = "PK Portfolio"
    const val pkNormalName = "Praveen Kumar"
    const val pkFullName   = "Praveen Kumar Boddupalli"
    const val introDesc = "I'm a full-stack developer with expertise in Kotlin, " +
            "I am committed to delivering high-quality solutions that meet the needs of my clients. " +
            "I specialize in developing robust Android Apps and web applications that are optimized for performance and scalability."
    const val techStackDesc = "With a deep understanding of both front-end and back-end development, " +
            "I am able to develop end-to-end solutions that seamlessly integrate across different platforms and technologies. " +
            "My experience in Kotlin allows me to develop applications that are efficient, reliable, and maintainable."

}

object Constants {
    const val SECTION_WIDTH = 1280
    const val FONT_FAMILY = "Roboto"

    const val MOBILE_LEAD_DEV_DESC =
        "As the lead developer for the ‘Sepal:Bike Infotainment App’, " +
            "I am dedicated to ensuring its complete development. " +
            "This involves collaborating with our UI/UX developers to bring the app to life with fully functional " +
            "and responsive features."
    const val ANDROID_DEV_DESC ="" +
            "During the early stages of our startup, " +
            "I took on multiple roles and responsibilities in order to bring our idea to life " +
            "and successfully deliver our product. From the initial idea stage, " +
            "I was involved in every aspect of the development process, including ideation, design, " +
            "development, testing, and delivery. As a result, " +
            "I gained a deep understanding of the product and was able to adapt quickly to changing requirements and priorities. " +
            "Through my dedication and willingness to take on new challenges, " +
            "I helped ensure the success of our startup and set a strong foundation for future growth."
    const val INTERN_DESC =
        "Involved in some projects for Safety & Security for Heavy Vehicles and doing R&D for those projects. " +
                "Dealing with different communication modules like BLE, GSM and GPS. Arduino programming for multiple Microcontrollers"

}

object Data{
    val libListAndroid = arrayOf(
        "MVVM Clean Code Architecture",
        "Dependency Injection (Hilt)",
        "Jetpack Compose Android",
        "Gson, kotlinx serialization ",
        "Google Maps and Location APIs",
        "Complete App Lifecycle",
        "Unit testing frameworks",
        "REST APIs with Ktor & Retrofit",
        "Push Notifications",
        "Compose Web with kobweb",
        "Proficient in using Git",
        "Finding & fixing Bugs"
    )
}

object Res{

    object Images {
        const val phone_ui_ux = "added/app_dev_small.png"
        const val programing_lan = "added/programing_lan.png"
        const val sepal_app = "tech/sepal_app.webp"
        const val train_app = "tech/train_app.png"
        const val lyk_app = "tech/lyk_water_app.jpg"
        const val this_app = "tech/this_app.png"
        const val profile_img = "tech/profile.jpeg"
    }
    object TechIcons{
        private const val android_studio = "tech/android-studio-icon.svg"
        private const val intellej_ide   = "tech/intellej_ide.png"
        private const val java_icon      = "tech/java_icon.png"
        private const val kotlin_icon    = "tech/kotlin_icon.svg"
        private const val ktor_icon      = "tech/ktor.svg"
        private const val compose_icon   = "tech/compose_small.png"

        val techIconList = arrayOf(
            android_studio,
            intellej_ide,
            java_icon,
            kotlin_icon,
            ktor_icon,
            compose_icon
        )
    }
}
object Socials{
    private const val github ="github"
    private const val twitter ="twitter"
    private const val linkedin ="linkedin"
    private const val instagram ="instagram"
    private const val whatsapp ="whatsapp"

    //Social Links
    private const val GITHUB_LINK = "https://github.com/praveensmedia"
    private const val TWITTER_LINK = "https://twitter.com/praveensMedia"
    private const val LINKEDIN_LINK = "https://www.linkedin.com/in/praveensmedia/"
    private const val INSTAGRAM_LINK = "https://www.instagram.com/praveensmedia/"
    private const val WHATSAPP_LINK = "https://wa.me/916281990945"

    val socialNames = arrayOf(
        SocialIconData(iconName = github, GITHUB_LINK),
        SocialIconData(iconName = twitter, TWITTER_LINK),
        SocialIconData(iconName = linkedin, LINKEDIN_LINK),
        SocialIconData(iconName = instagram, INSTAGRAM_LINK),
        SocialIconData(iconName = whatsapp, WHATSAPP_LINK)
    )

    const val ossLink = "https://github.com/praveensmedia/PK-Portfolio"
}
