package com.example.quizapp

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

class QuizQuestionActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var questionText:TextView
    lateinit var optionOne:TextView
    lateinit var optionTwo:TextView
    lateinit var optionThree:TextView
    lateinit var optionFour:TextView
    lateinit var image: ImageView
    lateinit var progressBar:ProgressBar
    lateinit var progressStatus:TextView
    lateinit var submitButton:Button

    private var mCurrentPosition:Int=1
    lateinit var mQuestionsList:ArrayList<Question>
    private var mSelectedOptionPosition:Int=0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)

        questionText=findViewById(R.id.question)
        optionOne=findViewById(R.id.option_one)
        optionTwo=findViewById(R.id.option_two)
        optionThree=findViewById(R.id.option_three)
        optionFour=findViewById(R.id.option_four)
        image=findViewById(R.id.image)
        progressBar=findViewById(R.id.progress_bar)
        progressStatus=findViewById(R.id.progress_status)
        mQuestionsList=Constants.getQuestions()
        submitButton=findViewById(R.id.submit)

        setQuestion()

        optionOne.setOnClickListener(this)
        optionTwo.setOnClickListener(this)
        optionThree.setOnClickListener(this)
        optionFour.setOnClickListener(this)

        submitButton.setOnClickListener(this)






    }

    private fun answerView(answer:Int,drawableView:Int){
        when(answer){
            1->{
                optionOne.background=ContextCompat.getDrawable(this,drawableView)
            }
            2->{
                optionTwo.background=ContextCompat.getDrawable(this,drawableView)
            }
            3->{
                optionThree.background=ContextCompat.getDrawable(this,drawableView)
            }
            4->{
                optionFour.background=ContextCompat.getDrawable(this,drawableView)
            }
        }
    }

    private fun setQuestion(){

        val question:Question = mQuestionsList[mCurrentPosition-1]
        defaultOptionView()
        if(mCurrentPosition==mQuestionsList.size){
            submitButton.text="Finish"
        }else{
            submitButton.text="Submit"
        }
        progressBar.progress=mCurrentPosition
        progressStatus.text="$mCurrentPosition / ${progressBar.max}"
        questionText.text=question.question
        optionOne.text=question.optionOne
        optionTwo.text=question.optionTwo
        optionThree.text=question.optionThree
        optionFour.text=question.optionFour
        image.setImageResource(question.image)
    }

    private fun defaultOptionView(){
        val options=ArrayList<TextView>()
        options.add(0,optionOne)
        options.add(1,optionTwo)
        options.add(2,optionThree)
        options.add(3,optionFour)

        for(option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface= Typeface.DEFAULT
            option.background=ContextCompat.getDrawable(this,R.drawable.default_option_border_bg)
        }

    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.option_one->{selectedOptionView(optionOne,1)}
            R.id.option_two->{selectedOptionView(optionTwo,2)}
            R.id.option_three->{selectedOptionView(optionThree,3)}
            R.id.option_four->{selectedOptionView(optionFour,4)}
            R.id.submit->{
                if(mSelectedOptionPosition==0){
                    mCurrentPosition++
                    when{mCurrentPosition<=mQuestionsList.size->{
                        setQuestion()
                    }else->{
                        Toast.makeText(this,"You have completed the quiz",Toast.LENGTH_SHORT).show()
                    }

                    }             }else{
                        val question=mQuestionsList[mCurrentPosition-1]
                    if(question.correctAnswer!=mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition,R.drawable.incorrect_option_bg)
                    }

                        answerView(question.correctAnswer,R.drawable.correct_option_bg)

                    if(mCurrentPosition == mQuestionsList.size){
                        submitButton.text="Finish"
                    }else{
                        submitButton.text="Go to next question"
                    }
                    mSelectedOptionPosition=0

                    }
            }
        }
    }

    private fun selectedOptionView(v:TextView,selectedOptionNum:Int){
        defaultOptionView()
        mSelectedOptionPosition=selectedOptionNum
        v.setTextColor(Color.parseColor("#363A43"))
        v.setTypeface(v.typeface,Typeface.BOLD)
        v.background=ContextCompat.getDrawable(this,R.drawable.selected_option_border_bg)
    }
}