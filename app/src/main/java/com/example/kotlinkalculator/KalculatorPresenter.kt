package com.example.kotlinkalculator

class KalculatorPresenter:KalculatorContract.Presenter {

    private lateinit var mModel:KalculatorModel
    private lateinit var mView:KalculatorContract.View

    override fun setView(view: KalculatorContract.View) {
        mView = view
    }

    override fun start() {
        mModel = KalculatorModel()
    }

    //Handle key input from user
    override fun append(input: String) {
        when (input) {
            "AC" -> mModel.clearInput()
            "DEL" -> mModel.deleteLastInput()
            "=" -> mModel.doMath()
            "+/-"->mModel.changeSign()
            else -> mModel.appendToInput(input)
        }
        val currentInput = mModel.getCurrentInputAsString()
        val previousInput = mModel.getPreviousInputAsString()
        mView.displayResult(currentInput)
        mView.displayPrevious(previousInput)
    }


}