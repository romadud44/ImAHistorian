package com.example.imahistorian

class QuestionsAndAnswers {

    val questions = mapOf(
        1 to "В каком году был запущен Google?",
        2 to "Кто является царем олимпийских богов в греческой мифологии?",
        3 to "Какая планета была понижена до карликовой в 2006 году?",
        4 to "Где были проведены первые современные Олимпийские игры?",
        5 to "Какому навозному жуку поклонялись древние египтяне?"
    )

    val answers = mapOf(
        1_1 to "1999",
        1_2 to "1997",
        1_3 to "1998",
        2_1 to "Шрек",
        2_2 to "Зевс",
        2_3 to "Аид",
        3_1 to "Луна",
        3_2 to "Земля",
        3_3 to "Плутон",
        4_1 to "Афины",
        4_2 to "Москва",
        4_3 to "Нью-Йорк",
        5_1 to "Майский жук",
        5_2 to "Скарабей",
        5_3 to "Таракан"
    )

    val resultComment = listOf(
        "Очень плохо",
        "Плохо",
        "Не удовлетворительно",
        "Удовлетворительно",
        "Хорошо",
        "Отлично"
    )
    val resultInfo = listOf(
        "Вы вообще не Историк!",
        "Вы очень плохой Историк :(",
        "Вы плохой Историк.",
        "Вы такой себе Историк.",
        "Вы хороший Историк!",
        "Вы отличный Историк!"
    )


}