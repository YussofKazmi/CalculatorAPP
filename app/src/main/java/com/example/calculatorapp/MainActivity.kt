/*
* This Program is the Implementation for the Calculator App's Logic
* It has various methods linked to the buttons in the xml file that display numbers in arithmetic format
* @author Yussof Kazmi
* @since 5/30
 */


package com.example.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.exp




class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
    }

    override fun onDestroy() {
        super.onDestroy()
        calcOutput.text = null
    }



    /*
    * This method is used to concatenate 0 to the Output of the calculator
    * @param View Object that correlates to clicking on the button linked to this method
    * @return Nothing
     */
    fun addZero(view: View) { calcOutput.append("0") }


    /*
    * This method is used to concatenate 1 to the Output of the calculator
    * @param View Object that correlates to clicking on the button linked to this method
    * @return Nothing
     */
    fun addOne(view: View) { calcOutput.append("1") }

    /*
    * This method is used to concatenate 2 to the Output of the calculator
    * @param View Object that correlates to clicking on the button linked to this method
    * @return Nothing
     */
    fun addTwo(view: View) { calcOutput.append("2") }

    /*
    * This method is used to concatenate 3 to the Output of the calculator
    * @param View Object that correlates to clicking on the button linked to this method
    * @return Nothing
     */
    fun addThree(view: View) { calcOutput.append("3") }

    /*
    * This method is used to concatenate 4 to the Output of the calculator
    * @param View Object that correlates to clicking on the button linked to this method
    * @return Nothing
     */
    fun addFour(view: View) { calcOutput.append("4") }

    /*
    * This method is used to concatenate 5 to the Output of the calculator
    * @param View Object that correlates to clicking on the button linked to this method
    * @return Nothing
     */
    fun addFive(view: View) { calcOutput.append("5") }

    /*
    * This method is used to concatenate 6 to the Output of the calculator
    * @param View Object that correlates to clicking on the button linked to this method
    * @return Nothing
     */
    fun addSix(view: View) { calcOutput.append("6") }

    /*
    * This method is used to concatenate 8 to the Output of the calculator
    * @param View Object that correlates to clicking on the button linked to this method
    * @return Nothing
     */
    fun addEight(view: View) { calcOutput.append("8") }

    /*
    * This method is used to concatenate 7 to the Output of the calculator
    * @param View Object that correlates to clicking on the button linked to this method
    * @return Nothing
     */
    fun addSeven(view: View) { calcOutput.append("7") }

    /*
    * This method is used to concatenate 9 to the Output of the calculator
    * @param View Object that correlates to clicking on the button linked to this method
    * @return Nothing
     */
    fun addNine(view: View) { calcOutput.append("9") }

    /*
    * This method is used to concatenate . to the Output of the calculator
    * specifically to indicate the number in question is given a decimal point
    * @param View Object that correlates to clicking on the button linked to this method
    * @return Nothing
     */
    fun period (view: View) {


        if (calcOutput.text[calcOutput.text.length - 1] == '.' ) { return }

        val count = calcOutput.text.count { Count: Char -> Count == '.'}

        if (count > 1) {return}

        calcOutput.append('.'.toString())
        return
        }

    /*
    * This method is used to concatenate +(addition) to the Output of the calculator
    * @param View Object that correlates to clicking on the button linked to this method
    * @return Nothing
     */
    fun Add(view: View) {
        if(calcOutput.text.indexOf("+") != -1 || calcOutput.text.indexOf("-") > 0 ||calcOutput.text.indexOf("*") != -1 || calcOutput.text.indexOf("/") != -1) {
            return
        }
        calcOutput.append("+")
    }

    /*
    * This method is used to concatenate a "-" sign for subtraction to the Output of the calculator
    * @param View Object that correlates to clicking on the button linked to this method
    * @return Nothing
     */
    fun Subtraction(view: View) {

        if (calcOutput.text.count { Count: Char -> Count == '-'} > 2) {
            return
        }

        if(calcOutput.text.indexOf("+") != -1 || calcOutput.text.indexOf("-") > 0 ||calcOutput.text.indexOf("*") != -1 || calcOutput.text.indexOf("/") != -1) {
            return
        }
        calcOutput.append("-")
    }

    /*
    * This method is used to concatenate * sign for indicating multiplication to the Output of the calculator
    * @param View Object that correlates to clicking on the button linked to this method
    * @return Nothing
     */
    fun Multiplication(view: View) {
        if(calcOutput.text.indexOf("+") != -1 || calcOutput.text.indexOf("-") > 0 ||calcOutput.text.indexOf("*") != -1 || calcOutput.text.indexOf("/") != -1) {
            return
        }
        calcOutput.append("*")
    }

    /*
    * This method is used to concatenate / sign indicating division to the Output of the calculator
    * @param View Object that correlates to clicking on the button linked to this method
    * @return Nothing
     */
    fun Division(view: View) {
        if(calcOutput.text.indexOf("+") != -1 || calcOutput.text.indexOf("-") > 0 ||calcOutput.text.indexOf("*") != -1 || calcOutput.text.indexOf("/") != -1) {
            return
        }
        calcOutput.append("/")
    }

    /*
    * This method is used to clear the Output of the calculator
    * @param View Object that correlates to clicking on the button linked to this method
    * @return Nothing
     */
    fun Clear(view: View) { calcOutput.text = "" }

    /*
    * This method is used to alter the string of the number by adding a (-) sign indicating negation
    * right to the beginning of that specific number to the Output of the calculator
    * @param View Object that correlates to clicking on the button linked to this method
    * @return Nothing
     */
    fun Negation(view: View) {

        if (calcOutput.text.count { Count: Char -> Count == '-'} > 2) {
            return
        }
        if(calcOutput.text == "" || (calcOutput.text[calcOutput.text.length - 1].toInt() in 42..45)) {
            calcOutput.append("-")
            return
        }
        var tempString: String = ""
        if(calcOutput.text.indexOf("+") == -1 || calcOutput.text.indexOf("-") == -1 ||calcOutput.text.indexOf("*") == -1 || calcOutput.text.indexOf("/") == -1) {
            tempString += ("-" + calcOutput.text)
            calcOutput.text = tempString
            return
        }

        return
    }

    /*
    * This method is used to concatenate 0 to the Output of the calculator
    * @param View Object that correlates to clicking on the button linked to this method
    * @return Nothing
     */
    fun statementParser(mathStatement: String): ArrayList<String> {

        val collection = arrayListOf<String>()
        var i: Int = 0
        var tempString: String = ""
        if (mathStatement[0] == '-') {
            i++
            tempString += '-'
        }
        while (mathStatement[i] != '+' && mathStatement[i] != '-' && mathStatement[i] != '*' && mathStatement[i] != '/' ) {

            tempString += mathStatement[i]
            i++
        }
        collection.add(tempString)
        tempString = ""
        collection.add(mathStatement[i].toString())
        i += 1

        while (i < mathStatement.length) {

            tempString+= mathStatement[i]
            i += 1
        }

        collection.add(tempString)

        return collection
    }

    /*
    * This method is used to arithmetically calculate the output of the current calculator Output and then
    * replace the current calculator output with the Output of the newly calculated expression in string format
    * @param View Object that correlates to clicking on the button linked to this method
    * @return Nothing
     */
    fun Equals(view: View) {


        val expression: String = calcOutput.text.toString()


        if (expression == "" ||( calcOutput.text.indexOf("+") == -1 && calcOutput.text.indexOf("-") == -1 && calcOutput.text.indexOf("*") == -1 && calcOutput.text.indexOf("/") == -1 )) {
            return
        }



        if (expression[expression.length - 1] == '+' || expression[expression.length - 1] == '-' || expression[expression.length - 1] == '/' || expression[expression.length - 1] == '*'  ) {
            return
        }
        val collection = statementParser(expression)

        when(collection[1].toString())
        {
            "+" -> collection.add((collection[0].toDouble() + collection[2].toDouble()).toString())
            "*" -> collection.add((collection[0].toDouble() * collection[2].toDouble()).toString())
            "-" -> collection.add((collection[0].toDouble() - collection[2].toDouble()).toString())
            "/" -> collection.add((collection[0].toDouble() / collection[2].toDouble()).toString())
        }

        calcOutput.text = collection[3]

        return
    }



}
