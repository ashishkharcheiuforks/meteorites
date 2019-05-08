package sk.mholecy.meteorites.common.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import dagger.android.support.DaggerFragment
import sk.mholecy.meteorites.common.di.ViewModelFactory
import javax.inject.Inject
import kotlin.reflect.KClass

open class BaseFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    fun <VM : ViewModel> getViewModel(viewModelClass: KClass<VM>): VM =
        ViewModelProviders.of(this, viewModelFactory)[viewModelClass.java]
}