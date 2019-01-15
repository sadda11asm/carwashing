package com.example.carwashing.di

import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.example.carwashing.BuildConfig
import com.example.carwashing.common.NavigationController
import com.example.carwashing.ui.MainViewModel
import com.example.carwashing.ui.MapsActivity
import com.example.carwashing.ui.carwash.CarWashViewModel
import com.example.carwashing.util.AppExecutors
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.experimental.builder.viewModel
import org.koin.dsl.module.module
import org.koin.experimental.builder.single
import java.util.concurrent.TimeUnit


val appModule = module {
    single { PreferenceManager.getDefaultSharedPreferences(androidContext()) }
    single { AppExecutors() }
}

val authModule = module {
    // single instance of HelloRepository
//    single<AuthRepository>()
//    viewModel<LoginViewModel>()
}

val mainModule = module {
    scope("main") { (params: MapsActivity) -> NavigationController(params) }
    //scope("main") { get<Gson>().fromJson(get<SharedPreferences>().getString(User.PREF_USER, ""), User::class.java) }
//    single<ChecksRepository>()
//    single<DirectoriesRepository>()
//    single<TalonRepository>()
//    single<ActRepository>()
//    single<DocsRepository>()
//    single<RequisitesRepository>()
    viewModel<CarWashViewModel>()
    viewModel<MainViewModel>()
//    viewModel<ActViewModel>()
//    viewModel<TalonViewModel>()
//    viewModel<RequisitesViewModel>()
//    viewModel<SearchViewModel>()
}



//val getFactory = JsonAndXmlConverters.QualifiedTypeConverterFactory(
//    GsonConverterFactory.create(),
//    SimpleXmlConverterFactory.create()
//)

val networkingModule = module {
    single {
////        val clientBuilder = OkHttpClient.Builder()
////        val loggingInterceptor = HttpLoggingInterceptor()
//        if (BuildConfig.DEBUG)
//            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
//        clientBuilder
//            .addInterceptor(loggingInterceptor)
//            .connectTimeout(20, TimeUnit.SECONDS)
//            .writeTimeout(120, TimeUnit.SECONDS)
//            .readTimeout(120, TimeUnit.SECONDS)
//        clientBuilder.build()
    }

    single {
//        Retrofit.Builder()
//            .baseUrl(UrlProvider.prodUrl)
//            .client(get())
//            .addConverterFactory(GsonConverterFactory.create())
//            .addConverterFactory(getFactory)
//            .addCallAdapterFactory(LiveDataCallAdapterFactory())
//            .build()
//            .create(ApiService::class.java)
    }
}
