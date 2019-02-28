package sk.mholecy.meteorites.meteorites.di

import org.koin.dsl.module
import sk.mholecy.meteorites.common.database.Database
import sk.mholecy.meteorites.meteorites.api.MeteoritesApiClient
import sk.mholecy.meteorites.meteorites.database.converter.MeteoritesConverter
import sk.mholecy.meteorites.meteorites.database.dao.MeteoritesDao
import sk.mholecy.meteorites.meteorites.service.MeteoritesDatabaseSyncService
import sk.mholecy.meteorites.meteorites.ui.list.adapter.MeteoriteDiffCallback
import sk.mholecy.meteorites.meteorites.ui.list.adapter.MeteoritesAdapter

internal val meteoritesModule = module {
    single {
        MeteoritesDatabaseSyncService(
            get<MeteoritesApiClient>(),
            get<MeteoritesDao>(),
            get<MeteoritesConverter>()
        )
    }
    single {
        get<Database>().meteoritesDao()
    }
    single {
        MeteoritesConverter()
    }
    single {
        MeteoritesAdapter(
            get<MeteoriteDiffCallback>()
        )
    }
    single {
        MeteoriteDiffCallback()
    }
}
