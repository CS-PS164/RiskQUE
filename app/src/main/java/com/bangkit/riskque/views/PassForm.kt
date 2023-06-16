package com.bangkit.riskque.views

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.os.Build
import android.text.Editable
import android.text.TextWatcher
import android.text.method.HideReturnsTransformationMethod
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.content.ContextCompat
import com.bangkit.riskque.R

class PassForm : AppCompatEditText {

    private var isError: Boolean = false
    private var isPassOk: Boolean = false

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
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                isError = if (p0?.length!! < 8) {
                    //error = "Character must grater than 8"
                    true
                } else {
                    false
                }
                isPassOk = !isError
            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })
    }

    fun isPassOk(): Boolean {
        return isPassOk
    }
}