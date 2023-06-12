package com.rifqi.androintermediate.customView

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.util.Patterns
import android.view.View
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.content.ContextCompat
import com.bangkit.riskque.R

class EmailForm : AppCompatEditText {

    private var isEmpty: Boolean = true
    private var isError: Boolean = false
    private var isEmailOk: Boolean = false

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context, attrs, defStyleAttr
    ) {
        init()
    }

    private fun init() {
        addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) = Unit

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (p0?.isNotEmpty() == true) {
                    isEmpty = false
                    isError = if (!Patterns.EMAIL_ADDRESS.matcher(p0).matches()) {
                        error = "Invalid email"
                        //set error message
                        true
                    } else {
                        false
                    }
                } else {
                    isEmpty = true
                }
                isEmailOk = !(isEmpty or isError)
            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })
    }

    fun isEmailOk(): Boolean {
        return isEmailOk
    }
}