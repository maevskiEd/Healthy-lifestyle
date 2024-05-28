package com.sf.healthylifestyle.di.modules

import com.sf.healthylifestyle.domain.usecases.GetTokenByPhone
import com.sf.healthylifestyle.view.auth.AuthViewModel
import dagger.Module
import dagger.Provides

@Module
class AppModule() {
    @Provides
    fun provideAuthViewModelFactory(
        getTokenByPhone: GetTokenByPhone
    ) = AuthViewModel.Factory(
        getTokenByPhone = getTokenByPhone
    )

}
