package com.lambdaschool.androidcrashreportingmtt

import com.crashlytics.android.Crashlytics

fun dropBreadcrumb(className: String, methodName: String, generalData: String) {
    val breadcrumb = "$className - $methodName - $generalData"
    Crashlytics.log(breadcrumb)
}