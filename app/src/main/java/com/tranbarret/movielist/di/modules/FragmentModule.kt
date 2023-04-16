package com.tranbarret.movielist.di.modules

import dagger.Module

@Module
class FragmentModule {

}

@PerFragment
interface FragmentComponent {
}

annotation class PerFragment
