package com.sahansenvar.exzicasestudy

import androidx.navigation.NavHostController
import com.sahansenvar.core.common.constants.Properties
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Property
import org.koin.core.annotation.Single

@Module
@ComponentScan("com.sahansenvar.exzicasestudy")
class MainModule{

    @Single
    fun provideNavHostController(
        @Property(Properties.NAV_CONTROLLER)
        navHostController: NavHostController
    ) = navHostController
}