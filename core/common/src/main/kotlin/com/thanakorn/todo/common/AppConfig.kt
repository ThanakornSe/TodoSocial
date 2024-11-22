package com.thanakorn.todo.common

import com.thanakorn.todo.common.base.AppConfiguration

object AppConfig : AppConfiguration {
    override var isDebug: Boolean = false
    override var baseApiUrl: String? = null
}