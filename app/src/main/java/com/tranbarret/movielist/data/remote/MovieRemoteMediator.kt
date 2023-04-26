package com.tranbarret.movielist.data.remote

//@OptIn(ExperimentalPagingApi::class)
class MovieRemoteMediator {

}
// @Inject constructor(
//    private val movieDatabase: MovieDatabase,
//    private val movieApi: MovieApi
//) : RemoteMediator<Int, MovieEntity>() {
//    override suspend fun load(
//        loadType: LoadType,
//        state: PagingState<Int, MovieEntity>
//    ): MediatorResult {
//        return try {
//            val loadKey = when(loadType) {
//                LoadType.REFRESH -> 1
//                LoadType.PREPEND -> return MediatorResult.Success(
//                    endOfPaginationReached = true
//                )
//                LoadType.APPEND -> {
//                    val lastItem = state.lastItemOrNull()
//                    if (lastItem == null) {
//                        1
//                    } else {
//                        (lastItem.id / state.config.pageSize) + 1
//                    }
//                }
//            }
//
//            val movies = movieApi.getPopularMovies(
//                page = loadKey
//            )
//
//            movieDatabase.withTransaction {
//                if (loadType == LoadType.REFRESH) {
//                    movieDatabase.movieDao.clearAll()
//                }
//                val movieEntities = movies.results.map {
//                    it.toEntity()
//                }
//                movieDatabase.movieDao.upsertAll(movieEntities)
//            }
//
//            movies.results.let {
//                MediatorResult.Success(
//                    endOfPaginationReached = it.isEmpty()
//                )
//            }
//
//            MediatorResult.Success(
//                endOfPaginationReached = movies.results.isEmpty()
//            )
//        } catch (e: IOException) {
//            MediatorResult.Error(e)
//        } catch (e : HttpException) {
//            MediatorResult.Error(e)
//        }
//    }


//    override fun loadSingle(
//        loadType: LoadType,
//        state: PagingState<Int, MovieEntity>
//    ): Single<MediatorResult> {
//        val position = params.key ?: 1
//
//        return service.popularMovieRx(apiKey, position, locale.language)
//            .subscribeOn(Schedulers.io())
//            .map { mapper.transform(it, locale) }
//            .map { toLoadResult(it, position) }
//            .onErrorReturn { LoadResult.Error(it) }
//    }
//}