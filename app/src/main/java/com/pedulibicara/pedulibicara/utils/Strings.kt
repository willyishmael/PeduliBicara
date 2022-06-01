package com.pedulibicara.pedulibicara.utils

import androidx.annotation.StringRes

object Strings {
    fun get(@StringRes stringRes: Int, vararg formatArgs: Any = emptyArray()): String {
        return App.instance.getString(stringRes, *formatArgs)
    }
}