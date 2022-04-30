package com.app.presentation.activity.screen

import androidx.activity.viewModels
import com.app.presentation.viewmodel.AppViewModel

/**
 * this func is concise and reusable to Create VMs of Screens
 */
inline fun <reified vm : AppViewModel> AppScreen<vm>.createVM(): vm {
    val vm: vm by activity().viewModels()
    return vm
}