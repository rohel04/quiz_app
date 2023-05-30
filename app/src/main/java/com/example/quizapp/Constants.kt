package com.example.quizapp

object Constants {
    fun getQuestions():ArrayList<Question>{
        val questionList=ArrayList<Question>()


        questionList.add(Question(id = 1, question = "What country does this flag belongs to?", optionOne = "Nepal", optionTwo = "India", optionThree = "China", optionFour = "Sri-Lanka", image = R.drawable.ic_nepal, correctAnswer = 1))
        questionList.add(Question(id = 2, question = "What country does this flag belongs to?", optionOne = "Nepal", optionTwo = "India", optionThree = "China", optionFour = "Sri-Lanka", image = R.drawable.ic_india, correctAnswer = 2))
        questionList.add(Question(id = 3, question = "What country does this flag belongs to?", optionOne = "Nepal", optionTwo = "India", optionThree = "China", optionFour = "Sri-Lanka", image = R.drawable.ic_china, correctAnswer = 3))
        questionList.add(Question(id = 4, question = "What country does this flag belongs to?", optionOne = "Brazil", optionTwo = "Argentina", optionThree = "Mexico", optionFour = "Thailand", image = R.drawable.ic_argentina, correctAnswer = 2))
        questionList.add(Question(id = 5, question = "What country does this flag belongs to?", optionOne = "Russia", optionTwo = "Japan", optionThree = "USA", optionFour = "Egypt", image = R.drawable.ic_egypt, correctAnswer = 4))
        questionList.add(Question(id = 6, question = "What country does this flag belongs to?", optionOne = "Portugal", optionTwo = "Pakistan", optionThree = "France", optionFour = "England", image = R.drawable.ic_france, correctAnswer = 3))
        questionList.add(Question(id = 7, question = "What country does this flag belongs to?", optionOne = "South Africa", optionTwo = "Ghana", optionThree = "Maldives", optionFour = "Italy", image = R.drawable.ic_ghana, correctAnswer = 2))
        questionList.add(Question(id = 8, question = "What country does this flag belongs to?", optionOne = "Kuwait", optionTwo = "Canada", optionThree = "Germany", optionFour = "Palestine", image = R.drawable.ic_kuwait, correctAnswer = 1))
        questionList.add(Question(id = 9, question = "What country does this flag belongs to?", optionOne = "Switzerland", optionTwo = "Slovakia", optionThree = "Somalia", optionFour = "France", image = R.drawable.ic_slovakia, correctAnswer = 2))
        questionList.add(Question(id = 10, question = "What country does this flag belongs to?", optionOne = "Palestine", optionTwo = "Morocco", optionThree = "China", optionFour = "Sri-Lanka", image = R.drawable.ic_palestine, correctAnswer = 1))

        return questionList

    }
}