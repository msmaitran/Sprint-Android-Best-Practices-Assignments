package com.lambdaschool.crashlyticsdemomtt

import com.crashlytics.android.Crashlytics

fun dropBreadcrumb(className: String, methodName: String, id: Long, generalData: String) {
    val breadcrumb = "$className - $methodName - $id - $generalData"
    Crashlytics.log(breadcrumb)
}