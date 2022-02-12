package com.example.ownquizapp

object setQAndA{
    fun getQuestions(): ArrayList<questionAndAnswers> {
        val questionList = ArrayList<questionAndAnswers>()
        val q1 = questionAndAnswers(
            "Where is Canada located?",
            1,
            "Asia",
            "Africa",
            "Europe",
            "North America",
            "Australia",
            4
        )

        val q2 = questionAndAnswers(
            "The Canadian national anthem begins with...",
            2,
            "Oh Canada...",
            "God save the queen...",
            "Freedom...",
            "Maple leaf, eh...",
            "Home of the brave...",
            1
        )

        val q3 = questionAndAnswers(
            "Capital of Canada is...",
            3,
            "Toronto",
            "Ontario",
            "Ottawa",
            "Windsor",
            "Vancouver",
            3
        )

        val q4 = questionAndAnswers(
            "Biggest city is...",
            4,
            "Toronto",
            "Vancouver",
            "London",
            "Windsor",
            "Kingston",
            1
        )

        val q5 = questionAndAnswers(
            "Canada is famous for...",
            5,
            "Maple Leaf",
            "Cheese burgers",
            "Hot Dogs",
            "Pepsi",
            "Chocolates",
            1
        )
        questionList.add(q1)
        questionList.add(q2)
        questionList.add(q3)
        questionList.add(q4)
        questionList.add(q5)
        return questionList
    }
}